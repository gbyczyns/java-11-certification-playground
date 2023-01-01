package lang;

import org.apache.commons.lang3.StringUtils;

public class AssignmentsTest {
	public static void main(String[] args) {
		test("A", "A", false);
		test("A", "B", true);
		test("A", null, true);
		test(null, "B", true);
		test(null, null, false);
	}

	public static void test(String oldAssignment, String newAssignment, boolean expected) {
		boolean result;
		if (oldAssignment == null ^ newAssignment == null || oldAssignment != null && !oldAssignment.toString().equals(newAssignment.toString())) {
			result = true;
		} else {
			result = false;
		}

		System.out.println(result == expected ? "OK" : "Chuj");
	}

	public static void test2(String oldAssignment, String newAssignment, boolean expected) {
		boolean result;
		if ((oldAssignment == null && newAssignment == null) || (oldAssignment != null && newAssignment != null && StringUtils.equals(oldAssignment.toString(), newAssignment.toString()))) {
			result = false;
		} else {
			result = true;
		}

		System.out.println(result == expected ? "OK" : "Chuj");
	}
}