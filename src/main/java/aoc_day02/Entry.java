/* Felipe Luna ~ 2020 */
package aoc_day02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Entry {
	int min;
	int max;
	char letter;
	String password;

	public Entry(String line) {
		final String regex = "(\\d+)-(\\d+)\\s(.):\\s(.+)";
		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(line);

		while (matcher.find()) {
			this.min = Integer.parseInt(matcher.group(1));
			this.max = Integer.parseInt(matcher.group(2));
			this.letter = matcher.group(3).charAt(0);
			this.password = matcher.group(4);
		}
	}

	@Override
	public String toString() {
		return this.min + " " + this.max + " : " + this.letter + " ~ " + this.password;
	}
}
