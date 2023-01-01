package concurrency;

public class ThreadSleepTest {

	public static void main(String[] args) {
		Runnable runnable = () -> {
			Thread thread = Thread.currentThread();
			do {
				try {
					System.out.println("Waiting");
					Thread.sleep(10000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
					return;
				}
			} while (!thread.isInterrupted());
		};

		Thread thread = new Thread(runnable);
		thread.start();
		thread.interrupt();
	}
}
