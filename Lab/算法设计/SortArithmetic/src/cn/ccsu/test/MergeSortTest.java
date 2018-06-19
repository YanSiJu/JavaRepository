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

		System.out.println("=====�鲢����=====");
		System.out.println("����������������ָ���:");
		Integer[] a = new Integer[in.nextInt()];
		for (int i = 0; i < a.length; i++) {

			a[i] = random.nextInt() / 10000000;
		}

		Sort<Integer> sort = new Sort<>();

		System.out.println("����ǰ:" + Arrays.toString(a));
		sort.mergeSort(a);
		System.out.println("�����:" + Arrays.toString(a));

		in.close();
	}

}
