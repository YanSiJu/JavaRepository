package cn.csu;

import org.junit.Test;

public class Main {

	public Main() {

	}

	@SuppressWarnings("static-access")
	@Test
	public void test() {
		A a = new A();
		B b = new B();
		a.display();
		b.display();
	}

	@SuppressWarnings("static-access")
	@Test
	public void test_1() {
		A a = new B();

		a.display();

	}

}
