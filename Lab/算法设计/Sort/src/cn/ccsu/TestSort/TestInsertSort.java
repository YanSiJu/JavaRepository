package cn.ccsu.TestSort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import cn.ccsu.sort.InsertSort;

public class TestInsertSort {
	public static void main(String[] args) {

		Random random = new Random();
		Scanner in = new Scanner(System.in);

		System.out.println("请输入欲排序的数字个数:");
		Integer[] a = new Integer[in.nextInt()];
		// System.out.println("请输入欲排序的数字:");
		for (int i = 0; i < a.length; i++) {

			a[i] = random.nextInt() / 10000000;
		}

		System.out.println("排序前:" + Arrays.toString(a));
		new InsertSort().sort(a);
		System.out.println("排序后:" + Arrays.toString(a));

		in.close();

	}

}
