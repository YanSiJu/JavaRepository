package cn.csu.bag;

/**
 * @author Bill
 *
 */
public class Bag {

	public static void find(int[][] v, int[] items, int[] w, int capacity) {

		int i = w.length - 1;
		int j = capacity;
		while (i > 0) {

			if (v[i][j] == v[i - 1][j]) {
				i--;
			} else {

				items[i] = 1;
				j -= w[i];
				i--;
			}
		}

	}

	public static void napSack(int itemNumber, int capacity, int[] value, int[] weight, int[][] v) {

		for (int i = 1; i <= itemNumber; i++)
			for (int j = 1; j <= capacity; j++) {
				if (j < weight[i]) {
					v[i][j] = v[i - 1][j];
				} else {

					if (v[i - 1][j] > v[i - 1][j - weight[i]] + value[i]) {
						v[i][j] = v[i - 1][j];
					} else {
						v[i][j] = v[i - 1][j - weight[i]] + value[i];
					}

				}
			}

	}
}
