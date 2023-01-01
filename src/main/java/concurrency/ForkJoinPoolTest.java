package concurrency;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
class User {
	private long id;
	private String name;
	private String surname;
	private String country;
}

public class ForkJoinPoolTest {
	public static void main(String[] args) {
		List<User> users = List.of(
				new User(1L, "A", "AAAA", "USA"),
				new User(1L, "B", "BBVV", "USA"),
				new User(1L, "C", "CCCC", "USA"),
				new User(1L, "D", "DDDD", "Poland"),
				new User(1L, "E", "EEEE", "Poland"),
				new User(1L, "F", "FFFF", "Serbia"),
				new User(1L, "G", "GGGG", "USA"),
				new User(1L, "H", "HHHH", "USA"),
				new User(1L, "I", "IIII", "USA"),
				new User(1L, "J", "JJJJ", "Poland"),
				new User(1L, "K", "KKKK", "Poland"),
				new User(1L, "L", "LLLL", "Serbia"),
				new User(1L, "M", "MMMM", "USA"),
				new User(1L, "N", "NNNN", "USA"),
				new User(1L, "O", "OOOO", "USA"),
				new User(1L, "P", "PPPP", "Poland"),
				new User(1L, "Q", "QQQQ", "Poland"),
				new User(1L, "R", "RRRR", "Serbia"),
				new User(1L, "S", "SSSS", "USA"),
				new User(1L, "T", "TTTT", "USA"),
				new User(1L, "U", "UUUU", "USA"),
				new User(1L, "V", "VVVV", "Poland"),
				new User(1L, "W", "WWWW", "Poland"),
				new User(1L, "X", "XXXX", "Serbia"),
				new User(1L, "Y", "YYYY", "Serbia"),
				new User(1L, "Z", "ZZZZ", "Serbia")
		);
		printNumberOfCountries(users);
		System.out.println("---------");
		printNumberOfCountries2(users);
	}

	public static void printNumberOfCountries(List<User> users) {
		users.parallelStream()
				.collect(Collectors.groupingByConcurrent(User::getCountry, Collectors.counting()))
				.forEach((country, count) -> System.out.println(country + ": " + count));
	}

	public static void printNumberOfCountries2(List<User> users) {
		Spliterator<User> spliterator = users.spliterator();
		Map<String, Long> result = new ForkJoinPool().invoke(new GroupingTask(spliterator));
		result.forEach((country, count) -> System.out.println(country + ": " + count));
	}

	@AllArgsConstructor
	static class GroupingTask extends RecursiveTask<Map<String, Long>> {
		private static final long THRESHOLD = 4;
		private final Spliterator<User> spliterator;

		@Override
		protected Map<String, Long> compute() {
			if (spliterator.estimateSize() > THRESHOLD) {
				var forkedTask = new GroupingTask(spliterator.trySplit()).fork();
				Map<String, Long> result = new GroupingTask(spliterator).compute();
				forkedTask.join().forEach((country, count) -> result.merge(country, count, Long::sum));
				return result;
			}
			return StreamSupport.stream(spliterator, true)
					.collect(Collectors.groupingByConcurrent(User::getCountry, Collectors.counting()));
		}
	}
}