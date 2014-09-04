package sorts;

import java.util.ArrayList;
import java.util.List;

public class SleepSort implements Sorter {

	private static final int SLEEP_FACTOR = 100;

	@Override
	public void sort(int[] array) {
		List<Integer> toAddList = new ArrayList<>();
		List<Thread> threadList = new ArrayList<>();
		for (int entry : array) {

			if (entry < 1) {
				throw new IllegalArgumentException(
						"Do not accept negative values");
			}

			SleepSortThread currentThread = new SleepSortThread(entry,
					toAddList);
			threadList.add(currentThread);
		}
		for (Thread t : threadList) {
			t.start();
		}
		for (Thread t : threadList) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < array.length; i++) {
			array[i] = toAddList.get(i);
		}

	}

	static class SleepSortThread extends Thread {

		private int sleepNumber;
		private List<Integer> addToList;

		public SleepSortThread(final int sleepNumber,
				final List<Integer> addToList) {
			this.sleepNumber = sleepNumber;
			this.addToList = addToList;
		}

		public void run() {
			try {
				Thread.sleep(sleepNumber * SLEEP_FACTOR);
				addToList.add(sleepNumber);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
