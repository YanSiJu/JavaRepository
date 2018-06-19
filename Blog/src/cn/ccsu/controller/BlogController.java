package cn.ccsu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import cn.ccsu.service.BlogService;

@RequestMapping("/Blog")
public class BlogController {

	@SuppressWarnings("unused")
	private BlogService service;
}
