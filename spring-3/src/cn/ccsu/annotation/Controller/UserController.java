package cn.ccsu.annotation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.ccsu.annotation.services.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	private UserServiceImpl service;
	
	public void controll() {

		System.out.println("UserController....");
		this.service.add();
		
	}
}
