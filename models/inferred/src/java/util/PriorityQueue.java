package java.util;
public class PriorityQueue<E> extends java.util.AbstractQueue<E> implements java.io.Serializable {
	public java.lang.Object f37;
	public PriorityQueue(java.util.Collection<? extends E> p0) {
		((java.util.PriorityQueue)this).f37 = p0.iterator().next();
	}
	public PriorityQueue(java.util.PriorityQueue<? extends E> p0) {
		((java.util.PriorityQueue)this).f37 = (java.lang.Object)((java.util.PriorityQueue)p0).f37;
	}
	public PriorityQueue(java.util.SortedSet<? extends E> p0) {
		((java.util.PriorityQueue)this).f37 = (java.lang.Object)((java.util.TreeSet)p0).f5;
		((java.util.PriorityQueue)this).f37 = (java.lang.Object)((java.util.concurrent.ConcurrentSkipListSet)p0).f1;
	}
	public PriorityQueue(java.util.Comparator<? super E> p0) {
	}
	public PriorityQueue() {
	}
	public boolean add(E p0) {
		boolean r = false;
		((java.util.PriorityQueue)this).f37 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public boolean remove(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
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
	public java.lang.Object[] toArray() {
		java.lang.Object[] r = null;
		r = new java.lang.Object[1];
		((java.lang.Object[])r)[0] = (java.lang.Object)((java.util.PriorityQueue)this).f37;
		return (java.lang.Object[])r;
	}
	public <T> T[] toArray(T[] p0) {
		java.lang.Object[] r = null;
		r = new java.lang.Object[1];
		((java.lang.Object[])r)[0] = (java.lang.Object)((java.util.PriorityQueue)this).f37;
		return (T[])r;
	}
	public java.util.Iterator<E> iterator() {
		java.util.Iterator r = null;
		r = new java.util.PriorityQueue.Itr();
		((java.util.PriorityQueue.Itr)r).f150 = (java.lang.Object)((java.util.PriorityQueue)this).f37;
		return (java.util.Iterator<E>)r;
	}
	public E poll() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.PriorityQueue)this).f37;
		return (E)r;
	}
	public E peek() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.PriorityQueue)this).f37;
		return (E)r;
	}
	public java.util.Comparator<? super E> comparator() {
		java.util.Comparator r = null;
		return (java.util.Comparator<? super E>)r;
	}
	public boolean offer(E p0) {
		boolean r = false;
		((java.util.PriorityQueue)this).f37 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public static final class PriorityQueueSpliterator<E> {
		public PriorityQueueSpliterator() {
		}
		public java.util.PriorityQueue.PriorityQueueSpliterator<E> trySplit() {
			java.util.PriorityQueue.PriorityQueueSpliterator r = null;
			return (java.util.PriorityQueue.PriorityQueueSpliterator<E>)r;
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
	public final class Itr implements java.util.Iterator<E> {
		public java.lang.Object f150;
		private Itr(java.util.PriorityQueue p0) {
		}
		public Itr() {
		}
		public void remove() {
		}
		public boolean hasNext() {
			boolean r = false;
			return (boolean)r;
		}
		public E next() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.PriorityQueue.Itr)this).f150;
			return (E)r;
		}
	}
	public class ANON248 {
		ANON248() {
		}
	}
	public E remove() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.PriorityQueue)this).f37;
		return (E)r;
	}
	public E element() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.PriorityQueue)this).f37;
		return (E)r;
	}
	public boolean addAll(java.util.Collection<? extends E> p0) {
		boolean r = false;
		((java.util.PriorityQueue)this).f37 = p0.iterator().next();
		return (boolean)r;
	}
}
