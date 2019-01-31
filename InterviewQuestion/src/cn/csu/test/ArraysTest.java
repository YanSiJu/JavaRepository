package cn.csu.test;

import java.util.Arrays;

public class ArraysTest {

	/*
	 * Arrays.deepToString()主要用于数组中还有数组的情况， 而Arrays.toString()则相反，
	 * 对于Arrays.toString()而言，当数组中有数组时，不会打印出数组中的内容， 只会以地址的形式打印出来。
	 */
	public static void main(String[] args) {

		int a[] = { 1, 2, 3 };
		System.out.println(Arrays.toString(a));
		int b[][] = { { 1, 2, 3 }, { 4, 5, 6 } };
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.deepToString(b));
	}

}
