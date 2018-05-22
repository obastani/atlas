package java.util;
public class LinkedHashMap<K,V> extends java.util.HashMap<K, V> implements java.util.Map<K, V> {
	public java.lang.Object f16;
	public java.lang.Object f113;
	public LinkedHashMap(java.util.Map<? extends K, ? extends V> p0) {
		((java.util.LinkedHashMap)this).f16 = p0.values().iterator().next();
		((java.util.LinkedHashMap)this).f113 = p0.keySet().iterator().next();
	}
	public LinkedHashMap() {
	}
	public V get(java.lang.Object p0) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.LinkedHashMap)this).f16;
		return (V)r;
	}
	public java.util.Collection<V> values() {
		java.util.Collection r = null;
		r = new java.util.LinkedHashMap.LinkedValues();
		((java.util.LinkedHashMap.LinkedValues)r).f108 = (java.lang.Object)((java.util.LinkedHashMap)this).f16;
		return (java.util.Collection<V>)r;
	}
	public void clear() {
	}
	public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
		java.util.Set r = null;
		r = new java.util.LinkedHashMap.LinkedEntrySet();
		((java.util.LinkedHashMap.LinkedEntrySet)r).f127 = (java.lang.Object)((java.util.LinkedHashMap)this).f16;
		((java.util.LinkedHashMap.LinkedEntrySet)r).f56 = (java.lang.Object)((java.util.LinkedHashMap)this).f113;
		return (java.util.Set<java.util.Map.Entry<K, V>>)r;
	}
	public java.util.Set<K> keySet() {
		java.util.Set r = null;
		r = new java.util.LinkedHashMap.LinkedKeySet();
		((java.util.LinkedHashMap.LinkedKeySet)r).f105 = (java.lang.Object)((java.util.LinkedHashMap)this).f113;
		return (java.util.Set<K>)r;
	}
	public boolean containsValue(java.lang.Object p0) {
		boolean r = false;
		return (boolean)r;
	}
	public V getOrDefault(java.lang.Object p0, V p1) {
		java.lang.Object r = null;
		r = (java.lang.Object)((java.util.LinkedHashMap)this).f16;
		return (V)r;
	}
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> p0) {
		boolean r = false;
		return (boolean)r;
	}
	public final class LinkedEntryIterator extends java.util.LinkedHashMap<K, V>.LinkedHashIterator implements java.util.Iterator<java.util.Map.Entry<K, V>> {
		public java.lang.Object f176;
		public java.lang.Object f142;
		LinkedEntryIterator(java.util.LinkedHashMap p0) {
		}
		public LinkedEntryIterator() {
		}
		public final java.util.Map.Entry<K, V> next() {
			java.util.Map.Entry r = null;
			r = new java.util.LinkedHashMap.Entry();
			((java.util.LinkedHashMap.Entry)r).f174 = (java.lang.Object)((java.util.LinkedHashMap.LinkedEntryIterator)this).f142;
			((java.util.LinkedHashMap.Entry)r).f74 = (java.lang.Object)((java.util.LinkedHashMap.LinkedEntryIterator)this).f176;
			return (java.util.Map.Entry<K, V>)r;
		}
	}
	public final class LinkedValueIterator extends java.util.LinkedHashMap<K, V>.LinkedHashIterator implements java.util.Iterator<V> {
		public java.lang.Object f60;
		LinkedValueIterator(java.util.LinkedHashMap p0) {
		}
		public LinkedValueIterator() {
		}
		public final V next() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.LinkedHashMap.LinkedValueIterator)this).f60;
			return (V)r;
		}
	}
	public final class LinkedKeyIterator extends java.util.LinkedHashMap<K, V>.LinkedHashIterator implements java.util.Iterator<K> {
		public java.lang.Object f91;
		LinkedKeyIterator(java.util.LinkedHashMap p0) {
		}
		public LinkedKeyIterator() {
		}
		public final K next() {
			java.lang.Object r = null;
			r = (java.lang.Object)((java.util.LinkedHashMap.LinkedKeyIterator)this).f91;
			return (K)r;
		}
	}
	public abstract class LinkedHashIterator {
		LinkedHashIterator(java.util.LinkedHashMap p0) {
		}
		public LinkedHashIterator() {
		}
		public final void remove() {
		}
		public final boolean hasNext() {
			boolean r = false;
			return (boolean)r;
		}
	}
	public final class LinkedEntrySet extends java.util.AbstractSet<java.util.Map.Entry<K, V>> {
		public java.lang.Object f56;
		public java.lang.Object f127;
		LinkedEntrySet(java.util.LinkedHashMap p0) {
		}
		public LinkedEntrySet() {
		}
		public final boolean remove(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public final void clear() {
		}
		public final boolean contains(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public final int size() {
			int r = 0;
			return (int)r;
		}
		public final java.util.Iterator<java.util.Map.Entry<K, V>> iterator() {
			java.util.Iterator r = null;
			r = new java.util.LinkedHashMap.LinkedEntryIterator();
			((java.util.LinkedHashMap.LinkedEntryIterator)r).f176 = (java.lang.Object)((java.util.LinkedHashMap.LinkedEntrySet)this).f56;
			((java.util.LinkedHashMap.LinkedEntryIterator)r).f142 = (java.lang.Object)((java.util.LinkedHashMap.LinkedEntrySet)this).f127;
			return (java.util.Iterator<java.util.Map.Entry<K, V>>)r;
		}
	}
	public final class LinkedValues extends java.util.AbstractCollection<V> {
		public java.lang.Object f108;
		LinkedValues(java.util.LinkedHashMap p0) {
		}
		public LinkedValues() {
		}
		public final void clear() {
		}
		public final boolean contains(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public final int size() {
			int r = 0;
			return (int)r;
		}
		public final java.util.Iterator<V> iterator() {
			java.util.Iterator r = null;
			r = new java.util.LinkedHashMap.LinkedValueIterator();
			((java.util.LinkedHashMap.LinkedValueIterator)r).f60 = (java.lang.Object)((java.util.LinkedHashMap.LinkedValues)this).f108;
			return (java.util.Iterator<V>)r;
		}
	}
	public final class LinkedKeySet extends java.util.AbstractSet<K> {
		public java.lang.Object f105;
		LinkedKeySet(java.util.LinkedHashMap p0) {
		}
		public LinkedKeySet() {
		}
		public final boolean remove(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public final void clear() {
		}
		public final boolean contains(java.lang.Object p0) {
			boolean r = false;
			return (boolean)r;
		}
		public final int size() {
			int r = 0;
			return (int)r;
		}
		public final java.util.Iterator<K> iterator() {
			java.util.Iterator r = null;
			r = new java.util.LinkedHashMap.LinkedKeyIterator();
			((java.util.LinkedHashMap.LinkedKeyIterator)r).f91 = (java.lang.Object)((java.util.LinkedHashMap.LinkedKeySet)this).f105;
			return (java.util.Iterator<K>)r;
		}
	}
	public static class Entry<K,V> extends java.util.HashMap.Node<K, V> {
		public java.lang.Object f74;
		public java.lang.Object f174;
		public Entry() {
		}
	}
}
