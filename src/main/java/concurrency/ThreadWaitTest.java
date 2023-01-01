package concurrency;

import lombok.SneakyThrows;

public class ThreadWaitTest {

	@SneakyThrows
	public static void main(String[] args) {
		Object lock = new Object();

		Runnable runnable = () -> {
			synchronized (lock) {
				try {
					System.out.println("Waiting");
					lock.wait();
					System.out.println("Notified");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Thread thread = new Thread(runnable);
		thread.start();

		// delay so that the thread can start
		Thread.sleep(100L);

		synchronized (lock) {
			lock.notify();
		}
	}
}
