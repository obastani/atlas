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
import java.util.List;

import atlas.AliasModelUtils.AliasModel;
import atlas.AliasModelUtils.MethodFilter;
import atlas.AliasModelUtils.ParameterFilter;
import atlas.ObjectConstructorUtils.ConstructStatementConstructor;
import atlas.ReflectionUtils.Callable;
import atlas.StatementUtils.ConstantStatement;
import atlas.StatementUtils.InvokeStatement;
import atlas.StatementUtils.LoadStatement;
import atlas.StatementUtils.SequenceStatement;
import atlas.StatementUtils.Statement;
import atlas.StatementUtils.StoreStatement;
import atlas.Utils.Maybe;
import atlas.Utils.Pair;

public class TestSynthesisUtils {
	public static List<List<Maybe<Object>>> runAllTraces(AliasModel model, Iterable<ConstructStatementConstructor> constructors, Iterable<Boolean> isNonNulls, Maybe<Long> timeoutMillis) {
		List<List<Maybe<Object>>> allTraces = new ArrayList<List<Maybe<Object>>>();
		for(Pair<ConstantStatement<Object>,Statement<Object>> test : getAllTests(constructors, model, isNonNulls)) {
			Maybe<List<Maybe<Object>>> trace = runTrace(test.getY(), model.getNumEdgePairs(), timeoutMillis);
			if(trace.hasT()) {
				allTraces.add(trace.getT());
			}
		}
		return allTraces;
	}

	public static Maybe<AliasModel> runAllTestsWithSubmodels(MethodFilter methodFilter, ParameterFilter parameterFilter, AliasModel model, Iterable<ConstructStatementConstructor> constructors, Iterable<Boolean> isNonNulls, Maybe<Long> timeoutMillis) {
		// check model
		if(!runAllTests(model, constructors, isNonNulls, timeoutMillis)) {
			return new Maybe<AliasModel>();
		}
		
		// check submodels
		for(AliasModel subModel : AliasModelUtils.getSubModels(methodFilter, parameterFilter, model)) {
			if(runAllTests(subModel, constructors, isNonNulls, timeoutMillis)) {
				return new Maybe<AliasModel>(subModel);
			}
		}
		
		// return model
		return new Maybe<AliasModel>(model);
	}
	
	public static boolean runAllTests(AliasModel model, Iterable<ConstructStatementConstructor> constructors, Iterable<Boolean> isNonNulls, Maybe<Long> timeoutMillis) {
		return runAllTestsHelper(getAllTests(constructors, model, isNonNulls), timeoutMillis);
	}
	
	public static boolean runAllTestsForExceptions(AliasModel model, Iterable<ConstructStatementConstructor> constructors, Iterable<Boolean> isNonNulls, Maybe<Long> timeoutMillis) {
		return runAllTestsForExceptionsHelper(getAllTests(constructors, model, isNonNulls), timeoutMillis);
	}
	
	private static boolean runAllTestsHelper(Iterable<Pair<ConstantStatement<Object>,Statement<Object>>> tests, Maybe<Long> timeoutMillis) {
		for(Pair<ConstantStatement<Object>,Statement<Object>> test : tests) {
			if(runTest(test, timeoutMillis)) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean runAllTestsForExceptionsHelper(Iterable<Pair<ConstantStatement<Object>,Statement<Object>>> tests, Maybe<Long> timeoutMillis) {
		for(Pair<ConstantStatement<Object>,Statement<Object>> test : tests) {
			Maybe<Throwable> exception = runTestForException(test, timeoutMillis);
			if(exception.hasT() && isIgnoredException(exception.getT())) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean isIgnoredException(Throwable exception) {
		for(Class<?> klass : Settings.IGNORED_EXCEPTIONS) {
			if(klass.isAssignableFrom(exception.getClass())) {
				return true;
			}
		}
		return false;
	}
	
	private static List<Pair<ConstantStatement<Object>,Statement<Object>>> getAllTests(Iterable<ConstructStatementConstructor> constructors, AliasModel model, Iterable<Boolean> isNonNulls) {
		List<Pair<ConstantStatement<Object>,Statement<Object>>> tests = new ArrayList<Pair<ConstantStatement<Object>,Statement<Object>>>();
		for(ConstructStatementConstructor constructor : constructors) {
			for(boolean isNonNull : isNonNulls) {
				Maybe<Pair<ConstantStatement<Object>,Statement<Object>>> test = getTest(constructor, model, isNonNull);
				if(test.hasT()) {
					tests.add(test.getT());
				}
			}
		}
		return tests;
	}
	
	private static Statement<Object> getInvokeParameter(ConstructStatementConstructor constructor, Class<?> parameterType, boolean isNonNull, boolean isReceiver) {
		return parameterType.isPrimitive() ? constructor.getConstructStatement(parameterType, isReceiver) : new ConstantStatement<Object>(isNonNull ? StatementUtils.execute(constructor.getConstructStatement(parameterType, isReceiver)) : null);
	}
	
	private static Statement<Object>[] getInvokeParameters(ConstructStatementConstructor constructor, Callable method, int parameterIndex, Statement<Object> parameter, boolean isNonNull) {
		Statement<Object>[] parameterStatements = new Statement[method.getParameterCount()];
		for(int i=0; i<method.getParameterCount(); i++) {
			parameterStatements[i] = i == parameterIndex ? parameter : getInvokeParameter(constructor, method.getParameterType(new Maybe<Integer>(i)), isNonNull, !method.isStatic() && i == 0);
		}
		return parameterStatements;
	}
	
	private static Maybe<Pair<ConstantStatement<Object>,Statement<Object>>> getTest(ConstructStatementConstructor constructor, AliasModel model, boolean isNonNull) {
		try {
			return new Maybe<Pair<ConstantStatement<Object>,Statement<Object>>>(getTestHelper(constructor, model, isNonNull));
		} catch(Exception e) {
			return new Maybe<Pair<ConstantStatement<Object>,Statement<Object>>>();
		}
	}
	
	private static Pair<ConstantStatement<Object>,Statement<Object>> getTestHelper(ConstructStatementConstructor constructor, AliasModel model, boolean isNonNull) {
		// statements
		ConstantStatement<Object> input = new ConstantStatement<Object>(StatementUtils.execute(constructor.getConstructStatement(model.getStart().getX().getParameterType(model.getStart().getY()), true)));
		Statement<Object> statement = input;
		int variableIndex = 0;
		
		for(int i=0; i<model.getNumEdgePairs(); i++) {
			// start/external
			Pair<Callable,Maybe<Integer>> external = model.getStartOrExternalTransition(i);
			
			// internal/end
			Maybe<Integer> internal = model.getInternalTransitionOrEnd(i);
			
			// parameters
			Statement<Object>[] parameters = getInvokeParameters(constructor, external.getX(), external.getY().getT(), statement, isNonNull);
			
			// trace external
			parameters[external.getY().getT()] = new SequenceStatement(new StoreStatement("p" + i, parameters[external.getY().getT()]), new LoadStatement("p" + i));
			
			// statements
			if(internal.hasT()) {
				// basic
				String variable = "x" + variableIndex++;
				Statement<Object> internalParameter = constructor.getConstructStatement(external.getX().getParameterType(internal), !external.getX().isStatic() && internal.getT() == 0);
				StoreStatement store = new StoreStatement(variable, internalParameter);
				parameters[internal.getT()] = new LoadStatement(variable);
				
				// trace receiver
				if(!external.getX().isStatic()) {
					parameters[0] = new SequenceStatement(new StoreStatement("r" + i, parameters[0]), new LoadStatement("r" + i));
				}
				
				// statement
				statement = new SequenceStatement(
						store,
						new InvokeStatement(external.getX(), parameters),
						new LoadStatement(variable));
			} else {
				// trace receiver
				if(!external.getX().isStatic()) {
					parameters[0] = new SequenceStatement(new StoreStatement("r" + i, parameters[0]), new LoadStatement("r" + i));
				}
				
				// statement
				statement = new InvokeStatement(external.getX(), parameters);
			}
		}
		
		// end
		return new Pair<ConstantStatement<Object>,Statement<Object>>(input, statement);
	}
	
	private static boolean runTest(Pair<ConstantStatement<Object>,Statement<Object>> test, Maybe<Long> timeoutMillis) {
		try {
			if(timeoutMillis.hasT()) {
				TestRunnable runnable = new TestRunnable(test);
				Utils.runForceTimeout(runnable, timeoutMillis.getT());
				return runnable.getResult();
			} else {
				return runTestHelper(test);
			}
		} catch(Exception e) {}
		return false;
	}
	
	private static Maybe<Throwable> runTestForException(Pair<ConstantStatement<Object>,Statement<Object>> test, Maybe<Long> timeoutMillis) {
		try {
			if(timeoutMillis.hasT()) {
				TestRunnable runnable = new TestRunnable(test);
				Utils.runForceTimeout(runnable, timeoutMillis.getT());
				return runnable.getException();
			} else {
				runTestHelper(test);
				return new Maybe<Throwable>();
			}
		} catch(Exception e) {
			return new Maybe<Throwable>(e);
		}
	}
	
	private static boolean runTestHelper(Pair<ConstantStatement<Object>,Statement<Object>> test) {
		return System.identityHashCode(StatementUtils.execute(test.getX())) == System.identityHashCode(StatementUtils.execute(test.getY()));
	}
	
	private static class TestRunnable implements Runnable {
		private final Pair<ConstantStatement<Object>,Statement<Object>> test;
		private Boolean result = null;
		private Throwable e = null;
		private TestRunnable(Pair<ConstantStatement<Object>,Statement<Object>> test) {
			this.test = test;
		}
		@Override
		public void run() {
			try {
				this.result = runTestHelper(this.test);
			} catch(Exception e) {
				Throwable f = e;
				while(f.getCause() != null) {
					f = f.getCause();
				}
				this.e = f;
			}
		}
		private boolean getResult() {
			return this.result != null && this.result;
		}
		private Maybe<Throwable> getException() {
			return this.e == null ? new Maybe<Throwable>() : new Maybe<Throwable>(this.e);
		}
	}
	
	private static Maybe<List<Maybe<Object>>> runTrace(Statement<Object> test, int length, Maybe<Long> timeoutMillis) {
		try {
			if(timeoutMillis.hasT()) {
				TraceRunnable runnable = new TraceRunnable(test, length);
				Utils.runForceTimeout(runnable, timeoutMillis.getT());
				return new Maybe<List<Maybe<Object>>>(runnable.getTrace());
			} else {
				return new Maybe<List<Maybe<Object>>>(runTraceHelper(test, length));
			}
		} catch(Exception e) {
			return new Maybe<List<Maybe<Object>>>();
		}
	}
	
	// variable_1, receiver_1, ..., variable_k, receiver_k, result
	// receiver is missing for static methods
	private static List<Maybe<Object>> runTraceHelper(Statement<Object> test, int length) {
		Pair<HashMap<String,Object>,Object> pair = StatementUtils.executeForStore(test);
		HashMap<String,Object> store = pair.getX();
		List<Maybe<Object>> trace = new ArrayList<Maybe<Object>>();
		for(int i=0; i<length; i++) {
			trace.add(new Maybe<Object>(store.get("p" + i)));
			trace.add(store.containsKey("r" + i) ? new Maybe<Object>(store.get("r" + i)) : new Maybe<Object>());
		}
		trace.add(new Maybe<Object>(pair.getY()));
		return trace;
	}
	
	private static class TraceRunnable implements Runnable {
		private final Statement<Object> test;
		private final int length;
		private List<Maybe<Object>> trace = null;
		private TraceRunnable(Statement<Object> test, int length) {
			this.test = test;
			this.length = length;
		}
		@Override
		public void run() {
			try {
				this.trace = runTraceHelper(this.test, this.length);
			} catch(Exception e) {}
		}
		private List<Maybe<Object>> getTrace() {
			return this.trace;
		}
	}
}
