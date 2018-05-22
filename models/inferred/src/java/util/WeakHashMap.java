package java.util;
public class WeakHashMap<K,V> extends java.util.AbstractMap<K, V> implements java.util.Map<K, V> {
	public java.lang.Object f80;
	public java.lang.Object f18;
	public WeakHashMap(java.util.Map<? extends K, ? extends V> p0) {
		((java.util.WeakHashMap)this).f18 = p0.values().iterator().next();
		((java.util.WeakHashMap)this).f80 = p0.keySet().iterator().next();
	}
	public WeakHashMap() {
	}
	public V remove(java.lang.Object p0) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.WeakHashMap)this).f18;
		return (V)r;
	}
	public V get(java.lang.Object p0) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.WeakHashMap)this).f18;
		return (V)r;
	}
	public V put(K p0, V p1) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.WeakHashMap)this).f18;
		((java.util.WeakHashMap)this).f80 = (java.lang.Object)p0;
		((java.util.WeakHashMap)this).f18 = (java.lang.Object)p1;
		return (V)r;
	}
	public java.util.Collection<V> values() {
		java.util.Collection r = null;
		r = new java.util.WeakHashMap.Values();
		((java.util.WeakHashMap.Values)r).f73 = (java.lang.Object)((java.util.WeakHashMap)this).f18;
		return (java.util.Collection<V>)r;
	}
	public void clear() {
	}
	public boolean isEmpty() {
		boolean r = false;
		return (boolean)r;
	}
	public int size() {
		int r = 0;
		return (int)r;
	}
	public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
		java.util.Set r = null;
		r = new java.util.WeakHashMap.EntrySet();
		((java.util.WeakHashMap.EntrySet)r).f102 = (java.lang.Object)((java.util.WeakHashMap)this).f80;
		((java.util.WeakHashMap.EntrySet)r).f141 = (java.lang.Object)((java.util.WeakHashMap)this).f18;
		return (java.util.Set<java.util.Map.Entry<K, V>>)r;
	}
	public void putAll(java.util.Map<? extends K, ? extends V> p0) {
		((java.util.WeakHashMap)this).f18 = p0.values().iterator().next();
		((java.util.WeakHashMap)this).f80 = p0.keySet().iterator().next();
	}
	public java.util.Set<K> keySet() {
		java.util.Set r = null;
		r = new java.util.WeakHashMap.KeySet();
		((java.util.WeakHashMap.KeySet)r).f138 = (java.lang.Object)((java.util.WeakHashMap)this).f80;
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
	public static final class EntrySpliterator<K,V> extends java.util.WeakHashMap.WeakHashMapSpliterator<K, V> {
		public EntrySpliterator() {
		}
		public java.util.WeakHashMap.EntrySpliterator<K, V> trySplit() {
			java.util.WeakHashMap.EntrySpliterator r = null;
			return (java.util.WeakHashMap.EntrySpliterator<K, V>)r;
		}
		public int characteristics() {
			int r = 0;
			return (int)r;
		}
	}
	public static final class ValueSpliterator<K,V> extends java.util.WeakHashMap.WeakHashMapSpliterator<K, V> {
		public ValueSpliterator() {
		}
		public java.util.WeakHashMap.ValueSpliterator<K, V> trySplit() {
			java.util.WeakHashMap.ValueSpliterator r = null;
			return (java.util.WeakHashMap.ValueSpliterator<K, V>)r;
		}
		public int characteristics() {
			int r = 0;
			return (int)r;
		}
	}
	public static final class KeySpliterator<K,V> extends java.util.WeakHashMap.WeakHashMapSpliterator<K, V> {
		public KeySpliterator() {
		}
		public java.util.WeakHashMap.KeySpliterator<K, V> trySplit() {
			java.util.WeakHashMap.KeySpliterator r = null;
			return (java.util.WeakHashMap.KeySpliterator<K, V>)r;
		}
		public int characteristics() {
			int r = 0;
			return (int)r;
		}
	}
	public static class WeakHashMapSpliterator<K,V> {
		public WeakHashMapSpliterator() {
		}
		public final long estimateSize() {
			long r = 0;
			return (long)r;
		}
	}
	public class EntrySet extends java.util.AbstractSet<java.util.Map.Entry<K, V>> {
		public java.lang.Object f102;
		public java.lang.Object f141;
		private EntrySet(java.util.WeakHashMap p0) {
		}
		public EntrySet() {
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
		public <T> T[] toArray(T[] p0) {
			java.lang.Object[] r = null;
			return (T[])r;
		}
		public java.lang.Object[] toArray() {
			java.lang.Object[] r = null;
			return (java.lang.Object[])r;
		}
		public java.util.Iterator<java.util.Map.Entry<K, V>> iterator() {
			java.util.Iterator r = null;
			r = new java.util.WeakHashMap.EntryIterator();
			((java.util.WeakHashMap.EntryIterator)r).f159 = (java.lang.Object)((java.util.WeakHashMap.EntrySet)this).f141;
			((java.util.WeakHashMap.EntryIterator)r).f157 = (java.lang.Object)((java.util.WeakHashMap.EntrySet)this).f102;
			return (java.util.Iterator<java.util.Map.Entry<K, V>>)r;
		}
	}
	public class Values extends java.util.AbstractCollection<V> {
		public java.lang.Object f73;
		private Values(java.util.WeakHashMap p0) {
		}
		public Values() {
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
			r = new java.util.WeakHashMap.ValueIterator();
			((java.util.WeakHashMap.ValueIterator)r).f133 = (java.lang.Object)((java.util.WeakHashMap.Values)this).f73;
			return (java.util.Iterator<V>)r;
		}
	}
	public class KeySet extends java.util.AbstractSet<K> {
		public java.lang.Object f138;
		private KeySet(java.util.WeakHashMap p0) {
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
			r = new java.util.WeakHashMap.KeyIterator();
			((java.util.WeakHashMap.KeyIterator)r).f119 = (java.lang.Object)((java.util.WeakHashMap.KeySet)this).f138;
			return (java.util.Iterator<K>)r;
		}
	}
	public class EntryIterator extends java.util.WeakHashMap<K, V>.HashIterator<java.util.Map.Entry<K, V>> {
		public java.lang.Object f157;
		public java.lang.Object f159;
		private EntryIterator(java.util.WeakHashMap p0) {
		}
		public EntryIterator() {
		}
		public java.util.Map.Entry<K, V> next() {
			java.util.Map.Entry r = null;
			r = new java.util.WeakHashMap.Entry();
			((java.util.WeakHashMap.Entry)r).f107 = (java.lang.Object)((java.util.WeakHashMap.EntryIterator)this).f159;
			((java.util.WeakHashMap.Entry)r).f88 = (java.lang.Object)((java.util.WeakHashMap.EntryIterator)this).f157;
			return (java.util.Map.Entry<K, V>)r;
		}
	}
	public class KeyIterator extends java.util.WeakHashMap<K, V>.HashIterator<K> {
		public java.lang.Object f119;
		private KeyIterator(java.util.WeakHashMap p0) {
		}
		public KeyIterator() {
		}
		public K next() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.WeakHashMap.KeyIterator)this).f119;
			return (K)r;
		}
	}
	public class ValueIterator extends java.util.WeakHashMap<K, V>.HashIterator<V> {
		public java.lang.Object f133;
		private ValueIterator(java.util.WeakHashMap p0) {
		}
		public ValueIterator() {
		}
		public V next() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.WeakHashMap.ValueIterator)this).f133;
			return (V)r;
		}
	}
	public abstract class HashIterator<T> implements java.util.Iterator<T> {
		HashIterator(java.util.WeakHashMap p0) {
		}
		public HashIterator() {
		}
		public void remove() {
		}
		public boolean hasNext() {
			boolean r = false;
			return (boolean)r;
		}
		protected java.util.WeakHashMap.Entry<K, V> nextEntry() {
			java.util.WeakHashMap.Entry r = null;
			return (java.util.WeakHashMap.Entry<K, V>)r;
		}
	}
	public static class Entry<K,V> extends java.lang.ref.WeakReference<java.lang.Object> implements java.util.Map.Entry<K, V> {
		public java.lang.Object f88;
		public java.lang.Object f107;
		public Entry() {
			super(null);
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
		public V getValue() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.WeakHashMap.Entry)this).f107;
			return (V)r;
		}
		public K getKey() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.WeakHashMap.Entry)this).f88;
			return (K)r;
		}
		public V setValue(V p0) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.WeakHashMap.Entry)this).f107;
			return (V)r;
		}
	}
	public class ANON160 {
		ANON160() {
		}
	}
}
