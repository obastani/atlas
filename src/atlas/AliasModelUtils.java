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
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import atlas.IteratorUtils.JoinIterable;
import atlas.ObjectConstructorUtils.ConstructStatementConstructor;
import atlas.ReflectionUtils.Callable;
import atlas.Utils.Maybe;
import atlas.Utils.MultivalueMap;
import atlas.Utils.Pair;

public class AliasModelUtils {
	// compute a candidate alias model
	public static PartialAliasModel getAliasModel(MethodLookup methodLookup, ParameterLookup parameterLookup, MethodDecisions methodDecisions, ParameterDecisions parameterDecisions) {
		PartialAliasModel model = new PartialAliasModelEmpty();
		while(true) {
			Maybe<PartialAliasModel> nextModel;
			if(model instanceof PartialAliasModelEmpty) {
				nextModel = processEmpty((PartialAliasModelEmpty)model, methodLookup, parameterLookup, methodDecisions, parameterDecisions);
			} else if(model instanceof PartialAliasModelInternal) {
				nextModel = processInternal((PartialAliasModelInternal)model, methodLookup, parameterLookup, methodDecisions, parameterDecisions);
			} else if(model instanceof PartialAliasModelExternal) {
				nextModel = processExternal((PartialAliasModelExternal)model, methodLookup, parameterLookup, methodDecisions, parameterDecisions);
			} else if(model instanceof AliasModel) {
				nextModel = new Maybe<PartialAliasModel>();
			} else {
				throw new RuntimeException();
			}
			if(!nextModel.hasT()) {
				return model;
			}
			model = nextModel.getT();
		}
	}
	
	public static Maybe<PartialAliasModel> processEmpty(PartialAliasModelEmpty model, MethodLookup methodLookup, ParameterLookup parameterLookup, MethodDecisions methodDecisions, ParameterDecisions parameterDecisions) {
		Maybe<Callable> startMethod = model.chooseStartMethod(methodDecisions, model.getStartMethods(methodLookup));
		if(!startMethod.hasT()) {
			return new Maybe<PartialAliasModel>();
		}
		Maybe<Maybe<Integer>> startParameter = model.chooseStartParameter(parameterDecisions, startMethod.getT(), model.getStartParameters(parameterLookup, startMethod.getT()));
		if(!startParameter.hasT()) {
			return new Maybe<PartialAliasModel>();
		}
		return new Maybe<PartialAliasModel>(model.start(startMethod.getT(), startParameter.getT()));
	}
	
	public static Maybe<PartialAliasModel> processInternal(PartialAliasModelInternal model, MethodLookup methodLookup, ParameterLookup parameterLookup, MethodDecisions methodDecisions, ParameterDecisions parameterDecisions) {
		Maybe<Callable> externalMethod = model.chooseExternalMethod(methodDecisions, model.getExternalMethods(methodLookup));
		if(!externalMethod.hasT()) {
			return new Maybe<PartialAliasModel>();
		}
		Maybe<Maybe<Integer>> externalParameter = model.chooseExternalParameter(parameterDecisions, externalMethod.getT(), model.getExternalParameters(parameterLookup, externalMethod.getT()));
		if(!externalParameter.hasT()) {
			return new Maybe<PartialAliasModel>();
		}
		return new Maybe<PartialAliasModel>(model.external(externalMethod.getT(), externalParameter.getT()));
	}
	
	public static Maybe<PartialAliasModel> processExternal(PartialAliasModelExternal model, MethodLookup methodLookup, ParameterLookup parameterLookup, MethodDecisions methodDecisions, ParameterDecisions parameterDecisions) {
		Maybe<Boolean> end = model.chooseEnd(parameterDecisions, model.getEnds(parameterLookup));
		if(!end.hasT()) {
			return new Maybe<PartialAliasModel>();
		}
		if(end.getT()) {
			return new Maybe<PartialAliasModel>(model.end());
		}
		
		Maybe<Maybe<Integer>> internalParameter = model.chooseInternalParameter(parameterDecisions, model.getInternalParameters(parameterLookup));
		if(!internalParameter.hasT()) {
			return new Maybe<PartialAliasModel>();
		}
		return new Maybe<PartialAliasModel>(model.internal(internalParameter.getT()));
	}
	
	// interface used by partial alias models to provide valid parameter transitions
	public static interface MethodLookup {
		public abstract List<Callable> getStartMethods();
		public abstract List<Callable> getExternalMethods(Callable curMethod, Maybe<Integer> curParameter);
	}
	
	// interface used by partial alias models to provide valid parameter transitions
	public static interface ParameterLookup {
		public abstract List<Maybe<Integer>> getStartParameters(Callable method);
		public abstract List<Maybe<Integer>> getInternalParameters(Callable curMethod, Maybe<Integer> curParameter);
		public abstract List<Maybe<Integer>> getExternalParameters(Callable curMethod, Maybe<Integer> curParameter, Callable method);
		public abstract List<Boolean> getEnds(Callable startMethod, Maybe<Integer> startParameter, Callable curMethod, Maybe<Integer> curParameter, int size);
	}
	
	public static interface MethodDecisions {
		public abstract Maybe<Callable> chooseStartMethod(List<Callable> methods);
		public abstract Maybe<Callable> chooseExternalMethod(List<Callable> path, Callable curMethod, Maybe<Integer> curParameter, List<Callable> methods);
	}
	
	public static interface ParameterDecisions {
		public abstract Maybe<Maybe<Integer>> chooseStartParameter(Callable startMethod, List<Maybe<Integer>> parameters);
		public abstract Maybe<Maybe<Integer>> chooseInternalParameter(Callable curMethod, Maybe<Integer> curParameter, List<Maybe<Integer>> parameters);
		public abstract Maybe<Maybe<Integer>> chooseExternalParameter(Callable curMethod, Maybe<Integer> curParameter, Callable externalMethod, List<Maybe<Integer>> parameters);
		public abstract Maybe<Boolean> chooseEnd(Callable startMethod, Maybe<Integer> startParameter, Callable curMethod, Maybe<Integer> curParameter, int size, List<Boolean> ends);
	}
	
	public static interface MethodFilter {
		public abstract boolean isStartMethod(Callable method);
		public abstract boolean isExternalMethod(Callable curMethod, Maybe<Integer> curParameter, Callable method);
	}
	
	public static interface ParameterFilter {
		public abstract boolean isStartParameter(Callable method, Maybe<Integer> parameter);
		public abstract boolean isInternalParameter(Callable curMethod, Maybe<Integer> curParameter, Maybe<Integer> parameter);
		public abstract boolean isExternalParameter(Callable curMethod, Maybe<Integer> curParameter, Callable method, Maybe<Integer> parameter);
		public abstract boolean isEnd(Callable startMethod, Maybe<Integer> startParameter, Callable curMethod, Maybe<Integer> curParameter, int size, boolean end);
	}
	
	public static class DefaultMethodLookup implements MethodLookup {
		private final MethodFilter filter;
		private final List<Callable> startMethods = new ArrayList<Callable>();
		private final List<Callable> allMethods = new ArrayList<Callable>();
		
		public DefaultMethodLookup(MethodFilter filter, Iterable<Callable> allMethods) {
			this.filter = filter;
			for(Callable method : allMethods) {
				this.allMethods.add(method);
				if(this.filter.isStartMethod(method)) {
					this.startMethods.add(method);
				}
			}
		}
		
		@Override
		public List<Callable> getStartMethods() {
			return this.startMethods;
		}
		
		@Override
		public List<Callable> getExternalMethods(Callable curMethod, Maybe<Integer> curParameter) {
			List<Callable> externalMethods = new ArrayList<Callable>();
			for(Callable method : this.allMethods) {
				if(this.filter.isExternalMethod(curMethod, curParameter, method)) {
					externalMethods.add(method);
				}
			}
			return externalMethods;
		}
	}
	
	public static class CompiledMethodLookup implements MethodLookup {
		private final List<Callable> startMethods = new ArrayList<Callable>();
		private final Map<Pair<Callable,Maybe<Integer>>,List<Callable>> externalMethods = new HashMap<Pair<Callable,Maybe<Integer>>,List<Callable>>();
		
		public CompiledMethodLookup(MethodFilter filter, Iterable<Callable> allMethods) {
			int total = 0;
			for(Callable method : allMethods) {
				total++;
				if(filter.isStartMethod(method)) {
					this.startMethods.add(method);
				}
			}
			int count = 0;
			for(Callable curMethod : allMethods) {
				if((++count)%100 == 0) {
					Log.info("COMPILING: " + count + "/" + total);
				}
				for(Maybe<Integer> curParameter : curMethod.getAllObjectParameters()) {
					List<Callable> methods = new ArrayList<Callable>();
					for(Callable method : allMethods) {
						if(filter.isExternalMethod(curMethod, curParameter, method)) {
							methods.add(method);
						}
					}
					this.externalMethods.put(new Pair<Callable,Maybe<Integer>>(curMethod, curParameter), methods);
				}
			}
			System.out.println("DONE COMPILING: " + total);
		}
		
		@Override
		public List<Callable> getStartMethods() {
			return this.startMethods;
		}
		
		@Override
		public List<Callable> getExternalMethods(Callable curMethod, Maybe<Integer> curParameter) {
			return this.externalMethods.get(new Pair<Callable,Maybe<Integer>>(curMethod, curParameter));
		}
	}
	
	public static class DefaultParameterLookup implements ParameterLookup {
		private final ParameterFilter filter;
		public DefaultParameterLookup(ParameterFilter filter) {
			this.filter = filter;
		}
		
		@Override
		public List<Maybe<Integer>> getStartParameters(Callable method) {
			List<Maybe<Integer>> startParameters = new ArrayList<Maybe<Integer>>();
			for(Maybe<Integer> parameter : method.getAllObjectParameters()) {
				if(this.filter.isStartParameter(method, parameter)) {
					startParameters.add(parameter);
				}
			}
			return startParameters;
		}
		
		@Override
		public List<Maybe<Integer>> getInternalParameters(Callable curMethod, Maybe<Integer> curParameter) {
			List<Maybe<Integer>> internalParameters = new ArrayList<Maybe<Integer>>();
			for(Maybe<Integer> parameter : curMethod.getAllObjectParameters()) {
				if(this.filter.isInternalParameter(curMethod, curParameter, parameter)) {
					internalParameters.add(parameter);
				}
			}
			return internalParameters;
		}
		
		@Override
		public List<Maybe<Integer>> getExternalParameters(Callable curMethod, Maybe<Integer> curParameter, Callable method) {
			List<Maybe<Integer>> externalParameters = new ArrayList<Maybe<Integer>>();
			for(Maybe<Integer> parameter : method.getAllObjectParameters()) {
				if(this.filter.isExternalParameter(curMethod, curParameter, method, parameter)) {
					externalParameters.add(parameter);
				}
			}
			return externalParameters;
		}
		
		@Override
		public List<Boolean> getEnds(Callable startMethod, Maybe<Integer> startParameter, Callable curMethod, Maybe<Integer> curParameter, int size) {
			List<Boolean> ends = new ArrayList<Boolean>();
			if(curMethod.hasObjectReturn() && this.filter.isEnd(startMethod, startParameter, curMethod, curParameter, size, true)) {
				ends.add(true);
			}
			if(this.filter.isEnd(startMethod, startParameter, curMethod, curParameter, size, false)) {
				ends.add(false);
			}
			return ends;
		}
	}

	private static <T> Maybe<T> chooseRandom(List<T> ts, Random random) {
		return ts.isEmpty() ? new Maybe<T>() : new Maybe<T>(ts.get(random.nextInt(ts.size())));
	}
	
	public static class DefaultMethodDecisions implements MethodDecisions {
		private final Random random;
		public DefaultMethodDecisions(Random random) {
			this.random = random;
		}
		@Override
		public Maybe<Callable> chooseStartMethod(List<Callable> methods) {
			return chooseRandom(methods, this.random);
		}
		@Override
		public Maybe<Callable> chooseExternalMethod(List<Callable> path, Callable curMethod, Maybe<Integer> curParameter, List<Callable> methods) {
			return chooseRandom(methods, this.random);
		}
	}
	
	public static class DefaultParameterDecisions implements ParameterDecisions {
		private final Random random;
		public DefaultParameterDecisions(Random random) {
			this.random = random;
		}
		
		@Override
		public Maybe<Maybe<Integer>> chooseStartParameter(Callable startMethod, List<Maybe<Integer>> parameters) {
			return chooseRandom(parameters, this.random);
		}
		
		@Override
		public Maybe<Maybe<Integer>> chooseInternalParameter(Callable curMethod, Maybe<Integer> curParameter, List<Maybe<Integer>> parameters) {
			return chooseRandom(parameters, this.random);
		}
		
		@Override
		public Maybe<Maybe<Integer>> chooseExternalParameter(Callable curMethod, Maybe<Integer> curParameter, Callable externalMethod, List<Maybe<Integer>> parameters) {
			return chooseRandom(parameters, this.random);
		}
		
		@Override
		public Maybe<Boolean> chooseEnd(Callable startMethod, Maybe<Integer> startParameter, Callable curMethod, Maybe<Integer> curParameter, int size, List<Boolean> ends) {
			return chooseRandom(ends, this.random);
		}
	}
	
	public static class Node {
		public final Callable method;
		public final Maybe<Integer> parameter;
		public Node(Callable method, Maybe<Integer> parameter) {
			this.method = method;
			this.parameter = parameter;
		}
		public Callable getMethod() {
			return this.method;
		}
		public Maybe<Integer> getParameter() {
			return this.parameter;
		}
		@Override
		public String toString() {
			return "(" + this.method.getString() + ", " + (this.parameter.hasT() ? this.parameter.getT() : -1) + ")";
		}
		@Override
		public int hashCode() {
			return 31*this.method.hashCode() + (this.parameter.hasT() ? this.parameter.getT() : -1);
		}
		@Override
		public boolean equals(Object obj) {
			Node other = (Node)obj;
			return this.method.equals(other.method) && this.parameter.equals(other.parameter);
		}
	}
	
	public static interface PartialAliasModel {
		public abstract List<Node> getPath();
	}
	
	// partial alias model with no edges
	public static class PartialAliasModelEmpty implements PartialAliasModel {
		private final List<Node> path = new ArrayList<Node>();
		
		// transitions
		public PartialAliasModelExternal start(Callable method, Maybe<Integer> parameter) {
			return new PartialAliasModelExternal(IteratorUtils.getSingleIterable(new Node(method, parameter)));
		}
		
		// lookup
		public List<Callable> getStartMethods(MethodLookup lookup) {
			return lookup.getStartMethods();
		}
		public List<Maybe<Integer>> getStartParameters(ParameterLookup lookup, Callable startMethod) {
			return lookup.getStartParameters(startMethod);
		}
		
		// decisions
		public Maybe<Callable> chooseStartMethod(MethodDecisions decisions, List<Callable> methods) {
			return decisions.chooseStartMethod(methods);
		}
		public Maybe<Maybe<Integer>> chooseStartParameter(ParameterDecisions decisions, Callable method, List<Maybe<Integer>> parameters) {
			return decisions.chooseStartParameter(method, parameters);
		}
		
		@Override
		public String toString() {
			return Utils.toString(new ArrayList<Node>());
		}
		
		@Override
		public List<Node> getPath() {
			return this.path;
		}
	}
	
	// partial alias model where last edge is external
	public static class PartialAliasModelExternal implements PartialAliasModel {
		private final List<Node> path = new ArrayList<Node>();
		private PartialAliasModelExternal(Iterable<Node> path) {
			for(Node node : path) {
				this.path.add(node);
			}
		}
		
		// utility
		private Node getStartNode() {
			return this.path.get(0);
		}
		private Node getCurrentNode() {
			return this.path.get(this.path.size()-1);
		}
		private int size() {
			return this.path.size();
		}
		
		// transitions
		public PartialAliasModelInternal internal(Maybe<Integer> parameter) {
			Node node = new Node(this.getCurrentNode().getMethod(), parameter);
			return new PartialAliasModelInternal(new JoinIterable<Node>(this.path, IteratorUtils.getSingleIterable(node)));
		}
		public AliasModel end() {
			Node node = new Node(this.getCurrentNode().getMethod(), new Maybe<Integer>());
			return new AliasModel(new JoinIterable<Node>(this.path, IteratorUtils.getSingleIterable(node)));
		}
		
		// lookup
		public List<Maybe<Integer>> getInternalParameters(ParameterLookup lookup) {
			return lookup.getInternalParameters(this.getCurrentNode().getMethod(), this.getCurrentNode().getParameter());
		}
		public List<Boolean> getEnds(ParameterLookup lookup) {
			return lookup.getEnds(this.getStartNode().getMethod(), this.getStartNode().getParameter(), this.getCurrentNode().getMethod(), this.getCurrentNode().getParameter(), this.size());
		}
		
		// decisions
		public Maybe<Maybe<Integer>> chooseInternalParameter(ParameterDecisions decisions, List<Maybe<Integer>> parameters) {
			return decisions.chooseInternalParameter(this.getCurrentNode().getMethod(), this.getCurrentNode().getParameter(), parameters);
		}
		public Maybe<Boolean> chooseEnd(ParameterDecisions decisions, List<Boolean> ends) {
			return decisions.chooseEnd(this.getStartNode().getMethod(), this.getStartNode().getParameter(), this.getCurrentNode().getMethod(), this.getCurrentNode().getParameter(), this.size(), ends);
		}
		
		@Override
		public String toString() {
			return Utils.toString(this.path);
		}
		
		@Override
		public List<Node> getPath() {
			return this.path;
		}
	}
	
	// partial alias model where last edge is internal
	public static class PartialAliasModelInternal implements PartialAliasModel {
		private final List<Node> path = new ArrayList<Node>();
		public PartialAliasModelInternal(Iterable<Node> path) {
			for(Node node : path) {
				this.path.add(node);
			}
		}
		
		// utility
		private Node getCurrentNode() {
			return this.path.get(this.path.size()-1);
		}
		public Callable getCurrentMethod() {
			return this.getCurrentNode().getMethod();
		}
		private Maybe<Integer> getCurrentParameter() {
			return this.getCurrentNode().getParameter();
		}
		private List<Callable> getMethodPath() {
			List<Callable> methodPath = new ArrayList<Callable>();
			for(int i=0; i<this.path.size(); i+=2) {
				methodPath.add(this.path.get(i).method);
			}
			return methodPath;
		}
		
		// transitions
		public PartialAliasModelExternal external(Callable method, Maybe<Integer> parameter) {
			Node node = new Node(method, parameter);
			return new PartialAliasModelExternal(new JoinIterable<Node>(this.path, IteratorUtils.getSingleIterable(node)));
		}
		
		// lookup
		public List<Callable> getExternalMethods(MethodLookup lookup) {
			return lookup.getExternalMethods(this.getCurrentMethod(), this.getCurrentParameter());
		}
		public List<Maybe<Integer>> getExternalParameters(ParameterLookup lookup, Callable externalMethod) {
			return lookup.getExternalParameters(this.getCurrentMethod(), this.getCurrentParameter(), externalMethod);
		}
		
		//decisions
		public Maybe<Callable> chooseExternalMethod(MethodDecisions decisions, List<Callable> methods) {
			return decisions.chooseExternalMethod(this.getMethodPath(), this.getCurrentMethod(), this.getCurrentParameter(), methods);
		}
		public Maybe<Maybe<Integer>> chooseExternalParameter(ParameterDecisions decisions, Callable externalMethod, List<Maybe<Integer>> parameters) {
			return decisions.chooseExternalParameter(this.getCurrentMethod(), this.getCurrentParameter(), externalMethod, parameters);
		}
		
		@Override
		public String toString() {
			return Utils.toString(this.path);
		}
		
		@Override
		public List<Node> getPath() {
			return this.path;
		}
	}
	
	// start[method, parameter] (internal[parameter+return] external[method, parameter])* end[]
	public static class AliasModel implements PartialAliasModel {
		private final List<Node> path = new ArrayList<Node>();
		public AliasModel(Iterable<Node> path) {
			for(Node node : path) {
				this.path.add(node);
			}
		}
		
		public int getNumEdgePairs() {
			return this.path.size()/2;
		}
		
		public Pair<Callable,Maybe<Integer>> getStart() {
			return this.getStartOrExternalTransition(0);
		}
		
		public Maybe<Integer> getEnd() {
			return this.getInternalTransitionOrEnd(this.getNumEdgePairs()-1);
		}
		
		public Maybe<Integer> getInternalTransitionOrEnd(int index) {
			return this.path.get(2*index+1).getParameter();
		}
		
		public Pair<Callable,Maybe<Integer>> getStartOrExternalTransition(int index) {
			Node node = this.path.get(2*index);
			return new Pair<Callable,Maybe<Integer>>(node.getMethod(), node.getParameter());
		}
		
		@Override
		public String toString() {
			return Utils.toString(this.path);
		}
		
		@Override
		public int hashCode() {
			int result = 1;
			for(int i=0; i<this.path.size(); i++) {
				result = 31*result + this.path.get(i).hashCode();
			}
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			AliasModel other = (AliasModel)obj;
			if(this.path.size() != other.path.size()) {
				return false;
			}
			for(int i=0; i<this.path.size(); i++) {
				if(!this.path.get(i).equals(other.path.get(i))) {
					return false;
				}
			}
			return true;
		}
		
		@Override
		public List<Node> getPath() {
			return this.path;
		}
	}
	
	public static List<AliasModel> getSubModels(MethodFilter methodFilter, ParameterFilter parameterFilter, AliasModel model) {
		List<AliasModel> models = new ArrayList<AliasModel>();
		for(int len=1; len<model.getNumEdgePairs(); len++) {
			for(int start=0; start<=model.getNumEdgePairs()-len; start++) {
				// model is [(2*start, 2*start+1), (2*start+2, 2*start+3), ..., (2*end-2, 2*end-1)]
				int end = start+len;
				
				// compute start/end nodes
				Pair<Callable,Maybe<Integer>> startNode = model.getStartOrExternalTransition(start);
				Pair<Callable,Maybe<Integer>> endNodeExternal = model.getStartOrExternalTransition(end-1);
				Maybe<Integer> endNodeInternal = model.getInternalTransitionOrEnd(end-1);
				
				// check model has return
				if(endNodeInternal.hasT()) {
					continue;
				}
				
				// check model start
				if(!methodFilter.isStartMethod(startNode.getX())) {
					continue;
				}
				if(!parameterFilter.isStartParameter(startNode.getX(), startNode.getY())) {
					continue;
				}
				
				// check model end
				if(!parameterFilter.isEnd(startNode.getX(), startNode.getY(), endNodeExternal.getX(), endNodeExternal.getY(), 2*len-1, true)) {
					continue;
				}
				
				// add the model
				List<Node> path = new ArrayList<Node>();
				for(int i=start; i<end; i++) {
					Pair<Callable,Maybe<Integer>> external = model.getStartOrExternalTransition(i);
					Maybe<Integer> internal = model.getInternalTransitionOrEnd(i);
					path.add(new Node(external.getX(), external.getY()));
					path.add(new Node(external.getX(), internal));
				}
				models.add(new AliasModel(path));
			}
		}
		return models;
	}
	
	// [(method, param), ..., (method, param)]
	public static AliasModel parseAliasModel(String str) {
		if(!str.startsWith("[(") || !str.endsWith(")]")) {
			throw new RuntimeException();
		}
		
		String[] tokens = str.substring(2, str.length()-2).split("\\), \\(");
		if(tokens.length%2 != 0) {
			throw new RuntimeException();
		}
		
		List<Node> nodes = new ArrayList<Node>();
		for(String token : tokens) {
			String[] curTokens = token.split(", ");
			if(curTokens.length != 2) {
				throw new RuntimeException();
			}
			int parameterValue = Integer.parseInt(curTokens[1]);
			Maybe<Integer> parameter = parameterValue == -1 ? new Maybe<Integer>() : new Maybe<Integer>(parameterValue);
			Callable method = ReflectionUtils.parseMethod(curTokens[0]);
			nodes.add(new Node(method, parameter));
		}
		
		for(int i=0; i<nodes.size(); i+=2) {
			if(!nodes.get(i).getMethod().equals(nodes.get(i+1).getMethod())) {
				throw new RuntimeException();
			}
		}
		
		return new AliasModel(nodes);
	}
	
	public static class Trace {
		private final List<Maybe<Class<?>>> classes = new ArrayList<Maybe<Class<?>>>();
		private Trace(Iterable<Maybe<Class<?>>> classes) {
			for(Maybe<Class<?>> klass : classes) {
				this.classes.add(klass);
			}
			if(this.classes.size()%2 != 1) {
				throw new RuntimeException();
			}
		}
		public int getNumEdgePairs() {
			return (this.classes.size()-1)/2;
		}
		public boolean isReceiver(int index) {
			return this.classes.get(2*index+1).hasT();
		}
		public Class<?> getReceiver(int index) {
			return this.classes.get(2*index+1).getT();
		}
		public Class<?> getVariable(int index) {
			return this.classes.get(2*index).getT();
		}
	}
	
	private static Maybe<Trace> getTrace(List<Maybe<Object>> trace, AliasModel model) {
		// check the trace
		if(trace.size() != 2*model.getNumEdgePairs()+1) {
			throw new RuntimeException();
		}
		Set<Integer> pathObjects = new HashSet<Integer>();
		for(int i=0; i<model.getNumEdgePairs(); i++) {
			int pathObject;
			try {
				pathObject = System.identityHashCode(trace.get(2*i).getT());
			} catch(Exception e) {
				Log.info("NULL RECEIVER: " + model);
				return new Maybe<Trace>();
			}
			if(pathObjects.contains(pathObject)) {
				Log.info("DUPLICATE OBJECT: " + model);
				return new Maybe<Trace>();
			}
			pathObjects.add(pathObject);
		}
		
		try {
			// build the classes
			List<Maybe<Class<?>>> classes = new ArrayList<Maybe<Class<?>>>();
			for(int i=0; i<trace.size(); i++) {
				classes.add(trace.get(i).hasT() ? new Maybe<Class<?>>(trace.get(i).getT().getClass()) : new Maybe<Class<?>>());
			}
			// return trace
			return new Maybe<Trace>(new Trace(classes));
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static MultivalueMap<AliasModel,Trace> getAllTraces(Iterable<AliasModel> models, Iterable<ConstructStatementConstructor> constructors, Iterable<Boolean> isNonNulls) {
		MultivalueMap<AliasModel,Trace> modelsWithTraces = new MultivalueMap<AliasModel,Trace>();
		for(AliasModel model : models) {
			List<List<Maybe<Object>>> traceLists = TestSynthesisUtils.runAllTraces(model, constructors, isNonNulls, new Maybe<Long>());
			for(List<Maybe<Object>> traceList : traceLists) {
				Maybe<Trace> trace = getTrace(traceList, model);
				if(trace.hasT()) {
					modelsWithTraces.add(model, trace.getT());
				}
			}
		}
		return modelsWithTraces;
	}
}
