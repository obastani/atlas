package java.util.concurrent;
public class LinkedBlockingDeque<E> extends java.util.AbstractQueue<E> implements java.util.concurrent.BlockingDeque<E>, java.io.Serializable {
	public java.lang.Object f25;
	public LinkedBlockingDeque(java.util.Collection<? extends E> p0) {
		((java.util.concurrent.LinkedBlockingDeque)this).f25 = p0.iterator().next();
	}
	public LinkedBlockingDeque() {
	}
	public boolean add(E p0) {
		boolean r = false;
		((java.util.concurrent.LinkedBlockingDeque)this).f25 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public boolean remove(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
	}
	public E remove() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.LinkedBlockingDeque)this).f25;
		return (E)r;
	}
	public void put(E p0) {
		((java.util.concurrent.LinkedBlockingDeque)this).f25 = (java.lang.Object)p0;
	}
	public java.lang.String toString() {
		java.lang.String r = null;
		r = new java.lang.String();
		return (java.lang.String)r;
	}
	public void clear() {
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
		r = new java.lang.Object[1];
		((java.lang.Object[])r)[0] = (java.lang.Object)((java.util.concurrent.LinkedBlockingDeque)this).f25;
		return (java.lang.Object[])r;
	}
	public java.util.Iterator<E> iterator() {
		java.util.Iterator r = null;
		r = new java.util.concurrent.LinkedBlockingDeque.Itr();
		((java.util.concurrent.LinkedBlockingDeque.Itr)r).f103 = (java.lang.Object)((java.util.concurrent.LinkedBlockingDeque)this).f25;
		return (java.util.Iterator<E>)r;
	}
	public E getFirst() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.LinkedBlockingDeque)this).f25;
		return (E)r;
	}
	public void push(E p0) {
		((java.util.concurrent.LinkedBlockingDeque)this).f25 = (java.lang.Object)p0;
	}
	public E pop() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.LinkedBlockingDeque)this).f25;
		return (E)r;
	}
	public E poll() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.LinkedBlockingDeque)this).f25;
		return (E)r;
	}
	public E poll(long p0, java.util.concurrent.TimeUnit p1) {
		java.lang.Object r = null;
		return (E)r;
	}
	public E peek() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.LinkedBlockingDeque)this).f25;
		return (E)r;
	}
	public int remainingCapacity() {
		int r = 0;
		return (int)r;
	}
	public int drainTo(java.util.Collection<? super E> p0) {
		int r = 0;
		return (int)r;
	}
	public int drainTo(java.util.Collection<? super E> p0, int p1) {
		int r = 0;
		return (int)r;
	}
	public void putFirst(E p0) {
		((java.util.concurrent.LinkedBlockingDeque)this).f25 = (java.lang.Object)p0;
	}
	public void putLast(E p0) {
		((java.util.concurrent.LinkedBlockingDeque)this).f25 = (java.lang.Object)p0;
	}
	public E takeFirst() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.LinkedBlockingDeque)this).f25;
		return (E)r;
	}
	public E takeLast() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.LinkedBlockingDeque)this).f25;
		return (E)r;
	}
	public void addFirst(E p0) {
		((java.util.concurrent.LinkedBlockingDeque)this).f25 = (java.lang.Object)p0;
	}
	public void addLast(E p0) {
		((java.util.concurrent.LinkedBlockingDeque)this).f25 = (java.lang.Object)p0;
	}
	public boolean offerFirst(E p0) {
		boolean r = false;
		((java.util.concurrent.LinkedBlockingDeque)this).f25 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public boolean offerFirst(E p0, long p1, java.util.concurrent.TimeUnit p2) {
		boolean r = false;
		return (boolean)r;
	}
	public boolean offerLast(E p0) {
		boolean r = false;
		((java.util.concurrent.LinkedBlockingDeque)this).f25 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public boolean offerLast(E p0, long p1, java.util.concurrent.TimeUnit p2) {
		boolean r = false;
		return (boolean)r;
	}
	public E removeFirst() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.LinkedBlockingDeque)this).f25;
		return (E)r;
	}
	public E removeLast() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.LinkedBlockingDeque)this).f25;
		return (E)r;
	}
	public E pollFirst() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.LinkedBlockingDeque)this).f25;
		return (E)r;
	}
	public E pollFirst(long p0, java.util.concurrent.TimeUnit p1) {
		java.lang.Object r = null;
		return (E)r;
	}
	public E pollLast(long p0, java.util.concurrent.TimeUnit p1) {
		java.lang.Object r = null;
		return (E)r;
	}
	public E pollLast() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.LinkedBlockingDeque)this).f25;
		return (E)r;
	}
	public E getLast() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.LinkedBlockingDeque)this).f25;
		return (E)r;
	}
	public E peekFirst() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.LinkedBlockingDeque)this).f25;
		return (E)r;
	}
	public E peekLast() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.LinkedBlockingDeque)this).f25;
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
		((java.util.concurrent.LinkedBlockingDeque)this).f25 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public boolean offer(E p0, long p1, java.util.concurrent.TimeUnit p2) {
		boolean r = false;
		return (boolean)r;
	}
	public E element() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.LinkedBlockingDeque)this).f25;
		return (E)r;
	}
	public java.util.Iterator<E> descendingIterator() {
		java.util.Iterator r = null;
		r = new java.util.concurrent.LinkedBlockingDeque.DescendingItr();
		((java.util.concurrent.LinkedBlockingDeque.DescendingItr)r).f58 = (java.lang.Object)((java.util.concurrent.LinkedBlockingDeque)this).f25;
		return (java.util.Iterator<E>)r;
	}
	public E take() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.LinkedBlockingDeque)this).f25;
		return (E)r;
	}
	public static final class LBDSpliterator<E> {
		LBDSpliterator(java.util.concurrent.LinkedBlockingDeque<E> p0) {
		}
		public LBDSpliterator() {
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
	public class DescendingItr extends java.util.concurrent.LinkedBlockingDeque<E>.AbstractItr {
		public java.lang.Object f58;
		private DescendingItr(java.util.concurrent.LinkedBlockingDeque p0) {
		}
		public DescendingItr() {
		}
	}
	public class Itr extends java.util.concurrent.LinkedBlockingDeque<E>.AbstractItr {
		public java.lang.Object f103;
		private Itr(java.util.concurrent.LinkedBlockingDeque p0) {
		}
		public Itr() {
		}
	}
	public abstract class AbstractItr implements java.util.Iterator<E> {
		AbstractItr(java.util.concurrent.LinkedBlockingDeque p0) {
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
			r = (java.lang.Object)((java.util.concurrent.LinkedBlockingDeque.DescendingItr)this).f58;
			r = (java.lang.Object)((java.util.concurrent.LinkedBlockingDeque.Itr)this).f103;
			return (E)r;
		}
	}
	public static final class Node<E> {
		Node(E p0) {
		}
		public Node() {
		}
	}
	public class ANON277 {
		ANON277() {
		}
	}
	public boolean addAll(java.util.Collection<? extends E> p0) {
		boolean r = false;
		((java.util.concurrent.LinkedBlockingDeque)this).f25 = p0.iterator().next();
		return (boolean)r;
	}
}
