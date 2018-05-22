package java.util;

public class AtlasEnumeration<E> implements java.util.Enumeration<E> {
	public E f;
	public boolean hasMoreElements() {
		return false;
	}
	public E nextElement() {
		return f;
	}
}
