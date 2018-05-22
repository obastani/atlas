package java.util;

import java.util.Map;

public class LinkedHashMap<K,V> extends java.util.AbstractMap<K,V> implements java.util.Map<K, V> {
	public K k;
	public V v;
	public LinkedHashMap(java.util.Map<? extends K, ? extends V> p0) {
		k = p0.keySet().iterator().next();
		v = p0.values().iterator().next();
	}
	public LinkedHashMap() {
	}
	public V get(java.lang.Object p0) {
		return v;
	}
	public java.util.Collection<V> values() {
		ArrayList<V> r = new ArrayList<V>();
		r.f = v;
		return r;
	}
	public void clear() {
	}
	public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
		HashSet<java.util.Map.Entry<K,V>> r = new HashSet<java.util.Map.Entry<K,V>>();
		AtlasEntry<K,V> e = new AtlasEntry<K,V>();
		e.k = k;
		e.v = v;
		r.f = e;
		return r;
	}
	public java.util.Set<K> keySet() {
		HashSet<K> r = new HashSet<K>();
		r.f = k;
		return r;
	}
	public boolean containsValue(java.lang.Object p0) {
		return false;
	}
	public V getOrDefault(java.lang.Object p0, V p1) {
		V v = p1;
		return v;
	}
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> p0) {
		return false;
	}
	public boolean containsKey(Object key) {
		return false;
	}
	public boolean isEmpty() {
		return false;
	}
	public V put(K key, V value) {
		k = key;
		v = value;
		return v;
	}
	public void putAll(Map<? extends K, ? extends V> m) {
		k = m.keySet().iterator().next();
		v = m.values().iterator().next();
	}
	public V remove(Object key) {
		return v;
	}
	public int size() {
		return 0;
	}
}
