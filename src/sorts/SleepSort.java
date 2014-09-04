package sorts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SleepSort implements Sorter {

	private static final int SLEEP_FACTOR = 100;

	@Override
	public void sort(int[] array) {
		List<Thread> threadList = new ArrayList<>();
		AtomicInteger counter = new AtomicInteger(0);
		for (int entry : array) {

			if (entry < 1) {
				throw new IllegalArgumentException(
						"Do not accept negative values");
			}

			SleepSortThread currentThread = new SleepSortThread(entry, array,
					counter);
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

	}

	static class SleepSortThread extends Thread {

		private int sleepNumber;
		private int[] array;
		private AtomicInteger counter;

		public SleepSortThread(final int sleepNumber, final int[] array,
				AtomicInteger counter) {
			this.sleepNumber = sleepNumber;
			this.array = array;
			this.counter = counter;
		}

		public void run() {
			try {
				Thread.sleep(sleepNumber * SLEEP_FACTOR);
				array[counter.getAndIncrement()] = sleepNumber;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
