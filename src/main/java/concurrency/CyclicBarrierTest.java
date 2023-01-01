package concurrency;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class CyclicBarrierTest {
	public static void main(String[] args) {
		int threads = 10;
		Random random = new SecureRandom();
		CyclicBarrier barrier = new CyclicBarrier(threads, () -> System.out.println("Barrier has been tripped."));
		ExecutorService executorService = Executors.newFixedThreadPool(threads);

		IntStream.range(0, threads).mapToObj(threadNo ->
				(Runnable) () -> {
					try {
						long sleepTime = random.nextInt(10000);
						Thread.sleep(sleepTime);
						System.out.println("Thread " + threadNo + " took " + sleepTime + " ms to complete.");
						barrier.await();
						System.out.println("Thread finished:" + threadNo);
					} catch (InterruptedException | BrokenBarrierException e) {
						e.printStackTrace();
					}
				})
				.forEach(executorService::execute);
		executorService.shutdown();
	}
}