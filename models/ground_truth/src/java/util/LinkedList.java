package java.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList<E> extends java.util.AbstractList<E> implements java.util.List<E>, java.util.Deque<E>, java.lang.Cloneable, java.io.Serializable {
	public E f;
	public LinkedList(java.util.Collection<? extends E> p0) {
		f = p0.iterator().next();
	}
	public LinkedList() {
	}
	public boolean add(E p0) {
		f = p0;
		return false;
	}
	public void add(int p0, E p1) {
		f = p1;
	}
	public boolean remove(java.lang.Object p0) {
		return false;
	}
	public E remove() {
		return f;
	}
	public E remove(int p0) {
		return f;
	}
	public E get(int p0) {
		return f;
	}
	public java.lang.Object clone() {
		LinkedList<E> r = new LinkedList<E>();
		r.f = f;
		return r;
	}
	public int indexOf(java.lang.Object p0) {
		return 0;
	}
	public void clear() {
	}
	public int lastIndexOf(java.lang.Object p0) {
		return 0;
	}
	public boolean contains(java.lang.Object p0) {
		return false;
	}
	public int size() {
		return 0;
	}
	public <T> T[] toArray(T[] p0) {
		Object[] r = new Object[1];
		r = p0;
		r[0] = f;
		return (T[])r;
	}
	public java.lang.Object[] toArray() {
		Object[] r = new Object[0];
		r[0] = f;
		return r;
	}
	public boolean addAll(int p0, java.util.Collection<? extends E> p1) {
		f = p1.iterator().next();
		return false;
	}
	public boolean addAll(java.util.Collection<? extends E> p0) {
		f = p0.iterator().next();
		return false;
	}
	public E getFirst() {
		return f;
	}
	public void push(E p0) {
		f = p0;
	}
	public E pop() {
		return f;
	}
	public E poll() {
		return f;
	}
	public E set(int p0, E p1) {
		f = p1;
		return f;
	}
	public E peek() {
		return f;
	}
	public java.util.ListIterator<E> listIterator(int p0) {
		AtlasListIterator<E> r = new AtlasListIterator<E>();
		r.f = f;
		return r;
	}
	public void addFirst(E p0) {
		f = p0;
	}
	public void addLast(E p0) {
		f = p0;
	}
	public boolean offerFirst(E p0) {
		f = p0;
		return false;
	}
	public boolean offerLast(E p0) {
		f = p0;
		return false;
	}
	public E removeFirst() {
		return f;
	}
	public E removeLast() {
		return f;
	}
	public E pollFirst() {
		return f;
	}
	public E pollLast() {
		return f;
	}
	public E getLast() {
		return f;
	}
	public E peekFirst() {
		return f;
	}
	public E peekLast() {
		return f;
	}
	public boolean removeFirstOccurrence(java.lang.Object p0) {
		return false;
	}
	public boolean removeLastOccurrence(java.lang.Object p0) {
		return false;
	}
	public boolean offer(E p0) {
		return false;
	}
	public E element() {
		return f;
	}
	public java.util.Iterator<E> descendingIterator() {
		AtlasIterator<E> r = new AtlasIterator<E>();
		r.f = f;
		return r;
	}
	public boolean containsAll(Collection<?> c) {
		return false;
	}
	public boolean isEmpty() {
		return false;
	}
	public Iterator<E> iterator() {
		AtlasIterator<E> r = new AtlasIterator<E>();
		r.f = f;
		return r;
	}
	public ListIterator<E> listIterator() {
		AtlasListIterator<E> r = new AtlasListIterator<E>();
		r.f = f;
		return r;
	}
	public boolean removeAll(Collection<?> c) {
		return false;
	}
	public boolean retainAll(Collection<?> c) {
		return false;
	}
	public List<E> subList(int fromIndex, int toIndex) {
		ArrayList<E> r = new ArrayList<E>();
		r.f = f;
		return r;
	}
}
