/* Felipe Luna ~ 2020 */
package aoc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Library {
	public List<String> parseFile(String fileName) {
		List<String> l = new ArrayList<>();

		BufferedReader reader;
		ClassLoader classLoader = getClass().getClassLoader();
		try {
			reader = new BufferedReader(new FileReader(new File(classLoader.getResource(fileName).getFile())));
			String line = reader.readLine();
			while (line != null) {
				l.add(line);
				line = reader.readLine();
			}
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return l;
	}

	public static long[] toArrayLong(List<String> l) {
		return l.stream().mapToLong(i -> Long.parseLong(i)).toArray();
	}

	public List<String> splitNewLine(List<String> l) {
		List<String> r = new ArrayList<>();

		StringBuilder sb = new StringBuilder();
		for (String s : l) {
			if ("".equals(s)) {
				r.add(sb.toString().trim());
				sb.setLength(0); // clear
			} else {
				sb.append(s);
				sb.append(" ");
			}
		}
		r.add(sb.toString().trim());
		return r;
	}
}
