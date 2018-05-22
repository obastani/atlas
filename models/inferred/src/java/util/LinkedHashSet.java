package java.util;
public class LinkedHashSet<E> extends java.util.HashSet<E> implements java.util.Set<E>, java.lang.Cloneable, java.io.Serializable {
	public java.lang.Object f7;
	public LinkedHashSet(java.util.Collection<? extends E> p0) {
		((java.util.LinkedHashSet)this).f7 = p0.iterator().next();
	}
	public LinkedHashSet() {
	}
}
