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

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import atlas.ReflectionUtils.Callable;
import atlas.StatementModelUtils.StatementModel;
import atlas.Utils.Maybe;
import atlas.Utils.MultivalueMap;
import atlas.Utils.Pair;
import atlas.Utils.Triple;

public class FieldTypeUtils {	
	private static class FieldEdge {
		private final Set<Pair<Callable,Maybe<Integer>>> sources = new HashSet<Pair<Callable,Maybe<Integer>>>();
		private final Set<Pair<Callable,Maybe<Integer>>> sinks = new HashSet<Pair<Callable,Maybe<Integer>>>();
	}
	
	private static Map<Integer,FieldEdge> getFieldEdges(Iterable<Pair<Callable,StatementModel>> statements) {
		Map<Integer,FieldEdge> edges = new HashMap<Integer,FieldEdge>();
		for(Pair<Callable,StatementModel> statement : statements) {
			// fields
			Maybe<Integer> sourceField = statement.getY().sourceField;
			Maybe<Integer> sinkField = statement.getY().sinkField;
			
			// variables
			Pair<Callable,Maybe<Integer>> sourceVariable = new Pair<Callable,Maybe<Integer>>(statement.getX(), statement.getY().source);
			Pair<Callable,Maybe<Integer>> sinkVariable = new Pair<Callable,Maybe<Integer>>(statement.getX(), statement.getY().sink);
			
			// edges
			if(sourceField.hasT()) {
				FieldEdge sourceFieldEdge = edges.get(sourceField.getT());
				if(sourceFieldEdge == null) {
					sourceFieldEdge = new FieldEdge();
					edges.put(sourceField.getT(), sourceFieldEdge);
				}
				sourceFieldEdge.sources.add(sourceVariable);
			}
			if(sinkField.hasT()) {
				FieldEdge sinkFieldEdge = edges.get(sinkField.getT());
				if(sinkFieldEdge == null) {
					sinkFieldEdge = new FieldEdge();
					edges.put(sinkField.getT(), sinkFieldEdge);
				}
				sinkFieldEdge.sinks.add(sinkVariable);
			}
		}
		return edges;
	}
	
	private static MultivalueMap<Triple<Callable,Maybe<Integer>,Integer>,Pair<Callable,StatementModel>> getStatementsBySource(Iterable<Pair<Callable,StatementModel>> statements) {
		MultivalueMap<Triple<Callable,Maybe<Integer>,Integer>,Pair<Callable,StatementModel>> statementsBySource = new MultivalueMap<Triple<Callable,Maybe<Integer>,Integer>,Pair<Callable,StatementModel>>();
		for(Pair<Callable,StatementModel> statement : statements) {
			if(statement.getY().sourceField.hasT()) {
				statementsBySource.add(new Triple<Callable,Maybe<Integer>,Integer>(statement.getX(), statement.getY().source, statement.getY().sourceField.getT()), statement);
			}
		}
		return statementsBySource;
	}
	
	private static void addHelper(Map<Integer,Class<?>> fieldTypes, LinkedList<Integer> worklist, Pair<Callable,Maybe<Integer>> variable, Maybe<Integer> field, Class<?> type) {
		if(field.hasT()) {
			if(!fieldTypes.containsKey(field.getT())) {
				fieldTypes.put(field.getT(), type);
				worklist.add(field.getT());
			} else if(!fieldTypes.get(field.getT()).equals(type)) {
				Log.info("INTERNAL FIELD MISMATCH: " + field.getT() + " has types " + fieldTypes.get(field.getT()) + " vs. " + type + " in parameter " + variable.getY().toString() + " of method " + variable.getX().toGenericString());
				if(fieldTypes.get(field.getT()).isAssignableFrom(type)) {
					Log.info("CHOOSING: " + fieldTypes.get(field.getT()));
				} else if(type.isAssignableFrom(fieldTypes.get(field.getT()))) {
					fieldTypes.put(field.getT(), type);
					worklist.add(field.getT());
					Log.info("CHOOSING: " + type);
				} else {
					Log.info("ERROR: UNMATCHABLE!");
				}
			}
		} else if(!type.equals(variable.getX().getParameterType(variable.getY()))) {
			Log.info("RETURN FIELD MISMATCH: types " + variable.getX().getParameterType(variable.getY()) + " vs. " + type + " in parameter " + variable.getY().toString() + " of method " + variable.getX().toString());
			if(!variable.getX().getParameterType(variable.getY()).isAssignableFrom(type)) {
				Log.info("ERROR: UNASSIGNABLE!");
			}
		}
	}
	
	public static Map<Integer,Class<?>> getFieldTypes(Iterable<Pair<Callable,StatementModel>> statements) {
		// setup
		Map<Integer,FieldEdge> fieldEdges = getFieldEdges(statements);
		MultivalueMap<Triple<Callable,Maybe<Integer>,Integer>,Pair<Callable,StatementModel>> statementsBySource = getStatementsBySource(statements);
		
		// result
		Map<Integer,Class<?>> fieldTypes = new HashMap<Integer,Class<?>>();
		
		// auxiliary data structure
		LinkedList<Integer> worklist = new LinkedList<Integer>();
		
		// initialize
		for(Pair<Callable,StatementModel> statement : statements) {
			// handle source base case
			if(!statement.getY().sourceField.hasT()) {
				// get source type
				Class<?> sourceType = statement.getX().getParameterType(statement.getY().source);
				// get sink variable
				Pair<Callable,Maybe<Integer>> sinkVariable = new Pair<Callable,Maybe<Integer>>(statement.getX(), statement.getY().sink);
				// get sink field
				Maybe<Integer> sinkField = statement.getY().sinkField;
				// put type
				addHelper(fieldTypes, worklist, sinkVariable, sinkField, sourceType);
			}
		}
		
		// transitive closure
		while(!worklist.isEmpty()) {
			// pop
			int curField = worklist.removeFirst();
			Class<?> curType = fieldTypes.get(curField);
			if(curType == null) {
				throw new RuntimeException();
			}
			
			// assign types to sinks
			for(Pair<Callable,Maybe<Integer>> source : fieldEdges.get(curField).sources) {
				for(Pair<Callable,StatementModel> statement : statementsBySource.get(new Triple<Callable,Maybe<Integer>,Integer>(source.getX(), source.getY(), curField))) {
					// get sink variable
					Pair<Callable,Maybe<Integer>> sinkVariable = new Pair<Callable,Maybe<Integer>>(statement.getX(), statement.getY().sink);
					// get sink field
					Maybe<Integer> sinkField = statement.getY().sinkField;
					// put type
					addHelper(fieldTypes, worklist, sinkVariable, sinkField, curType);
				}
			}
		}
		
		return fieldTypes;
	}
}
