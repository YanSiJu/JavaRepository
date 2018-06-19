package cn.ccsu.basic;

import java.util.Scanner;

public class JudgeTriangle {

	public static String judge(double x, double y, double z) {

		/*
		 * 判断三角形的三条边能否构成三角形，并要求能判断出是等腰等边还是普通三角形
		 */
		if (isTriangle(x, y, z)) {
			if (JudgeTriangle.isIsosseles(x, y, z)) {
				if (JudgeTriangle.isEquilateral(x, y, z)) {

					return "" + x + "," + y + "," + z + "三边所构成的三角形为等边三角形";
				} else {
					return "" + x + "," + y + "," + z + "三边所构成的三角形为等腰三角形";
				}

			} else {
				return "" + x + "," + y + "," + z + "三边所构成的三角形为普通三角形";
			}

		} else {
			return "" + x + "," + y + "," + z + "三边不能构成三角形";
		}

	}

	/*
	 * 判断x、y、z三条边能否构成三角形 。若能，则返回true，否则返回false
	 */
	public static boolean isTriangle(double x, double y, double z) {
		if (x + y > z && x + z > y && y + z > x) {

			return true;
		}
		return false;
	}

	/*
	 * 判断该三角形是否为等腰三角形 。若是，则返回true，否则返回false 参数x、y、z为三角形的三条边
	 */
	public static boolean isIsosseles(double x, double y, double z) {

		if (x == y || x == z || y == z) {
			return true;
		}
		return false;

	}

	/*
	 * 判断该三角形是否为等边三角形 。若是，则返回true，否则返回false 参数x、y、z为三角形的三条边
	 * 
	 */

	public static boolean isEquilateral(double x, double y, double z) {

		if (x == y && x == z && y == z) {
			return true;
		}

		return false;
	}

	public static void main(String... args) {

		Scanner in = new Scanner(System.in);
		Scanner strIn = new Scanner(System.in);
		String str = "";
		double x;
		double y;
		double z;
		while (true) {

			System.out.println("请输入三角形的三条边:");

			x = in.nextDouble();
			y = in.nextDouble();
			z = in.nextDouble();
			System.out.println(JudgeTriangle.judge(x, y, z));

			System.out.println("(输入“Q”退出)按任意键继续......");
			str = strIn.nextLine();
			if (str.equalsIgnoreCase("Q") || str.equalsIgnoreCase("q")) {

				break;
			}

		}

		in.close();
		strIn.close();

	}
}
