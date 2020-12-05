/* Felipe Luna ~ 2020 */
package aoc_day02;

import java.util.List;
import java.util.stream.Collectors;

public class Day2 {

	public static boolean isValid(Entry entry) {
		if (entry.password.length() == 0) {
			return false;
		}
		int times = 0;
		for (char c : entry.password.toCharArray()) {
			if (c == entry.letter) {
				times++;
			}
		}
		if (entry.min <= times && times <= entry.max) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isValid2(Entry entry) {
		if (entry.password.length() == 0) {
			return false;
		}

		if (entry.min > entry.password.length()) {
			return false;
		}

		if (entry.max > entry.password.length()) {
			return false;
		}

		if (entry.password.charAt(entry.min - 1) == entry.letter
				^ entry.password.charAt(entry.max - 1) == entry.letter) {
			return true;
		} else {
			return false;
		}
	}

	public static long valids(List<Entry> entries) {
		return entries.stream().map(entry -> isValid(entry)).filter(i -> i == true).count();
	}

	public static long valids2(List<Entry> entries) {
		return entries.stream().map(entry -> isValid2(entry)).filter(i -> i == true).count();
	}

	public static List<Entry> toListEntry(List<String> l) {
		return l.stream().map(s -> new Entry(s)).collect(Collectors.toList());
	}
}
