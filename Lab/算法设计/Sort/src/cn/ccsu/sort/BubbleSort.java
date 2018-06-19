package cn.ccsu.sort;

public class BubbleSort {

	public void sort(Integer[] a) {

		Integer tmp;
		for (int i = 0; i < a.length - 1; i++)
			for (int j = 0; j < a.length - i - 1; j++) {

				if (a[j] > a[j + 1]) {

					tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
				}
			}

	}
}
