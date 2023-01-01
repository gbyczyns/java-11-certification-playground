package lang;

public class StackOverflowTest {
	public static class A {
		B b = new B();
	}

	public static class B {
		A a = new A();
	}

	public static void main(String[] args) {
		A a = new A();
		System.out.println("test: " + a);
	}
}
