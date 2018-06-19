package cn.ccsu.test;

import java.util.ArrayList;
import java.util.List;

public class Test {

	private String value = null;

	public Test(String v) {

		this.value = v;
	}

	 @Override
	public boolean equals(Object o) {

		System.out.println("Person's equals()  method.");
		if (o == this)
			return true;
		if (o instanceof Test) {

			Test test = (Test) o;
			return value.equals(test.value);
		}

		return false;
	}

	public static void main(String... args) {

		List<Object> list = new ArrayList<>();

		Test t1 = new Test("object");
		Test t2 = new Test("object");
		Test t3 = new Test("object");
		Test t4 = new Test("object");

		list.add(t1);
		list.add(125);

		System.out.println(list.contains(t3));
		System.out.println("list.contains(\"abc\"):" + (list.contains(new Integer(125))));
		System.out.println(t2.equals(t3));
		System.out.println(t3.equals(t4));

	}

}
