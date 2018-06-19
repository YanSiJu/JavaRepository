package com.alibaba.Test;


import java.util.Arrays;
import java.util.Scanner;
import org.junit.Test;
import com.alibaba.sort.SelectSort;

public class TestSelectSort extends SelectSort {

	@Test
	public void test() {
		//fail("Not yet implemented");

		Integer[] a = new Integer[10];
		Scanner in = new Scanner(System.in);
		
		System.out.println("请输入"+a.length+"个整数:");
		for (int i = 0; i < a.length; i++) {
				a[i] = in.nextInt();
		}
		
		System.out.println("\n排序前："+Arrays.toString(a));
		
		SelectSort.sort(a);
		
		System.out.println("\n排序后："+Arrays.toString(a));
		
		in.close();
		

	}

}
