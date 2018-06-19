package cn.ccsu.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author Bill
 *
 */
public class ArrayListTest {

	@Test
	public void test() {

		System.out.println("=====ArrayListTest=====");
		List<Integer> tmpArray = new ArrayList<>();
		int size =10;
		for (int i = 0; i < size; i++) {
			tmpArray.add(null);
		}
		 System.out.println("tmpArray.get(0):" + tmpArray.get(0));
	}

}
