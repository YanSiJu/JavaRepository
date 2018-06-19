package cn.ccsu.test;


import java.util.Random;
import java.util.Scanner;
import org.junit.Test;

import cn.ccsu.arithmetic.Sort;

/**
 * @author Bill
 *
 */
public class QuicklySortTest {

	@Test
	public void quicklySortTest() {
		Random random = new Random();
		Scanner in = new Scanner(System.in);

		System.out.println("请输入欲排序的数字个数:");
		Integer[] a = new Integer[in.nextInt()];
		for (int i = 0; i < a.length; i++) {

			a[i] = random.nextInt() / 10000000;
		}

		Sort<Integer> sort = new Sort<>();

		long start = System.currentTimeMillis();
		sort.quicklySort(a);
		long end = System.currentTimeMillis();
		System.out.println("quicklySort  time:" + (end - start));

		/*start = System.currentTimeMillis();
		sort.insetrSort(a);
		end = System.currentTimeMillis();
		System.out.println("insetrSort  time:" + (end - start));*/

		/*
		 * System.out.println("排序前:" + Arrays.toString(a)); sort.quicklySort(a, 0,
		 * a.length - 1); // sort.median(a, 0, a.length - 1); System.out.println("排序后:"
		 * + Arrays.toString(a));
		 */

		in.close();
	}

}
