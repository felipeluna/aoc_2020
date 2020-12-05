/* Felipe Luna ~ 2020 */
package aoc_day03;

import static org.junit.Assert.*;

import aoc.AocTest;
import org.junit.Before;
import org.junit.Test;

public class Day3Test extends AocTest {

	String[] file;

	@Before
	public void setup() {
		file = library.parseFile("aoc_2020_03.txt").toArray(String[]::new);
	}

	@Test
	public void demo() {
		assertEquals(7, Day3.traverse(Day3.demoInput, 3, 1));
		assertEquals(2, Day3.traverse(Day3.demoInput, 1, 1));
		assertEquals(3, Day3.traverse(Day3.demoInput, 5, 1));
		assertEquals(4, Day3.traverse(Day3.demoInput, 7, 1));
		assertEquals(2, Day3.traverse(Day3.demoInput, 1, 2));
	}

	@Test
	public void test_1() {
		assertEquals(187, Day3.traverse(file, 3, 1));
	}

	@Test
	public void test_2() {
		assertEquals(4723283400L, Day3.traverse2(file));
	}
}
