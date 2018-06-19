package cn.csu.test;

import java.util.Arrays;
import cn.csu.arithmetic.TwoSum;

/**
 * @author Bill
 *
 */
public class TestTwoSum {

	public static void main(String[] args) {

		int[] a = { 2, 7, 11, 15,21,1,3};

		/*
		 * Random r = new Random();
		 * 
		 * random.nextInt(max)%(max-min+1) + min; for (int i = 0; i < a.length; i++)
		 * a[i] = r.nextInt(50) % (50 - 0 + 1) + 0;
		 */

		System.out.println(Arrays.toString(a));
		System.out.println("\nstart at  "+System.currentTimeMillis());
		System.out.println(Arrays.toString(TwoSum.twoSum(a, 8)));
		System.out.println("end with  "+System.currentTimeMillis());

	}
}
