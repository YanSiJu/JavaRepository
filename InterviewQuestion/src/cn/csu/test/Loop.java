package cn.csu.test;

public class Loop {

	public static void main(String[] args) {
		int[][] array = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		flag: for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.println("i=" + i + ",j=" + j);
				if (array[i][j] == 4)
					break flag;
			}
		}
		System.out.println("找到了需要的数字，结束程序");

	}

}
