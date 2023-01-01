package lang;

public class LoopTest {
	public static void main(String[] args) {
		int sum = 0;
		for (var i = 0; i < 7; i++) {
			if (i == 4) {
				break;
			} else {
				continue;
			}
//			sum += i; // unreachable
		}
	}
}
