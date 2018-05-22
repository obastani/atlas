package java.util;
public class ArrayDeque<E> extends java.util.AbstractCollection<E> implements java.util.Deque<E>, java.lang.Cloneable, java.io.Serializable {
	public java.lang.Object f28;
	public ArrayDeque(java.util.Collection<? extends E> p0) {
		((java.util.ArrayDeque)this).f28 = p0.iterator().next();
	}
	public ArrayDeque() {
	}
	public boolean add(E p0) {
		boolean r = false;
		((java.util.ArrayDeque)this).f28 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public boolean remove(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
	}
	public E remove() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.ArrayDeque)this).f28;
		return (E)r;
	}
	public java.util.ArrayDeque<E> clone() {
		java.util.ArrayDeque r = null;
		r = new java.util.ArrayDeque();
		((java.util.ArrayDeque)r).f28 = (java.lang.Object)((java.util.ArrayDeque)this).f28;
		return (java.util.ArrayDeque<E>)r;
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
		r = new java.lang.Object[1];
		((java.lang.Object[])r)[0] = (java.lang.Object)((java.util.ArrayDeque)this).f28;
		return (java.lang.Object[])r;
	}
	public java.util.Iterator<E> iterator() {
		java.util.Iterator r = null;
		r = new java.util.ArrayDeque.DeqIterator();
		((java.util.ArrayDeque.DeqIterator)r).f101 = (java.lang.Object)((java.util.ArrayDeque)this).f28;
		return (java.util.Iterator<E>)r;
	}
	public E getFirst() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.ArrayDeque)this).f28;
		return (E)r;
	}
	public void push(E p0) {
		((java.util.ArrayDeque)this).f28 = (java.lang.Object)p0;
	}
	public E pop() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.ArrayDeque)this).f28;
		return (E)r;
	}
	public E poll() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.ArrayDeque)this).f28;
		return (E)r;
	}
	public E peek() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.ArrayDeque)this).f28;
		return (E)r;
	}
	public void addFirst(E p0) {
		((java.util.ArrayDeque)this).f28 = (java.lang.Object)p0;
	}
	public void addLast(E p0) {
		((java.util.ArrayDeque)this).f28 = (java.lang.Object)p0;
	}
	public boolean offerFirst(E p0) {
		boolean r = false;
		((java.util.ArrayDeque)this).f28 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public boolean offerLast(E p0) {
		boolean r = false;
		((java.util.ArrayDeque)this).f28 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public E removeFirst() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.ArrayDeque)this).f28;
		return (E)r;
	}
	public E removeLast() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.ArrayDeque)this).f28;
		return (E)r;
	}
	public E pollFirst() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.ArrayDeque)this).f28;
		return (E)r;
	}
	public E pollLast() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.ArrayDeque)this).f28;
		return (E)r;
	}
	public E getLast() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.ArrayDeque)this).f28;
		return (E)r;
	}
	public E peekFirst() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.ArrayDeque)this).f28;
		return (E)r;
	}
	public E peekLast() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.ArrayDeque)this).f28;
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
		((java.util.ArrayDeque)this).f28 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public E element() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.ArrayDeque)this).f28;
		return (E)r;
	}
	public java.util.Iterator<E> descendingIterator() {
		java.util.Iterator r = null;
		r = new java.util.ArrayDeque.DescendingIterator();
		((java.util.ArrayDeque.DescendingIterator)r).f121 = (java.lang.Object)((java.util.ArrayDeque)this).f28;
		return (java.util.Iterator<E>)r;
	}
	public static final class DeqSpliterator<E> {
		public DeqSpliterator() {
		}
		public java.util.ArrayDeque.DeqSpliterator<E> trySplit() {
			java.util.ArrayDeque.DeqSpliterator r = null;
			return (java.util.ArrayDeque.DeqSpliterator<E>)r;
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
		public java.lang.Object f121;
		private DescendingIterator(java.util.ArrayDeque p0) {
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
			r = (java.lang.Object)((java.util.ArrayDeque.DescendingIterator)this).f121;
			return (E)r;
		}
	}
	public class DeqIterator implements java.util.Iterator<E> {
		public java.lang.Object f101;
		private DeqIterator(java.util.ArrayDeque p0) {
		}
		public DeqIterator() {
		}
		public void remove() {
		}
		public boolean hasNext() {
			boolean r = false;
			return (boolean)r;
		}
		public E next() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.ArrayDeque.DeqIterator)this).f101;
			return (E)r;
		}
	}
	public class ANON407 {
		ANON407() {
		}
	}
	public boolean addAll(java.util.Collection<? extends E> p0) {
		boolean r = false;
		((java.util.ArrayDeque)this).f28 = p0.iterator().next();
		return (boolean)r;
	}
}
