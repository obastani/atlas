package java.util;

import java.util.LinkedList.ListItr;

public class Collections {
	public Collections() {
	}
	public static <T> T min(java.util.Collection<? extends T> p0, java.util.Comparator<? super T> p1) {
		java.lang.Object r = null;
		r = p0.iterator().next();
		return (T)r;
	}
	public static <T> T min(java.util.Collection<? extends T> p0) {
		java.lang.Object r = null;
		r = p0.iterator().next();
		return (T)r;
	}
	public static <T> T max(java.util.Collection<? extends T> p0, java.util.Comparator<? super T> p1) {
		java.lang.Object r = null;
		r = p0.iterator().next();
		return (T)r;
	}
	public static <T> T max(java.util.Collection<? extends T> p0) {
		java.lang.Object r = null;
		r = p0.iterator().next();
		return (T)r;
	}
	public static <T> boolean replaceAll(java.util.List<T> p0, T p1, T p2) {
		boolean r = false;
		return (boolean)r;
	}
	public static <T> boolean addAll(java.util.Collection<? super T> p0, T[] p1) {
		boolean r = false;
		return (boolean)r;
	}
	public static <T> java.util.Set<T> synchronizedSet(java.util.Set<T> p0) {
		java.util.Set r = null;
		r = new java.util.Collections.SynchronizedSet();
		((java.util.Collections.SynchronizedSet)r).f78 = p0.iterator().next();
		return (java.util.Set<T>)r;
	}
	public static <T> java.util.Enumeration<T> emptyEnumeration() {
		java.util.Enumeration r = null;
		return (java.util.Enumeration<T>)r;
	}
	public static <E> java.util.Set<E> newSetFromMap(java.util.Map<E, java.lang.Boolean> p0) {
		java.util.Set r = null;
		return (java.util.Set<E>)r;
	}
	public static <T> java.util.List<T> unmodifiableList(java.util.List<? extends T> p0) {
		java.util.List r = null;
		r = new java.util.Collections.UnmodifiableList();
		r = new java.util.Collections.UnmodifiableRandomAccessList();
		((java.util.Collections.UnmodifiableRandomAccessList)r).f20 = p0.iterator().next();
		((java.util.Collections.UnmodifiableList)r).f116 = p0.iterator().next();
		return (java.util.List<T>)r;
	}
	public static <T> java.util.ArrayList<T> list(java.util.Enumeration<T> p0) {
		java.util.ArrayList r = null;
		r = new java.util.ArrayList();
		((java.util.ArrayList)r).f35 = p0.nextElement();
		return (java.util.ArrayList<T>)r;
	}
	public static <T> java.util.Iterator<T> emptyIterator() {
		java.util.Iterator r = null;
		return (java.util.Iterator<T>)r;
	}
	public static <T> java.util.Collection<T> synchronizedCollection(java.util.Collection<T> p0) {
		java.util.Collection r = null;
		r = new java.util.Collections.SynchronizedCollection();
		((java.util.Collections.SynchronizedCollection)r).f24 = p0.iterator().next();
		return (java.util.Collection<T>)r;
	}
	public static <T> void copy(java.util.List<? super T> p0, java.util.List<? extends T> p1) {
	}
	public static <T> void fill(java.util.List<? super T> p0, T p1) {
	}
	public static <T> java.util.List<T> nCopies(int p0, T p1) {
		java.util.List r = null;
		return (java.util.List<T>)r;
	}
	public static void reverse(java.util.List<?> p0) {
	}
	public static <T> java.util.Comparator<T> reverseOrder() {
		java.util.Comparator r = null;
		return (java.util.Comparator<T>)r;
	}
	public static <T> java.util.Comparator<T> reverseOrder(java.util.Comparator<T> p0) {
		java.util.Comparator r = null;
		return (java.util.Comparator<T>)r;
	}
	public static <T> void sort(java.util.List<T> p0, java.util.Comparator<? super T> p1) {
	}
	public static <T> void sort(java.util.List<T> p0) {
	}
	public static <T> java.util.List<T> synchronizedList(java.util.List<T> p0) {
		java.util.List r = null;
		r = new java.util.Collections.SynchronizedList();
		r = new java.util.Collections.SynchronizedRandomAccessList();
		((java.util.Collections.SynchronizedRandomAccessList)r).f3 = p0.iterator().next();
		((java.util.Collections.SynchronizedList)r).f95 = p0.iterator().next();
		return (java.util.List<T>)r;
	}
	public static <T> int binarySearch(java.util.List<? extends T> p0, T p1, java.util.Comparator<? super T> p2) {
		int r = 0;
		return (int)r;
	}
	public static <T> int binarySearch(java.util.List<? extends java.lang.Comparable<? super T>> p0, T p1) {
		int r = 0;
		return (int)r;
	}
	public static void shuffle(java.util.List<?> p0) {
	}
	public static void shuffle(java.util.List<?> p0, java.util.Random p1) {
	}
	public static void swap(java.util.List<?> p0, int p1, int p2) {
	}
	public static void rotate(java.util.List<?> p0, int p1) {
	}
	public static int indexOfSubList(java.util.List<?> p0, java.util.List<?> p1) {
		int r = 0;
		return (int)r;
	}
	public static int lastIndexOfSubList(java.util.List<?> p0, java.util.List<?> p1) {
		int r = 0;
		return (int)r;
	}
	public static <T> java.util.Collection<T> unmodifiableCollection(java.util.Collection<? extends T> p0) {
		java.util.Collection r = null;
		r = new java.util.Collections.UnmodifiableCollection();
		((java.util.Collections.UnmodifiableCollection)r).f32 = p0.iterator().next();
		return (java.util.Collection<T>)r;
	}
	public static <T> java.util.Set<T> unmodifiableSet(java.util.Set<? extends T> p0) {
		java.util.Set r = null;
		r = new java.util.Collections.UnmodifiableSet();
		((java.util.Collections.UnmodifiableSet)r).f42 = p0.iterator().next();
		return (java.util.Set<T>)r;
	}
	public static <T> java.util.SortedSet<T> unmodifiableSortedSet(java.util.SortedSet<T> p0) {
		java.util.SortedSet r = null;
		r = new java.util.Collections.UnmodifiableSortedSet();
		((java.util.Collections.UnmodifiableSortedSet)r).f82 = p0.iterator().next();
		return (java.util.SortedSet<T>)r;
	}
	public static <T> java.util.NavigableSet<T> unmodifiableNavigableSet(java.util.NavigableSet<T> p0) {
		java.util.NavigableSet r = null;
		r = new java.util.Collections.UnmodifiableNavigableSet();
		((java.util.Collections.UnmodifiableNavigableSet)r).f8 = p0.iterator().next();
		return (java.util.NavigableSet<T>)r;
	}
	public static <K,V> java.util.Map<K, V> unmodifiableMap(java.util.Map<? extends K, ? extends V> p0) {
		java.util.Map r = null;
		r = new java.util.Collections.UnmodifiableMap();
		((java.util.Collections.UnmodifiableMap)r).f146 = p0.keySet().iterator().next();
		((java.util.Collections.UnmodifiableMap)r).f29 = p0.values().iterator().next();
		return (java.util.Map<K, V>)r;
	}
	public static <K,V> java.util.SortedMap<K, V> unmodifiableSortedMap(java.util.SortedMap<K, ? extends V> p0) {
		java.util.SortedMap r = null;
		r = new java.util.Collections.UnmodifiableSortedMap();
		((java.util.Collections.UnmodifiableSortedMap)r).f175 = p0.keySet().iterator().next();
		((java.util.Collections.UnmodifiableSortedMap)r).f27 = p0.values().iterator().next();
		return (java.util.SortedMap<K, V>)r;
	}
	public static <K,V> java.util.NavigableMap<K, V> unmodifiableNavigableMap(java.util.NavigableMap<K, ? extends V> p0) {
		java.util.NavigableMap r = null;
		r = new java.util.Collections.UnmodifiableNavigableMap();
		((java.util.Collections.UnmodifiableNavigableMap)r).f81 = p0.keySet().iterator().next();
		((java.util.Collections.UnmodifiableNavigableMap)r).f54 = p0.values().iterator().next();
		return (java.util.NavigableMap<K, V>)r;
	}
	public static <T> java.util.SortedSet<T> synchronizedSortedSet(java.util.SortedSet<T> p0) {
		java.util.SortedSet r = null;
		r = new java.util.Collections.SynchronizedSortedSet();
		((java.util.Collections.SynchronizedSortedSet)r).f66 = p0.iterator().next();
		return (java.util.SortedSet<T>)r;
	}
	public static <T> java.util.NavigableSet<T> synchronizedNavigableSet(java.util.NavigableSet<T> p0) {
		java.util.NavigableSet r = null;
		r = new java.util.Collections.SynchronizedNavigableSet();
		((java.util.Collections.SynchronizedNavigableSet)r).f65 = p0.iterator().next();
		return (java.util.NavigableSet<T>)r;
	}
	public static <K,V> java.util.Map<K, V> synchronizedMap(java.util.Map<K, V> p0) {
		java.util.Map r = null;
		r = new java.util.Collections.SynchronizedMap();
		((java.util.Collections.SynchronizedMap)r).f53 = p0.values().iterator().next();
		((java.util.Collections.SynchronizedMap)r).f134 = p0.keySet().iterator().next();
		return (java.util.Map<K, V>)r;
	}
	public static <K,V> java.util.SortedMap<K, V> synchronizedSortedMap(java.util.SortedMap<K, V> p0) {
		java.util.SortedMap r = null;
		r = new java.util.Collections.SynchronizedSortedMap();
		((java.util.Collections.SynchronizedSortedMap)r).f100 = p0.keySet().iterator().next();
		((java.util.Collections.SynchronizedSortedMap)r).f83 = p0.values().iterator().next();
		return (java.util.SortedMap<K, V>)r;
	}
	public static <K,V> java.util.NavigableMap<K, V> synchronizedNavigableMap(java.util.NavigableMap<K, V> p0) {
		java.util.NavigableMap r = null;
		r = new java.util.Collections.SynchronizedNavigableMap();
		((java.util.Collections.SynchronizedNavigableMap)r).f76 = p0.keySet().iterator().next();
		((java.util.Collections.SynchronizedNavigableMap)r).f72 = p0.values().iterator().next();
		return (java.util.NavigableMap<K, V>)r;
	}
	public static <E> java.util.Collection<E> checkedCollection(java.util.Collection<E> p0, java.lang.Class<E> p1) {
		java.util.Collection r = null;
		return (java.util.Collection<E>)r;
	}
	public static <E> java.util.Queue<E> checkedQueue(java.util.Queue<E> p0, java.lang.Class<E> p1) {
		java.util.Queue r = null;
		return (java.util.Queue<E>)r;
	}
	public static <E> java.util.Set<E> checkedSet(java.util.Set<E> p0, java.lang.Class<E> p1) {
		java.util.Set r = null;
		return (java.util.Set<E>)r;
	}
	public static <E> java.util.SortedSet<E> checkedSortedSet(java.util.SortedSet<E> p0, java.lang.Class<E> p1) {
		java.util.SortedSet r = null;
		return (java.util.SortedSet<E>)r;
	}
	public static <E> java.util.NavigableSet<E> checkedNavigableSet(java.util.NavigableSet<E> p0, java.lang.Class<E> p1) {
		java.util.NavigableSet r = null;
		return (java.util.NavigableSet<E>)r;
	}
	public static <E> java.util.List<E> checkedList(java.util.List<E> p0, java.lang.Class<E> p1) {
		java.util.List r = null;
		return (java.util.List<E>)r;
	}
	public static <K,V> java.util.Map<K, V> checkedMap(java.util.Map<K, V> p0, java.lang.Class<K> p1, java.lang.Class<V> p2) {
		java.util.Map r = null;
		return (java.util.Map<K, V>)r;
	}
	public static <K,V> java.util.SortedMap<K, V> checkedSortedMap(java.util.SortedMap<K, V> p0, java.lang.Class<K> p1, java.lang.Class<V> p2) {
		java.util.SortedMap r = null;
		return (java.util.SortedMap<K, V>)r;
	}
	public static <K,V> java.util.NavigableMap<K, V> checkedNavigableMap(java.util.NavigableMap<K, V> p0, java.lang.Class<K> p1, java.lang.Class<V> p2) {
		java.util.NavigableMap r = null;
		return (java.util.NavigableMap<K, V>)r;
	}
	public static <T> java.util.ListIterator<T> emptyListIterator() {
		java.util.ListIterator r = null;
		return (java.util.ListIterator<T>)r;
	}
	public static final <T> java.util.Set<T> emptySet() {
		java.util.Set r = null;
		return (java.util.Set<T>)r;
	}
	public static <E> java.util.SortedSet<E> emptySortedSet() {
		java.util.SortedSet r = null;
		return (java.util.SortedSet<E>)r;
	}
	public static <E> java.util.NavigableSet<E> emptyNavigableSet() {
		java.util.NavigableSet r = null;
		return (java.util.NavigableSet<E>)r;
	}
	public static final <T> java.util.List<T> emptyList() {
		java.util.List r = null;
		return (java.util.List<T>)r;
	}
	public static final <K,V> java.util.Map<K, V> emptyMap() {
		java.util.Map r = null;
		return (java.util.Map<K, V>)r;
	}
	public static final <K,V> java.util.SortedMap<K, V> emptySortedMap() {
		java.util.SortedMap r = null;
		return (java.util.SortedMap<K, V>)r;
	}
	public static final <K,V> java.util.NavigableMap<K, V> emptyNavigableMap() {
		java.util.NavigableMap r = null;
		return (java.util.NavigableMap<K, V>)r;
	}
	public static <T> java.util.Set<T> singleton(T p0) {
		java.util.Set r = null;
		r = new java.util.Collections.SingletonSet();
		((java.util.Collections.SingletonSet)r).f77 = (java.lang.Object)p0;
		return (java.util.Set<T>)r;
	}
	public static <T> java.util.List<T> singletonList(T p0) {
		java.util.List r = null;
		r = new java.util.Collections.SingletonList();
		((java.util.Collections.SingletonList)r).f139 = (java.lang.Object)p0;
		return (java.util.List<T>)r;
	}
	public static <K,V> java.util.Map<K, V> singletonMap(K p0, V p1) {
		java.util.Map r = null;
		r = new java.util.Collections.SingletonMap();
		((java.util.Collections.SingletonMap)r).f132 = (java.lang.Object)p0;
		((java.util.Collections.SingletonMap)r).f160 = (java.lang.Object)p1;
		return (java.util.Map<K, V>)r;
	}
	public static <T> java.util.Enumeration<T> enumeration(java.util.Collection<T> p0) {
		java.util.Enumeration r = null;
		r = new java.util.Collections.ANON3();
		((java.util.Collections.ANON3)r).f0 = p0.iterator().next();
		return (java.util.Enumeration<T>)r;
	}
	public static int frequency(java.util.Collection<?> p0, java.lang.Object p1) {
		int r = 0;
		return (int)r;
	}
	public static boolean disjoint(java.util.Collection<?> p0, java.util.Collection<?> p1) {
		boolean r = false;
		return (boolean)r;
	}
	public static <T> java.util.Queue<T> asLifoQueue(java.util.Deque<T> p0) {
		java.util.Queue r = null;
		r = new java.util.Collections.AsLIFOQueue();
		((java.util.Collections.AsLIFOQueue)r).f40 = p0.iterator().next();
		return (java.util.Queue<T>)r;
	}
	public static class AsLIFOQueue<E> extends java.util.AbstractQueue<E> implements java.util.Queue<E>, java.io.Serializable {
		public java.lang.Object f40;
		AsLIFOQueue(java.util.Deque<E> p0) {
		}
		public AsLIFOQueue() {
		}
		public boolean add(E p0) {
			boolean r = false;
			return (boolean)r;
		}
		public E remove() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Collections.AsLIFOQueue)this).f40;
			return (E)r;
		}
		public boolean remove(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public java.lang.String toString() {
			java.lang.String r = null;
			return (java.lang.String)r;
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
			r = new java.util.ArrayDeque().new DeqIterator();
			r = new java.util.concurrent.LinkedBlockingDeque().new Itr();
			r = new java.util.concurrent.ConcurrentLinkedDeque().new Itr();
			((java.util.ArrayDeque.DeqIterator)r).f101 = (java.lang.Object)((java.util.Collections.AsLIFOQueue)this).f40;
			((java.util.concurrent.ConcurrentLinkedDeque.Itr)r).f99 = (java.lang.Object)((java.util.Collections.AsLIFOQueue)this).f40;
			((java.util.concurrent.LinkedBlockingDeque.Itr)r).f103 = (java.lang.Object)((java.util.Collections.AsLIFOQueue)this).f40;
			return (java.util.Iterator<E>)r;
		}
		public E poll() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Collections.AsLIFOQueue)this).f40;
			return (E)r;
		}
		public E peek() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Collections.AsLIFOQueue)this).f40;
			return (E)r;
		}
		public boolean containsAll(java.util.Collection<?> p0) {
			boolean r = false;
			return (boolean)r;
		}
		public boolean removeAll(java.util.Collection<?> p0) {
			boolean r = false;
			return (boolean)r;
		}
		public boolean retainAll(java.util.Collection<?> p0) {
			boolean r = false;
			return (boolean)r;
		}
		public boolean offer(E p0) {
			boolean r = false;
			return (boolean)r;
		}
		public E element() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Collections.AsLIFOQueue)this).f40;
			return (E)r;
		}
	}
	public static class SetFromMap<E> extends java.util.AbstractSet<E> implements java.util.Set<E>, java.io.Serializable {
		SetFromMap(java.util.Map<E, java.lang.Boolean> p0) {
		}
		public SetFromMap() {
		}
		public boolean add(E p0) {
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
		public java.lang.String toString() {
			java.lang.String r = null;
			return (java.lang.String)r;
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
			return (java.util.Iterator<E>)r;
		}
		public boolean containsAll(java.util.Collection<?> p0) {
			boolean r = false;
			return (boolean)r;
		}
		public boolean removeAll(java.util.Collection<?> p0) {
			boolean r = false;
			return (boolean)r;
		}
		public boolean retainAll(java.util.Collection<?> p0) {
			boolean r = false;
			return (boolean)r;
		}
	}
	public static class ReverseComparator2<T> implements java.util.Comparator<T>, java.io.Serializable {
		ReverseComparator2(java.util.Comparator<T> p0) {
		}
		public ReverseComparator2() {
		}
		public boolean equals(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public int hashCode() {
			int r = 0;
			return (int)r;
		}
		public int compare(T p0, T p1) {
			int r = 0;
			return (int)r;
		}
		public java.util.Comparator<T> reversed() {
			java.util.Comparator r = null;
			return (java.util.Comparator<T>)r;
		}
	}
	public static class ReverseComparator implements java.util.Comparator<java.lang.Comparable<java.lang.Object>>, java.io.Serializable {
		public ReverseComparator() {
		}
		public int compare(java.lang.Comparable<java.lang.Object> p0, java.lang.Comparable<java.lang.Object> p1) {
			int r = 0;
			return (int)r;
		}
		public java.util.Comparator<java.lang.Comparable<java.lang.Object>> reversed() {
			java.util.Comparator r = null;
			return (java.util.Comparator<java.lang.Comparable<java.lang.Object>>)r;
		}
	}
	public static class CopiesList<E> extends java.util.AbstractList<E> implements java.util.RandomAccess, java.io.Serializable {
		public CopiesList() {
		}
		public E get(int p0) {
			java.lang.Object r = null;
			return (E)r;
		}
		public int indexOf(java.lang.Object p0) {
			int r = 0;
			return (int)r;
		}
		public int lastIndexOf(java.lang.Object p0) {
			int r = 0;
			return (int)r;
		}
		public boolean contains(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public int size() {
			int r = 0;
			return (int)r;
		}
		public java.util.List<E> subList(int p0, int p1) {
			java.util.List r = null;
			return (java.util.List<E>)r;
		}
		public <T> T[] toArray(T[] p0) {
			java.lang.Object[] r = null;
			return (T[])r;
		}
		public java.lang.Object[] toArray() {
			java.lang.Object[] r = null;
			return (java.lang.Object[])r;
		}
	}
	public static class SingletonMap<K,V> extends java.util.AbstractMap<K, V> implements java.io.Serializable {
		public java.lang.Object f160;
		public java.lang.Object f132;
		SingletonMap(K p0, V p1) {
		}
		public SingletonMap() {
		}
		public boolean remove(java.lang.Object p0, java.lang.Object p1) {
			boolean r = false;
			return (boolean)r;
		}
		public V get(java.lang.Object p0) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Collections.SingletonMap)this).f160;
			return (V)r;
		}
		public java.util.Collection<V> values() {
			java.util.Collection r = null;
			r = new java.util.Collections.SingletonSet();
			((java.util.Collections.SingletonSet)r).f77 = (java.lang.Object)((java.util.Collections.SingletonMap)this).f160;
			return (java.util.Collection<V>)r;
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
			return (V)r;
		}
		public int size() {
			int r = 0;
			return (int)r;
		}
		public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
			java.util.Set r = null;
			r = new java.util.Collections.SingletonSet();
			((java.util.Collections.SingletonSet)r).f135 = (java.lang.Object)((java.util.Collections.SingletonMap)this).f160;
			((java.util.Collections.SingletonSet)r).f135 = (java.lang.Object)((java.util.Collections.SingletonMap)this).f132;
			return (java.util.Set<java.util.Map.Entry<K, V>>)r;
		}
		public V putIfAbsent(K p0, V p1) {
			java.lang.Object r = null;
			return (V)r;
		}
		public java.util.Set<K> keySet() {
			java.util.Set r = null;
			r = new java.util.Collections.SingletonSet();
			((java.util.Collections.SingletonSet)r).f77 = (java.lang.Object)((java.util.Collections.SingletonMap)this).f132;
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
			r = (java.lang.Object)((java.util.Collections.SingletonMap)this).f160;
			return (V)r;
		}
	}
	public static class SingletonList<E> extends java.util.AbstractList<E> implements java.util.RandomAccess, java.io.Serializable {
		public java.lang.Object f139;
		SingletonList(E p0) {
		}
		public SingletonList() {
		}
		public E get(int p0) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Collections.SingletonList)this).f139;
			return (E)r;
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
			r = new ANON290();
			((ANON290)r).f156 = (java.lang.Object)((java.util.Collections.SingletonList)this).f139;
			return (java.util.Iterator<E>)r;
		}
		public void sort(java.util.Comparator<? super E> p0) {
		}
		public java.util.ListIterator<E> listIterator(int p0) {
			java.util.ListIterator r = null;
			r = new java.util.AtlasAbstractList.ListItr();
			((java.util.AtlasAbstractList.ListItr)r).f90 = (java.lang.Object)((java.util.Collections.SingletonList)this).f139;
			return (java.util.ListIterator<E>)r;
		}
		public java.util.ListIterator<E> listIterator() {
			java.util.ListIterator r = null;
			r = new java.util.AtlasAbstractList.ListItr();
			r = new java.util.LinkedList().new ListItr();
			((java.util.AtlasAbstractList.ListItr)r).f90 = (java.lang.Object)((java.util.Collections.SingletonList)this).f139;
			return (java.util.ListIterator<E>)r;
		}
	}
	public static class SingletonSet<E> extends java.util.AbstractSet<E> implements java.io.Serializable {
		public java.lang.Object f135;
		public java.lang.Object f77;
		SingletonSet(E p0) {
		}
		public SingletonSet() {
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
			r = new ANON290();
			((ANON290)r).f156 = (java.lang.Object)((java.util.Collections.SingletonSet)this).f135;
			((ANON290)r).f156 = (java.lang.Object)((java.util.Collections.SingletonSet)this).f77;
			return (java.util.Iterator<E>)r;
		}
	}
	public static class EmptyMap<K,V> extends java.util.AbstractMap<K, V> implements java.io.Serializable {
		public EmptyMap() {
		}
		public boolean remove(java.lang.Object p0, java.lang.Object p1) {
			boolean r = false;
			return (boolean)r;
		}
		public V get(java.lang.Object p0) {
			java.lang.Object r = null;
			return (V)r;
		}
		public boolean equals(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public java.util.Collection<V> values() {
			java.util.Collection r = null;
			return (java.util.Collection<V>)r;
		}
		public int hashCode() {
			int r = 0;
			return (int)r;
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
			return (V)r;
		}
		public java.util.Set<K> keySet() {
			java.util.Set r = null;
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
			return (V)r;
		}
	}
	public static class EmptyList<E> extends java.util.AbstractList<E> implements java.util.RandomAccess, java.io.Serializable {
		public EmptyList() {
		}
		public E get(int p0) {
			java.lang.Object r = null;
			return (E)r;
		}
		public boolean equals(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public int hashCode() {
			int r = 0;
			return (int)r;
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
			return (java.util.Iterator<E>)r;
		}
		public boolean containsAll(java.util.Collection<?> p0) {
			boolean r = false;
			return (boolean)r;
		}
		public java.util.ListIterator<E> listIterator() {
			java.util.ListIterator r = null;
			return (java.util.ListIterator<E>)r;
		}
		public void sort(java.util.Comparator<? super E> p0) {
		}
	}
	public static class EmptySet<E> extends java.util.AbstractSet<E> implements java.io.Serializable {
		public EmptySet() {
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
			return (java.util.Iterator<E>)r;
		}
		public boolean containsAll(java.util.Collection<?> p0) {
			boolean r = false;
			return (boolean)r;
		}
	}
	public static class EmptyEnumeration<E> implements java.util.Enumeration<E> {
		public EmptyEnumeration() {
		}
		public boolean hasMoreElements() {
			boolean r = false;
			return (boolean)r;
		}
		public E nextElement() {
			java.lang.Object r = null;
			return (E)r;
		}
	}
	public static class EmptyListIterator<E> extends java.util.Collections.EmptyIterator<E> implements java.util.ListIterator<E> {
		public EmptyListIterator() {
		}
		public void add(E p0) {
		}
		public void set(E p0) {
		}
		public int previousIndex() {
			int r = 0;
			return (int)r;
		}
		public boolean hasPrevious() {
			boolean r = false;
			return (boolean)r;
		}
		public E previous() {
			java.lang.Object r = null;
			return (E)r;
		}
		public int nextIndex() {
			int r = 0;
			return (int)r;
		}
	}
	public static class EmptyIterator<E> implements java.util.Iterator<E> {
		public EmptyIterator() {
		}
		public void remove() {
		}
		public boolean hasNext() {
			boolean r = false;
			return (boolean)r;
		}
		public E next() {
			java.lang.Object r = null;
			return (E)r;
		}
	}
	public static class CheckedNavigableMap<K,V> extends java.util.Collections.CheckedSortedMap<K, V> implements java.util.NavigableMap<K, V>, java.io.Serializable {
		CheckedNavigableMap(java.util.NavigableMap<K, V> p0, java.lang.Class<K> p1, java.lang.Class<V> p2) {
		}
		public CheckedNavigableMap() {
		}
		public java.util.NavigableSet<K> keySet() {
			java.util.NavigableSet r = null;
			return (java.util.NavigableSet<K>)r;
		}
		public java.util.Comparator<? super K> comparator() {
			java.util.Comparator r = null;
			return (java.util.Comparator<? super K>)r;
		}
		public java.util.NavigableSet<K> navigableKeySet() {
			java.util.NavigableSet r = null;
			return (java.util.NavigableSet<K>)r;
		}
		public java.util.NavigableMap<K, V> descendingMap() {
			java.util.NavigableMap r = null;
			return (java.util.NavigableMap<K, V>)r;
		}
		public K firstKey() {
			java.lang.Object r = null;
			return (K)r;
		}
		public K lastKey() {
			java.lang.Object r = null;
			return (K)r;
		}
		public java.util.Map.Entry<K, V> firstEntry() {
			java.util.Map.Entry r = null;
			return (java.util.Map.Entry<K, V>)r;
		}
		public java.util.Map.Entry<K, V> lastEntry() {
			java.util.Map.Entry r = null;
			return (java.util.Map.Entry<K, V>)r;
		}
		public java.util.Map.Entry<K, V> pollFirstEntry() {
			java.util.Map.Entry r = null;
			return (java.util.Map.Entry<K, V>)r;
		}
		public java.util.Map.Entry<K, V> pollLastEntry() {
			java.util.Map.Entry r = null;
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
			return (java.util.Map.Entry<K, V>)r;
		}
		public K floorKey(K p0) {
			java.lang.Object r = null;
			return (K)r;
		}
		public java.util.Map.Entry<K, V> ceilingEntry(K p0) {
			java.util.Map.Entry r = null;
			return (java.util.Map.Entry<K, V>)r;
		}
		public K ceilingKey(K p0) {
			java.lang.Object r = null;
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
			return (java.util.NavigableSet<K>)r;
		}
		public java.util.NavigableMap<K, V> subMap(K p0, K p1) {
			java.util.NavigableMap r = null;
			return (java.util.NavigableMap<K, V>)r;
		}
		public java.util.NavigableMap<K, V> subMap(K p0, boolean p1, K p2, boolean p3) {
			java.util.NavigableMap r = null;
			return (java.util.NavigableMap<K, V>)r;
		}
		public java.util.NavigableMap<K, V> headMap(K p0) {
			java.util.NavigableMap r = null;
			return (java.util.NavigableMap<K, V>)r;
		}
		public java.util.NavigableMap<K, V> headMap(K p0, boolean p1) {
			java.util.NavigableMap r = null;
			return (java.util.NavigableMap<K, V>)r;
		}
		public java.util.NavigableMap<K, V> tailMap(K p0, boolean p1) {
			java.util.NavigableMap r = null;
			return (java.util.NavigableMap<K, V>)r;
		}
		public java.util.NavigableMap<K, V> tailMap(K p0) {
			java.util.NavigableMap r = null;
			return (java.util.NavigableMap<K, V>)r;
		}
	}
	public static class CheckedSortedMap<K,V> extends java.util.Collections.CheckedMap<K, V> implements java.util.SortedMap<K, V>, java.io.Serializable {
		CheckedSortedMap(java.util.SortedMap<K, V> p0, java.lang.Class<K> p1, java.lang.Class<V> p2) {
		}
		public CheckedSortedMap() {
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
	public static class CheckedMap<K,V> implements java.util.Map<K, V>, java.io.Serializable {
		CheckedMap(java.util.Map<K, V> p0, java.lang.Class<K> p1, java.lang.Class<V> p2) {
		}
		public CheckedMap() {
		}
		public V remove(java.lang.Object p0) {
			java.lang.Object r = null;
			return (V)r;
		}
		public boolean remove(java.lang.Object p0, java.lang.Object p1) {
			boolean r = false;
			return (boolean)r;
		}
		public V get(java.lang.Object p0) {
			java.lang.Object r = null;
			return (V)r;
		}
		public V put(K p0, V p1) {
			java.lang.Object r = null;
			return (V)r;
		}
		public boolean equals(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public java.lang.String toString() {
			java.lang.String r = null;
			return (java.lang.String)r;
		}
		public java.util.Collection<V> values() {
			java.util.Collection r = null;
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
		public V replace(K p0, V p1) {
			java.lang.Object r = null;
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
			return (java.util.Set<java.util.Map.Entry<K, V>>)r;
		}
		public void putAll(java.util.Map<? extends K, ? extends V> p0) {
		}
		public V putIfAbsent(K p0, V p1) {
			java.lang.Object r = null;
			return (V)r;
		}
		public java.util.Set<K> keySet() {
			java.util.Set r = null;
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
		public static class CheckedEntrySet<K,V> implements java.util.Set<java.util.Map.Entry<K, V>> {
			CheckedEntrySet(java.util.Set<java.util.Map.Entry<K, V>> p0, java.lang.Class<V> p1) {
			}
			public CheckedEntrySet() {
			}
			public boolean add(java.util.Map.Entry<K, V> p0) {
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
			public java.lang.String toString() {
				java.lang.String r = null;
				return (java.lang.String)r;
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
				return (java.util.Iterator<java.util.Map.Entry<K, V>>)r;
			}
			public boolean addAll(java.util.Collection<? extends java.util.Map.Entry<K, V>> p0) {
				boolean r = false;
				return (boolean)r;
			}
			public boolean containsAll(java.util.Collection<?> p0) {
				boolean r = false;
				return (boolean)r;
			}
			public boolean removeAll(java.util.Collection<?> p0) {
				boolean r = false;
				return (boolean)r;
			}
			public boolean retainAll(java.util.Collection<?> p0) {
				boolean r = false;
				return (boolean)r;
			}
			public static class CheckedEntry<K,V,T> implements java.util.Map.Entry<K, V> {
				CheckedEntry(java.util.Map.Entry<K, V> p0, java.lang.Class<T> p1) {
				}
				public CheckedEntry() {
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
			public class ANON127 implements java.util.Iterator<java.util.Map.Entry<K, V>> {
				ANON127() {
				}
				public void remove() {
				}
				public boolean hasNext() {
					boolean r = false;
					return (boolean)r;
				}
				public java.util.Map.Entry<K, V> next() {
					java.util.Map.Entry r = null;
					return (java.util.Map.Entry<K, V>)r;
				}
			}
		}
	}
	public static class CheckedRandomAccessList<E> extends java.util.Collections.CheckedList<E> implements java.util.RandomAccess {
		CheckedRandomAccessList(java.util.List<E> p0, java.lang.Class<E> p1) {
		}
		public CheckedRandomAccessList() {
		}
		public java.util.List<E> subList(int p0, int p1) {
			java.util.List r = null;
			return (java.util.List<E>)r;
		}
	}
	public static class CheckedList<E> extends java.util.Collections.CheckedCollection<E> implements java.util.List<E> {
		CheckedList(java.util.List<E> p0, java.lang.Class<E> p1) {
		}
		public CheckedList() {
		}
		public void add(int p0, E p1) {
		}
		public E remove(int p0) {
			java.lang.Object r = null;
			return (E)r;
		}
		public E get(int p0) {
			java.lang.Object r = null;
			return (E)r;
		}
		public boolean equals(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public int hashCode() {
			int r = 0;
			return (int)r;
		}
		public int indexOf(java.lang.Object p0) {
			int r = 0;
			return (int)r;
		}
		public int lastIndexOf(java.lang.Object p0) {
			int r = 0;
			return (int)r;
		}
		public java.util.List<E> subList(int p0, int p1) {
			java.util.List r = null;
			return (java.util.List<E>)r;
		}
		public boolean addAll(int p0, java.util.Collection<? extends E> p1) {
			boolean r = false;
			return (boolean)r;
		}
		public E set(int p0, E p1) {
			java.lang.Object r = null;
			return (E)r;
		}
		public java.util.ListIterator<E> listIterator() {
			java.util.ListIterator r = null;
			return (java.util.ListIterator<E>)r;
		}
		public java.util.ListIterator<E> listIterator(int p0) {
			java.util.ListIterator r = null;
			return (java.util.ListIterator<E>)r;
		}
		public void sort(java.util.Comparator<? super E> p0) {
		}
		public class ANON110<E> implements java.util.ListIterator<E> {
			ANON110() {
			}
			public void add(E p0) {
			}
			public void remove() {
			}
			public boolean hasNext() {
				boolean r = false;
				return (boolean)r;
			}
			public E next() {
				java.lang.Object r = null;
				return (E)r;
			}
			public void set(E p0) {
			}
			public int previousIndex() {
				int r = 0;
				return (int)r;
			}
			public boolean hasPrevious() {
				boolean r = false;
				return (boolean)r;
			}
			public E previous() {
				java.lang.Object r = null;
				return (E)r;
			}
			public int nextIndex() {
				int r = 0;
				return (int)r;
			}
		}
	}
	public static class CheckedNavigableSet<E> extends java.util.Collections.CheckedSortedSet<E> implements java.util.NavigableSet<E>, java.io.Serializable {
		CheckedNavigableSet(java.util.NavigableSet<E> p0, java.lang.Class<E> p1) {
		}
		public CheckedNavigableSet() {
		}
		public E floor(E p0) {
			java.lang.Object r = null;
			return (E)r;
		}
		public java.util.NavigableSet<E> subSet(E p0, boolean p1, E p2, boolean p3) {
			java.util.NavigableSet r = null;
			return (java.util.NavigableSet<E>)r;
		}
		public java.util.NavigableSet<E> subSet(E p0, E p1) {
			java.util.NavigableSet r = null;
			return (java.util.NavigableSet<E>)r;
		}
		public java.util.NavigableSet<E> headSet(E p0, boolean p1) {
			java.util.NavigableSet r = null;
			return (java.util.NavigableSet<E>)r;
		}
		public java.util.NavigableSet<E> headSet(E p0) {
			java.util.NavigableSet r = null;
			return (java.util.NavigableSet<E>)r;
		}
		public java.util.NavigableSet<E> tailSet(E p0, boolean p1) {
			java.util.NavigableSet r = null;
			return (java.util.NavigableSet<E>)r;
		}
		public java.util.NavigableSet<E> tailSet(E p0) {
			java.util.NavigableSet r = null;
			return (java.util.NavigableSet<E>)r;
		}
		public E pollFirst() {
			java.lang.Object r = null;
			return (E)r;
		}
		public E pollLast() {
			java.lang.Object r = null;
			return (E)r;
		}
		public java.util.Iterator<E> descendingIterator() {
			java.util.Iterator r = null;
			return (java.util.Iterator<E>)r;
		}
		public E ceiling(E p0) {
			java.lang.Object r = null;
			return (E)r;
		}
		public E higher(E p0) {
			java.lang.Object r = null;
			return (E)r;
		}
		public java.util.NavigableSet<E> descendingSet() {
			java.util.NavigableSet r = null;
			return (java.util.NavigableSet<E>)r;
		}
		public E lower(E p0) {
			java.lang.Object r = null;
			return (E)r;
		}
	}
	public static class CheckedSortedSet<E> extends java.util.Collections.CheckedSet<E> implements java.util.SortedSet<E>, java.io.Serializable {
		CheckedSortedSet(java.util.SortedSet<E> p0, java.lang.Class<E> p1) {
		}
		public CheckedSortedSet() {
		}
		public E first() {
			java.lang.Object r = null;
			return (E)r;
		}
		public java.util.SortedSet<E> subSet(E p0, E p1) {
			java.util.SortedSet r = null;
			return (java.util.SortedSet<E>)r;
		}
		public java.util.SortedSet<E> headSet(E p0) {
			java.util.SortedSet r = null;
			return (java.util.SortedSet<E>)r;
		}
		public java.util.SortedSet<E> tailSet(E p0) {
			java.util.SortedSet r = null;
			return (java.util.SortedSet<E>)r;
		}
		public java.util.Comparator<? super E> comparator() {
			java.util.Comparator r = null;
			return (java.util.Comparator<? super E>)r;
		}
		public E last() {
			java.lang.Object r = null;
			return (E)r;
		}
	}
	public static class CheckedSet<E> extends java.util.Collections.CheckedCollection<E> implements java.util.Set<E>, java.io.Serializable {
		CheckedSet(java.util.Set<E> p0, java.lang.Class<E> p1) {
		}
		public CheckedSet() {
		}
		public boolean equals(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public int hashCode() {
			int r = 0;
			return (int)r;
		}
	}
	public static class CheckedQueue<E> extends java.util.Collections.CheckedCollection<E> implements java.util.Queue<E>, java.io.Serializable {
		CheckedQueue(java.util.Queue<E> p0, java.lang.Class<E> p1) {
		}
		public CheckedQueue() {
		}
		public E remove() {
			java.lang.Object r = null;
			return (E)r;
		}
		public boolean equals(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public int hashCode() {
			int r = 0;
			return (int)r;
		}
		public E poll() {
			java.lang.Object r = null;
			return (E)r;
		}
		public E peek() {
			java.lang.Object r = null;
			return (E)r;
		}
		public boolean offer(E p0) {
			boolean r = false;
			return (boolean)r;
		}
		public E element() {
			java.lang.Object r = null;
			return (E)r;
		}
	}
	public static class CheckedCollection<E> implements java.util.Collection<E>, java.io.Serializable {
		CheckedCollection(java.util.Collection<E> p0, java.lang.Class<E> p1) {
		}
		public CheckedCollection() {
		}
		public boolean add(E p0) {
			boolean r = false;
			return (boolean)r;
		}
		public boolean remove(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public java.lang.String toString() {
			java.lang.String r = null;
			return (java.lang.String)r;
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
			return (java.util.Iterator<E>)r;
		}
		public boolean addAll(java.util.Collection<? extends E> p0) {
			boolean r = false;
			return (boolean)r;
		}
		public boolean containsAll(java.util.Collection<?> p0) {
			boolean r = false;
			return (boolean)r;
		}
		public boolean removeAll(java.util.Collection<?> p0) {
			boolean r = false;
			return (boolean)r;
		}
		public boolean retainAll(java.util.Collection<?> p0) {
			boolean r = false;
			return (boolean)r;
		}
		public class ANON186<E> implements java.util.Iterator<E> {
			ANON186() {
			}
			public void remove() {
			}
			public boolean hasNext() {
				boolean r = false;
				return (boolean)r;
			}
			public E next() {
				java.lang.Object r = null;
				return (E)r;
			}
		}
	}
	public static class SynchronizedNavigableMap<K,V> extends java.util.Collections.SynchronizedSortedMap<K, V> implements java.util.NavigableMap<K, V> {
		public java.lang.Object f72;
		public java.lang.Object f76;
		SynchronizedNavigableMap(java.util.NavigableMap<K, V> p0) {
		}
		SynchronizedNavigableMap(java.util.NavigableMap<K, V> p0, java.lang.Object p1) {
		}
		public SynchronizedNavigableMap() {
		}
		public java.util.NavigableSet<K> keySet() {
			java.util.NavigableSet r = null;
			r = new java.util.Collections.SynchronizedNavigableSet();
			((java.util.Collections.SynchronizedNavigableSet)r).f65 = (java.lang.Object)((java.util.Collections.SynchronizedNavigableMap)this).f76;
			return (java.util.NavigableSet<K>)r;
		}
		public java.util.NavigableSet<K> navigableKeySet() {
			java.util.NavigableSet r = null;
			return (java.util.NavigableSet<K>)r;
		}
		public java.util.NavigableMap<K, V> descendingMap() {
			java.util.NavigableMap r = null;
			return (java.util.NavigableMap<K, V>)r;
		}
		public java.util.Map.Entry<K, V> firstEntry() {
			java.util.Map.Entry r = null;
			r = new java.util.AtlasAbstractMap.SimpleImmutableEntry();
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f137 = (java.lang.Object)((java.util.Collections.SynchronizedNavigableMap)this).f76;
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f12 = (java.lang.Object)((java.util.Collections.SynchronizedNavigableMap)this).f72;
			return (java.util.Map.Entry<K, V>)r;
		}
		public java.util.Map.Entry<K, V> lastEntry() {
			java.util.Map.Entry r = null;
			r = new java.util.AtlasAbstractMap.SimpleImmutableEntry();
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f12 = (java.lang.Object)((java.util.Collections.SynchronizedNavigableMap)this).f72;
			return (java.util.Map.Entry<K, V>)r;
		}
		public java.util.Map.Entry<K, V> pollFirstEntry() {
			java.util.Map.Entry r = null;
			return (java.util.Map.Entry<K, V>)r;
		}
		public java.util.Map.Entry<K, V> pollLastEntry() {
			java.util.Map.Entry r = null;
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
			return (java.util.Map.Entry<K, V>)r;
		}
		public K floorKey(K p0) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Collections.SynchronizedNavigableMap)this).f76;
			return (K)r;
		}
		public java.util.Map.Entry<K, V> ceilingEntry(K p0) {
			java.util.Map.Entry r = null;
			return (java.util.Map.Entry<K, V>)r;
		}
		public K ceilingKey(K p0) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Collections.SynchronizedNavigableMap)this).f76;
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
			return (java.util.NavigableSet<K>)r;
		}
		public java.util.SortedMap<K, V> subMap(K p0, K p1) {
			java.util.SortedMap r = null;
			return (java.util.SortedMap<K, V>)r;
		}
		public java.util.NavigableMap<K, V> subMap(K p0, boolean p1, K p2, boolean p3) {
			java.util.NavigableMap r = null;
			return (java.util.NavigableMap<K, V>)r;
		}
		public java.util.SortedMap<K, V> headMap(K p0) {
			java.util.SortedMap r = null;
			return (java.util.SortedMap<K, V>)r;
		}
		public java.util.NavigableMap<K, V> headMap(K p0, boolean p1) {
			java.util.NavigableMap r = null;
			r = new java.util.Collections.SynchronizedNavigableMap();
			((java.util.Collections.SynchronizedNavigableMap)r).f72 = (java.lang.Object)((java.util.Collections.SynchronizedNavigableMap)this).f72;
			return (java.util.NavigableMap<K, V>)r;
		}
		public java.util.SortedMap<K, V> tailMap(K p0) {
			java.util.SortedMap r = null;
			return (java.util.SortedMap<K, V>)r;
		}
		public java.util.NavigableMap<K, V> tailMap(K p0, boolean p1) {
			java.util.NavigableMap r = null;
			return (java.util.NavigableMap<K, V>)r;
		}
	}
	public static class SynchronizedSortedMap<K,V> extends java.util.Collections.SynchronizedMap<K, V> implements java.util.SortedMap<K, V> {
		public java.lang.Object f83;
		public java.lang.Object f100;
		SynchronizedSortedMap(java.util.SortedMap<K, V> p0) {
		}
		SynchronizedSortedMap(java.util.SortedMap<K, V> p0, java.lang.Object p1) {
		}
		public SynchronizedSortedMap() {
		}
		public java.util.Comparator<? super K> comparator() {
			java.util.Comparator r = null;
			return (java.util.Comparator<? super K>)r;
		}
		public K firstKey() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Collections.SynchronizedSortedMap)this).f100;
			r = (java.lang.Object)((java.util.Collections.SynchronizedNavigableMap)this).f76;
			return (K)r;
		}
		public K lastKey() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Collections.SynchronizedSortedMap)this).f100;
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
	public static class SynchronizedMap<K,V> implements java.util.Map<K, V>, java.io.Serializable {
		public java.lang.Object f53;
		public java.lang.Object f134;
		SynchronizedMap(java.util.Map<K, V> p0) {
		}
		SynchronizedMap(java.util.Map<K, V> p0, java.lang.Object p1) {
		}
		public SynchronizedMap() {
		}
		public V remove(java.lang.Object p0) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Collections.SynchronizedMap)this).f53;
			r = (java.lang.Object)((java.util.Collections.SynchronizedSortedMap)this).f83;
			return (V)r;
		}
		public boolean remove(java.lang.Object p0, java.lang.Object p1) {
			boolean r = false;
			return (boolean)r;
		}
		public V get(java.lang.Object p0) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Collections.SynchronizedMap)this).f53;
			r = (java.lang.Object)((java.util.Collections.SynchronizedSortedMap)this).f83;
			return (V)r;
		}
		public V put(K p0, V p1) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Collections.SynchronizedMap)this).f53;
			r = (java.lang.Object)((java.util.Collections.SynchronizedSortedMap)this).f83;
			return (V)r;
		}
		public boolean equals(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public java.lang.String toString() {
			java.lang.String r = null;
			return (java.lang.String)r;
		}
		public java.util.Collection<V> values() {
			java.util.Collection r = null;
			r = new java.util.Collections.SynchronizedCollection();
			((java.util.Collections.SynchronizedCollection)r).f24 = (java.lang.Object)((java.util.Collections.SynchronizedMap)this).f53;
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
			r = (java.lang.Object)((java.util.Collections.SynchronizedMap)this).f53;
			r = (java.lang.Object)((java.util.Collections.SynchronizedSortedMap)this).f83;
			r = (java.lang.Object)((java.util.Collections.SynchronizedNavigableMap)this).f72;
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
		public void putAll(java.util.Map<? extends K, ? extends V> p0) {
		}
		public V putIfAbsent(K p0, V p1) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Collections.SynchronizedMap)this).f53;
			r = (java.lang.Object)((java.util.Collections.SynchronizedNavigableMap)this).f72;
			return (V)r;
		}
		public java.util.Set<K> keySet() {
			java.util.Set r = null;
			r = new java.util.Collections.SynchronizedSet();
			((java.util.Collections.SynchronizedSet)r).f78 = (java.lang.Object)((java.util.Collections.SynchronizedMap)this).f134;
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
			r = (java.lang.Object)((java.util.Collections.SynchronizedMap)this).f53;
			r = (java.lang.Object)((java.util.Collections.SynchronizedSortedMap)this).f83;
			return (V)r;
		}
	}
	public static class SynchronizedRandomAccessList<E> extends java.util.Collections.SynchronizedList<E> implements java.util.RandomAccess {
		public java.lang.Object f3;
		SynchronizedRandomAccessList(java.util.List<E> p0) {
		}
		SynchronizedRandomAccessList(java.util.List<E> p0, java.lang.Object p1) {
		}
		public SynchronizedRandomAccessList() {
		}
		public java.util.List<E> subList(int p0, int p1) {
			java.util.List r = null;
			return (java.util.List<E>)r;
		}
	}
	public static class SynchronizedList<E> extends java.util.Collections.SynchronizedCollection<E> implements java.util.List<E> {
		public java.lang.Object f95;
		SynchronizedList(java.util.List<E> p0) {
		}
		SynchronizedList(java.util.List<E> p0, java.lang.Object p1) {
		}
		public SynchronizedList() {
		}
		public void add(int p0, E p1) {
		}
		public E remove(int p0) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Collections.SynchronizedRandomAccessList)this).f3;
			r = (java.lang.Object)((java.util.Collections.SynchronizedList)this).f95;
			return (E)r;
		}
		public E get(int p0) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Collections.SynchronizedRandomAccessList)this).f3;
			r = (java.lang.Object)((java.util.Collections.SynchronizedList)this).f95;
			return (E)r;
		}
		public boolean equals(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public int hashCode() {
			int r = 0;
			return (int)r;
		}
		public int indexOf(java.lang.Object p0) {
			int r = 0;
			return (int)r;
		}
		public int lastIndexOf(java.lang.Object p0) {
			int r = 0;
			return (int)r;
		}
		public java.util.List<E> subList(int p0, int p1) {
			java.util.List r = null;
			return (java.util.List<E>)r;
		}
		public boolean addAll(int p0, java.util.Collection<? extends E> p1) {
			boolean r = false;
			return (boolean)r;
		}
		public E set(int p0, E p1) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Collections.SynchronizedRandomAccessList)this).f3;
			r = (java.lang.Object)((java.util.Collections.SynchronizedList)this).f95;
			return (E)r;
		}
		public java.util.ListIterator<E> listIterator(int p0) {
			java.util.ListIterator r = null;
			r = new java.util.Vector().new ListItr();
			((java.util.Vector.ListItr)r).f98 = (java.lang.Object)((java.util.Collections.SynchronizedRandomAccessList)this).f3;
			return (java.util.ListIterator<E>)r;
		}
		public java.util.ListIterator<E> listIterator() {
			java.util.ListIterator r = null;
			r = new java.util.LinkedList().new ListItr();
			r = new java.util.ArrayList().new ListItr();
			((java.util.LinkedList.ListItr)r).f48 = (java.lang.Object)((java.util.Collections.SynchronizedList)this).f95;
			((java.util.ArrayList.ListItr)r).f148 = (java.lang.Object)((java.util.Collections.SynchronizedRandomAccessList)this).f3;
			return (java.util.ListIterator<E>)r;
		}
		public void sort(java.util.Comparator<? super E> p0) {
		}
	}
	public static class SynchronizedNavigableSet<E> extends java.util.Collections.SynchronizedSortedSet<E> implements java.util.NavigableSet<E> {
		public java.lang.Object f65;
		SynchronizedNavigableSet(java.util.NavigableSet<E> p0) {
		}
		SynchronizedNavigableSet(java.util.NavigableSet<E> p0, java.lang.Object p1) {
		}
		public SynchronizedNavigableSet() {
		}
		public E floor(E p0) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Collections.SynchronizedNavigableSet)this).f65;
			return (E)r;
		}
		public java.util.NavigableSet<E> subSet(E p0, boolean p1, E p2, boolean p3) {
			java.util.NavigableSet r = null;
			return (java.util.NavigableSet<E>)r;
		}
		public java.util.NavigableSet<E> subSet(E p0, E p1) {
			java.util.NavigableSet r = null;
			return (java.util.NavigableSet<E>)r;
		}
		public java.util.NavigableSet<E> headSet(E p0, boolean p1) {
			java.util.NavigableSet r = null;
			r = new java.util.Collections.SynchronizedNavigableSet();
			((java.util.Collections.SynchronizedNavigableSet)r).f65 = (java.lang.Object)((java.util.Collections.SynchronizedNavigableSet)this).f65;
			return (java.util.NavigableSet<E>)r;
		}
		public java.util.NavigableSet<E> headSet(E p0) {
			java.util.NavigableSet r = null;
			return (java.util.NavigableSet<E>)r;
		}
		public java.util.NavigableSet<E> tailSet(E p0, boolean p1) {
			java.util.NavigableSet r = null;
			return (java.util.NavigableSet<E>)r;
		}
		public java.util.NavigableSet<E> tailSet(E p0) {
			java.util.NavigableSet r = null;
			r = new java.util.Collections.SynchronizedNavigableSet();
			((java.util.Collections.SynchronizedNavigableSet)r).f65 = (java.lang.Object)((java.util.Collections.SynchronizedNavigableSet)this).f65;
			return (java.util.NavigableSet<E>)r;
		}
		public E pollFirst() {
			java.lang.Object r = null;
			return (E)r;
		}
		public E pollLast() {
			java.lang.Object r = null;
			return (E)r;
		}
		public java.util.Iterator<E> descendingIterator() {
			java.util.Iterator r = null;
			r = new java.util.TreeMap().new KeyIterator();
			((java.util.TreeMap.KeyIterator)r).f162 = (java.lang.Object)((java.util.Collections.SynchronizedNavigableSet)this).f65;
			return (java.util.Iterator<E>)r;
		}
		public E ceiling(E p0) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Collections.SynchronizedNavigableSet)this).f65;
			return (E)r;
		}
		public E higher(E p0) {
			java.lang.Object r = null;
			return (E)r;
		}
		public java.util.NavigableSet<E> descendingSet() {
			java.util.NavigableSet r = null;
			return (java.util.NavigableSet<E>)r;
		}
		public E lower(E p0) {
			java.lang.Object r = null;
			return (E)r;
		}
	}
	public static class SynchronizedSortedSet<E> extends java.util.Collections.SynchronizedSet<E> implements java.util.SortedSet<E> {
		public java.lang.Object f66;
		SynchronizedSortedSet(java.util.SortedSet<E> p0) {
		}
		SynchronizedSortedSet(java.util.SortedSet<E> p0, java.lang.Object p1) {
		}
		public SynchronizedSortedSet() {
		}
		public E first() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Collections.SynchronizedNavigableSet)this).f65;
			return (E)r;
		}
		public java.util.SortedSet<E> subSet(E p0, E p1) {
			java.util.SortedSet r = null;
			return (java.util.SortedSet<E>)r;
		}
		public java.util.SortedSet<E> headSet(E p0) {
			java.util.SortedSet r = null;
			return (java.util.SortedSet<E>)r;
		}
		public java.util.SortedSet<E> tailSet(E p0) {
			java.util.SortedSet r = null;
			return (java.util.SortedSet<E>)r;
		}
		public java.util.Comparator<? super E> comparator() {
			java.util.Comparator r = null;
			return (java.util.Comparator<? super E>)r;
		}
		public E last() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Collections.SynchronizedNavigableSet)this).f65;
			r = (java.lang.Object)((java.util.Collections.SynchronizedSortedSet)this).f66;
			return (E)r;
		}
	}
	public static class SynchronizedSet<E> extends java.util.Collections.SynchronizedCollection<E> implements java.util.Set<E> {
		public java.lang.Object f68;
		public java.lang.Object f78;
		SynchronizedSet(java.util.Set<E> p0) {
		}
		SynchronizedSet(java.util.Set<E> p0, java.lang.Object p1) {
		}
		public SynchronizedSet() {
		}
		public boolean equals(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public int hashCode() {
			int r = 0;
			return (int)r;
		}
	}
	public static class SynchronizedCollection<E> implements java.util.Collection<E>, java.io.Serializable {
		public java.lang.Object f24;
		SynchronizedCollection(java.util.Collection<E> p0) {
		}
		SynchronizedCollection(java.util.Collection<E> p0, java.lang.Object p1) {
		}
		public SynchronizedCollection() {
		}
		public boolean add(E p0) {
			boolean r = false;
			return (boolean)r;
		}
		public boolean remove(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public java.lang.String toString() {
			java.lang.String r = null;
			return (java.lang.String)r;
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
			r = new java.util.Collections.UnmodifiableCollection.ANON39();
			r = new java.util.concurrent.PriorityBlockingQueue().new Itr();
			r = new ANON290();
			r = new java.util.concurrent.LinkedBlockingDeque().new Itr();
			r = new java.util.LinkedHashMap().new LinkedKeyIterator();
			r = new java.util.concurrent.ConcurrentSkipListMap().new KeyIterator();
			r = new java.util.LinkedList().new ListItr();
			r = new java.util.concurrent.ConcurrentLinkedDeque().new Itr();
			r = new java.util.concurrent.ConcurrentLinkedQueue().new Itr();
			r = new java.util.TreeMap().new KeyIterator();
			r = new java.util.Vector().new Itr();
			r = new java.util.PriorityQueue().new Itr();
			r = new java.util.concurrent.CopyOnWriteArrayList.COWIterator();
			r = new java.util.ArrayDeque().new DeqIterator();
			r = new java.util.HashMap().new KeyIterator();
			r = new java.util.concurrent.LinkedBlockingQueue().new Itr();
			r = new java.util.Hashtable().new Enumerator();
			r = new java.util.ArrayList().new Itr();
			r = new java.util.concurrent.LinkedTransferQueue().new Itr();
			((java.util.concurrent.ConcurrentLinkedDeque.Itr)r).f99 = (java.lang.Object)((java.util.Collections.SynchronizedCollection)this).f24;
			((java.util.LinkedList.ListItr)r).f48 = (java.lang.Object)((java.util.Collections.SynchronizedCollection)this).f24;
			((java.util.TreeMap.KeyIterator)r).f162 = (java.lang.Object)((java.util.Collections.SynchronizedSortedSet)this).f66;
			((java.util.concurrent.LinkedBlockingQueue.Itr)r).f115 = (java.lang.Object)((java.util.Collections.SynchronizedCollection)this).f24;
			((java.util.HashMap.KeyIterator)r).f171 = (java.lang.Object)((java.util.Collections.SynchronizedCollection)this).f24;
			((java.util.ArrayList.Itr)r).f9 = (java.lang.Object)((java.util.Collections.SynchronizedCollection)this).f24;
			((java.util.concurrent.ConcurrentLinkedQueue.Itr)r).f96 = (java.lang.Object)((java.util.Collections.SynchronizedCollection)this).f24;
			((java.util.TreeMap.KeyIterator)r).f162 = (java.lang.Object)((java.util.Collections.SynchronizedNavigableSet)this).f65;
			((java.util.Hashtable.Enumerator)r).f55 = (java.lang.Object)((java.util.Collections.SynchronizedCollection)this).f24;
			((java.util.concurrent.ConcurrentSkipListMap.KeyIterator)r).f112 = (java.lang.Object)((java.util.Collections.SynchronizedCollection)this).f24;
			((java.util.Vector.Itr)r).f125 = (java.lang.Object)((java.util.Collections.SynchronizedRandomAccessList)this).f3;
			((java.util.concurrent.CopyOnWriteArrayList.COWIterator)r).f128 = (java.lang.Object)((java.util.Collections.SynchronizedRandomAccessList)this).f3;
			((ANON290)r).f156 = (java.lang.Object)((java.util.Collections.SynchronizedSet)this).f78;
			((java.util.PriorityQueue.Itr)r).f150 = (java.lang.Object)((java.util.Collections.SynchronizedCollection)this).f24;
			((java.util.concurrent.ConcurrentSkipListMap.KeyIterator)r).f112 = (java.lang.Object)((java.util.Collections.SynchronizedSet)this).f78;
			((java.util.ArrayList.Itr)r).f9 = (java.lang.Object)((java.util.Collections.SynchronizedRandomAccessList)this).f3;
			((java.util.Collections.UnmodifiableCollection.ANON39)r).f143 = (java.lang.Object)((java.util.Collections.SynchronizedCollection)this).f24;
			((java.util.Vector.Itr)r).f125 = (java.lang.Object)((java.util.Collections.SynchronizedCollection)this).f24;
			((java.util.TreeMap.KeyIterator)r).f162 = (java.lang.Object)((java.util.Collections.SynchronizedSet)this).f78;
			((ANON290)r).f156 = (java.lang.Object)((java.util.Collections.SynchronizedRandomAccessList)this).f3;
			((java.util.concurrent.LinkedTransferQueue.Itr)r).f59 = (java.lang.Object)((java.util.Collections.SynchronizedCollection)this).f24;
			((java.util.Hashtable.Enumerator)r).f55 = (java.lang.Object)((java.util.Collections.SynchronizedSet)this).f78;
			((java.util.LinkedList.ListItr)r).f48 = (java.lang.Object)((java.util.Collections.SynchronizedList)this).f95;
			((java.util.LinkedHashMap.LinkedKeyIterator)r).f91 = (java.lang.Object)((java.util.Collections.SynchronizedSet)this).f78;
			((java.util.Hashtable.Enumerator)r).f166 = (java.lang.Object)((java.util.Collections.SynchronizedSet)this).f68;
			((java.util.concurrent.PriorityBlockingQueue.Itr)r).f69 = (java.lang.Object)((java.util.Collections.SynchronizedCollection)this).f24;
			((java.util.concurrent.LinkedBlockingDeque.Itr)r).f103 = (java.lang.Object)((java.util.Collections.SynchronizedCollection)this).f24;
			((java.util.ArrayDeque.DeqIterator)r).f101 = (java.lang.Object)((java.util.Collections.SynchronizedCollection)this).f24;
			return (java.util.Iterator<E>)r;
		}
		public boolean addAll(java.util.Collection<? extends E> p0) {
			boolean r = false;
			return (boolean)r;
		}
		public boolean containsAll(java.util.Collection<?> p0) {
			boolean r = false;
			return (boolean)r;
		}
		public boolean removeAll(java.util.Collection<?> p0) {
			boolean r = false;
			return (boolean)r;
		}
		public boolean retainAll(java.util.Collection<?> p0) {
			boolean r = false;
			return (boolean)r;
		}
	}
	public static class UnmodifiableNavigableMap<K,V> extends java.util.Collections.UnmodifiableSortedMap<K, V> implements java.util.NavigableMap<K, V>, java.io.Serializable {
		public java.lang.Object f81;
		public java.lang.Object f54;
		UnmodifiableNavigableMap(java.util.NavigableMap<K, ? extends V> p0) {
		}
		public UnmodifiableNavigableMap() {
		}
		public java.util.NavigableSet<K> navigableKeySet() {
			java.util.NavigableSet r = null;
			return (java.util.NavigableSet<K>)r;
		}
		public java.util.NavigableMap<K, V> descendingMap() {
			java.util.NavigableMap r = null;
			r = new java.util.Collections.UnmodifiableNavigableMap();
			((java.util.Collections.UnmodifiableNavigableMap)r).f81 = (java.lang.Object)((java.util.Collections.UnmodifiableNavigableMap)this).f81;
			return (java.util.NavigableMap<K, V>)r;
		}
		public java.util.Map.Entry<K, V> firstEntry() {
			java.util.Map.Entry r = null;
			r = new java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntry();
			((java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntry)r).f163 = (java.lang.Object)((java.util.Collections.UnmodifiableNavigableMap)this).f81;
			return (java.util.Map.Entry<K, V>)r;
		}
		public java.util.Map.Entry<K, V> lastEntry() {
			java.util.Map.Entry r = null;
			return (java.util.Map.Entry<K, V>)r;
		}
		public java.util.Map.Entry<K, V> pollFirstEntry() {
			java.util.Map.Entry r = null;
			return (java.util.Map.Entry<K, V>)r;
		}
		public java.util.Map.Entry<K, V> pollLastEntry() {
			java.util.Map.Entry r = null;
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
			return (java.util.Map.Entry<K, V>)r;
		}
		public K floorKey(K p0) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Collections.UnmodifiableNavigableMap)this).f81;
			return (K)r;
		}
		public java.util.Map.Entry<K, V> ceilingEntry(K p0) {
			java.util.Map.Entry r = null;
			return (java.util.Map.Entry<K, V>)r;
		}
		public K ceilingKey(K p0) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Collections.UnmodifiableNavigableMap)this).f81;
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
			return (java.util.NavigableSet<K>)r;
		}
		public java.util.NavigableMap<K, V> subMap(K p0, boolean p1, K p2, boolean p3) {
			java.util.NavigableMap r = null;
			return (java.util.NavigableMap<K, V>)r;
		}
		public java.util.NavigableMap<K, V> headMap(K p0, boolean p1) {
			java.util.NavigableMap r = null;
			return (java.util.NavigableMap<K, V>)r;
		}
		public java.util.NavigableMap<K, V> tailMap(K p0, boolean p1) {
			java.util.NavigableMap r = null;
			r = new java.util.Collections.UnmodifiableNavigableMap();
			((java.util.Collections.UnmodifiableNavigableMap)r).f81 = (java.lang.Object)((java.util.Collections.UnmodifiableNavigableMap)this).f81;
			return (java.util.NavigableMap<K, V>)r;
		}
		public static class EmptyNavigableMap<K,V> extends java.util.Collections.UnmodifiableNavigableMap<K, V> implements java.io.Serializable {
			public EmptyNavigableMap() {
			}
			public java.util.NavigableSet<K> navigableKeySet() {
				java.util.NavigableSet r = null;
				return (java.util.NavigableSet<K>)r;
			}
		}
	}
	public static class UnmodifiableSortedMap<K,V> extends java.util.Collections.UnmodifiableMap<K, V> implements java.util.SortedMap<K, V>, java.io.Serializable {
		public java.lang.Object f27;
		public java.lang.Object f175;
		UnmodifiableSortedMap(java.util.SortedMap<K, ? extends V> p0) {
		}
		public UnmodifiableSortedMap() {
		}
		public java.util.Comparator<? super K> comparator() {
			java.util.Comparator r = null;
			return (java.util.Comparator<? super K>)r;
		}
		public K firstKey() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Collections.UnmodifiableNavigableMap)this).f81;
			return (K)r;
		}
		public K lastKey() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Collections.UnmodifiableNavigableMap)this).f81;
			r = (java.lang.Object)((java.util.Collections.UnmodifiableSortedMap)this).f175;
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
	public static class UnmodifiableMap<K,V> implements java.util.Map<K, V>, java.io.Serializable {
		public java.lang.Object f146;
		public java.lang.Object f29;
		UnmodifiableMap(java.util.Map<? extends K, ? extends V> p0) {
		}
		public UnmodifiableMap() {
		}
		public V remove(java.lang.Object p0) {
			java.lang.Object r = null;
			return (V)r;
		}
		public boolean remove(java.lang.Object p0, java.lang.Object p1) {
			boolean r = false;
			return (boolean)r;
		}
		public V get(java.lang.Object p0) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Collections.UnmodifiableMap)this).f29;
			return (V)r;
		}
		public V put(K p0, V p1) {
			java.lang.Object r = null;
			return (V)r;
		}
		public boolean equals(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public java.lang.String toString() {
			java.lang.String r = null;
			return (java.lang.String)r;
		}
		public java.util.Collection<V> values() {
			java.util.Collection r = null;
			r = new java.util.Collections.UnmodifiableCollection();
			((java.util.Collections.UnmodifiableCollection)r).f32 = (java.lang.Object)((java.util.Collections.UnmodifiableMap)this).f29;
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
		public void putAll(java.util.Map<? extends K, ? extends V> p0) {
		}
		public V putIfAbsent(K p0, V p1) {
			java.lang.Object r = null;
			return (V)r;
		}
		public java.util.Set<K> keySet() {
			java.util.Set r = null;
			r = new java.util.Collections.UnmodifiableSet();
			((java.util.Collections.UnmodifiableSet)r).f42 = (java.lang.Object)((java.util.Collections.UnmodifiableMap)this).f146;
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
			r = (java.lang.Object)((java.util.Collections.UnmodifiableSortedMap)this).f27;
			r = (java.lang.Object)((java.util.Collections.UnmodifiableNavigableMap)this).f54;
			r = (java.lang.Object)((java.util.Collections.UnmodifiableMap)this).f29;
			return (V)r;
		}
		public static class UnmodifiableEntrySet<K,V> extends java.util.Collections.UnmodifiableSet<java.util.Map.Entry<K, V>> {
			UnmodifiableEntrySet(java.util.Set<? extends java.util.Map.Entry<? extends K, ? extends V>> p0) {
			}
			public UnmodifiableEntrySet() {
			}
			public boolean equals(java.lang.Object p0) {
				boolean r = false;
				return (boolean)r;
			}
			public boolean contains(java.lang.Object p0) {
				boolean r = false;
				return (boolean)r;
			}
			public java.lang.Object[] toArray() {
				java.lang.Object[] r = null;
				return (java.lang.Object[])r;
			}
			public <T> T[] toArray(T[] p0) {
				java.lang.Object[] r = null;
				return (T[])r;
			}
			public java.util.Iterator<java.util.Map.Entry<K, V>> iterator() {
				java.util.Iterator r = null;
				return (java.util.Iterator<java.util.Map.Entry<K, V>>)r;
			}
			public boolean containsAll(java.util.Collection<?> p0) {
				boolean r = false;
				return (boolean)r;
			}
			public static class UnmodifiableEntry<K,V> implements java.util.Map.Entry<K, V> {
				public java.lang.Object f163;
				UnmodifiableEntry(java.util.Map.Entry<? extends K, ? extends V> p0) {
				}
				public UnmodifiableEntry() {
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
					r = (java.lang.Object)((java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntry)this).f163;
					return (K)r;
				}
				public V setValue(V p0) {
					java.lang.Object r = null;
					return (V)r;
				}
			}
			public static final class UnmodifiableEntrySetSpliterator<K,V> {
				public UnmodifiableEntrySetSpliterator() {
				}
				public long estimateSize() {
					long r = 0;
					return (long)r;
				}
				public long getExactSizeIfKnown() {
					long r = 0;
					return (long)r;
				}
				public int characteristics() {
					int r = 0;
					return (int)r;
				}
				public boolean hasCharacteristics(int p0) {
					boolean r = false;
					return (boolean)r;
				}
				public java.util.Comparator<? super java.util.Map.Entry<K, V>> getComparator() {
					java.util.Comparator r = null;
					return (java.util.Comparator<? super java.util.Map.Entry<K, V>>)r;
				}
			}
			public class ANON154 implements java.util.Iterator<java.util.Map.Entry<K, V>> {
				ANON154() {
				}
				public void remove() {
				}
				public boolean hasNext() {
					boolean r = false;
					return (boolean)r;
				}
				public java.util.Map.Entry<K, V> next() {
					java.util.Map.Entry r = null;
					return (java.util.Map.Entry<K, V>)r;
				}
			}
		}
	}
	public static class UnmodifiableRandomAccessList<E> extends java.util.Collections.UnmodifiableList<E> implements java.util.RandomAccess {
		public java.lang.Object f20;
		UnmodifiableRandomAccessList(java.util.List<? extends E> p0) {
		}
		public UnmodifiableRandomAccessList() {
		}
		public java.util.List<E> subList(int p0, int p1) {
			java.util.List r = null;
			return (java.util.List<E>)r;
		}
	}
	public static class UnmodifiableList<E> extends java.util.Collections.UnmodifiableCollection<E> implements java.util.List<E> {
		public java.lang.Object f116;
		UnmodifiableList(java.util.List<? extends E> p0) {
		}
		public UnmodifiableList() {
		}
		public void add(int p0, E p1) {
		}
		public E remove(int p0) {
			java.lang.Object r = null;
			return (E)r;
		}
		public E get(int p0) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Collections.UnmodifiableList)this).f116;
			r = (java.lang.Object)((java.util.Collections.UnmodifiableRandomAccessList)this).f20;
			return (E)r;
		}
		public boolean equals(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public int hashCode() {
			int r = 0;
			return (int)r;
		}
		public int indexOf(java.lang.Object p0) {
			int r = 0;
			return (int)r;
		}
		public int lastIndexOf(java.lang.Object p0) {
			int r = 0;
			return (int)r;
		}
		public java.util.List<E> subList(int p0, int p1) {
			java.util.List r = null;
			return (java.util.List<E>)r;
		}
		public boolean addAll(int p0, java.util.Collection<? extends E> p1) {
			boolean r = false;
			return (boolean)r;
		}
		public E set(int p0, E p1) {
			java.lang.Object r = null;
			return (E)r;
		}
		public java.util.ListIterator<E> listIterator(int p0) {
			java.util.ListIterator r = null;
			r = new ANON109();
			((ANON109)r).f158 = (java.lang.Object)((java.util.Collections.UnmodifiableList)this).f116;
			((ANON109)r).f158 = (java.lang.Object)((java.util.Collections.UnmodifiableRandomAccessList)this).f20;
			return (java.util.ListIterator<E>)r;
		}
		public java.util.ListIterator<E> listIterator() {
			java.util.ListIterator r = null;
			r = new ANON109();
			((ANON109)r).f158 = (java.lang.Object)((java.util.Collections.UnmodifiableList)this).f116;
			((ANON109)r).f158 = (java.lang.Object)((java.util.Collections.UnmodifiableRandomAccessList)this).f20;
			return (java.util.ListIterator<E>)r;
		}
		public void sort(java.util.Comparator<? super E> p0) {
		}
		public class ANON109<E> implements java.util.ListIterator<E> {
			public java.lang.Object f158;
			ANON109() {
			}
			public void add(E p0) {
			}
			public void remove() {
			}
			public boolean hasNext() {
				boolean r = false;
				return (boolean)r;
			}
			public E next() {
				java.lang.Object r = null;
				r = (java.lang.Object)((ANON109)this).f158;
				return (E)r;
			}
			public void set(E p0) {
			}
			public int previousIndex() {
				int r = 0;
				return (int)r;
			}
			public boolean hasPrevious() {
				boolean r = false;
				return (boolean)r;
			}
			public E previous() {
				java.lang.Object r = null;
				return (E)r;
			}
			public int nextIndex() {
				int r = 0;
				return (int)r;
			}
		}
	}
	public static class UnmodifiableNavigableSet<E> extends java.util.Collections.UnmodifiableSortedSet<E> implements java.util.NavigableSet<E>, java.io.Serializable {
		public java.lang.Object f8;
		UnmodifiableNavigableSet(java.util.NavigableSet<E> p0) {
		}
		public UnmodifiableNavigableSet() {
		}
		public E floor(E p0) {
			java.lang.Object r = null;
			return (E)r;
		}
		public java.util.NavigableSet<E> subSet(E p0, boolean p1, E p2, boolean p3) {
			java.util.NavigableSet r = null;
			return (java.util.NavigableSet<E>)r;
		}
		public java.util.NavigableSet<E> headSet(E p0, boolean p1) {
			java.util.NavigableSet r = null;
			return (java.util.NavigableSet<E>)r;
		}
		public java.util.NavigableSet<E> tailSet(E p0, boolean p1) {
			java.util.NavigableSet r = null;
			return (java.util.NavigableSet<E>)r;
		}
		public E pollFirst() {
			java.lang.Object r = null;
			return (E)r;
		}
		public E pollLast() {
			java.lang.Object r = null;
			return (E)r;
		}
		public java.util.Iterator<E> descendingIterator() {
			java.util.Iterator r = null;
			return (java.util.Iterator<E>)r;
		}
		public E ceiling(E p0) {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Collections.UnmodifiableNavigableSet)this).f8;
			return (E)r;
		}
		public E higher(E p0) {
			java.lang.Object r = null;
			return (E)r;
		}
		public java.util.NavigableSet<E> descendingSet() {
			java.util.NavigableSet r = null;
			return (java.util.NavigableSet<E>)r;
		}
		public E lower(E p0) {
			java.lang.Object r = null;
			return (E)r;
		}
		public static class EmptyNavigableSet<E> extends java.util.Collections.UnmodifiableNavigableSet<E> implements java.io.Serializable {
			public EmptyNavigableSet() {
			}
		}
	}
	public static class UnmodifiableSortedSet<E> extends java.util.Collections.UnmodifiableSet<E> implements java.util.SortedSet<E>, java.io.Serializable {
		public java.lang.Object f82;
		UnmodifiableSortedSet(java.util.SortedSet<E> p0) {
		}
		public UnmodifiableSortedSet() {
		}
		public E first() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Collections.UnmodifiableSortedSet)this).f82;
			return (E)r;
		}
		public java.util.SortedSet<E> subSet(E p0, E p1) {
			java.util.SortedSet r = null;
			return (java.util.SortedSet<E>)r;
		}
		public java.util.SortedSet<E> headSet(E p0) {
			java.util.SortedSet r = null;
			return (java.util.SortedSet<E>)r;
		}
		public java.util.SortedSet<E> tailSet(E p0) {
			java.util.SortedSet r = null;
			return (java.util.SortedSet<E>)r;
		}
		public java.util.Comparator<? super E> comparator() {
			java.util.Comparator r = null;
			return (java.util.Comparator<? super E>)r;
		}
		public E last() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Collections.UnmodifiableSortedSet)this).f82;
			return (E)r;
		}
	}
	public static class UnmodifiableSet<E> extends java.util.Collections.UnmodifiableCollection<E> implements java.util.Set<E>, java.io.Serializable {
		public java.lang.Object f42;
		UnmodifiableSet(java.util.Set<? extends E> p0) {
		}
		public UnmodifiableSet() {
		}
		public boolean equals(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public int hashCode() {
			int r = 0;
			return (int)r;
		}
	}
	public static class UnmodifiableCollection<E> implements java.util.Collection<E>, java.io.Serializable {
		public java.lang.Object f32;
		UnmodifiableCollection(java.util.Collection<? extends E> p0) {
		}
		public UnmodifiableCollection() {
		}
		public boolean add(E p0) {
			boolean r = false;
			return (boolean)r;
		}
		public boolean remove(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public java.lang.String toString() {
			java.lang.String r = null;
			return (java.lang.String)r;
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
			r = new java.lang.Object[1];
			((java.lang.Object[])r)[0] = (java.lang.Object)((java.util.Collections.UnmodifiableSet)this).f42;
			return (T[])r;
		}
		public java.lang.Object[] toArray() {
			java.lang.Object[] r = null;
			return (java.lang.Object[])r;
		}
		public java.util.Iterator<E> iterator() {
			java.util.Iterator r = null;
			r = new ANON39();
			((ANON39)r).f143 = (java.lang.Object)((java.util.Collections.UnmodifiableCollection)this).f32;
			((ANON39)r).f143 = (java.lang.Object)((java.util.Collections.UnmodifiableRandomAccessList)this).f20;
			((ANON39)r).f143 = (java.lang.Object)((java.util.Collections.UnmodifiableList)this).f116;
			((ANON39)r).f143 = (java.lang.Object)((java.util.Collections.UnmodifiableNavigableSet)this).f8;
			((ANON39)r).f143 = (java.lang.Object)((java.util.Collections.UnmodifiableSet)this).f42;
			return (java.util.Iterator<E>)r;
		}
		public boolean addAll(java.util.Collection<? extends E> p0) {
			boolean r = false;
			return (boolean)r;
		}
		public boolean containsAll(java.util.Collection<?> p0) {
			boolean r = false;
			return (boolean)r;
		}
		public boolean removeAll(java.util.Collection<?> p0) {
			boolean r = false;
			return (boolean)r;
		}
		public boolean retainAll(java.util.Collection<?> p0) {
			boolean r = false;
			return (boolean)r;
		}
		public static class ANON39<E> implements java.util.Iterator<E> {
			public java.lang.Object f143;
			ANON39() {
			}
			public void remove() {
			}
			public boolean hasNext() {
				boolean r = false;
				return (boolean)r;
			}
			public E next() {
				java.lang.Object r = null;
				r = (java.lang.Object)((ANON39)this).f143;
				return (E)r;
			}
		}
	}
	public static class ANON290<E> implements java.util.Iterator<E> {
		public java.lang.Object f156;
		ANON290() {
		}
		public void remove() {
		}
		public boolean hasNext() {
			boolean r = false;
			return (boolean)r;
		}
		public E next() {
			java.lang.Object r = null;
			r = new java.util.AtlasAbstractMap.SimpleImmutableEntry();
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f12 = (java.lang.Object)((ANON290)this).f156;
			((java.util.AtlasAbstractMap.SimpleImmutableEntry)r).f137 = (java.lang.Object)((ANON290)this).f156;
			r = (java.lang.Object)((ANON290)this).f156;
			return (E)r;
		}
	}
	public class ANON251<T> {
		ANON251() {
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
	public static class ANON3<E> implements java.util.Enumeration<E> {
		public java.lang.Object f0;
		public boolean hasMoreElements() {
			return false;
		}
		public E nextElement() {
			return (E)f0;
		}
	}
}
