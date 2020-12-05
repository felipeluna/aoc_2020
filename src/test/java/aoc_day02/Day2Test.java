/* Felipe Luna ~ 2020 */
package aoc_day02;

import static org.junit.Assert.*;

import aoc.AocTest;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class Day2Test extends AocTest {

	public List<Entry> file;

	@Before
	public void setup() {
		file = Day2.toListEntry((library.parseFile("aoc_2020_02.txt")));
	}

	@Test
	public void isValid() {
		assertTrue(Day2.isValid(new Entry("1-3 a: abcde")));
		assertTrue(Day2.isValid(new Entry("2-4 g: zgggp")));
		assertFalse(Day2.isValid(new Entry("14-15 x: xxxxxxxxxxxcxxgm")));
		assertFalse(Day2.isValid(new Entry("1-3 b: cdefg")));
		assertTrue(Day2.isValid(new Entry("2-9 c: ccccccccc")));
	}

	@Test
	public void isValid2() {
		assertTrue(Day2.isValid2(new Entry("1-3 a: abcde")));
		assertFalse(Day2.isValid2(new Entry("1-3 b: cdefg")));
		assertFalse(Day2.isValid2(new Entry("2-9 c: ccccccccc")));
	}

	@Test
	public void test() {
		assertEquals(603, Day2.valids(file));
	}

	@Test
	public void test2() {
		assertEquals(404, Day2.valids2(file));
	}
}
