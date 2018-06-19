package cn.csu.practice;

public class Fourteenth {

	public static int theDayOfTheYear(int year, int month, int day) {
		int[] m = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			m[2] = 29;
		}
		int sum = 0;
		for (int i = 1; i <= month - 1; i++) {
			sum += m[i];
		}
		return sum + day;
	}
}
