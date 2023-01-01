package concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTest {
	public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
		ExecutorService executorService = Executors.newWorkStealingPool();
		Future<String> future = executorService.submit(() -> {
//			Thread.sleep(5000L);
//			return "Hello world";
			throw new IllegalStateException("Failed");
		});
		executorService.shutdown();
		System.out.println(future.get(1000L, TimeUnit.MILLISECONDS));
	}
}
