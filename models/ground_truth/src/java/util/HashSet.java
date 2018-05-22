package java.util;
public class HashSet<E> extends java.util.AbstractSet<E> implements java.util.Set<E>, java.lang.Cloneable, java.io.Serializable {
	public E f;
	public HashSet(java.util.Collection<? extends E> p0) {
		f = p0.iterator().next();
	}
	public HashSet() {
	}
	public boolean add(E p0) {
		f = p0;
		return false;
	}
	public boolean remove(java.lang.Object p0) {
		return false;
	}
	public java.lang.Object clone() {
		HashSet<E> r = new HashSet<E>();
		r.f = f;
		return r;
	}
	public void clear() {
	}
	public boolean isEmpty() {
		return false;
	}
	public boolean contains(java.lang.Object p0) {
		return false;
	}
	public int size() {
		return 0;
	}
	public java.util.Iterator<E> iterator() {
		AtlasIterator<E> r = new AtlasIterator<E>();
		r.f = f;
		return r;
	}
	public boolean addAll(java.util.Collection<? extends E> c) {
		f = c.iterator().next();
		return false;
	}
	public boolean containsAll(java.util.Collection<?> c) {
		return false;
	}
	public boolean removeAll(java.util.Collection<?> c) {
		return false;
	}
	public boolean retainAll(java.util.Collection<?> c) {
		return false;
	}
	public Object[] toArray() {
		Object[] r = new Object[1];
		r[0] = f;
		return r;
	}
	public <T> T[] toArray(T[] a) {
		Object[] r = new Object[1];
		r = a;
		r[0] = f;
		return (T[])r;
	}
}
