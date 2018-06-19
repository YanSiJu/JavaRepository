package cn.ccsu.basic;

import java.util.Scanner;

public class JudgeTriangle {

	public static String judge(double x, double y, double z) {

		/*
		 * �ж������ε��������ܷ񹹳������Σ���Ҫ�����жϳ��ǵ����ȱ߻�����ͨ������
		 */
		if (isTriangle(x, y, z)) {
			if (JudgeTriangle.isIsosseles(x, y, z)) {
				if (JudgeTriangle.isEquilateral(x, y, z)) {

					return "" + x + "," + y + "," + z + "���������ɵ�������Ϊ�ȱ�������";
				} else {
					return "" + x + "," + y + "," + z + "���������ɵ�������Ϊ����������";
				}

			} else {
				return "" + x + "," + y + "," + z + "���������ɵ�������Ϊ��ͨ������";
			}

		} else {
			return "" + x + "," + y + "," + z + "���߲��ܹ���������";
		}

	}

	/*
	 * �ж�x��y��z�������ܷ񹹳������� �����ܣ��򷵻�true�����򷵻�false
	 */
	public static boolean isTriangle(double x, double y, double z) {
		if (x + y > z && x + z > y && y + z > x) {

			return true;
		}
		return false;
	}

	/*
	 * �жϸ��������Ƿ�Ϊ���������� �����ǣ��򷵻�true�����򷵻�false ����x��y��zΪ�����ε�������
	 */
	public static boolean isIsosseles(double x, double y, double z) {

		if (x == y || x == z || y == z) {
			return true;
		}
		return false;

	}

	/*
	 * �жϸ��������Ƿ�Ϊ�ȱ������� �����ǣ��򷵻�true�����򷵻�false ����x��y��zΪ�����ε�������
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

			System.out.println("�����������ε�������:");

			x = in.nextDouble();
			y = in.nextDouble();
			z = in.nextDouble();
			System.out.println(JudgeTriangle.judge(x, y, z));

			System.out.println("(���롰Q���˳�)�����������......");
			str = strIn.nextLine();
			if (str.equalsIgnoreCase("Q") || str.equalsIgnoreCase("q")) {

				break;
			}

		}

		in.close();
		strIn.close();

	}
}
