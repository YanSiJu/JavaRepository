package cn.csu.test;

import org.junit.Test;
import cn.csu.factory.AbstractCarFactory;
///import cn.csu.factory.ORVFactory;
import cn.csu.factory.SportsCarFactory;
import cn.csu.product.AbstractBMW;
import cn.csu.product.AbstractBenz;

public class AbstractFactoryTest {

	@Test
	public void test() {

//		AbstractCarFactory factory = new ORVFactory();
		 AbstractCarFactory factory = new SportsCarFactory();
		AbstractBenz benz = factory.BenzFactory();
		AbstractBMW bmw = factory.BMWFactory();

		benz.drive();
		bmw.drive();

	}
}
