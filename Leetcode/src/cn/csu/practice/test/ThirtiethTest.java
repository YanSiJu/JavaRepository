package cn.csu.practice.test;

import java.util.Arrays;
import org.junit.Test;
import cn.csu.practice.Thirtieth;

public class ThirtiethTest {

	@Test
	public void testInsertElementToArray() {
		// fail("Not yet implemented");
		int[] a = { 2, 6, 8, 9, 10, 13, 16, 19, 20,Integer.MAX_VALUE};
		System.out.println("����ǰ:" + Arrays.toString(a));
		Thirtieth.insertElementToArray(a, 14);
		System.out.print("\n�����:" + Arrays.toString(a));
	}

}
