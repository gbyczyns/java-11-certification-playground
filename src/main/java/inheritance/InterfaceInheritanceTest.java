package inheritance;

interface Super {
	String name = "SUPER"; //Line n1
	static String test() {return "eee";}
}

interface Sub extends Super { //Line n2
	String name = "SUB";
}

public class InterfaceInheritanceTest {
	public static void main(String[] args) {
		Sub sub = null;
		Super sup = null;
		System.out.println(sub.name);
		System.out.println(sup.name);
		System.out.println(Super.name);
		System.out.println(Sub.name);
		System.out.println(Super.test());
		// System.out.println(Sub.test()); // static method may be invoked on containing interface class only
	}
}