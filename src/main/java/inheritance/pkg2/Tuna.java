package inheritance.pkg2;

import inheritance.pkg1.Fish;

public class Tuna extends Fish {
	void test() {
		Fish fish = this;
//		fish.size = 12; // doesn't work
//		fish.swim();
		Fish.staticMethod();
	}
}