package java.util;
public abstract class AtlasAbstractList<E> {
	public static class ListItr<E> extends java.util.AtlasAbstractList.Itr<E> implements java.util.ListIterator<E> {
		public java.lang.Object f90;
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
	public static class Itr<E> implements java.util.Iterator<E> {
		public java.lang.Object f136;
		private Itr(java.util.AbstractList p0) {
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
			r = (java.lang.Object)((java.util.AtlasAbstractList.Itr)this).f136;
			r = (java.lang.Object)((java.util.AtlasAbstractList.ListItr)this).f90;
			return (E)r;
		}
	}
	public class ANON388 {
		ANON388() {
		}
	}
}
