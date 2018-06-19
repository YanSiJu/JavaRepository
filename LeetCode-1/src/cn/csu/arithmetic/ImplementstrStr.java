package cn.csu.arithmetic;

public class ImplementstrStr {
	public static int strStr(String haystack, String needle) {
		int needleLength = needle.length();
		int haystackLength = haystack.length();

		if (needleLength == 0) {
			return 0;
		}
		if (needleLength > haystackLength) {
			return -1;
		}

		for (int i = 0; i <= haystackLength - needleLength; i++) {
			int j = 1;
			char ch = haystack.charAt(i);
			if (ch == needle.charAt(0)) {
				for (j = 1; j < needleLength; j++) {
					if (needle.charAt(j) != haystack.charAt(i + j)) {
						break;
					}
				}
				if (j == needleLength) {
					return i;
				}
			}
		}
		return -1;
	}
}
