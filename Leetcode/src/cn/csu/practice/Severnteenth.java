package cn.csu.practice;

public class Severnteenth {

	public static int pearnum(int days, int count, int sum) {
		if (count < 1)
			return sum;
		if (count == days || count == days - 1) {
			return pearnum(days, --count, 1);
		} else {
			return pearnum(days, --count, (sum + 1) * 2);
		}
	}

	public static int pearnum(int days) {
		int sum = 1;
		for (int i = days - 1; i > 1; i--) {
			sum = (sum + 1) * 2;
//			System.out.println(sum);
		}
		return sum;
	}

}
