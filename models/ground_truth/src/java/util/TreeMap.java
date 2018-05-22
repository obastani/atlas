package java.util;
public class TreeMap<K,V> extends java.util.AbstractMap<K,V> implements java.util.NavigableMap<K, V>, java.lang.Cloneable, java.io.Serializable {
	public K k;
	public V v;
	public java.util.Comparator<? super K> c = new java.util.Comparator<K>() { public int compare(K o1, K o2) { return 0; }};
	public TreeMap(java.util.SortedMap<K, ? extends V> p0) {
		k = p0.keySet().iterator().next();
		v = p0.values().iterator().next();
	}
	public TreeMap(java.util.Map<? extends K, ? extends V> p0) {
		k = p0.keySet().iterator().next();
		v = p0.values().iterator().next();
	}
	public TreeMap(java.util.Comparator<? super K> p0) {
		c = p0;
	}
	public TreeMap() {
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
	public java.util.Collection<V> values() {
		ArrayList<V> r = new ArrayList<V>();
		r.f = v;
		return r;
	}
	public java.lang.Object clone() {
		TreeMap<K,V> r = new TreeMap<K,V>();
		r.k = k;
		r.v = v;
		r.c = c;
		return r;
	}
	public void clear() {
	}
	public V replace(K p0, V p1) {
		k = p0;
		v = p1;
		return v;
	}
	public boolean replace(K p0, V p1, V p2) {
		k = p0;
		v = p2;
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
	public java.util.Comparator<? super K> comparator() {
		return c;
	}
	public java.util.NavigableSet<K> navigableKeySet() {
		AtlasNavigableSet<K> r = new AtlasNavigableSet<K>();
		r.f = k;
		r.c = c;
		return r;
	}
	public java.util.NavigableMap<K, V> descendingMap() {
		TreeMap<K,V> r = new TreeMap<K,V>();
		r.k = k;
		r.v = v;
		r.c = c;
		return r;
	}
	public K firstKey() {
		return k;
	}
	public K lastKey() {
		return k;
	}
	public java.util.Map.Entry<K, V> firstEntry() {
		AtlasEntry<K,V> r = new AtlasEntry<K,V>();
		r.k = k;
		r.v = v;
		return r;
	}
	public java.util.Map.Entry<K, V> lastEntry() {
		AtlasEntry<K,V> r = new AtlasEntry<K,V>();
		r.k = k;
		r.v = v;
		return r;
	}
	public java.util.Map.Entry<K, V> pollFirstEntry() {
		AtlasEntry<K,V> r = new AtlasEntry<K,V>();
		r.k = k;
		r.v = v;
		return r;
	}
	public java.util.Map.Entry<K, V> pollLastEntry() {
		AtlasEntry<K,V> r = new AtlasEntry<K,V>();
		r.k = k;
		r.v = v;
		return r;
	}
	public java.util.Map.Entry<K, V> lowerEntry(K p0) {
		AtlasEntry<K,V> r = new AtlasEntry<K,V>();
		r.k = k;
		r.v = v;
		return r;
	}
	public K lowerKey(K p0) {
		return k;
	}
	public java.util.Map.Entry<K, V> floorEntry(K p0) {
		AtlasEntry<K,V> r = new AtlasEntry<K,V>();
		r.k = k;
		r.v = v;
		return r;
	}
	public K floorKey(K p0) {
		return k;
	}
	public java.util.Map.Entry<K, V> ceilingEntry(K p0) {
		AtlasEntry<K,V> r = new AtlasEntry<K,V>();
		r.k = k;
		r.v = v;
		return r;
	}
	public K ceilingKey(K p0) {
		return k;
	}
	public java.util.Map.Entry<K, V> higherEntry(K p0) {
		AtlasEntry<K,V> r = new AtlasEntry<K,V>();
		r.k = k;
		r.v = v;
		return r;
	}
	public K higherKey(K p0) {
		return k;
	}
	public java.util.NavigableSet<K> descendingKeySet() {
		AtlasNavigableSet<K> r = new AtlasNavigableSet<K>();
		r.f = k;
		r.c = c;
		return r;
	}
	public java.util.NavigableMap<K, V> subMap(K p0, boolean p1, K p2, boolean p3) {
		TreeMap<K,V> r = new TreeMap<K,V>();
		r.k = k;
		r.v = v;
		r.c = c;
		return r;
	}
	public java.util.SortedMap<K, V> subMap(K p0, K p1) {
		TreeMap<K,V> r = new TreeMap<K,V>();
		r.k = k;
		r.v = v;
		r.c = c;
		return r;
	}
	public java.util.SortedMap<K, V> headMap(K p0) {
		TreeMap<K,V> r = new TreeMap<K,V>();
		r.k = k;
		r.v = v;
		r.c = c;
		return r;
	}
	public java.util.NavigableMap<K, V> headMap(K p0, boolean p1) {
		TreeMap<K,V> r = new TreeMap<K,V>();
		r.k = k;
		r.v = v;
		r.c = c;
		return r;
	}
	public java.util.SortedMap<K, V> tailMap(K p0) {
		TreeMap<K,V> r = new TreeMap<K,V>();
		r.k = k;
		r.v = v;
		r.c = c;
		return r;
	}
	public java.util.NavigableMap<K, V> tailMap(K p0, boolean p1) {
		TreeMap<K,V> r = new TreeMap<K,V>();
		r.k = k;
		r.v = v;
		r.c = c;
		return r;
	}
	public boolean isEmpty() {
		return false;
	}
}
