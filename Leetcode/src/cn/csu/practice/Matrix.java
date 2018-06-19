package cn.csu.practice;

public class Matrix {

	public void multi(int[][] a, int[][] b, int[][] c) {

		int sum = 0;
		int n = 0;
		for (int i = 0; i < a.length; i++) {
			for (n = 0; n < b[0].length; n++) {
				int j = 0;
				int m = 0;
				if (j <= a[0].length - 1 && m <= b.length - 1) {
					sum += a[i][j] * b[m][n];
				}
				j++;
				m++;
			}
			c[i][n] = sum;
			sum = 0;
		}
	}
}
