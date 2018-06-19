package cn.csu.practice.test;

import java.util.Arrays;
import org.junit.Test;
import cn.csu.practice.Thirtieth;

public class ThirtiethTest {

	@Test
	public void testInsertElementToArray() {
		// fail("Not yet implemented");
		int[] a = { 2, 6, 8, 9, 10, 13, 16, 19, 20,Integer.MAX_VALUE};
		System.out.println("插入前:" + Arrays.toString(a));
		Thirtieth.insertElementToArray(a, 14);
		System.out.print("\n插入后:" + Arrays.toString(a));
	}

}
