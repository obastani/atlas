package java.util.concurrent;
public class LinkedBlockingQueue<E> extends java.util.AbstractQueue<E> implements java.util.concurrent.BlockingQueue<E>, java.io.Serializable {
	public java.lang.Object f33;
	public LinkedBlockingQueue(java.util.Collection<? extends E> p0) {
		((java.util.concurrent.LinkedBlockingQueue)this).f33 = p0.iterator().next();
	}
	public LinkedBlockingQueue() {
	}
	public boolean remove(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
	}
	public void put(E p0) {
		((java.util.concurrent.LinkedBlockingQueue)this).f33 = (java.lang.Object)p0;
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
		r = new java.lang.Object[1];
		((java.lang.Object[])r)[0] = (java.lang.Object)((java.util.concurrent.LinkedBlockingQueue)this).f33;
		return (T[])r;
	}
	public java.lang.Object[] toArray() {
		java.lang.Object[] r = null;
		r = new java.lang.Object[1];
		((java.lang.Object[])r)[0] = (java.lang.Object)((java.util.concurrent.LinkedBlockingQueue)this).f33;
		return (java.lang.Object[])r;
	}
	public java.util.Iterator<E> iterator() {
		java.util.Iterator r = null;
		r = new java.util.concurrent.LinkedBlockingQueue.Itr();
		((java.util.concurrent.LinkedBlockingQueue.Itr)r).f115 = (java.lang.Object)((java.util.concurrent.LinkedBlockingQueue)this).f33;
		return (java.util.Iterator<E>)r;
	}
	public E poll() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.LinkedBlockingQueue)this).f33;
		return (E)r;
	}
	public E poll(long p0, java.util.concurrent.TimeUnit p1) {
		java.lang.Object r = null;
		return (E)r;
	}
	public E peek() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.LinkedBlockingQueue)this).f33;
		return (E)r;
	}
	public int remainingCapacity() {
		int r = 0;
		return (int)r;
	}
	public int drainTo(java.util.Collection<? super E> p0, int p1) {
		int r = 0;
		return (int)r;
	}
	public int drainTo(java.util.Collection<? super E> p0) {
		int r = 0;
		return (int)r;
	}
	public boolean offer(E p0) {
		boolean r = false;
		((java.util.concurrent.LinkedBlockingQueue)this).f33 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public boolean offer(E p0, long p1, java.util.concurrent.TimeUnit p2) {
		boolean r = false;
		return (boolean)r;
	}
	public E take() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.LinkedBlockingQueue)this).f33;
		return (E)r;
	}
	public static final class LBQSpliterator<E> {
		LBQSpliterator(java.util.concurrent.LinkedBlockingQueue<E> p0) {
		}
		public LBQSpliterator() {
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
	public class Itr implements java.util.Iterator<E> {
		public java.lang.Object f115;
		Itr(java.util.concurrent.LinkedBlockingQueue p0) {
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
			r = (java.lang.Object)((java.util.concurrent.LinkedBlockingQueue.Itr)this).f115;
			return (E)r;
		}
	}
	public static class Node<E> {
		Node(E p0) {
		}
		public Node() {
		}
	}
	public boolean add(E p0) {
		boolean r = false;
		((java.util.concurrent.LinkedBlockingQueue)this).f33 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public E remove() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.LinkedBlockingQueue)this).f33;
		return (E)r;
	}
	public E element() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.LinkedBlockingQueue)this).f33;
		return (E)r;
	}
	public boolean addAll(java.util.Collection<? extends E> p0) {
		boolean r = false;
		((java.util.concurrent.LinkedBlockingQueue)this).f33 = p0.iterator().next();
		return (boolean)r;
	}
}
