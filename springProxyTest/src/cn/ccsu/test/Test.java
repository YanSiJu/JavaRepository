package cn.ccsu.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.ccsu.service.impl.IUserServiceImpl;

public class Test {

	public Test() {

	}

	public static void main(String[] a) {
		ClassPathXmlApplicationContext ctxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserServiceImpl service =(IUserServiceImpl) ctxt.getBean("iUserServiceImpl");
		service.addUser();
		/*
		 * B b = (B) ctxt.getBean("b"); b.testAnno(); System.out.println("b:"+b);
		 */
		ctxt.close();

	}
}
