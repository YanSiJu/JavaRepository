package cn.csu.arithmetic;

public class RomanToInteger {

	public static int romanToInt(String s) {
		int val = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == 'I') {
				if (i + 1 < s.length() && s.charAt(i + 1) == 'V') {
					val += 4;
					i++;
				} else if (i + 1 < s.length() &&s.charAt(i + 1) == 'X') {
					val += 9;
					i++;
				} else {
					val += 1;
				}
			} else if (ch == 'X') {
				if (i + 1 < s.length() &&s.charAt(i + 1) == 'L') {
					val += 40;
					i++;
				} else if (i + 1 < s.length() &&s.charAt(i + 1) == 'C') {
					val += 90;
					i++;
				} else {
					val += 10;
				}
			} else if (ch == 'C') {
				if (i + 1 < s.length() &&s.charAt(i + 1) == 'D') {
					val += 400;
					i++;
				} else if (i + 1 < s.length() &&s.charAt(i + 1) == 'M') {
					val += 900;
					i++;
				} else {
					val += 100;
				}
			} else if (ch == 'M') {
				val += 1000;
			} else if (ch == 'V') {
				val += 5;
			} else if (ch == 'L') {
				val += 50;
			} else if (ch == 'D') {
				val += 500;
			}
		}
		return val;
	}
}
