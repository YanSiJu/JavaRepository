package cn.ccsu.test;

public class ExceptionTest {

	public static void main(String[] args) {
		try {
			System.out.println(3 / 0);
		} catch (ArithmeticException e) {
			System.out.println("��ѧ�쳣");
		} catch (RuntimeException e) {
			System.out.println("����ʱ�쳣");
		}
	}
}
