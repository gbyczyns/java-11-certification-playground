package inheritance;

class OuterFoo {
	void test() {
	}
}

public class SamePackageInheritanceTest {

	static class InnerFoo {
		void test() {
		}
	}

	class Bar extends InnerFoo {
		@Override // da się tę metodę nadpisać nawet mimo tego, że ma widoczność default
		void test() {
			super.test();
		}
	}

	class Baz extends OuterFoo {

	}
}

class Bac extends SamePackageInheritanceTest.InnerFoo {

}