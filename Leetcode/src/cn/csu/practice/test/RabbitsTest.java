package cn.csu.practice.test;

import java.util.List;
import org.junit.Test;
import cn.csu.practice.Rabbits;

public class RabbitsTest {

	@Test
	public void testFibonacci() {
//		fail("Not yet implemented");
		List<Integer> list = Rabbits.Fibonacci(12);
		System.out.println(list);
	/*	for(Integer r:list) {
			System.out.println(r);
		}*/
	}

}
