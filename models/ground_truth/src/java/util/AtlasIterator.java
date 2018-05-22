package java.util;

public class AtlasIterator<E> implements java.util.Iterator<E> {
	public E f;
	public boolean hasNext() {
		return false;
	}
	public E next() {
		return f;
	}
	public void remove() {
	}
}
