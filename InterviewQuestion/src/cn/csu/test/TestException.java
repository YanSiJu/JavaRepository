package cn.csu.test;

public class TestException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 0, 1, 2, 3, 4 };
		int sum = 0;
		try {
			for (int i = 0; i < 6; i++) {
				sum += a[i];
			}
			System.out.println("sum=" + sum);
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			System.out.println("�����±�Խ��");
		} finally {
			System.out.println("�������");
		}
	}

}
