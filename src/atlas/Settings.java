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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import atlas.Utils.Maybe;

public class Settings {
	public static final Maybe<Long> DEFAULT_TIMEOUT = new Maybe<Long>(100L);
	public static final String SOURCE_DIRNAME = "../models";
	public static final String EMPTY_SOURCE_DIRNAME = "../empty";
	
	public static final String MODEL_FILENAME = "models.txt";
	public static final String PROXY_FILENAME = "proxy.txt";
	public static final String[] CLASS_LIST_FILES = new String[]{"data/classes_1.7.txt"};
	
	public static final boolean IS_CONSTRUCTOR_STATIC = true;
	public static final boolean CONSTRUCTOR_HAS_OBJECT_RETURN = true;
	public static final boolean IS_ARRAY_STATIC = false;
	public static final String ARRAY_STORE_NAME = "ARRAY_STORE";
	public static final String ARRAY_LOAD_NAME = "ARRAY_LOAD";
	
	public static final int MAX_MERGE_CHECK_LENGTH = 10;
	
	public static final int SOURCE_ARRAY_LENGTH = 1;
	public static final int DEFAULT_ARRAY_LENGTH = 1;
	
	public static final String[] ATLAS_ROOTS = {"java."};
	public static final String[] ATLAS_TARGETS = {
			"java.util.AbstractCollection",
			"java.util.AbstractList",
			"java.util.AbstractQueue",
			"java.util.AbstractSequentialList",
			"java.util.AbstractSet",
			"java.util.AbstractMap",
			"java.util.Dictionary",
			"java.util.concurrent.ArrayBlockingQueue",
			"java.util.ArrayDeque",
			"java.util.ArrayList",
			"java.util.concurrent.ConcurrentLinkedDeque",
			"java.util.concurrent.ConcurrentLinkedQueue",
			"java.util.concurrent.ConcurrentSkipListSet",
			"java.util.concurrent.CopyOnWriteArrayList",
			"java.util.concurrent.CopyOnWriteArraySet",
			"java.util.concurrent.DelayQueue",
			"java.util.HashSet",
			"java.util.concurrent.LinkedBlockingDeque",
			"java.util.concurrent.LinkedBlockingQueue",
			"java.util.LinkedHashSet",
			"java.util.LinkedList",
			"java.util.concurrent.LinkedTransferQueue",
			"java.util.concurrent.PriorityBlockingQueue",
			"java.util.PriorityQueue",
			"java.util.Stack",
			"java.util.concurrent.SynchronousQueue",
			"java.util.TreeSet",
			"java.util.Vector",
			"java.util.concurrent.ConcurrentHashMap",
			"java.util.concurrent.ConcurrentSkipListMap",
			"java.util.HashMap",
			"java.util.Hashtable",
			"java.util.IdentityHashMap",
			"java.util.LinkedHashMap",
			"java.util.TreeMap",
			"java.util.WeakHashMap",
			"java.util.Collections",
			"java.util.Arrays"
	};
	public static Set<String> ATLAS_TARGET_SET = new HashSet<String>(Arrays.asList(ATLAS_TARGETS));
	
	public static final boolean USE_EMPTY_ATLAS = false;

	public static final String PROXY_SEPARATOR = "##";
	public static final String ANONYMOUS_PREFIX = "ANON";
	public static final String ATLAS_PREFIX = "atlas";
	public static final String EMPTY_PREFIX = "empty";
	public static final String NAME_PREFIX = USE_EMPTY_ATLAS ? EMPTY_PREFIX : ATLAS_PREFIX;
	
	public static final String AUTOMATON_FILE = "models.aut";
	
	public static final boolean PROXY_IS_NON_NULL = false;
	
	public static final Class<?>[] IGNORED_EXCEPTIONS = new Class<?>[]{UnsupportedOperationException.class};
}
