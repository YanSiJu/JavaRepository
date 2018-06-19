package cn.ccsu.TestSort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


import cn.ccsu.sort.SelectSort;

public class TestSelectSort {
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
		SelectSort<Integer> s = new SelectSort<Integer>();		//机房环境:jdk 1.6
		s.sort(a);
		System.out.println("排序后:" + Arrays.toString(a));

		in.close();

	}
}
