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

import java.util.HashSet;
import java.util.Set;

import atlas.AliasModelUtils.AliasModel;
import atlas.AliasModelUtils.MethodFilter;
import atlas.AliasModelUtils.MethodLookup;
import atlas.AliasModelUtils.ParameterDecisions;
import atlas.AliasModelUtils.ParameterFilter;
import atlas.AliasModelUtils.ParameterLookup;
import atlas.AliasModelUtils.PartialAliasModel;
import atlas.AliasModelUtils.Trace;
import atlas.LearnerUtils.LearnerMethodDecisions;
import atlas.ObjectConstructorUtils.ConstructStatementConstructor;
import atlas.ReflectionUtils.Callable;
import atlas.Utils.Maybe;
import atlas.Utils.MultivalueMap;

public class RunUtils {
	public static void runConstructProxyModels(Iterable<Class<?>> allClasses, Iterable<ConstructStatementConstructor> constructors) {
		MultivalueMap<Callable,Class<?>> models = ProxyModelUtils.getProxyModels(allClasses, constructors, Settings.DEFAULT_TIMEOUT);
		for(Callable method : models.keySet()) {
			for(Class<?> klass : models.get(method)) {
				Log.info(method + " -> " + klass.getName());
			}
		}
		ModelFileUtils.updateProxy(models);
	}
	
	public static void runLearnConstructModels(MethodLookup methodLookup, ParameterLookup parameterLookup, LearnerMethodDecisions methodDecisions, ParameterDecisions parameterDecisions, MethodFilter methodFilter, ParameterFilter parameterFilter, Iterable<ConstructStatementConstructor> constructors, Iterable<Boolean> isNonNulls, int iters) {
		Set<AliasModel> models = new HashSet<AliasModel>();
		for(int i=0; i<iters; i++) {
			boolean isSuccessful = false;
			
			// construct model
			PartialAliasModel partialModel = AliasModelUtils.getAliasModel(methodLookup, parameterLookup, methodDecisions, parameterDecisions);
			if(partialModel instanceof AliasModel) {
				// model not yet discovered
				if(!models.contains((AliasModel)partialModel)) {
					// test model
					Maybe<AliasModel> model = TestSynthesisUtils.runAllTestsWithSubmodels(methodFilter, parameterFilter, (AliasModel)partialModel, constructors, isNonNulls, Settings.DEFAULT_TIMEOUT);
					if(model.hasT()) {
						// model still not already discovered
						if(!models.contains(model.getT())) {
							// update models
							models.add(model.getT());
							Log.info(model.getT().toString());
							Log.info("Count: " + models.size() + "/" + (i+1));
							isSuccessful = true;
						}
					}
				}
			}
			
			// update learner
			methodDecisions.update(partialModel, isSuccessful);
		}
		ModelFileUtils.update(models);
	}
	
	public static void runWriteModels(Iterable<Class<?>> allClasses, Iterable<ConstructStatementConstructor> constructors, Iterable<Boolean> isNonNulls) {
		long startTime = System.currentTimeMillis();
		
		// get traced models
		MultivalueMap<AliasModel,Trace> models = AliasModelUtils.getAllTraces(ModelFileUtils.load(), constructors, isNonNulls);
		
		// update proxy
		MultivalueMap<Callable,Class<?>> proxyModels = ModelFileUtils.loadProxy();
		proxyModels.addAll(ProxyModelUtils.getProxyObjectModelsFromAliasModels(models));
		ModelFileUtils.updateProxy(proxyModels);
		
		// write models
		ModelFileUtils.writeModelsTracing(allClasses, models, proxyModels, constructors, isNonNulls);
		
		long time = System.currentTimeMillis() - startTime;
		Log.info("total time: " + time);
	}
}
