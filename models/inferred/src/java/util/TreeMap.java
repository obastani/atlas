package java.util;

import java.util.AtlasAbstractMap.ANON183;

public class TreeMap<K,V> extends java.util.AbstractMap<K, V> implements java.util.NavigableMap<K, V>, java.lang.Cloneable, java.io.Serializable {
	public java.lang.Object f13;
	public java.lang.Object f45;
	public TreeMap(java.util.SortedMap<K, ? extends V> p0) {
		((java.util.TreeMap)this).f13 = p0.keySet().iterator().next();
		((java.util.TreeMap)this).f45 = p0.values().iterator().next();
	}
	public TreeMap(java.util.Map<? extends K, ? extends V> p0) {
		((java.util.TreeMap)this).f45 = p0.values().iterator().next();
		((java.util.TreeMap)this).f13 = p0.keySet().iterator().next();
	}
	public TreeMap(java.util.Comparator<? super K> p0) {
	}
	public TreeMap() {
	}
	public V remove(java.lang.Object p0) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.TreeMap)this).f45;
		return (V)r;
	}
	public V get(java.lang.Object p0) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.TreeMap)this).f45;
		return (V)r;
	}
	public V put(K p0, V p1) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.TreeMap)this).f45;
		((java.util.TreeMap)this).f13 = (java.lang.Object)p0;
		((java.util.TreeMap)this).f45 = (java.lang.Object)p1;
		return (V)r;
	}
	public java.util.Collection<V> values() {
		java.util.Collection r = null;
		r = new java.util.TreeMap.Values();
		((java.util.TreeMap.Values)r).f89 = (java.lang.Object)((java.util.TreeMap)this).f45;
		return (java.util.Collection<V>)r;
	}
	public java.lang.Object clone() {
		java.lang.Object r = null;
		r = new java.util.TreeMap();
		((java.util.TreeMap)r).f13 = (java.lang.Object)((java.util.TreeMap)this).f13;
		((java.util.TreeMap)r).f45 = (java.lang.Object)((java.util.TreeMap)this).f45;
		return (java.lang.Object)r;
	}
	public void clear() {
	}
	public V replace(K p0, V p1) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.TreeMap)this).f45;
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
		r = new java.util.TreeMap.EntrySet();
		((java.util.TreeMap.EntrySet)r).f43 = (java.lang.Object)((java.util.TreeMap)this).f45;
		((java.util.TreeMap.EntrySet)r).f165 = (java.lang.Object)((java.util.TreeMap)this).f13;
		return (java.util.Set<java.util.Map.Entry<K, V>>)r;
	}
	public void putAll(java.util.Map<? extends K, ? extends V> p0) {
		((java.util.TreeMap)this).f13 = p0.keySet().iterator().next();
		((java.util.TreeMap)this).f45 = p0.values().iterator().next();
	}
	public java.util.Set<K> keySet() {
		java.util.Set r = null;
		r = new java.util.TreeMap.KeySet();
		((java.util.TreeMap.KeySet)r).f22 = (java.lang.Object)((java.util.TreeMap)this).f13;
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
	public java.util.Comparator<? super K> comparator() {
		java.util.Comparator r = null;
		return (java.util.Comparator<? super K>)r;
	}
	public java.util.NavigableSet<K> navigableKeySet() {
		java.util.NavigableSet r = null;
		r = new java.util.TreeMap.KeySet();
		((java.util.TreeMap.KeySet)r).f22 = (java.lang.Object)((java.util.TreeMap)this).f13;
		return (java.util.NavigableSet<K>)r;
	}
	public java.util.NavigableMap<K, V> descendingMap() {
		java.util.NavigableMap r = null;
		r = new java.util.TreeMap.DescendingSubMap();
		((java.util.TreeMap.DescendingSubMap)r).f92 = (java.lang.Object)((java.util.TreeMap)this).f13;
		((java.util.TreeMap.DescendingSubMap)r).f151 = (java.lang.Object)((java.util.TreeMap)this).f45;
		return (java.util.NavigableMap<K, V>)r;
	}
	public K firstKey() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.TreeMap)this).f13;
		return (K)r;
	}
	public K lastKey() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.TreeMap)this).f13;
		return (K)r;
	}
	public java.util.Map.Entry<K, V> firstEntry() {
		java.util.Map.Entry r = null;
		r = new java.util.AtlasAbstractMap.SimpleImmutableEntry();
		((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f137 = (java.lang.Object)((java.util.TreeMap)this).f13;
		((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f12 = (java.lang.Object)((java.util.TreeMap)this).f45;
		return (java.util.Map.Entry<K, V>)r;
	}
	public java.util.Map.Entry<K, V> lastEntry() {
		java.util.Map.Entry r = null;
		r = new java.util.AtlasAbstractMap.SimpleImmutableEntry();
		((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f137 = (java.lang.Object)((java.util.TreeMap)this).f13;
		((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f12 = (java.lang.Object)((java.util.TreeMap)this).f45;
		return (java.util.Map.Entry<K, V>)r;
	}
	public java.util.Map.Entry<K, V> pollFirstEntry() {
		java.util.Map.Entry r = null;
		r = new java.util.AtlasAbstractMap.SimpleImmutableEntry();
		((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f137 = (java.lang.Object)((java.util.TreeMap)this).f13;
		((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f12 = (java.lang.Object)((java.util.TreeMap)this).f45;
		return (java.util.Map.Entry<K, V>)r;
	}
	public java.util.Map.Entry<K, V> pollLastEntry() {
		java.util.Map.Entry r = null;
		r = new java.util.AtlasAbstractMap.SimpleImmutableEntry();
		((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f137 = (java.lang.Object)((java.util.TreeMap)this).f13;
		((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f12 = (java.lang.Object)((java.util.TreeMap)this).f45;
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
		((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f137 = (java.lang.Object)((java.util.TreeMap)this).f13;
		((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f12 = (java.lang.Object)((java.util.TreeMap)this).f45;
		return (java.util.Map.Entry<K, V>)r;
	}
	public K floorKey(K p0) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.TreeMap)this).f13;
		return (K)r;
	}
	public java.util.Map.Entry<K, V> ceilingEntry(K p0) {
		java.util.Map.Entry r = null;
		r = new java.util.AtlasAbstractMap.SimpleImmutableEntry();
		((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f137 = (java.lang.Object)((java.util.TreeMap)this).f13;
		((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f12 = (java.lang.Object)((java.util.TreeMap)this).f45;
		return (java.util.Map.Entry<K, V>)r;
	}
	public K ceilingKey(K p0) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.TreeMap)this).f13;
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
		r = new java.util.TreeMap.KeySet();
		((java.util.TreeMap.KeySet)r).f22 = (java.lang.Object)((java.util.TreeMap)this).f13;
		return (java.util.NavigableSet<K>)r;
	}
	public java.util.NavigableMap<K, V> subMap(K p0, boolean p1, K p2, boolean p3) {
		java.util.NavigableMap r = null;
		r = new java.util.TreeMap.AscendingSubMap();
		((java.util.TreeMap.AscendingSubMap)r).f41 = (java.lang.Object)((java.util.TreeMap)this).f45;
		((java.util.TreeMap.AscendingSubMap)r).f39 = (java.lang.Object)((java.util.TreeMap)this).f13;
		return (java.util.NavigableMap<K, V>)r;
	}
	public java.util.SortedMap<K, V> subMap(K p0, K p1) {
		java.util.SortedMap r = null;
		return (java.util.SortedMap<K, V>)r;
	}
	public java.util.SortedMap<K, V> headMap(K p0) {
		java.util.SortedMap r = null;
		return (java.util.SortedMap<K, V>)r;
	}
	public java.util.NavigableMap<K, V> headMap(K p0, boolean p1) {
		java.util.NavigableMap r = null;
		r = new java.util.TreeMap.AscendingSubMap();
		((java.util.TreeMap.AscendingSubMap)r).f41 = (java.lang.Object)((java.util.TreeMap)this).f45;
		((java.util.TreeMap.AscendingSubMap)r).f39 = (java.lang.Object)((java.util.TreeMap)this).f13;
		return (java.util.NavigableMap<K, V>)r;
	}
	public java.util.NavigableMap<K, V> tailMap(K p0, boolean p1) {
		java.util.NavigableMap r = null;
		r = new java.util.TreeMap.AscendingSubMap();
		((java.util.TreeMap.AscendingSubMap)r).f41 = (java.lang.Object)((java.util.TreeMap)this).f45;
		((java.util.TreeMap.AscendingSubMap)r).f39 = (java.lang.Object)((java.util.TreeMap)this).f13;
		return (java.util.NavigableMap<K, V>)r;
	}
	public java.util.SortedMap<K, V> tailMap(K p0) {
		java.util.SortedMap r = null;
		r = new java.util.TreeMap.AscendingSubMap();
		((java.util.TreeMap.AscendingSubMap)r).f41 = (java.lang.Object)((java.util.TreeMap)this).f45;
		((java.util.TreeMap.AscendingSubMap)r).f39 = (java.lang.Object)((java.util.TreeMap)this).f13;
		return (java.util.SortedMap<K, V>)r;
	}
	public static final class EntrySpliterator<K,V> extends java.util.TreeMap.TreeMapSpliterator<K, V> {
		public EntrySpliterator() {
		}
		public java.util.TreeMap.EntrySpliterator<K, V> trySplit() {
			java.util.TreeMap.EntrySpliterator r = null;
			return (java.util.TreeMap.EntrySpliterator<K, V>)r;
		}
		public int characteristics() {
			int r = 0;
			return (int)r;
		}
		public java.util.Comparator<java.util.Map.Entry<K, V>> getComparator() {
			java.util.Comparator r = null;
			return (java.util.Comparator<java.util.Map.Entry<K, V>>)r;
		}
	}
	public static final class ValueSpliterator<K,V> extends java.util.TreeMap.TreeMapSpliterator<K, V> {
		public ValueSpliterator() {
		}
		public java.util.TreeMap.ValueSpliterator<K, V> trySplit() {
			java.util.TreeMap.ValueSpliterator r = null;
			return (java.util.TreeMap.ValueSpliterator<K, V>)r;
		}
		public int characteristics() {
			int r = 0;
			return (int)r;
		}
	}
	public static final class DescendingKeySpliterator<K,V> extends java.util.TreeMap.TreeMapSpliterator<K, V> {
		public DescendingKeySpliterator() {
		}
		public java.util.TreeMap.DescendingKeySpliterator<K, V> trySplit() {
			java.util.TreeMap.DescendingKeySpliterator r = null;
			return (java.util.TreeMap.DescendingKeySpliterator<K, V>)r;
		}
		public int characteristics() {
			int r = 0;
			return (int)r;
		}
	}
	public static final class KeySpliterator<K,V> extends java.util.TreeMap.TreeMapSpliterator<K, V> {
		public KeySpliterator() {
		}
		public java.util.TreeMap.KeySpliterator<K, V> trySplit() {
			java.util.TreeMap.KeySpliterator r = null;
			return (java.util.TreeMap.KeySpliterator<K, V>)r;
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
	public static class TreeMapSpliterator<K,V> {
		public TreeMapSpliterator() {
		}
		public final long estimateSize() {
			long r = 0;
			return (long)r;
		}
	}
	public static final class Entry<K,V> implements java.util.Map.Entry<K, V> {
		public java.lang.Object f122;
		public java.lang.Object f170;
		Entry(K p0, V p1, java.util.TreeMap.Entry<K, V> p2) {
		}
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
			r = (java.lang.Object)((java.util.TreeMap.Entry)this).f122;
			return (V)r;
		}
		public K getKey() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.TreeMap.Entry)this).f170;
			return (K)r;
		}
		public V setValue(V p0) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.TreeMap.Entry)this).f122;
			return (V)r;
		}
	}
	public class SubMap extends java.util.AbstractMap<K, V> implements java.util.SortedMap<K, V>, java.io.Serializable {
		private SubMap(java.util.TreeMap p0) {
		}
		public SubMap() {
		}
		public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
			java.util.Set r = null;
			return (java.util.Set<java.util.Map.Entry<K, V>>)r;
		}
		public java.util.Comparator<? super K> comparator() {
			java.util.Comparator r = null;
			return (java.util.Comparator<? super K>)r;
		}
		public K firstKey() {
			java.lang.Object r = null;
			return (K)r;
		}
		public K lastKey() {
			java.lang.Object r = null;
			return (K)r;
		}
		public java.util.SortedMap<K, V> subMap(K p0, K p1) {
			java.util.SortedMap r = null;
			return (java.util.SortedMap<K, V>)r;
		}
		public java.util.SortedMap<K, V> headMap(K p0) {
			java.util.SortedMap r = null;
			return (java.util.SortedMap<K, V>)r;
		}
		public java.util.SortedMap<K, V> tailMap(K p0) {
			java.util.SortedMap r = null;
			return (java.util.SortedMap<K, V>)r;
		}
	}
	public static final class DescendingSubMap<K,V> extends java.util.TreeMap.NavigableSubMap<K, V> {
		public java.lang.Object f151;
		public java.lang.Object f92;
		public DescendingSubMap() {
		}
		public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
			java.util.Set r = null;
			return (java.util.Set<java.util.Map.Entry<K, V>>)r;
		}
		public java.util.Comparator<? super K> comparator() {
			java.util.Comparator r = null;
			return (java.util.Comparator<? super K>)r;
		}
		public java.util.NavigableMap<K, V> descendingMap() {
			java.util.NavigableMap r = null;
			r = new java.util.TreeMap.AscendingSubMap();
			((java.util.TreeMap.AscendingSubMap)r).f41 = (java.lang.Object)((java.util.TreeMap.DescendingSubMap)this).f151;
			return (java.util.NavigableMap<K, V>)r;
		}
		public java.util.NavigableMap<K, V> subMap(K p0, boolean p1, K p2, boolean p3) {
			java.util.NavigableMap r = null;
			r = new java.util.TreeMap.DescendingSubMap();
			((java.util.TreeMap.DescendingSubMap)r).f92 = (java.lang.Object)((java.util.TreeMap.DescendingSubMap)this).f92;
			return (java.util.NavigableMap<K, V>)r;
		}
		public java.util.NavigableMap<K, V> headMap(K p0, boolean p1) {
			java.util.NavigableMap r = null;
			r = new java.util.TreeMap.DescendingSubMap();
			((java.util.TreeMap.DescendingSubMap)r).f151 = (java.lang.Object)((java.util.TreeMap.DescendingSubMap)this).f151;
			return (java.util.NavigableMap<K, V>)r;
		}
		public java.util.NavigableMap<K, V> tailMap(K p0, boolean p1) {
			java.util.NavigableMap r = null;
			return (java.util.NavigableMap<K, V>)r;
		}
		public final class DescendingEntrySetView extends java.util.TreeMap.NavigableSubMap<K, V>.EntrySetView {
			DescendingEntrySetView(java.util.TreeMap.DescendingSubMap p0) {
			}
			public DescendingEntrySetView() {
			}
			public java.util.Iterator<java.util.Map.Entry<K, V>> iterator() {
				java.util.Iterator r = null;
				return (java.util.Iterator<java.util.Map.Entry<K, V>>)r;
			}
		}
		public java.util.Collection<V> values() {
			java.util.Collection r = null;
			r = new ANON183();
			((ANON183)r).f153 = (java.lang.Object)((java.util.TreeMap.DescendingSubMap)this).f151;
			return (java.util.Collection<V>)r;
		}
	}
	public static final class AscendingSubMap<K,V> extends java.util.TreeMap.NavigableSubMap<K, V> {
		public java.lang.Object f39;
		public java.lang.Object f41;
		public AscendingSubMap() {
		}
		public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
			java.util.Set r = null;
			return (java.util.Set<java.util.Map.Entry<K, V>>)r;
		}
		public java.util.Comparator<? super K> comparator() {
			java.util.Comparator r = null;
			return (java.util.Comparator<? super K>)r;
		}
		public java.util.NavigableMap<K, V> descendingMap() {
			java.util.NavigableMap r = null;
			r = new java.util.TreeMap.DescendingSubMap();
			((java.util.TreeMap.DescendingSubMap)r).f92 = (java.lang.Object)((java.util.TreeMap.AscendingSubMap)this).f39;
			((java.util.TreeMap.DescendingSubMap)r).f151 = (java.lang.Object)((java.util.TreeMap.AscendingSubMap)this).f41;
			return (java.util.NavigableMap<K, V>)r;
		}
		public java.util.NavigableMap<K, V> subMap(K p0, boolean p1, K p2, boolean p3) {
			java.util.NavigableMap r = null;
			r = new java.util.TreeMap.AscendingSubMap();
			((java.util.TreeMap.AscendingSubMap)r).f39 = (java.lang.Object)((java.util.TreeMap.AscendingSubMap)this).f39;
			((java.util.TreeMap.AscendingSubMap)r).f41 = (java.lang.Object)((java.util.TreeMap.AscendingSubMap)this).f41;
			return (java.util.NavigableMap<K, V>)r;
		}
		public java.util.NavigableMap<K, V> headMap(K p0, boolean p1) {
			java.util.NavigableMap r = null;
			r = new java.util.TreeMap.AscendingSubMap();
			((java.util.TreeMap.AscendingSubMap)r).f39 = (java.lang.Object)((java.util.TreeMap.AscendingSubMap)this).f39;
			((java.util.TreeMap.AscendingSubMap)r).f41 = (java.lang.Object)((java.util.TreeMap.AscendingSubMap)this).f41;
			return (java.util.NavigableMap<K, V>)r;
		}
		public java.util.NavigableMap<K, V> tailMap(K p0, boolean p1) {
			java.util.NavigableMap r = null;
			r = new java.util.TreeMap.AscendingSubMap();
			((java.util.TreeMap.AscendingSubMap)r).f41 = (java.lang.Object)((java.util.TreeMap.AscendingSubMap)this).f41;
			return (java.util.NavigableMap<K, V>)r;
		}
		public final class AscendingEntrySetView extends java.util.TreeMap.NavigableSubMap<K, V>.EntrySetView {
			AscendingEntrySetView(java.util.TreeMap.AscendingSubMap p0) {
			}
			public AscendingEntrySetView() {
			}
			public java.util.Iterator<java.util.Map.Entry<K, V>> iterator() {
				java.util.Iterator r = null;
				return (java.util.Iterator<java.util.Map.Entry<K, V>>)r;
			}
		}
		public java.util.Collection<V> values() {
			java.util.Collection r = null;
			r = new java.util.AtlasAbstractMap.ANON183();
			((java.util.AtlasAbstractMap.ANON183)r).f153 = (java.lang.Object)((java.util.TreeMap.AscendingSubMap)this).f41;
			return (java.util.Collection<V>)r;
		}
	}
	public abstract static class NavigableSubMap<K,V> extends java.util.AbstractMap<K, V> implements java.util.NavigableMap<K, V>, java.io.Serializable {
		public NavigableSubMap() {
		}
		public final V remove(java.lang.Object p0) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.TreeMap.DescendingSubMap)this).f151;
			r = (java.lang.Object)((java.util.TreeMap.AscendingSubMap)this).f41;
			return (V)r;
		}
		public final V get(java.lang.Object p0) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.TreeMap.DescendingSubMap)this).f151;
			r = (java.lang.Object)((java.util.TreeMap.AscendingSubMap)this).f41;
			return (V)r;
		}
		public final V put(K p0, V p1) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.TreeMap.AscendingSubMap)this).f41;
			return (V)r;
		}
		public boolean isEmpty() {
			boolean r = false;
			return (boolean)r;
		}
		public int size() {
			int r = 0;
			return (int)r;
		}
		public final java.util.Set<K> keySet() {
			java.util.Set r = null;
			r = new java.util.TreeMap.KeySet();
			((java.util.TreeMap.KeySet)r).f22 = (java.lang.Object)((java.util.TreeMap.DescendingSubMap)this).f92;
			((java.util.TreeMap.KeySet)r).f22 = (java.lang.Object)((java.util.TreeMap.AscendingSubMap)this).f39;
			return (java.util.Set<K>)r;
		}
		public final boolean containsKey(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public final java.util.NavigableSet<K> navigableKeySet() {
			java.util.NavigableSet r = null;
			r = new java.util.TreeMap.KeySet();
			((java.util.TreeMap.KeySet)r).f22 = (java.lang.Object)((java.util.TreeMap.DescendingSubMap)this).f92;
			return (java.util.NavigableSet<K>)r;
		}
		public final K firstKey() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.TreeMap.AscendingSubMap)this).f39;
			r = (java.lang.Object)((java.util.TreeMap.DescendingSubMap)this).f92;
			return (K)r;
		}
		public final K lastKey() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.TreeMap.AscendingSubMap)this).f39;
			r = (java.lang.Object)((java.util.TreeMap.DescendingSubMap)this).f92;
			return (K)r;
		}
		public final java.util.Map.Entry<K, V> firstEntry() {
			java.util.Map.Entry r = null;
			r = new java.util.AtlasAbstractMap.SimpleImmutableEntry();
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f12 = (java.lang.Object)((java.util.TreeMap.DescendingSubMap)this).f151;
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f137 = (java.lang.Object)((java.util.TreeMap.AscendingSubMap)this).f39;
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f137 = (java.lang.Object)((java.util.TreeMap.DescendingSubMap)this).f92;
			return (java.util.Map.Entry<K, V>)r;
		}
		public final java.util.Map.Entry<K, V> lastEntry() {
			java.util.Map.Entry r = null;
			r = new java.util.AtlasAbstractMap.SimpleImmutableEntry();
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f12 = (java.lang.Object)((java.util.TreeMap.DescendingSubMap)this).f151;
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f12 = (java.lang.Object)((java.util.TreeMap.AscendingSubMap)this).f41;
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f137 = (java.lang.Object)((java.util.TreeMap.AscendingSubMap)this).f39;
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f137 = (java.lang.Object)((java.util.TreeMap.DescendingSubMap)this).f92;
			return (java.util.Map.Entry<K, V>)r;
		}
		public final java.util.Map.Entry<K, V> pollFirstEntry() {
			java.util.Map.Entry r = null;
			r = new java.util.AtlasAbstractMap.SimpleImmutableEntry();
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f12 = (java.lang.Object)((java.util.TreeMap.DescendingSubMap)this).f151;
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f12 = (java.lang.Object)((java.util.TreeMap.AscendingSubMap)this).f41;
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f137 = (java.lang.Object)((java.util.TreeMap.AscendingSubMap)this).f39;
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f137 = (java.lang.Object)((java.util.TreeMap.DescendingSubMap)this).f92;
			return (java.util.Map.Entry<K, V>)r;
		}
		public final java.util.Map.Entry<K, V> pollLastEntry() {
			java.util.Map.Entry r = null;
			r = new java.util.AtlasAbstractMap.SimpleImmutableEntry();
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f12 = (java.lang.Object)((java.util.TreeMap.DescendingSubMap)this).f151;
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f12 = (java.lang.Object)((java.util.TreeMap.AscendingSubMap)this).f41;
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f137 = (java.lang.Object)((java.util.TreeMap.AscendingSubMap)this).f39;
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f137 = (java.lang.Object)((java.util.TreeMap.DescendingSubMap)this).f92;
			return (java.util.Map.Entry<K, V>)r;
		}
		public final java.util.Map.Entry<K, V> lowerEntry(K p0) {
			java.util.Map.Entry r = null;
			return (java.util.Map.Entry<K, V>)r;
		}
		public final K lowerKey(K p0) {
			java.lang.Object r = null;
			return (K)r;
		}
		public final java.util.Map.Entry<K, V> floorEntry(K p0) {
			java.util.Map.Entry r = null;
			r = new java.util.AtlasAbstractMap.SimpleImmutableEntry();
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f12 = (java.lang.Object)((java.util.TreeMap.DescendingSubMap)this).f151;
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f12 = (java.lang.Object)((java.util.TreeMap.AscendingSubMap)this).f41;
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f137 = (java.lang.Object)((java.util.TreeMap.AscendingSubMap)this).f39;
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f137 = (java.lang.Object)((java.util.TreeMap.DescendingSubMap)this).f92;
			return (java.util.Map.Entry<K, V>)r;
		}
		public final K floorKey(K p0) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.TreeMap.AscendingSubMap)this).f39;
			r = (java.lang.Object)((java.util.TreeMap.DescendingSubMap)this).f92;
			return (K)r;
		}
		public final java.util.Map.Entry<K, V> ceilingEntry(K p0) {
			java.util.Map.Entry r = null;
			r = new java.util.AtlasAbstractMap.SimpleImmutableEntry();
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f12 = (java.lang.Object)((java.util.TreeMap.DescendingSubMap)this).f151;
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f12 = (java.lang.Object)((java.util.TreeMap.AscendingSubMap)this).f41;
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f137 = (java.lang.Object)((java.util.TreeMap.AscendingSubMap)this).f39;
			return (java.util.Map.Entry<K, V>)r;
		}
		public final K ceilingKey(K p0) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.TreeMap.AscendingSubMap)this).f39;
			r = (java.lang.Object)((java.util.TreeMap.DescendingSubMap)this).f92;
			return (K)r;
		}
		public final java.util.Map.Entry<K, V> higherEntry(K p0) {
			java.util.Map.Entry r = null;
			return (java.util.Map.Entry<K, V>)r;
		}
		public final K higherKey(K p0) {
			java.lang.Object r = null;
			return (K)r;
		}
		public java.util.NavigableSet<K> descendingKeySet() {
			java.util.NavigableSet r = null;
			r = new java.util.TreeMap.KeySet();
			((java.util.TreeMap.KeySet)r).f22 = (java.lang.Object)((java.util.TreeMap.AscendingSubMap)this).f39;
			return (java.util.NavigableSet<K>)r;
		}
		public final java.util.SortedMap<K, V> subMap(K p0, K p1) {
			java.util.SortedMap r = null;
			return (java.util.SortedMap<K, V>)r;
		}
		public final java.util.SortedMap<K, V> headMap(K p0) {
			java.util.SortedMap r = null;
			return (java.util.SortedMap<K, V>)r;
		}
		public final java.util.SortedMap<K, V> tailMap(K p0) {
			java.util.SortedMap r = null;
			r = new java.util.TreeMap.AscendingSubMap();
			r = new java.util.TreeMap.DescendingSubMap();
			((java.util.TreeMap.AscendingSubMap)r).f41 = (java.lang.Object)((java.util.TreeMap.AscendingSubMap)this).f41;
			((java.util.TreeMap.DescendingSubMap)r).f92 = (java.lang.Object)((java.util.TreeMap.DescendingSubMap)this).f92;
			((java.util.TreeMap.DescendingSubMap)r).f151 = (java.lang.Object)((java.util.TreeMap.DescendingSubMap)this).f151;
			return (java.util.SortedMap<K, V>)r;
		}
		public final class DescendingSubMapKeyIterator extends java.util.TreeMap.NavigableSubMap<K, V>.SubMapIterator<K> {
			public java.lang.Object f84;
			public DescendingSubMapKeyIterator() {
			}
			public void remove() {
			}
			public K next() {
				java.lang.Object r = null;
				r = (java.lang.Object)((java.util.TreeMap.NavigableSubMap.DescendingSubMapKeyIterator)this).f84;
				return (K)r;
			}
			public long estimateSize() {
				long r = 0;
				return (long)r;
			}
			public int characteristics() {
				int r = 0;
				return (int)r;
			}
		}
		public final class SubMapKeyIterator extends java.util.TreeMap.NavigableSubMap<K, V>.SubMapIterator<K> {
			public java.lang.Object f110;
			public SubMapKeyIterator() {
			}
			public void remove() {
			}
			public K next() {
				java.lang.Object r = null;
				r = (java.lang.Object)((java.util.TreeMap.NavigableSubMap.SubMapKeyIterator)this).f110;
				return (K)r;
			}
			public long estimateSize() {
				long r = 0;
				return (long)r;
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
		public final class DescendingSubMapEntryIterator extends java.util.TreeMap.NavigableSubMap<K, V>.SubMapIterator<java.util.Map.Entry<K, V>> {
			public DescendingSubMapEntryIterator() {
			}
			public void remove() {
			}
			public java.util.Map.Entry<K, V> next() {
				java.util.Map.Entry r = null;
				return (java.util.Map.Entry<K, V>)r;
			}
		}
		public final class SubMapEntryIterator extends java.util.TreeMap.NavigableSubMap<K, V>.SubMapIterator<java.util.Map.Entry<K, V>> {
			public SubMapEntryIterator() {
			}
			public void remove() {
			}
			public java.util.Map.Entry<K, V> next() {
				java.util.Map.Entry r = null;
				return (java.util.Map.Entry<K, V>)r;
			}
		}
		public abstract class SubMapIterator<T> implements java.util.Iterator<T> {
			public SubMapIterator() {
			}
			public final boolean hasNext() {
				boolean r = false;
				return (boolean)r;
			}
		}
		public abstract class EntrySetView extends java.util.AbstractSet<java.util.Map.Entry<K, V>> {
			EntrySetView(java.util.TreeMap.NavigableSubMap p0) {
			}
			public EntrySetView() {
			}
			public boolean remove(java.lang.Object p0) {
				boolean r = false;
				return (boolean)r;
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
		}
	}
	public final class DescendingKeyIterator extends java.util.TreeMap<K, V>.PrivateEntryIterator<K> {
		public java.lang.Object f172;
		public DescendingKeyIterator() {
		}
		public void remove() {
		}
		public K next() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.TreeMap.DescendingKeyIterator)this).f172;
			return (K)r;
		}
	}
	public final class KeyIterator extends java.util.TreeMap<K, V>.PrivateEntryIterator<K> {
		public java.lang.Object f162;
		public KeyIterator() {
		}
		public K next() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.TreeMap.KeyIterator)this).f162;
			return (K)r;
		}
	}
	public final class ValueIterator extends java.util.TreeMap<K, V>.PrivateEntryIterator<V> {
		public java.lang.Object f144;
		public ValueIterator() {
		}
		public V next() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.TreeMap.ValueIterator)this).f144;
			return (V)r;
		}
	}
	public final class EntryIterator extends java.util.TreeMap<K, V>.PrivateEntryIterator<java.util.Map.Entry<K, V>> {
		public java.lang.Object f131;
		public java.lang.Object f117;
		public EntryIterator() {
		}
		public java.util.Map.Entry<K, V> next() {
			java.util.Map.Entry r = null;
			r = new java.util.TreeMap.Entry();
			((java.util.TreeMap.Entry)r).f122 = (java.lang.Object)((java.util.TreeMap.EntryIterator)this).f117;
			((java.util.TreeMap.Entry)r).f170 = (java.lang.Object)((java.util.TreeMap.EntryIterator)this).f131;
			return (java.util.Map.Entry<K, V>)r;
		}
	}
	public abstract class PrivateEntryIterator<T> implements java.util.Iterator<T> {
		public PrivateEntryIterator() {
		}
		public void remove() {
		}
		public final boolean hasNext() {
			boolean r = false;
			return (boolean)r;
		}
	}
	public static final class KeySet<E> extends java.util.AbstractSet<E> implements java.util.NavigableSet<E> {
		public java.lang.Object f22;
		KeySet(java.util.NavigableMap<E, ?> p0) {
		}
		public KeySet() {
		}
		public boolean remove(java.lang.Object p0) {
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
		public java.util.Iterator<E> iterator() {
			java.util.Iterator r = null;
			r = new java.util.TreeMap().new KeyIterator();
			((java.util.TreeMap.KeyIterator)r).f162 = (java.lang.Object)((java.util.TreeMap.KeySet)this).f22;
			return (java.util.Iterator<E>)r;
		}
		public E first() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.TreeMap.KeySet)this).f22;
			return (E)r;
		}
		public E floor(E p0) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.TreeMap.KeySet)this).f22;
			return (E)r;
		}
		public java.util.NavigableSet<E> subSet(E p0, boolean p1, E p2, boolean p3) {
			java.util.NavigableSet r = null;
			r = new java.util.TreeMap.KeySet();
			((java.util.TreeMap.KeySet)r).f22 = (java.lang.Object)((java.util.TreeMap.KeySet)this).f22;
			return (java.util.NavigableSet<E>)r;
		}
		public java.util.SortedSet<E> subSet(E p0, E p1) {
			java.util.SortedSet r = null;
			return (java.util.SortedSet<E>)r;
		}
		public java.util.SortedSet<E> headSet(E p0) {
			java.util.SortedSet r = null;
			return (java.util.SortedSet<E>)r;
		}
		public java.util.NavigableSet<E> headSet(E p0, boolean p1) {
			java.util.NavigableSet r = null;
			r = new java.util.TreeMap.KeySet();
			((java.util.TreeMap.KeySet)r).f22 = (java.lang.Object)((java.util.TreeMap.KeySet)this).f22;
			return (java.util.NavigableSet<E>)r;
		}
		public java.util.SortedSet<E> tailSet(E p0) {
			java.util.SortedSet r = null;
			r = new java.util.TreeMap.KeySet();
			((java.util.TreeMap.KeySet)r).f22 = (java.lang.Object)((java.util.TreeMap.KeySet)this).f22;
			return (java.util.SortedSet<E>)r;
		}
		public java.util.NavigableSet<E> tailSet(E p0, boolean p1) {
			java.util.NavigableSet r = null;
			r = new java.util.TreeMap.KeySet();
			((java.util.TreeMap.KeySet)r).f22 = (java.lang.Object)((java.util.TreeMap.KeySet)this).f22;
			return (java.util.NavigableSet<E>)r;
		}
		public java.util.Comparator<? super E> comparator() {
			java.util.Comparator r = null;
			return (java.util.Comparator<? super E>)r;
		}
		public E last() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.TreeMap.KeySet)this).f22;
			return (E)r;
		}
		public E pollFirst() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.TreeMap.KeySet)this).f22;
			return (E)r;
		}
		public E pollLast() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.TreeMap.KeySet)this).f22;
			return (E)r;
		}
		public java.util.Iterator<E> descendingIterator() {
			java.util.Iterator r = null;
			r = new java.util.TreeMap().new DescendingKeyIterator();
			((java.util.TreeMap.DescendingKeyIterator)r).f172 = (java.lang.Object)((java.util.TreeMap.KeySet)this).f22;
			return (java.util.Iterator<E>)r;
		}
		public E ceiling(E p0) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.TreeMap.KeySet)this).f22;
			return (E)r;
		}
		public E higher(E p0) {
			java.lang.Object r = null;
			return (E)r;
		}
		public java.util.NavigableSet<E> descendingSet() {
			java.util.NavigableSet r = null;
			r = new java.util.TreeMap.KeySet();
			((java.util.TreeMap.KeySet)r).f22 = (java.lang.Object)((java.util.TreeMap.KeySet)this).f22;
			return (java.util.NavigableSet<E>)r;
		}
		public E lower(E p0) {
			java.lang.Object r = null;
			return (E)r;
		}
	}
	public class EntrySet extends java.util.AbstractSet<java.util.Map.Entry<K, V>> {
		public java.lang.Object f165;
		public java.lang.Object f43;
		EntrySet(java.util.TreeMap p0) {
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
		public java.util.Iterator<java.util.Map.Entry<K, V>> iterator() {
			java.util.Iterator r = null;
			r = new java.util.TreeMap.EntryIterator();
			((java.util.TreeMap.EntryIterator)r).f117 = (java.lang.Object)((java.util.TreeMap.EntrySet)this).f43;
			((java.util.TreeMap.EntryIterator)r).f131 = (java.lang.Object)((java.util.TreeMap.EntrySet)this).f165;
			return (java.util.Iterator<java.util.Map.Entry<K, V>>)r;
		}
	}
	public class Values extends java.util.AbstractCollection<V> {
		public java.lang.Object f89;
		Values(java.util.TreeMap p0) {
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
		public java.util.Iterator<V> iterator() {
			java.util.Iterator r = null;
			r = new java.util.TreeMap.ValueIterator();
			((java.util.TreeMap.ValueIterator)r).f144 = (java.lang.Object)((java.util.TreeMap.Values)this).f89;
			return (java.util.Iterator<V>)r;
		}
	}
}
