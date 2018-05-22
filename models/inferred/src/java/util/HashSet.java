package java.util;
public class HashSet<E> extends java.util.AbstractSet<E> implements java.util.Set<E>, java.lang.Cloneable, java.io.Serializable {
	public java.lang.Object f11;
	public HashSet(java.util.Collection<? extends E> p0) {
		((java.util.HashSet)this).f11 = p0.iterator().next();
	}
	public HashSet() {
	}
	public boolean add(E p0) {
		boolean r = false;
		((java.util.HashSet)this).f11 = (java.lang.Object)p0;
		((java.util.LinkedHashSet)this).f7 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public boolean remove(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
	}
	public java.lang.Object clone() {
		java.lang.Object r = null;
		r = new java.util.HashSet();
		r = new java.util.LinkedHashSet();
		((java.util.LinkedHashSet)r).f7 = (java.lang.Object)((java.util.LinkedHashSet)this).f7;
		((java.util.HashSet)r).f11 = (java.lang.Object)((java.util.HashSet)this).f11;
		return (java.lang.Object)r;
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
	public java.util.Iterator<E> iterator() {
		java.util.Iterator r = null;
		r = new java.util.HashMap().new KeyIterator();
		r = new java.util.LinkedHashMap().new LinkedKeyIterator();
		((java.util.HashMap.KeyIterator)r).f171 = (java.lang.Object)((java.util.HashSet)this).f11;
		((java.util.LinkedHashMap.LinkedKeyIterator)r).f91 = (java.lang.Object)((java.util.LinkedHashSet)this).f7;
		return (java.util.Iterator<E>)r;
	}
	public boolean addAll(java.util.Collection<? extends E> p0) {
		boolean r = false;
		((java.util.HashSet)this).f11 = p0.iterator().next();
		((java.util.LinkedHashSet)this).f7 = p0.iterator().next();
		return (boolean)r;
	}
	public <T> T[] toArray(T[] p0) {
		java.lang.Object[] r = null;
		r = new java.lang.Object[1];
		((java.lang.Object[])r)[0] = (java.lang.Object)((java.util.HashSet)this).f11;
		((java.lang.Object[])r)[0] = (java.lang.Object)((java.util.LinkedHashSet)this).f7;
		return (T[])r;
	}
}
