package java.util;

public class AtlasEntry<K,V> implements java.util.Map.Entry<K,V>, java.lang.Cloneable, java.io.Serializable {
	public K k;
	public V v;
	public K getKey() {
		return k;
	}
	public V getValue() {
		return v;
	}
	public V setValue(V value) {
		v = value;
		return v;
	}
	public Object clone() {
		AtlasEntry<K,V> r = new AtlasEntry<K,V>();
		r.k = k;
		r.v = v;
		return r;
	}
}
