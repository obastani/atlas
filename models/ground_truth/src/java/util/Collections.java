package java.util;
public class Collections {
	public static java.util.Set EMPTY_SET = new HashSet();
	public static java.util.List EMPTY_LIST = new ArrayList();
	public static java.util.Map EMPTY_MAP = new HashMap();
	public Collections() {
	}
	public static <T> T min(java.util.Collection<? extends T> p0, java.util.Comparator<? super T> p1) {
		return p0.iterator().next();
	}
	public static <T> T min(java.util.Collection<? extends T> p0) {
		return p0.iterator().next();
	}
	public static <T> T max(java.util.Collection<? extends T> p0, java.util.Comparator<? super T> p1) {
		return p0.iterator().next();
	}
	public static <T> T max(java.util.Collection<? extends T> p0) {
		return p0.iterator().next();
	}
	public static <T> boolean replaceAll(java.util.List<T> p0, T p1, T p2) {
		p0.add(p2);
		return false;
	}
	public static <T> boolean addAll(java.util.Collection<? super T> p0, T[] p1) {
		p0.add(p1[0]);
		return false;
	}
	public static <T> java.util.Set<T> synchronizedSet(java.util.Set<T> p0) {
		HashSet<T> r = new HashSet<T>();
		r.f = p0.iterator().next();
		return r;
	}
	public static <T> java.util.Enumeration<T> emptyEnumeration() {
		return new AtlasEnumeration<T>();
	}
	public static <E> java.util.Set<E> newSetFromMap(java.util.Map<E, java.lang.Boolean> p0) {
		HashSet<E> r = new HashSet<E>();
		r.f = p0.keySet().iterator().next();
		return r;
	}
	public static <T> java.util.List<T> unmodifiableList(java.util.List<? extends T> p0) {
		ArrayList<T> r = new ArrayList<T>();
		r.f = p0.get(0);
		return r;
	}
	public static <T> java.util.ArrayList<T> list(java.util.Enumeration<T> p0) {
		ArrayList<T> r = new ArrayList<T>();
		r.f = p0.nextElement();
		return r;
	}
	public static <T> java.util.Iterator<T> emptyIterator() {
		return new AtlasIterator<T>();
	}
	public static <T> java.util.Collection<T> synchronizedCollection(java.util.Collection<T> p0) {
		ArrayList<T> r = new ArrayList<T>();
		r.f = p0.iterator().next();
		return r;
	}
	public static <T> void copy(java.util.List<? super T> p0, java.util.List<? extends T> p1) {
		p0.add(p1.get(0));
	}
	public static <T> void fill(java.util.List<? super T> p0, T p1) {
		p0.add(p1);
	}
	public static <T> java.util.List<T> nCopies(int p0, T p1) {
		ArrayList<T> r = new ArrayList<T>();
		r.f = p1;
		return r;
	}
	public static void reverse(java.util.List<?> p0) {
	}
	public static <T> java.util.Comparator<T> reverseOrder() {
		return new java.util.Comparator<T>() { public int compare(T o1, T o2) { return 0; }};
	}
	public static <T> java.util.Comparator<T> reverseOrder(java.util.Comparator<T> p0) {
		return new java.util.Comparator<T>() { public int compare(T o1, T o2) { return 0; }};
	}
	public static <T> void sort(java.util.List<T> p0, java.util.Comparator<? super T> p1) {
	}
	public static <T> void sort(java.util.List<T> p0) {
	}
	public static <T> java.util.List<T> synchronizedList(java.util.List<T> p0) {
		ArrayList<T> r = new ArrayList<T>();
		r.f = p0.get(0);
		return r;
	}
	public static <T> java.util.Set<T> unmodifiableSet(java.util.Set<? extends T> p0) {
		HashSet<T> r = new HashSet<T>();
		r.f = p0.iterator().next();
		return r;
	}
	public static <T> int binarySearch(java.util.List<? extends java.lang.Comparable<? super T>> p0, T p1) {
		return 0;
	}
	public static <T> int binarySearch(java.util.List<? extends T> p0, T p1, java.util.Comparator<? super T> p2) {
		return 0;
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
		return 0;
	}
	public static int lastIndexOfSubList(java.util.List<?> p0, java.util.List<?> p1) {
		return 0;
	}
	public static <T> java.util.Collection<T> unmodifiableCollection(java.util.Collection<? extends T> p0) {
		ArrayList<T> r = new ArrayList<T>();
		r.f = p0.iterator().next();
		return r;
	}
	public static <T> java.util.SortedSet<T> unmodifiableSortedSet(java.util.SortedSet<T> p0) {
		AtlasNavigableSet<T> r = new AtlasNavigableSet<T>();
		r.f = p0.iterator().next();
		return r;
	}
	public static <T> java.util.NavigableSet<T> unmodifiableNavigableSet(java.util.NavigableSet<T> p0) {
		AtlasNavigableSet<T> r = new AtlasNavigableSet<T>();
		r.f = p0.iterator().next();
		return r;
	}
	public static <K,V> java.util.Map<K, V> unmodifiableMap(java.util.Map<? extends K, ? extends V> p0) {
		HashMap<K,V> r = new HashMap<K,V>();
		r.k = p0.keySet().iterator().next();
		r.v = p0.values().iterator().next();
		return r;
	}
	public static <K,V> java.util.SortedMap<K, V> unmodifiableSortedMap(java.util.SortedMap<K, ? extends V> p0) {
		TreeMap<K,V> r = new TreeMap<K,V>();
		r.k = p0.keySet().iterator().next();
		r.v = p0.values().iterator().next();
		return r;
	}
	public static <K,V> java.util.NavigableMap<K, V> unmodifiableNavigableMap(java.util.NavigableMap<K, ? extends V> p0) {
		TreeMap<K,V> r = new TreeMap<K,V>();
		r.k = p0.keySet().iterator().next();
		r.v = p0.values().iterator().next();
		return r;
	}
	public static <T> java.util.SortedSet<T> synchronizedSortedSet(java.util.SortedSet<T> p0) {
		AtlasNavigableSet<T> r = new AtlasNavigableSet<T>();
		r.f = p0.iterator().next();
		return r;
	}
	public static <T> java.util.NavigableSet<T> synchronizedNavigableSet(java.util.NavigableSet<T> p0) {
		AtlasNavigableSet<T> r = new AtlasNavigableSet<T>();
		r.f = p0.iterator().next();
		return r;
	}
	public static <K,V> java.util.Map<K, V> synchronizedMap(java.util.Map<K, V> p0) {
		HashMap<K,V> r = new HashMap<K,V>();
		r.k = p0.keySet().iterator().next();
		r.v = p0.values().iterator().next();
		return r;
	}
	public static <K,V> java.util.SortedMap<K, V> synchronizedSortedMap(java.util.SortedMap<K, V> p0) {
		TreeMap<K,V> r = new TreeMap<K,V>();
		r.k = p0.keySet().iterator().next();
		r.v = p0.values().iterator().next();
		return r;
	}
	public static <K,V> java.util.NavigableMap<K, V> synchronizedNavigableMap(java.util.NavigableMap<K, V> p0) {
		TreeMap<K,V> r = new TreeMap<K,V>();
		r.k = p0.keySet().iterator().next();
		r.v = p0.values().iterator().next();
		return r;
	}
	public static <E> java.util.Collection<E> checkedCollection(java.util.Collection<E> p0, java.lang.Class<E> p1) {
		ArrayList<E> r = new ArrayList<E>();
		r.f = p0.iterator().next();
		return r;
	}
	public static <E> java.util.Queue<E> checkedQueue(java.util.Queue<E> p0, java.lang.Class<E> p1) {
		java.util.ArrayDeque<E> r = new java.util.ArrayDeque<E>();
		r.add(p0.poll());
		return r;
	}
	public static <E> java.util.Set<E> checkedSet(java.util.Set<E> p0, java.lang.Class<E> p1) {
		HashSet<E> r = new HashSet<E>();
		r.f = p0.iterator().next();
		return r;
	}
	public static <E> java.util.SortedSet<E> checkedSortedSet(java.util.SortedSet<E> p0, java.lang.Class<E> p1) {
		AtlasNavigableSet<E> r = new AtlasNavigableSet<E>();
		r.f = p0.iterator().next();
		return r;
	}
	public static <E> java.util.NavigableSet<E> checkedNavigableSet(java.util.NavigableSet<E> p0, java.lang.Class<E> p1) {
		AtlasNavigableSet<E> r = new AtlasNavigableSet<E>();
		r.f = p0.iterator().next();
		return r;
	}
	public static <E> java.util.List<E> checkedList(java.util.List<E> p0, java.lang.Class<E> p1) {
		ArrayList<E> r = new ArrayList<E>();
		r.f = p0.iterator().next();
		return r;
	}
	public static <K,V> java.util.Map<K, V> checkedMap(java.util.Map<K, V> p0, java.lang.Class<K> p1, java.lang.Class<V> p2) {
		HashMap<K,V> r = new HashMap<K,V>();
		r.k = p0.keySet().iterator().next();
		r.v = p0.values().iterator().next();
		return r;
	}
	public static <K,V> java.util.SortedMap<K, V> checkedSortedMap(java.util.SortedMap<K, V> p0, java.lang.Class<K> p1, java.lang.Class<V> p2) {
		TreeMap<K,V> r = new TreeMap<K,V>();
		r.k = p0.keySet().iterator().next();
		r.v = p0.values().iterator().next();
		return r;
	}
	public static <K,V> java.util.NavigableMap<K, V> checkedNavigableMap(java.util.NavigableMap<K, V> p0, java.lang.Class<K> p1, java.lang.Class<V> p2) {
		TreeMap<K,V> r = new TreeMap<K,V>();
		r.k = p0.keySet().iterator().next();
		r.v = p0.values().iterator().next();
		return r;
	}
	public static <T> java.util.ListIterator<T> emptyListIterator() {
		return new AtlasListIterator<T>();
	}
	public static final <T> java.util.Set<T> emptySet() {
		return new HashSet<T>();
	}
	public static <E> java.util.SortedSet<E> emptySortedSet() {
		return new AtlasNavigableSet<E>();
	}
	public static <E> java.util.NavigableSet<E> emptyNavigableSet() {
		return new AtlasNavigableSet<E>();
	}
	public static final <T> java.util.List<T> emptyList() {
		return new ArrayList<T>();
	}
	public static final <K,V> java.util.Map<K, V> emptyMap() {
		return new HashMap<K,V>();
	}
	public static final <K,V> java.util.SortedMap<K, V> emptySortedMap() {
		return new TreeMap<K,V>();
	}
	public static final <K,V> java.util.NavigableMap<K, V> emptyNavigableMap() {
		return new TreeMap<K,V>();
	}
	public static <T> java.util.Set<T> singleton(T p0) {
		return new HashSet<T>();
	}
	public static <T> java.util.List<T> singletonList(T p0) {
		return new ArrayList<T>();
	}
	public static <K,V> java.util.Map<K, V> singletonMap(K p0, V p1) {
		return new HashMap<K,V>();
	}
	public static <T> java.util.Enumeration<T> enumeration(java.util.Collection<T> p0) {
		return new AtlasEnumeration<T>();
	}
	public static int frequency(java.util.Collection<?> p0, java.lang.Object p1) {
		return 0;
	}
	public static boolean disjoint(java.util.Collection<?> p0, java.util.Collection<?> p1) {
		return false;
	}
	public static <T> java.util.Queue<T> asLifoQueue(java.util.Deque<T> p0) {
		java.util.ArrayDeque<T> r = new java.util.ArrayDeque<T>();
		r.add(p0.getFirst());
		return r;
	}
}
