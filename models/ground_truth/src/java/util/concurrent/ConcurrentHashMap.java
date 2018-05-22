package java.util.concurrent;

import java.util.ArrayList;
import java.util.AtlasEntry;
import java.util.AtlasEnumeration;
import java.util.HashSet;

public class ConcurrentHashMap<K,V> extends java.util.AbstractMap<K,V> implements java.util.concurrent.ConcurrentMap<K, V>, java.io.Serializable {
	public K k;
	public V v;
	public ConcurrentHashMap(java.util.Map<? extends K, ? extends V> p0) {
		k = p0.keySet().iterator().next();
		v = p0.values().iterator().next();
	}
	public ConcurrentHashMap() {
	}
	public boolean remove(java.lang.Object p0, java.lang.Object p1) {
		return false;
	}
	public V remove(java.lang.Object p0) {
		return v;
	}
	public V get(java.lang.Object p0) {
		return v;
	}
	public V put(K p0, V p1) {
		k = p0;
		v = p1;
		return v;
	}
	public boolean equals(java.lang.Object p0) {
		return false;
	}
	public java.lang.String toString() {
		return "";
	}
	public java.util.Collection<V> values() {
		ArrayList<V> r = new ArrayList<V>();
		r.f = v;
		return r;
	}
	public int hashCode() {
		return 0;
	}
	public void clear() {
	}
	public boolean isEmpty() {
		return false;
	}
	public boolean replace(K p0, V p1, V p2) {
		k = p0;
		v = p2;
		return false;
	}
	public V replace(K p0, V p1) {
		k = p0;
		v = p1;
		return v;
	}
	public boolean contains(java.lang.Object p0) {
		return false;
	}
	public int size() {
		return 0;
	}
	public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
		HashSet<java.util.Map.Entry<K,V>> r = new HashSet<java.util.Map.Entry<K,V>>();
		AtlasEntry<K,V> e = new AtlasEntry<K,V>();
		e.k = k;
		e.v = v;
		r.f = e;
		return r;
	}
	public void putAll(java.util.Map<? extends K, ? extends V> p0) {
		k = p0.keySet().iterator().next();
		v = p0.values().iterator().next();
	}
	public V putIfAbsent(K p0, V p1) {
		k = p0;
		v = p1;
		return v;
	}
	public java.util.Enumeration<V> elements() {
		AtlasEnumeration<V> r = new AtlasEnumeration<V>();
		r.f = v;
		return r;
	}
	public java.util.Enumeration<K> keys() {
		AtlasEnumeration<K> r = new AtlasEnumeration<K>();
		r.f = k;
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
	public boolean containsKey(java.lang.Object p0) {
		return false;
	}
	public V getOrDefault(java.lang.Object p0, V p1) {
		V r = v;
		r = p1;
		return v;
	}
	public long mappingCount() {
		return 0;
	}
	public Object clone() {
		ConcurrentHashMap<K,V> r = new ConcurrentHashMap<K,V>();
		r.k = k;
		r.v = v;
		return r;
	}
}
