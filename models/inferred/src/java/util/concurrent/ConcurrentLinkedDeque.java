package java.util.concurrent;
public class ConcurrentLinkedDeque<E> extends java.util.AbstractCollection<E> implements java.util.Deque<E>, java.io.Serializable {
	public java.lang.Object f4;
	public ConcurrentLinkedDeque(java.util.Collection<? extends E> p0) {
		((java.util.concurrent.ConcurrentLinkedDeque)this).f4 = p0.iterator().next();
	}
	public ConcurrentLinkedDeque() {
	}
	public boolean add(E p0) {
		boolean r = false;
		((java.util.concurrent.ConcurrentLinkedDeque)this).f4 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public boolean remove(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
	}
	public E remove() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentLinkedDeque)this).f4;
		return (E)r;
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
		r = new java.lang.Object[1];
		return (java.lang.Object[])r;
	}
	public <T> T[] toArray(T[] p0) {
		java.lang.Object[] r = null;
		return (T[])r;
	}
	public java.util.Iterator<E> iterator() {
		java.util.Iterator r = null;
		r = new java.util.concurrent.ConcurrentLinkedDeque.Itr();
		((java.util.concurrent.ConcurrentLinkedDeque.Itr)r).f99 = (java.lang.Object)((java.util.concurrent.ConcurrentLinkedDeque)this).f4;
		return (java.util.Iterator<E>)r;
	}
	public boolean addAll(java.util.Collection<? extends E> p0) {
		boolean r = false;
		((java.util.concurrent.ConcurrentLinkedDeque)this).f4 = p0.iterator().next();
		return (boolean)r;
	}
	public E getFirst() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentLinkedDeque)this).f4;
		return (E)r;
	}
	public void push(E p0) {
		((java.util.concurrent.ConcurrentLinkedDeque)this).f4 = (java.lang.Object)p0;
	}
	public E pop() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentLinkedDeque)this).f4;
		return (E)r;
	}
	public E poll() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentLinkedDeque)this).f4;
		return (E)r;
	}
	public E peek() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentLinkedDeque)this).f4;
		return (E)r;
	}
	public void addFirst(E p0) {
		((java.util.concurrent.ConcurrentLinkedDeque)this).f4 = (java.lang.Object)p0;
	}
	public void addLast(E p0) {
		((java.util.concurrent.ConcurrentLinkedDeque)this).f4 = (java.lang.Object)p0;
	}
	public boolean offerFirst(E p0) {
		boolean r = false;
		((java.util.concurrent.ConcurrentLinkedDeque)this).f4 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public boolean offerLast(E p0) {
		boolean r = false;
		((java.util.concurrent.ConcurrentLinkedDeque)this).f4 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public E removeFirst() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentLinkedDeque)this).f4;
		return (E)r;
	}
	public E removeLast() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentLinkedDeque)this).f4;
		return (E)r;
	}
	public E pollFirst() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentLinkedDeque)this).f4;
		return (E)r;
	}
	public E pollLast() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentLinkedDeque)this).f4;
		return (E)r;
	}
	public E getLast() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentLinkedDeque)this).f4;
		return (E)r;
	}
	public E peekFirst() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentLinkedDeque)this).f4;
		return (E)r;
	}
	public E peekLast() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentLinkedDeque)this).f4;
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
		((java.util.concurrent.ConcurrentLinkedDeque)this).f4 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public E element() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentLinkedDeque)this).f4;
		return (E)r;
	}
	public java.util.Iterator<E> descendingIterator() {
		java.util.Iterator r = null;
		r = new java.util.concurrent.ConcurrentLinkedDeque.DescendingItr();
		((java.util.concurrent.ConcurrentLinkedDeque.DescendingItr)r).f123 = (java.lang.Object)((java.util.concurrent.ConcurrentLinkedDeque)this).f4;
		return (java.util.Iterator<E>)r;
	}
	public static final class CLDSpliterator<E> {
		CLDSpliterator(java.util.concurrent.ConcurrentLinkedDeque<E> p0) {
		}
		public CLDSpliterator() {
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
	public class DescendingItr extends java.util.concurrent.ConcurrentLinkedDeque<E>.AbstractItr {
		public java.lang.Object f123;
		private DescendingItr(java.util.concurrent.ConcurrentLinkedDeque p0) {
		}
		public DescendingItr() {
		}
	}
	public class Itr extends java.util.concurrent.ConcurrentLinkedDeque<E>.AbstractItr {
		public java.lang.Object f99;
		private Itr(java.util.concurrent.ConcurrentLinkedDeque p0) {
		}
		public Itr() {
		}
	}
	public abstract class AbstractItr implements java.util.Iterator<E> {
		AbstractItr(java.util.concurrent.ConcurrentLinkedDeque p0) {
		}
		public AbstractItr() {
		}
		public void remove() {
		}
		public boolean hasNext() {
			boolean r = false;
			return (boolean)r;
		}
		public E next() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.concurrent.ConcurrentLinkedDeque.Itr)this).f99;
			r = (java.lang.Object)((java.util.concurrent.ConcurrentLinkedDeque.DescendingItr)this).f123;
			return (E)r;
		}
	}
	public static final class Node<E> {
		Node(E p0) {
		}
		public Node() {
		}
	}
	public class ANON370 {
		ANON370() {
		}
	}
}
