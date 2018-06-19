package cn.ccsu.sort;

public class InsertSort {

	public void sort(Integer[] a) {
		// TODO Auto-generated method stub

		Integer tmp = 0;
		int j;
		for (int i = 1; i < a.length; i++) {
			tmp = a[i];
			for (j = i - 1; j >= 0; j--) {
				if (a[j] > tmp)
					a[j + 1] = a[j];
				else
					break;
			}
			a[j + 1] = tmp;
		}
	}

}
