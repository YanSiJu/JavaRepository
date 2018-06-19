package cn.csu.test;

import java.util.Scanner;

import cn.csu.bag.Bag;

public class BagTest {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("��������Ʒ�����ͱ�������:");
		int itemNumber = in.nextInt();
		int capacity = in.nextInt();

		int[] w = new int[itemNumber + 1];
		int[] value = new int[itemNumber + 1];
		System.out.println("������" + itemNumber + "����Ʒ������:");
		assign(w);
		System.out.println("������" + itemNumber + "����Ʒ�ļ�ֵ:");
		assign(value);

		int[][] v = new int[itemNumber + 1][capacity + 1];

		Bag.napSack(itemNumber, capacity, value, w, v);
		printArray(v);
		System.out.println("���Ž�:" + v[itemNumber][capacity]);

		int[] items = new int[itemNumber + 1];
		for (int i = 0; i < items.length; i++) {
			items[i] = 0;
		}

		Bag.find(v, items, w, capacity);

		System.out.println("���Ž��Ӽ�:");
		for (int i = 0; i < items.length; i++) {
			if (items[i] == 1) {
				System.out.print(i + "  ");
			}
		}

		in.close();
	}

	public static void assign(int[] a) {
		for (int i = 1; i < a.length; i++) {
			a[i] = in.nextInt();
		}
	}

	public static void printArray(int[][] a) {

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + "   ");
			}
			System.out.println();
		}

	}
}
