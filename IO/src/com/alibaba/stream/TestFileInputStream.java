package com.alibaba.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;

public class TestFileInputStream {

	@Test
	public void test() {

		FileInputStream in = null;
		try {

			File file = new File("Hello.txt");
			in = new FileInputStream(file);
			byte[] b = new byte[5];
			int len = 0;
			while ((len = in.read(b)) != -1) {

				for (int i = 0; i < len; i++)
					System.out.print((char)b[i]);

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
