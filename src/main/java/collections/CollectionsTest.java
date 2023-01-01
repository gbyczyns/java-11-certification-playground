package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionsTest {
	public static void main(String[] args) {
		var list1 = Arrays.asList(1, 2, 3, 4);
		list1.replaceAll(v -> v + 1);
		System.out.println(list1);

		var list2 = List.of(1, 2, 3, 4);
		list2.replaceAll(v -> v + 1);
		System.out.println(list2);
	}
}
