package java.util.concurrent;
public class PriorityBlockingQueue<E> extends java.util.AbstractQueue<E> implements java.util.concurrent.BlockingQueue<E>, java.io.Serializable {
	public java.lang.Object f17;
	public PriorityBlockingQueue(java.util.Collection<? extends E> p0) {
		((java.util.concurrent.PriorityBlockingQueue)this).f17 = p0.iterator().next();
	}
	public PriorityBlockingQueue() {
	}
	public boolean add(E p0) {
		boolean r = false;
		((java.util.concurrent.PriorityBlockingQueue)this).f17 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public boolean remove(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
	}
	public void put(E p0) {
		((java.util.concurrent.PriorityBlockingQueue)this).f17 = (java.lang.Object)p0;
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
	public java.lang.Object[] toArray() {
		java.lang.Object[] r = null;
		r = new java.lang.Object[1];
		((java.lang.Object[])r)[0] = (java.lang.Object)((java.util.concurrent.PriorityBlockingQueue)this).f17;
		return (java.lang.Object[])r;
	}
	public <T> T[] toArray(T[] p0) {
		java.lang.Object[] r = null;
		return (T[])r;
	}
	public java.util.Iterator<E> iterator() {
		java.util.Iterator r = null;
		r = new java.util.concurrent.PriorityBlockingQueue.Itr();
		((java.util.concurrent.PriorityBlockingQueue.Itr)r).f69 = (java.lang.Object)((java.util.concurrent.PriorityBlockingQueue)this).f17;
		return (java.util.Iterator<E>)r;
	}
	public E poll() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.PriorityBlockingQueue)this).f17;
		return (E)r;
	}
	public E poll(long p0, java.util.concurrent.TimeUnit p1) {
		java.lang.Object r = null;
		return (E)r;
	}
	public E peek() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.PriorityBlockingQueue)this).f17;
		return (E)r;
	}
	public java.util.Comparator<? super E> comparator() {
		java.util.Comparator r = null;
		return (java.util.Comparator<? super E>)r;
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
	public boolean offer(E p0, long p1, java.util.concurrent.TimeUnit p2) {
		boolean r = false;
		((java.util.concurrent.PriorityBlockingQueue)this).f17 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public boolean offer(E p0) {
		boolean r = false;
		((java.util.concurrent.PriorityBlockingQueue)this).f17 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public E take() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.PriorityBlockingQueue)this).f17;
		return (E)r;
	}
	public static final class PBQSpliterator<E> {
		public PBQSpliterator() {
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
		public java.lang.Object f69;
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
			r = (java.lang.Object)((java.util.concurrent.PriorityBlockingQueue.Itr)this).f69;
			return (E)r;
		}
	}
	public E remove() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.PriorityBlockingQueue)this).f17;
		return (E)r;
	}
	public E element() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.PriorityBlockingQueue)this).f17;
		return (E)r;
	}
	public boolean addAll(java.util.Collection<? extends E> p0) {
		boolean r = false;
		((java.util.concurrent.PriorityBlockingQueue)this).f17 = p0.iterator().next();
		return (boolean)r;
	}
}
