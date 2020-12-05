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
}
