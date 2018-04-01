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
import java.util.Iterator;
import java.util.Set;

import atlas.AliasModelUtils.ParameterFilter;
import atlas.ReflectionUtils.AtlasMethod;
import atlas.ReflectionUtils.Callable;
import atlas.Utils.Maybe;

public class DebugUtils {
	public static class EntrySetParameterFilter implements ParameterFilter {
		@Override
		public boolean isStartParameter(Callable method, Maybe<Integer> parameter) {
			if(method.getDeclaringClass().equals(HashMap.class)
					&& method.getName().equals("put")
					&& parameter.hasT()
					&& parameter.getT() == 1) {
				return true;
			}
			return false;
		}
		
		@Override
		public boolean isInternalParameter(Callable curMethod, Maybe<Integer> curParameter, Maybe<Integer> parameter) {
			if(curMethod.getName().equals("put")) {
				return parameter.hasT() && parameter.getT() == 0;
			}
			return true;
		}
		
		@Override
		public boolean isExternalParameter(Callable curMethod, Maybe<Integer> curParameter, Callable method, Maybe<Integer> parameter) {
			if(curMethod.getDeclaringClass().equals(HashMap.class)
					&& curMethod.getName().equals("put")
					&& curParameter.hasT()
					&& curParameter.getT() == 0
					&& method.getName().equals("entrySet")
					&& parameter.hasT()
					&& parameter.getT() == 0) {
				return true;
			}
			if(curMethod.getDeclaringClass().equals(HashMap.class)
					&& curMethod.getName().equals("entrySet")
					&& !curParameter.hasT()
					&& method.getName().equals("iterator")
					&& parameter.hasT()
					&& parameter.getT() == 0
					&& !((AtlasMethod)method).bindings.variables().isEmpty()) {
				return true;
			}
			if(curMethod.getDeclaringClass().equals(Set.class)
					&& curMethod.getName().equals("iterator")
					&& !curParameter.hasT()
					&& method.getName().equals("next")
					&& parameter.hasT()
					&& parameter.getT() == 0
					&& !((AtlasMethod)curMethod).bindings.variables().isEmpty()
					&& !((AtlasMethod)method).bindings.variables().isEmpty()) {
				return true;
			}
			if(curMethod.getDeclaringClass().equals(Iterator.class)
					&& curMethod.getName().equals("next")
					&& !curParameter.hasT()
					&& method.getName().equals("getKey")
					&& parameter.hasT()
					&& parameter.getT() == 0) {
				return true;
			}
			return false;
		}

		@Override
		public boolean isEnd(Callable startMethod, Maybe<Integer> startParameter, Callable curMethod, Maybe<Integer> curParameter, int size, boolean end) {
			return !end || !curMethod.getName().equals("put");
		}
	}
}
