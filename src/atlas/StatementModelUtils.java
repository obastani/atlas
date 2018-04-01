// Copyright 2016-2018 Stanford University
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package atlas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import atlas.AliasModelUtils.AliasModel;
import atlas.AliasModelUtils.Node;
import atlas.AliasModelUtils.Trace;
import atlas.ObjectConstructorUtils.ConstructStatementConstructor;
import atlas.ReflectionTypeUtils.AtlasType;
import atlas.ReflectionTypeUtils.AtlasTypeBindings;
import atlas.ReflectionUtils.AtlasMethod;
import atlas.ReflectionUtils.Callable;
import atlas.Utils.Maybe;
import atlas.Utils.MultivalueMap;
import atlas.Utils.Pair;
import dk.brics.automaton.Automaton;
import dk.brics.automaton.BasicAutomata;
import dk.brics.automaton.State;
import dk.brics.automaton.Transition;

public class StatementModelUtils {
	public static class StatementModel {
		public final Maybe<Integer> source;
		public final Maybe<Integer> sink;
		public final Class<?> sourceType;
		public final Class<?> sinkType;
		public final Maybe<Integer> sourceField;
		public final Maybe<Integer> sinkField;
		public StatementModel(Maybe<Integer> source, Maybe<Integer> sink, Class<?> sourceType, Class<?> sinkType, Maybe<Integer> sourceField, Maybe<Integer> sinkField) {
			this.source = source;
			this.sink = sink;
			this.sourceType = sourceType;
			this.sinkType = sinkType;
			this.sourceField = sourceField;
			this.sinkField = sinkField;
		}
		@Override
		public String toString() {
			return (this.sink.hasT() ? "p" + this.sink.getT() : "r") + (this.sinkField.hasT() ? ".f" + this.sinkField.getT() : "") + " = " + (this.source.hasT() ? "p" + this.source.getT() : "r") + (this.sourceField.hasT() ? ".f" + this.sourceField.getT() : "");
		}
		@Override
		public int hashCode() {
			int hash = 1;
			hash = 31*hash + this.source.hashCode();
			hash = 31*hash + this.sink.hashCode();
			hash = 31*hash + this.sourceType.hashCode();
			hash = 31*hash + this.sinkType.hashCode();
			hash = 31*hash + this.sourceField.hashCode();
			hash = 31*hash + this.sinkField.hashCode();
			return hash;
		}
		@Override
		public boolean equals(Object obj) {
			StatementModel other = (StatementModel)obj;
			return this.source.equals(other.source)
					&& this.sink.equals(other.sink)
					&& this.sourceType.equals(other.sourceType)
					&& this.sinkType.equals(other.sinkType)
					&& this.sourceField.equals(other.sourceField)
					&& this.sinkField.equals(other.sinkField);
		}
	}
	
	private static enum StateType {
		START, EXTERNAL, INTERNAL, END;
	}
	
	private static class Symbol {
		private final Callable method; // concrete method
		private final Maybe<Integer> parameter;
		private final Class<?> klass;
		private final StateType type;
		private Symbol(Callable method, Maybe<Integer> parameter, Class<?> klass, StateType type) {
			this.method = method;
			this.parameter = parameter;
			this.klass = klass;
			this.type = type;
		}
		public int hashCode() {
			return 31*(31*(31*this.method.hashCode() + this.parameter.hashCode()) + this.klass.hashCode()) + this.type.hashCode();
		}
		public boolean equals(Object obj) {
			Symbol other = (Symbol)obj;
			return this.method.equals(other.method) && this.parameter.equals(other.parameter) && this.klass.equals(other.klass) && this.type.equals(other.type);
		}
		public String toString() {
			return "[" + this.method.toString() + ", " + this.parameter.toString() + ", " + this.klass.toString() + ", " + this.type.toString() + "]";
		}
	}
	
	private static Maybe<StateType> getStateType(State state, List<Symbol> symbols) {
		return state.getTransitions().isEmpty() ? new Maybe<StateType>() : new Maybe<StateType>(symbols.get(state.getTransitions().iterator().next().getMin()).type);
	}
	
	private static boolean isFieldStateType(Maybe<StateType> type) {
		return !type.hasT() || type.getT() == StateType.START || type.getT() == StateType.EXTERNAL;
	}
	
	private static void checkState(State state, List<Symbol> symbols) {
		Maybe<StateType> type = getStateType(state, symbols);
		for(Transition transition : state.getTransitions()) {
			// check next state
			Maybe<StateType> nextType = getStateType(transition.getDest(), symbols);
			if(!type.hasT()) {
				throw new RuntimeException();
			}
			if(isFieldStateType(type) == isFieldStateType(nextType)) {
				throw new RuntimeException();
			}
			if((type.getT() == StateType.END) == nextType.hasT()) {
				throw new RuntimeException();
			}
			// check consistency
			for(int i=transition.getMin(); i<=transition.getMax(); i++) {
				StateType curType = symbols.get(i).type;
				if(curType != type.getT()) {
					throw new RuntimeException();
				}
			}
		}
	}
	
	private static void checkAutomaton(Automaton aut, List<Symbol> symbols) {
		for(State state : aut.getStates()) {
			checkState(state, symbols);
		}
	}
	
	private static Map<State,String> getAccessors(Automaton aut) {
		// setup
		Set<State> acceptStates = aut.getAcceptStates();
		for(State state : aut.getStates()) {
			state.setAccept(false);
		}
		
		// get accessors
		Map<State,String> accessors = new HashMap<State,String>();
		for(State state : aut.getStates()) {
			state.setAccept(true);
			accessors.put(state, aut.getShortestExample(true));
			state.setAccept(false);
		}
		
		// cleanup
		for(State state : aut.getStates()) {
			state.setAccept(acceptStates.contains(state));
		}
		
		return accessors;
	}
	
	private static State run(Automaton aut, String str) {
		State cur = aut.getInitialState();
		for(int i=0; i<str.length(); i++) {
			cur = cur.step(str.charAt(i));
		}
		return cur;
	}
	
	private static Maybe<AliasModel> getUnspecializedModel(AliasModel model) {
		List<Node> nodes = new ArrayList<Node>();
		AtlasType curType = null;
		for(int i=0; i<model.getNumEdgePairs(); i++) {
			// get nodes
			Pair<Callable,Maybe<Integer>> external = model.getStartOrExternalTransition(i);
			Maybe<Integer> internal = model.getInternalTransitionOrEnd(i);
			
			// get method for current type
			Callable method = null;
			if(curType == null || external.getX().isStatic() || !external.getY().hasT() || external.getY().getT() != 0) {
				method = external.getX();
			} else {
				try {
					if(external.getX() instanceof AtlasMethod) {
						method = ((AtlasMethod)external.getX()).getVersionForClass(curType);
					} else {
						method = external.getX().getVersionForClass(curType.getBaseType());
					}
				} catch(Exception e) {
					return new Maybe<AliasModel>();
				}
			}
			
			// update current type
			if(!internal.hasT()) {
				if(method instanceof AtlasMethod) {
					curType = ReflectionTypeUtils.getAtlasType(((AtlasMethod)method).method.getGenericReturnType(), ((AtlasMethod)method).bindings);
				} else {
					curType = ReflectionTypeUtils.getAtlasType(method.getReturnType(), new AtlasTypeBindings());
				}
			} else if(!method.isStatic() && internal.getT() == 0) {
				curType = ReflectionTypeUtils.getAtlasType(method.getDeclaringClass(), new AtlasTypeBindings());
			} else {
				curType = null;
			}
			
			nodes.add(new Node(method, external.getY()));
			nodes.add(new Node(method, internal));
		}
		return new Maybe<AliasModel>(new AliasModel(nodes));
	}
	
	private static enum MergeOutcome {
		PASS, FAIL, FAIL_IF_DEFER, PASS_IF_DEFER
	}
	
	private static MergeOutcome tryMerge(Automaton aut, String s0, String s1, List<Symbol> symbols, int maxLength, Iterable<ConstructStatementConstructor> constructors, Iterable<Boolean> isNonNulls) {
		if(symbols.size() > Character.MAX_VALUE) {
			throw new RuntimeException();
		}
		
		// merge
		Automaton merge = aut.clone();
		
		// get states to be merged
		State q0 = run(merge, s0);
		State q1 = run(merge, s1);
		
		// merge states
		for(State q : merge.getStates()) {
			for(Transition transition : q.getTransitions()) {
				if(transition.getDest().equals(q0)) {
					q.addTransition(new Transition(transition.getMin(), transition.getMax(), q0));
				}
				if(transition.getDest().equals(q1)) {
					q.addTransition(new Transition(transition.getMin(), transition.getMax(), q1));
				}
			}
		}
		for(Transition transition : q0.getTransitions()) {
			q1.addTransition(new Transition(transition.getMin(), transition.getMax(), transition.getDest()));
		}
		for(Transition transition : q1.getTransitions()) {
			q0.addTransition(new Transition(transition.getMin(), transition.getMax(), transition.getDest()));
		}
		
		// difference
		merge = merge.minus(aut);
		merge.minimize();
		
		// reject if empty models (it implies the information needed to reject the merge is missing)
		if(merge.isEmpty()) {
			return MergeOutcome.FAIL;
		}
		
		// short strings
		List<String> strings = new ArrayList<String>();
		strings.add(merge.getShortestExample(true));
		
		// bounded strings
		Automaton single = BasicAutomata.makeCharRange((char)0, (char)(symbols.size()-1));
		Automaton bound = BasicAutomata.makeEmptyString();
		for(int i=0; i<maxLength; i++) {
			bound = bound.concatenate(single);
		}
		
		// bounded difference
		merge = merge.intersection(bound);
		merge.minimize();
		
		// finite strings
		if(!merge.isFinite()) {
			throw new RuntimeException();
		}
		strings.addAll(merge.getFiniteStrings());
		
		// get models and test
		List<AliasModel> models = new ArrayList<AliasModel>();
		for(String string : strings) {
			List<Node> nodes = new ArrayList<Node>();
			for(int i=0; i<string.length(); i++) {
				Symbol symbol = symbols.get((int)string.charAt(i));
				nodes.add(new Node(symbol.method, symbol.parameter));
			}
			AliasModel model = new AliasModel(nodes);
			Maybe<AliasModel> unspecializedModel = getUnspecializedModel(model);
			if(unspecializedModel.hasT()) {
				models.add(unspecializedModel.getT());
			}
		}
		
		// check models
		Log.info("NUM MODELS: " + models.size());
		boolean hasPassing = false;
		for(AliasModel model : models) {
			Log.info("MODEL: " + model.toString());
			if(TestSynthesisUtils.runAllTests(model, constructors, isNonNulls, Settings.DEFAULT_TIMEOUT)) {
				hasPassing = true;
				continue;
			}
			if(TestSynthesisUtils.runAllTestsForExceptions(model, constructors, isNonNulls, Settings.DEFAULT_TIMEOUT)) {
				continue;
			}
			Log.info("FAIL: " + model.toString());
			return MergeOutcome.FAIL;
		}
		
		if(hasPassing) {
			Log.info("ALL PASSED");
			return MergeOutcome.PASS;
		} else if(models.isEmpty()) {
			Log.info("DEFERRING (EMPTY)");
			return MergeOutcome.PASS_IF_DEFER;
		} else {
			Log.info("DEFERRING (EXCEPTIONS)");
			return MergeOutcome.PASS_IF_DEFER;
		}
	}
	
	private static Pair<Map<State,Maybe<Integer>>,Map<Maybe<Integer>,Class<?>>> buildFields(Automaton aut, List<Symbol> symbols) {
		Map<State,Maybe<Integer>> fields = new HashMap<State,Maybe<Integer>>();
		Map<Maybe<Integer>,Class<?>> fieldClasses = new HashMap<Maybe<Integer>,Class<?>>();
		int fieldCount = 0;
		for(State state : aut.getStates()) {
			// only handle field types
			Maybe<StateType> type = getStateType(state, symbols);
			if(!isFieldStateType(type)) {
				continue;
			}
			
			// field
			Maybe<Integer> field = !type.hasT() || type.getT() == StateType.START ? new Maybe<Integer>() : new Maybe<Integer>(fieldCount++);
			fields.put(state, field);
			
			// field class
			if(!field.hasT()) {
				continue;
			}
			Class<?> klass = symbols.get(state.getTransitions().iterator().next().getMin()).klass;
			fieldClasses.put(field, klass);
			
			// check to make sure field is only in one class
			for(Transition t : state.getTransitions()) {
				for(int i=t.getMin(); i<=t.getMax(); i++) {
					if(!symbols.get(i).klass.equals(klass)) {
						throw new RuntimeException();
					}
				}
			}
		}
		return new Pair<Map<State,Maybe<Integer>>,Map<Maybe<Integer>,Class<?>>>(fields, fieldClasses);
	}
	
	public static Pair<Automaton,List<Symbol>> toAutomaton(MultivalueMap<AliasModel,Trace> models, Iterable<ConstructStatementConstructor> constructors, Iterable<Boolean> isNonNulls) {
		// symbol strings
		List<Symbol[]> symbolStrings = new ArrayList<Symbol[]>();
		for(AliasModel model : models.keySet()) {
			// ignore length one models
			if(model.getNumEdgePairs() == 1) {
				continue;
			}
			
			// get trace
			if(models.get(model).isEmpty()) {
				Log.info("NO TRACES FOR MODEL: " + model.toString());
				continue;
			}
			Trace trace = models.get(model).iterator().next();
			
			// get symbol string
			symbolStrings.add(toSymbolString(model, trace));
		}
		return toAutomatonHelper(symbolStrings, constructors, isNonNulls);
	}
	
	private static Symbol[] toSymbolString(AliasModel model, Trace trace) {
		if(model.getNumEdgePairs() <= 1) {
			throw new RuntimeException();
		}
		Symbol[] symbolString = new Symbol[2*model.getNumEdgePairs()];
		for(int i=0; i<model.getNumEdgePairs(); i++) {
			// get edges
			Pair<Callable,Maybe<Integer>> external = model.getStartOrExternalTransition(i);
			Maybe<Integer> internal = model.getInternalTransitionOrEnd(i);
			
			// get method
			Callable method;
			try {
				if(external.getX().isStatic()) {
					method = external.getX();
				} else {
					method = external.getX().getVersionForClass(trace.getReceiver(i));
				}
			} catch(Exception e) {
				throw new RuntimeException(e);
			}
			
			// symbols
			Class<?> zClass = i == 0 ? method.getParameterType(external.getY()) : trace.getVariable(i);
			Class<?> wClass = i == model.getNumEdgePairs()-1 ? method.getReturnType() : trace.getVariable(i+1);
			Symbol z = new Symbol(method, external.getY(), zClass, i == 0 ? StateType.START : StateType.EXTERNAL);
			Symbol w = new Symbol(method, internal, wClass, i == model.getNumEdgePairs()-1 ? StateType.END : StateType.INTERNAL);
			
			// build string
			symbolString[2*i] = z;
			symbolString[2*i+1] = w;
		}
		return symbolString;
	}
	
	private static Pair<Automaton,List<Symbol>> toAutomatonHelper(List<Symbol[]> symbolStrings, Iterable<ConstructStatementConstructor> constructors, Iterable<Boolean> isNonNulls) {
		// build symbol set
		Set<Symbol> symbolSet = new HashSet<Symbol>();
		for(Symbol[] symbolString : symbolStrings) {
			for(Symbol symbol : symbolString) {
				symbolSet.add(symbol);
			}
		}
		
		// build symbol lookups
		List<Symbol> symbols = new ArrayList<Symbol>(symbolSet);
		Map<Symbol,Character> symbolInverse = new HashMap<Symbol,Character>();
		char count = 0;
		for(Symbol symbol : symbols) {
			if(count == Character.MAX_VALUE) {
				throw new RuntimeException();
			}
			symbolInverse.put(symbol, count++);
		}
		
		// build strings
		String[] strings = new String[symbolStrings.size()];
		for(int i=0; i<symbolStrings.size(); i++) {
			Symbol[] symbolString = symbolStrings.get(i);
			char[] string = new char[symbolString.length];
			for(int j=0; j<symbolString.length; j++) {
				string[j] = symbolInverse.get(symbolString[j]);
			}
			strings[i] = new String(string);
		}
		
		// build automaton
		Automaton aut = BasicAutomata.makeStringUnion(strings);
		Log.info("SYMBOLS: " + symbols.size());
		Log.info("STATES: " + aut.getNumberOfStates());
		checkAutomaton(aut, symbols);
		
		// build fields
		Pair<Map<State,Maybe<Integer>>,Map<Maybe<Integer>,Class<?>>> pair = buildFields(aut, symbols);
		Map<State,Maybe<Integer>> fields = pair.getX();
		Map<Maybe<Integer>,Class<?>> fieldClasses = pair.getY();
		
		// useful data structure
		Map<State,String> accessors = getAccessors(aut);
		
		// merges
		int processed = 0;
		Map<State,State> toRepresentatives = new HashMap<State,State>();
		Set<State> representatives = new HashSet<State>();
		LinkedList<State> worklist = new LinkedList<State>(aut.getStates());
		Set<State> firstTry = new HashSet<State>();
		while(!worklist.isEmpty()) {
			State q = worklist.remove();
			processed++;
			// only handle field types
			if(!isFieldStateType(getStateType(q, symbols))) {
				continue;
			}
			// skip non-fields
			if(!fields.get(q).hasT()) {
				continue;
			}
			Log.info("MERGE STEP: " + processed + "/" + aut.getStates().size());
			Log.info("MERGE STEP: " + fieldClasses.get(fields.get(q)) + "." + fields.get(q));
			// try merging with each representative
			boolean isMerge = false;
			boolean isTryAgain = false;
			for(State r : representatives) {
				// only merge fields in the same class
				if(!fieldClasses.get(fields.get(q)).equals(fieldClasses.get(fields.get(r)))) {
					continue;
				}
				// try merge
				MergeOutcome result = tryMerge(aut, accessors.get(q), accessors.get(r), symbols, Settings.MAX_MERGE_CHECK_LENGTH, constructors, isNonNulls);
				// queue merge
				if(result == MergeOutcome.PASS || (result == MergeOutcome.PASS_IF_DEFER && firstTry.contains(q))) {
					Log.info("MERGING: " + fieldClasses.get(fields.get(r)) + "." + fields.get(r));
					toRepresentatives.put(q, r);
					isMerge = true;
					break;
				} else if((result == MergeOutcome.PASS_IF_DEFER || result == MergeOutcome.FAIL_IF_DEFER) && !firstTry.contains(q)) {
					isTryAgain = true;
				}
			}
			if(!isMerge) {
				if(isTryAgain) {
					// try again at the end
					Log.info("TRYING AGAIN LATER: " + fieldClasses.get(fields.get(q)) + "." + fields.get(q));
					worklist.addLast(q);
					firstTry.add(q);
				} else {
					// create new representative
					Log.info("MERGING NONE: " + fieldClasses.get(fields.get(q)) + "." + fields.get(q));
					representatives.add(q);
				}
			}
			Log.info("");
		}
		
		// perform merges
		processed = 0;
		for(Map.Entry<State,State> entry : toRepresentatives.entrySet()) {
			Log.info("PERFORMED MERGES: " + (processed++) + "/" + toRepresentatives.size());
			// add transitions to r
			for(Transition tq : entry.getKey().getTransitions()) {
				entry.getValue().addTransition(tq);
			}
			for(State state : aut.getStates()) {
				List<Transition> newTransitions = new ArrayList<Transition>();
				for(Transition transition : state.getTransitions()) {
					if(transition.getDest().equals(entry.getKey())) {
						newTransitions.add(new Transition(transition.getMin(), transition.getMax(), entry.getValue()));
					}
				}
				for(Transition transition : newTransitions) {
					state.addTransition(transition);
				}
			}
			if(entry.getKey().isAccept()) {
				entry.getValue().setAccept(true);
			}
			// delete q
			entry.getKey().getTransitions().clear();
			for(State state : aut.getStates()) {
				Iterator<Transition> it = state.getTransitions().iterator();
				while(it.hasNext()) {
					Transition t = it.next();
					if(t.getDest().equals(entry.getKey())) {
						it.remove();
					}
				}
			}
			entry.getKey().setAccept(false);
		}
		
		// check automaton
		checkAutomaton(aut, symbols);
		
		return new Pair<Automaton,List<Symbol>>(aut, symbols);
	}
	
	public static List<Pair<Callable,StatementModel>> toStatements(MultivalueMap<AliasModel,Trace> models, Pair<Automaton,List<Symbol>> data) {
		Automaton aut = data.getX();
		List<Symbol> symbols = data.getY();
		
		// build fields
		Pair<Map<State,Maybe<Integer>>,Map<Maybe<Integer>,Class<?>>> pair = buildFields(aut, symbols);
		Map<State,Maybe<Integer>> fields = pair.getX();
		
		// build statements
		Set<Pair<Callable,StatementModel>> statements = new LinkedHashSet<Pair<Callable,StatementModel>>();
		for(State f1 : aut.getStates()) {
			// only process field states
			if(!isFieldStateType(getStateType(f1, symbols))) {
				continue;
			}
			
			// for each state
			for(Transition t1 : f1.getTransitions()) {
				State t = t1.getDest();
				for(Transition t2 : t.getTransitions()) {
					State f2 = t2.getDest();
					
					// for each transition
					for(int i=t1.getMin(); i<=t1.getMax(); i++) {
						for(int j=t2.getMin(); j<=t2.getMax(); j++) {
							// should be same method
							if(!symbols.get(i).method.equals(symbols.get(j).method)) {
								throw new RuntimeException();
							}
							
							// add statement
							Class<?> sourceType = symbols.get(i).klass;
							Class<?> sinkType = symbols.get(j).klass;
							Callable method = symbols.get(i).method;
							Maybe<Integer> source = symbols.get(i).parameter;
							Maybe<Integer> sink = symbols.get(j).parameter;
							Maybe<Integer> sourceField = fields.get(f1);
							Maybe<Integer> sinkField = fields.get(f2);
							statements.add(new Pair<Callable,StatementModel>(method, new StatementModel(source, sink, sourceType, sinkType, sourceField, sinkField)));
						}
					}
				}
			}
		}

		for(AliasModel model : models.keySet()) {
			if(model.getNumEdgePairs() != 1) {
				continue;
			}
			
			Pair<Callable,Maybe<Integer>> external = model.getStartOrExternalTransition(0);
			Maybe<Integer> internal = model.getInternalTransitionOrEnd(0);
			
			Callable method = external.getX();
			statements.add(new Pair<Callable,StatementModel>(method, new StatementModel(external.getY(), internal, method.getParameterType(external.getY()), method.getParameterType(internal), new Maybe<Integer>(), new Maybe<Integer>())));
		}
		
		return new ArrayList<Pair<Callable,StatementModel>>(statements);
	}
}
