package java.util.concurrent;
public class ConcurrentLinkedQueue<E> extends java.util.AbstractQueue<E> implements java.util.Queue<E>, java.io.Serializable {
	public java.lang.Object f6;
	public ConcurrentLinkedQueue(java.util.Collection<? extends E> p0) {
		((java.util.concurrent.ConcurrentLinkedQueue)this).f6 = p0.iterator().next();
	}
	public ConcurrentLinkedQueue() {
	}
	public boolean add(E p0) {
		boolean r = false;
		((java.util.concurrent.ConcurrentLinkedQueue)this).f6 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public boolean remove(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
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
		r = new java.lang.Object[1];
		((java.lang.Object[])r)[0] = (java.lang.Object)((java.util.concurrent.ConcurrentLinkedQueue)this).f6;
		return (T[])r;
	}
	public java.lang.Object[] toArray() {
		java.lang.Object[] r = null;
		r = new java.lang.Object[1];
		((java.lang.Object[])r)[0] = (java.lang.Object)((java.util.concurrent.ConcurrentLinkedQueue)this).f6;
		return (java.lang.Object[])r;
	}
	public java.util.Iterator<E> iterator() {
		java.util.Iterator r = null;
		r = new java.util.concurrent.ConcurrentLinkedQueue.Itr();
		((java.util.concurrent.ConcurrentLinkedQueue.Itr)r).f96 = (java.lang.Object)((java.util.concurrent.ConcurrentLinkedQueue)this).f6;
		return (java.util.Iterator<E>)r;
	}
	public boolean addAll(java.util.Collection<? extends E> p0) {
		boolean r = false;
		((java.util.concurrent.ConcurrentLinkedQueue)this).f6 = p0.iterator().next();
		return (boolean)r;
	}
	public E poll() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentLinkedQueue)this).f6;
		return (E)r;
	}
	public E peek() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentLinkedQueue)this).f6;
		return (E)r;
	}
	public boolean offer(E p0) {
		boolean r = false;
		((java.util.concurrent.ConcurrentLinkedQueue)this).f6 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public static final class CLQSpliterator<E> {
		CLQSpliterator(java.util.concurrent.ConcurrentLinkedQueue<E> p0) {
		}
		public CLQSpliterator() {
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
		public java.lang.Object f96;
		Itr(java.util.concurrent.ConcurrentLinkedQueue p0) {
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
			r = (java.lang.Object)((java.util.concurrent.ConcurrentLinkedQueue.Itr)this).f96;
			return (E)r;
		}
	}
	public static class Node<E> {
		Node(E p0) {
		}
		public Node() {
		}
	}
	public E remove() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentLinkedQueue)this).f6;
		return (E)r;
	}
	public E element() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.ConcurrentLinkedQueue)this).f6;
		return (E)r;
	}
}
