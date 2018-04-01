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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Log {
	private static String logName = null;
	
	public static void init(String log) {
		logName = log;
		new File(logName).delete();
	}
	
	public static void info(String s) {
		System.out.println(s);
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(logName, true));
			pw.println(s);
			pw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}