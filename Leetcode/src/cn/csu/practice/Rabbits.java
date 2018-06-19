package cn.csu.practice;

import java.util.LinkedList;
import java.util.List;

public class Rabbits {

	public static List<Integer> Fibonacci(int n) {
		List<Integer> rabbits = new LinkedList<Integer>();
		rabbits.add(1);
		rabbits.add(1);
		for (int i = 0; i < n - 2; i++) {
			rabbits.add(rabbits.get(i) + rabbits.get(i + 1));
		}
		return rabbits;
	}

}
