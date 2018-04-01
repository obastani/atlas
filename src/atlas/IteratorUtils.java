// Copyright 2016-2018 Stanford University
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package atlas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import atlas.Utils.Filter;

public class IteratorUtils {
	public static <T> Iterable<T> getSingleIterable(T t) {
		List<T> ts = new ArrayList<T>();
		ts.add(t);
		return ts;
	}
	
	public static class JoinIterator<T> implements Iterator<T> {
		private final List<Iterator<T>> iterators;
		private int cur = 0;
		
		public JoinIterator(List<Iterator<T>> iterators) {
			this.iterators = iterators;
			this.step();
		}
		
		private void step() {
			while(this.cur < this.iterators.size() && !this.iterators.get(this.cur).hasNext()) {
				this.cur++;
			}
		}
		
		public boolean hasNext() {
			return this.cur < this.iterators.size();
		}
		
		public T next() {
			if(this.cur == this.iterators.size()) {
				return null;
			}
			T next = this.iterators.get(this.cur).next();
			this.step();
			return next;
		}
		public void remove() {	
			this.iterators.get(cur).remove();
		}
	}
	
	public static class JoinIterable<T> implements Iterable<T> {
		private final List<Iterable<T>> iterables = new ArrayList<Iterable<T>>();
		
		public JoinIterable(Iterable<Iterable<T>> iterables) {
			for(Iterable<T> iterable : iterables) {
				this.iterables.add(iterable);
			}
		}
		
		public JoinIterable(Iterable<T> ... iterables) {
			for(Iterable<T> iterable : iterables) {
				this.iterables.add(iterable);
			}
		}
		
		@Override
		public Iterator<T> iterator() {
			List<Iterator<T>> iterators = new ArrayList<Iterator<T>>();
			for(Iterable<T> iterable : this.iterables) {
				iterators.add(iterable.iterator());
			}
			return new JoinIterator<T>(iterators);
		}
	}
	
	public static class FilteredIterator<T> implements Iterator<T> {
		private final Iterator<T> iterator;
		private final Filter<T> filter;
		
		public FilteredIterator(Iterator<T> iterator, Filter<T> filter) {
			this.iterator = iterator;
			this.filter = filter;
			increment();
		}
		
		private T next;
		
		private void increment() {
			this.next = null;
			while(this.iterator.hasNext()) {
				T t = this.iterator.next();
				if(this.filter.filter(t)) {
					this.next = t;
					break;
				}
			}
		}

		@Override
		public boolean hasNext() {
			return this.next != null;
		}

		@Override
		public T next() {
			T t = this.next;
			increment();
			return t;
		}

		@Override
		public void remove() {
			throw new RuntimeException();
		}
	}
	
	public static class FilteredIterable<T> implements Iterable<T> {
		private final Iterable<T> iterable;
		private final Filter<T> filter;
		
		public FilteredIterable(Iterable<T> iterable, Filter<T> filter) {
			this.iterable = iterable;
			this.filter = filter;
		}
		
		@Override
		public Iterator<T> iterator() {
			return new FilteredIterator<T>(this.iterable.iterator(), this.filter);
		}
	}
	
}
