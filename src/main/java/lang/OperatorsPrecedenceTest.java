package lang;

public class OperatorsPrecedenceTest {


	public static void main(String[] args) {
		System.out.println(v(false, "1") || v(true, "2") | v(false, "3"));

		boolean status = true;
//		System.out.println(status = false || status = true | status = false);
		System.out.println(status);

	}

	private static boolean v(boolean value, String desc) {
		System.out.println(desc);
		return value;
	}

}
