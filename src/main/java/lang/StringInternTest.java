package lang;

public class StringInternTest {
	public static void main(String[] args) {
		{
			String s1 = "text";
			String s2 = new String(s1).intern();
			System.out.println(s1 == s2);
		}
		{
			String s1 = new String("text".getBytes());
			String s2 = "text";
			System.out.println(s1 == s2);
		}
		{
			StringBuilder sb = new StringBuilder("text");
			String s = new String(sb);
			System.out.println("text" == s);
		}
	}
}
