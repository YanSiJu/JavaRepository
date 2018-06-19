package cn.ccsu.test;

import org.junit.Test;

import cn.ccsu.system.Facade;

public class FacadeTest {

	public FacadeTest() {

	}

	@Test
	public void test() {
		Facade facade = new Facade();
		facade.on();
	}

}
