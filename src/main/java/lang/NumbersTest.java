package lang;

public class NumbersTest {
	public static void main(String[] args) {

		long i = Integer.MAX_VALUE;
		i++;
		System.out.println(i);

		int j = (int) Long.MAX_VALUE;
		System.out.println(j);

		short a = 4, b = 6;
		float result = a / (float) b;
		System.out.println(result);

		var xx = 0xFF;
	}
}
