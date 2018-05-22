package java.util;
public class Stack<E> extends java.util.Vector<E> {
	public E push(E p0) {
		f = p0;
		return f;
	}
	public synchronized E pop() {
		return f;
	}
	public synchronized E peek() {
		return f;
	}
	public boolean empty() {
		return false;
	}
	public synchronized int search(java.lang.Object p0) {
		return 0;
	}
}
