package inheritance.foobar;

class Foo {
	protected String myField = "foo";

	protected /* static */ String myMethod() { // static nie działa, bo nie można nadpisywać statycznych metod
		return "Foo";
	}
}

public class Bar extends Foo {
	private String myField = "Bar";

	public String myMethod() {
		System.out.println(this.myField);
		System.out.println(super.myField);
		return "Bar";
	}

	public static void main(String[] args) {
		Foo foo = new Bar();
		System.out.println(foo.myField);
		System.out.println(foo.myMethod());
	}
}
