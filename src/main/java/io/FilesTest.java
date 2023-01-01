package io;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class FilesTest {
	public static void main(String[] args) {
		//		Console console = System.console();
		//		console.printf("Hello world");

		FileSystem fs = FileSystems.getDefault();
		Iterable<Path> rootDirectories = fs.getRootDirectories();
		for (Path p : rootDirectories) {
			System.out.println(p);
		}
	}
}
