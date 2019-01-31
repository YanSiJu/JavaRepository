package cn.csu.test;

import org.junit.jupiter.api.Test;

public class StringTest {

	@Test
	public void test_1() {
		String str1 = "hello";
		String str2 = "he" + new String("llo");
		System.err.println(str1 == str2);// false
	}

	@Test
	public void test_2() {
		String str1 = "hello";
		String str2 = "he" + "llo";
		System.err.println(str1 == str2);// true
	}

	@Test
	public void test_3() {
		String str1 = "hello";
		String str2 = "he";
		String str3 = "llo";
		String str4 = str2 + str3;
		System.err.println(str1 == str4);// false
	}

	@Test
	public void name() {
		int a = 0;
		int c = 0;
		do {
			--c;
			a = a - 1;
		} while (a > 0);
		System.out.println(c);
	}
}
