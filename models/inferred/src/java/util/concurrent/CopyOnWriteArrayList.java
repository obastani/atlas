package java.util.concurrent;
public class CopyOnWriteArrayList<E> implements java.util.List<E>, java.util.RandomAccess, java.lang.Cloneable, java.io.Serializable {
	public java.lang.Object f2;
	public CopyOnWriteArrayList(java.util.Collection<? extends E> p0) {
		((java.util.concurrent.CopyOnWriteArrayList)this).f2 = p0.iterator().next();
	}
	public CopyOnWriteArrayList() {
	}
	public boolean add(E p0) {
		boolean r = false;
		((java.util.concurrent.CopyOnWriteArrayList)this).f2 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public void add(int p0, E p1) {
		((java.util.concurrent.CopyOnWriteArrayList)this).f2 = (java.lang.Object)p1;
	}
	public boolean remove(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
	}
	public E remove(int p0) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.CopyOnWriteArrayList)this).f2;
		return (E)r;
	}
	public E get(int p0) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.CopyOnWriteArrayList)this).f2;
		return (E)r;
	}
	public boolean equals(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
	}
	public java.lang.String toString() {
		java.lang.String r = null;
		r = new java.lang.String();
		return (java.lang.String)r;
	}
	public int hashCode() {
		int r = 0;
		return (int)r;
	}
	public java.lang.Object clone() {
		java.lang.Object r = null;
		r = new java.util.concurrent.CopyOnWriteArrayList();
		((java.util.concurrent.CopyOnWriteArrayList)r).f2 = (java.lang.Object)((java.util.concurrent.CopyOnWriteArrayList)this).f2;
		return (java.lang.Object)r;
	}
	public int indexOf(E p0, int p1) {
		int r = 0;
		return (int)r;
	}
	public int indexOf(java.lang.Object p0) {
		int r = 0;
		return (int)r;
	}
	public void clear() {
	}
	public boolean isEmpty() {
		boolean r = false;
		return (boolean)r;
	}
	public int lastIndexOf(java.lang.Object p0) {
		int r = 0;
		return (int)r;
	}
	public int lastIndexOf(E p0, int p1) {
		int r = 0;
		return (int)r;
	}
	public boolean contains(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
	}
	public int size() {
		int r = 0;
		return (int)r;
	}
	public java.util.List<E> subList(int p0, int p1) {
		java.util.List r = null;
		return (java.util.List<E>)r;
	}
	public <T> T[] toArray(T[] p0) {
		java.lang.Object[] r = null;
		r = new java.lang.Object[1];
		((java.lang.Object[])r)[0] = (java.lang.Object)((java.util.concurrent.CopyOnWriteArrayList)this).f2;
		return (T[])r;
	}
	public java.lang.Object[] toArray() {
		java.lang.Object[] r = null;
		r = new java.lang.Object[1];
		return (java.lang.Object[])r;
	}
	public java.util.Iterator<E> iterator() {
		java.util.Iterator r = null;
		r = new java.util.concurrent.CopyOnWriteArrayList.COWIterator();
		((java.util.concurrent.CopyOnWriteArrayList.COWIterator)r).f128 = (java.lang.Object)((java.util.concurrent.CopyOnWriteArrayList)this).f2;
		return (java.util.Iterator<E>)r;
	}
	public boolean addAll(java.util.Collection<? extends E> p0) {
		boolean r = false;
		((java.util.concurrent.CopyOnWriteArrayList)this).f2 = p0.iterator().next();
		return (boolean)r;
	}
	public boolean addAll(int p0, java.util.Collection<? extends E> p1) {
		boolean r = false;
		((java.util.concurrent.CopyOnWriteArrayList)this).f2 = p1.iterator().next();
		return (boolean)r;
	}
	public E set(int p0, E p1) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.concurrent.CopyOnWriteArrayList)this).f2;
		return (E)r;
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
	public java.util.ListIterator<E> listIterator() {
		java.util.ListIterator r = null;
		r = new java.util.concurrent.CopyOnWriteArrayList.COWIterator();
		((java.util.concurrent.CopyOnWriteArrayList.COWIterator)r).f128 = (java.lang.Object)((java.util.concurrent.CopyOnWriteArrayList)this).f2;
		return (java.util.ListIterator<E>)r;
	}
	public java.util.ListIterator<E> listIterator(int p0) {
		java.util.ListIterator r = null;
		r = new java.util.concurrent.CopyOnWriteArrayList.COWIterator();
		((java.util.concurrent.CopyOnWriteArrayList.COWIterator)r).f128 = (java.lang.Object)((java.util.concurrent.CopyOnWriteArrayList)this).f2;
		return (java.util.ListIterator<E>)r;
	}
	public void sort(java.util.Comparator<? super E> p0) {
	}
	public boolean addIfAbsent(E p0) {
		boolean r = false;
		((java.util.concurrent.CopyOnWriteArrayList)this).f2 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public int addAllAbsent(java.util.Collection<? extends E> p0) {
		int r = 0;
		((java.util.concurrent.CopyOnWriteArrayList)this).f2 = p0.iterator().next();
		return (int)r;
	}
	public static class COWSubListIterator<E> implements java.util.ListIterator<E> {
		public COWSubListIterator() {
		}
		public void add(E p0) {
		}
		public void remove() {
		}
		public boolean hasNext() {
			boolean r = false;
			return (boolean)r;
		}
		public E next() {
			java.lang.Object r = null;
			return (E)r;
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
	public static class COWSubList<E> extends java.util.AbstractList<E> implements java.util.RandomAccess {
		public COWSubList() {
		}
		public void add(int p0, E p1) {
		}
		public E remove(int p0) {
			java.lang.Object r = null;
			return (E)r;
		}
		public boolean remove(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public E get(int p0) {
			java.lang.Object r = null;
			return (E)r;
		}
		public void clear() {
		}
		public int size() {
			int r = 0;
			return (int)r;
		}
		public java.util.List<E> subList(int p0, int p1) {
			java.util.List r = null;
			return (java.util.List<E>)r;
		}
		public java.util.Iterator<E> iterator() {
			java.util.Iterator r = null;
			return (java.util.Iterator<E>)r;
		}
		public E set(int p0, E p1) {
			java.lang.Object r = null;
			return (E)r;
		}
		public boolean removeAll(java.util.Collection<?> p0) {
			boolean r = false;
			return (boolean)r;
		}
		public boolean retainAll(java.util.Collection<?> p0) {
			boolean r = false;
			return (boolean)r;
		}
		public java.util.ListIterator<E> listIterator(int p0) {
			java.util.ListIterator r = null;
			return (java.util.ListIterator<E>)r;
		}
		public void sort(java.util.Comparator<? super E> p0) {
		}
	}
	public static final class COWIterator<E> implements java.util.ListIterator<E> {
		public java.lang.Object f128;
		public COWIterator() {
		}
		public void add(E p0) {
		}
		public void remove() {
		}
		public boolean hasNext() {
			boolean r = false;
			return (boolean)r;
		}
		public E next() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.concurrent.CopyOnWriteArrayList.COWIterator)this).f128;
			return (E)r;
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
	public class ANON377 {
		ANON377() {
		}
	}
}
