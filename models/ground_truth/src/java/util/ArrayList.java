package java.util;

public class ArrayList<E> extends java.util.AbstractList<E> implements java.util.List<E>, java.util.RandomAccess, java.lang.Cloneable, java.io.Serializable {
	public E f;
	public ArrayList(java.util.Collection<? extends E> p0) {
		f = p0.iterator().next();
	}
	public ArrayList() {
	}
	public boolean add(E p0) {
		f = p0;
		return false;
	}
	public void add(int p0, E p1) {
		f = p1;
	}
	public boolean remove(java.lang.Object p0) {
		return false;
	}
	public E remove(int p0) {
		return f;
	}
	public E get(int p0) {
		return f;
	}
	public java.lang.Object clone() {
		ArrayList<E> r = new ArrayList<E>();
		r.f = f;
		return r;
	}
	public int indexOf(java.lang.Object p0) {
		return 0;
	}
	public void clear() {
	}
	public boolean isEmpty() {
		return false;
	}
	public int lastIndexOf(java.lang.Object p0) {
		return 0;
	}
	public boolean contains(java.lang.Object p0) {
		return false;
	}
	public int size() {
		return 0;
	}
	public java.util.List<E> subList(int p0, int p1) {
		ArrayList<E> r = new ArrayList<E>();
		r.f = f;
		return r;
	}
	public <T> T[] toArray(T[] p0) {
		Object[] r = new Object[1];
		r = p0;
		r[0] = f;
		return (T[])r;
	}
	public Object[] toArray() {
		Object[] r = new Object[1];
		r[0] = f;
		return r;
	}
	public java.util.Iterator<E> iterator() {
		AtlasIterator<E> r = new AtlasIterator<E>();
		r.f = f;
		return r;
	}
	public boolean addAll(int p0, java.util.Collection<? extends E> p1) {
		f = p1.iterator().next();
		return false;
	}
	public boolean addAll(java.util.Collection<? extends E> p0) {
		f = p0.iterator().next();
		return false;
	}
	public E set(int p0, E p1) {
		f = p1;
		return f;
	}
	public void ensureCapacity(int p0) {
	}
	public void trimToSize() {
	}
	public boolean removeAll(java.util.Collection<?> p0) {
		return false;
	}
	public boolean retainAll(java.util.Collection<?> p0) {
		return false;
	}
	protected void removeRange(int p0, int p1) {
	}
	public java.util.ListIterator<E> listIterator() {
		AtlasListIterator<E> r = new AtlasListIterator<E>();
		r.f = f;
		return r;
	}
	public java.util.ListIterator<E> listIterator(int p0) {
		AtlasListIterator<E> r = new AtlasListIterator<E>();
		r.f = f;
		return r;
	}
	public void sort(java.util.Comparator<? super E> p0) {
	}
	public boolean containsAll(java.util.Collection<?> c) {
		return false;
	}
}
