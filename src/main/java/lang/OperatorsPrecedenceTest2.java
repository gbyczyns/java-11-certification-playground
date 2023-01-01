package lang;

import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

public class OperatorsPrecedenceTest2 {
	public static int operate(IntUnaryOperator iuo) {
		return iuo.applyAsInt(5);
	}

	public static void main(String[] args) {
		IntFunction<IntUnaryOperator> fo = a -> b -> a - b;
		var x = operate(fo.apply(20));
		System.out.println(x);
	}
}