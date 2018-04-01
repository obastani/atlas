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
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

import atlas.Utils.Maybe;
import atlas.Utils.Triple;

public class QLearnerUtils {
	public static class QTuple {
		public final Object state;
		public final Object nextState;
		public final double reward;
		public QTuple(Object state, Object nextState, double reward) {
			this.state = state;
			this.nextState = nextState;
			this.reward = reward;
		}
	}
	
	public static class QLearner {
		private final Map<Object,Map<Object,Double>> qValues = new HashMap<Object,Map<Object,Double>>();
		
		private Iterable<Double> getQValues(Object state) {
			Map<Object,Double> curQValues = this.qValues.get(state);
			return curQValues == null ? new ArrayList<Double>() : curQValues.values();
		}
		
		private double getQValue(Object state, Object nextState) {
			Map<Object,Double> curQValues = this.qValues.get(state);
			if(curQValues == null) {
				return 0.0;
			}
			Double qValue = curQValues.get(nextState);
			if(qValue == null) {
				return 0.0;
			}
			return qValue;
		}
		
		private void setQValue(Object state, Object nextState, double qValue) {
			if(qValue == 0.0) {
				return;
			}
			Map<Object,Double> curQValues = this.qValues.get(state);
			if(curQValues == null) {
				curQValues = new HashMap<Object,Double>();
				this.qValues.put(state, curQValues);
			}
			curQValues.put(nextState, qValue);
		}
		
		public void update(QTuple tuple, double alpha, double gamma) {
			// current q(s, a)
			double curQValue = this.getQValue(tuple.state, tuple.nextState);
			
			// current r
			double reward = tuple.reward;
			
			// max_{a'} q(s', a')
			double maxNextQValue = 0.0;
			for(double nextQValue : this.getQValues(tuple.nextState)) {
				if(maxNextQValue < nextQValue) {
					maxNextQValue = nextQValue;
				}
			}
			
			// new q(s, a)
			double newCurQValue = (1.0 - alpha)*curQValue + alpha*(reward + gamma*maxNextQValue);
			
			// update
			this.setQValue(tuple.state, tuple.nextState, newCurQValue);
		}
		
		public <T> Maybe<Integer> choose(Object state, List<T> nextStates, double epsilon, Random random) {
			if(nextStates.size() == 0) {
				// no actions
				return new Maybe<Integer>();
			} else if(random.nextDouble() < epsilon) {
				// epsilon greedy
				return new Maybe<Integer>(random.nextInt(nextStates.size()));
			} else {
				// get total q-values
				double total = 0.0;
				for(T nextState : nextStates) {
					total += this.getQValue(state, nextState);
				}
				if(total == 0.0) {
					return new Maybe<Integer>(random.nextInt(nextStates.size()));
				}
				// choose randomly in proportion to q-value
				double choice = total*random.nextDouble();
				double sum = 0.0;
				for(int i=0; i<nextStates.size(); i++) {
					sum += this.getQValue(state, nextStates.get(i));
					if(choice <= sum) {
						return new Maybe<Integer>(i);
					}
				}
			}
			throw new RuntimeException();
		}
		
		public List<Triple<Object,Object,Double>> top(int numTop) {
			PriorityQueue<Triple<Object,Object,Double>> top = new PriorityQueue<Triple<Object,Object,Double>>(
					12, new Comparator<Triple<Object,Object,Double>>() {
						public int compare(Triple<Object,Object,Double> t1, Triple<Object,Object,Double> t2) {
							return Double.compare(t1.getZ(), t2.getZ()); }});
			for(Map.Entry<Object,Map<Object,Double>> stateEntry : this.qValues.entrySet()) {
				for(Map.Entry<Object,Double> nextStateEntry : stateEntry.getValue().entrySet()) {
					top.add(new Triple<Object,Object,Double>(stateEntry.getKey(), nextStateEntry.getKey(), nextStateEntry.getValue()));
					if(top.size() > numTop) {
						top.poll();
					}
				}
			}
			return new ArrayList<Triple<Object,Object,Double>>(top);
		}
	}
}
