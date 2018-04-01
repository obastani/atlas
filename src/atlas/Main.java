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

import java.util.List;
import java.util.Random;

import atlas.AliasModelUtils.AliasModel;
import atlas.AliasModelUtils.DefaultParameterDecisions;
import atlas.AliasModelUtils.MethodFilter;
import atlas.AliasModelUtils.MethodLookup;
import atlas.AliasModelUtils.ParameterDecisions;
import atlas.AliasModelUtils.ParameterFilter;
import atlas.AliasModelUtils.ParameterLookup;
import atlas.LearnerUtils.LearnerMethodDecisions;
import atlas.LearnerUtils.QMethodDecisions;
import atlas.ObjectConstructorUtils.ConstructStatementConstructor;
import atlas.ReflectionUtils.Callable;
import atlas.Utils.Filter;

public class Main {
	public static boolean isTargetClass(String name) {
		return name.equals("java.util.Object") || name.startsWith("java.util.");
	}
	
	public static boolean isJavaClass(String name) {
		return name.startsWith("java.");
	}
	
	public static void runModels(int iters, boolean isStrictReceiver, boolean isQLearner, Iterable<Boolean> isNonNulls) {
		// parameters
		boolean isCompiled = true;
		int transitionBound = 9;
		double epsilon = 0.5;
		double alpha = 0.8;
		double gamma = 1.0;
		int seed = 0;
		
		// set up
		Random random = new Random(seed);
		List<Callable> allMethods = ReflectionUtils.getCompleteMethods(
				new Filter<String>() { public boolean filter(String klass) { return isTargetClass(klass); }},
				false, true);
		MethodLookup methodLookup = isCompiled ? TransitionUtils.getCompiledStrictMethodLookup(transitionBound, isStrictReceiver, allMethods) : TransitionUtils.getStrictMethodLookup(transitionBound, isStrictReceiver, allMethods);
		ParameterLookup parameterLookup = TransitionUtils.getStrictParameterLookup(transitionBound, isStrictReceiver);
		LearnerMethodDecisions methodDecisions = isQLearner ? new QMethodDecisions(methodLookup, epsilon, alpha, gamma, random) : LearnerUtils.getRandomLearnerMethodDecisions(random);
		ParameterDecisions parameterDecisions = new DefaultParameterDecisions(random);
		MethodFilter methodFilter = TransitionUtils.getStrictMethodFilter(transitionBound, isStrictReceiver);
		ParameterFilter parameterFilter = TransitionUtils.getStrictParameterFilter(transitionBound, isStrictReceiver);
		List<Class<?>> classes = ReflectionUtils.getClasses(
				new Filter<String>() { public boolean filter(String klass) { return isTargetClass(klass); }}, false, true);
		List<ConstructStatementConstructor> constructors = ObjectConstructorUtils.getDefaultConstructStatementConstructors(classes, isNonNulls);
		
		// run
		long time = System.currentTimeMillis();
		RunUtils.runLearnConstructModels(methodLookup, parameterLookup, methodDecisions, parameterDecisions, methodFilter, parameterFilter, constructors, isNonNulls, iters);
		Log.info("Time: " + (System.currentTimeMillis() - time));
	}
	
	public static void runProxy() {
		List<Class<?>> allClasses = ReflectionUtils.getClasses(new Filter<String>() { public boolean filter(String klass) { return isTargetClass(klass); }}, false, false);
		List<ConstructStatementConstructor> constructors = ObjectConstructorUtils.getDefaultConstructStatementConstructors(allClasses, Settings.PROXY_IS_NON_NULL);
		RunUtils.runConstructProxyModels(allClasses, constructors);
		System.exit(0);
	}
	
	public static void runSource() {
		List<Class<?>> allClasses = ReflectionUtils.getClasses(new Filter<String>() { public boolean filter(String klass) { return isJavaClass(klass); }}, false, false);
		List<Boolean> isNonNulls = ObjectConstructorUtils.getAllBooleans();
		List<ConstructStatementConstructor> constructors = ObjectConstructorUtils.getDefaultConstructStatementConstructors(allClasses, isNonNulls);
		RunUtils.runWriteModels(allClasses, constructors, isNonNulls);
	}
	
	public static void main(String[] args) {
		Log.init("log_nonstrict_1mil.txt");
		runModels(1000000, false, true, ObjectConstructorUtils.getAllBooleans());
		
		Log.init("log_strict_1mil.txt");
		runModels(1000000, true, true, ObjectConstructorUtils.getAllBooleans());
		
		Log.init("log_proxy.txt");
		runProxy();
		
		Log.init("log_source.txt");
		runSource();
	}
}
