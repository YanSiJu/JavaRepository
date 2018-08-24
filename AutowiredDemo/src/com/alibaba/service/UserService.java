package com.alibaba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.alibaba.entity.User;

@Service
public class UserService {

	@Autowired
	private User user;

	public void Login() {

		System.out.println(user);
	}
}
