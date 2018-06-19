package test;

public class StringTest {

	public static void main(String[] args) {
		Integer a = 25;
		System.out.println(String.valueOf(a));
		System.out.println(a.toString().intern());
		System.out.println(Integer.toString(a));
	}

}
