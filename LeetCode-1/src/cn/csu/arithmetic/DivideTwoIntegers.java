package cn.csu.arithmetic;

public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		int flag = ((dividend > 0 && divisor > 0) || ((dividend < 0 && divisor < 0))) ? 1 : -1;
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		int val = 0;
		int count = 0;
		for (; val > divisor; val = dividend - divisor) {
			count++;
		}
		System.out.println(count);
		return flag * count;
	}
}
