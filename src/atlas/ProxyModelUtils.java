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

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;

import atlas.AliasModelUtils.AliasModel;
import atlas.AliasModelUtils.Trace;
import atlas.ObjectConstructorUtils.ConstructStatementConstructor;
import atlas.ReflectionUtils.AtlasMethod;
import atlas.ReflectionUtils.Callable;
import atlas.Utils.Maybe;
import atlas.Utils.MultivalueMap;
import atlas.Utils.Pair;

public class ProxyModelUtils {
	private static class RunMethod implements Runnable {
		private final Method method;
		private final Object receiver;
		private final Object[] parameters;
		private Object output;
		private RunMethod(Method method, Object receiver, Object[] parameters) {
			this.method = method;
			this.receiver = receiver;
			this.parameters = parameters;
		}
		@Override
		public void run() {
			try {
				this.output = this.method.invoke(this.receiver, this.parameters);
			} catch(Exception e) {
				this.output = null;
			}
		}
	}
	
	private static Maybe<Class<?>> getProxyModel(Method method, ConstructStatementConstructor constructor, Maybe<Long> timeout) {
		try {
			Object[] parameters = new Object[method.getParameterTypes().length];
			Object receiver = Modifier.isStatic(method.getModifiers()) ? null : constructor.getConstructStatement(method.getDeclaringClass(), true).execute(new HashMap<String,Object>());
			for(int i=0; i<method.getParameterTypes().length; i++) {
				parameters[i] = method.getParameterTypes()[i].isPrimitive() ? constructor.getConstructStatement(method.getParameterTypes()[i], false) : null;
			}
			Object output;
			if(timeout.hasT()) {
				RunMethod run = new RunMethod(method, receiver, parameters);
				Utils.runForceTimeout(run, timeout.getT());
				output = run.output;
			} else {
				output = method.invoke(receiver, parameters);
			}
			return output == null || receiver.equals(output) ? new Maybe<Class<?>>() : new Maybe<Class<?>>(output.getClass());
		} catch(Exception e) {
			return new Maybe<Class<?>>();
		}
	}
	
	public static MultivalueMap<Callable,Class<?>> getProxyModels(Iterable<Class<?>> allClasses, Iterable<ConstructStatementConstructor> constructors, Maybe<Long> timeout) {
		MultivalueMap<Callable,Class<?>> models = new MultivalueMap<Callable,Class<?>>();
		for(Class<?> klass : allClasses) {
			for(Method method : klass.getDeclaredMethods()) {
				if(!Modifier.isPublic(method.getModifiers())) {
					continue;
				}
				if(method.isSynthetic()) {
					continue;
				}
				if(method.getReturnType().isPrimitive()) {
					continue;
				}
				if(Modifier.isAbstract(method.getModifiers())) {
					continue;
				}
				try {
					for(ConstructStatementConstructor constructor : constructors) {
						Maybe<Class<?>> model = getProxyModel(method, constructor, timeout);
						if(model.hasT()) {
							models.add(new AtlasMethod(method, klass), model.getT());
						}
					}
				} catch(Exception e) {}
			}
		}
		return models;
	}
	
	public static MultivalueMap<Callable,Class<?>> getProxyObjectModelsFromAliasModels(MultivalueMap<AliasModel,Trace> models) {
		MultivalueMap<Callable,Class<?>> proxyModels = new MultivalueMap<Callable,Class<?>>();
		for(AliasModel model : models.keySet()) {
			for(int i=0; i<model.getNumEdgePairs()-1; i++) {
				Pair<Callable,Maybe<Integer>> external = model.getStartOrExternalTransition(i);
				Maybe<Integer> internal = model.getInternalTransitionOrEnd(i);
				if(!(external.getX() instanceof AtlasMethod)) {
					continue;
				}
				if(internal.hasT()) {
					continue;
				}
				Method method = ((AtlasMethod)external.getX()).method;
				for(Trace trace : models.get(model)) {
					if(trace.isReceiver(i)) {
						try {
							method = trace.getReceiver(i).getMethod(method.getName(), method.getParameterTypes());
						} catch(Exception e) {
							throw new RuntimeException(e);
						}
					}
					proxyModels.add(new AtlasMethod(method, method.getDeclaringClass()), trace.getVariable(i+1));
				}
			}
		}
		return proxyModels;
	}
}
