package com.alibaba.Test;

import java.util.Arrays;
import java.util.Scanner;

//import static org.junit.Assert.*;

import org.junit.Test;

import com.alibaba.sort.BubbleSort;

public class TestBubbleSort extends BubbleSort {

	@Test
	public void test() {
	//	fail("Not yet implemented");
		

		Integer[] a = new Integer[10];
		Scanner in = new Scanner(System.in);
		
		System.out.println("������"+a.length+"������:");
		for (int i = 0; i < a.length; i++) {
				a[i] = in.nextInt();
		}
		
		System.out.println("\n����ǰ��"+Arrays.toString(a));
		
		BubbleSort.sort(a);
		
		System.out.println("\n�����"+Arrays.toString(a));
		
		in.close();
		
	}

}
