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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Utils {
	public static <K,V> Map<V,K> getInverse(Map<K,V> map) {
		Map<V,K> inverse = new HashMap<V,K>();
		for(Map.Entry<K,V> entry : map.entrySet()) {
			if(inverse.containsKey(entry.getValue())) {
				throw new RuntimeException("Map not invertible!");
			}
			inverse.put(entry.getValue(), entry.getKey());
		}
		return inverse;
	}
	
	public static <V> Map<V,Integer> getInverse(List<V> list) {
		Map<V,Integer> inverse = new HashMap<V,Integer>();
		for(int i=0; i<list.size(); i++) {
			inverse.put(list.get(i), i);
		}
		return inverse;
	}
	
	public static <K,V> MultivalueMap<V,K> getMultiInverse(Map<K,V> map) {
		MultivalueMap<V,K> inverse = new MultivalueMap<V,K>();
		for(Map.Entry<K,V> entry  : map.entrySet()) {
			inverse.add(entry.getValue(), entry.getKey());
		}
		return inverse;
	}
	
	public static <T> List<T> getList(T ... ts) {
		List<T> tlist = new ArrayList<T>();
		for(T t : ts) {
			tlist.add(t);
		}
		return tlist;
	}
	
	public static class Counter<K> {
		private Map<K,Integer> counts = new HashMap<K,Integer>();
		private int totalCount = 0;

		public int getCount(K k) {
			Integer count = this.counts.get(k);
			if(count == null) {
				count = 0;
				this.counts.put(k, count);
			}
			return count;
		}

		public void increment(K k) {
			this.totalCount++;
			this.setCount(k, this.getCount(k)+1);
		}

		public void setCount(K k, int count) {
			Integer oldCount = this.counts.get(k);
			if(oldCount != null) {
				this.totalCount -= oldCount;
			}
			this.counts.put(k, count);
			this.totalCount += count;
		}

		public Set<K> keySet() {
			return this.counts.keySet();
		}

		public Set<Map.Entry<K,Integer>> entrySet() {
			return this.counts.entrySet();
		}
		
		public int getTotalCount() {
			return this.totalCount;
		}

		public List<K> sortedKeySet() {
			List<K> keys = new ArrayList<K>(this.keySet());
			Collections.sort(keys, new Comparator<K>() {
				@Override public int compare(K k1, K k2) {
					int i1 = getCount(k1);
					int i2 = getCount(k2);
					if(i1 < i2) {
						return 1;
					} else if(i1 == i2) {
						return 0;
					} else {
						return -1;
					}
				}
			});
			return keys;
		}
	}

	public static class MultivalueMap<K,V> extends HashMap<K,Set<V>> {
		private static final long serialVersionUID = -6390444829513305915L;
		
		public MultivalueMap() {}

		public MultivalueMap(MultivalueMap<K,V> other) {
			this.addAll(other);
		}

		public void add(K k, V v) {
			ensure(k).add(v);
		}
		
		public Set<V> ensure(K k) {
			Set<V> vSet = super.get(k);
			if(vSet == null) {
				super.put(k, vSet = new HashSet<V>());
			}
			return vSet;
		}
		
		public void addAll(MultivalueMap<K,V> other) {
			for(Map.Entry<K,Set<V>> entry : other.entrySet()) {
				for(V v : entry.getValue()) {
					this.add(entry.getKey(), v);
				}
			}
		}

		@Override
		public Set<V> get(Object k) {
			Set<V> vSet = super.get(k);
			return vSet == null ? new HashSet<V>() : vSet;
		}
	}

	public static class Pair<X,Y> {
		private final X x;
		private final Y y;

		public Pair(X x, Y y) {
			this.x = x;
			this.y = y;
		}
		
		public X getX() {
			return this.x;
		}

		public Y getY() {
			return this.y;
		}

		@Override
		public String toString() {
			return "[" + this.x.toString() + "," + this.y.toString() + "]";
		}

		@Override
		public int hashCode() {
			return 37*this.x.hashCode() + this.y.hashCode();
		}

		@SuppressWarnings("rawtypes")
		@Override
		public boolean equals(Object obj) {
			Pair other = (Pair)obj;
			return this.x.equals(other.x) && this.y.equals(other.y);
		}
	}

	public static class Triple<X,Y,Z> {
		private final X x;
		private final Y y;
		private final Z z;

		public Triple(X x, Y y, Z z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		public X getX() {
			return this.x;
		}

		public Y getY() {
			return this.y;
		}
		
		public Z getZ() {
			return this.z;
		}

		@Override
		public String toString() {
			return "[" + this.x.toString() + "," + this.y.toString() + "," + this.z.toString() + "]";
		}

		@Override
		public int hashCode() {
			return 37*(37*this.x.hashCode() + this.y.hashCode()) + this.z.hashCode();
		}

		@SuppressWarnings("rawtypes")
		@Override
		public boolean equals(Object obj) {
			Triple other = (Triple)obj;
			return this.x.equals(other.x) && this.y.equals(other.y) && this.z.equals(other.z);
		}
	}

	public static class Quadruple<X,Y,Z,W> {
		private final X x;
		private final Y y;
		private final Z z;
		private final W w;

		public Quadruple(X x, Y y, Z z, W w) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.w = w;
		}
		
		public X getX() {
			return this.x;
		}

		public Y getY() {
			return this.y;
		}
		
		public Z getZ() {
			return this.z;
		}
		
		public W getW() {
			return this.w;
		}

		@Override
		public String toString() {
			return "[" + this.x.toString() + "," + this.y.toString() + "," + this.z.toString() + "," + this.w.toString() + "]";
		}

		@Override
		public int hashCode() {
			return 37*(37*(37*this.x.hashCode() + this.y.hashCode()) + this.z.hashCode()) + this.w.hashCode();
		}

		@SuppressWarnings("rawtypes")
		@Override
		public boolean equals(Object obj) {
			Quadruple other = (Quadruple)obj;
			return this.x.equals(other.x) && this.y.equals(other.y) && this.z.equals(other.z) && this.w.equals(other.w);
		}
	}
	
	public static interface Filter<T> {
		public abstract boolean filter(T t);
	}
	
	public static class OrFilter<T> implements Filter<T> {
		private final List<Filter<T>> filters = new ArrayList<Filter<T>>();
		@SuppressWarnings("unchecked")
		public OrFilter(Filter<T> ... filters) {
			for(Filter<T> filter : filters) {
				this.filters.add(filter);
			}
		}
		@Override
		public boolean filter(T t) {
			for(Filter<T> filter : this.filters) {
				if(filter.filter(t)) {
					return true;
				}
			}
			return false;
		}
	}
	
	public static class AndFilter<T> implements Filter<T> {
		private final List<Filter<T>> filters = new ArrayList<Filter<T>>();
		public AndFilter(Filter<T> ... filters) {
			for(Filter<T> filter : filters) {
				this.filters.add(filter);
			}
		}
		@Override
		public boolean filter(T t) {
			for(Filter<T> filter : this.filters) {
				if(!filter.filter(t)) {
					return false;
				}
			}
			return true;
		}
	}
	
	public static class NotFilter<T> implements Filter<T> {
		public final Filter<T> filter;
		public NotFilter(Filter<T> filter) { this.filter = filter; }
		@Override
		public boolean filter(T t) {
			return !this.filter.filter(t);
		}
	}
	
	public static class ConstantFilter<T> implements Filter<T> {
		private final boolean value;
		public ConstantFilter(boolean value) {
			this.value = value;
		}
		public boolean filter(T t) {
			return this.value;
		}
	}

	public static class Maybe<T> {
		private T t;
		public Maybe(T t) {
			this.t = t;
		}
		public Maybe() {
			this.t = null;
		}
		public T getT() {
			if(this.t != null) {
				return t;
			}
			throw new RuntimeException("Invalid!");
		}
		public boolean hasT() {
			return this.t != null;
		}
		public T getTOr(T t) {
			return this.hasT() ? this.getT() : t;
		}
		@Override
		public String toString() {
			return "Maybe[" + (this.hasT() ? this.t.toString() : "") + "]";
		}
		public int hashCode() {
			return this.hasT() ? this.getT().hashCode() : 0;
		}
		@Override
		public boolean equals(Object obj) {
			Maybe<T> other = (Maybe<T>)obj;
			return this.hasT() == other.hasT() && ((!this.hasT() && !other.hasT()) || this.getT().equals(other.getT()));
		}
	}
	
	public static <T> List<T> join(List<T> ... tss) {
		List<T> allTs = new ArrayList<T>();
		for(List<T> ts : tss) {
			allTs.addAll(ts);
		}
		return allTs;
	}
	
	public static <T> String join(String join, Iterable<T> ts) {
		StringBuilder sb = new StringBuilder();
		for(T t : ts) {
			sb.append(t.toString()).append(join);
		}
		return sb.substring(0, sb.length() - join.length());
	}
	
	public static String toString(double[] doubles) {
		List<Double> doubleList = new ArrayList<Double>();
		for(int i=0; i<doubles.length; i++) {
			doubleList.add(doubles[i]);
		}
		return toString(doubleList);
	}
	
	public static <T> String toString(List<T> ts) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(T t : ts) {
			sb.append(t.toString()).append(", ");
		}
		if(!ts.isEmpty()) {
			sb.delete(sb.length()-2, sb.length());
		}
		sb.append("]");
		return sb.toString();
	}
	
	public static void runForceTimeout(Runnable runnable, long timeoutMillis) {
		Thread thread = new Thread(runnable);
		thread.start();
		try {
			thread.join(timeoutMillis);
		} catch(Exception e) {}
		if(thread.isAlive()) {
			thread.stop();
			throw new RuntimeException();
		}
	}
}
