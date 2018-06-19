package cn.csu.practice.test;

import org.junit.Test;

import cn.csu.practice.Severnteenth;

public class SevernteenthTest {

	@Test
	public void testPearnum() {
		// fail("Not yet implemented");
		int days = 10;
		int count = 10;
		int sum = 0;
		System.out.println("递归方式:" + Severnteenth.pearnum(days, count, sum));
		System.out.println("迭代方式" + Severnteenth.pearnum(days));
	}

}
