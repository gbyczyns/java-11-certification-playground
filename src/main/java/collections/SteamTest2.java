package collections;

import java.util.Random;
import java.util.stream.Stream;

public class SteamTest2 {
	public static void main(String[] args) {
		Random random = new Random();
		Stream.generate(() -> random.nextInt(10000))
				.takeWhile(i -> i != 0)
				.forEach(System.out::println);

		Stream<Integer> numStream = Stream.of(10, 20, 30);
		numStream.map(n -> n + 10).peek(s -> System.out.print(s));
		numStream.forEach(s -> System.out.println(s));
	}
}
