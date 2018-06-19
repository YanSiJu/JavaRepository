package cn.csu.practice;

public class Thirtieth {

	public static void insertElementToArray(int[] a, int x) {
		for (int i = 0; i < a.length - 2; i++) {
			if (x < a[i]) {
				for (int j = a.length - 2; j >= i; j--) {
					a[j + 1] = a[j];
				}
				a[i] = x;
				return;
			}
		}
		a[a.length - 1] = x;
	}
}
