package com.alibaba.wrapper;

import org.junit.Test;
//import org.junit.internal.runners.statements.Fail;

public class TestWrapper {

	@Test
	public void m() {

		Short a = 1;
		short b = 1;
		System.out.println("$ " + a.equals(1));
		System.out.println("$  " + a.equals(b));

	}

	@Test
	public void test() {

		int m = 12;
		Integer n = m;

		Boolean a = true;

		System.out.println("n:" + n + "  a:" + a);
		System.out.println("n:" + n.hashCode() + "  a:" + a.hashCode());

		// n = null;
		// a = null;

		// System.out.println("n:"+n+" a:"+a);

		String str = String.valueOf(a);
		System.out.println("str:" + str);

		Boolean k = Boolean.parseBoolean(str);
		System.out.println("k:" + k);

	}
}
