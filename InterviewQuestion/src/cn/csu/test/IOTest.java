package cn.csu.test;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

public class IOTest {

	public IOTest() {
	}

	IOTest(int a) {
		super();
		@SuppressWarnings("unused")
		int x = 3;
	}

	@Test
	public void name() {
		System.out.println(3 * 0.1);
		System.out.println(3 * 0.1 == 0.3);
		Integer[] a= {20,45,130,20,60,22};
		System.out.println(Arrays.deepToString(a));
	}

	public byte name(ConcurrentHashMap<String, Object> map) {
		return 0;
	}

	@Test
	public void writer() {
		byte a = 12;
		String.valueOf(a);
		int i = 12;
		System.out.println(i -= i *= i);

		System.out.println(IOTest.class);

		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileOutputStream("abc.txt"));
			String name = "chen";
			out.print(name);
		} catch (Exception e) {
			System.out.println("文件没有发现！");
		} finally {
			out.close();
		}

	}
}

class Super {
	protected float getNum() {
		return 3.0f;
	}
}

class Sub extends Super {
	// Here

	@SuppressWarnings("unused")
	private void getNum(double d) {
	}

}

class Book {
	protected int getPrice() {
		return 0;
	}

}

class ComputerBook extends Book {
	protected int getPrice(int page) {
		return page;
	}

	public int getPrice() {
		return 10;
	}
}
