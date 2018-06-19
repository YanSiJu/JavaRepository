package cn.csu.practice;

import java.util.ArrayList;
import java.util.List;

public class Twentyfive {

	public static boolean isPalindromicnumber(int n) {

		List<Integer> numbers = new ArrayList<Integer>();
		digitNumber(n, numbers);
		for (int i = 0; i < (numbers.size() - 1) / 2; i++) {
			if (numbers.get(i) != numbers.get(n - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static void digitNumber(int n, List<Integer> numbers) {
		int x = n / 10;
		while (x > 0) {
			numbers.add(x);
			x = n / 10;
		}
	}
}
