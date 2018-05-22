package java.util.concurrent;
public class LinkedTransferQueue<E> extends java.util.AbstractQueue<E> implements java.io.Serializable {
	public java.lang.Object f15;
	public LinkedTransferQueue(java.util.Collection<? extends E> p0) {
		((java.util.concurrent.LinkedTransferQueue)this).f15 = p0.iterator().next();
	}
	public LinkedTransferQueue() {
	}
	public boolean add(E p0) {
		boolean r = false;
		((java.util.concurrent.LinkedTransferQueue)this).f15 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public boolean remove(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
	}
	public void put(E p0) {
		((java.util.concurrent.LinkedTransferQueue)this).f15 = (java.lang.Object)p0;
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
		r = new java.util.concurrent.LinkedTransferQueue.Itr();
		((java.util.concurrent.LinkedTransferQueue.Itr)r).f59 = (java.lang.Object)((java.util.concurrent.LinkedTransferQueue)this).f15;
		return (java.util.Iterator<E>)r;
	}
	public E poll() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.LinkedTransferQueue)this).f15;
		return (E)r;
	}
	public E poll(long p0, java.util.concurrent.TimeUnit p1) {
		java.lang.Object r = null;
		return (E)r;
	}
	public E peek() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.LinkedTransferQueue)this).f15;
		return (E)r;
	}
	public void transfer(E p0) {
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
	public boolean tryTransfer(E p0, long p1, java.util.concurrent.TimeUnit p2) {
		boolean r = false;
		return (boolean)r;
	}
	public boolean tryTransfer(E p0) {
		boolean r = false;
		return (boolean)r;
	}
	public boolean hasWaitingConsumer() {
		boolean r = false;
		return (boolean)r;
	}
	public int getWaitingConsumerCount() {
		int r = 0;
		return (int)r;
	}
	public boolean offer(E p0) {
		boolean r = false;
		((java.util.concurrent.LinkedTransferQueue)this).f15 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public boolean offer(E p0, long p1, java.util.concurrent.TimeUnit p2) {
		boolean r = false;
		((java.util.concurrent.LinkedTransferQueue)this).f15 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public E take() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.LinkedTransferQueue)this).f15;
		return (E)r;
	}
	public static final class LTQSpliterator<E> {
		LTQSpliterator(java.util.concurrent.LinkedTransferQueue<E> p0) {
		}
		public LTQSpliterator() {
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
		public java.lang.Object f59;
		Itr(java.util.concurrent.LinkedTransferQueue p0) {
		}
		public Itr() {
		}
		public final void remove() {
		}
		public final boolean hasNext() {
			boolean r = false;
			return (boolean)r;
		}
		public final E next() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.concurrent.LinkedTransferQueue.Itr)this).f59;
			return (E)r;
		}
	}
	public static final class Node {
		public Node() {
		}
	}
	public <T> T[] toArray(T[] p0) {
		java.lang.Object[] r = null;
		r = new java.lang.Object[1];
		((java.lang.Object[])r)[0] = (java.lang.Object)((java.util.concurrent.LinkedTransferQueue)this).f15;
		return (T[])r;
	}
	public java.lang.Object[] toArray() {
		java.lang.Object[] r = null;
		r = new java.lang.Object[1];
		((java.lang.Object[])r)[0] = (java.lang.Object)((java.util.concurrent.LinkedTransferQueue)this).f15;
		return (java.lang.Object[])r;
	}
	public E remove() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.LinkedTransferQueue)this).f15;
		return (E)r;
	}
	public E element() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.LinkedTransferQueue)this).f15;
		return (E)r;
	}
	public boolean addAll(java.util.Collection<? extends E> p0) {
		boolean r = false;
		((java.util.concurrent.LinkedTransferQueue)this).f15 = p0.iterator().next();
		return (boolean)r;
	}
}
