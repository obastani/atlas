package java.util.concurrent;
public class CopyOnWriteArraySet<E> extends java.util.AbstractSet<E> implements java.io.Serializable {
	public java.lang.Object f10;
	public CopyOnWriteArraySet(java.util.Collection<? extends E> p0) {
		((java.util.concurrent.CopyOnWriteArraySet)this).f10 = p0.iterator().next();
	}
	public CopyOnWriteArraySet() {
	}
	public boolean add(E p0) {
		boolean r = false;
		((java.util.concurrent.CopyOnWriteArraySet)this).f10 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public boolean remove(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
	}
	public boolean equals(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
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
		((java.lang.Object[])r)[0] = (java.lang.Object)((java.util.concurrent.CopyOnWriteArraySet)this).f10;
		return (java.lang.Object[])r;
	}
	public <T> T[] toArray(T[] p0) {
		java.lang.Object[] r = null;
		r = new java.lang.Object[1];
		((java.lang.Object[])r)[0] = (java.lang.Object)((java.util.concurrent.CopyOnWriteArraySet)this).f10;
		return (T[])r;
	}
	public java.util.Iterator<E> iterator() {
		java.util.Iterator r = null;
		r = new java.util.concurrent.CopyOnWriteArrayList.COWIterator();
		((java.util.concurrent.CopyOnWriteArrayList.COWIterator)r).f128 = (java.lang.Object)((java.util.concurrent.CopyOnWriteArraySet)this).f10;
		return (java.util.Iterator<E>)r;
	}
	public boolean addAll(java.util.Collection<? extends E> p0) {
		boolean r = false;
		((java.util.concurrent.CopyOnWriteArraySet)this).f10 = p0.iterator().next();
		return (boolean)r;
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
}
