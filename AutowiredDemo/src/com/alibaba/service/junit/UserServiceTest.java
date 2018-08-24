package com.alibaba.service.junit;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.service.UserService;

class UserServiceTest {

	@Test
	void testLogin() {
		ApplicationContext ctxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		new UserService().Login();
	}

}
