package cn.csu.test;

import org.junit.Test;

public class ExceptionTest {
	public static void main(String[] args) {
		try {
			System.out.println("hello,jr");
			System.exit(0);
		} finally {
			System.out.println("88");
		}
	}

	@Test
	public void assignmentTest() {
		float price = 2.3f;
		String str = "34.1f";
		try {// txtMinPrice����Ϊ���ַ������������Ƿ��������ַ���������Ҫ������
			price = Float.parseFloat(str);
		} catch (Exception e) {
		}
		System.out.println(price);
	}

}
