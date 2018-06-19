package cn.csu.test;

public class PrimTest {
	static int num1 = 6;
	static int num2 = 5;

	public static void main(String[] args) throws Exception {
		int MAX = Integer.MAX_VALUE;
		// int[][] map = new int[][]{
		// {0,3,MAX,MAX,6,5},
		// {3,0,1,MAX,MAX,4},
		// {MAX,1,0,6,MAX,4},
		// {MAX,MAX,6,0,8,5}, 
		// {6,MAX,MAX,8,0,2},
		// {5,4,4,5,2,0}
		// };
		int[][] map = new int[][] { { 0, 5, 7, MAX, 2 }, { 5, 0, MAX, 6, 3 }, { 7, MAX, 0, 4, 4 }, { MAX, 6, 4, 0, 5 },
				{ 2, 3, 4, 5, 0 } };
		System.out.println("依次经过的点为(坐标(1,1)表示到达第一个元素的最短距离为1)：");
		int sum = prim(map);
		System.out.println("权值和为：" + sum);
	}

	public static int prim(int[][] arr) {
		int sum = 0;
		int[] costs = new int[num1];
		int[] startPoint = new int[num1];
		for (int i = 1; i < num2; i++) {
			startPoint[i] = 0;
			costs[i] = arr[0][i];
		}
		for (int i = 1; i < num2; i++) {
			int min = Integer.MAX_VALUE;
			int minIndex = 0;
			for (int j = 1; j < num2; j++) {
				int temp = costs[j];
				if (temp != 0 && temp < min) {
					min = temp;
					minIndex = j;
				}
			}
			System.out.println("(" + (minIndex + 1) + "," + min + ")");
			sum += min;
			costs[minIndex] = 0;
			for (int k = 0; k < num2; k++) {
				int newCost = arr[minIndex][k];
				if (newCost != 0 && newCost < costs[k]) {
					costs[k] = newCost;
					startPoint[k] = minIndex;
				}
			}
		}
		return sum;
	}
}
