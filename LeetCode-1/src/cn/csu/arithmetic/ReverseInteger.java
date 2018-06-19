package cn.csu.arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bill
 *
 */
public class ReverseInteger {

	public int reverse(int x) {

		/*
		 * if (x > (int) Math.pow(2, 32)) { System.out.println("\n0000"); return 0; }
		 */

		// ��¼���ֵ�λ��
		int n = 0;
		// ��¼����x������
		int isNagative = x > 0 ? 1 : -1;
		x = Math.abs(x);
		// ����ArrayList����Ԫ��
		int index = 0;
		// ��ת�������
		int number = 0;
		// �洢����x����λ�ϵ�����
		List<Integer> list = new ArrayList<>();

		// ȡ��x����λ�ϵ����֣�����list��
		while (x > 0) {

			list.add(x % 10);
			x = x / 10;
			n++;
		}

		// ��ȡ��ת�������
		for (int i = n; i > 0; i--) {

			number = (int) (number + Math.pow(10, i - 1) * list.get(index));
			// �����ת�������������򷵻�0
			if (number == 2147483647) {
				return 0;
			}
			index++; // ArrayList����+1

		}
		// ���xΪ��������᷵�ظ���
		return number * isNagative;
	}
}
