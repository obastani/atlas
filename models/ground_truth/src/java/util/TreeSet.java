package java.util;
public class TreeSet<E> extends java.util.AbstractSet<E> implements java.util.NavigableSet<E>, java.lang.Cloneable, java.io.Serializable {
	public E f;
	public java.util.Comparator<? super E> c = new java.util.Comparator<E>() { public int compare(E e1, E e2) { return 0; }};
	public TreeSet(java.util.SortedSet<E> p0) {
		f = p0.iterator().next();
	}
	public TreeSet(java.util.Collection<? extends E> p0) {
		f = p0.iterator().next();
	}
	public TreeSet(java.util.Comparator<? super E> p0) {
	}
	TreeSet(java.util.NavigableMap<E, java.lang.Object> p0) {
	}
	public TreeSet() {
	}
	public boolean add(E p0) {
		f = p0;
		return false;
	}
	public boolean remove(java.lang.Object p0) {
		return false;
	}
	public java.lang.Object clone() {
		TreeSet<E> r = new TreeSet<E>();
		r.f = f;
		return r;
	}
	public void clear() {
	}
	public boolean isEmpty() {
		return false;
	}
	public boolean contains(java.lang.Object p0) {
		return false;
	}
	public int size() {
		return 0;
	}
	public java.util.Iterator<E> iterator() {
		AtlasIterator<E> r = new AtlasIterator<E>();
		r.f = f;
		return r;
	}
	public boolean addAll(java.util.Collection<? extends E> p0) {
		f = p0.iterator().next();
		return false;
	}
	public E first() {
		return f;
	}
	public E floor(E p0) {
		f = p0;
		return f;
	}
	public E pollFirst() {
		return f;
	}
	public E pollLast() {
		return f;
	}
	public java.util.Iterator<E> descendingIterator() {
		AtlasIterator<E> r = new AtlasIterator<E>();
		r.f = f;
		return r;
	}
	public E last() {
		return f;
	}
	public java.util.Comparator<? super E> comparator() {
		return c;
	}
	public E lower(E p0) {
		return f;
	}
	public java.util.SortedSet<E> subSet(E p0, E p1) {
		TreeSet<E> r = new TreeSet<E>();
		r.f = f;
		return r;
	}
	public java.util.NavigableSet<E> subSet(E p0, boolean p1, E p2, boolean p3) {
		TreeSet<E> r = new TreeSet<E>();
		r.f = f;
		return r;
	}
	public java.util.SortedSet<E> headSet(E p0) {
		TreeSet<E> r = new TreeSet<E>();
		r.f = f;
		return r;
	}
	public java.util.NavigableSet<E> headSet(E p0, boolean p1) {
		TreeSet<E> r = new TreeSet<E>();
		r.f = f;
		return r;
	}
	public java.util.NavigableSet<E> tailSet(E p0, boolean p1) {
		TreeSet<E> r = new TreeSet<E>();
		r.f = f;
		return r;
	}
	public java.util.SortedSet<E> tailSet(E p0) {
		TreeSet<E> r = new TreeSet<E>();
		r.f = f;
		return r;
	}
	public E ceiling(E p0) {
		return f;
	}
	public E higher(E p0) {
		return f;
	}
	public java.util.NavigableSet<E> descendingSet() {
		TreeSet<E> r = new TreeSet<E>();
		r.f = f;
		return r;
	}
	public <T> T[] toArray(T[] p0) {
		java.lang.Object[] r = new java.lang.Object[1];
		r = p0;
		r[0] = f;
		return (T[])r;
	}
	public java.lang.Object[] toArray() {
		java.lang.Object[] r = new java.lang.Object[1];
		r[0] = f;
		return (java.lang.Object[])r;
	}
}
