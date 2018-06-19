package cn.csu.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Thirtythree {

	public static void pascaltriangle(int rows) {

		List<Integer> oldList = new LinkedList<Integer>();
		List<Integer> currentList = new ArrayList<Integer>();
		oldList.add(1);
		for (int i = 1; i <= rows; i++) {
			for (int k = 0; k < rows - i; k++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				if (j == 1 || j == i) {
					System.out.print(1 + " ");
					currentList.add(1);
				} else {
					System.out.print((oldList.get(j - 2) + oldList.get(j - 1)) + " ");
					int n = oldList.get(j - 2) + oldList.get(j - 1);
					currentList.add(n);
				}
			}
			if (i == 1) {
				currentList = new ArrayList<Integer>();
				currentList.add(1);
				currentList.add(1);
			}
			oldList = currentList;
			currentList = new ArrayList<Integer>();
			System.out.println();
		}
	}

}
