package java.util;

import java.util.LinkedList.ListItr;

public class LinkedList<E> extends java.util.AbstractSequentialList<E> implements java.util.List<E>, java.util.Deque<E>, java.lang.Cloneable, java.io.Serializable {
	public java.lang.Object f14;
	public LinkedList(java.util.Collection<? extends E> p0) {
		((java.util.LinkedList)this).f14 = p0.iterator().next();
	}
	public LinkedList() {
	}
	public boolean add(E p0) {
		boolean r = false;
		((java.util.LinkedList)this).f14 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public void add(int p0, E p1) {
		((java.util.LinkedList)this).f14 = (java.lang.Object)p1;
	}
	public boolean remove(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
	}
	public E remove() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.LinkedList)this).f14;
		return (E)r;
	}
	public E remove(int p0) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.LinkedList)this).f14;
		return (E)r;
	}
	public E get(int p0) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.LinkedList)this).f14;
		return (E)r;
	}
	public java.lang.Object clone() {
		java.lang.Object r = null;
		r = new java.util.LinkedList();
		((java.util.LinkedList)r).f14 = (java.lang.Object)((java.util.LinkedList)this).f14;
		return (java.lang.Object)r;
	}
	public int indexOf(java.lang.Object p0) {
		int r = 0;
		return (int)r;
	}
	public void clear() {
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
	public <T> T[] toArray(T[] p0) {
		java.lang.Object[] r = null;
		r = new java.lang.Object[1];
		((java.lang.Object[])r)[0] = (java.lang.Object)((java.util.LinkedList)this).f14;
		return (T[])r;
	}
	public java.lang.Object[] toArray() {
		java.lang.Object[] r = null;
		r = new java.lang.Object[1];
		((java.lang.Object[])r)[0] = (java.lang.Object)((java.util.LinkedList)this).f14;
		return (java.lang.Object[])r;
	}
	public boolean addAll(int p0, java.util.Collection<? extends E> p1) {
		boolean r = false;
		((java.util.LinkedList)this).f14 = p1.iterator().next();
		return (boolean)r;
	}
	public boolean addAll(java.util.Collection<? extends E> p0) {
		boolean r = false;
		((java.util.LinkedList)this).f14 = p0.iterator().next();
		return (boolean)r;
	}
	public E getFirst() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.LinkedList)this).f14;
		return (E)r;
	}
	public void push(E p0) {
		((java.util.LinkedList)this).f14 = (java.lang.Object)p0;
	}
	public E pop() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.LinkedList)this).f14;
		return (E)r;
	}
	public E poll() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.LinkedList)this).f14;
		return (E)r;
	}
	public E set(int p0, E p1) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.LinkedList)this).f14;
		return (E)r;
	}
	public E peek() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.LinkedList)this).f14;
		return (E)r;
	}
	public java.util.ListIterator<E> listIterator(int p0) {
		java.util.ListIterator r = null;
		r = new java.util.LinkedList.ListItr();
		((java.util.LinkedList.ListItr)r).f48 = (java.lang.Object)((java.util.LinkedList)this).f14;
		return (java.util.ListIterator<E>)r;
	}
	public void addFirst(E p0) {
		((java.util.LinkedList)this).f14 = (java.lang.Object)p0;
	}
	public void addLast(E p0) {
		((java.util.LinkedList)this).f14 = (java.lang.Object)p0;
	}
	public boolean offerFirst(E p0) {
		boolean r = false;
		((java.util.LinkedList)this).f14 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public boolean offerLast(E p0) {
		boolean r = false;
		((java.util.LinkedList)this).f14 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public E removeFirst() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.LinkedList)this).f14;
		return (E)r;
	}
	public E removeLast() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.LinkedList)this).f14;
		return (E)r;
	}
	public E pollFirst() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.LinkedList)this).f14;
		return (E)r;
	}
	public E pollLast() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.LinkedList)this).f14;
		return (E)r;
	}
	public E getLast() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.LinkedList)this).f14;
		return (E)r;
	}
	public E peekFirst() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.LinkedList)this).f14;
		return (E)r;
	}
	public E peekLast() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.LinkedList)this).f14;
		return (E)r;
	}
	public boolean removeFirstOccurrence(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
	}
	public boolean removeLastOccurrence(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
	}
	public boolean offer(E p0) {
		boolean r = false;
		((java.util.LinkedList)this).f14 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public E element() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.LinkedList)this).f14;
		return (E)r;
	}
	public java.util.Iterator<E> descendingIterator() {
		java.util.Iterator r = null;
		r = new java.util.LinkedList.DescendingIterator();
		((java.util.LinkedList.DescendingIterator)r).f114 = (java.lang.Object)((java.util.LinkedList)this).f14;
		return (java.util.Iterator<E>)r;
	}
	public static final class LLSpliterator<E> {
		public LLSpliterator() {
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
	public class DescendingIterator implements java.util.Iterator<E> {
		public java.lang.Object f114;
		private DescendingIterator(java.util.LinkedList p0) {
		}
		public DescendingIterator() {
		}
		public void remove() {
		}
		public boolean hasNext() {
			boolean r = false;
			return (boolean)r;
		}
		public E next() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.LinkedList.DescendingIterator)this).f114;
			return (E)r;
		}
	}
	public static class Node<E> {
		Node(java.util.LinkedList.Node<E> p0, E p1, java.util.LinkedList.Node<E> p2) {
		}
		public Node() {
		}
	}
	public class ListItr implements java.util.ListIterator<E> {
		public java.lang.Object f48;
		public ListItr() {
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
			r = (java.lang.Object)((java.util.LinkedList.ListItr)this).f48;
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
	public class ANON59 {
		ANON59() {
		}
	}
	public java.util.ListIterator<E> listIterator() {
		java.util.ListIterator r = null;
		r = new java.util.AtlasAbstractList.ListItr();
		r = new java.util.LinkedList().new ListItr();
		((java.util.LinkedList.ListItr)r).f48 = (java.lang.Object)((java.util.LinkedList)this).f14;
		return (java.util.ListIterator<E>)r;
	}
	public java.util.Iterator<E> iterator() {
		java.util.Iterator r = null;
		r = new java.util.LinkedList().new ListItr();
		((java.util.LinkedList.ListItr)r).f48 = (java.lang.Object)((java.util.LinkedList)this).f14;
		return (java.util.Iterator<E>)r;
	}
}
