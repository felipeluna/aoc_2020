/* Felipe Luna ~ 2020 */
package aoc_day04;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Passport {

	Map<String, String> pass;

	public Passport(String line) {
		pass = parsePassport(line);
	}

	private Map<String, String> parsePassport(String line) {
		Map<String, String> m = new HashMap<>();

		for (String s : line.split(" ")) {
			String[] data = s.split(":");
			m.put(data[0], data[1]);
		}
		return m;
	}

	public boolean isValid() {
		boolean byrPresent = this.pass.containsKey("byr");
		boolean iyrPresent = this.pass.containsKey("iyr");
		boolean eyrPresent = this.pass.containsKey("eyr");
		boolean hgtPresent = this.pass.containsKey("hgt");
		boolean hclPresent = this.pass.containsKey("hcl");
		boolean eclPresent = this.pass.containsKey("ecl");
		boolean pidPresent = this.pass.containsKey("pid");
		return byrPresent && iyrPresent && eyrPresent && hgtPresent && hclPresent && eclPresent && pidPresent;
	}

	public boolean isValid2() {
		boolean byrPresent = this.pass.containsKey("byr");
		if (byrPresent) {
			byrPresent = yearValid(this.pass.get("byr"), 1920, 2002);
		}
		boolean iyrPresent = this.pass.containsKey("iyr");
		if (iyrPresent) {
			iyrPresent = yearValid(this.pass.get("iyr"), 2010, 2020);
		}
		boolean eyrPresent = this.pass.containsKey("eyr");
		if (eyrPresent) {
			eyrPresent = yearValid(this.pass.get("eyr"), 2020, 2030);
		}
		boolean hgtPresent = this.pass.containsKey("hgt");
		if (hgtPresent) {
			hgtPresent = heightValid(this.pass.get("hgt"));
		}
		boolean hclPresent = this.pass.containsKey("hcl");
		if (hclPresent) {
			hclPresent = hclValid(this.pass.get("hcl"));
		}
		boolean eclPresent = this.pass.containsKey("ecl");
		if (eclPresent) {
			eclPresent = eclValid(this.pass.get("ecl"));
		}
		boolean pidPresent = this.pass.containsKey("pid");
		if (pidPresent) {
			pidPresent = pidValid(this.pass.get("pid"));
		}

		return byrPresent && iyrPresent && eyrPresent && hgtPresent && hclPresent && eclPresent && pidPresent;
	}

	public boolean yearValid(String s, int min, int max) {
		if (s.length() != 4) {
			return false;
		}
		int year = Integer.parseInt(s);
		if (min <= year && year <= max) {
			return true;
		}
		return false;
	}

	public boolean heightValid(String hgt) {
		if (hgt.length() < 2) {
			return false;
		}
		String unit = hgt.substring(hgt.length() - 2, hgt.length());

		String value = hgt.substring(0, hgt.length() - 2);
		if (value.length() < 1) {
			return false;
		}
		long v = Long.parseLong(value);
		if ("cm".equals(unit)) {
			if (150 <= v && v <= 193) {
				return true;
			}
			return false;
		}
		if ("in".equals(unit)) {
			if (59 <= v && v <= 76) {
				return true;
			}
			return false;
		}

		return false;
	}

	public boolean hclValid(String hcl) {
		if (hcl.length() != 7) {
			return false;
		}
		final String regex = "#[0-9a-f]{6}";

		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(hcl);

		if (matcher.find()) {
			return true;
		}
		return false;
	}

	public boolean eclValid(String ecl) {
		if ("amb".equals(ecl) || "blu".equals(ecl) || "brn".equals(ecl) || "gry".equals(ecl) || "grn".equals(ecl)
				|| "hzl".equals(ecl) || "oth".equals(ecl)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean pidValid(String pid) {
		if (pid.length() != 9) {
			return false;
		}

		final String regex = "[0-9]{9}";

		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(pid);

		if (matcher.find()) {
			return true;
		}
		return false;
	}
}
