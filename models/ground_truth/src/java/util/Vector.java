package java.util;
public class Vector<E> extends java.util.AbstractList<E> implements java.util.List<E>, java.util.RandomAccess, java.lang.Cloneable, java.io.Serializable {
	public E f;
	public Vector(java.util.Collection<? extends E> p0) {
		f = p0.iterator().next();
	}
	public Vector() {
	}
	public synchronized boolean add(E p0) {
		f = p0;
		return false;
	}
	public void add(int p0, E p1) {
		f = p1;
	}
	public synchronized E remove(int p0) {
		return f;
	}
	public boolean remove(java.lang.Object p0) {
		return false;
	}
	public synchronized E get(int p0) {
		return f;
	}
	public synchronized boolean equals(java.lang.Object p0) {
		return false;
	}
	public synchronized java.lang.String toString() {
		return "";
	}
	public synchronized int hashCode() {
		return 0;
	}
	public synchronized java.lang.Object clone() {
		Vector<E> r = new Vector<E>();
		r.f = f;
		return r;
	}
	public synchronized int indexOf(java.lang.Object p0, int p1) {
		return 0;
	}
	public int indexOf(java.lang.Object p0) {
		return 0;
	}
	public void clear() {
	}
	public synchronized boolean isEmpty() {
		return false;
	}
	public synchronized int lastIndexOf(java.lang.Object p0, int p1) {
		return 0;
	}
	public synchronized int lastIndexOf(java.lang.Object p0) {
		return 0;
	}
	public boolean contains(java.lang.Object p0) {
		return false;
	}
	public synchronized int size() {
		return 0;
	}
	public synchronized java.util.List<E> subList(int p0, int p1) {
		ArrayList<E> r = new ArrayList<E>();
		r.f = f;
		return r;
	}
	public synchronized <T> T[] toArray(T[] p0) {
		Object[] r = new Object[1];
		r = p0;
		r[0] = f;
		return (T[])r;
	}
	public synchronized java.lang.Object[] toArray() {
		Object[] r = new Object[1];
		r[0] = f;
		return r;
	}
	public synchronized java.util.Iterator<E> iterator() {
		AtlasIterator<E> r = new AtlasIterator<E>();
		r.f = f;
		return r;
	}
	public synchronized boolean addAll(java.util.Collection<? extends E> p0) {
		f = p0.iterator().next();
		return false;
	}
	public synchronized boolean addAll(int p0, java.util.Collection<? extends E> p1) {
		f = p1.iterator().next();
		return false;
	}
	public synchronized void addElement(E p0) {
		f = p0;
	}
	public synchronized E elementAt(int p0) {
		return f;
	}
	public java.util.Enumeration<E> elements() {
		AtlasEnumeration<E> r = new AtlasEnumeration<E>();
		r.f = f;
		return r;
	}
	public synchronized E set(int p0, E p1) {
		f = p1;
		return f;
	}
	public synchronized int capacity() {
		return 0;
	}
	public synchronized void ensureCapacity(int p0) {
	}
	public synchronized void trimToSize() {
	}
	public synchronized void copyInto(java.lang.Object[] p0) {
		p0[0] = f;
	}
	public synchronized void setSize(int p0) {
	}
	public synchronized E firstElement() {
		return f;
	}
	public synchronized E lastElement() {
		return f;
	}
	public synchronized void setElementAt(E p0, int p1) {
		f = p0;
	}
	public synchronized void removeElementAt(int p0) {
	}
	public synchronized void insertElementAt(E p0, int p1) {
		f = p0;
	}
	public synchronized boolean removeElement(java.lang.Object p0) {
		return false;
	}
	public synchronized void removeAllElements() {
	}
	public synchronized boolean containsAll(java.util.Collection<?> p0) {
		return false;
	}
	public synchronized boolean removeAll(java.util.Collection<?> p0) {
		return false;
	}
	public synchronized boolean retainAll(java.util.Collection<?> p0) {
		return false;
	}
	protected synchronized void removeRange(int p0, int p1) {
	}
	public synchronized java.util.ListIterator<E> listIterator() {
		AtlasListIterator<E> r = new AtlasListIterator<E>();
		r.f = f;
		return r;
	}
	public synchronized java.util.ListIterator<E> listIterator(int p0) {
		AtlasListIterator<E> r = new AtlasListIterator<E>();
		r.f = f;
		return r;
	}
	public synchronized void sort(java.util.Comparator<? super E> p0) {
	}
}
