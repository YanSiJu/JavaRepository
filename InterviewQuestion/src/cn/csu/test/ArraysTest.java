package cn.csu.test;

import java.util.Arrays;

public class ArraysTest {

	/*
	 * Arrays.deepToString()��Ҫ���������л������������� ��Arrays.toString()���෴��
	 * ����Arrays.toString()���ԣ���������������ʱ�������ӡ�������е����ݣ� ֻ���Ե�ַ����ʽ��ӡ������
	 */
	public static void main(String[] args) {

		int a[] = { 1, 2, 3 };
		System.out.println(Arrays.toString(a));
		int b[][] = { { 1, 2, 3 }, { 4, 5, 6 } };
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.deepToString(b));
	}

}
