package java.util.concurrent;
public class ConcurrentSkipListMap<K,V> extends java.util.AbstractMap<K, V> implements java.util.concurrent.ConcurrentNavigableMap<K, V>, java.lang.Cloneable, java.io.Serializable {
	public java.lang.Object f86;
	public java.lang.Object f46;
	public ConcurrentSkipListMap(java.util.Map<? extends K, ? extends V> p0) {
		((java.util.concurrent.ConcurrentSkipListMap)this).f86 = p0.keySet().iterator().next();
		((java.util.concurrent.ConcurrentSkipListMap)this).f46 = p0.values().iterator().next();
	}
	public ConcurrentSkipListMap(java.util.SortedMap<K, ? extends V> p0) {
		((java.util.concurrent.ConcurrentSkipListMap)this).f86 = p0.keySet().iterator().next();
		((java.util.concurrent.ConcurrentSkipListMap)this).f46 = p0.values().iterator().next();
	}
	public ConcurrentSkipListMap(java.util.Comparator<? super K> p0) {
	}
	public ConcurrentSkipListMap() {
	}
	public V remove(java.lang.Object p0) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f46;
		return (V)r;
	}
	public boolean remove(java.lang.Object p0, java.lang.Object p1) {
		boolean r = false;
		return (boolean)r;
	}
	public V get(java.lang.Object p0) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f46;
		return (V)r;
	}
	public V put(K p0, V p1) {
		java.lang.Object r = null;
		((java.util.concurrent.ConcurrentSkipListMap)this).f46 = (java.lang.Object)p1;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f46;
		((java.util.concurrent.ConcurrentSkipListMap)this).f86 = (java.lang.Object)p0;
		return (V)r;
	}
	public boolean equals(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
	}
	public java.util.Collection<V> values() {
		java.util.Collection r = null;
		r = new java.util.concurrent.ConcurrentSkipListMap.Values();
		((java.util.concurrent.ConcurrentSkipListMap.Values)r).f109 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f46;
		return (java.util.Collection<V>)r;
	}
	public java.util.concurrent.ConcurrentSkipListMap<K, V> clone() {
		java.util.concurrent.ConcurrentSkipListMap r = null;
		r = new java.util.concurrent.ConcurrentSkipListMap();
		((java.util.concurrent.ConcurrentSkipListMap)r).f46 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f46;
		((java.util.concurrent.ConcurrentSkipListMap)r).f86 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f86;
		return (java.util.concurrent.ConcurrentSkipListMap<K, V>)r;
	}
	public void clear() {
	}
	public boolean isEmpty() {
		boolean r = false;
		return (boolean)r;
	}
	public V replace(K p0, V p1) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f46;
		return (V)r;
	}
	public boolean replace(K p0, V p1, V p2) {
		boolean r = false;
		return (boolean)r;
	}
	public int size() {
		int r = 0;
		return (int)r;
	}
	public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
		java.util.Set r = null;
		r = new java.util.concurrent.ConcurrentSkipListMap.EntrySet();
		((java.util.concurrent.ConcurrentSkipListMap.EntrySet)r).f111 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f86;
		((java.util.concurrent.ConcurrentSkipListMap.EntrySet)r).f130 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f46;
		return (java.util.Set<java.util.Map.Entry<K, V>>)r;
	}
	public V putIfAbsent(K p0, V p1) {
		java.lang.Object r = null;
		((java.util.concurrent.ConcurrentSkipListMap)this).f46 = (java.lang.Object)p1;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f46;
		((java.util.concurrent.ConcurrentSkipListMap)this).f86 = (java.lang.Object)p0;
		return (V)r;
	}
	public java.util.NavigableSet<K> keySet() {
		java.util.NavigableSet r = null;
		r = new java.util.concurrent.ConcurrentSkipListMap.KeySet();
		((java.util.concurrent.ConcurrentSkipListMap.KeySet)r).f19 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f86;
		return (java.util.NavigableSet<K>)r;
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
		r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f46;
		return (V)r;
	}
	public java.util.Comparator<? super K> comparator() {
		java.util.Comparator r = null;
		return (java.util.Comparator<? super K>)r;
	}
	public java.util.NavigableSet<K> navigableKeySet() {
		java.util.NavigableSet r = null;
		r = new java.util.concurrent.ConcurrentSkipListMap.KeySet();
		((java.util.concurrent.ConcurrentSkipListMap.KeySet)r).f19 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f86;
		return (java.util.NavigableSet<K>)r;
	}
	public java.util.concurrent.ConcurrentNavigableMap<K, V> descendingMap() {
		java.util.concurrent.ConcurrentNavigableMap r = null;
		r = new java.util.concurrent.ConcurrentSkipListMap.SubMap();
		((java.util.concurrent.ConcurrentSkipListMap.SubMap)r).f31 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f86;
		((java.util.concurrent.ConcurrentSkipListMap.SubMap)r).f52 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f46;
		return (java.util.concurrent.ConcurrentNavigableMap<K, V>)r;
	}
	public K firstKey() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f86;
		return (K)r;
	}
	public K lastKey() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f86;
		return (K)r;
	}
	public java.util.Map.Entry<K, V> firstEntry() {
		java.util.Map.Entry r = null;
		r = new java.util.AtlasAbstractMap.SimpleImmutableEntry();
		((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f12 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f46;
		((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f137 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f86;
		return (java.util.Map.Entry<K, V>)r;
	}
	public java.util.Map.Entry<K, V> lastEntry() {
		java.util.Map.Entry r = null;
		r = new java.util.AtlasAbstractMap.SimpleImmutableEntry();
		((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f12 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f46;
		((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f137 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f86;
		return (java.util.Map.Entry<K, V>)r;
	}
	public java.util.Map.Entry<K, V> pollFirstEntry() {
		java.util.Map.Entry r = null;
		r = new java.util.AtlasAbstractMap.SimpleImmutableEntry();
		((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f12 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f46;
		((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f137 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f86;
		return (java.util.Map.Entry<K, V>)r;
	}
	public java.util.Map.Entry<K, V> pollLastEntry() {
		java.util.Map.Entry r = null;
		r = new java.util.AtlasAbstractMap.SimpleImmutableEntry();
		((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f12 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f46;
		((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f137 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f86;
		return (java.util.Map.Entry<K, V>)r;
	}
	public java.util.Map.Entry<K, V> lowerEntry(K p0) {
		java.util.Map.Entry r = null;
		return (java.util.Map.Entry<K, V>)r;
	}
	public K lowerKey(K p0) {
		java.lang.Object r = null;
		return (K)r;
	}
	public java.util.Map.Entry<K, V> floorEntry(K p0) {
		java.util.Map.Entry r = null;
		r = new java.util.AtlasAbstractMap.SimpleImmutableEntry();
		((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f12 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f46;
		((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f137 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f86;
		return (java.util.Map.Entry<K, V>)r;
	}
	public K floorKey(K p0) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f86;
		return (K)r;
	}
	public java.util.Map.Entry<K, V> ceilingEntry(K p0) {
		java.util.Map.Entry r = null;
		r = new java.util.AtlasAbstractMap.SimpleImmutableEntry();
		((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f12 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f46;
		((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f137 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f86;
		return (java.util.Map.Entry<K, V>)r;
	}
	public K ceilingKey(K p0) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f86;
		return (K)r;
	}
	public java.util.Map.Entry<K, V> higherEntry(K p0) {
		java.util.Map.Entry r = null;
		return (java.util.Map.Entry<K, V>)r;
	}
	public K higherKey(K p0) {
		java.lang.Object r = null;
		return (K)r;
	}
	public java.util.NavigableSet<K> descendingKeySet() {
		java.util.NavigableSet r = null;
		r = new java.util.concurrent.ConcurrentSkipListMap.KeySet();
		((java.util.concurrent.ConcurrentSkipListMap.KeySet)r).f19 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f86;
		return (java.util.NavigableSet<K>)r;
	}
	public java.util.concurrent.ConcurrentNavigableMap<K, V> subMap(K p0, boolean p1, K p2, boolean p3) {
		java.util.concurrent.ConcurrentNavigableMap r = null;
		r = new java.util.concurrent.ConcurrentSkipListMap.SubMap();
		((java.util.concurrent.ConcurrentSkipListMap.SubMap)r).f31 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f86;
		((java.util.concurrent.ConcurrentSkipListMap.SubMap)r).f52 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f46;
		return (java.util.concurrent.ConcurrentNavigableMap<K, V>)r;
	}
	public java.util.concurrent.ConcurrentNavigableMap<K, V> subMap(K p0, K p1) {
		java.util.concurrent.ConcurrentNavigableMap r = null;
		return (java.util.concurrent.ConcurrentNavigableMap<K, V>)r;
	}
	public java.util.concurrent.ConcurrentNavigableMap<K, V> headMap(K p0, boolean p1) {
		java.util.concurrent.ConcurrentNavigableMap r = null;
		r = new java.util.concurrent.ConcurrentSkipListMap.SubMap();
		((java.util.concurrent.ConcurrentSkipListMap.SubMap)r).f31 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f86;
		((java.util.concurrent.ConcurrentSkipListMap.SubMap)r).f52 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f46;
		return (java.util.concurrent.ConcurrentNavigableMap<K, V>)r;
	}
	public java.util.concurrent.ConcurrentNavigableMap<K, V> headMap(K p0) {
		java.util.concurrent.ConcurrentNavigableMap r = null;
		return (java.util.concurrent.ConcurrentNavigableMap<K, V>)r;
	}
	public java.util.concurrent.ConcurrentNavigableMap<K, V> tailMap(K p0, boolean p1) {
		java.util.concurrent.ConcurrentNavigableMap r = null;
		r = new java.util.concurrent.ConcurrentSkipListMap.SubMap();
		((java.util.concurrent.ConcurrentSkipListMap.SubMap)r).f31 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f86;
		((java.util.concurrent.ConcurrentSkipListMap.SubMap)r).f52 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f46;
		return (java.util.concurrent.ConcurrentNavigableMap<K, V>)r;
	}
	public java.util.concurrent.ConcurrentNavigableMap<K, V> tailMap(K p0) {
		java.util.concurrent.ConcurrentNavigableMap r = null;
		r = new java.util.concurrent.ConcurrentSkipListMap.SubMap();
		((java.util.concurrent.ConcurrentSkipListMap.SubMap)r).f31 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f86;
		((java.util.concurrent.ConcurrentSkipListMap.SubMap)r).f52 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap)this).f46;
		return (java.util.concurrent.ConcurrentNavigableMap<K, V>)r;
	}
	public static final class EntrySpliterator<K,V> extends java.util.concurrent.ConcurrentSkipListMap.CSLMSpliterator<K, V> {
		public EntrySpliterator() {
		}
		public int characteristics() {
			int r = 0;
			return (int)r;
		}
		public final java.util.Comparator<java.util.Map.Entry<K, V>> getComparator() {
			java.util.Comparator r = null;
			return (java.util.Comparator<java.util.Map.Entry<K, V>>)r;
		}
	}
	public static final class ValueSpliterator<K,V> extends java.util.concurrent.ConcurrentSkipListMap.CSLMSpliterator<K, V> {
		public ValueSpliterator() {
		}
		public int characteristics() {
			int r = 0;
			return (int)r;
		}
	}
	public static final class KeySpliterator<K,V> extends java.util.concurrent.ConcurrentSkipListMap.CSLMSpliterator<K, V> {
		public KeySpliterator() {
		}
		public int characteristics() {
			int r = 0;
			return (int)r;
		}
		public final java.util.Comparator<? super K> getComparator() {
			java.util.Comparator r = null;
			return (java.util.Comparator<? super K>)r;
		}
	}
	public abstract static class CSLMSpliterator<K,V> {
		public CSLMSpliterator() {
		}
		public final long estimateSize() {
			long r = 0;
			return (long)r;
		}
	}
	public static final class SubMap<K,V> extends java.util.AbstractMap<K, V> implements java.util.concurrent.ConcurrentNavigableMap<K, V>, java.lang.Cloneable, java.io.Serializable {
		public java.lang.Object f52;
		public java.lang.Object f31;
		public SubMap() {
		}
		public V remove(java.lang.Object p0) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f52;
			return (V)r;
		}
		public boolean remove(java.lang.Object p0, java.lang.Object p1) {
			boolean r = false;
			return (boolean)r;
		}
		public V get(java.lang.Object p0) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f52;
			return (V)r;
		}
		public V put(K p0, V p1) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f52;
			return (V)r;
		}
		public java.util.Collection<V> values() {
			java.util.Collection r = null;
			r = new java.util.concurrent.ConcurrentSkipListMap.Values();
			((java.util.concurrent.ConcurrentSkipListMap.Values)r).f109 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f52;
			return (java.util.Collection<V>)r;
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
			r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f52;
			return (V)r;
		}
		public int size() {
			int r = 0;
			return (int)r;
		}
		public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
			java.util.Set r = null;
			return (java.util.Set<java.util.Map.Entry<K, V>>)r;
		}
		public V putIfAbsent(K p0, V p1) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f52;
			return (V)r;
		}
		public java.util.NavigableSet<K> keySet() {
			java.util.NavigableSet r = null;
			r = new java.util.concurrent.ConcurrentSkipListMap.KeySet();
			((java.util.concurrent.ConcurrentSkipListMap.KeySet)r).f19 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f31;
			return (java.util.NavigableSet<K>)r;
		}
		public boolean containsValue(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public boolean containsKey(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public java.util.Comparator<? super K> comparator() {
			java.util.Comparator r = null;
			return (java.util.Comparator<? super K>)r;
		}
		public java.util.NavigableSet<K> navigableKeySet() {
			java.util.NavigableSet r = null;
			r = new java.util.concurrent.ConcurrentSkipListMap.KeySet();
			((java.util.concurrent.ConcurrentSkipListMap.KeySet)r).f19 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f31;
			return (java.util.NavigableSet<K>)r;
		}
		public java.util.concurrent.ConcurrentSkipListMap.SubMap<K, V> descendingMap() {
			java.util.concurrent.ConcurrentSkipListMap.SubMap r = null;
			r = new java.util.concurrent.ConcurrentSkipListMap.SubMap();
			((java.util.concurrent.ConcurrentSkipListMap.SubMap)r).f31 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f31;
			((java.util.concurrent.ConcurrentSkipListMap.SubMap)r).f52 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f52;
			return (java.util.concurrent.ConcurrentSkipListMap.SubMap<K, V>)r;
		}
		public K firstKey() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f31;
			return (K)r;
		}
		public K lastKey() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f31;
			return (K)r;
		}
		public java.util.Map.Entry<K, V> firstEntry() {
			java.util.Map.Entry r = null;
			r = new java.util.AtlasAbstractMap.SimpleImmutableEntry();
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f137 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f31;
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f12 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f52;
			return (java.util.Map.Entry<K, V>)r;
		}
		public java.util.Map.Entry<K, V> lastEntry() {
			java.util.Map.Entry r = null;
			r = new java.util.AtlasAbstractMap.SimpleImmutableEntry();
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f137 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f31;
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f12 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f52;
			return (java.util.Map.Entry<K, V>)r;
		}
		public java.util.Map.Entry<K, V> pollFirstEntry() {
			java.util.Map.Entry r = null;
			r = new java.util.AtlasAbstractMap.SimpleImmutableEntry();
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f137 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f31;
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f12 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f52;
			return (java.util.Map.Entry<K, V>)r;
		}
		public java.util.Map.Entry<K, V> pollLastEntry() {
			java.util.Map.Entry r = null;
			r = new java.util.AtlasAbstractMap.SimpleImmutableEntry();
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f137 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f31;
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f12 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f52;
			return (java.util.Map.Entry<K, V>)r;
		}
		public java.util.Map.Entry<K, V> lowerEntry(K p0) {
			java.util.Map.Entry r = null;
			return (java.util.Map.Entry<K, V>)r;
		}
		public K lowerKey(K p0) {
			java.lang.Object r = null;
			return (K)r;
		}
		public java.util.Map.Entry<K, V> floorEntry(K p0) {
			java.util.Map.Entry r = null;
			r = new java.util.AtlasAbstractMap.SimpleImmutableEntry();
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f137 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f31;
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f12 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f52;
			return (java.util.Map.Entry<K, V>)r;
		}
		public K floorKey(K p0) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f31;
			return (K)r;
		}
		public java.util.Map.Entry<K, V> ceilingEntry(K p0) {
			java.util.Map.Entry r = null;
			r = new java.util.AtlasAbstractMap.SimpleImmutableEntry();
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f137 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f31;
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f12 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f52;
			return (java.util.Map.Entry<K, V>)r;
		}
		public K ceilingKey(K p0) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f31;
			return (K)r;
		}
		public java.util.Map.Entry<K, V> higherEntry(K p0) {
			java.util.Map.Entry r = null;
			return (java.util.Map.Entry<K, V>)r;
		}
		public K higherKey(K p0) {
			java.lang.Object r = null;
			return (K)r;
		}
		public java.util.NavigableSet<K> descendingKeySet() {
			java.util.NavigableSet r = null;
			r = new java.util.concurrent.ConcurrentSkipListMap.KeySet();
			((java.util.concurrent.ConcurrentSkipListMap.KeySet)r).f19 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f31;
			return (java.util.NavigableSet<K>)r;
		}
		public java.util.concurrent.ConcurrentSkipListMap.SubMap<K, V> subMap(K p0, boolean p1, K p2, boolean p3) {
			java.util.concurrent.ConcurrentSkipListMap.SubMap r = null;
			r = new java.util.concurrent.ConcurrentSkipListMap.SubMap();
			((java.util.concurrent.ConcurrentSkipListMap.SubMap)r).f31 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f31;
			((java.util.concurrent.ConcurrentSkipListMap.SubMap)r).f52 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f52;
			return (java.util.concurrent.ConcurrentSkipListMap.SubMap<K, V>)r;
		}
		public java.util.concurrent.ConcurrentSkipListMap.SubMap<K, V> subMap(K p0, K p1) {
			java.util.concurrent.ConcurrentSkipListMap.SubMap r = null;
			return (java.util.concurrent.ConcurrentSkipListMap.SubMap<K, V>)r;
		}
		public java.util.concurrent.ConcurrentSkipListMap.SubMap<K, V> headMap(K p0, boolean p1) {
			java.util.concurrent.ConcurrentSkipListMap.SubMap r = null;
			r = new java.util.concurrent.ConcurrentSkipListMap.SubMap();
			((java.util.concurrent.ConcurrentSkipListMap.SubMap)r).f31 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f31;
			((java.util.concurrent.ConcurrentSkipListMap.SubMap)r).f52 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f52;
			return (java.util.concurrent.ConcurrentSkipListMap.SubMap<K, V>)r;
		}
		public java.util.concurrent.ConcurrentSkipListMap.SubMap<K, V> headMap(K p0) {
			java.util.concurrent.ConcurrentSkipListMap.SubMap r = null;
			return (java.util.concurrent.ConcurrentSkipListMap.SubMap<K, V>)r;
		}
		public java.util.concurrent.ConcurrentSkipListMap.SubMap<K, V> tailMap(K p0, boolean p1) {
			java.util.concurrent.ConcurrentSkipListMap.SubMap r = null;
			r = new java.util.concurrent.ConcurrentSkipListMap.SubMap();
			((java.util.concurrent.ConcurrentSkipListMap.SubMap)r).f31 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f31;
			((java.util.concurrent.ConcurrentSkipListMap.SubMap)r).f52 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f52;
			return (java.util.concurrent.ConcurrentSkipListMap.SubMap<K, V>)r;
		}
		public java.util.concurrent.ConcurrentSkipListMap.SubMap<K, V> tailMap(K p0) {
			java.util.concurrent.ConcurrentSkipListMap.SubMap r = null;
			r = new java.util.concurrent.ConcurrentSkipListMap.SubMap();
			((java.util.concurrent.ConcurrentSkipListMap.SubMap)r).f31 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f31;
			((java.util.concurrent.ConcurrentSkipListMap.SubMap)r).f52 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap)this).f52;
			return (java.util.concurrent.ConcurrentSkipListMap.SubMap<K, V>)r;
		}
		public final class SubMapEntryIterator extends java.util.concurrent.ConcurrentSkipListMap.SubMap<K, V>.SubMapIter<java.util.Map.Entry<K, V>> {
			SubMapEntryIterator(java.util.concurrent.ConcurrentSkipListMap.SubMap p0) {
			}
			public SubMapEntryIterator() {
			}
			public java.util.Map.Entry<K, V> next() {
				java.util.Map.Entry r = null;
				return (java.util.Map.Entry<K, V>)r;
			}
			public int characteristics() {
				int r = 0;
				return (int)r;
			}
		}
		public final class SubMapKeyIterator extends java.util.concurrent.ConcurrentSkipListMap.SubMap<K, V>.SubMapIter<K> {
			public java.lang.Object f49;
			SubMapKeyIterator(java.util.concurrent.ConcurrentSkipListMap.SubMap p0) {
			}
			public SubMapKeyIterator() {
			}
			public K next() {
				java.lang.Object r = null;
				r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap.SubMapKeyIterator)this).f49;
				return (K)r;
			}
			public int characteristics() {
				int r = 0;
				return (int)r;
			}
			public final java.util.Comparator<? super K> getComparator() {
				java.util.Comparator r = null;
				return (java.util.Comparator<? super K>)r;
			}
		}
		public final class SubMapValueIterator extends java.util.concurrent.ConcurrentSkipListMap.SubMap<K, V>.SubMapIter<V> {
			public java.lang.Object f173;
			SubMapValueIterator(java.util.concurrent.ConcurrentSkipListMap.SubMap p0) {
			}
			public SubMapValueIterator() {
			}
			public V next() {
				java.lang.Object r = null;
				r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.SubMap.SubMapValueIterator)this).f173;
				return (V)r;
			}
			public int characteristics() {
				int r = 0;
				return (int)r;
			}
		}
		public abstract class SubMapIter<T> implements java.util.Iterator<T> {
			SubMapIter(java.util.concurrent.ConcurrentSkipListMap.SubMap p0) {
			}
			public SubMapIter() {
			}
			public void remove() {
			}
			public final boolean hasNext() {
				boolean r = false;
				return (boolean)r;
			}
			public long estimateSize() {
				long r = 0;
				return (long)r;
			}
		}
	}
	public static final class EntrySet<K1,V1> extends java.util.AbstractSet<java.util.Map.Entry<K1, V1>> {
		public java.lang.Object f130;
		public java.lang.Object f111;
		EntrySet(java.util.concurrent.ConcurrentNavigableMap<K1, V1> p0) {
		}
		public EntrySet() {
		}
		public boolean remove(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public boolean equals(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
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
		public <T> T[] toArray(T[] p0) {
			java.lang.Object[] r = null;
			return (T[])r;
		}
		public java.lang.Object[] toArray() {
			java.lang.Object[] r = null;
			return (java.lang.Object[])r;
		}
		public java.util.Iterator<java.util.Map.Entry<K1, V1>> iterator() {
			java.util.Iterator r = null;
			r = new java.util.concurrent.ConcurrentSkipListMap().new EntryIterator();
			((java.util.concurrent.ConcurrentSkipListMap.EntryIterator)r).f149 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.EntrySet)this).f130;
			((java.util.concurrent.ConcurrentSkipListMap.EntryIterator)r).f164 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.EntrySet)this).f111;
			return (java.util.Iterator<java.util.Map.Entry<K1, V1>>)r;
		}
	}
	public static final class Values<E> extends java.util.AbstractCollection<E> {
		public java.lang.Object f109;
		Values(java.util.concurrent.ConcurrentNavigableMap<?, E> p0) {
		}
		public Values() {
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
		public <T> T[] toArray(T[] p0) {
			java.lang.Object[] r = null;
			return (T[])r;
		}
		public java.lang.Object[] toArray() {
			java.lang.Object[] r = null;
			return (java.lang.Object[])r;
		}
		public java.util.Iterator<E> iterator() {
			java.util.Iterator r = null;
			r = new java.util.concurrent.ConcurrentSkipListMap().new ValueIterator();
			((java.util.concurrent.ConcurrentSkipListMap.ValueIterator)r).f145 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.Values)this).f109;
			return (java.util.Iterator<E>)r;
		}
	}
	public static final class KeySet<E> extends java.util.AbstractSet<E> implements java.util.NavigableSet<E> {
		public java.lang.Object f19;
		KeySet(java.util.concurrent.ConcurrentNavigableMap<E, ?> p0) {
		}
		public KeySet() {
		}
		public boolean remove(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public boolean equals(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
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
		public java.lang.Object[] toArray() {
			java.lang.Object[] r = null;
			return (java.lang.Object[])r;
		}
		public <T> T[] toArray(T[] p0) {
			java.lang.Object[] r = null;
			return (T[])r;
		}
		public java.util.Iterator<E> iterator() {
			java.util.Iterator r = null;
			r = new java.util.concurrent.ConcurrentSkipListMap().new KeyIterator();
			((java.util.concurrent.ConcurrentSkipListMap.KeyIterator)r).f112 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.KeySet)this).f19;
			return (java.util.Iterator<E>)r;
		}
		public E first() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.KeySet)this).f19;
			return (E)r;
		}
		public E floor(E p0) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.KeySet)this).f19;
			return (E)r;
		}
		public java.util.NavigableSet<E> subSet(E p0, E p1) {
			java.util.NavigableSet r = null;
			return (java.util.NavigableSet<E>)r;
		}
		public java.util.NavigableSet<E> subSet(E p0, boolean p1, E p2, boolean p3) {
			java.util.NavigableSet r = null;
			r = new java.util.concurrent.ConcurrentSkipListMap.KeySet();
			((java.util.concurrent.ConcurrentSkipListMap.KeySet)r).f19 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.KeySet)this).f19;
			return (java.util.NavigableSet<E>)r;
		}
		public java.util.NavigableSet<E> headSet(E p0) {
			java.util.NavigableSet r = null;
			return (java.util.NavigableSet<E>)r;
		}
		public java.util.NavigableSet<E> headSet(E p0, boolean p1) {
			java.util.NavigableSet r = null;
			r = new java.util.concurrent.ConcurrentSkipListMap.KeySet();
			((java.util.concurrent.ConcurrentSkipListMap.KeySet)r).f19 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.KeySet)this).f19;
			return (java.util.NavigableSet<E>)r;
		}
		public java.util.NavigableSet<E> tailSet(E p0) {
			java.util.NavigableSet r = null;
			r = new java.util.concurrent.ConcurrentSkipListMap.KeySet();
			((java.util.concurrent.ConcurrentSkipListMap.KeySet)r).f19 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.KeySet)this).f19;
			return (java.util.NavigableSet<E>)r;
		}
		public java.util.NavigableSet<E> tailSet(E p0, boolean p1) {
			java.util.NavigableSet r = null;
			r = new java.util.concurrent.ConcurrentSkipListMap.KeySet();
			((java.util.concurrent.ConcurrentSkipListMap.KeySet)r).f19 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.KeySet)this).f19;
			return (java.util.NavigableSet<E>)r;
		}
		public java.util.Comparator<? super E> comparator() {
			java.util.Comparator r = null;
			return (java.util.Comparator<? super E>)r;
		}
		public E last() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.KeySet)this).f19;
			return (E)r;
		}
		public E pollFirst() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.KeySet)this).f19;
			return (E)r;
		}
		public E pollLast() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.KeySet)this).f19;
			return (E)r;
		}
		public java.util.Iterator<E> descendingIterator() {
			java.util.Iterator r = null;
			r = new java.util.concurrent.ConcurrentSkipListMap().new KeyIterator();
			((java.util.concurrent.ConcurrentSkipListMap.KeyIterator)r).f112 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.KeySet)this).f19;
			return (java.util.Iterator<E>)r;
		}
		public E ceiling(E p0) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.KeySet)this).f19;
			return (E)r;
		}
		public E higher(E p0) {
			java.lang.Object r = null;
			return (E)r;
		}
		public java.util.NavigableSet<E> descendingSet() {
			java.util.NavigableSet r = null;
			r = new java.util.concurrent.ConcurrentSkipListMap.KeySet();
			((java.util.concurrent.ConcurrentSkipListMap.KeySet)r).f19 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.KeySet)this).f19;
			return (java.util.NavigableSet<E>)r;
		}
		public E lower(E p0) {
			java.lang.Object r = null;
			return (E)r;
		}
	}
	public final class EntryIterator extends java.util.concurrent.ConcurrentSkipListMap<K, V>.Iter<java.util.Map.Entry<K, V>> {
		public java.lang.Object f164;
		public java.lang.Object f149;
		EntryIterator(java.util.concurrent.ConcurrentSkipListMap p0) {
		}
		public EntryIterator() {
		}
		public java.util.Map.Entry<K, V> next() {
			java.util.Map.Entry r = null;
			r = new java.util.AtlasAbstractMap.SimpleImmutableEntry();
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f137 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.EntryIterator)this).f164;
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f12 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.EntryIterator)this).f149;
			return (java.util.Map.Entry<K, V>)r;
		}
	}
	public final class KeyIterator extends java.util.concurrent.ConcurrentSkipListMap<K, V>.Iter<K> {
		public java.lang.Object f112;
		KeyIterator(java.util.concurrent.ConcurrentSkipListMap p0) {
		}
		public KeyIterator() {
		}
		public K next() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.KeyIterator)this).f112;
			return (K)r;
		}
	}
	public final class ValueIterator extends java.util.concurrent.ConcurrentSkipListMap<K, V>.Iter<V> {
		public java.lang.Object f145;
		ValueIterator(java.util.concurrent.ConcurrentSkipListMap p0) {
		}
		public ValueIterator() {
		}
		public V next() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListMap.ValueIterator)this).f145;
			return (V)r;
		}
	}
	public abstract class Iter<T> implements java.util.Iterator<T> {
		Iter(java.util.concurrent.ConcurrentSkipListMap p0) {
		}
		public Iter() {
		}
		public void remove() {
		}
		public final boolean hasNext() {
			boolean r = false;
			return (boolean)r;
		}
	}
	public static final class HeadIndex<K,V> extends java.util.concurrent.ConcurrentSkipListMap.Index<K, V> {
		public HeadIndex() {
		}
	}
	public static class Index<K,V> {
		Index(java.util.concurrent.ConcurrentSkipListMap.Node<K, V> p0, java.util.concurrent.ConcurrentSkipListMap.Index<K, V> p1, java.util.concurrent.ConcurrentSkipListMap.Index<K, V> p2) {
		}
		public Index() {
		}
	}
	public static final class Node<K,V> {
		Node(K p0, java.lang.Object p1, java.util.concurrent.ConcurrentSkipListMap.Node<K, V> p2) {
		}
		Node(java.util.concurrent.ConcurrentSkipListMap.Node<K, V> p0) {
		}
		public Node() {
		}
	}
	public void putAll(java.util.Map<? extends K, ? extends V> p0) {
		((java.util.concurrent.ConcurrentSkipListMap)this).f46 = p0.values().iterator().next();
		((java.util.concurrent.ConcurrentSkipListMap)this).f86 = p0.keySet().iterator().next();
	}
}
