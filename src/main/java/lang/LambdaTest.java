package lang;

public class LambdaTest {

	private static abstract class Runner {
		abstract void run(String arg);
	}

	public static void main(String[] args) {
//		helloWorld((v -> System.out.println(v)); // abstract class cannot be implemented as lambda expression
		helloWorld(new Runner() {
			@Override
			void run(String arg) {
				System.out.println(arg);
			}
		});
	}

	private static void helloWorld(Runner runner) {
		runner.run("Hello world");
	}
}
