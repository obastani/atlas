package java.util;
public class Stack<E> extends java.util.Vector<E> {
	public java.lang.Object f26;
	public Stack() {
	}
	public E push(E p0) {
		java.lang.Object r = null;
		((java.util.Stack)this).f26 = (java.lang.Object)p0;
		return (E)r;
	}
	public synchronized E pop() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.Stack)this).f26;
		return (E)r;
	}
	public synchronized E peek() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.Stack)this).f26;
		return (E)r;
	}
	public boolean empty() {
		boolean r = false;
		return (boolean)r;
	}
	public synchronized int search(java.lang.Object p0) {
		int r = 0;
		return (int)r;
	}
}
