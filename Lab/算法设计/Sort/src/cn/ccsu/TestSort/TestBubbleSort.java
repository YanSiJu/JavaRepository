package cn.ccsu.TestSort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import cn.ccsu.sort.BubbleSort;

public class TestBubbleSort {

	public static void main(String[] args) {

		Random random = new Random();
		Scanner in = new Scanner(System.in);

		System.out.println("����������������ָ���:");
		Integer[] a = new Integer[in.nextInt()];
		// System.out.println("�����������������:");
		for (int i = 0; i < a.length; i++) {

			a[i] = random.nextInt()/10000000;
		}

		System.out.println("����ǰ:" + Arrays.toString(a));
		new BubbleSort().sort(a);
		System.out.println("�����:" + Arrays.toString(a));

		in.close();

	}

}
