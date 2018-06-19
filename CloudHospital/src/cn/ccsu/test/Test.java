package cn.ccsu.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ccsu.bean.User;
import cn.ccsu.dao.UserMapper;

public class Test {

	public Test() {

	}

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper mapper = (UserMapper) ctxt.getBean("userMapper");
		mapper.addUser(new User());
		ctxt.close();
	}

}
