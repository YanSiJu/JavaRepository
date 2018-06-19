package cn.ccsu.aop.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.ccsu.service.IPerformance;

public class AOPTest {

	@Autowired
	private IPerformance p;

	public AOPTest() {

	}

	@Test
	public void test() {
		ClassPathXmlApplicationContext ctxt = new ClassPathXmlApplicationContext("applicationContext.xml");

		p = (IPerformance) ctxt.getBean("IPerformance");
		System.out.println("IPerformance:" + p + "\n");
		String name = "Mikeal.Jackson";
		p.perform(name);

		ctxt.close();
	}
}
