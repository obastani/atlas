package java.util;
public class LinkedHashSet<E> extends java.util.HashSet<E> implements java.util.Set<E>, java.lang.Cloneable, java.io.Serializable {
	public LinkedHashSet(java.util.Collection<? extends E> p0) {
		f = p0.iterator().next();
	}
	public LinkedHashSet() {
	}
}
