package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsTest {
	public static void main(String[] args) throws InterruptedException {
		{
			ExecutorService executorService = Executors.newFixedThreadPool(10);
			Runnable runnable = () -> {
				System.out.println(Thread.currentThread().getName());
			};
			executorService.submit(runnable);
			executorService.submit(runnable);
			executorService.submit(runnable);
			executorService.shutdown();
		}
		{
			ScheduledExecutorService ses = Executors.newScheduledThreadPool(4, runnable -> new Thread(runnable));
			ses.scheduleAtFixedRate(() -> System.out.println(Thread.currentThread().getName()), 0, 50L,  TimeUnit.MILLISECONDS);
			Thread.sleep(3000L); // delay
			ses.shutdown();
		}
	}
}
