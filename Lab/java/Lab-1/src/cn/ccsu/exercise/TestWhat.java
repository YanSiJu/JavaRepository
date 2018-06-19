package cn.ccsu.exercise;

import java.util.Scanner;

public class TestWhat {

	public static void main(String[] args) {
		boolean leap;
		int year;
		Scanner in = new Scanner(System.in);
		
		System.out.println("请输入一个年份：");
		year = in.nextInt();
		leap = TestWhat.isYeap(year);

		if (leap == true)
			System.out.println(year + " is leap year");
		else
			System.out.println(year + " is not leap year");

		// 判断year是否为闰年
		/*
		 * if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
		 * System.out.println(year + " is what？"); else System.out.println(year
		 * + " is not what？");
		 */
		/*
		 * // year = 2008; if (year % 4 != 0) leap = false; // year % 4 ！=
		 * 0：不是闰年 else if (year % 100 != 0) leap = true; // year % 100 != 0 &&
		 * year % 4 == 0:是闰年 // year % 100 == 0 && year % 4 == 0 && year % 400
		 * != 0:不是闰年 else if (year % 400 != 0) leap = false; // year % 100 == 0
		 * && year % 4 == 0 && year % 400 == 0:是闰年 else leap = true;
		 * 
		 * if (leap == true) System.out.println(year + " is what？"); else
		 * System.out.println(year + " is not what？");
		 * 
		 * // year = 2050; if (year % 4 == 0) { if (year % 100 == 0) { if (year
		 * % 400 == 0) leap = true; else leap = false; } else leap = true; }
		 * else leap = false;
		 * 
		 * if (leap == true) System.out.println(year + " is what？"); else
		 * System.out.println(year + " is not what？");
		 */
	}

	public static boolean isYeap(int year) {

		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
			return true;
		else
			return false;
	}
}
