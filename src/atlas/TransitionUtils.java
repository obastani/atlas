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

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import atlas.AliasModelUtils.CompiledMethodLookup;
import atlas.AliasModelUtils.DefaultMethodLookup;
import atlas.AliasModelUtils.DefaultParameterLookup;
import atlas.AliasModelUtils.MethodFilter;
import atlas.AliasModelUtils.MethodLookup;
import atlas.AliasModelUtils.ParameterFilter;
import atlas.AliasModelUtils.ParameterLookup;
import atlas.ReflectionUtils.AtlasArray;
import atlas.ReflectionUtils.AtlasConstructor;
import atlas.ReflectionUtils.AtlasMethod;
import atlas.ReflectionUtils.Callable;
import atlas.Utils.Maybe;

public class TransitionUtils {
	public static ParameterLookup getStrictParameterLookup(int bound, boolean isStrictReceiver) {
		return new DefaultParameterLookup(getStrictParameterFilter(bound, isStrictReceiver));
	}
	
	public static MethodLookup getStrictMethodLookup(int bound, boolean isStrictReceiver, Iterable<Callable> allMethods) {
		return new DefaultMethodLookup(getStrictMethodFilter(bound, isStrictReceiver), allMethods);
	}
	
	public static MethodLookup getCompiledStrictMethodLookup(int bound, boolean isStrictReceiver, Iterable<Callable> allMethods) {
		return new CompiledMethodLookup(getStrictMethodFilter(bound, isStrictReceiver), allMethods);
	}
	
	public static ParameterFilter getStrictParameterFilter(int bound, boolean isStrictReceiver) {
		return new AndParameterFilter(
				new AtlasTargetParameterFilter(),			 // method must be in atlas target if possible (i.e., not a return)
				new BindingParameterFilter(),                // methods must have matching bindings
				new NoStartReturnParameterFilter(),          // start edge must NOT be (-> return)
				new NoStartReceiverParameterFilter(),        // start edge must NOT be (-> receiver)
				new NoExternalReturnReturnParameterFilter(), // external edges must NOT be (return -> return)
				new NoExternalReturnParameterFilter(),       // external edges must NOT be (return -> return) or (parameter -> return)
				new NoLoopParameterFilter(),                 // external edges must NOT be (x -> y), method(x) == method(y), internal edges must not be (x -> x)
				isStrictReceiver
				? new StrictReceiverOnlyParameterFilter()    // external edges must be return -> receiver, also same as next
				: new ReceiverOnlyParameterFilter(),         // internal edges must be (parameter -> receiver), (parameter -> return), or (receiver -> return)
				new TypeEqualityParameterFilter(),           // external edge must be (x -> y), where type(x) == type(y), conclusion must be (x -> y), where type(x) == type(y)
				new NoAbstractMethodParameterFilter(),       // filter out abstract method externals, unless receiver (since these are virtual calls)
				                                             //   reject * -> (java.util.List.addAll(java.util.Collection), 1)
				                                             //   accept * -> (java.util.ArrayList.addAll(java.util.Collection), 1)
				                                             //   accept * -> (java.util.Iterator.next(), 0)
				new BoundedParameterFilter(bound));          // bounded model size
	}
	
	public static MethodFilter getStrictMethodFilter(int bound, boolean isStrictReceiver) {
		return new AndMethodFilter(
				new NoAbstractMethodFilter(),             // filter out abstract method starts (method declaring class, rather than method)
				new NoLoopMethodFilter(),                 // external edges must NOT be (x -> y), method(x) == method(y), internal edges must not be (x -> x)
				new EarlyStoppingMethodFilter(getStrictParameterLookup(bound, isStrictReceiver)));
	}
	
	public static class AndMethodFilter implements MethodFilter {
		private final List<MethodFilter> filters = new ArrayList<MethodFilter>();
		public AndMethodFilter(MethodFilter ... filters) {
			for(MethodFilter filter : filters) {
				this.filters.add(filter);
			}
		}
		
		@Override
		public boolean isStartMethod(Callable method) {
			for(MethodFilter filter : this.filters) {
				if(!filter.isStartMethod(method)) {
					return false;
				}
			}
			return true;
		}
		
		@Override
		public boolean isExternalMethod(Callable curMethod, Maybe<Integer> curParameter, Callable method) {
			for(MethodFilter filter : this.filters) {
				if(!filter.isExternalMethod(curMethod, curParameter, method)) {
					return false;
				}
			}
			return true;
		}
	}
	
	public static class AndParameterFilter implements ParameterFilter {
		private final List<ParameterFilter> filters = new ArrayList<ParameterFilter>();
		public AndParameterFilter(ParameterFilter ... filters) {
			for(ParameterFilter filter : filters) {
				this.filters.add(filter);
			}
		}
		
		@Override
		public boolean isStartParameter(Callable method, Maybe<Integer> parameter) {
			for(ParameterFilter filter : this.filters) {
				if(!filter.isStartParameter(method, parameter)) {
					return false;
				}
			}
			return true;
		}
		
		@Override
		public boolean isInternalParameter(Callable curMethod, Maybe<Integer> curParameter, Maybe<Integer> parameter) {
			for(ParameterFilter filter : this.filters) {
				if(!filter.isInternalParameter(curMethod, curParameter, parameter)) {
					return false;
				}
			}
			return true;
		}
		
		@Override
		public boolean isExternalParameter(Callable curMethod, Maybe<Integer> curParameter, Callable method, Maybe<Integer> parameter) {
			for(ParameterFilter filter : this.filters) {
				if(!filter.isExternalParameter(curMethod, curParameter, method, parameter)) {
					return false;
				}
			}
			return true;
		}
		
		@Override
		public boolean isEnd(Callable startMethod, Maybe<Integer> startParameter, Callable curMethod, Maybe<Integer> curParameter, int size, boolean end) {
			for(ParameterFilter filter : this.filters) {
				if(!filter.isEnd(startMethod, startParameter, curMethod, curParameter, size, end)) {
					return false;
				}
			}
			return true;
		}
	}
	
	public static class AtlasTargetParameterFilter implements ParameterFilter {
		private static boolean check(Callable method) {
			if(method instanceof AtlasMethod) {
				return Settings.ATLAS_TARGET_SET.contains(((AtlasMethod)method).klass.getName());
			} else if(method instanceof AtlasConstructor) {
				return Settings.ATLAS_TARGET_SET.contains(Settings.ATLAS_TARGET_SET.contains(method.getDeclaringClass()));
			} else if(method instanceof AtlasArray) {
				return true;
			} else {
				throw new RuntimeException();
			}
		}
		
		@Override
		public boolean isStartParameter(Callable method, Maybe<Integer> parameter) {
			return check(method);
		}

		@Override
		public boolean isInternalParameter(Callable curMethod, Maybe<Integer> curParameter, Maybe<Integer> parameter) {
			return true;
		}

		@Override
		public boolean isExternalParameter(Callable curMethod, Maybe<Integer> curParameter, Callable method, Maybe<Integer> parameter) {
			return !parameter.hasT() || parameter.getT() == 0 || check(method);
		}

		@Override
		public boolean isEnd(Callable startMethod, Maybe<Integer> startParameter, Callable curMethod, Maybe<Integer> curParameter, int size, boolean end) {
			return true;
		}
	}
	
	// external methods must have matching bindings
	public static class BindingParameterFilter implements ParameterFilter {
		@Override
		public boolean isStartParameter(Callable method, Maybe<Integer> parameter) {
			return true;
		}
		
		@Override
		public boolean isInternalParameter(Callable curMethod, Maybe<Integer> curParameter, Maybe<Integer> parameter) {
			return true;
		}
		
		@Override
		public boolean isExternalParameter(Callable curMethod, Maybe<Integer> curParameter, Callable method, Maybe<Integer> parameter) {
			if(ReflectionUtils.hasRawBindings(method)) {
				return true;
			} else {
				return !curParameter.hasT() && parameter.hasT() && parameter.getT() == 0 && ReflectionUtils.hasMatchingBindings(curMethod, method);
			}
		}

		@Override
		public boolean isEnd(Callable startMethod, Maybe<Integer> startParameter, Callable curMethod, Maybe<Integer> curParameter, int size, boolean end) {
			return true;
		}
	}
	
	// no external edges connecting return to return
	public static class NoExternalReturnReturnParameterFilter implements ParameterFilter {
		@Override
		public boolean isStartParameter(Callable method, Maybe<Integer> parameter) {
			return true;
		}
		
		@Override
		public boolean isInternalParameter(Callable curMethod, Maybe<Integer> curParameter, Maybe<Integer> parameter) {
			return true;
		}
		
		@Override
		public boolean isExternalParameter(Callable curMethod, Maybe<Integer> curParameter, Callable method, Maybe<Integer> parameter) {
			return curParameter.hasT() || parameter.hasT();
		}

		@Override
		public boolean isEnd(Callable startMethod, Maybe<Integer> startParameter, Callable curMethod, Maybe<Integer> curParameter, int size, boolean end) {
			return true;
		}
	}
	
	// no abstract method start (method declaring class, rather than method)
	// no external abstract method unless the parameter is the receiver
	public static class NoAbstractMethodFilter implements MethodFilter {
		@Override
		public boolean isStartMethod(Callable method) {
			return !Modifier.isAbstract(method.getDeclaringClass().getModifiers()) || (method instanceof AtlasArray);
		}
		
		@Override
		public boolean isExternalMethod(Callable curMethod, Maybe<Integer> curParameter, Callable method) {
			return true;
		}
	}
	public static class NoAbstractMethodParameterFilter implements ParameterFilter {
		@Override
		public boolean isStartParameter(Callable method, Maybe<Integer> parameter) {
			return true;
		}
		@Override
		public boolean isInternalParameter(Callable curMethod, Maybe<Integer> curParameter, Maybe<Integer> parameter) {
			return true;
		}

		@Override
		public boolean isExternalParameter(Callable curMethod, Maybe<Integer> curParameter, Callable method, Maybe<Integer> parameter) {
			return !Modifier.isAbstract(method.getDeclaringClass().getModifiers()) // method is not abstract
					|| method.isStatic()                                           // method is not abstract
					|| (method instanceof AtlasArray)                              // method is not abstract (atlas array)
					|| (parameter.hasT() && parameter.getT() == 0);                // parameter is receiver
		}
		
		@Override
		public boolean isEnd(Callable startMethod, Maybe<Integer> startParameter, Callable curMethod, Maybe<Integer> curParameter, int size, boolean end) {
			return true;
		}
	}
	
	// no (external) method loops
	public static class NoLoopMethodFilter implements MethodFilter {
		@Override
		public boolean isStartMethod(Callable method) {
			return true;
		}
		
		@Override
		public boolean isExternalMethod(Callable curMethod, Maybe<Integer> curParameter, Callable method) {
			return !curMethod.equals(method);
		}
	}
	
	// no (internal) parameter loops
	public static class NoLoopParameterFilter implements ParameterFilter {
		@Override
		public boolean isStartParameter(Callable method, Maybe<Integer> parameter) {
			return true;
		}
		
		@Override
		public boolean isInternalParameter(Callable curMethod, Maybe<Integer> curParameter, Maybe<Integer> parameter) {
			return !parameter.equals(curParameter);
		}
		
		@Override
		public boolean isExternalParameter(Callable curMethod, Maybe<Integer> curParameter, Callable method, Maybe<Integer> parameter) {
			return true;
		}
		
		@Override
		public boolean isEnd(Callable startMethod, Maybe<Integer> startParameter, Callable curMethod, Maybe<Integer> curParameter, int size, boolean end) {
			return true;
		}
	}
	
	// no start returns
	public static class NoStartReturnParameterFilter implements ParameterFilter {
		@Override
		public boolean isStartParameter(Callable method, Maybe<Integer> parameter) {
			return parameter.hasT();
		}
		
		@Override
		public boolean isInternalParameter(Callable curMethod, Maybe<Integer> curParameter, Maybe<Integer> parameter) {
			return true;
		}
		
		@Override
		public boolean isExternalParameter(Callable curMethod, Maybe<Integer> curParameter, Callable method, Maybe<Integer> parameter) {
			return true;
		}

		@Override
		public boolean isEnd(Callable startMethod, Maybe<Integer> startParameter, Callable curMethod, Maybe<Integer> curParameter, int size, boolean end) {
			return true;
		}
	}
	
	// no start receiver
	public static class NoStartReceiverParameterFilter implements ParameterFilter {
		@Override
		public boolean isStartParameter(Callable method, Maybe<Integer> parameter) {
			return method.isStatic() || (!parameter.hasT() || parameter.getT() != 0);
		}
		
		@Override
		public boolean isInternalParameter(Callable curMethod, Maybe<Integer> curParameter, Maybe<Integer> parameter) {
			return true;
		}
		
		@Override
		public boolean isExternalParameter(Callable curMethod, Maybe<Integer> curParameter, Callable method, Maybe<Integer> parameter) {
			return true;
		}

		@Override
		public boolean isEnd(Callable startMethod, Maybe<Integer> startParameter, Callable curMethod, Maybe<Integer> curParameter, int size, boolean end) {
			return true;
		}
	}
	
	// no external returns
	public static class NoExternalReturnParameterFilter implements ParameterFilter {
		public boolean isStartParameter(Callable method, Maybe<Integer> parameter) {
			return true;
		}
		
		@Override
		public boolean isInternalParameter(Callable curMethod, Maybe<Integer> curParameter, Maybe<Integer> parameter) {
			return true;
		}
		
		@Override
		public boolean isExternalParameter(Callable curMethod, Maybe<Integer> curParameter, Callable method, Maybe<Integer> parameter) {
			return parameter.hasT();
		}

		@Override
		public boolean isEnd(Callable startMethod, Maybe<Integer> startParameter, Callable curMethod, Maybe<Integer> curParameter, int size, boolean end) {
			return true;
		}
	}
	
	// internal edges must be parameter -> receiver, parameter -> return, or receiver -> return
	// in particular, no receiver -> parameter or parameter -> parameter
	public static class ReceiverOnlyParameterFilter implements ParameterFilter {
		@Override
		public boolean isStartParameter(Callable method, Maybe<Integer> parameter) {
			return true;
		}
		
		@Override
		public boolean isInternalParameter(Callable curMethod, Maybe<Integer> curParameter, Maybe<Integer> parameter) {
			return !parameter.hasT() || (!curMethod.isStatic() && parameter.getT() == 0);
		}
		
		@Override
		public boolean isExternalParameter(Callable curMethod, Maybe<Integer> curParameter, Callable method, Maybe<Integer> parameter) {
			return parameter.hasT() && parameter.getT() == 0 ? method.hasObjectReturn() : true;
		}
		
		@Override
		public boolean isEnd(Callable startMethod, Maybe<Integer> startParameter, Callable curMethod, Maybe<Integer> curParameter, int size, boolean end) {
			return true;
		}
	}
	
	// external edges must be return -> receiver
	public static class StrictReceiverOnlyParameterFilter implements ParameterFilter {
		@Override
		public boolean isStartParameter(Callable method, Maybe<Integer> parameter) {
			return true;
		}
		
		@Override
		public boolean isInternalParameter(Callable curMethod, Maybe<Integer> curParameter, Maybe<Integer> parameter) {
			return !parameter.hasT() || (!curMethod.isStatic() && parameter.getT() == 0);
		}
		
		@Override
		public boolean isExternalParameter(Callable curMethod, Maybe<Integer> curParameter, Callable method, Maybe<Integer> parameter) {
			return !method.isStatic() && parameter.hasT() && parameter.getT() == 0 && method.hasObjectReturn();
		}
		
		@Override
		public boolean isEnd(Callable startMethod, Maybe<Integer> startParameter, Callable curMethod, Maybe<Integer> curParameter, int size, boolean end) {
			return true;
		}
	}
	
	public static class TypeEqualityParameterFilter implements ParameterFilter {
		@Override
		public boolean isStartParameter(Callable method, Maybe<Integer> parameter) {
			return true;
		}
		
		@Override
		public boolean isInternalParameter(Callable curMethod, Maybe<Integer> curParameter, Maybe<Integer> parameter) {
			return true;
		}
		
		@Override
		public boolean isExternalParameter(Callable curMethod, Maybe<Integer> curParameter, Callable method, Maybe<Integer> parameter) {
			Class<?> curType = Constants.isClone(curMethod) && !curParameter.hasT() ? curMethod.getDeclaringClass() : curMethod.getParameterType(curParameter);
			Class<?> type = method.getParameterType(parameter);
			if(curType.equals(Object.class) || type.equals(Object.class)) {
				return curType.equals(type);
			} else if(method.isStatic() || (parameter.hasT() && parameter.getT() != 0)) {
				 return method.getParameterType(parameter).isAssignableFrom(curType);
			} else {
				return method.getParameterType(parameter).equals(curType);
			}
		}
		
		@Override
		public boolean isEnd(Callable startMethod, Maybe<Integer> startParameter, Callable curMethod, Maybe<Integer> curParameter, int size, boolean end) {
			return !end || curMethod.getReturnType().isAssignableFrom(startMethod.getParameterType(startParameter));
		}
	}
	
	public static class EarlyStoppingMethodFilter implements MethodFilter {
		private final ParameterLookup lookup;
		public EarlyStoppingMethodFilter(ParameterLookup lookup) {
			this.lookup = lookup;
		}
		
		@Override
		public boolean isStartMethod(Callable method) {
			return !this.lookup.getStartParameters(method).isEmpty();
		}
		
		@Override
		public boolean isExternalMethod(Callable curMethod, Maybe<Integer> curParameter, Callable method) {
			return !this.lookup.getExternalParameters(curMethod, curParameter, method).isEmpty();
		}
	}
	
	public static class BoundedParameterFilter implements ParameterFilter {
		private final int bound;
		public BoundedParameterFilter(int bound) {
			this.bound = bound;
		}
		
		@Override
		public boolean isStartParameter(Callable startMethod, Maybe<Integer> startParameter) {
			return true;
		}

		@Override
		public boolean isInternalParameter(Callable curMethod, Maybe<Integer> curParameter, Maybe<Integer> internalParameter) {
			return true;
		}

		@Override
		public boolean isEnd(Callable startMethod, Maybe<Integer> startParameter, Callable curMethod, Maybe<Integer> curParameter, int size, boolean end) {
			return end || size < this.bound;
		}
		
		@Override
		public boolean isExternalParameter(Callable curMethod, Maybe<Integer> curParameter, Callable externalMethod, Maybe<Integer> externalParameter) {
			return true;
		}
	}
}
