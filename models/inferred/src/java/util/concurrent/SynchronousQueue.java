package java.util.concurrent;
public class SynchronousQueue<E> extends java.util.AbstractQueue<E> implements java.util.concurrent.BlockingQueue<E>, java.io.Serializable {
	public SynchronousQueue() {
	}
	public boolean remove(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
	}
	public void put(E p0) {
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
		r = new java.util.Collections.EmptyIterator();
		return (java.util.Iterator<E>)r;
	}
	public E poll() {
		java.lang.Object r = null;
		return (E)r;
	}
	public E poll(long p0, java.util.concurrent.TimeUnit p1) {
		java.lang.Object r = null;
		return (E)r;
	}
	public E peek() {
		java.lang.Object r = null;
		return (E)r;
	}
	public boolean containsAll(java.util.Collection<?> p0) {
		boolean r = false;
		return (boolean)r;
	}
	public boolean removeAll(java.util.Collection<?> p0) {
		boolean r = false;
		return (boolean)r;
	}
	public boolean retainAll(java.util.Collection<?> p0) {
		boolean r = false;
		return (boolean)r;
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
		return (boolean)r;
	}
	public boolean offer(E p0, long p1, java.util.concurrent.TimeUnit p2) {
		boolean r = false;
		return (boolean)r;
	}
	public E take() {
		java.lang.Object r = null;
		return (E)r;
	}
	public static class FifoWaitQueue extends java.util.concurrent.SynchronousQueue.WaitQueue {
		public FifoWaitQueue() {
		}
	}
	public static class LifoWaitQueue extends java.util.concurrent.SynchronousQueue.WaitQueue {
		public LifoWaitQueue() {
		}
	}
	public static class WaitQueue implements java.io.Serializable {
		public WaitQueue() {
		}
	}
	public static final class TransferQueue<E> extends java.util.concurrent.SynchronousQueue.Transferer<E> {
		public TransferQueue() {
		}
		public static final class QNode {
			public QNode() {
			}
		}
	}
	public static final class TransferStack<E> extends java.util.concurrent.SynchronousQueue.Transferer<E> {
		public TransferStack() {
		}
		public static final class SNode {
			SNode(java.lang.Object p0) {
			}
			public SNode() {
			}
		}
	}
	public abstract static class Transferer<E> {
		public Transferer() {
		}
	}
}
