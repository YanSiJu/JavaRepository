package cn.ccsu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.ccsu.services.Userservice;

@Controller
public class Handler {

	public Handler() {
		
		System.out.println("Handler  constructor");
	}
	
	
	
	@Autowired
	private Userservice service;

	@RequestMapping("/userHandle")
	public String handle() {

		System.out.println("Handler");
		this.service.add();
		return "show";

	}
}
