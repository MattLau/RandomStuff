package sorts;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class SleepSortTest {

	@Test
	public void allArgsSucceeds() {
		int[] test = { 5, 4, 3, 2, 1 };
		Sorter testSorter = new SleepSort();
		testSorter.sort(test);
		int[] sortedTest = { 1, 2, 3, 4, 5 };
		assertArrayEquals(test, sortedTest);
	}

	@Test(expected = IllegalArgumentException.class)
	public void negativeFails() {
		int[] test = { -1 };
		Sorter testSorter = new SleepSort();
		testSorter.sort(test);
		fail("should not reach here.");
	}

}
