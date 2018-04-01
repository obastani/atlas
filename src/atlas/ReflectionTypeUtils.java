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
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ReflectionTypeUtils {
	public static final AtlasType ATLAS_OBJECT_TYPE = new AtlasClassType(Object.class);
	public static interface AtlasType {
		public abstract Class<?> getBaseType();
	}
	public static class AtlasClassType implements AtlasType {
		public final Class<?> klass;
		public AtlasClassType(Class<?> klass) {
			this.klass = klass;
		}
		public Class<?> getBaseType() {
			return this.klass;
		}
		@Override
		public int hashCode() {
			return this.klass.hashCode();
		}
		@Override
		public boolean equals(Object obj) {
			if(!(obj instanceof AtlasClassType)) {
				return false;
			}
			AtlasClassType other = (AtlasClassType)obj;
			return this.klass.equals(other.klass);
		}
		@Override
		public String toString() {
			return this.klass.getName();
		}
	}
	public static class AtlasGenericArrayType implements AtlasType {
		public final AtlasType componentType;
		public AtlasGenericArrayType(AtlasType componentType) {
			this.componentType = componentType;
		}
		public Class<?> getBaseType() {
			return Array.newInstance(this.componentType.getBaseType(), 0).getClass();
		}
		@Override
		public int hashCode() {
			return this.componentType.hashCode();
		}
		@Override
		public boolean equals(Object obj) {
			if(!(obj instanceof AtlasGenericArrayType)) {
				return false;
			}
			AtlasGenericArrayType other = (AtlasGenericArrayType)obj;
			return this.componentType.equals(other.componentType);
		}
		@Override
		public String toString() {
			return this.componentType.toString() + "[]";
		}
	}
	public static class AtlasParameterizedType implements AtlasType {
		public final AtlasType baseType;
		public final AtlasType[] typeParameters;
		public AtlasParameterizedType(AtlasType baseType, AtlasType[] typeParameters) {
			if(typeParameters.length == 0) {
				Log.info("WARNING: EMPTY TYPE PARAMETERS FOR " + baseType.toString());
			}
			this.baseType = baseType;
			this.typeParameters = typeParameters;
		}
		public Class<?> getBaseType() {
			return this.baseType.getBaseType();
		}
		@Override
		public int hashCode() {
			int hash = this.baseType.hashCode();
			for(AtlasType type : this.typeParameters) {
				hash = 31*hash + type.hashCode();
			}
			return hash;
		}
		@Override
		public boolean equals(Object obj) {
			if(!(obj instanceof AtlasParameterizedType)) {
				return false;
			}
			AtlasParameterizedType other = (AtlasParameterizedType)obj;
			if(!this.baseType.equals(other.baseType) || this.typeParameters.length != other.typeParameters.length) {
				return false;
			}
			for(int i=0; i<this.typeParameters.length; i++) {
				if(!this.typeParameters[i].equals(other.typeParameters[i])) {
					return false;
				}
			}
			return true;
		}
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(this.baseType.toString()).append("<");
			for(AtlasType typeParameter : this.typeParameters) {
				sb.append(typeParameter.toString()).append(",");
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append(">");
			return sb.toString();
		}
	}
	public static class AtlasTypeBindings {
		private final Map<TypeVariable<?>,AtlasType> bindings = new HashMap<TypeVariable<?>,AtlasType>();
		public AtlasTypeBindings(AtlasTypeBindings bindings) {
			this.bindings.putAll(bindings.bindings);
		}
		public AtlasTypeBindings() {}
		public AtlasType get(TypeVariable<?> type) {
			return this.bindings.getOrDefault(type, ATLAS_OBJECT_TYPE);
		}
		public Set<TypeVariable<?>> variables() {
			return this.bindings.keySet();
		}
		@Override
		public int hashCode() {
			return this.bindings.hashCode();
		}
		@Override
		public boolean equals(Object obj) {
			AtlasTypeBindings other = (AtlasTypeBindings)obj;
			return this.bindings.equals(other.bindings);
		}
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("{");
			for(TypeVariable<?> variable : this.variables()) {
				sb.append(variable).append(" in ").append(variable.getGenericDeclaration()).append(": ").append(this.bindings.get(variable)).append(", ");
			}
			if(!this.variables().isEmpty()) {
				sb.delete(sb.length()-2, sb.length());
			}
			sb.append("}");
			return sb.toString();
		}
		private void add(TypeVariable<?> variable, AtlasType type) {
			if(this.bindings.containsKey(variable) && !this.get(variable).equals(type)) {
				throw new RuntimeException();
			} else if(!type.equals(ATLAS_OBJECT_TYPE)) {
				this.bindings.put(variable, type);
			}
		}
		private void addAll(AtlasTypeBindings bindings) {
			this.bindings.putAll(bindings.bindings);
		}
	}
	public static AtlasType getAtlasType(Type type, AtlasTypeBindings bindings) {
		if(type instanceof Class<?>) {
			return new AtlasClassType((Class<?>)type);
		} else if(type instanceof GenericArrayType) {
			return new AtlasGenericArrayType(getAtlasType(((GenericArrayType)type).getGenericComponentType(), bindings));
		} else if(type instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType)type;
			AtlasType[] typeParameters = new AtlasType[parameterizedType.getActualTypeArguments().length];
			for(int i=0; i<typeParameters.length; i++) {
				typeParameters[i] = getAtlasType(parameterizedType.getActualTypeArguments()[i], bindings);
			}
			return new AtlasParameterizedType(getAtlasType(parameterizedType.getRawType(), bindings), typeParameters);
		} else if(type instanceof TypeVariable<?>) {
			return bindings.get((TypeVariable<?>)type);
		} else if(type instanceof WildcardType) {
			return ATLAS_OBJECT_TYPE;
		} else {
			throw new RuntimeException();
		}
	}
	private static AtlasTypeBindings getCurBindings(Type type, AtlasTypeBindings bindings) {
		AtlasTypeBindings newBindings = new AtlasTypeBindings();
		if(type instanceof ParameterizedType) {
			Class<?> baseType = getAtlasType(type, bindings).getBaseType();
			ParameterizedType parameterizedType = (ParameterizedType)type;
			if(baseType.getTypeParameters().length != parameterizedType.getActualTypeArguments().length) {
				throw new RuntimeException();
			}
			for(int i=0; i<parameterizedType.getActualTypeArguments().length; i++) {
				newBindings.add(baseType.getTypeParameters()[i], getAtlasType(parameterizedType.getActualTypeArguments()[i], bindings));
			}
		} else if(type instanceof TypeVariable) {
			newBindings.add((TypeVariable<?>)type, getAtlasType(type, bindings));
		}
		return newBindings;
	}
	private static void getBindingsHelper(Type type, AtlasTypeBindings bindings) {
		bindings.addAll(getCurBindings(type, bindings));
		Class<?> baseType = getAtlasType(type, bindings).getBaseType();
		if(baseType.getSuperclass() != null) {
			getBindingsHelper(baseType.getGenericSuperclass(), bindings);
		}
		for(Type interfaceType : baseType.getGenericInterfaces()) {
			getBindingsHelper(interfaceType, bindings);
		}
	}
	public static AtlasTypeBindings getBindings(Type type, AtlasTypeBindings curBindings) {
		AtlasTypeBindings bindings = new AtlasTypeBindings(getCurBindings(type, curBindings));
		getBindingsHelper(type, bindings);
		return bindings;
	}
	public static AtlasTypeBindings getBindings(Type type) {
		return getBindings(type, new AtlasTypeBindings());
	}
}
