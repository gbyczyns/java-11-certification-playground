package collections;

import java.util.ArrayList;
import java.util.List;

public class CollectionsTest2 {
	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		strings.add("A");
		strings.add("E");
		strings.add("I");
		strings.add("O");
		strings.add("U");
		strings.addAll(strings.subList(0, 4));
		System.out.println(strings);

		String[] arr = new String[3];
		arr[5].length();
	}
}
