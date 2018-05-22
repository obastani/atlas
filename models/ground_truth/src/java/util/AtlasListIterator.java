package java.util;

public class AtlasListIterator<E> implements java.util.ListIterator<E> {
	public E f;
	public boolean hasNext() {
		return false;
	}
	public E next() {
		return f;
	}
	public boolean hasPrevious() {
		return false;
	}
	public E previous() {
		return f;
	}
	public int nextIndex() {
		return 0;
	}
	public int previousIndex() {
		return 0;
	}
	public void remove() {
	}
	public void set(E e) {
		f = e;
	}
	public void add(E e) {
		f = e;
	}
}
