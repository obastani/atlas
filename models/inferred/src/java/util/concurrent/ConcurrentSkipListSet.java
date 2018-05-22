package java.util.concurrent;
public class ConcurrentSkipListSet<E> extends java.util.AbstractSet<E> implements java.util.NavigableSet<E>, java.lang.Cloneable, java.io.Serializable {
	public java.lang.Object f1;
	ConcurrentSkipListSet(java.util.concurrent.ConcurrentNavigableMap<E, java.lang.Object> p0) {
	}
	public ConcurrentSkipListSet(java.util.SortedSet<E> p0) {
		((java.util.concurrent.ConcurrentSkipListSet)this).f1 = p0.iterator().next();
	}
	public ConcurrentSkipListSet(java.util.Collection<? extends E> p0) {
		((java.util.concurrent.ConcurrentSkipListSet)this).f1 = p0.iterator().next();
	}
	public ConcurrentSkipListSet(java.util.Comparator<? super E> p0) {
	}
	public ConcurrentSkipListSet() {
	}
	public boolean add(E p0) {
		boolean r = false;
		((java.util.concurrent.ConcurrentSkipListSet)this).f1 = (java.lang.Object)p0;
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
	public java.util.concurrent.ConcurrentSkipListSet<E> clone() {
		java.util.concurrent.ConcurrentSkipListSet r = null;
		r = new java.util.concurrent.ConcurrentSkipListSet();
		((java.util.concurrent.ConcurrentSkipListSet)r).f1 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListSet)this).f1;
		return (java.util.concurrent.ConcurrentSkipListSet<E>)r;
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
		r = new java.util.concurrent.ConcurrentSkipListMap().new KeyIterator();
		((java.util.concurrent.ConcurrentSkipListMap.KeyIterator)r).f112 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListSet)this).f1;
		return (java.util.Iterator<E>)r;
	}
	public E first() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListSet)this).f1;
		return (E)r;
	}
	public boolean removeAll(java.util.Collection<?> p0) {
		boolean r = false;
		return (boolean)r;
	}
	public E floor(E p0) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListSet)this).f1;
		return (E)r;
	}
	public java.util.NavigableSet<E> subSet(E p0, boolean p1, E p2, boolean p3) {
		java.util.NavigableSet r = null;
		r = new java.util.concurrent.ConcurrentSkipListSet();
		((java.util.concurrent.ConcurrentSkipListSet)r).f1 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListSet)this).f1;
		return (java.util.NavigableSet<E>)r;
	}
	public java.util.NavigableSet<E> subSet(E p0, E p1) {
		java.util.NavigableSet r = null;
		return (java.util.NavigableSet<E>)r;
	}
	public java.util.NavigableSet<E> headSet(E p0, boolean p1) {
		java.util.NavigableSet r = null;
		r = new java.util.concurrent.ConcurrentSkipListSet();
		((java.util.concurrent.ConcurrentSkipListSet)r).f1 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListSet)this).f1;
		return (java.util.NavigableSet<E>)r;
	}
	public java.util.NavigableSet<E> headSet(E p0) {
		java.util.NavigableSet r = null;
		return (java.util.NavigableSet<E>)r;
	}
	public java.util.NavigableSet<E> tailSet(E p0, boolean p1) {
		java.util.NavigableSet r = null;
		r = new java.util.concurrent.ConcurrentSkipListSet();
		((java.util.concurrent.ConcurrentSkipListSet)r).f1 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListSet)this).f1;
		return (java.util.NavigableSet<E>)r;
	}
	public java.util.NavigableSet<E> tailSet(E p0) {
		java.util.NavigableSet r = null;
		r = new java.util.concurrent.ConcurrentSkipListSet();
		((java.util.concurrent.ConcurrentSkipListSet)r).f1 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListSet)this).f1;
		return (java.util.NavigableSet<E>)r;
	}
	public java.util.Comparator<? super E> comparator() {
		java.util.Comparator r = null;
		return (java.util.Comparator<? super E>)r;
	}
	public E last() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListSet)this).f1;
		return (E)r;
	}
	public E pollFirst() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListSet)this).f1;
		return (E)r;
	}
	public E pollLast() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListSet)this).f1;
		return (E)r;
	}
	public java.util.Iterator<E> descendingIterator() {
		java.util.Iterator r = null;
		r = new java.util.concurrent.ConcurrentSkipListMap().new KeyIterator();
		((java.util.concurrent.ConcurrentSkipListMap.KeyIterator)r).f112 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListSet)this).f1;
		return (java.util.Iterator<E>)r;
	}
	public E ceiling(E p0) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListSet)this).f1;
		return (E)r;
	}
	public E higher(E p0) {
		java.lang.Object r = null;
		return (E)r;
	}
	public java.util.NavigableSet<E> descendingSet() {
		java.util.NavigableSet r = null;
		r = new java.util.concurrent.ConcurrentSkipListSet();
		((java.util.concurrent.ConcurrentSkipListSet)r).f1 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListSet)this).f1;
		return (java.util.NavigableSet<E>)r;
	}
	public E lower(E p0) {
		java.lang.Object r = null;
		return (E)r;
	}
	public boolean addAll(java.util.Collection<? extends E> p0) {
		boolean r = false;
		((java.util.concurrent.ConcurrentSkipListSet)this).f1 = p0.iterator().next();
		return (boolean)r;
	}
}
