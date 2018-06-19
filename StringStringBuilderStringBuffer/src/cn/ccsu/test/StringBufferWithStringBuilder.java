package cn.ccsu.test;

import org.junit.Test;

public class StringBufferWithStringBuilder {

	public StringBufferWithStringBuilder() {

	}

	public void testString() {
		long start = System.currentTimeMillis();
		String str = null;
		for (int i = 0; i < 20000; i++) {
			str = str + i + ",";
		}
		System.out.println(System.currentTimeMillis() - start);
	}

	public void testStringBuffer() {
		long start = System.currentTimeMillis();

		StringBuffer sbuf = new StringBuffer();
		for (int i = 0; i < 20000; i++) {
			sbuf.append(i + ",");
		}
		System.out.println(System.currentTimeMillis() - start);
	}

	public void testStringBulider() {
		long start = System.currentTimeMillis();

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 20000; i++) {
			builder.append(i + ",");
		}
		System.out.println(System.currentTimeMillis() - start);
	}

	@Test
	public void test() {

		System.out.print("String:");
		testString();

		System.out.print("StringBuffer:");
		testStringBuffer();

		System.out.print("StringBulider:");
		testStringBulider();

	}

}
