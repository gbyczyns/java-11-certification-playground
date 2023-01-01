package collections;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {

		var r1 = Stream.of("a", "bb", "cccc")
				.reduce(0, (v1, str) -> v1 + str.length(), (i1, i2) -> i1 + i2);
		System.out.println(r1);

		var r2 = Stream.of("a", "bb", "cccc")
				.map(String::length)
				.reduce((i1, i2) -> i1 + i2)
				.orElse(0);
		System.out.println(r2);

		var r3 = Stream.of("a", "bb", "cccc")
				.map(String::length)
				.reduce(0, (i1, i2) -> i1 + i2);
		System.out.println(r3);

		var r4 = Stream.of("a", "bb", "cccc")
				.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
		System.out.println(r4);

		var r5 = Stream.of("a", "bb", "cccc")
				.collect(Collectors.groupingBy(String::length));

		var r6 = Stream.of("a", "bb", "cccc")
				.collect(Collectors.partitioningBy(String::isBlank));
	}
}
