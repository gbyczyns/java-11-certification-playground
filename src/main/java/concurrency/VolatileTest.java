package concurrency;

public class VolatileTest {

	static class Shared {
		public volatile int x;
		public volatile int y;
	}

	public static void main(String[] args) {
		Shared shared = new Shared();
		new Thread(() -> {
			while (shared.y < 1) {
				System.out.println(shared.x);
			}
		}).start();

		new Thread(() -> {
			shared.x = 2;
			shared.y = 2;
		}).start();
	}
}