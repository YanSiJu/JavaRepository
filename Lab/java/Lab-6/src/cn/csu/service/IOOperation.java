package cn.csu.service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOOperation {

	// “20102324，张三，男，25，软件工程”

	public static void testIO() throws IOException {

		FileWriter writer = new FileWriter("a.txt");
		writer.write("20102324，张三，男，25，软件工程");
		writer.close();

		FileReader reader = new FileReader("a.txt");
		char[] c = new char[2];
		int len = 0;
		while ((len = reader.read(c)) != -1) {

			System.out.print(String.valueOf(c, 0, len));
		}
		reader.close();
		
	}
}
