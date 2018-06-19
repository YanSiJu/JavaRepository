package cn.csu.test;

import org.junit.Test;
import cn.csu.beans.Singleton;

public class InnerClassTest {

	@Test
	public void testGetInstance() {
		// fail("Not yet implemented");
		Singleton s_1 = Singleton.getInstance();
		Singleton s_2 = Singleton.getInstance();
		
		System.out.println(s_1 == s_2);

	}

}
