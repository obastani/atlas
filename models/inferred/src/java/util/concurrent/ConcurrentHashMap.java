package java.util.concurrent;
public class ConcurrentHashMap<K,V> extends java.util.AbstractMap<K, V> implements java.util.concurrent.ConcurrentMap<K, V>, java.io.Serializable {
	public java.lang.Object f50;
	public java.lang.Object f85;
	public ConcurrentHashMap(java.util.Map<? extends K, ? extends V> p0) {
		((java.util.concurrent.ConcurrentHashMap)this).f85 = p0.values().iterator().next();
		((java.util.concurrent.ConcurrentHashMap)this).f50 = p0.keySet().iterator().next();
	}
	public ConcurrentHashMap() {
	}
	public boolean remove(java.lang.Object p0, java.lang.Object p1) {
		boolean r = false;
		return (boolean)r;
	}
	public V remove(java.lang.Object p0) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentHashMap)this).f85;
		return (V)r;
	}
	public V get(java.lang.Object p0) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentHashMap)this).f85;
		return (V)r;
	}
	public V put(K p0, V p1) {
		java.lang.Object r = null;
		((java.util.concurrent.ConcurrentHashMap)this).f85 = (java.lang.Object)p1;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentHashMap)this).f85;
		((java.util.concurrent.ConcurrentHashMap)this).f50 = (java.lang.Object)p0;
		return (V)r;
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
	public java.util.Collection<V> values() {
		java.util.Collection r = null;
		r = new java.util.concurrent.ConcurrentHashMap.ValuesView();
		((java.util.concurrent.ConcurrentHashMap.ValuesView)r).f106 = (java.lang.Object)((java.util.concurrent.ConcurrentHashMap)this).f85;
		return (java.util.Collection<V>)r;
	}
	public int hashCode() {
		int r = 0;
		return (int)r;
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
		r = (java.lang.Object)((java.util.concurrent.ConcurrentHashMap)this).f85;
		return (V)r;
	}
	public boolean contains(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
	}
	public int size() {
		int r = 0;
		return (int)r;
	}
	public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
		java.util.Set r = null;
		r = new java.util.concurrent.ConcurrentHashMap.EntrySetView();
		return (java.util.Set<java.util.Map.Entry<K, V>>)r;
	}
	public void putAll(java.util.Map<? extends K, ? extends V> p0) {
		((java.util.concurrent.ConcurrentHashMap)this).f85 = p0.values().iterator().next();
		((java.util.concurrent.ConcurrentHashMap)this).f50 = p0.keySet().iterator().next();
	}
	public V putIfAbsent(K p0, V p1) {
		java.lang.Object r = null;
		((java.util.concurrent.ConcurrentHashMap)this).f85 = (java.lang.Object)p1;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentHashMap)this).f85;
		((java.util.concurrent.ConcurrentHashMap)this).f50 = (java.lang.Object)p0;
		return (V)r;
	}
	public java.util.Enumeration<V> elements() {
		java.util.Enumeration r = null;
		r = new java.util.concurrent.ConcurrentHashMap.ValueIterator();
		((java.util.concurrent.ConcurrentHashMap.ValueIterator)r).f79 = (java.lang.Object)((java.util.concurrent.ConcurrentHashMap)this).f85;
		return (java.util.Enumeration<V>)r;
	}
	public java.util.Enumeration<K> keys() {
		java.util.Enumeration r = null;
		r = new java.util.concurrent.ConcurrentHashMap.KeyIterator();
		((java.util.concurrent.ConcurrentHashMap.KeyIterator)r).f167 = (java.lang.Object)((java.util.concurrent.ConcurrentHashMap)this).f50;
		return (java.util.Enumeration<K>)r;
	}
	public java.util.concurrent.ConcurrentHashMap.KeySetView<K, V> keySet(V p0) {
		java.util.concurrent.ConcurrentHashMap.KeySetView r = null;
		r = new java.util.concurrent.ConcurrentHashMap.KeySetView();
		((java.util.concurrent.ConcurrentHashMap.KeySetView)r).f67 = (java.lang.Object)((java.util.concurrent.ConcurrentHashMap)this).f50;
		return (java.util.concurrent.ConcurrentHashMap.KeySetView<K, V>)r;
	}
	public java.util.concurrent.ConcurrentHashMap.KeySetView<K, V> keySet() {
		java.util.concurrent.ConcurrentHashMap.KeySetView r = null;
		r = new java.util.concurrent.ConcurrentHashMap.KeySetView();
		((java.util.concurrent.ConcurrentHashMap.KeySetView)r).f67 = (java.lang.Object)((java.util.concurrent.ConcurrentHashMap)this).f50;
		return (java.util.concurrent.ConcurrentHashMap.KeySetView<K, V>)r;
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
		r = (java.lang.Object)((java.util.concurrent.ConcurrentHashMap)this).f85;
		return (V)r;
	}
	public long mappingCount() {
		long r = 0;
		return (long)r;
	}
	public static <K> java.util.concurrent.ConcurrentHashMap.KeySetView<K, java.lang.Boolean> newKeySet() {
		java.util.concurrent.ConcurrentHashMap.KeySetView r = null;
		return (java.util.concurrent.ConcurrentHashMap.KeySetView<K, java.lang.Boolean>)r;
	}
	public static <K> java.util.concurrent.ConcurrentHashMap.KeySetView<K, java.lang.Boolean> newKeySet(int p0) {
		java.util.concurrent.ConcurrentHashMap.KeySetView r = null;
		return (java.util.concurrent.ConcurrentHashMap.KeySetView<K, java.lang.Boolean>)r;
	}
	public static final class MapReduceMappingsToIntTask<K,V> extends java.util.concurrent.ConcurrentHashMap.BulkTask<K, V, java.lang.Integer> {
		public MapReduceMappingsToIntTask() {
		}
		public final void compute() {
		}
		public final java.lang.Integer getRawResult() {
			java.lang.Integer r = null;
			return (java.lang.Integer)r;
		}
	}
	public static final class MapReduceEntriesToIntTask<K,V> extends java.util.concurrent.ConcurrentHashMap.BulkTask<K, V, java.lang.Integer> {
		public MapReduceEntriesToIntTask() {
		}
		public final void compute() {
		}
		public final java.lang.Integer getRawResult() {
			java.lang.Integer r = null;
			return (java.lang.Integer)r;
		}
	}
	public static final class MapReduceValuesToIntTask<K,V> extends java.util.concurrent.ConcurrentHashMap.BulkTask<K, V, java.lang.Integer> {
		public MapReduceValuesToIntTask() {
		}
		public final void compute() {
		}
		public final java.lang.Integer getRawResult() {
			java.lang.Integer r = null;
			return (java.lang.Integer)r;
		}
	}
	public static final class MapReduceKeysToIntTask<K,V> extends java.util.concurrent.ConcurrentHashMap.BulkTask<K, V, java.lang.Integer> {
		public MapReduceKeysToIntTask() {
		}
		public final void compute() {
		}
		public final java.lang.Integer getRawResult() {
			java.lang.Integer r = null;
			return (java.lang.Integer)r;
		}
	}
	public static final class MapReduceMappingsToLongTask<K,V> extends java.util.concurrent.ConcurrentHashMap.BulkTask<K, V, java.lang.Long> {
		public MapReduceMappingsToLongTask() {
		}
		public final void compute() {
		}
		public final java.lang.Long getRawResult() {
			java.lang.Long r = null;
			return (java.lang.Long)r;
		}
	}
	public static final class MapReduceEntriesToLongTask<K,V> extends java.util.concurrent.ConcurrentHashMap.BulkTask<K, V, java.lang.Long> {
		public MapReduceEntriesToLongTask() {
		}
		public final void compute() {
		}
		public final java.lang.Long getRawResult() {
			java.lang.Long r = null;
			return (java.lang.Long)r;
		}
	}
	public static final class MapReduceValuesToLongTask<K,V> extends java.util.concurrent.ConcurrentHashMap.BulkTask<K, V, java.lang.Long> {
		public MapReduceValuesToLongTask() {
		}
		public final void compute() {
		}
		public final java.lang.Long getRawResult() {
			java.lang.Long r = null;
			return (java.lang.Long)r;
		}
	}
	public static final class MapReduceKeysToLongTask<K,V> extends java.util.concurrent.ConcurrentHashMap.BulkTask<K, V, java.lang.Long> {
		public MapReduceKeysToLongTask() {
		}
		public final void compute() {
		}
		public final java.lang.Long getRawResult() {
			java.lang.Long r = null;
			return (java.lang.Long)r;
		}
	}
	public static final class MapReduceMappingsToDoubleTask<K,V> extends java.util.concurrent.ConcurrentHashMap.BulkTask<K, V, java.lang.Double> {
		public MapReduceMappingsToDoubleTask() {
		}
		public final void compute() {
		}
		public final java.lang.Double getRawResult() {
			java.lang.Double r = null;
			return (java.lang.Double)r;
		}
	}
	public static final class MapReduceEntriesToDoubleTask<K,V> extends java.util.concurrent.ConcurrentHashMap.BulkTask<K, V, java.lang.Double> {
		public MapReduceEntriesToDoubleTask() {
		}
		public final void compute() {
		}
		public final java.lang.Double getRawResult() {
			java.lang.Double r = null;
			return (java.lang.Double)r;
		}
	}
	public static final class MapReduceValuesToDoubleTask<K,V> extends java.util.concurrent.ConcurrentHashMap.BulkTask<K, V, java.lang.Double> {
		public MapReduceValuesToDoubleTask() {
		}
		public final void compute() {
		}
		public final java.lang.Double getRawResult() {
			java.lang.Double r = null;
			return (java.lang.Double)r;
		}
	}
	public static final class MapReduceKeysToDoubleTask<K,V> extends java.util.concurrent.ConcurrentHashMap.BulkTask<K, V, java.lang.Double> {
		public MapReduceKeysToDoubleTask() {
		}
		public final void compute() {
		}
		public final java.lang.Double getRawResult() {
			java.lang.Double r = null;
			return (java.lang.Double)r;
		}
	}
	public static final class MapReduceMappingsTask<K,V,U> extends java.util.concurrent.ConcurrentHashMap.BulkTask<K, V, U> {
		public MapReduceMappingsTask() {
		}
		public final void compute() {
		}
		public final U getRawResult() {
			java.lang.Object r = null;
			return (U)r;
		}
	}
	public static final class MapReduceEntriesTask<K,V,U> extends java.util.concurrent.ConcurrentHashMap.BulkTask<K, V, U> {
		public MapReduceEntriesTask() {
		}
		public final void compute() {
		}
		public final U getRawResult() {
			java.lang.Object r = null;
			return (U)r;
		}
	}
	public static final class MapReduceValuesTask<K,V,U> extends java.util.concurrent.ConcurrentHashMap.BulkTask<K, V, U> {
		public MapReduceValuesTask() {
		}
		public final void compute() {
		}
		public final U getRawResult() {
			java.lang.Object r = null;
			return (U)r;
		}
	}
	public static final class MapReduceKeysTask<K,V,U> extends java.util.concurrent.ConcurrentHashMap.BulkTask<K, V, U> {
		public MapReduceKeysTask() {
		}
		public final void compute() {
		}
		public final U getRawResult() {
			java.lang.Object r = null;
			return (U)r;
		}
	}
	public static final class ReduceEntriesTask<K,V> extends java.util.concurrent.ConcurrentHashMap.BulkTask<K, V, java.util.Map.Entry<K, V>> {
		public ReduceEntriesTask() {
		}
		public final void compute() {
		}
		public final java.util.Map.Entry<K, V> getRawResult() {
			java.util.Map.Entry r = null;
			return (java.util.Map.Entry<K, V>)r;
		}
	}
	public static final class ReduceValuesTask<K,V> extends java.util.concurrent.ConcurrentHashMap.BulkTask<K, V, V> {
		public ReduceValuesTask() {
		}
		public final void compute() {
		}
		public final V getRawResult() {
			java.lang.Object r = null;
			return (V)r;
		}
	}
	public static final class ReduceKeysTask<K,V> extends java.util.concurrent.ConcurrentHashMap.BulkTask<K, V, K> {
		public ReduceKeysTask() {
		}
		public final void compute() {
		}
		public final K getRawResult() {
			java.lang.Object r = null;
			return (K)r;
		}
	}
	public static final class SearchMappingsTask<K,V,U> extends java.util.concurrent.ConcurrentHashMap.BulkTask<K, V, U> {
		public SearchMappingsTask() {
		}
		public final void compute() {
		}
		public final U getRawResult() {
			java.lang.Object r = null;
			return (U)r;
		}
	}
	public static final class SearchEntriesTask<K,V,U> extends java.util.concurrent.ConcurrentHashMap.BulkTask<K, V, U> {
		public SearchEntriesTask() {
		}
		public final void compute() {
		}
		public final U getRawResult() {
			java.lang.Object r = null;
			return (U)r;
		}
	}
	public static final class SearchValuesTask<K,V,U> extends java.util.concurrent.ConcurrentHashMap.BulkTask<K, V, U> {
		public SearchValuesTask() {
		}
		public final void compute() {
		}
		public final U getRawResult() {
			java.lang.Object r = null;
			return (U)r;
		}
	}
	public static final class SearchKeysTask<K,V,U> extends java.util.concurrent.ConcurrentHashMap.BulkTask<K, V, U> {
		public SearchKeysTask() {
		}
		public final void compute() {
		}
		public final U getRawResult() {
			java.lang.Object r = null;
			return (U)r;
		}
	}
	public static final class ForEachTransformedMappingTask<K,V,U> extends java.util.concurrent.ConcurrentHashMap.BulkTask<K, V, java.lang.Void> {
		public ForEachTransformedMappingTask() {
		}
		public final void compute() {
		}
	}
	public static final class ForEachTransformedEntryTask<K,V,U> extends java.util.concurrent.ConcurrentHashMap.BulkTask<K, V, java.lang.Void> {
		public ForEachTransformedEntryTask() {
		}
		public final void compute() {
		}
	}
	public static final class ForEachTransformedValueTask<K,V,U> extends java.util.concurrent.ConcurrentHashMap.BulkTask<K, V, java.lang.Void> {
		public ForEachTransformedValueTask() {
		}
		public final void compute() {
		}
	}
	public static final class ForEachTransformedKeyTask<K,V,U> extends java.util.concurrent.ConcurrentHashMap.BulkTask<K, V, java.lang.Void> {
		public ForEachTransformedKeyTask() {
		}
		public final void compute() {
		}
	}
	public static final class ForEachMappingTask<K,V> extends java.util.concurrent.ConcurrentHashMap.BulkTask<K, V, java.lang.Void> {
		public ForEachMappingTask() {
		}
		public final void compute() {
		}
	}
	public static final class ForEachEntryTask<K,V> extends java.util.concurrent.ConcurrentHashMap.BulkTask<K, V, java.lang.Void> {
		public ForEachEntryTask() {
		}
		public final void compute() {
		}
	}
	public static final class ForEachValueTask<K,V> extends java.util.concurrent.ConcurrentHashMap.BulkTask<K, V, java.lang.Void> {
		public ForEachValueTask() {
		}
		public final void compute() {
		}
	}
	public static final class ForEachKeyTask<K,V> extends java.util.concurrent.ConcurrentHashMap.BulkTask<K, V, java.lang.Void> {
		public ForEachKeyTask() {
		}
		public final void compute() {
		}
	}
	public abstract static class BulkTask<K,V,R> {
		public BulkTask() {
		}
	}
	public static final class EntrySetView<K,V> extends java.util.concurrent.ConcurrentHashMap.CollectionView<K, V, java.util.Map.Entry<K, V>> implements java.util.Set<java.util.Map.Entry<K, V>>, java.io.Serializable {
		EntrySetView(java.util.concurrent.ConcurrentHashMap<K, V> p0) {
		}
		public EntrySetView() {
		}
		public boolean add(java.util.Map.Entry<K, V> p0) {
			boolean r = false;
			return (boolean)r;
		}
		public boolean remove(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public final boolean equals(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public final int hashCode() {
			int r = 0;
			return (int)r;
		}
		public boolean contains(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public java.util.Iterator<java.util.Map.Entry<K, V>> iterator() {
			java.util.Iterator r = null;
			return (java.util.Iterator<java.util.Map.Entry<K, V>>)r;
		}
		public boolean addAll(java.util.Collection<? extends java.util.Map.Entry<K, V>> p0) {
			boolean r = false;
			return (boolean)r;
		}
	}
	public static final class ValuesView<K,V> extends java.util.concurrent.ConcurrentHashMap.CollectionView<K, V, V> implements java.util.Collection<V>, java.io.Serializable {
		public java.lang.Object f106;
		ValuesView(java.util.concurrent.ConcurrentHashMap<K, V> p0) {
		}
		public ValuesView() {
		}
		public final boolean add(V p0) {
			boolean r = false;
			return (boolean)r;
		}
		public final boolean remove(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public final boolean contains(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public final java.util.Iterator<V> iterator() {
			java.util.Iterator r = null;
			r = new java.util.concurrent.ConcurrentHashMap.ValueIterator();
			((java.util.concurrent.ConcurrentHashMap.ValueIterator)r).f79 = (java.lang.Object)((java.util.concurrent.ConcurrentHashMap.ValuesView)this).f106;
			return (java.util.Iterator<V>)r;
		}
		public final boolean addAll(java.util.Collection<? extends V> p0) {
			boolean r = false;
			return (boolean)r;
		}
	}
	public static class KeySetView<K,V> extends java.util.concurrent.ConcurrentHashMap.CollectionView<K, V, K> implements java.util.Set<K>, java.io.Serializable {
		public java.lang.Object f67;
		KeySetView(java.util.concurrent.ConcurrentHashMap<K, V> p0, V p1) {
		}
		public KeySetView() {
		}
		public boolean add(K p0) {
			boolean r = false;
			return (boolean)r;
		}
		public boolean remove(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public boolean equals(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public int hashCode() {
			int r = 0;
			return (int)r;
		}
		public boolean contains(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public java.util.Iterator<K> iterator() {
			java.util.Iterator r = null;
			r = new java.util.concurrent.ConcurrentHashMap.KeyIterator();
			((java.util.concurrent.ConcurrentHashMap.KeyIterator)r).f167 = (java.lang.Object)((java.util.concurrent.ConcurrentHashMap.KeySetView)this).f67;
			return (java.util.Iterator<K>)r;
		}
		public boolean addAll(java.util.Collection<? extends K> p0) {
			boolean r = false;
			return (boolean)r;
		}
		public V getMappedValue() {
			java.lang.Object r = null;
			return (V)r;
		}
	}
	public abstract static class CollectionView<K,V,E> implements java.util.Collection<E>, java.io.Serializable {
		CollectionView(java.util.concurrent.ConcurrentHashMap<K, V> p0) {
		}
		public CollectionView() {
		}
		public abstract boolean remove(java.lang.Object p0);
		public final java.lang.String toString() {
			java.lang.String r = null;
			return (java.lang.String)r;
		}
		public final void clear() {
		}
		public final boolean isEmpty() {
			boolean r = false;
			return (boolean)r;
		}
		public abstract boolean contains(java.lang.Object p0);
		public final int size() {
			int r = 0;
			return (int)r;
		}
		public final <T> T[] toArray(T[] p0) {
			java.lang.Object[] r = null;
			return (T[])r;
		}
		public final java.lang.Object[] toArray() {
			java.lang.Object[] r = null;
			return (java.lang.Object[])r;
		}
		public abstract java.util.Iterator<E> iterator();
		public final boolean containsAll(java.util.Collection<?> p0) {
			boolean r = false;
			return (boolean)r;
		}
		public final boolean removeAll(java.util.Collection<?> p0) {
			boolean r = false;
			return (boolean)r;
		}
		public final boolean retainAll(java.util.Collection<?> p0) {
			boolean r = false;
			return (boolean)r;
		}
		public java.util.concurrent.ConcurrentHashMap<K, V> getMap() {
			java.util.concurrent.ConcurrentHashMap r = null;
			return (java.util.concurrent.ConcurrentHashMap<K, V>)r;
		}
	}
	public static final class EntrySpliterator<K,V> extends java.util.concurrent.ConcurrentHashMap.Traverser<K, V> {
		public EntrySpliterator() {
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
	public static final class ValueSpliterator<K,V> extends java.util.concurrent.ConcurrentHashMap.Traverser<K, V> {
		public ValueSpliterator() {
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
	public static final class KeySpliterator<K,V> extends java.util.concurrent.ConcurrentHashMap.Traverser<K, V> {
		public KeySpliterator() {
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
	public static final class MapEntry<K,V> implements java.util.Map.Entry<K, V> {
		MapEntry(K p0, V p1, java.util.concurrent.ConcurrentHashMap<K, V> p2) {
		}
		public MapEntry() {
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
			return (K)r;
		}
		public V setValue(V p0) {
			java.lang.Object r = null;
			return (V)r;
		}
	}
	public static final class EntryIterator<K,V> extends java.util.concurrent.ConcurrentHashMap.BaseIterator<K, V> implements java.util.Iterator<java.util.Map.Entry<K, V>> {
		public EntryIterator() {
		}
		public final java.util.Map.Entry<K, V> next() {
			java.util.Map.Entry r = null;
			return (java.util.Map.Entry<K, V>)r;
		}
	}
	public static final class ValueIterator<K,V> extends java.util.concurrent.ConcurrentHashMap.BaseIterator<K, V> implements java.util.Iterator<V>, java.util.Enumeration<V> {
		public java.lang.Object f79;
		public ValueIterator() {
		}
		public final V next() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.concurrent.ConcurrentHashMap.ValueIterator)this).f79;
			return (V)r;
		}
		public final V nextElement() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.concurrent.ConcurrentHashMap.ValueIterator)this).f79;
			return (V)r;
		}
	}
	public static final class KeyIterator<K,V> extends java.util.concurrent.ConcurrentHashMap.BaseIterator<K, V> implements java.util.Iterator<K>, java.util.Enumeration<K> {
		public java.lang.Object f167;
		public KeyIterator() {
		}
		public final K next() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.concurrent.ConcurrentHashMap.KeyIterator)this).f167;
			return (K)r;
		}
		public final K nextElement() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.concurrent.ConcurrentHashMap.KeyIterator)this).f167;
			return (K)r;
		}
	}
	public static class BaseIterator<K,V> extends java.util.concurrent.ConcurrentHashMap.Traverser<K, V> {
		public BaseIterator() {
		}
		public final void remove() {
		}
		public final boolean hasNext() {
			boolean r = false;
			return (boolean)r;
		}
		public final boolean hasMoreElements() {
			boolean r = false;
			return (boolean)r;
		}
	}
	public static class Traverser<K,V> {
		public Traverser() {
		}
	}
	public static final class TableStack<K,V> {
		public TableStack() {
		}
	}
	public static final class TreeBin<K,V> extends java.util.concurrent.ConcurrentHashMap.Node<K, V> {
		TreeBin(java.util.concurrent.ConcurrentHashMap.TreeNode<K, V> p0) {
		}
		public TreeBin() {
		}
	}
	public static final class TreeNode<K,V> extends java.util.concurrent.ConcurrentHashMap.Node<K, V> {
		public TreeNode() {
		}
	}
	public static final class CounterCell {
		public CounterCell() {
		}
	}
	public static final class ReservationNode<K,V> extends java.util.concurrent.ConcurrentHashMap.Node<K, V> {
		public ReservationNode() {
		}
	}
	public static final class ForwardingNode<K,V> extends java.util.concurrent.ConcurrentHashMap.Node<K, V> {
		public ForwardingNode() {
		}
	}
	public static class Segment<K,V> extends java.util.concurrent.locks.ReentrantLock implements java.io.Serializable {
		public Segment() {
		}
	}
	public static class Node<K,V> implements java.util.Map.Entry<K, V> {
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
			return (V)r;
		}
		public final K getKey() {
			java.lang.Object r = null;
			return (K)r;
		}
		public final V setValue(V p0) {
			java.lang.Object r = null;
			return (V)r;
		}
	}
}
