package com.alibaba.Test;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Scanner;
import org.junit.Test;
import com.alibaba.sort.InsertSort;
import com.alibaba.sort.SelectSort;

@SuppressWarnings("unused")
public class TestInsertSort extends InsertSort {

	@Test
	public void test() {
//		fail("Not yet implemented");
		
		Integer[] a = new Integer[10];
		Scanner in = new Scanner(System.in);
		
		System.out.println("������"+a.length+"������:");
		for (int i = 0; i < a.length; i++) {
				a[i] = in.nextInt();
		}
		
		System.out.println("\n����ǰ��"+Arrays.toString(a));
		
		InsertSort.sort(a);
		
		
		System.out.println("\n�����"+Arrays.toString(a));
		
		in.close();
		
		
	}

}
