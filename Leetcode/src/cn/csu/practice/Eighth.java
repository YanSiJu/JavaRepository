package cn.csu.practice;

import java.util.ArrayList;
import java.util.List;

public class Eighth {

	public static int add(int a, int number) {
		List<Integer> list = new ArrayList<Integer>(number);
		list.add(a);
		for (int i = 1; i < number; i++) {
			list.add((int) (list.get(i - 1) + a * Math.pow(10, i)));
		}
		int sum = 0;
		for (Integer lst : list) {
			sum += lst;
		}
		return sum;
	}
}
