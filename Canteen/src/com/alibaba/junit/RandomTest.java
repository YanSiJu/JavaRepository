package com.alibaba.junit;

import org.junit.jupiter.api.Test;

class RandomTest {

	@Test
	void test() {
		// fail("Not yet implemented");
		String vcode = "";
		for (int i = 0; i < 6; i++) {
			vcode = vcode + (int) (Math.random() * 9);
		}
		System.out.println(vcode);
	}

}
