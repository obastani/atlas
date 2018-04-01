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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import atlas.StatementUtils.ConstantStatement;
import atlas.StatementUtils.ConstructArrayStatement;
import atlas.StatementUtils.ConstructBooleanArrayStatement;
import atlas.StatementUtils.ConstructByteArrayStatement;
import atlas.StatementUtils.ConstructCharArrayStatement;
import atlas.StatementUtils.ConstructDoubleArrayStatement;
import atlas.StatementUtils.ConstructFloatArrayStatement;
import atlas.StatementUtils.ConstructIntArrayStatement;
import atlas.StatementUtils.ConstructLongArrayStatement;
import atlas.StatementUtils.ConstructObjectStatement;
import atlas.StatementUtils.ConstructShortArrayStatement;
import atlas.StatementUtils.Statement;
import atlas.Utils.MultivalueMap;
import atlas.Utils.Triple;

public class ObjectConstructorUtils {
	private static MultivalueMap<Class<?>,Constructor<?>> getClassUses(List<Class<?>> classes) {
		MultivalueMap<Class<?>,Constructor<?>> uses = new MultivalueMap<Class<?>,Constructor<?>>();
		Set<Class<?>> classSet = new HashSet<Class<?>>(classes);
		
		// add constructors
		for(Class<?> klass : classes) {
			for(Constructor<?> constructor : klass.getConstructors()) {
				for(Class<?> parameterClass : constructor.getParameterTypes()) {
					if(parameterClass.isPrimitive()) {
						continue;
					}
					if(parameterClass.isArray()) {
						continue;
					}
					if(!classSet.contains(parameterClass)) {
						Log.info("WARNING: CLASS " + parameterClass.getName() + " NOT LOADED");
					}
					uses.add(parameterClass, constructor);
				}
			}
		}
		
		return uses;
	}
	
	private static MultivalueMap<Class<?>,Class<?>> getCompatibleClasses(List<Class<?>> classes) {
		MultivalueMap<Class<?>,Class<?>> compatibleClasses = new MultivalueMap<Class<?>,Class<?>>();
		for(Class<?> klass : classes) {
			for(Class<?> otherClass : classes) {
				if(klass.isAssignableFrom(otherClass)) {
					compatibleClasses.add(klass, otherClass);
				}
			}
		}
		return compatibleClasses;
	}
	
	private static class ConstructorDescriptor {
		private final Constructor<?> constructor;
		private final Class<?>[] parameterClasses;
		private ConstructorDescriptor(Constructor<?> constructor, Class<?>[] parameterClasses) {
			this.constructor = constructor;
			this.parameterClasses = parameterClasses;
		}
	}
	
	private static int compare(int i1, int i2) {
		if(i1 < i2) {
			return -1;
		} else if(i1 == i2) {
			return 0;
		} else {
			return 1;
		}
	}
	
	private static Map<Class<?>,ConstructorDescriptor> closure(List<Class<?>> classes) {
		Map<Class<?>,Triple<ConstructorDescriptor,Object,Integer>> constructors = new HashMap<Class<?>,Triple<ConstructorDescriptor,Object,Integer>>();
		
		MultivalueMap<Class<?>,Constructor<?>> uses = getClassUses(classes);
		MultivalueMap<Class<?>,Class<?>> compatibleClasses = getCompatibleClasses(classes);
		
		// setup worklist
		Comparator<Triple<ConstructorDescriptor,Object,Integer>> comparator = new Comparator<Triple<ConstructorDescriptor,Object,Integer>>() {
			public int compare(Triple<ConstructorDescriptor,Object,Integer> t1, Triple<ConstructorDescriptor,Object,Integer> t2) {
				return ObjectConstructorUtils.compare(t1.getZ(), t2.getZ()); }};
		PriorityQueue<Triple<ConstructorDescriptor,Object,Integer>> worklist = new PriorityQueue<Triple<ConstructorDescriptor,Object,Integer>>(12, comparator);
		
		// initiate worklist with no-parameter constructors
		for(Class<?> klass : classes) {
			for(Constructor<?> constructor : klass.getConstructors()) {
				if(ReflectionUtils.isConcreteDeclaringClass(constructor) && constructor.getParameterTypes().length == 0) {
					try {
						worklist.add(new Triple<ConstructorDescriptor,Object,Integer>(new ConstructorDescriptor(constructor, new Class<?>[]{}), constructor.newInstance(), 1));
					} catch(Exception e) {}
				}
			}
		}
		
		// process and add completed constructors to worklist
		while(!worklist.isEmpty()) {
			// get min
			Triple<ConstructorDescriptor,Object,Integer> triple = worklist.remove();
			ConstructorDescriptor curConstructor = triple.getX();
			
			// set as constructor (unless already processed)
			if(constructors.containsKey(curConstructor.constructor.getDeclaringClass())) {
				continue;
			}
			constructors.put(curConstructor.constructor.getDeclaringClass(), triple);
			
			// add new constructors to worklist
			for(Constructor<?> constructor : uses.get(curConstructor.constructor.getDeclaringClass())) {
				if(!ReflectionUtils.isConcreteDeclaringClass(constructor)) {
					continue;
				}
				Object[] parameters = new Object[constructor.getParameterTypes().length];
				Class<?>[] parameterClasses = new Class<?>[constructor.getParameterTypes().length];
				int weight = 0;
				boolean flag = true;
				for(int i=0; i<constructor.getParameterTypes().length; i++) {
					Triple<Class<?>,Object,Integer> min = null;
					for(Class<?> otherClass : compatibleClasses.get(constructor.getParameterTypes()[i])) {
						if(constructors.containsKey(otherClass) && (min == null || constructors.get(otherClass).getZ() < min.getZ())) {
							min = new Triple<Class<?>,Object,Integer>(otherClass, constructors.get(otherClass).getY(), constructors.get(otherClass).getZ());
						}
					}
					if(min != null) {
						parameterClasses[i] = min.getX();
						parameters[i] = min.getY();
						weight += min.getZ();
					} else {
						flag = false;
						break;
					}
				}
				if(flag) {
					try {
						worklist.add(new Triple<ConstructorDescriptor,Object,Integer>(new ConstructorDescriptor(constructor, parameterClasses), constructor.newInstance(parameters), weight+1));
					} catch(Exception e) {}
				}
			}
		}
		
		// fill in lowest weight for each class
		Map<Class<?>,ConstructorDescriptor> simpleConstructors = new HashMap<Class<?>,ConstructorDescriptor>();
		for(Class<?> klass : classes) {
			Triple<ConstructorDescriptor,Object,Integer> min = null;
			for(Class<?> otherClass : compatibleClasses.get(klass)) {
				if(min == null || (constructors.containsKey(otherClass) && constructors.get(otherClass).getZ() < min.getZ())) {
					min = constructors.get(otherClass);
				}
			}
			if(min != null) {
				simpleConstructors.put(klass, min.getX());
			} else {
				Log.info("WARNING: NO CONSTRUCTOR FOR " + klass.getName());
			}
		}
		
		return simpleConstructors;
	}
	
	public static interface PrimitiveConstructor {
		public abstract boolean getBoolean();
		public abstract byte getByte();
		public abstract char getChar();
		public abstract short getShort();
		public abstract int getInt();
		public abstract long getLong();
		public abstract float getFloat();
		public abstract double getDouble();
	}
	
	public static interface ConstructStatementConstructor {
		public abstract Statement<Object> getConstructStatement(Class<?> klass, boolean isNonConstant);
	}
	
	public static class DefaultPrimitiveConstructor implements PrimitiveConstructor {
		public boolean getBoolean() {
			return true;
		}
		public byte getByte() {
			return (byte)0;
		}
		public char getChar() {
			return (char)0;
		}
		public short getShort() {
			return (short)0;
		}
		public int getInt() {
			return 0;
		}
		public long getLong() {
			return (long)0;
		}
		public float getFloat() {
			return 0.0f;
		}
		public double getDouble() {
			return 0.0;
		}
	}
	
	private static interface ConstructObjectStatementConstructor {
		public Statement<Object> getConstructObjectStatement(ConstructStatementConstructor statementConstructor, Class<?> klass, boolean isNonConstant);
	}
	
	private static ConstantStatement<Object> getPrimitive(PrimitiveConstructor primitive, Class<?> klass) {
		if(klass.equals(boolean.class)) {
			return new ConstantStatement<Object>(primitive.getBoolean());
		} else if(klass.equals(byte.class)) {
			return new ConstantStatement<Object>(primitive.getByte());
		} else if(klass.equals(char.class)) {
			return new ConstantStatement<Object>(primitive.getChar());
		} else if(klass.equals(short.class)) {
			return new ConstantStatement<Object>(primitive.getShort());
		} else if(klass.equals(int.class)) {
			return new ConstantStatement<Object>(primitive.getInt());
		} else if(klass.equals(long.class)) {
			return new ConstantStatement<Object>(primitive.getLong());
		} else if(klass.equals(float.class)) {
			return new ConstantStatement<Object>(primitive.getFloat());
		} else if(klass.equals(double.class)) {
			return new ConstantStatement<Object>(primitive.getDouble());
		} else {
			throw new RuntimeException();
		}
	}
	
	private static class ProxyConstructStatementConstructor implements ConstructStatementConstructor {
		private final ConstructObjectStatementConstructor objectConstructor;
		private final PrimitiveConstructor primitive;
		private final int arrayLength;
		
		private ProxyConstructStatementConstructor(ConstructObjectStatementConstructor objectConstructor, PrimitiveConstructor primitive, int arrayLength) {
			this.objectConstructor = objectConstructor;
			this.primitive = primitive;
			this.arrayLength = arrayLength;
		}
		
		@Override
		public Statement<Object> getConstructStatement(Class<?> klass, boolean isNonConstant) {
			if(klass.isPrimitive()) {
				return this.getConstantPrimitiveStatement(klass);
			} else if(klass.isArray()) {
				return this.getConstructArrayStatement(klass.getComponentType(), isNonConstant);
			} else {
				return this.objectConstructor.getConstructObjectStatement(this, klass, isNonConstant);
			}
		}
		
		private Statement<Object> getConstantPrimitiveStatement(Class<?> klass) {
			return getPrimitive(this.primitive, klass);
		}
		
		private Statement<Object> getConstructArrayStatement(Class<?> klass, boolean isNonConstant) {
			if(klass.isPrimitive()) {
				if(klass.equals(boolean.class)) {
					Statement<Boolean>[] componentValues = new Statement[this.arrayLength];
					for(int i=0; i<componentValues.length; i++) {
						componentValues[i] = new ConstantStatement<Boolean>(this.primitive.getBoolean());
					}
					return new ConstructBooleanArrayStatement(componentValues);
				} else if(klass.equals(byte.class)) {
					Statement<Byte>[] componentValues = new Statement[this.arrayLength];
					for(int i=0; i<componentValues.length; i++) {
						componentValues[i] = new ConstantStatement<Byte>(this.primitive.getByte());
					}
					return new ConstructByteArrayStatement(componentValues);
				} else if(klass.equals(char.class)) {
					Statement<Character>[] componentValues = new Statement[this.arrayLength];
					for(int i=0; i<componentValues.length; i++) {
						componentValues[i] = new ConstantStatement<Character>(this.primitive.getChar());
					}
					return new ConstructCharArrayStatement(componentValues);
				} else if(klass.equals(short.class)) {
					Statement<Short>[] componentValues = new ConstantStatement[this.arrayLength];
					for(int i=0; i<componentValues.length; i++) {
						componentValues[i] = new ConstantStatement<Short>(this.primitive.getShort());
					}
					return new ConstructShortArrayStatement(componentValues);
				} else if(klass.equals(int.class)) {
					Statement<Integer>[] componentValues = new Statement[this.arrayLength];
					for(int i=0; i<componentValues.length; i++) {
						componentValues[i] = new ConstantStatement<Integer>(this.primitive.getInt());
					}
					return new ConstructIntArrayStatement(componentValues);
				} else if(klass.equals(long.class)) {
					Statement<Long>[] componentValues = new Statement[this.arrayLength];
					for(int i=0; i<componentValues.length; i++) {
						componentValues[i] = new ConstantStatement<Long>(this.primitive.getLong());
					}
					return new ConstructLongArrayStatement(componentValues);
				} else if(klass.equals(float.class)) {
					Statement<Float>[] componentValues = new Statement[this.arrayLength];
					for(int i=0; i<componentValues.length; i++) {
						componentValues[i] = new ConstantStatement<Float>(this.primitive.getFloat());
					}
					return new ConstructFloatArrayStatement(componentValues);
				} else if(klass.equals(double.class)) {
					Statement<Double>[] componentValues = new Statement[this.arrayLength];
					for(int i=0; i<componentValues.length; i++) {
						componentValues[i] = new ConstantStatement<Double>(this.primitive.getDouble());
					}
					return new ConstructDoubleArrayStatement(componentValues);
				} else {
					throw new RuntimeException();
				}
			} else {
				Statement<Object>[] componentValues = new Statement[this.arrayLength];
				for(int i=0; i<componentValues.length; i++) {
					componentValues[i] = this.getConstructStatement(klass, isNonConstant);
				}
				return new ConstructArrayStatement(klass, componentValues);
			}
		}
	}
	
	private static class SimpleConstructObjectStatementConstructor implements ConstructObjectStatementConstructor {
		private final Map<Class<?>,Constructor<?>> constructors = new HashMap<Class<?>,Constructor<?>>();
		private SimpleConstructObjectStatementConstructor(PrimitiveConstructor primitive, Iterable<Class<?>> classes) {
			List<Class<?>> classList = new ArrayList<Class<?>>();
			for(Class<?> klass : classes) {
				classList.add(klass);
			}
			for(Class<?> klass : classes) {
				Constructor<?> minConstructor = null;
				for(Constructor<?> constructor : klass.getConstructors()) {
					try {
						Statement<Object>[] parameters = new Statement[constructor.getParameterTypes().length];
						for(int i=0; i<constructor.getParameterTypes().length; i++) {
							Class<?> parameterType = constructor.getParameterTypes()[i];
							parameters[i] = parameterType.isPrimitive() ? getPrimitive(primitive, parameterType) : new ConstantStatement<Object>(null);
						}
						StatementUtils.execute(new ConstructObjectStatement(constructor, parameters));
					} catch(Exception e) {
						continue;
					}
					if(minConstructor == null || constructor.getParameterTypes().length < minConstructor.getParameterTypes().length) {
						minConstructor = constructor;
					}
				}
				if(minConstructor != null) {
					this.constructors.put(klass, minConstructor);
				}
			}
		}
		@Override
		public Statement<Object> getConstructObjectStatement(ConstructStatementConstructor statementConstructor, Class<?> klass, boolean isNonConstant) {
			if(!this.constructors.containsKey(klass)) {
				if(klass.equals(Object.class)) {
					try {
						return new ConstructObjectStatement(String.class.getConstructor(), new Statement[0]);
					} catch(Exception e) {
						throw new RuntimeException();
					}
				}
				if(isNonConstant) {
					throw new RuntimeException();
				}
				return new ConstantStatement<Object>(null);
			}
			Constructor<?> constructor = this.constructors.get(klass);
			Statement<Object>[] parameters = new Statement[constructor.getParameterTypes().length];
			for(int i=0; i<constructor.getParameterTypes().length; i++) {
				Class<?> parameterType = constructor.getParameterTypes()[i];
				parameters[i] = parameterType.isPrimitive() ? statementConstructor.getConstructStatement(parameterType, isNonConstant) : new ConstantStatement<Object>(null);
			}
			return new ConstructObjectStatement(constructor, parameters);
		}
	}
	
	private static class NonNullConstructObjectStatementConstructor implements ConstructObjectStatementConstructor {
		private final Map<Class<?>,ConstructorDescriptor> constructors;
		private final PrimitiveConstructor primitive;
		private NonNullConstructObjectStatementConstructor(Iterable<Class<?>> classes, PrimitiveConstructor primitive, boolean useStringForObject) {
			this.primitive = primitive;
			List<Class<?>> classList = new ArrayList<Class<?>>();
			for(Class<?> klass : classes) {
				classList.add(klass);
			}
			this.constructors = closure(classList);
			if(useStringForObject) {
				this.constructors.put(Object.class, new ConstructorDescriptor(Constants.getEmptyStringConstructor(), new Class[]{}));
				this.constructors.put(Comparable.class, new ConstructorDescriptor(Constants.getEmptyStringConstructor(), new Class[]{}));
			}
		}
		@Override
		public Statement<Object> getConstructObjectStatement(ConstructStatementConstructor statementConstructor, Class<?> klass, boolean isNonConstant) {
			if(!this.constructors.containsKey(klass)) {
				if(klass.equals(Object.class)) {
					try {
						return new ConstructObjectStatement(String.class.getConstructor(), new Statement[0]);
					} catch(Exception e) {
						throw new RuntimeException();
					}
				}
				if(isNonConstant) {
					throw new RuntimeException();
				}
				return new ConstantStatement<Object>(null);
			}
			if(!isNonConstant) {
				if(klass.equals(Object.class) || klass.equals(Comparable.class) || klass.equals(String.class)) {
					return new ConstantStatement<Object>("");
				} else if(klass.equals(Boolean.class)) {
					return new ConstantStatement<Object>(primitive.getBoolean());
				} else if(klass.equals(Byte.class)) {
					return new ConstantStatement<Object>(primitive.getByte());
				} else if(klass.equals(Character.class)) {
					return new ConstantStatement<Object>(primitive.getChar());
				} else if(klass.equals(Short.class)) {
					return new ConstantStatement<Object>(primitive.getShort());
				} else if(klass.equals(Integer.class)) {
					return new ConstantStatement<Object>(primitive.getInt());
				} else if(klass.equals(Long.class)) {
					return new ConstantStatement<Object>(primitive.getLong());
				} else if(klass.equals(Float.class)) {
					return new ConstantStatement<Object>(primitive.getFloat());
				} else if(klass.equals(Double.class)) {
					return new ConstantStatement<Object>(primitive.getDouble());
				}
			}
			ConstructorDescriptor descriptor = this.constructors.get(klass);
			Statement<Object>[] parameters = new Statement[descriptor.constructor.getParameterTypes().length];
			for(int i=0; i<descriptor.constructor.getParameterTypes().length; i++) {
				parameters[i] = statementConstructor.getConstructStatement(descriptor.parameterClasses[i], isNonConstant);
			}
			return new ConstructObjectStatement(descriptor.constructor, parameters);
		}
	}
	
	private static class DefaultConstructStatementConstructor implements ConstructStatementConstructor {
		private final ConstructStatementConstructor statementConstructor;
		private DefaultConstructStatementConstructor(Iterable<Class<?>> classes, PrimitiveConstructor primitive, int arrayLength, boolean isNonNull, boolean useStringForObject) {
			ConstructObjectStatementConstructor objectConstructor = isNonNull ? new NonNullConstructObjectStatementConstructor(classes, primitive, useStringForObject) : new SimpleConstructObjectStatementConstructor(new DefaultPrimitiveConstructor(), classes);
			this.statementConstructor = new ProxyConstructStatementConstructor(objectConstructor, primitive, arrayLength);
		}
		@Override
		public Statement<Object> getConstructStatement(Class<?> klass, boolean isInput) {
			return this.statementConstructor.getConstructStatement(klass, isInput);
		}
	}
	
	public static List<Boolean> getAllBooleans() {
		List<Boolean> booleans = new ArrayList<Boolean>();
		booleans.add(true);
		booleans.add(false);
		return booleans;
	}
	
	public static List<ConstructStatementConstructor> getDefaultConstructStatementConstructors(Iterable<Class<?>> classes, boolean isNonNull) {
		List<ConstructStatementConstructor> constructors = new ArrayList<ConstructStatementConstructor>();
		for(boolean useStringForObject : getAllBooleans()) {
			constructors.add(new DefaultConstructStatementConstructor(classes, new DefaultPrimitiveConstructor(), Settings.DEFAULT_ARRAY_LENGTH, isNonNull, useStringForObject));
		}
		return constructors;
	}
	
	public static List<ConstructStatementConstructor> getDefaultConstructStatementConstructors(Iterable<Class<?>> classes, Iterable<Boolean> isNonNulls) {
		List<ConstructStatementConstructor> constructors = new ArrayList<ConstructStatementConstructor>();
		for(boolean isNonNull : isNonNulls) {
			constructors.addAll(getDefaultConstructStatementConstructors(classes, isNonNull));
		}
		return constructors;
	}
}
