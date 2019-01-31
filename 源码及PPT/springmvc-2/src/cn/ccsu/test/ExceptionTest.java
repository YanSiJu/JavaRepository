package cn.ccsu.test;

public class ExceptionTest {

	public static void main(String[] args) {
		try {
			System.out.println(3 / 0);
		} catch (ArithmeticException e) {
			System.out.println("数学异常");
		} catch (RuntimeException e) {
			System.out.println("运行时异常");
		}
	}
}
