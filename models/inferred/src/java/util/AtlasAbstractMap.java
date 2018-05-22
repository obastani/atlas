package java.util;
public abstract class AtlasAbstractMap<K,V> {
	public static class SimpleImmutableEntry<K,V> implements java.util.Map.Entry<K, V>, java.io.Serializable {
		public java.lang.Object f137;
		public java.lang.Object f12;
		public SimpleImmutableEntry(K p0, V p1) {
		}
		public SimpleImmutableEntry(java.util.Map.Entry<? extends K, ? extends V> p0) {
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)this).f137 = (java.lang.Object)((java.util.AtlasAbstractMap.SimpleEntry)p0).f97;
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)this).f12 = (java.lang.Object)((java.util.AtlasAbstractMap.SimpleEntry)p0).f104;
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)this).f12 = (java.lang.Object)((java.util.AtlasAbstractMap.SimpleImmutableEntry)p0).f12;
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)this).f137 = (java.lang.Object)((java.util.AtlasAbstractMap.SimpleImmutableEntry)p0).f137;
		}
		public SimpleImmutableEntry() {
		}
		public boolean equals(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public java.lang.String toString() {
			java.lang.String r = null;
			r = new java.lang.String();
			return (java.lang.String)r;
		}
		public int hashCode() {
			int r = 0;
			return (int)r;
		}
		public V getValue() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.AtlasAbstractMap.SimpleImmutableEntry)this).f12;
			return (V)r;
		}
		public K getKey() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.AtlasAbstractMap.SimpleImmutableEntry)this).f137;
			return (K)r;
		}
		public V setValue(V p0) {
			java.lang.Object r = null;
			return (V)r;
		}
	}
	public static class SimpleEntry<K,V> implements java.util.Map.Entry<K, V>, java.io.Serializable {
		public java.lang.Object f97;
		public java.lang.Object f104;
		public SimpleEntry(K p0, V p1) {
		}
		public SimpleEntry(java.util.Map.Entry<? extends K, ? extends V> p0) {
			((java.util.AtlasAbstractMap.SimpleEntry)this).f97 = (java.lang.Object)((java.util.AtlasAbstractMap.SimpleImmutableEntry)p0).f137;
			((java.util.AtlasAbstractMap.SimpleEntry)this).f104 = (java.lang.Object)((java.util.AtlasAbstractMap.SimpleImmutableEntry)p0).f12;
		}
		public SimpleEntry() {
		}
		public boolean equals(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public java.lang.String toString() {
			java.lang.String r = null;
			r = new java.lang.String();
			return (java.lang.String)r;
		}
		public int hashCode() {
			int r = 0;
			return (int)r;
		}
		public V getValue() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.AtlasAbstractMap.SimpleEntry)this).f104;
			return (V)r;
		}
		public K getKey() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.AtlasAbstractMap.SimpleEntry)this).f97;
			return (K)r;
		}
		public V setValue(V p0) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.AtlasAbstractMap.SimpleEntry)this).f104;
			return (V)r;
		}
	}
	public static class ANON183<V> extends java.util.AbstractCollection<V> {
		public java.lang.Object f153;
		ANON183() {
		}
		public void clear() {
		}
		public boolean isEmpty() {
			boolean r = false;
			return (boolean)r;
		}
		public boolean contains(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public int size() {
			int r = 0;
			return (int)r;
		}
		public java.util.Iterator<V> iterator() {
			java.util.Iterator r = null;
			r = new ANON241();
			((ANON241)r).f118 = (java.lang.Object)((ANON183)this).f153;
			return (java.util.Iterator<V>)r;
		}
		public static class ANON241<V> implements java.util.Iterator<V> {
			public java.lang.Object f118;
			ANON241() {
			}
			public void remove() {
			}
			public boolean hasNext() {
				boolean r = false;
				return (boolean)r;
			}
			public V next() {
				java.lang.Object r = null;
				r = (java.lang.Object)((ANON241)this).f118;
				return (V)r;
			}
		}
	}
	public class ANON242 extends java.util.AbstractSet<K> {
		ANON242() {
		}
		public void clear() {
		}
		public boolean isEmpty() {
			boolean r = false;
			return (boolean)r;
		}
		public boolean contains(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public int size() {
			int r = 0;
			return (int)r;
		}
		public java.util.Iterator<K> iterator() {
			java.util.Iterator r = null;
			return (java.util.Iterator<K>)r;
		}
		public class ANON217 implements java.util.Iterator<K> {
			ANON217() {
			}
			public void remove() {
			}
			public boolean hasNext() {
				boolean r = false;
				return (boolean)r;
			}
			public K next() {
				java.lang.Object r = null;
				return (K)r;
			}
		}
	}
}
