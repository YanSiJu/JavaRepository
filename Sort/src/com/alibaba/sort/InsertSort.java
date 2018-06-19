package com.alibaba.sort;

public class InsertSort {

	public static void sort(Integer[] a) {

		Integer temp = null;
		int j = 0;
		for (int i = 1; i < a.length; i++) {
			temp = a[i];
			for (j = i - 1; j >= 0; j--) {
				if (a[j] > temp) {
					a[j + 1] = a[j];
				} else
					break;

			}
			a[j + 1] = temp;
		}
	}
}
