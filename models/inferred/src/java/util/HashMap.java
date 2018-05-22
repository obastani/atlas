package java.util;
public class HashMap<K,V> extends java.util.AbstractMap<K, V> implements java.util.Map<K, V>, java.lang.Cloneable, java.io.Serializable {
	public java.lang.Object f30;
	public java.lang.Object f47;
	public HashMap(java.util.Map<? extends K, ? extends V> p0) {
		((java.util.HashMap)this).f47 = p0.keySet().iterator().next();
		((java.util.HashMap)this).f30 = p0.values().iterator().next();
	}
	public HashMap() {
	}
	public V remove(java.lang.Object p0) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.HashMap)this).f30;
		r = (java.lang.Object)((java.util.LinkedHashMap)this).f16;
		return (V)r;
	}
	public boolean remove(java.lang.Object p0, java.lang.Object p1) {
		boolean r = false;
		return (boolean)r;
	}
	public V get(java.lang.Object p0) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.HashMap)this).f30;
		return (V)r;
	}
	public V put(K p0, V p1) {
		java.lang.Object r = null;
		((java.util.HashMap)this).f47 = (java.lang.Object)p0;
		((java.util.LinkedHashMap)this).f113 = (java.lang.Object)p0;
		r = (java.lang.Object)((java.util.HashMap)this).f30;
		((java.util.LinkedHashMap)this).f16 = (java.lang.Object)p1;
		((java.util.HashMap)this).f30 = (java.lang.Object)p1;
		r = (java.lang.Object)((java.util.LinkedHashMap)this).f16;
		return (V)r;
	}
	public java.util.Collection<V> values() {
		java.util.Collection r = null;
		r = new java.util.HashMap.Values();
		((java.util.HashMap.Values)r).f70 = (java.lang.Object)((java.util.HashMap)this).f30;
		return (java.util.Collection<V>)r;
	}
	public java.lang.Object clone() {
		java.lang.Object r = null;
		r = new java.util.HashMap();
		r = new java.util.LinkedHashMap();
		((java.util.HashMap)r).f30 = (java.lang.Object)((java.util.HashMap)this).f30;
		((java.util.HashMap)r).f47 = (java.lang.Object)((java.util.HashMap)this).f47;
		((java.util.LinkedHashMap)r).f16 = (java.lang.Object)((java.util.LinkedHashMap)this).f16;
		return (java.lang.Object)r;
	}
	public void clear() {
	}
	public boolean isEmpty() {
		boolean r = false;
		return (boolean)r;
	}
	public boolean replace(K p0, V p1, V p2) {
		boolean r = false;
		return (boolean)r;
	}
	public V replace(K p0, V p1) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.HashMap)this).f30;
		r = (java.lang.Object)((java.util.LinkedHashMap)this).f16;
		return (V)r;
	}
	public int size() {
		int r = 0;
		return (int)r;
	}
	public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
		java.util.Set r = null;
		r = new java.util.HashMap.EntrySet();
		((java.util.HashMap.EntrySet)r).f44 = (java.lang.Object)((java.util.HashMap)this).f47;
		((java.util.HashMap.EntrySet)r).f129 = (java.lang.Object)((java.util.HashMap)this).f30;
		return (java.util.Set<java.util.Map.Entry<K, V>>)r;
	}
	public void putAll(java.util.Map<? extends K, ? extends V> p0) {
		((java.util.HashMap)this).f47 = p0.keySet().iterator().next();
		((java.util.HashMap)this).f30 = p0.values().iterator().next();
		((java.util.LinkedHashMap)this).f113 = p0.keySet().iterator().next();
		((java.util.LinkedHashMap)this).f16 = p0.values().iterator().next();
	}
	public V putIfAbsent(K p0, V p1) {
		java.lang.Object r = null;
		((java.util.HashMap)this).f47 = (java.lang.Object)p0;
		((java.util.LinkedHashMap)this).f113 = (java.lang.Object)p0;
		r = (java.lang.Object)((java.util.HashMap)this).f30;
		((java.util.LinkedHashMap)this).f16 = (java.lang.Object)p1;
		((java.util.HashMap)this).f30 = (java.lang.Object)p1;
		r = (java.lang.Object)((java.util.LinkedHashMap)this).f16;
		return (V)r;
	}
	public java.util.Set<K> keySet() {
		java.util.Set r = null;
		r = new java.util.HashMap.KeySet();
		((java.util.HashMap.KeySet)r).f38 = (java.lang.Object)((java.util.HashMap)this).f47;
		return (java.util.Set<K>)r;
	}
	public boolean containsValue(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
	}
	public boolean containsKey(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
	}
	public V getOrDefault(java.lang.Object p0, V p1) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.HashMap)this).f30;
		return (V)r;
	}
	public static final class TreeNode<K,V> extends java.util.LinkedHashMap.Entry<K, V> {
		public TreeNode() {
		}
	}
	public static final class EntrySpliterator<K,V> extends java.util.HashMap.HashMapSpliterator<K, V> {
		public EntrySpliterator() {
		}
		public java.util.HashMap.EntrySpliterator<K, V> trySplit() {
			java.util.HashMap.EntrySpliterator r = null;
			return (java.util.HashMap.EntrySpliterator<K, V>)r;
		}
		public int characteristics() {
			int r = 0;
			return (int)r;
		}
	}
	public static final class ValueSpliterator<K,V> extends java.util.HashMap.HashMapSpliterator<K, V> {
		public ValueSpliterator() {
		}
		public java.util.HashMap.ValueSpliterator<K, V> trySplit() {
			java.util.HashMap.ValueSpliterator r = null;
			return (java.util.HashMap.ValueSpliterator<K, V>)r;
		}
		public int characteristics() {
			int r = 0;
			return (int)r;
		}
	}
	public static final class KeySpliterator<K,V> extends java.util.HashMap.HashMapSpliterator<K, V> {
		public KeySpliterator() {
		}
		public java.util.HashMap.KeySpliterator<K, V> trySplit() {
			java.util.HashMap.KeySpliterator r = null;
			return (java.util.HashMap.KeySpliterator<K, V>)r;
		}
		public int characteristics() {
			int r = 0;
			return (int)r;
		}
	}
	public static class HashMapSpliterator<K,V> {
		public HashMapSpliterator() {
		}
		public final long estimateSize() {
			long r = 0;
			return (long)r;
		}
	}
	public final class EntryIterator extends java.util.HashMap<K, V>.HashIterator implements java.util.Iterator<java.util.Map.Entry<K, V>> {
		public java.lang.Object f87;
		public java.lang.Object f93;
		EntryIterator(java.util.HashMap p0) {
		}
		public EntryIterator() {
		}
		public final java.util.Map.Entry<K, V> next() {
			java.util.Map.Entry r = null;
			r = new java.util.HashMap.Node();
			((java.util.HashMap.Node)r).f168 = (java.lang.Object)((java.util.HashMap.EntryIterator)this).f87;
			((java.util.HashMap.Node)r).f94 = (java.lang.Object)((java.util.HashMap.EntryIterator)this).f93;
			return (java.util.Map.Entry<K, V>)r;
		}
	}
	public final class ValueIterator extends java.util.HashMap<K, V>.HashIterator implements java.util.Iterator<V> {
		public java.lang.Object f34;
		ValueIterator(java.util.HashMap p0) {
		}
		public ValueIterator() {
		}
		public final V next() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.HashMap.ValueIterator)this).f34;
			return (V)r;
		}
	}
	public final class KeyIterator extends java.util.HashMap<K, V>.HashIterator implements java.util.Iterator<K> {
		public java.lang.Object f171;
		KeyIterator(java.util.HashMap p0) {
		}
		public KeyIterator() {
		}
		public final K next() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.HashMap.KeyIterator)this).f171;
			return (K)r;
		}
	}
	public abstract class HashIterator {
		HashIterator(java.util.HashMap p0) {
		}
		public HashIterator() {
		}
		public final void remove() {
		}
		public final boolean hasNext() {
			boolean r = false;
			return (boolean)r;
		}
	}
	public final class EntrySet extends java.util.AbstractSet<java.util.Map.Entry<K, V>> {
		public java.lang.Object f129;
		public java.lang.Object f44;
		EntrySet(java.util.HashMap p0) {
		}
		public EntrySet() {
		}
		public final boolean remove(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public final void clear() {
		}
		public final boolean contains(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public final int size() {
			int r = 0;
			return (int)r;
		}
		public final java.util.Iterator<java.util.Map.Entry<K, V>> iterator() {
			java.util.Iterator r = null;
			r = new java.util.HashMap.EntryIterator();
			((java.util.HashMap.EntryIterator)r).f93 = (java.lang.Object)((java.util.HashMap.EntrySet)this).f129;
			((java.util.HashMap.EntryIterator)r).f87 = (java.lang.Object)((java.util.HashMap.EntrySet)this).f44;
			return (java.util.Iterator<java.util.Map.Entry<K, V>>)r;
		}
	}
	public final class Values extends java.util.AbstractCollection<V> {
		public java.lang.Object f70;
		Values(java.util.HashMap p0) {
		}
		public Values() {
		}
		public final void clear() {
		}
		public final boolean contains(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public final int size() {
			int r = 0;
			return (int)r;
		}
		public final java.util.Iterator<V> iterator() {
			java.util.Iterator r = null;
			r = new java.util.HashMap.ValueIterator();
			((java.util.HashMap.ValueIterator)r).f34 = (java.lang.Object)((java.util.HashMap.Values)this).f70;
			return (java.util.Iterator<V>)r;
		}
	}
	public final class KeySet extends java.util.AbstractSet<K> {
		public java.lang.Object f38;
		KeySet(java.util.HashMap p0) {
		}
		public KeySet() {
		}
		public final boolean remove(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public final void clear() {
		}
		public final boolean contains(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public final int size() {
			int r = 0;
			return (int)r;
		}
		public final java.util.Iterator<K> iterator() {
			java.util.Iterator r = null;
			r = new java.util.HashMap.KeyIterator();
			((java.util.HashMap.KeyIterator)r).f171 = (java.lang.Object)((java.util.HashMap.KeySet)this).f38;
			return (java.util.Iterator<K>)r;
		}
	}
	public static class Node<K,V> implements java.util.Map.Entry<K, V> {
		public java.lang.Object f168;
		public java.lang.Object f94;
		public Node() {
		}
		public final boolean equals(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public final java.lang.String toString() {
			java.lang.String r = null;
			return (java.lang.String)r;
		}
		public final int hashCode() {
			int r = 0;
			return (int)r;
		}
		public final V getValue() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.HashMap.Node)this).f94;
			return (V)r;
		}
		public final K getKey() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.LinkedHashMap.Entry)this).f74;
			r = (java.lang.Object)((java.util.HashMap.Node)this).f168;
			return (K)r;
		}
		public final V setValue(V p0) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.LinkedHashMap.Entry)this).f174;
			r = (java.lang.Object)((java.util.HashMap.Node)this).f94;
			return (V)r;
		}
	}
}
