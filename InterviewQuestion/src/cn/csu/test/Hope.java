package cn.csu.test;

public class Hope {
	public static void main(String argv[]) {
		Hope h = new Hope();
		Hope a = new H();
		System.out.println(h);
		System.out.println(a);
	}

	protected Hope() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
	}
}

class H extends Hope {
}
