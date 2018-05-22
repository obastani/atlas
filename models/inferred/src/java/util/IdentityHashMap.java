package java.util;
public class IdentityHashMap<K,V> extends java.util.AbstractMap<K, V> implements java.util.Map<K, V>, java.io.Serializable, java.lang.Cloneable {
	public java.lang.Object f51;
	public java.lang.Object f61;
	public IdentityHashMap(java.util.Map<? extends K, ? extends V> p0) {
		((java.util.IdentityHashMap)this).f61 = p0.keySet().iterator().next();
		((java.util.IdentityHashMap)this).f51 = p0.values().iterator().next();
	}
	public IdentityHashMap() {
	}
	public V remove(java.lang.Object p0) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.IdentityHashMap)this).f51;
		return (V)r;
	}
	public V get(java.lang.Object p0) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.IdentityHashMap)this).f51;
		return (V)r;
	}
	public V put(K p0, V p1) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.IdentityHashMap)this).f51;
		((java.util.IdentityHashMap)this).f51 = (java.lang.Object)p1;
		((java.util.IdentityHashMap)this).f61 = (java.lang.Object)p0;
		return (V)r;
	}
	public boolean equals(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
	}
	public java.util.Collection<V> values() {
		java.util.Collection r = null;
		r = new java.util.IdentityHashMap.Values();
		((java.util.IdentityHashMap.Values)r).f57 = (java.lang.Object)((java.util.IdentityHashMap)this).f51;
		return (java.util.Collection<V>)r;
	}
	public int hashCode() {
		int r = 0;
		return (int)r;
	}
	public java.lang.Object clone() {
		java.lang.Object r = null;
		r = new java.util.IdentityHashMap();
		((java.util.IdentityHashMap)r).f51 = (java.lang.Object)((java.util.IdentityHashMap)this).f51;
		((java.util.IdentityHashMap)r).f61 = (java.lang.Object)((java.util.IdentityHashMap)this).f61;
		return (java.lang.Object)r;
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
		r = new java.util.IdentityHashMap.EntrySet();
		((java.util.IdentityHashMap.EntrySet)r).f152 = (java.lang.Object)((java.util.IdentityHashMap)this).f51;
		((java.util.IdentityHashMap.EntrySet)r).f169 = (java.lang.Object)((java.util.IdentityHashMap)this).f61;
		return (java.util.Set<java.util.Map.Entry<K, V>>)r;
	}
	public void putAll(java.util.Map<? extends K, ? extends V> p0) {
		((java.util.IdentityHashMap)this).f51 = p0.values().iterator().next();
		((java.util.IdentityHashMap)this).f61 = p0.keySet().iterator().next();
	}
	public java.util.Set<K> keySet() {
		java.util.Set r = null;
		r = new java.util.IdentityHashMap.KeySet();
		((java.util.IdentityHashMap.KeySet)r).f140 = (java.lang.Object)((java.util.IdentityHashMap)this).f61;
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
	public static final class EntrySpliterator<K,V> extends java.util.IdentityHashMap.IdentityHashMapSpliterator<K, V> {
		public EntrySpliterator() {
		}
		public java.util.IdentityHashMap.EntrySpliterator<K, V> trySplit() {
			java.util.IdentityHashMap.EntrySpliterator r = null;
			return (java.util.IdentityHashMap.EntrySpliterator<K, V>)r;
		}
		public int characteristics() {
			int r = 0;
			return (int)r;
		}
	}
	public static final class ValueSpliterator<K,V> extends java.util.IdentityHashMap.IdentityHashMapSpliterator<K, V> {
		public ValueSpliterator() {
		}
		public java.util.IdentityHashMap.ValueSpliterator<K, V> trySplit() {
			java.util.IdentityHashMap.ValueSpliterator r = null;
			return (java.util.IdentityHashMap.ValueSpliterator<K, V>)r;
		}
		public int characteristics() {
			int r = 0;
			return (int)r;
		}
	}
	public static final class KeySpliterator<K,V> extends java.util.IdentityHashMap.IdentityHashMapSpliterator<K, V> {
		public KeySpliterator() {
		}
		public java.util.IdentityHashMap.KeySpliterator<K, V> trySplit() {
			java.util.IdentityHashMap.KeySpliterator r = null;
			return (java.util.IdentityHashMap.KeySpliterator<K, V>)r;
		}
		public int characteristics() {
			int r = 0;
			return (int)r;
		}
	}
	public static class IdentityHashMapSpliterator<K,V> {
		public IdentityHashMapSpliterator() {
		}
		public final long estimateSize() {
			long r = 0;
			return (long)r;
		}
	}
	public class EntrySet extends java.util.AbstractSet<java.util.Map.Entry<K, V>> {
		public java.lang.Object f152;
		public java.lang.Object f169;
		private EntrySet(java.util.IdentityHashMap p0) {
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
			r = new java.util.IdentityHashMap.EntryIterator();
			((java.util.IdentityHashMap.EntryIterator)r).f147 = (java.lang.Object)((java.util.IdentityHashMap.EntrySet)this).f169;
			((java.util.IdentityHashMap.EntryIterator)r).f161 = (java.lang.Object)((java.util.IdentityHashMap.EntrySet)this).f152;
			return (java.util.Iterator<java.util.Map.Entry<K, V>>)r;
		}
		public boolean removeAll(java.util.Collection<?> p0) {
			boolean r = false;
			return (boolean)r;
		}
	}
	public class Values extends java.util.AbstractCollection<V> {
		public java.lang.Object f57;
		private Values(java.util.IdentityHashMap p0) {
		}
		public Values() {
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
		public java.util.Iterator<V> iterator() {
			java.util.Iterator r = null;
			r = new java.util.IdentityHashMap.ValueIterator();
			((java.util.IdentityHashMap.ValueIterator)r).f154 = (java.lang.Object)((java.util.IdentityHashMap.Values)this).f57;
			return (java.util.Iterator<V>)r;
		}
	}
	public class KeySet extends java.util.AbstractSet<K> {
		public java.lang.Object f140;
		private KeySet(java.util.IdentityHashMap p0) {
		}
		public KeySet() {
		}
		public boolean remove(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public int hashCode() {
			int r = 0;
			return (int)r;
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
		public java.util.Iterator<K> iterator() {
			java.util.Iterator r = null;
			r = new java.util.IdentityHashMap.KeyIterator();
			((java.util.IdentityHashMap.KeyIterator)r).f124 = (java.lang.Object)((java.util.IdentityHashMap.KeySet)this).f140;
			return (java.util.Iterator<K>)r;
		}
		public boolean removeAll(java.util.Collection<?> p0) {
			boolean r = false;
			return (boolean)r;
		}
	}
	public class EntryIterator extends java.util.IdentityHashMap<K, V>.IdentityHashMapIterator<java.util.Map.Entry<K, V>> {
		public java.lang.Object f161;
		public java.lang.Object f147;
		private EntryIterator(java.util.IdentityHashMap p0) {
		}
		public EntryIterator() {
		}
		public void remove() {
		}
		public java.util.Map.Entry<K, V> next() {
			java.util.Map.Entry r = null;
			r = new java.util.IdentityHashMap.EntryIterator.Entry();
			((java.util.IdentityHashMap.EntryIterator.Entry)r).f177 = (java.lang.Object)((java.util.IdentityHashMap.EntryIterator)this).f161;
			((java.util.IdentityHashMap.EntryIterator.Entry)r).f64 = (java.lang.Object)((java.util.IdentityHashMap.EntryIterator)this).f147;
			return (java.util.Map.Entry<K, V>)r;
		}
		public class Entry implements java.util.Map.Entry<K, V> {
			public java.lang.Object f64;
			public java.lang.Object f177;
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
			public V getValue() {
				java.lang.Object r = null;
				return (V)r;
			}
			public K getKey() {
				java.lang.Object r = null;
				r = (java.lang.Object)((java.util.IdentityHashMap.EntryIterator.Entry)this).f64;
				return (K)r;
			}
			public V setValue(V p0) {
				java.lang.Object r = null;
				r = (java.lang.Object)((java.util.IdentityHashMap.EntryIterator.Entry)this).f177;
				return (V)r;
			}
		}
	}
	public class ValueIterator extends java.util.IdentityHashMap<K, V>.IdentityHashMapIterator<V> {
		public java.lang.Object f154;
		private ValueIterator(java.util.IdentityHashMap p0) {
		}
		public ValueIterator() {
		}
		public V next() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.IdentityHashMap.ValueIterator)this).f154;
			return (V)r;
		}
	}
	public class KeyIterator extends java.util.IdentityHashMap<K, V>.IdentityHashMapIterator<K> {
		public java.lang.Object f124;
		private KeyIterator(java.util.IdentityHashMap p0) {
		}
		public KeyIterator() {
		}
		public K next() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.IdentityHashMap.KeyIterator)this).f124;
			return (K)r;
		}
	}
	public abstract class IdentityHashMapIterator<T> implements java.util.Iterator<T> {
		private IdentityHashMapIterator(java.util.IdentityHashMap p0) {
		}
		public IdentityHashMapIterator() {
		}
		public void remove() {
		}
		public boolean hasNext() {
			boolean r = false;
			return (boolean)r;
		}
		protected int nextIndex() {
			int r = 0;
			return (int)r;
		}
	}
	public class ANON9 {
		ANON9() {
		}
	}
}
