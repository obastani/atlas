package java.util.concurrent;
public class ArrayBlockingQueue<E> extends java.util.AbstractQueue<E> implements java.util.concurrent.BlockingQueue<E>, java.io.Serializable {
	public ArrayBlockingQueue() {
	}
	public boolean add(E p0) {
		boolean r = false;
		return (boolean)r;
	}
	public boolean remove(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
	}
	public void put(E p0) {
	}
	public java.lang.String toString() {
		java.lang.String r = null;
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
		return (java.lang.Object[])r;
	}
	public <T> T[] toArray(T[] p0) {
		java.lang.Object[] r = null;
		return (T[])r;
	}
	public java.util.Iterator<E> iterator() {
		java.util.Iterator r = null;
		return (java.util.Iterator<E>)r;
	}
	public E poll(long p0, java.util.concurrent.TimeUnit p1) {
		java.lang.Object r = null;
		return (E)r;
	}
	public E poll() {
		java.lang.Object r = null;
		return (E)r;
	}
	public E peek() {
		java.lang.Object r = null;
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
	public boolean offer(E p0, long p1, java.util.concurrent.TimeUnit p2) {
		boolean r = false;
		return (boolean)r;
	}
	public boolean offer(E p0) {
		boolean r = false;
		return (boolean)r;
	}
	public E take() {
		java.lang.Object r = null;
		return (E)r;
	}
	public class Itr implements java.util.Iterator<E> {
		Itr(java.util.concurrent.ArrayBlockingQueue p0) {
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
			return (E)r;
		}
	}
	public class Itrs {
		public Itrs() {
		}
		public class Node extends java.lang.ref.WeakReference<java.util.concurrent.ArrayBlockingQueue<E>.Itr> {
			public Node() {
				super(null);
			}
		}
	}
}
