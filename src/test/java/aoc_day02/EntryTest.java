/* Felipe Luna ~ 2020 */
package aoc_day02;

import static org.junit.Assert.*;

import org.junit.Test;

public class EntryTest {

	@Test
	public void test() {
		Entry entry = new Entry("1-3 a: abcde");
		assertEquals(1, entry.min);
		assertEquals(3, entry.max);
		assertEquals('a', entry.letter);
		assertEquals("abcde", entry.password);
	}
}
