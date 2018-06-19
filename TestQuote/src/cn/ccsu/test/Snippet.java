package cn.ccsu.test;

public class Snippet {

	public static void test(int x) {
		x++;
		System.out.println("方法内，x == " + x);
	}

	public static void main(String[] args) {

		int a = 3;
		Snippet.test(a);
		System.out.println("方法外，a == " + a);

	}

}
