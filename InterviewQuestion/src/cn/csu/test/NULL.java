package cn.csu.test;

public class NULL {
	public void haha() {
		System.out.println("haha");
	}

	public static void main(String[] args) {
		((NULL) null).haha();
	}

	public static int getValue(int i) {
		int result = 0;
		switch (i) {
		case 1:
			result = result + i;
		case 2:
			result = result + i * 2;
		case 3:
			result = result + i * 3;
		}
		return result;
	}

}
