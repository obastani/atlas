package java.util;
public class ArrayList<E> extends java.util.AbstractList<E> implements java.util.List<E>, java.util.RandomAccess, java.lang.Cloneable, java.io.Serializable {
	public java.lang.Object f35;
	public ArrayList(java.util.Collection<? extends E> p0) {
		((java.util.ArrayList)this).f35 = p0.iterator().next();
	}
	public ArrayList() {
	}
	public boolean add(E p0) {
		boolean r = false;
		((java.util.ArrayList)this).f35 = (java.lang.Object)p0;
		return (boolean)r;
	}
	public void add(int p0, E p1) {
		((java.util.ArrayList)this).f35 = (java.lang.Object)p1;
	}
	public boolean remove(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
	}
	public E remove(int p0) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.ArrayList)this).f35;
		return (E)r;
	}
	public E get(int p0) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.ArrayList)this).f35;
		return (E)r;
	}
	public java.lang.Object clone() {
		java.lang.Object r = null;
		r = new java.util.ArrayList();
		((java.util.ArrayList)r).f35 = (java.lang.Object)((java.util.ArrayList)this).f35;
		return (java.lang.Object)r;
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
		((java.lang.Object[])r)[0] = (java.lang.Object)((java.util.ArrayList)this).f35;
		return (T[])r;
	}
	public java.lang.Object[] toArray() {
		java.lang.Object[] r = null;
		r = new java.lang.Object[1];
		((java.lang.Object[])r)[0] = (java.lang.Object)((java.util.ArrayList)this).f35;
		return (java.lang.Object[])r;
	}
	public java.util.Iterator<E> iterator() {
		java.util.Iterator r = null;
		r = new java.util.ArrayList.Itr();
		((java.util.ArrayList.Itr)r).f9 = (java.lang.Object)((java.util.ArrayList)this).f35;
		return (java.util.Iterator<E>)r;
	}
	public boolean addAll(int p0, java.util.Collection<? extends E> p1) {
		boolean r = false;
		((java.util.ArrayList)this).f35 = p1.iterator().next();
		return (boolean)r;
	}
	public boolean addAll(java.util.Collection<? extends E> p0) {
		boolean r = false;
		((java.util.ArrayList)this).f35 = p0.iterator().next();
		return (boolean)r;
	}
	public E set(int p0, E p1) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.ArrayList)this).f35;
		return (E)r;
	}
	public void ensureCapacity(int p0) {
	}
	public void trimToSize() {
	}
	public boolean removeAll(java.util.Collection<?> p0) {
		boolean r = false;
		return (boolean)r;
	}
	public boolean retainAll(java.util.Collection<?> p0) {
		boolean r = false;
		return (boolean)r;
	}
	protected void removeRange(int p0, int p1) {
	}
	public java.util.ListIterator<E> listIterator() {
		java.util.ListIterator r = null;
		r = new java.util.ArrayList.ListItr();
		((java.util.ArrayList.ListItr)r).f148 = (java.lang.Object)((java.util.ArrayList)this).f35;
		return (java.util.ListIterator<E>)r;
	}
	public java.util.ListIterator<E> listIterator(int p0) {
		java.util.ListIterator r = null;
		r = new java.util.ArrayList.ListItr();
		((java.util.ArrayList.ListItr)r).f148 = (java.lang.Object)((java.util.ArrayList)this).f35;
		return (java.util.ListIterator<E>)r;
	}
	public void sort(java.util.Comparator<? super E> p0) {
	}
	public static final class ArrayListSpliterator<E> {
		public ArrayListSpliterator() {
		}
		public java.util.ArrayList.ArrayListSpliterator<E> trySplit() {
			java.util.ArrayList.ArrayListSpliterator r = null;
			return (java.util.ArrayList.ArrayListSpliterator<E>)r;
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
	public class SubList extends java.util.AbstractList<E> implements java.util.RandomAccess {
		public SubList() {
		}
		public void add(int p0, E p1) {
		}
		public E remove(int p0) {
			java.lang.Object r = null;
			return (E)r;
		}
		public E get(int p0) {
			java.lang.Object r = null;
			return (E)r;
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
		public boolean addAll(int p0, java.util.Collection<? extends E> p1) {
			boolean r = false;
			return (boolean)r;
		}
		public boolean addAll(java.util.Collection<? extends E> p0) {
			boolean r = false;
			return (boolean)r;
		}
		public E set(int p0, E p1) {
			java.lang.Object r = null;
			return (E)r;
		}
		protected void removeRange(int p0, int p1) {
		}
		public java.util.ListIterator<E> listIterator(int p0) {
			java.util.ListIterator r = null;
			return (java.util.ListIterator<E>)r;
		}
		public class ANON198<E> implements java.util.ListIterator<E> {
			ANON198() {
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
	}
	public class ListItr extends java.util.ArrayList<E>.Itr implements java.util.ListIterator<E> {
		public java.lang.Object f148;
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
		public java.lang.Object f9;
		private Itr(java.util.ArrayList p0) {
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
			r = (java.lang.Object)((java.util.ArrayList.Itr)this).f9;
			r = (java.lang.Object)((java.util.ArrayList.ListItr)this).f148;
			return (E)r;
		}
	}
	public class ANON410 {
		ANON410() {
		}
	}
}
