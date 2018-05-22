package java.util;

public class HashMap<K,V> extends java.util.AbstractMap<K,V> implements java.util.Map<K,V>, java.lang.Cloneable, java.io.Serializable {
	public K k;
	public V v;
	public HashMap(java.util.Map<? extends K, ? extends V> p0) {
		k = p0.keySet().iterator().next();
		v = p0.values().iterator().next();
	}
	public HashMap() {
	}
	public V remove(java.lang.Object p0) {
		return v;
	}
	public boolean remove(java.lang.Object p0, java.lang.Object p1) {
		return false;
	}
	public V get(java.lang.Object p0) {
		return v;
	}
	public V put(K p0, V p1) {
		k = p0;
		v = p1;
		return v;
	}
	public java.util.Collection<V> values() {
		ArrayList<V> r = new ArrayList<V>();
		r.f = v;
		return r;
	}
	public java.lang.Object clone() {
		HashMap<K,V> r = new HashMap<K,V>();
		r.k = k;
		r.v = v;
		return r;
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
	public int size() {
		return 0;
	}
	public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
		HashSet<java.util.Map.Entry<K,V>> r = new HashSet<java.util.Map.Entry<K,V>>();
		AtlasEntry<K,V> e = new AtlasEntry<K,V>();
		e.k = k;
		e.v = v;
		r.add(e);
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
	public java.util.Set<K> keySet() {
		HashSet<K> r = new HashSet<K>();
		r.f = k;
		return (java.util.Set<K>)r;
	}
	public boolean containsValue(java.lang.Object p0) {
		return false;
	}
	public boolean containsKey(java.lang.Object p0) {
		return false;
	}
	public V getOrDefault(java.lang.Object p0, V p1) {
		V r = p1;
		r = v;
		return r;
	}
}
