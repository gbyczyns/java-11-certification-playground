package lang;

public class SwitchTest {
	public static void main(String[] args) {
		int day = 3; // will not work with Integer!
		switch (day) {
			case '3':
				break;
		}

		test1('c');
//		test2('c'); // doesn't work
	}

	private static void test1(int i) {
	}

	private static void test2(Integer i) {
	}
}
