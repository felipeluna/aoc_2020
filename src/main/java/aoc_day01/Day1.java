/* Felipe Luna ~ 2020 */
package aoc_day01;

public class Day1 {

	public static final long[] demoEntry = new long[]{1721, 979, 366, 299, 675, 1456};

	public static long find(long[] entry) {

		for (int i = 0; i < entry.length - 1; i++) {
			for (int j = i; j < entry.length; j++) {
				if (entry[i] + entry[j] == 2020) {
					return entry[i] * entry[j];
				}
			}
		}

		return 0;
	}

	public static long find2(long[] entry) {

		for (int i = 0; i < entry.length - 2; i++) {
			for (int j = i; j < entry.length - 1; j++) {
				for (int v = j; v < entry.length; v++)
					if (entry[i] + entry[j] + entry[v] == 2020) {
						return entry[i] * entry[j] * entry[v];
					}
			}
		}

		return 0;
	}
}
