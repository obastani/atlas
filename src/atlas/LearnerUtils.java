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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import atlas.AliasModelUtils.DefaultMethodDecisions;
import atlas.AliasModelUtils.MethodDecisions;
import atlas.AliasModelUtils.MethodLookup;
import atlas.AliasModelUtils.PartialAliasModel;
import atlas.QLearnerUtils.QLearner;
import atlas.QLearnerUtils.QTuple;
import atlas.ReflectionUtils.Callable;
import atlas.Utils.Maybe;
import atlas.Utils.MultivalueMap;
import atlas.Utils.Pair;

public class LearnerUtils {
	public static interface LearnerMethodDecisions extends MethodDecisions {
		public abstract void update(PartialAliasModel model, boolean isSuccessful);
	}
	
	public static class DefaultLearnerMethodDecisions implements LearnerMethodDecisions {
		private final MethodDecisions decisions;
		public DefaultLearnerMethodDecisions(MethodDecisions decisions) {
			this.decisions = decisions;
		}
		@Override
		public Maybe<Callable> chooseStartMethod(List<Callable> methods) {
			return this.decisions.chooseStartMethod(methods);
		}
		@Override
		public Maybe<Callable> chooseExternalMethod(List<Callable> path, Callable curMethod, Maybe<Integer> curParameter, List<Callable> methods) {
			return this.decisions.chooseExternalMethod(path, curMethod, curParameter, methods);
		}
		@Override
		public void update(PartialAliasModel model, boolean isSuccessful) {}
	}
	
	public static LearnerMethodDecisions getRandomLearnerMethodDecisions(Random random) {
		return new DefaultLearnerMethodDecisions(new DefaultMethodDecisions(random));
	}
	
	public static class QMethodDecisions implements LearnerMethodDecisions {
		private final QLearner learner = new QLearner();
		private final Map<String,List<Object>> startMethodTransitions;
		private final double epsilon;
		private final double alpha;
		private final double gamma;
		private final Random random;
		
		public QMethodDecisions(MethodLookup lookup, double epsilon, double alpha, double gamma, Random random) {
			this.startMethodTransitions = getStartMethodTransitions(lookup);
			this.epsilon = epsilon;
			this.alpha = alpha;
			this.gamma = gamma;
			this.random = random;
		}
		
		@Override
		public Maybe<Callable> chooseStartMethod(List<Callable> methods) {
			Object state = "";
			while(!(state instanceof Callable)) {
				Maybe<Integer> action = this.learner.choose(state, this.startMethodTransitions.get(state), this.epsilon, this.random);
				state = this.startMethodTransitions.get(state).get(action.getT());
			}
			return new Maybe<Callable>((Callable)state);
		}

		@Override
		public Maybe<Callable> chooseExternalMethod(List<Callable> path, Callable curMethod, Maybe<Integer> curParameter, List<Callable> methods) {
			Object state = Utils.toString(path);
			Maybe<Integer> action = this.learner.choose(state, methods, this.epsilon, this.random);
			return action.hasT() ? new Maybe<Callable>(methods.get(action.getT())) : new Maybe<Callable>();
		}
		
		@Override
		public void update(PartialAliasModel model, boolean isSuccessful) {
			List<QTuple> history = this.getHistory(model, isSuccessful);
			for(int i=history.size()-1; i>=0; i--) {
				this.learner.update(history.get(i), this.alpha, this.gamma);
			}
		}
		
		private List<QTuple> getHistory(PartialAliasModel model, boolean isSuccessful) {
			List<QTuple> history = new ArrayList<QTuple>();
			List<Pair<String,Object>> transitions = getStartMethodTransitionsHelper(model.getPath().get(0).getMethod());
			for(int i=0; i<transitions.size(); i++) {
				double reward = (isSuccessful && i == transitions.size()-1) ? 1.0 : 0.0;
				history.add(new QTuple(transitions.get(i).getX(), transitions.get(i).getY(), reward));
			}
			return history;
		}
	}
	
	private static List<Pair<String,Object>> getStartMethodTransitionsHelper(Callable method) {
		List<Pair<String,Object>> transitions = new ArrayList<Pair<String,Object>>();
		String[] tokens = method.getDeclaringClass().getName().split("\\.");
		String state = "";
		for(int i=0; i<tokens.length; i++) {
			String newState = state + (i == 0 ? "" : ".") + tokens[i];
			transitions.add(new Pair<String,Object>(state, newState));
			state = newState;
		}
		transitions.add(new Pair<String,Object>(state, method));
		return transitions;
	}
	
	private static Map<String,List<Object>> getStartMethodTransitions(MethodLookup lookup) {
		MultivalueMap<String,Object> transitionSet = new MultivalueMap<String,Object>();
		for(Callable method : lookup.getStartMethods()) {
			for(Pair<String,Object> transition : getStartMethodTransitionsHelper(method)) {
				transitionSet.add(transition.getX(), transition.getY());
			}
		}
		Map<String,List<Object>> transitions = new HashMap<String,List<Object>>();
		for(Map.Entry<String,Set<Object>> entry : transitionSet.entrySet()) {
			transitions.put(entry.getKey(), new ArrayList<Object>(entry.getValue()));
		}
		return transitions;
	}
}
