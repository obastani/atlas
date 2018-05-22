package java.util;
public class Hashtable<K,V> extends java.util.Dictionary<K, V> implements java.util.Map<K, V>, java.lang.Cloneable, java.io.Serializable {
	public java.lang.Object f36;
	public java.lang.Object f126;
	public Hashtable(java.util.Map<? extends K, ? extends V> p0) {
		((java.util.Hashtable)this).f36 = p0.values().iterator().next();
		((java.util.Hashtable)this).f126 = p0.keySet().iterator().next();
	}
	public Hashtable() {
	}
	public synchronized boolean remove(java.lang.Object p0, java.lang.Object p1) {
		boolean r = false;
		return (boolean)r;
	}
	public synchronized V remove(java.lang.Object p0) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.Hashtable)this).f36;
		return (V)r;
	}
	public synchronized V get(java.lang.Object p0) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.Hashtable)this).f36;
		return (V)r;
	}
	public synchronized V put(K p0, V p1) {
		java.lang.Object r = null;
		((java.util.Hashtable)this).f36 = (java.lang.Object)p1;
		((java.util.Hashtable)this).f126 = (java.lang.Object)p0;
		r = (java.lang.Object)((java.util.Hashtable)this).f36;
		return (V)r;
	}
	public synchronized boolean equals(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
	}
	public synchronized java.lang.String toString() {
		java.lang.String r = null;
		r = new java.lang.String();
		return (java.lang.String)r;
	}
	public java.util.Collection<V> values() {
		java.util.Collection r = null;
		r = new java.util.Collections.SynchronizedCollection();
		((java.util.Collections.SynchronizedCollection)r).f24 = (java.lang.Object)((java.util.Hashtable)this).f36;
		return (java.util.Collection<V>)r;
	}
	public synchronized int hashCode() {
		int r = 0;
		return (int)r;
	}
	public synchronized java.lang.Object clone() {
		java.lang.Object r = null;
		r = new java.util.Hashtable();
		((java.util.Hashtable)r).f36 = (java.lang.Object)((java.util.Hashtable)this).f36;
		return (java.lang.Object)r;
	}
	public synchronized void clear() {
	}
	public synchronized boolean isEmpty() {
		boolean r = false;
		return (boolean)r;
	}
	public synchronized boolean replace(K p0, V p1, V p2) {
		boolean r = false;
		return (boolean)r;
	}
	public synchronized V replace(K p0, V p1) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.Hashtable)this).f36;
		return (V)r;
	}
	public synchronized boolean contains(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
	}
	public synchronized int size() {
		int r = 0;
		return (int)r;
	}
	public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
		java.util.Set r = null;
		r = new java.util.Collections.SynchronizedSet();
		return (java.util.Set<java.util.Map.Entry<K, V>>)r;
	}
	public synchronized void putAll(java.util.Map<? extends K, ? extends V> p0) {
		((java.util.Hashtable)this).f36 = p0.values().iterator().next();
		((java.util.Hashtable)this).f126 = p0.keySet().iterator().next();
	}
	public synchronized V putIfAbsent(K p0, V p1) {
		java.lang.Object r = null;
		((java.util.Hashtable)this).f126 = (java.lang.Object)p0;
		((java.util.Hashtable)this).f36 = (java.lang.Object)p1;
		r = (java.lang.Object)((java.util.Hashtable)this).f36;
		return (V)r;
	}
	public synchronized java.util.Enumeration<V> elements() {
		java.util.Enumeration r = null;
		r = new java.util.Collections.EmptyEnumeration();
		r = new java.util.Hashtable.Enumerator();
		((java.util.Hashtable.Enumerator)r).f55 = (java.lang.Object)((java.util.Hashtable)this).f36;
		return (java.util.Enumeration<V>)r;
	}
	public synchronized java.util.Enumeration<K> keys() {
		java.util.Enumeration r = null;
		r = new java.util.Collections.EmptyEnumeration();
		r = new java.util.Hashtable.Enumerator();
		((java.util.Hashtable.Enumerator)r).f55 = (java.lang.Object)((java.util.Hashtable)this).f126;
		return (java.util.Enumeration<K>)r;
	}
	public java.util.Set<K> keySet() {
		java.util.Set r = null;
		r = new java.util.Collections.SynchronizedSet();
		((java.util.Collections.SynchronizedSet)r).f78 = (java.lang.Object)((java.util.Hashtable)this).f126;
		return (java.util.Set<K>)r;
	}
	public boolean containsValue(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
	}
	public synchronized boolean containsKey(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
	}
	protected void rehash() {
	}
	public synchronized V getOrDefault(java.lang.Object p0, V p1) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.Hashtable)this).f36;
		return (V)r;
	}
	public class Enumerator<T> implements java.util.Enumeration<T>, java.util.Iterator<T> {
		public java.lang.Object f166;
		public java.lang.Object f55;
		public Enumerator() {
		}
		public void remove() {
		}
		public boolean hasNext() {
			boolean r = false;
			return (boolean)r;
		}
		public T next() {
			java.lang.Object r = null;
			r = new java.util.Hashtable.Entry();
			((java.util.Hashtable.Entry)r).f155 = (java.lang.Object)((java.util.Hashtable.Enumerator)this).f166;
			r = (java.lang.Object)((java.util.Hashtable.Enumerator)this).f55;
			return (T)r;
		}
		public boolean hasMoreElements() {
			boolean r = false;
			return (boolean)r;
		}
		public T nextElement() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Hashtable.Enumerator)this).f55;
			return (T)r;
		}
	}
	public static class Entry<K,V> implements java.util.Map.Entry<K, V> {
		public java.lang.Object f155;
		public Entry() {
		}
		public boolean equals(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public java.lang.String toString() {
			java.lang.String r = null;
			return (java.lang.String)r;
		}
		public int hashCode() {
			int r = 0;
			return (int)r;
		}
		protected java.lang.Object clone() {
			java.lang.Object r = null;
			return (java.lang.Object)r;
		}
		public V getValue() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Hashtable.Entry)this).f155;
			return (V)r;
		}
		public K getKey() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Hashtable.Entry)this).f155;
			return (K)r;
		}
		public V setValue(V p0) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Hashtable.Entry)this).f155;
			return (V)r;
		}
	}
	public class ValueCollection extends java.util.AbstractCollection<V> {
		private ValueCollection(java.util.Hashtable p0) {
		}
		public ValueCollection() {
		}
		public void clear() {
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
			return (java.util.Iterator<V>)r;
		}
	}
	public class EntrySet extends java.util.AbstractSet<java.util.Map.Entry<K, V>> {
		private EntrySet(java.util.Hashtable p0) {
		}
		public EntrySet() {
		}
		public boolean add(java.util.Map.Entry<K, V> p0) {
			boolean r = false;
			return (boolean)r;
		}
		public boolean remove(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public void clear() {
		}
		public boolean contains(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public int size() {
			int r = 0;
			return (int)r;
		}
		public java.util.Iterator<java.util.Map.Entry<K, V>> iterator() {
			java.util.Iterator r = null;
			return (java.util.Iterator<java.util.Map.Entry<K, V>>)r;
		}
	}
	public class KeySet extends java.util.AbstractSet<K> {
		private KeySet(java.util.Hashtable p0) {
		}
		public KeySet() {
		}
		public boolean remove(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public void clear() {
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
	}
	public class ANON134 {
		ANON134() {
		}
	}
}
