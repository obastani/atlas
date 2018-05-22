package java.util;

import java.util.Collection;

public class AtlasNavigableSet<E> implements java.util.NavigableSet<E>, java.lang.Cloneable, java.io.Serializable {
	public E f;
	public java.util.Comparator<? super E> c = new java.util.Comparator<E>() { public int compare(E o1, E o2) { return 0; }};
	public java.util.Comparator<? super E> comparator() {
		return c;
	}
	public E first() {
		return f;
	}
	public E last() {
		return f;
	}
	public E ceiling(E e) {
		return f;
	}
	public java.util.Iterator<E> descendingIterator() {
		AtlasIterator<E> r = new AtlasIterator<E>();
		r.f = f;
		return r;
	}
	public java.util.NavigableSet<E> descendingSet() {
		AtlasNavigableSet<E> r = new AtlasNavigableSet<E>();
		r.f = f;
		return r;
	}
	public E floor(E e) {
		return f;
	}
	public java.util.SortedSet<E> headSet(E toElement) {
		AtlasNavigableSet<E> r = new AtlasNavigableSet<E>();
		r.f = f;
		return r;
	}
	public java.util.NavigableSet<E> headSet(E toElement, boolean inclusive) {
		AtlasNavigableSet<E> r = new AtlasNavigableSet<E>();
		r.f = f;
		return r;
	}
	public E higher(E e) {
		return f;
	}
	public E lower(E e) {
		return f;
	}
	public E pollFirst() {
		return f;
	}
	public E pollLast() {
		return f;
	}
	public java.util.SortedSet<E> subSet(E fromElement, E toElement) {
		AtlasNavigableSet<E> r = new AtlasNavigableSet<E>();
		r.f = f;
		return r;
	}
	public java.util.NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
		AtlasNavigableSet<E> r = new AtlasNavigableSet<E>();
		r.f = f;
		return r;
	}
	public java.util.SortedSet<E> tailSet(E fromElement) {
		AtlasNavigableSet<E> r = new AtlasNavigableSet<E>();
		r.f = f;
		return r;
	}
	public java.util.NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
		AtlasNavigableSet<E> r = new AtlasNavigableSet<E>();
		r.f = f;
		return r;
	}
	public java.util.Iterator<E> iterator() {
		AtlasIterator<E> r = new AtlasIterator<E>();
		r.f = f;
		return r;
	}
	public int size() {
		return 0;
	}
	public boolean add(E arg0) {
		f = arg0;
		return false;
	}
	public boolean addAll(Collection<? extends E> arg0) {
		f = arg0.iterator().next();
		return false;
	}
	public void clear() {
	}
	public boolean contains(Object arg0) {
		return false;
	}
	public boolean containsAll(Collection<?> arg0) {
		return false;
	}
	public boolean isEmpty() {
		return false;
	}
	public boolean remove(Object arg0) {
		return false;
	}
	public boolean removeAll(Collection<?> arg0) {
		return false;
	}
	public boolean retainAll(Collection<?> arg0) {
		return false;
	}
	public Object[] toArray() {
		Object[] a = new Object[1];
		a[0] = f;
		return a;
	}
	public <T> T[] toArray(T[] arg0) {
		java.lang.Object[] r = null;
		r = arg0;
		r = new java.lang.Object[1];
		r[0] = f;
		return (T[])r;
	}
	public Object clone() {
		AtlasNavigableSet<E> r = new AtlasNavigableSet<E>();
		r.f = f;
		r.c = c;
		return r;
	}
}
