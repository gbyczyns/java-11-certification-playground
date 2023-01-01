package lang;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class ExceptionTest {
	public static void main(String[] args) {
		try {
			test();
		} catch (NoSuchFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void test() throws Exception {
	}
}
