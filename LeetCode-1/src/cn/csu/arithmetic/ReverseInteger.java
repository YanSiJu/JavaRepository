package cn.csu.arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bill
 *
 */
public class ReverseInteger {

	public int reverse(int x) {

		/*
		 * if (x > (int) Math.pow(2, 32)) { System.out.println("\n0000"); return 0; }
		 */

		// 记录数字的位数
		int n = 0;
		// 记录数字x的正负
		int isNagative = x > 0 ? 1 : -1;
		x = Math.abs(x);
		// 用于ArrayList索引元素
		int index = 0;
		// 反转后的数字
		int number = 0;
		// 存储数字x各个位上的数字
		List<Integer> list = new ArrayList<>();

		// 取出x各个位上的数字，存在list中
		while (x > 0) {

			list.add(x % 10);
			x = x / 10;
			n++;
		}

		// 获取反转后的数字
		for (int i = n; i > 0; i--) {

			number = (int) (number + Math.pow(10, i - 1) * list.get(index));
			// 如果反转后的数字溢出，则返回0
			if (number == 2147483647) {
				return 0;
			}
			index++; // ArrayList索引+1

		}
		// 如果x为负数，则会返回负数
		return number * isNagative;
	}
}
