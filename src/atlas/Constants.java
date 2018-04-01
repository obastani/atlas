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

import java.lang.reflect.Constructor;

import atlas.ReflectionUtils.AtlasMethod;
import atlas.ReflectionUtils.Callable;

public class Constants {
	public static boolean isClone(Callable callable) {
		return callable instanceof AtlasMethod && callable.getRawParameterTypes().length == 0 && callable.getName().equals("clone");
	}
	private static Constructor<?> emptyStringConstructor = null;
	public static Constructor<?> getEmptyStringConstructor() {
		if(emptyStringConstructor == null) {
			try {
				emptyStringConstructor = String.class.getConstructor();
			} catch(Exception e) {
				throw new RuntimeException(e);
			}
		}
		return emptyStringConstructor;
	}
}
