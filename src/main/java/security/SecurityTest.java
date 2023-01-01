package security;

import java.io.FilePermission;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class SecurityTest {
	public static void main(String[] args) throws IOException {
		System.setSecurityManager(new SecurityManager());
		new URL("http://www.google.com").openConnection().connect();

//		FilePermission filePermission = new FilePermission("/Users/byczynsg/Desktop", "read");
//		AccessController.checkPermission(filePermission);
//		PrivilegedAction<String> action;
	}
}
