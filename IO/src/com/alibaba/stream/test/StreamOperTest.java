package com.alibaba.stream.test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.alibaba.stream.StreamOper;

public class StreamOperTest {

	@Test
	public void testCopyFile() {
		fail("Not yet implemented");

		String src = "C:\\Users\\Bill\\Desktop\\Java8 新特性.pdf";
		String dest = "C:\\Users\\Bill\\Desktop\\Java8 新特性_1.pdf";
		long start = System.nanoTime();
		StreamOper.copyFile(src, dest);
		long end = System.nanoTime();
		System.out.println("不使用缓冲流耗时:" + (end - start));

	}

	@Test
	public void testcopyFileWithBuffer() {
		fail("Not yet implemented");

		String src = "C:\\Users\\Bill\\Desktop\\Java8 新特性.pdf";
		String dest = "C:\\Users\\Bill\\Desktop\\Java8 新特性_2.pdf";
		long start = System.nanoTime();
		StreamOper.copyFileWithBuffer(src, dest);
		long end = System.nanoTime();
		System.out.println("---->使用缓冲流耗时:" + (end - start));
	}

	@Test
	public void testInsert() {
		// fail("Not yet implemented");
		String fileName = "Test.txt";
		String content = "\nUse RandomAccessFile to modify file!!\n";
		int pos = 7;
		StreamOper.insert(fileName, content, pos);

	}

}
