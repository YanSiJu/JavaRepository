package cn.csu.arithmetic;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class IntegerToRoman {
	// [1,3999].

	static Map<Integer, String> map = new Hashtable<>(30);

	static {
		map.put(1, "I");
		map.put(2, "II");
		map.put(3, "III");
		map.put(4, "IV");
		map.put(5, "V");
		map.put(6, "VI");
		map.put(7, "VII");
		map.put(8, "VIII");
		map.put(9, "IX");
	}

	static {
		map.put(10, "X");
		map.put(20, "XX");
		map.put(30, "XXX");
		map.put(40, "XL");
		map.put(50, "L");
		map.put(60, "LX");
		map.put(70, "LXX");
		map.put(80, "LXXX");
		map.put(90, "XC");
	}

	static {
		map.put(100, "C");
		map.put(200, "CC");
		map.put(300, "CCC");
		map.put(400, "CD");
		map.put(500, "D");
		map.put(600, "DC");
		map.put(700, "DCC");
		map.put(800, "DCCC");
		map.put(900, "CM");
	}

	static {
		map.put(1000, "M");
		map.put(2000, "MM");
		map.put(3000, "MMM");
		map.put(0, "");
	}

	public static String intToRoman(int num) {
		StringBuilder str = new StringBuilder();
		int count = 0;
		List<Integer> list = new ArrayList<>(4);
		int n = num % 10;
		list.add(n);
		num = num / 10;
		count++;
		while (num > 0) {
			list.add(num % 10);
			num /= 10;
			count++;
		}

		for (int i = count - 1; i >= 0; i--) {
			Integer a = (int) (list.get(i) * Math.pow(10, --count));
			str.append(map.get(a));
		}
		return str.toString();
	}
}
