package java.util;
public class Hashtable<K,V> extends java.util.Dictionary<K,V> implements java.util.Map<K, V>, java.lang.Cloneable, java.io.Serializable {
	public K k;
	public V v;
	public Hashtable(java.util.Map<? extends K, ? extends V> p0) {
		k = p0.keySet().iterator().next();
		v = p0.values().iterator().next();
	}
	public Hashtable() {
	}
	public synchronized boolean remove(java.lang.Object p0, java.lang.Object p1) {
		return false;
	}
	public synchronized V remove(java.lang.Object p0) {
		return v;
	}
	public synchronized V get(java.lang.Object p0) {
		return v;
	}
	public synchronized V put(K p0, V p1) {
		k = p0;
		v = p1;
		return v;
	}
	public synchronized boolean equals(java.lang.Object p0) {
		return false;
	}
	public synchronized java.lang.String toString() {
		return "";
	}
	public java.util.Collection<V> values() {
		ArrayList<V> r = new ArrayList<V>();
		r.f = v;
		return r;
	}
	public synchronized int hashCode() {
		return 0;
	}
	public synchronized java.lang.Object clone() {
		Hashtable<K,V> r = new Hashtable<K,V>();
		r.k = k;
		r.v = v;
		return r;
	}
	public synchronized void clear() {
	}
	public synchronized boolean isEmpty() {
		return false;
	}
	public synchronized boolean replace(K p0, V p1, V p2) {
		k = p0;
		v = p2;
		return false;
	}
	public synchronized V replace(K p0, V p1) {
		k = p0;
		v = p1;
		return v;
	}
	public synchronized boolean contains(java.lang.Object p0) {
		return false;
	}
	public synchronized int size() {
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
	public synchronized void putAll(java.util.Map<? extends K, ? extends V> p0) {
		k = p0.keySet().iterator().next();
		v = p0.values().iterator().next();
	}
	public synchronized V putIfAbsent(K p0, V p1) {
		k = p0;
		v = p1;
		return v;
	}
	public synchronized java.util.Enumeration<V> elements() {
		AtlasEnumeration<V> r = new AtlasEnumeration<V>();
		r.f = v;
		return r;
	}
	public synchronized java.util.Enumeration<K> keys() {
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
	public synchronized boolean containsKey(java.lang.Object p0) {
		return false;
	}
	protected void rehash() {
	}
	public synchronized V getOrDefault(java.lang.Object p0, V p1) {
		V r = v;
		r = p1;
		return r;
	}
}
