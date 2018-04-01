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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import atlas.AliasModelUtils.AliasModel;
import atlas.AliasModelUtils.Trace;
import atlas.ObjectConstructorUtils.ConstructStatementConstructor;
import atlas.ReflectionUtils.Callable;
import atlas.Utils.MultivalueMap;

public class ModelFileUtils {
	public static List<AliasModel> load() {
		try {
			File file = new File(Settings.MODEL_FILENAME);
			List<AliasModel> models = new ArrayList<AliasModel>();
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while((line = br.readLine()) != null) {
				try {
					models.add(AliasModelUtils.parseAliasModel(line));
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			br.close();
			return models;
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	public static void update(Iterable<AliasModel> models) {
		try {
			Set<AliasModel> allModels = new HashSet<AliasModel>(load());
			for(AliasModel model : models) {
				allModels.add(model);
			}
			List<String> allModelStrings = new ArrayList<String>();
			for(AliasModel model : allModels) {
				allModelStrings.add(model.toString());
			}
			Collections.sort(allModelStrings);
			PrintWriter pw = new PrintWriter(new FileWriter(Settings.MODEL_FILENAME));
			for(String model : allModelStrings) {
				pw.println(model);
			}
			pw.close();
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	public static MultivalueMap<Callable,Class<?>> loadProxy() {
		try {
			File file = new File(Settings.PROXY_FILENAME);
			MultivalueMap<Callable,Class<?>> proxy = new MultivalueMap<Callable,Class<?>>();
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while((line = br.readLine()) != null) {
				String[] tokens = line.split(Settings.PROXY_SEPARATOR);
				Callable method = ReflectionUtils.parseMethod(tokens[0]);
				Class<?> klass = ReflectionUtils.parseClass(tokens[1]);
				proxy.add(method, klass);
			}
			br.close();
			return proxy;
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	public static void updateProxy(MultivalueMap<Callable,Class<?>> proxy) {
		try {
			MultivalueMap<Callable,Class<?>> allProxy = new MultivalueMap<Callable,Class<?>>(loadProxy());
			allProxy.addAll(proxy);
			List<String> allProxyStrings = new ArrayList<String>();
			for(Map.Entry<Callable,Set<Class<?>>> entry : allProxy.entrySet()) {
				for(Class<?> klass : entry.getValue()) {
					allProxyStrings.add(entry.getKey().getString() + Settings.PROXY_SEPARATOR + ReflectionUtils.toString(klass, false, false));
				}
			}
			Collections.sort(allProxyStrings);
			PrintWriter pw = new PrintWriter(new FileWriter(Settings.PROXY_FILENAME));
			for(String model : allProxyStrings) {
				pw.println(model);
			}
			pw.close();
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	private static void delete(File file) {
		if(!file.exists()) {
		} else if(file.isDirectory()) {
			for(File child : file.listFiles()) {
				delete(child);
			}
		} else {
			file.delete();
		}
	}
	public static void writeModelsTracing(Iterable<Class<?>> allClasses, MultivalueMap<AliasModel,Trace> models, MultivalueMap<Callable,Class<?>> proxyModels, Iterable<ConstructStatementConstructor> constructors, Iterable<Boolean> isNonNulls) {
		String sourceDirName = Settings.USE_EMPTY_ATLAS ? Settings.EMPTY_SOURCE_DIRNAME : Settings.SOURCE_DIRNAME;
		delete(new File(new File(sourceDirName), "src"));
		SourceUtils.writeStatements(new File(sourceDirName), allClasses, models, proxyModels, constructors, isNonNulls);
	}
}
