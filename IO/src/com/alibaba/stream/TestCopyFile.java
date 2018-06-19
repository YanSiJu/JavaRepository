package com.alibaba.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class TestCopyFile {

	@Test
	public void Test() {

		FileInputStream in = null;
		
		FileOutputStream out = null;

		try {
			long start = System.currentTimeMillis();
			// 变量初始化
			File src = new File(
					"I:\\Learning_Data\\Professional_Course_Info\\Java\\Java SE" + "\\Java SE视频\\第10章：IO(day15-day16)\\"
							+ "第10章：IO(day15-day16)\\day15\\day15_05File" + "InputStream的使用.wmv");
			File dest = new File("C:\\Users\\Bill\\Desktop\\Video.wmv");
			in = new FileInputStream(src);
			out = new FileOutputStream(dest);

			// 从源文件读取数据，并写入到目标文件中
			int len = 0;
			byte[] b = new byte[1024];
			while ((len = in.read(b)) != -1) {
				out.write(b, 0, len);
			}
			long end = System.currentTimeMillis();
			System.out.println("总共花费：" + (end - start));

		} catch (IOException e) {

		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			if (out != null)
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

}
