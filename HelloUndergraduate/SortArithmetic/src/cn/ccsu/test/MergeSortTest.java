package cn.ccsu.test;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import org.junit.Test;
import cn.ccsu.arithmetic.Sort;

/**
 * @author Bill
 *
 */
public class MergeSortTest {

	@Test
	public void test() {

		Random random = new Random();
		Scanner in = new Scanner(System.in);

		System.out.println("MergeSortTest\n");
		System.out.println("请输入欲排序的数字个数:");
		Integer[] a = new Integer[in.nextInt()];
		for (int i = 0; i < a.length; i++) {

			a[i] = random.nextInt() / 10000000;
		}

		Sort<Integer> sort = new Sort<Integer>();

		System.out.println("排序前:" + Arrays.toString(a));
		sort.mergeSort(a);
		System.out.println("排序后:" + Arrays.toString(a));

		in.close();
	}

}
