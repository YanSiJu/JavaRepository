package cn.ccsu.test;

public class TestInteger {

	public static void main(String... args) {

		Integer a;
		Integer b;

		a = 23;
		b = 23;
		System.out.println(a.equals(b));
		System.out.println(a == b);

		a = 128;
		b = 128;
		System.out.println("\n" + a.equals(b));
		System.out.println(a == b);

		a = new Integer(23);
		b = new Integer(23);
		System.out.println("\n" + a.equals(b));
		System.out.println(a == b);

		a = Integer.valueOf(25);
		b = Integer.valueOf(25);
		System.out.println("\n" + a.equals(b));
		System.out.println(a == b);

		a = Integer.valueOf(129);
		b = Integer.valueOf(129);
		System.out.println("\n" + a.equals(b));
		System.out.println(a == b);

	}

}
