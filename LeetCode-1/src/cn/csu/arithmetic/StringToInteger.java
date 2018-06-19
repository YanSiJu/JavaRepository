package cn.csu.arithmetic;

public class StringToInteger {

	public static int myAtoi(String str) {
		int[] valueArray = new int[str.length()];
		// 记录数字的正负 0:负 1:正
		int symbol = 1;
		int symbolCount = 0;
		// 记录数字的个数
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == ' ') {
				if (count != 0) {
					break;
				}
			} else if ((c == '+' || c == '-') && count == 0) {
				if (symbolCount == 1) {
					return 0;
				} else if (i + 1 < str.length() && str.charAt(i + 1) == ' ') {
					return 0;
				}
				if (c == '+') {
					symbol = 1;
				} else if (c == '-') {
					symbol = 0;
				}
				symbolCount++;
			} else if (c == '.') {
				break;
			} else if (c >= '0' && c <= '9') {
				valueArray[count++] = c - 48;
			} else if (c > '9' || c < '0') {
				if (count == 0) {
					return 0;
				} else {
					break;
				}
			}

		}
		long val = 0;
		for (int i = count - 1; i >= 0; i--) {
			val += valueArray[i] * Math.pow(10, count - i - 1);
		}
		if (symbol == 0) {
			val = -1 * val;
		}
		if (val < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		if (val > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		return (int) val;
	}
}
