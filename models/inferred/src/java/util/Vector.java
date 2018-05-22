package java.util;
public class Vector<E> extends java.util.AbstractList<E> implements java.util.List<E>, java.util.RandomAccess, java.lang.Cloneable, java.io.Serializable {
	public java.lang.Object f21;
	public Vector(java.util.Collection<? extends E> p0) {
		((java.util.Vector)this).f21 = p0.iterator().next();
	}
	public Vector() {
	}
	public synchronized boolean add(E p0) {
		boolean r = false;
		((java.util.Stack)this).f26 = (java.lang.Object)p0;
		((java.util.Vector)this).f21 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public void add(int p0, E p1) {
		((java.util.Stack)this).f26 = (java.lang.Object)p1;
		((java.util.Vector)this).f21 = (java.lang.Object)p1;
	}
	public synchronized E remove(int p0) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.Stack)this).f26;
		r = (java.lang.Object)((java.util.Vector)this).f21;
		return (E)r;
	}
	public boolean remove(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
	}
	public synchronized E get(int p0) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.Stack)this).f26;
		r = (java.lang.Object)((java.util.Vector)this).f21;
		return (E)r;
	}
	public synchronized boolean equals(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
	}
	public synchronized java.lang.String toString() {
		java.lang.String r = null;
		r = new java.lang.String();
		return (java.lang.String)r;
	}
	public synchronized int hashCode() {
		int r = 0;
		return (int)r;
	}
	public synchronized java.lang.Object clone() {
		java.lang.Object r = null;
		r = new java.util.Stack();
		r = new java.util.Vector();
		((java.util.Stack)r).f26 = (java.lang.Object)((java.util.Stack)this).f26;
		((java.util.Vector)r).f21 = (java.lang.Object)((java.util.Vector)this).f21;
		return (java.lang.Object)r;
	}
	public synchronized int indexOf(java.lang.Object p0, int p1) {
		int r = 0;
		return (int)r;
	}
	public int indexOf(java.lang.Object p0) {
		int r = 0;
		return (int)r;
	}
	public void clear() {
	}
	public synchronized boolean isEmpty() {
		boolean r = false;
		return (boolean)r;
	}
	public synchronized int lastIndexOf(java.lang.Object p0, int p1) {
		int r = 0;
		return (int)r;
	}
	public synchronized int lastIndexOf(java.lang.Object p0) {
		int r = 0;
		return (int)r;
	}
	public boolean contains(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
	}
	public synchronized int size() {
		int r = 0;
		return (int)r;
	}
	public synchronized java.util.List<E> subList(int p0, int p1) {
		java.util.List r = null;
		return (java.util.List<E>)r;
	}
	public synchronized <T> T[] toArray(T[] p0) {
		java.lang.Object[] r = null;
		return (T[])r;
	}
	public synchronized java.lang.Object[] toArray() {
		java.lang.Object[] r = null;
		r = new java.lang.Object[1];
		((java.lang.Object[])r)[0] = (java.lang.Object)((java.util.Stack)this).f26;
		return (java.lang.Object[])r;
	}
	public synchronized java.util.Iterator<E> iterator() {
		java.util.Iterator r = null;
		r = new java.util.Vector.Itr();
		((java.util.Vector.Itr)r).f125 = (java.lang.Object)((java.util.Vector)this).f21;
		((java.util.Vector.Itr)r).f125 = (java.lang.Object)((java.util.Stack)this).f26;
		return (java.util.Iterator<E>)r;
	}
	public synchronized boolean addAll(java.util.Collection<? extends E> p0) {
		boolean r = false;
		((java.util.Stack)this).f26 = p0.iterator().next();
		((java.util.Vector)this).f21 = p0.iterator().next();
		return (boolean)r;
	}
	public synchronized boolean addAll(int p0, java.util.Collection<? extends E> p1) {
		boolean r = false;
		((java.util.Vector)this).f21 = p1.iterator().next();
		((java.util.Stack)this).f26 = p1.iterator().next();
		return (boolean)r;
	}
	public synchronized void addElement(E p0) {
		((java.util.Stack)this).f26 = (java.lang.Object)p0;
		((java.util.Vector)this).f21 = (java.lang.Object)p0;
	}
	public synchronized E elementAt(int p0) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.Stack)this).f26;
		r = (java.lang.Object)((java.util.Vector)this).f21;
		return (E)r;
	}
	public java.util.Enumeration<E> elements() {
		java.util.Enumeration r = null;
		r = new ANON223();
		((ANON223)r).f71 = (java.lang.Object)((java.util.Vector)this).f21;
		((ANON223)r).f71 = (java.lang.Object)((java.util.Stack)this).f26;
		return (java.util.Enumeration<E>)r;
	}
	public synchronized E set(int p0, E p1) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.Stack)this).f26;
		r = (java.lang.Object)((java.util.Vector)this).f21;
		return (E)r;
	}
	public synchronized int capacity() {
		int r = 0;
		return (int)r;
	}
	public synchronized void ensureCapacity(int p0) {
	}
	public synchronized void trimToSize() {
	}
	public synchronized void copyInto(java.lang.Object[] p0) {
	}
	public synchronized void setSize(int p0) {
	}
	public synchronized E firstElement() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.Stack)this).f26;
		r = (java.lang.Object)((java.util.Vector)this).f21;
		return (E)r;
	}
	public synchronized E lastElement() {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.Stack)this).f26;
		r = (java.lang.Object)((java.util.Vector)this).f21;
		return (E)r;
	}
	public synchronized void setElementAt(E p0, int p1) {
	}
	public synchronized void removeElementAt(int p0) {
	}
	public synchronized void insertElementAt(E p0, int p1) {
		((java.util.Stack)this).f26 = (java.lang.Object)p0;
		((java.util.Vector)this).f21 = (java.lang.Object)p0;
	}
	public synchronized boolean removeElement(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
	}
	public synchronized void removeAllElements() {
	}
	public synchronized boolean containsAll(java.util.Collection<?> p0) {
		boolean r = false;
		return (boolean)r;
	}
	public synchronized boolean removeAll(java.util.Collection<?> p0) {
		boolean r = false;
		return (boolean)r;
	}
	public synchronized boolean retainAll(java.util.Collection<?> p0) {
		boolean r = false;
		return (boolean)r;
	}
	protected synchronized void removeRange(int p0, int p1) {
	}
	public synchronized java.util.ListIterator<E> listIterator() {
		java.util.ListIterator r = null;
		r = new java.util.Vector.ListItr();
		((java.util.Vector.ListItr)r).f98 = (java.lang.Object)((java.util.Vector)this).f21;
		((java.util.Vector.ListItr)r).f98 = (java.lang.Object)((java.util.Stack)this).f26;
		return (java.util.ListIterator<E>)r;
	}
	public synchronized java.util.ListIterator<E> listIterator(int p0) {
		java.util.ListIterator r = null;
		r = new java.util.Vector.ListItr();
		((java.util.Vector.ListItr)r).f98 = (java.lang.Object)((java.util.Vector)this).f21;
		((java.util.Vector.ListItr)r).f98 = (java.lang.Object)((java.util.Stack)this).f26;
		return (java.util.ListIterator<E>)r;
	}
	public synchronized void sort(java.util.Comparator<? super E> p0) {
	}
	public static final class VectorSpliterator<E> {
		public VectorSpliterator() {
		}
		public long estimateSize() {
			long r = 0;
			return (long)r;
		}
		public int characteristics() {
			int r = 0;
			return (int)r;
		}
	}
	public final class ListItr extends java.util.Vector<E>.Itr implements java.util.ListIterator<E> {
		public java.lang.Object f98;
		public ListItr() {
		}
		public void add(E p0) {
		}
		public void set(E p0) {
		}
		public int previousIndex() {
			int r = 0;
			return (int)r;
		}
		public boolean hasPrevious() {
			boolean r = false;
			return (boolean)r;
		}
		public E previous() {
			java.lang.Object r = null;
			return (E)r;
		}
		public int nextIndex() {
			int r = 0;
			return (int)r;
		}
	}
	public class Itr implements java.util.Iterator<E> {
		public java.lang.Object f125;
		private Itr(java.util.Vector p0) {
		}
		public Itr() {
		}
		public void remove() {
		}
		public boolean hasNext() {
			boolean r = false;
			return (boolean)r;
		}
		public E next() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.Vector.Itr)this).f125;
			r = (java.lang.Object)((java.util.Vector.ListItr)this).f98;
			return (E)r;
		}
	}
	public class ANON223<E> implements java.util.Enumeration<E> {
		public java.lang.Object f71;
		ANON223() {
		}
		public boolean hasMoreElements() {
			boolean r = false;
			return (boolean)r;
		}
		public E nextElement() {
			java.lang.Object r = null;
			r = (java.lang.Object)((ANON223)this).f71;
			return (E)r;
		}
	}
}
