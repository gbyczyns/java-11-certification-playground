package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class PecsTest {
	static class Product {
	}

	static class Food extends Product {
	}

	static class Drink extends Product {
	}

	public static void main(String[] args) {
		boolean enabled = false;
		assert enabled = true;
		assert enabled;

		{
			List<?> list0 = new ArrayList<>();
			//		list0.add(new Object()); // nothing can be added to such list, except null
		}

		{
			List<? extends Product> list1 = new ArrayList<>();
			//		list1.add(new Drink()); // cannot be added
			Product p1 = list1.get(0);
		}

		{
			List<? super Product> list = new ArrayList<>();
			list.add(new Food());
			list.add(new Drink());
			list.add(new Product());
//			list.add(new Object()); //nope
//			list.add("String"); // nope
			Product p2 = (Product) list.get(0); // needs to be casted
		}
		{
			List<? super Product> list1 = new ArrayList<Object>();
			List<? super Food> list2 = new ArrayList<>();
//			List<? super Product> list2 = new ArrayList<Food>();
//			List<? super Food> list3 = new ArrayList<Drink>();
		}
	}

	double calculate(double number, Function<Integer, Double> function) {
		return function.apply((int) number);
	}
}
