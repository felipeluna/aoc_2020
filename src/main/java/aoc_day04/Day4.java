/* Felipe Luna ~ 2020 */
package aoc_day04;

import java.util.List;

public class Day4 {

	public static long valids(List<String> l) {
		return l.stream().map(it -> new Passport(it).isValid()).filter(it -> it.equals(true)).count();
	}

	public static long valids2(List<String> l) {
		return l.stream().map(it -> new Passport(it).isValid2()).filter(it -> it.equals(true)).count();
	}
}
