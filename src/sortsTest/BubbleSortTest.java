package sortsTest;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import sorts.BubbleSort;
import sorts.Sorter;

public class BubbleSortTest {
	@Test
	public void allArgsSucceeds() {
		int[] test = { 5, 4, 3, 2, 1 };
		Sorter testSorter = new BubbleSort();
		testSorter.sort(test);
		int[] sortedTest = { 1, 2, 3, 4, 5 };
		assertArrayEquals(test, sortedTest);
	}
}
