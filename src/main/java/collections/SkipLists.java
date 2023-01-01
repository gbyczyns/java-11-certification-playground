package collections;

import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

public class SkipLists {
	public static void main(String[] args) {
		List<Integer> integers = List.of(10, 3, 8, 0, 15, 100, 67, 999, 2);
		ConcurrentSkipListSet<Integer> concurrentSkipListSet = new ConcurrentSkipListSet<>(integers);
		System.out.println(concurrentSkipListSet);

		TreeSet<Integer> treeSet = new TreeSet<>(integers);
		System.out.println(treeSet);
	}
}
