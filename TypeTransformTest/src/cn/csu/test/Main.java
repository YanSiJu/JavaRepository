package cn.csu.test;

import org.junit.Test;

public class Main {

	public Main() {

	}

	@Test
	public void test_1() {

		String s = (String) new Object();
		System.out.println(s);
	}

	@Test
	public void test_2() {

		Object obj = new Object();
		System.out.println((String) obj);
	}

	@Test
	public void test_4() {

		A obj = new A();
		System.out.println((B) obj);
	}

	@Test
	public void test_3() {

		B b = (B) new A();
		System.out.println(b);
	}
}
