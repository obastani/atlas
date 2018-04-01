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

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import atlas.ReflectionUtils.Callable;
import atlas.Utils.Pair;

public class StatementUtils {
	public static interface Statement<T> {
		public abstract T execute(Map<String,Object> store);
		public abstract String code();
	}
	
	public static <T> T execute(Statement<T> statement) {
		return statement.execute(new HashMap<String,Object>());
	}
	
	public static Pair<HashMap<String,Object>,Object> executeForStore(Statement<?> statement) {
		HashMap<String,Object> store = new HashMap<String,Object>();
		Object output = statement.execute(store);
		return new Pair<HashMap<String,Object>,Object>(store, output);
	}
	
	public static class SequenceStatement implements Statement<Object> {
		private final Statement<Object>[] statements;
		public SequenceStatement(Statement<Object> ... statements) {
			this.statements = statements;
		}
		@Override
		public Object execute(Map<String,Object> store) {
			for(int i=0; i<this.statements.length-1; i++) {
				this.statements[i].execute(store);
			}
			return this.statements[this.statements.length-1].execute(store);
		}
		@Override
		public String code() {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<this.statements.length-1; i++) {
				sb.append(this.statements[i].code()).append("; ");
			}
			sb.append(this.statements[this.statements.length-1].code());
			return sb.toString();
		}
	}
	
	public static class InvokeStatement implements Statement<Object> {
		private final Callable method;
		private final Statement<Object>[] parameterStatements;
		public InvokeStatement(Callable method, Statement<Object>[] parameterStatements) {
			if(method.getParameterCount() != parameterStatements.length) {
				throw new RuntimeException();
			}
			this.method = method;
			this.parameterStatements = parameterStatements;
		}
		@Override
		public Object execute(Map<String,Object> store) {
			Object receiver = this.method.isStatic() ? null : this.parameterStatements[0].execute(store);
			Object[] parameters = new Object[this.method.getRawParameterTypes().length];
			for(int i=0; i<this.method.getRawParameterTypes().length; i++) {
				parameters[i] = this.parameterStatements[i + (this.method.isStatic() ? 0 : 1)].execute(store);
			}
			try {
				return this.method.invoke(receiver, parameters);
			} catch(Exception e) {
				throw new RuntimeException(e);
			}
		}
		@Override
		public String code() {
			StringBuilder sb = new StringBuilder();
			if(!method.isStatic()) {
				sb.append(this.parameterStatements[0].code()).append(".");
			}
			sb.append(this.method.getName()).append("(");
			for(int i=0; i<this.method.getRawParameterTypes().length; i++) {
				sb.append(this.parameterStatements[i + (this.method.isStatic() ? 0 : 1)].code()).append(", ");
			}
			if(this.method.getRawParameterTypes().length > 0) {
				sb.delete(sb.length()-2, sb.length());
			}
			sb.append(")");
			return sb.toString();
		}
	}
	
	public static class StoreStatement implements Statement<Object> {
		private final String name;
		private final Statement<Object> statement;
		
		public StoreStatement(String name, Statement<Object> statement) {
			this.name = name;
			this.statement = statement;
		}
		
		@Override
		public Object execute(Map<String,Object> store) {
			Object obj = this.statement.execute(store);
			store.put(this.name, obj);
			return null;
		}

		@Override
		public String code() {
			StringBuilder sb = new StringBuilder();
			sb.append(this.name).append(" = ").append(this.statement.code());
			return sb.toString();
		}
	}
	
	public static class LoadStatement implements Statement<Object> {
		private final String name;
		
		public LoadStatement(String name) {
			this.name = name;
		}

		@Override
		public Object execute(Map<String,Object> store) {
			return store.get(this.name);
		}

		@Override
		public String code() {
			return this.name;
		}
	}
	
	public static class ConstantStatement<T> implements Statement<T> {
		private final T t;
		public ConstantStatement(T t) {
			this.t = t;
		}
		@Override
		public T execute(Map<String,Object> store) {
			return this.t;
		}
		@Override
		public String code() {
			return this.t == null ? "null" : this.t.toString();
		}
	}
	
	public static class ConstructObjectStatement implements Statement<Object> {
		private final Constructor<?> constructor;
		private final Statement<Object>[] parameterStatements;
		public ConstructObjectStatement(Constructor<?> constructor, Statement<Object>[] parameterStatements) {
			if(constructor.getParameterTypes().length != parameterStatements.length) {
				throw new RuntimeException();
			}
			this.constructor = constructor;
			this.parameterStatements = parameterStatements;
		}
		@Override
		public Object execute(Map<String,Object> store) {
			Object[] parameters = new Object[this.constructor.getParameterTypes().length];
			for(int i=0; i<this.constructor.getParameterTypes().length; i++) {
				parameters[i] = this.parameterStatements[i].execute(store);
			}
			try {
				return this.constructor.newInstance(parameters);
			} catch(Exception e) {
				throw new RuntimeException(e);
			}
		}
		@Override
		public String code() {
			StringBuilder sb = new StringBuilder();
			sb.append("(new ").append(this.constructor.getDeclaringClass().getName()).append("(");
			for(int i=0; i<this.parameterStatements.length; i++) {
				sb.append(this.parameterStatements[i].code()).append(", ");
			}
			if(this.parameterStatements.length > 0) {
				sb.delete(sb.length()-2, sb.length());
			}
			sb.append("))");
			return sb.toString();
		}
	}
	
	private static String codeArray(String componentType, Statement<?>[] componentStatements) {
		StringBuilder sb = new StringBuilder();
		sb.append("new ").append(componentType).append("[").append(componentStatements.length).append("]{");
		for(int i=0; i<componentStatements.length; i++) {
			sb.append(componentStatements[i].code()).append(", ");
		}
		if(componentStatements.length > 0) {
			sb.delete(sb.length()-2, sb.length());
		}
		sb.append("}");
		return sb.toString();
	}
	
	public static class ConstructArrayStatement implements Statement<Object> {
		private final Class<?> componentType;
		private final Statement<Object>[] componentStatements;
		public ConstructArrayStatement(Class<?> componentType, Statement<Object>[] componentStatements) {
			this.componentType = componentType;
			this.componentStatements = componentStatements;
		}
		@Override
		public Object execute(Map<String,Object> store) {
			Object array = Array.newInstance(this.componentType, this.componentStatements.length);
			for(int i=0; i<this.componentStatements.length; i++) {
				Array.set(array, i, this.componentStatements[i].execute(store));
			}
			return array;
		}
		@Override
		public String code() {
			return codeArray(this.componentType.getName(), this.componentStatements);
		}
	}
	
	public static class ConstructBooleanArrayStatement implements Statement<Object> {
		private final Statement<Boolean>[] componentStatements;
		public ConstructBooleanArrayStatement(Statement<Boolean>[] componentValues) {
			this.componentStatements = componentValues;
		}
		@Override
		public Object execute(Map<String,Object> store) {
			Object array = Array.newInstance(boolean.class, this.componentStatements.length);
			for(int i=0; i<this.componentStatements.length; i++) {
				Array.setBoolean(array, i, this.componentStatements[i].execute(store));
			}
			return array;
		}
		@Override
		public String code() {
			return codeArray("boolean", this.componentStatements);
		}
	}
	
	public static class ConstructByteArrayStatement implements Statement<Object> {
		private final Statement<Byte>[] componentStatements;
		public ConstructByteArrayStatement(Statement<Byte>[] componentValues) {
			this.componentStatements = componentValues;
		}
		@Override
		public Object execute(Map<String,Object> store) {
			Object array = Array.newInstance(byte.class, this.componentStatements.length);
			for(int i=0; i<this.componentStatements.length; i++) {
				Array.setByte(array, i, this.componentStatements[i].execute(store));
			}
			return array;
		}
		@Override
		public String code() {
			return codeArray("byte", this.componentStatements);
		}
	}
	
	public static class ConstructCharArrayStatement implements Statement<Object> {
		private final Statement<Character>[] componentStatements;
		public ConstructCharArrayStatement(Statement<Character>[] componentValues) {
			this.componentStatements = componentValues;
		}
		@Override
		public Object execute(Map<String,Object> store) {
			Object array = Array.newInstance(char.class, this.componentStatements.length);
			for(int i=0; i<this.componentStatements.length; i++) {
				Array.setChar(array, i, this.componentStatements[i].execute(store));
			}
			return array;
		}
		@Override
		public String code() {
			return codeArray("char", this.componentStatements);
		}
	}
	
	public static class ConstructShortArrayStatement implements Statement<Object> {
		private final Statement<Short>[] componentStatements;
		public ConstructShortArrayStatement(Statement<Short>[] componentValues) {
			this.componentStatements = componentValues;
		}
		@Override
		public Object execute(Map<String,Object> store) {
			Object array = Array.newInstance(short.class, this.componentStatements.length);
			for(int i=0; i<this.componentStatements.length; i++) {
				Array.setShort(array, i, this.componentStatements[i].execute(store));
			}
			return array;
		}
		@Override
		public String code() {
			return codeArray("short", this.componentStatements);
		}
	}
	
	public static class ConstructIntArrayStatement implements Statement<Object> {
		private final Statement<Integer>[] componentStatements;
		public ConstructIntArrayStatement(Statement<Integer>[] componentValues) {
			this.componentStatements = componentValues;
		}
		@Override
		public Object execute(Map<String,Object> store) {
			Object array = Array.newInstance(int.class, this.componentStatements.length);
			for(int i=0; i<this.componentStatements.length; i++) {
				Array.setInt(array, i, this.componentStatements[i].execute(store));
			}
			return array;
		}
		@Override
		public String code() {
			return codeArray("int", this.componentStatements);
		}
	}
	
	public static class ConstructLongArrayStatement implements Statement<Object> {
		private final Statement<Long>[] componentStatements;
		public ConstructLongArrayStatement(Statement<Long>[] componentValues) {
			this.componentStatements = componentValues;
		}
		@Override
		public Object execute(Map<String,Object> store) {
			Object array = Array.newInstance(long.class, this.componentStatements.length);
			for(int i=0; i<this.componentStatements.length; i++) {
				Array.setLong(array, i, this.componentStatements[i].execute(store));
			}
			return array;
		}
		@Override
		public String code() {
			return codeArray("long", this.componentStatements);
		}
	}
	
	public static class ConstructFloatArrayStatement implements Statement<Object> {
		private final Statement<Float>[] componentStatements;
		public ConstructFloatArrayStatement(Statement<Float>[] componentValues) {
			this.componentStatements = componentValues;
		}
		@Override
		public Object execute(Map<String,Object> store) {
			Object array = Array.newInstance(float.class, this.componentStatements.length);
			for(int i=0; i<this.componentStatements.length; i++) {
				Array.setFloat(array, i, this.componentStatements[i].execute(store));
			}
			return array;
		}
		@Override
		public String code() {
			return codeArray("float", this.componentStatements);
		}
	}
	
	public static class ConstructDoubleArrayStatement implements Statement<Object> {
		private final Statement<Double>[] componentStatements;
		public ConstructDoubleArrayStatement(Statement<Double>[] componentValues) {
			this.componentStatements = componentValues;
		}
		@Override
		public Object execute(Map<String,Object> store) {
			Object array = Array.newInstance(double.class, this.componentStatements.length);
			for(int i=0; i<this.componentStatements.length; i++) {
				Array.setDouble(array, i, this.componentStatements[i].execute(store));
			}
			return array;
		}
		@Override
		public String code() {
			return codeArray("double", this.componentStatements);
		}
	}
}
