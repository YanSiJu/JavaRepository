package cn.csu.arithmetic;

public class Pow {

	public static double myPow(double x, int n) {
		/*
		 * if (x > 100.0 || x < -100.0) { return 0; }
		 */

		if (n < 0) {
			x = 1 / x;
			n = -n;
		}
		double val = 1;
		for (int i = 0; i < n; i++) {
			val *= x;
		}
		return val;
	}
}
