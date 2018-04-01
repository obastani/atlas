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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import atlas.AliasModelUtils.AliasModel;
import atlas.AliasModelUtils.Trace;
import atlas.ObjectConstructorUtils.ConstructStatementConstructor;
import atlas.ReflectionUtils.AtlasArray;
import atlas.ReflectionUtils.AtlasConstructor;
import atlas.ReflectionUtils.AtlasMethod;
import atlas.ReflectionUtils.Callable;
import atlas.StatementModelUtils.StatementModel;
import atlas.Utils.Maybe;
import atlas.Utils.MultivalueMap;
import atlas.Utils.Pair;

public class SourceUtils {
	private static final boolean WRITE_EXCEPTIONS = false;
	private static final boolean WRITE_DEFAULT = false;
	private static final boolean WRITE_STATIC_INTERFACE = false;
	
	private static final String BUILD_FILE = "build.xml";
	private static final String BUILD_CONTENTS = "<project default=\"build\"><target name=\"build\"><mkdir dir=\"classes\"/><javac srcdir=\"src\" destdir=\"classes\"><compilerarg value=\"-XDignore.symbol.file\"/></javac></target></project>";
	
	private static final String[] ALL_ROOT_PACKAGES = new String[]{"java", "sun"};
	
	private static String toString(Maybe<Integer> variable, Maybe<Integer> field, boolean isStatic, Maybe<Class<?>> castType, Map<Class<?>,Integer> anonymousClassNames, boolean isConstructor) {
		StringBuilder sb = new StringBuilder();
		
		if(castType.hasT() != field.hasT()) {
			throw new RuntimeException();
		}
		
		if(castType.hasT()) {
			sb.append("((").append(ReflectionUtils.toStringWithAnonymous(castType.getT(), anonymousClassNames, true, true)).append(")");
		}
		
		// handle variable
		if(variable.hasT() && variable.getT() == 0 && !isStatic) {
			sb.append("this");
		} else if(variable.hasT() && !isStatic) {
			sb.append("p" + (variable.getT()-1));
		} else if(variable.hasT()) {
			sb.append("p" + variable.getT());
		} else if(isConstructor) {
			sb.append("this");
		} else {
			sb.append("r");
		}
		
		if(castType.hasT()) {
			sb.append(")");
		}
		
		// handle field
		if(field.hasT() && castType.hasT() && castType.getT().isArray()) {
			sb.append("[0]");
		} else if(field.hasT()) {
			sb.append(".f").append(field.getT());
		}
		
		return sb.toString();
	}
	
	private static String toString(StatementModel statement, boolean isStatic, Class<?> castType, Maybe<Class<?>> sourceCastType, Maybe<Class<?>> sinkCastType, Map<Class<?>,Integer> anonymousClassNames, boolean isToStringMethod, boolean isConstructor) {
		if(!statement.source.hasT()) {
			throw new RuntimeException();
		}
		String castString = "(" + ReflectionUtils.toStringWithAnonymous(castType, anonymousClassNames, !isToStringMethod, true) + ")";
		String sourceString =  castString + toString(statement.source, statement.sourceField, isStatic, sourceCastType, anonymousClassNames, isConstructor);
		String sinkString = toString(statement.sink, statement.sinkField, isStatic, sinkCastType, anonymousClassNames, isConstructor);
		return sinkString + " = " + sourceString + ";";
	}
	
	private static String getTypeName(Type type, Class<?> klass, boolean usePrefix) {
		return process(type.getTypeName(), usePrefix);
	}
	
	public static String process(String type, boolean usePrefix) {
		type = type.replace('$', '.');
		
		for(String root : ALL_ROOT_PACKAGES) {
			// [..., util.HashMap., util.HashMap...., ...]
			String[] tokens = type.split(root + "\\.");
			
			if(tokens.length <= 1) {
				continue;
			}
			
			List<Integer> indices = new ArrayList<Integer>();
			for(int i=1; i<tokens.length-1; i++) {
				if(!tokens[i].matches("[a-zA-z\\.]*")) {
					continue;
				}
				if(tokens[i].isEmpty()) {
					continue;
				}
				if(!tokens[i+1].startsWith(tokens[i].substring(0, tokens[i].length()-1))) {
					continue;
				}
				indices.add(i);
			}
			
			StringBuilder sb = new StringBuilder();
			
			for(int i=0; i<tokens.length-1; i++) {
				if(indices.contains(i)) {
					continue;
				}
				sb.append(tokens[i]).append(root).append(".");
			}
			sb.append(tokens[tokens.length-1]);
			
			type = sb.toString();
		}
		
		if(usePrefix) {
			for(String target : Settings.ATLAS_TARGETS) {
				if(type.contains("######")) {
					throw new RuntimeException();
				}
				type = type.replace("java.lang.Object", "######");
				type = type.replace(target, Settings.NAME_PREFIX + "." + target);
				type = type.replace("######", "java.lang.Object");
			}
		}
		
		return type;
	}
	
	private static boolean filterConstructor(Constructor<?> constructor, Set<Class<?>> allClassSet) {
		for(Class<?> klass : constructor.getParameterTypes()) {
			if(!allClassSet.contains(klass)) {
				return false;
			}
		}
		return true;
	}
	
	private static List<Constructor<?>> getDeclaredConstructors(Class<?> klass, Set<Class<?>> allClassSet) {
		Set<Constructor<?>> constructorSet = new LinkedHashSet<Constructor<?>>();
		for(Constructor<?> constructor : klass.getDeclaredConstructors()) {
			if(constructor.isSynthetic()) {
				continue;
			}
			if(!filterConstructor(constructor, allClassSet)) {
				continue;
			}
			if(constructor.getParameterTypes().length != constructor.getGenericParameterTypes().length) {
				Log.info("PARAMETER MISMATCH: " + constructor.toGenericString());
				continue;
			}
			try {
				constructorSet.add(klass.getDeclaredConstructor(constructor.getParameterTypes()));
			} catch(Exception e) {
				throw new RuntimeException(e);
			}
		}
		return new ArrayList<Constructor<?>>(constructorSet);
	}
	
	private static boolean filterClass(Class<?> klass, Set<Class<?>> allClassSet) {
		if(klass.isPrimitive()) {
			return true;
		} else if(klass.isArray()) {
			return filterClass(klass.getComponentType(), allClassSet);
		} else {
			return filterSingle(klass, allClassSet);
		}
	}
	
	private static boolean filterMethod(Method method, Set<Class<?>> allClassSet) {
		if(!filterClass(method.getReturnType(), allClassSet)) {
			return false;
		}
		for(Class<?> klass : method.getParameterTypes()) {
			if(!filterClass(klass, allClassSet)) {
				return false;
			}
		}
		return true;
	}
	
	private static List<Method> getDeclaredMethods(Class<?> klass, Set<Class<?>> allClassSet) {
		Set<Method> methodSet = new LinkedHashSet<Method>();
		for(Method method : klass.getDeclaredMethods()) {
			try {
				if(klass.isEnum() && (method.equals(klass.getMethod("values")) || method.equals(klass.getMethod("valueOf", String.class)))) {
					continue;
				}
				if(method.isSynthetic()) {
					continue;
				}
				if(!filterMethod(method, allClassSet)) {
					continue;
				}
				if(!WRITE_DEFAULT && method.isDefault()) {
					continue;
				}
				if(!WRITE_STATIC_INTERFACE && klass.isInterface() && Modifier.isStatic(method.getModifiers())) {
					continue;
				}
				methodSet.add(klass.getDeclaredMethod(method.getName(), method.getParameterTypes()));
			} catch(Exception e) {
				throw new RuntimeException(e);
			}
		}
		return new ArrayList<Method>(methodSet);
	}
	
	public static String toString(Constructor<?> constructor, Set<Class<?>> allClassSet) {
		StringBuilder sb = new StringBuilder();
		
		// public V java.util.HashMap.put(K,V)
		String str = process(constructor.toGenericString(), true);
		
		// [public V java.util.HashMap.put, K,V]
		String[] tokens = str.substring(0, str.length()-1).split("\\(");
		String[] prefixTokens = tokens[0].split(" ");
		
		// public V
		for(int i=0; i<prefixTokens.length-1; i++) {
			sb.append(prefixTokens[i]).append(" ");
		}
		
		// public V put(
		String[] nameTokens = prefixTokens[prefixTokens.length-1].split("\\.");
		sb.append(nameTokens[nameTokens.length-1]).append("(");
		
		// public V put(K p0, V p1)
		for(int i=0; i<constructor.getParameterTypes().length; i++) {
			sb.append(getTypeName(constructor.getGenericParameterTypes()[i], constructor.getParameterTypes()[i], true)).append(" ").append("p").append(i).append(", ");
		}
		if(constructor.getParameterTypes().length != 0) {
			sb.delete(sb.length()-2, sb.length());
		}
		sb.append(")");
		
		List<Class<?>> exceptionClasses = new ArrayList<Class<?>>();
		List<Type> exceptions = new ArrayList<Type>();
		for(int index : filter(constructor.getExceptionTypes(), allClassSet)) {
			exceptions.add(constructor.getGenericExceptionTypes()[index]);
			exceptionClasses.add(constructor.getExceptionTypes()[index]);
		}

		if(exceptions.size() == 0) {
			return sb.toString();
		}
		
		if(WRITE_EXCEPTIONS) {
			// throws ...
			sb.append(" throws ");
			for(int i=0; i<exceptions.size(); i++) {
				sb.append(getTypeName(exceptions.get(i), exceptionClasses.get(i), true)).append(", ");
			}
			sb.delete(sb.length()-2, sb.length());
		}
		
		return sb.toString();
	}
	
	private static boolean isToStringMethod(Method method) {
		return method.getName().equals("toString") && method.getParameterTypes().length == 0;
	}
	
	private static boolean isGetClassMethod(Method method) {
		return method.getName().equals("getClass") && method.getParameterTypes().length == 0;
	}
	
	private static boolean isObjectMethod(Method method) {
		return isToStringMethod(method) || isGetClassMethod(method);
	}
	
	public static String toString(Method method, Set<Class<?>> allClassSet) {
		StringBuilder sb = new StringBuilder();
		
		// public V java.util.HashMap.put(K,V)
		String str = process(method.toGenericString(), !isObjectMethod(method));
		
		// [public V java.util.HashMap.put, K,V]
		String[] tokens = str.substring(0, str.length()-1).split("\\(");
		String[] prefixTokens = tokens[0].split(" ");
		
		// public V
		for(int i=0; i<prefixTokens.length-1; i++) {
			if(prefixTokens[i].equals("native")) {
			} else {
				sb.append(prefixTokens[i]).append(" ");
			}
		}
		
		// public V put(
		String[] nameTokens = prefixTokens[prefixTokens.length-1].split("\\.");
		sb.append(nameTokens[nameTokens.length-1]).append("(");
		
		if(method.getParameterTypes().length == 0) {
			sb.append(")");
			return sb.toString();
		}
		
		// public V put(K p0, V p1)
		for(int i=0; i<method.getParameterTypes().length; i++) {
			sb.append(getTypeName(method.getGenericParameterTypes()[i], method.getParameterTypes()[i], true)).append(" ").append("p").append(i).append(", ");
		}
		sb.replace(sb.length()-2, sb.length(), ")");
		
		List<Type> exceptions = new ArrayList<Type>();
		List<Class<?>> exceptionClasses = new ArrayList<Class<?>>();
		for(int index : filter(method.getExceptionTypes(), allClassSet)) {
			exceptions.add(method.getGenericExceptionTypes()[index]);
			exceptionClasses.add(method.getExceptionTypes()[index]);
		}

		if(exceptions.size() == 0) {
			return sb.toString();
		}
		
		// throws ...
		if(WRITE_EXCEPTIONS) {
			sb.append(" throws ");
			for(int i=0; i<exceptions.size(); i++) {
				sb.append(getTypeName(exceptions.get(i), exceptionClasses.get(i), true)).append(", ");
			}
			sb.delete(sb.length()-2, sb.length());
		}
		
		return sb.toString();
	}
	
	private static String toGenericString(Class<?> klass) {
        StringBuilder sb = new StringBuilder();
        int modifiers = klass.getModifiers() & Modifier.classModifiers();
        if(modifiers != 0) {
            sb.append(Modifier.toString(modifiers)).append(" ");
        }
        if(klass.isInterface()) {
            sb.append("interface");
        } else if(klass.isEnum()) {
            sb.append("enum");
        } else {
        	sb.append("class");
        }
        sb.append(" ").append(klass.getSimpleName());
        
        TypeVariable<?>[] typeParameters = klass.getTypeParameters();
        if(typeParameters.length > 0) {
            sb.append("<");
        }
        for(TypeVariable<?> typeParameter : typeParameters) {
            sb.append(typeParameter.toString()).append(",");
        }
        if(typeParameters.length > 0) {
            sb.replace(sb.length()-1, sb.length(), ">");
        }

        return sb.toString();
    }
	
	private static boolean filterSingle(Class<?> klass, Set<Class<?>> allClassSet) {
		if(!allClassSet.contains(klass)) {
			return false;
		}
		return ReflectionUtils.isAtlasRoot(klass);
	}
	
	private static List<Integer> filter(Class<?>[] classes, Set<Class<?>> allClassSet) {
		List<Integer> indices = new ArrayList<Integer>();
		for(int i=0; i<classes.length; i++) {
			if(filterSingle(classes[i], allClassSet)) {
				indices.add(i);
			}
		}
		return indices;
	}
	
	private static String getAnonymousClassName(Class<?> klass, Map<Class<?>,Integer> anonymousClassNames) {
		if(!klass.isAnonymousClass()) {
			throw new RuntimeException();
		}
		if(!anonymousClassNames.containsKey(klass)) {
			throw new RuntimeException();
		}
		return Settings.ANONYMOUS_PREFIX + anonymousClassNames.get(klass);
	}
	
	private static String getAnonymousClassGenericName(Class<?> klass, Map<Class<?>,Integer> anonymousClassNames) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(getAnonymousClassName(klass, anonymousClassNames));
		
		if(klass.getGenericSuperclass() == Object.class && klass.getGenericInterfaces().length == 0) {
			return sb.toString();
		}
		
		if(klass.getGenericSuperclass() != Object.class && klass.getGenericInterfaces().length > 0) {
			throw new RuntimeException();
		}
		
		Class<?> superclass;
		Type supertype;
		if(klass.getGenericSuperclass() != Object.class) {
			superclass = klass.getSuperclass();
			supertype = klass.getGenericSuperclass();
		} else if(klass.getGenericInterfaces().length == 1) {
			superclass = klass.getInterfaces()[0];
			supertype = klass.getGenericInterfaces()[0];
		} else {
			throw new RuntimeException();
		}
		
		if(superclass.getTypeParameters().length == 0) {
			return sb.toString();
		}
		
		// check
		String[] tokens = superclass.toGenericString().split(" ");
		if(!supertype.getTypeName().equals(tokens[tokens.length-1])) {
			return sb.toString();
		}
		
        TypeVariable<?>[] typeParameters = superclass.getTypeParameters();
        if(typeParameters.length > 0) {
            sb.append("<");
        }
        for(TypeVariable<?> typeParameter : typeParameters) {
            sb.append(typeParameter.toString()).append(",");
        }
        if(typeParameters.length > 0) {
            sb.replace(sb.length()-1, sb.length(), ">");
        }
		
        return sb.toString();
	}
	
	public static String toString(Class<?> klass, Set<Class<?>> allClassSet, Map<Class<?>,Integer> anonymousClassNames) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("public ");
		
		if(klass.isAnonymousClass()) {
			sb.append("class ").append(getAnonymousClassGenericName(klass, anonymousClassNames));
		} else {
			// [public, class, java.util.ArrayList<E>]
			String[] tokens = process(toGenericString(klass), true).split(" ");
			
			// public class ArrayList<E>
			for(int i=0; i<tokens.length-1; i++) {
				if(klass.isEnum() && (tokens[i].equals("final") || tokens[i].equals("abstract"))) {
				} else if(tokens[i].equals("public") || tokens[i].equals("private") || tokens[i].equals("protected")) {
				} else {
					sb.append(tokens[i]).append(" ");
				}
			}
			
			String[] nameTokens = tokens[tokens.length-1].split("\\.");
			sb.append(nameTokens[nameTokens.length-1]);
		}
		
		if(klass.isEnum()) {
			return sb.toString();
		}
		
		// public class ArrayList<E> extends java.util.AbstractList<E>
		Type superclass = klass.getGenericSuperclass();
		if(!klass.isInterface() && !klass.equals(Object.class) && !superclass.equals(Object.class) && filterSingle(klass.getSuperclass(), allClassSet)) {
			sb.append(" extends ").append(getTypeName(superclass, klass.getSuperclass(), true));
		}
		
		// public class ArrayList<E> extends java.util.AbstractList<E> implements ...
		List<Type> interfaces = new ArrayList<Type>();
		List<Class<?>> interfaceClasses = new ArrayList<Class<?>>();
		for(int index : filter(klass.getInterfaces(), allClassSet)) {
			interfaces.add(klass.getGenericInterfaces()[index]);
			interfaceClasses.add(klass.getInterfaces()[index]);
		}
		if(interfaces.size() > 0) {
			sb.append(klass.isInterface() ? " extends " : " implements ");
			for(int i=0; i<interfaces.size(); i++) {
				sb.append(getTypeName(interfaces.get(i), interfaceClasses.get(i), true)).append(", ");
			}
			sb.delete(sb.length()-2, sb.length());
		}
		
		return sb.toString();
	}
	
	private static String getReturnDeclaration(Method method) {
		Class<?> type = method.getReturnType();
		if(type.isPrimitive()) {
			if(type.equals(boolean.class)) {
				return "boolean r = false;";
			} else if(type.equals(void.class)) {
				throw new RuntimeException();
			} else {
				return type.getName() + " r = 0;";
			}
		} else {
			return ReflectionUtils.toString(method.getReturnType(), !isObjectMethod(method), true) + " r = null;";
		}
	}
	
	private static String getReturn(Method method) {
		return "return (" + getTypeName(method.getGenericReturnType(), method.getReturnType(), !isObjectMethod(method)) + ")r;";
	}
	
	private static String toString(Class<?> klass, Map<Integer,Class<?>> fieldTypes, MultivalueMap<Class<?>,Integer> fields, MultivalueMap<Constructor<?>,StatementModel> constructors, MultivalueMap<Method,StatementModel> methods, MultivalueMap<Method,Class<?>> proxyMethods, String prefix, Set<Class<?>> allClassSet, MultivalueMap<Class<?>,Class<?>> anonymousClasses, Map<Class<?>,Integer> anonymousClassNames) {
		StringBuilder sb = new StringBuilder();
		
		// declaration
		sb.append(prefix).append(toString(klass, allClassSet, anonymousClassNames)).append(" {\n");
		
		// fields
		for(int field : fields.get(klass)) {
			sb.append(prefix).append("\tpublic ").append(ReflectionUtils.isAtlasTarget(fieldTypes.get(field)) ? Settings.NAME_PREFIX + "." : "").append(fieldTypes.get(field).getName()).append(" f").append(field).append(";\n");
		}
		
		// enum
		if(klass.isEnum()) {
			try {
				// hack to get around overridden toString method:
				//    http://stackoverflow.com/questions/5411434/how-to-call-a-superclass-method-using-java-reflection
		        Field IMPL_LOOKUP = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
		        IMPL_LOOKUP.setAccessible(true);
		        MethodHandles.Lookup lkp = (MethodHandles.Lookup)IMPL_LOOKUP.get(null);
		        MethodHandle toStringHandle = lkp.findSpecial(Enum.class, "toString", MethodType.methodType(String.class), klass);
		        
		        // print enum constants
				sb.append(prefix).append("\t");
				for(Object ob : klass.getEnumConstants()) {
					sb.append(toStringHandle.invoke(ob)).append(", ");
				}
				sb.delete(sb.length()-2, sb.length());
				sb.append(";\n");
			} catch(Throwable e) {
				throw new RuntimeException(e);
			}
		}
		
		// constructors
		if(!klass.isAnonymousClass()) {
			for(Constructor<?> constructor : getDeclaredConstructors(klass, allClassSet)) {
				if(constructor.getParameterTypes().length == 0) {
					continue;
				}
				sb.append(prefix).append("\t").append(toString(constructor, allClassSet)).append(" {\n");
				for(StatementModel statement : constructors.get(constructor)) {
					Class<?> castType = statement.sinkField.hasT() ? fieldTypes.get(statement.sinkField.getT()) : statement.sinkType;
					Maybe<Class<?>> sourceCastType = statement.sourceField.hasT() ? new Maybe<Class<?>>(statement.sourceType) : new Maybe<Class<?>>();
					Maybe<Class<?>> sinkCastType = statement.sinkField.hasT() ? new Maybe<Class<?>>(statement.sinkType) : new Maybe<Class<?>>();
					sb.append(prefix).append("\t\t").append(toString(statement, Settings.IS_CONSTRUCTOR_STATIC, castType, sourceCastType, sinkCastType, anonymousClassNames, false, true)).append("\n");
				}
				sb.append(prefix).append("\t}").append("\n");
			}
		}
		if(klass.equals(Enum.class)) {
			sb.append(prefix).append("\tprotected Enum(java.lang.String name, int ordinal) {\n");
			sb.append(prefix).append("\t}").append("\n");
		}
		if(!klass.isEnum() && !klass.isInterface()) {
			if(klass.isAnonymousClass()) {
				sb.append(prefix).append("\t").append(getAnonymousClassName(klass, anonymousClassNames)).append("() {\n");
			} else {
				sb.append(prefix).append("\t").append("public ").append(klass.getSimpleName()).append("() {\n");
			}
			sb.append(prefix).append("\t}").append("\n");
		}
		
		// methods
		for(Method method : getDeclaredMethods(klass, allClassSet)) {
			if(!Modifier.isPublic(method.getModifiers()) && !Modifier.isProtected(method.getModifiers())) {
				continue;
			}
			if(Modifier.isAbstract(method.getModifiers())) {
				sb.append(prefix).append("\t").append(toString(method, allClassSet)).append(";").append("\n");
			} else {
				sb.append(prefix).append("\t").append(toString(method, allClassSet)).append(" {\n");
				if(!method.getReturnType().equals(void.class)) {
					sb.append(prefix).append("\t\t").append(getReturnDeclaration(method)).append("\n");
				}
				for(Class<?> proxyStatement : proxyMethods.get(method)) {
					sb.append(prefix).append("\t\t").append("r = new ");
					if(proxyStatement.isArray()) {
						sb.append(ReflectionUtils.toStringWithAnonymous(proxyStatement.getComponentType(), anonymousClassNames, true, true)).append("[").append(Settings.SOURCE_ARRAY_LENGTH).append("];\n");
					} else if(proxyStatement.isPrimitive()) {
						throw new RuntimeException();
					} else {
						sb.append(ReflectionUtils.toStringWithAnonymous(proxyStatement, anonymousClassNames, true, true)).append("();\n");
					}
				}
				for(StatementModel statement : methods.get(method)) {
					Class<?> castType = statement.sinkField.hasT() ? fieldTypes.get(statement.sinkField.getT()) : statement.sinkType;
					Maybe<Class<?>> sourceCastType = statement.sourceField.hasT() ? new Maybe<Class<?>>(statement.sourceType) : new Maybe<Class<?>>();
					Maybe<Class<?>> sinkCastType = statement.sinkField.hasT() ? new Maybe<Class<?>>(statement.sinkType) : new Maybe<Class<?>>();
					sb.append(prefix).append("\t\t").append(toString(statement, Modifier.isStatic(method.getModifiers()), castType, sourceCastType, sinkCastType, anonymousClassNames, isToStringMethod(method), false)).append("\n");
				}
				if(!method.getReturnType().equals(void.class)) {
					sb.append(prefix).append("\t\t").append(getReturn(method)).append("\n");
				}
				sb.append(prefix).append("\t}").append("\n");
			}
		}
		
		// classes
		for(int index : filter(klass.getDeclaredClasses(), allClassSet)) {
			sb.append(toString(klass.getDeclaredClasses()[index], fieldTypes, fields, constructors, methods, proxyMethods, prefix + "\t", allClassSet, anonymousClasses, anonymousClassNames));
		}
		
		// anonymous classes
		for(Class<?> anonymousClass : anonymousClasses.get(klass)) {
			if(anonymousClass.getEnclosingClass().isEnum()) {
				continue;
			}
			if(filterSingle(anonymousClass, allClassSet)) {
				sb.append(toString(anonymousClass, fieldTypes, fields, constructors, methods, proxyMethods, prefix + "\t", allClassSet, anonymousClasses, anonymousClassNames));
			}
		}
		
		// ending
		sb.append(prefix).append("}\n");
		
		return sb.toString();
	}
	
	public static String toString(Class<?> klass, Map<Integer,Class<?>> fieldTypes, MultivalueMap<Class<?>,Integer> fields, MultivalueMap<Constructor<?>,StatementModel> constructors, MultivalueMap<Method,StatementModel> methods, MultivalueMap<Method,Class<?>> proxyMethods, Set<Class<?>> allClassSet, MultivalueMap<Class<?>,Class<?>> anonymousClasses, Map<Class<?>,Integer> anonymousClassNames) {
		return toString(klass, fieldTypes, fields, constructors, methods, proxyMethods, "", allClassSet, anonymousClasses, anonymousClassNames);
	}
	
	public static String getFilename(Class<?> klass) {
		if(klass.getEnclosingClass() != null) {
			throw new RuntimeException();
		}
		return Settings.NAME_PREFIX + File.separatorChar + klass.getName().replace('.', File.separatorChar) + ".java";
	}
	
	private static void getAllClassesHelper(Class<?> klass, Set<Class<?>> allClasses) {
		try {
			klass.getDeclaredMethods();
			klass.getDeclaredClasses();
		} catch(Throwable e) {
			return;
		}
		if(allClasses.contains(klass)) {
			return;
		}
		allClasses.add(klass);
		for(Class<?> subclass : klass.getDeclaredClasses()) {
			getAllClassesHelper(subclass, allClasses);
		}
	}
	
	public static List<Pair<String,String>> toFiles(Iterable<Class<?>> allClasses, Iterable<Pair<Callable,StatementModel>> statements, MultivalueMap<Callable,Class<?>> proxyStatements) {
		// get classes
		Set<Class<?>> allClassSet = new HashSet<Class<?>>();
		for(Class<?> klass : allClasses) {
			getAllClassesHelper(klass, allClassSet);
		}
		for(Class<?> klass : allClassSet) {
			if(klass.getSimpleName().startsWith(Settings.ANONYMOUS_PREFIX)) {
				throw new RuntimeException();
			}
		}
		
		// check containment
		Set<Callable> allMethods = new HashSet<Callable>();
		for(Class<?> klass : allClassSet) {
			for(Method method : getDeclaredMethods(klass, allClassSet)) {
				allMethods.add(new AtlasMethod(method, klass));
			}
			for(Constructor<?> constructor : getDeclaredConstructors(klass, allClassSet)) {
				allMethods.add(new AtlasConstructor(constructor));
			}
		}
		for(Pair<Callable,StatementModel> statement : statements) {
			if(!allMethods.contains(statement.getX())) {
				if(statement.getX().getDeclaringClass().isAnonymousClass()) {
					Log.info("UNHANDLED ANONYMOUS CLASS: " + statement.getX().getDeclaringClass());
				} else {
					Log.info("UNHANDLED STATEMENT: " + statement.getX().toString() + ", " + statement.getY().toString());
				}
			}
		}
		for(Map.Entry<Callable,Set<Class<?>>> entry : proxyStatements.entrySet()) {
			if(!allMethods.contains(entry.getKey())) {
				for(Class<?> klass : entry.getValue()) {
					Log.info("UNHANDLED PROXY STATEMENT: " + entry.getKey().toString() + ", " + klass.getName());
				}
			}
		}
		
		// build field types
		Map<Integer,Class<?>> fieldTypes = FieldTypeUtils.getFieldTypes(statements);
		
		// build the fields
		MultivalueMap<Class<?>,Integer> fields = new MultivalueMap<Class<?>,Integer>();
		for(Pair<Callable,StatementModel> statement : statements) {
			if(statement.getY().sourceField.hasT()) {
				fields.add(statement.getY().sourceType, statement.getY().sourceField.getT());
			}
			if(statement.getY().sinkField.hasT()) {
				fields.add(statement.getY().sinkType, statement.getY().sinkField.getT());
			}
		}
		
		// build the methods
		MultivalueMap<Constructor<?>,StatementModel> constructors = new MultivalueMap<Constructor<?>,StatementModel>();
		MultivalueMap<Method,StatementModel> methods = new MultivalueMap<Method,StatementModel>();
		for(Pair<Callable,StatementModel> statement : statements) {
			if(statement.getX() instanceof AtlasMethod) {
				methods.add(((AtlasMethod)statement.getX()).method, statement.getY());
			} else if(statement.getX() instanceof AtlasConstructor) {
				constructors.add(((AtlasConstructor)statement.getX()).constructor, statement.getY());
			} else if(statement.getX() instanceof AtlasArray) {
				Log.info("IGNORING ARRAY STATEMENT: " + statement.getX().getString() + ", " + statement.getY().toString());
			} else {
				throw new RuntimeException();
			}
		}
		MultivalueMap<Method,Class<?>> proxyMethods = new MultivalueMap<Method,Class<?>>();
		for(Map.Entry<Callable,Set<Class<?>>> entry : proxyStatements.entrySet()) {
			for(Class<?> klass : entry.getValue()) {
				if(entry.getKey() instanceof AtlasMethod) {
					proxyMethods.add(((AtlasMethod)entry.getKey()).method, klass);
				} else {
					throw new RuntimeException();
				}
			}
		}
		
		// build anonymous classes
		MultivalueMap<Class<?>,Class<?>> anonymousClasses = new MultivalueMap<Class<?>,Class<?>>();
		Map<Class<?>,Integer> anonymousClassNames = new HashMap<Class<?>,Integer>();
		int count = 0;
		for(Class<?> klass : allClasses) {
			if(klass.isAnonymousClass()) {
				anonymousClasses.add(klass.getEnclosingClass(), klass);
				anonymousClassNames.put(klass, count++);
			}
		}
		
		// build the classes
		List<Pair<String,String>> files = new ArrayList<Pair<String,String>>();
		for(Class<?> klass : allClasses) {
			if(klass.getEnclosingClass() != null) {
				continue;
			}
			if(!ReflectionUtils.isAtlasTarget(klass)) {
				continue;
			}
			String packagePrefix = "package " + Settings.NAME_PREFIX + "." + klass.getPackage().getName() + ";\n";
			String string = packagePrefix + toString(klass, fieldTypes, fields, constructors, methods, proxyMethods, allClassSet, anonymousClasses, anonymousClassNames);
			files.add(new Pair<String,String>(getFilename(klass), string));
		}
		
		return files;
	}
	
	public static void writeFiles(File directory, List<Pair<String,String>> files) {
		File srcDirectory = new File(directory, "src");
		for(Pair<String,String> file : files) {
			if(file.getX().equals(Settings.NAME_PREFIX + File.separatorChar + "java/util/regex/UnicodeProp.java")) {
				Log.info("SKIPPING java.util.regex.UnicodeProp");
				continue;
			}if(file.getX().equals(Settings.NAME_PREFIX + File.separatorChar + "java/lang/Object.java")) {
				Log.info("SKIPPING java.lang.Object");
				continue;
			}
			File f = new File(srcDirectory, file.getX());
			f.getParentFile().mkdirs();
			try {
				PrintWriter pw = new PrintWriter(new FileWriter(f));
				pw.print(file.getY());
				pw.close();
			} catch(IOException e) {
				throw new RuntimeException(e);
			}
		}
		try {
			File build = new File(directory, BUILD_FILE);
			PrintWriter pw = new PrintWriter(new FileWriter(build));
			pw.println(BUILD_CONTENTS);
			pw.close();
		} catch(IOException e) {
			throw new RuntimeException();
		}
	}
	
	public static void writeStatements(File directory, Iterable<Class<?>> allClasses, MultivalueMap<AliasModel,Trace> models, MultivalueMap<Callable,Class<?>> proxyModels, Iterable<ConstructStatementConstructor> constructors, Iterable<Boolean> isNonNulls) {
		if(Settings.USE_EMPTY_ATLAS) {
			writeFiles(directory, toFiles(allClasses, new ArrayList<Pair<Callable,StatementModel>>(), new MultivalueMap<Callable,Class<?>>()));
		} else {
			writeFiles(directory, toFiles(allClasses, StatementModelUtils.toStatements(models, StatementModelUtils.toAutomaton(models, constructors, isNonNulls)), proxyModels));
		}
	}
}
