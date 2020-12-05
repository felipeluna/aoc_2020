/* Felipe Luna ~ 2020 */
package aoc_day01;

import static org.junit.Assert.assertEquals;

import aoc.AocTest;
import aoc.Library;
import org.junit.Before;
import org.junit.Test;

public class Day1Test extends AocTest {

	public long[] file;

	@Before
	public void setup() {
		file = Library.toArrayLong(library.parseFile("aoc_2020_01.txt"));
	}

	@Test
	public void test_1() {
		assertEquals(618144, Day1.find(file));
	}

	@Test
	public void test_2() {
		assertEquals(173538720, Day1.find2(file));
	}
}
