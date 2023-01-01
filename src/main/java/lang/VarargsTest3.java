package lang;

class One {
	void test(byte val) {
		System.out.println("byte");
	}

	void test(int... values) {
		System.out.println("int...");
	}
}

class Two {
	void test(int val) {
		System.out.println("int");
	}

	void test(byte... values) {
		System.out.println("byte...");
	}
}

public class VarargsTest3 {

	public static void main(String[] args) {
		new One().test(1);
		new One().test((byte) 1);

		new Two().test(1);
		new Two().test((byte) 1); // WTF
		new Two().test((byte) 1, (byte) 2);
	}

}
