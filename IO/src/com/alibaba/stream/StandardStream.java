package com.alibaba.stream;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

public class StandardStream {

	public StandardStream() {

	}

	@Test
	public void test() {

		System.out.println("System.in:" + System.in + "\n");
		System.err.println("System.in:" + System.in + "\n");
		System.out.println("System.out:" + System.out + "\n");
	}

	@Test
	public void printStreamTest() {
		PrintStream ps = null;
		PrintStream out;
		try {
			out = System.out;
			ps = new PrintStream(new FileOutputStream("out.txt"), true);
			System.setOut(ps);

			System.out.println("修改前--->System.out:" + out + "\n");
			System.out.println("修改后--->System.out:" + System.out + "\n\n");
			System.out.println("唐纳德▪特朗普");
			System.out.println(new StandardStream());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
			}
		}

	}

	@Test
	public void inputStreamTest() {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		String str = new String();
		StringBuilder builder = new StringBuilder();
		InputStreamReader reader;
		BufferedReader br = null;
		try {
			fis = new FileInputStream("dbcp.txt");
			bis = new BufferedInputStream(fis);
			System.setIn(bis);
			reader = new InputStreamReader(System.in);
			br = new BufferedReader(reader);

			while ((str = br.readLine()) != null) {
				builder.append(str + "\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("从文件中读出的内容:\n" + builder);

	}

	@Test
	public void scannerTest() {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		Scanner sc = null;
		System.out.println("System.in:" + System.in + "\n\n");
		try {
			fis = new FileInputStream("dbcp.txt");
			bis = new BufferedInputStream(fis);

			System.setIn(bis);
			System.out.println("System.in:" + System.in + "\nbis:" + bis + "\n");
			sc = new Scanner(System.in);
			while (sc.hasNext()) {
				System.out.println(sc.next());
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (sc != null) {
				sc.close();
			}

		}

	}

}
