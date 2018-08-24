package cn.csu.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class forTest {

	@Test
	void test() {
//		fail("Not yet implemented");
		int sum = 0;
		for (int i = 0; i <= 102; i++) {
			sum += i;
		}
		System.out.println(sum);
	}

}
