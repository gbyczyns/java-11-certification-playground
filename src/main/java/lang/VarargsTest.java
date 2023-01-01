package lang;

import java.util.Arrays;

public class VarargsTest {

	public static void main(String[] args) {
		String[] plants = broken("seed"); // ClassCastException
		System.out.println(Arrays.toString(plants));
	}

	public static <T> T[] unsafe(T... elements) {
		return elements; // unsafe! don't ever return a parameterized varargs array
	}

	public static <T> T[] broken(T seed) {
		T[] plant = unsafe(seed, seed, seed); // broken! This will be an Object[] no matter what T is
		return plant;
	}
}
