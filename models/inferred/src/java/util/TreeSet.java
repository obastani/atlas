package java.util;
public class TreeSet<E> extends java.util.AbstractSet<E> implements java.util.NavigableSet<E>, java.lang.Cloneable, java.io.Serializable {
	public java.lang.Object f5;
	public TreeSet(java.util.SortedSet<E> p0) {
		((java.util.TreeSet)this).f5 = p0.iterator().next();
	}
	public TreeSet(java.util.Collection<? extends E> p0) {
		((java.util.TreeSet)this).f5 = p0.iterator().next();
	}
	public TreeSet(java.util.Comparator<? super E> p0) {
	}
	TreeSet(java.util.NavigableMap<E, java.lang.Object> p0) {
	}
	public TreeSet() {
	}
	public boolean add(E p0) {
		boolean r = false;
		((java.util.TreeSet)this).f5 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public boolean remove(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
	}
	public java.lang.Object clone() {
		java.lang.Object r = null;
		r = new java.util.TreeSet();
		((java.util.TreeSet)r).f5 = (java.lang.Object)((java.util.TreeSet)this).f5;
		return (java.lang.Object)r;
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
		((java.util.TreeMap.KeyIterator)r).f162 = (java.lang.Object)((java.util.TreeSet)this).f5;
		return (java.util.Iterator<E>)r;
	}
	public boolean addAll(java.util.Collection<? extends E> p0) {
		boolean r = false;
		((java.util.TreeSet)this).f5 = p0.iterator().next();
		return (boolean)r;
	}
	public E first() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.TreeSet)this).f5;
		return (E)r;
	}
	public E floor(E p0) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.TreeSet)this).f5;
		return (E)r;
	}
	public java.util.NavigableSet<E> subSet(E p0, boolean p1, E p2, boolean p3) {
		java.util.NavigableSet r = null;
		r = new java.util.TreeSet();
		((java.util.TreeSet)r).f5 = (java.lang.Object)((java.util.TreeSet)this).f5;
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
		r = new java.util.TreeSet();
		((java.util.TreeSet)r).f5 = (java.lang.Object)((java.util.TreeSet)this).f5;
		return (java.util.NavigableSet<E>)r;
	}
	public java.util.NavigableSet<E> tailSet(E p0, boolean p1) {
		java.util.NavigableSet r = null;
		r = new java.util.TreeSet();
		((java.util.TreeSet)r).f5 = (java.lang.Object)((java.util.TreeSet)this).f5;
		return (java.util.NavigableSet<E>)r;
	}
	public java.util.SortedSet<E> tailSet(E p0) {
		java.util.SortedSet r = null;
		r = new java.util.TreeSet();
		((java.util.TreeSet)r).f5 = (java.lang.Object)((java.util.TreeSet)this).f5;
		return (java.util.SortedSet<E>)r;
	}
	public java.util.Comparator<? super E> comparator() {
		java.util.Comparator r = null;
		return (java.util.Comparator<? super E>)r;
	}
	public E last() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.TreeSet)this).f5;
		return (E)r;
	}
	public E pollFirst() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.TreeSet)this).f5;
		return (E)r;
	}
	public E pollLast() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.TreeSet)this).f5;
		return (E)r;
	}
	public java.util.Iterator<E> descendingIterator() {
		java.util.Iterator r = null;
		r = new java.util.TreeMap().new DescendingKeyIterator();
		((java.util.TreeMap.DescendingKeyIterator)r).f172 = (java.lang.Object)((java.util.TreeSet)this).f5;
		return (java.util.Iterator<E>)r;
	}
	public E ceiling(E p0) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.TreeSet)this).f5;
		return (E)r;
	}
	public E higher(E p0) {
		java.lang.Object r = null;
		return (E)r;
	}
	public java.util.NavigableSet<E> descendingSet() {
		java.util.NavigableSet r = null;
		r = new java.util.TreeSet();
		((java.util.TreeSet)r).f5 = (java.lang.Object)((java.util.TreeSet)this).f5;
		return (java.util.NavigableSet<E>)r;
	}
	public E lower(E p0) {
		java.lang.Object r = null;
		return (E)r;
	}
	public <T> T[] toArray(T[] p0) {
		java.lang.Object[] r = null;
		r = new java.lang.Object[1];
		((java.lang.Object[])r)[0] = (java.lang.Object)((java.util.TreeSet)this).f5;
		return (T[])r;
	}
	public java.lang.Object[] toArray() {
		java.lang.Object[] r = null;
		r = new java.lang.Object[1];
		((java.lang.Object[])r)[0] = (java.lang.Object)((java.util.TreeSet)this).f5;
		return (java.lang.Object[])r;
	}
}
