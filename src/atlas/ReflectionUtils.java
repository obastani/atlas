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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import atlas.ReflectionTypeUtils.AtlasType;
import atlas.ReflectionTypeUtils.AtlasTypeBindings;
import atlas.Utils.Filter;
import atlas.Utils.Maybe;

public class ReflectionUtils {
	public static interface Callable {
		public abstract boolean hasObjectReturn();
		public abstract Class<?> getParameterType(Maybe<Integer> parameter);
		public abstract Class<?> getReturnType();
		public abstract boolean isStatic();
		public abstract List<Maybe<Integer>> getAllObjectParameters();
		public abstract Class<?> getDeclaringClass();
		public abstract String getString();
		public abstract int getParameterCount();
		public abstract Object invoke(Object receiver, Object[] parameters);
		public abstract Class<?>[] getRawParameterTypes();
		public abstract String getName();
		public abstract Callable getVersionForClass(Class<?> receiver);
		public abstract String toGenericString();
		public abstract boolean isConcreteDeclaringClass();
	}
	
	public static class AtlasMethod implements Callable {
		public final Method method;
		public final Class<?> klass;
		public final AtlasTypeBindings bindings;
		public final boolean hasRawBindings;
		private static AtlasTypeBindings getRawBindings(Method method) {
			return ReflectionTypeUtils.getBindings(method.getDeclaringClass());
		}
		public AtlasMethod(Method method, Class<?> klass, AtlasTypeBindings bindings) {
			this.method = method;
			this.klass = klass;
			this.bindings = bindings;
			this.hasRawBindings = this.bindings.equals(getRawBindings(this.method));
		}
		public AtlasMethod(Method method, Class<?> klass) {
			this.method = method;
			this.klass = klass;
			this.bindings = getRawBindings(this.method);
			this.hasRawBindings = true;
		}
		public boolean hasObjectReturn() {
			return !this.method.getReturnType().isPrimitive();
		}
		public Class<?> getParameterType(Maybe<Integer> parameter) {
			return ReflectionUtils.getParameterType(this, parameter);
		}
		public Class<?> getReturnType() {
			return ReflectionTypeUtils.getAtlasType(this.method.getGenericReturnType(), this.bindings).getBaseType();
		}
		public boolean isStatic() {
			return Modifier.isStatic(this.method.getModifiers());
		}
		public List<Maybe<Integer>> getAllObjectParameters() {
			return ReflectionUtils.getAllObjectParameters(this);
		}
		public Class<?> getDeclaringClass() {
			return this.klass;
		}
		public String getString() {
			return ReflectionUtils.toString(this);
		}
		public int getParameterCount() {
			return this.method.getParameterTypes().length + (this.isStatic() ? 0 : 1);
		}
		public Object invoke(Object receiver, Object[] parameters) {
			try {
				return this.method.invoke(receiver, parameters);
			} catch(Exception e) {
				throw new RuntimeException(e);
			}
		}
		public Class<?>[] getRawParameterTypes() {
			return this.method.getParameterTypes();
		}
		public String getName() {
			return this.method.getName();
		}
		public Callable getVersionForClass(Class<?> receiver) {
			try {
				return new AtlasMethod(receiver.getMethod(this.method.getName(), this.method.getParameterTypes()), receiver);
			} catch(Exception e) {
				throw new RuntimeException(e);
			}
		}
		public Callable getVersionForClass(AtlasType receiver) {
			try {
				return new AtlasMethod(receiver.getBaseType().getMethod(this.method.getName(), this.method.getParameterTypes()), receiver.getBaseType(), this.bindings);
			} catch(Exception e) {
				throw new RuntimeException(e);
			}
		}
		public String toGenericString() {
			return this.method.toGenericString();
		}
		public boolean isConcreteDeclaringClass() {
			return !ReflectionUtils.isConcreteDeclaringClass(this.method);
		}
		@Override
		public int hashCode() {
			return 31*(31*this.method.hashCode() + this.klass.hashCode()) + this.bindings.hashCode();
		}
		@Override
		public boolean equals(Object obj) {
			if(!(obj instanceof AtlasMethod)) {
				return false;
			}
			AtlasMethod other = (AtlasMethod)obj;
			return this.method.equals(other.method) && this.klass.equals(other.klass) && this.bindings.equals(other.bindings);
		}
		@Override
		public String toString() {
			return getString();
		}
	}
	
	public static class AtlasConstructor implements Callable {
		public final Constructor<?> constructor;
		public boolean hasObjectReturn() {
			return Settings.CONSTRUCTOR_HAS_OBJECT_RETURN;
		}
		public Class<?> getParameterType(Maybe<Integer> parameter) {
			return ReflectionUtils.getParameterType(this, parameter);
		}
		public Class<?> getReturnType() {
			return this.constructor.getDeclaringClass();
		}
		public boolean isStatic() {
			return Settings.IS_CONSTRUCTOR_STATIC;
		}
		public List<Maybe<Integer>> getAllObjectParameters() {
			return ReflectionUtils.getAllObjectParameters(this);
		}
		public Class<?> getDeclaringClass() {
			return this.constructor.getDeclaringClass();
		}
		public String getString() {
			return ReflectionUtils.toString(this);
		}
		public int getParameterCount() {
			return this.constructor.getParameterTypes().length;
		}
		public Object invoke(Object receiver, Object[] parameters) {
			if(receiver != null) {
				throw new RuntimeException();
			}
			try {
				return this.constructor.newInstance(parameters);
			} catch(Exception e) {
				throw new RuntimeException(e);
			}
		}
		public Class<?>[] getRawParameterTypes() {
			return this.constructor.getParameterTypes();
		}
		public String getName() {
			return this.getDeclaringClass().getSimpleName();
		}
		public Callable getVersionForClass(Class<?> receiver) {
			try {
				return new AtlasConstructor(receiver.getConstructor(this.constructor.getParameterTypes()));
			} catch(Exception e) {
				throw new RuntimeException(e);
			}
		}
		public String toGenericString() {
			return this.constructor.toGenericString();
		}
		public AtlasConstructor(Constructor<?> constructor) {
			this.constructor = constructor;
		}
		public boolean isConcreteDeclaringClass() {
			return ReflectionUtils.isConcreteDeclaringClass(this.constructor);
		}
		@Override
		public int hashCode() {
			return this.constructor.hashCode();
		}
		@Override
		public boolean equals(Object obj) {
			if(!(obj instanceof AtlasConstructor)) {
				return false;
			}
			AtlasConstructor other = (AtlasConstructor)obj;
			return this.constructor.equals(other.constructor);
		}
		@Override
		public String toString() {
			return this.getString();
		}
	}
	
	public static class AtlasArray implements Callable {
		public final Class<?> componentType;
		public final boolean isStore;
		public AtlasArray(Class<?> componentType, boolean isStore) {
			this.componentType = componentType;
			this.isStore = isStore;
		}
		public boolean hasObjectReturn() {
			return !this.isStore && !this.componentType.isPrimitive();
		}
		public Class<?> getParameterType(Maybe<Integer> parameter) {
			return ReflectionUtils.getParameterType(this, parameter);
		}
		public Class<?> getReturnType() {
			return this.isStore ? void.class : this.componentType;
		}
		public boolean isStatic() {
			return Settings.IS_ARRAY_STATIC;
		}
		public List<Maybe<Integer>> getAllObjectParameters() {
			return ReflectionUtils.getAllObjectParameters(this);
		}
		public Class<?> getDeclaringClass() {
			return Array.newInstance(this.componentType, 0).getClass();
		}
		public String getString() {
			return ReflectionUtils.toString(this);
		}
		public int getParameterCount() {
			return this.isStore ? 2 : 1;
		}
		public Object invoke(Object receiver, Object[] parameters) {
			try {
				if(this.isStore) {
					if(parameters.length != 1) {
						throw new RuntimeException();
					}
					Array.set(receiver, 0, parameters[0]);
					return null;
				} else {
					if(parameters.length != 0) {
						throw new RuntimeException();
					}
					return Array.get(receiver, 0);
				}
			} catch(Exception e) {
				throw new RuntimeException(e);
			}
		}
		public Class<?>[] getRawParameterTypes() {
			return this.isStore ? new Class[]{this.componentType} : new Class[]{};
		}
		public String getName() {
			return this.isStore ? Settings.ARRAY_STORE_NAME : Settings.ARRAY_LOAD_NAME;
		}
		public Callable getVersionForClass(Class<?> receiver) {
			try {
				if(!receiver.isArray()) {
					throw new RuntimeException();
				}
				if(!receiver.getComponentType().equals(this.componentType)) {
					Log.info("UNEQUAL COMPONENT TYPES: " + receiver.getComponentType().toString() + " vs. " + this.componentType.toString());
				}
				if(!this.componentType.isAssignableFrom(receiver.getComponentType())) {
					throw new RuntimeException();
				}
				return this;
			} catch(Exception e) {
				throw new RuntimeException(e);
			}
		}
		public String toGenericString() {
			throw new RuntimeException();
		}
		public boolean isConcreteDeclaringClass() {
			return true;
		}
		@Override
		public int hashCode() {
			return 31*this.componentType.hashCode() + Boolean.hashCode(this.isStore);
		}
		@Override
		public boolean equals(Object obj) {
			if(!(obj instanceof AtlasArray)) {
				return false;
			}
			AtlasArray other = (AtlasArray)obj;
			return this.componentType.equals(other.componentType) && this.isStore == other.isStore;
		}
		@Override
		public String toString() {
			return getString();
		}
	}
	
	private static List<Maybe<Integer>> getAllObjectParameters(Callable method) {
		List<Maybe<Integer>> parameters = new ArrayList<Maybe<Integer>>();
		if(!method.isStatic()) {
			parameters.add(new Maybe<Integer>(0));
		}
		for(int i=0; i<method.getRawParameterTypes().length; i++) {
			if(!method.getRawParameterTypes()[i].isPrimitive()) {
				parameters.add(new Maybe<Integer>(i + (method.isStatic() ? 0 : 1)));
			}
		}
		if(method.hasObjectReturn()) {
			parameters.add(new Maybe<Integer>());
		}
		return parameters;
	}
	
	private static Class<?> getParameterType(Callable method, Maybe<Integer> parameter) {
		if(!parameter.hasT()) {
			return method.getReturnType();
		} else if(method.isStatic()) {
			return method.getRawParameterTypes()[parameter.getT()];
		} else if(parameter.getT() == 0) {
			return method.getDeclaringClass();
		} else {
			return method.getRawParameterTypes()[parameter.getT()-1];
		}
	}
	
	public static boolean isConcrete(Class<?> klass) {
		return !klass.isInterface() && !Modifier.isAbstract(klass.getModifiers());
	}
	
	public static boolean isConcreteDeclaringClass(Constructor<?> constructor) {
		return isConcrete(constructor.getDeclaringClass());
	}
	
	public static boolean isConcreteDeclaringClass(Method method) {
		return isConcrete(method.getDeclaringClass());
	}
	
	public static List<Class<?>> getClasses(Filter<String> filter, boolean isConcrete, boolean isPublic) {
		try {
			Set<Class<?>> classes = new HashSet<Class<?>>();
			for(String filename : Settings.CLASS_LIST_FILES) {
				BufferedReader br = new BufferedReader(new FileReader(filename));
				String line;
				while((line = br.readLine()) != null) {
					if(!filter.filter(line)) {
						continue;
					}
					Class<?> klass;
					try {
						klass = Class.forName(line);
					} catch(Throwable e) {
						Log.info("MISSING CLASS: " + line);
						continue;
					}
					try {
						klass.getDeclaredMethods();
					} catch(Throwable e) {
						Log.info("UNABLE TO LOAD METHODS: " + line);
					}
					if(isPublic && !Modifier.isPublic(klass.getModifiers())) {
						continue;
					}
					if(isConcrete && !isConcrete(klass)) {
						continue;
					}
					classes.add(klass);
				}
				br.close();
			}
			return new ArrayList<Class<?>>(classes);
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static List<Callable> getMethods(Class<?> klass) {
		List<Callable> methods = new ArrayList<Callable>();
		for(Method method : klass.getMethods()) {
			methods.add(new AtlasMethod(method, klass));
		}
		for(Constructor<?> constructor : klass.getConstructors()) {
			methods.add(new AtlasConstructor(constructor));
		}
		return methods;
	}
	
	public static List<Callable> getMethods(List<Class<?>> classes) {
		Set<Callable> methods = new HashSet<Callable>();
		for(Class<?> klass : classes) {
			methods.addAll(getMethods(klass));
		}
		return new ArrayList<Callable>(methods);
	}
	
	private static List<AtlasMethod> getMethods(Class<?> klass, AtlasTypeBindings bindings) {
		List<AtlasMethod> methods = new ArrayList<AtlasMethod>();
		for(Method method : klass.getMethods()) {
			methods.add(new AtlasMethod(method, klass, bindings));
		}
		return methods;
	}
	
	public static boolean hasRawBindings(Callable method) {
		return !(method instanceof AtlasMethod) || ((AtlasMethod)method).hasRawBindings;
	}
	
	public static boolean hasMatchingBindings(Callable curMethod, Callable method) {
		if(curMethod instanceof AtlasMethod && method instanceof AtlasMethod) {
				AtlasMethod atlasMethod = (AtlasMethod)method;
				AtlasMethod curAtlasMethod = (AtlasMethod)curMethod;
				return atlasMethod.bindings.equals(ReflectionTypeUtils.getBindings(curAtlasMethod.method.getGenericReturnType(), curAtlasMethod.bindings));
		} else {
			return false;
		}
	}
	
	private static List<Callable> getClosure(List<Callable> methods, List<Class<?>> classes) {
		List<Callable> newMethods = new ArrayList<Callable>(methods);
		Set<Callable> methodSet = new HashSet<Callable>(methods);
		Set<Class<?>> classSet = new HashSet<Class<?>>(classes);
		LinkedList<Callable> worklist = new LinkedList<Callable>(methods);
		while(!worklist.isEmpty()) {
			Callable method = worklist.removeFirst();
			if(!(method instanceof AtlasMethod)) {
				continue;
			}
			AtlasMethod atlasMethod = (AtlasMethod)method;
			for(AtlasMethod newMethod : getMethods(atlasMethod.method.getReturnType(), ReflectionTypeUtils.getBindings(atlasMethod.method.getGenericReturnType(), atlasMethod.bindings))) {
				if(methodSet.contains(newMethod)) {
					continue;
				}
				if(!classSet.contains(newMethod.getDeclaringClass())) {
					continue;
				}
				if(ReflectionTypeUtils.getBindings(newMethod.method.getGenericReturnType(), newMethod.bindings).variables().isEmpty()) {
					continue;
				}
				Log.info("ADDING: " + newMethod + ", " + newMethod.getReturnType().getName() + ", " + newMethod.bindings);
				newMethods.add(newMethod);
				methodSet.add(newMethod);
				worklist.add(newMethod);
			}
		}
		return newMethods;
	}
	
	// arrays
	// generics
	public static List<Callable> getCompleteMethods(Filter<String> classFilter, boolean isConcrete, boolean isPublic) {
		List<Class<?>> classes = getClasses(classFilter, isConcrete, isPublic);
		List<Callable> methods = getMethods(classes);
		List<Callable> methodsWithArray = new ArrayList<Callable>(methods);
		for(Callable method : methods) {
			if(method.getName().equals(Settings.ARRAY_LOAD_NAME) || method.getName().equals(Settings.ARRAY_STORE_NAME)) {
				throw new RuntimeException();
			}
			if(method.getReturnType().isArray()) {
				methodsWithArray.add(new AtlasArray(method.getReturnType().getComponentType(), false));
			}
			for(Class<?> parameter : method.getRawParameterTypes()) {
				if(parameter.isArray()) {
					methodsWithArray.add(new AtlasArray(parameter.getComponentType(), true));
				}
			}
		}
		return getClosure(methods, classes);
	}
	
	public static boolean isAtlasRoot(Class<?> klass) {
		for(String root : Settings.ATLAS_ROOTS) {
			if(klass.getName().startsWith(root)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isAtlasTarget(Class<?> klass) {
		if(klass.equals(Object.class)) {
			return false;
		}
		for(String target : Settings.ATLAS_TARGETS) {
			if(klass.getName().startsWith(target)) {
				return true;
			}
		}
		return false;
	}
	
	public static String toString(Class<?> klass, boolean usePrefix, boolean replaceEnclosed) {
		if(klass.isPrimitive()) {
			if(klass.equals(boolean.class)) {
				return "boolean";
			} else if(klass.equals(byte.class)) {
				return "byte";
			} else if(klass.equals(char.class)) {
				return "char";
			} else if(klass.equals(short.class)) {
				return "short";
			} else if(klass.equals(int.class)) {
				return "int";
			} else if(klass.equals(long.class)) {
				return "long";
			} else if(klass.equals(float.class)) {
				return "float";
			} else if(klass.equals(double.class)) {
				return "double";
			} else if(klass.equals(void.class)) {
				return "void";
			} else {
				throw new RuntimeException();
			}
		} else if(klass.isArray()) {
			return toString(klass.getComponentType(), usePrefix, replaceEnclosed) + "[]";
		} else {
			return (usePrefix && isAtlasTarget(klass) ? Settings.NAME_PREFIX + "." : "") + (replaceEnclosed ? klass.getName().replace('$', '.') : klass.getName());
		}
	}
	
	public static String toStringWithAnonymous(Class<?> klass, Map<Class<?>,Integer> anonymousClassNames, boolean usePrefix, boolean replaceEnclosing) {
		if(klass.isAnonymousClass()) {
			if(!anonymousClassNames.containsKey(klass)) {
				Log.info("MISSING ANONYMOUS CLASS: " + klass.toGenericString());
				return klass.getName().replace('$', '.');
			} else {
				return Settings.ANONYMOUS_PREFIX + anonymousClassNames.get(klass);
			}
		} else {
			return toString(klass, usePrefix, replaceEnclosing);
		}
	}
	
	public static String toString(Callable method) {
		StringBuilder sb = new StringBuilder();
		sb.append(method.getDeclaringClass().isArray() ? method.getDeclaringClass().getComponentType().getName() : method.getDeclaringClass().getName());
		sb.append(".").append(method.getName()).append("(");
		for(int i=0; i<method.getRawParameterTypes().length; i++) {
			sb.append(toString(method.getRawParameterTypes()[i], false, false)).append(",");
		}
		if(method.getRawParameterTypes().length > 0) {
			sb.deleteCharAt(sb.length()-1);
		}
		sb.append(")");
		return sb.toString();
	}
	
	public static Class<?> parseClass(String str) {
		if(str.equals("boolean")) {
			return boolean.class;
		} else if(str.equals("byte")) {
			return byte.class;
		} else if(str.equals("char")) {
			return char.class;
		} else if(str.equals("short")) {
			return short.class;
		} else if(str.equals("int")) {
			return int.class;
		} else if(str.equals("long")) {
			return long.class;
		} else if(str.equals("float")) {
			return float.class;
		} else if(str.equals("double")) {
			return double.class;
		} else if(str.endsWith("[]")) {
			return Array.newInstance(parseClass(str.substring(0, str.length()-2)), 0).getClass();
		} else {
			try {
				return Class.forName(str);
			} catch(ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public static Callable parseMethod(String str) {
		// classname.methodname(parameter,...,parameter)
		if(!str.endsWith(")")) {
			throw new RuntimeException();
		}
		str = str.substring(0, str.length()-1);
		String[] tokens = str.split("\\(");
		if(tokens.length == 0 || tokens.length > 2) {
			throw new RuntimeException();
		}
		
		// [class, name, methodname]
		String[] nameTokens = tokens[0].split("\\.");
		if(nameTokens.length < 2) {
			throw new RuntimeException();
		}
		StringBuilder classNameSb = new StringBuilder();
		for(int i=0; i<nameTokens.length-1; i++) {
			classNameSb.append(nameTokens[i]).append(".");
		}
		String className = classNameSb.deleteCharAt(classNameSb.length()-1).toString();
		String methodName = nameTokens[nameTokens.length-1];
		
		// [parameter, ..., parameter]
		String[] parameterNames = tokens.length == 2 ? tokens[1].split(",") : new String[0];
		Class<?>[] parameterTypes = new Class[parameterNames.length];
		
		try {
			Class<?> klass = parseClass(className);
			for(int i=0; i<parameterNames.length; i++) {
				parameterTypes[i] = parseClass(parameterNames[i]);
			}
			if(methodName.equals(klass.getSimpleName())) {
				return new AtlasConstructor(klass.getConstructor(parameterTypes));
			} else if(methodName.equals(Settings.ARRAY_STORE_NAME)) {
				return new AtlasArray(klass, true);
			} else if(methodName.equals(Settings.ARRAY_LOAD_NAME)) {
				return new AtlasArray(klass, false);
			} else {
				return new AtlasMethod(klass.getMethod(methodName, parameterTypes), klass);
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
