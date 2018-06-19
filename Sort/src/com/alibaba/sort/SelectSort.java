package com.alibaba.sort;

import java.lang.reflect.Field;

public class SelectSort {

	public static void sort(Integer[] a) {

		int i;
		int min = 0;
		Integer tmp = 0;
		for (i = 0; i <= a.length - 2; i++) {
			min = i;
			for (int j = i + 1; j <= a.length - 1; j++) {

				if (a[j] < a[min]) {
					min = j;
				}
			}

			// swap(a[i], a[min]);

			tmp = a[i];
			a[i] = a[min];
			a[min] = tmp;
		}

		// 改用位运算的方式

	}

	public static void swap(Integer a, Integer b) {
		Field field = null;
		try {
			field = Integer.class.getDeclaredField("value");
		} catch (NoSuchFieldException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		field.setAccessible(true);

		int temp = a.intValue();

		try {
			field.setInt(a, b.intValue());
			field.setInt(b, temp);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}
}
