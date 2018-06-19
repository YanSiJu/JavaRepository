package cn.csu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.csu.service.UserService;

@Controller
public class UserController {

	@Autowired
	public UserService service;

	public void regist() {
		service.register(null);
	}

	public UserController() {
		System.out.println(this.getClass().getName() + "'s constructor");

	}

}
