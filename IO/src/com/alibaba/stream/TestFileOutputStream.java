package com.alibaba.stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class TestFileOutputStream {

	@Test
	public void test() {

		FileOutputStream out = null;
		try {

			File file = new File("Test.txt");
			out = new FileOutputStream(file);
			out.write("Java Linux \nUnix Hello,spring!! \n\n Fire!!".getBytes());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null)
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}
