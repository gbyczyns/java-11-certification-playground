package concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolTest2 {
	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		int result = forkJoinPool.invoke(new FibonacciTask(19));
		System.out.println("Result: " + result);
	}

	static class FibonacciTask extends RecursiveTask<Integer> {
		private final int n;

		public FibonacciTask(int n) {
			if (n < 0) {
				throw new IllegalArgumentException("Negative numbers not allowed: " + n);
			}
			this.n = n;
		}

		@Override
		protected Integer compute() {
			if (n < 2) {
				return n;
			}
			var fork = new FibonacciTask(n - 2).fork();
			return new FibonacciTask(n - 1).compute() + fork.join();
		}
	}
}
