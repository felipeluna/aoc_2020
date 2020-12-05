/* Felipe Luna ~ 2020 */
package aoc_day03;

import aoc.Library;

public class Day3 {

	public static final Library library = new Library();

	public static final String[] demoInput = library.parseFile("aoc_2020_03-demo.txt").toArray(String[]::new);

	public static long traverse(String[] map, int right, int down) {
		int line = down;
		int column = 0;
		long count = 0;
		while (line < map.length) {
			column = (column + right) % map[line].length();

			if (map[line].charAt(column) == '#') {
				count++;
			}
			line += down;
		}
		return count;
	}

	public static long traverse2(String[] map) {

		long first = traverse(map, 1, 1);
		long second = traverse(map, 3, 1);
		long third = traverse(map, 5, 1);
		long fourth = traverse(map, 7, 1);
		long fifth = traverse(map, 1, 2);
		return first * second * third * fourth * fifth;
	}
}
