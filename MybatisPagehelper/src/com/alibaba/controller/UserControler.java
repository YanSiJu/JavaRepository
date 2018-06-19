package com.alibaba.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.pagehelper.PageInfo;
import com.alibaba.entity.User;
import com.alibaba.service.UserService;
import com.github.pagehelper.PageHelper;

@Controller
@RequestMapping("User")
public class UserControler {

	@Autowired
	private UserService service;

	@RequestMapping("emps")
	public String list(@RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn,
			Map<String, Object> map) {

		// 引入分页查询，使用PageHelper分页功能
		// 在查询之前传入当前页，然后多少记录
		PageHelper.startPage(pn, 5);
		// startPage后紧跟的这个查询就是分页查询
		List<User> emps = service.getAll();
		// 使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
		PageInfo<User> pageInfo = new PageInfo<>(emps, 10);
		// pageINfo封装了分页的详细信息，也可以指定连续显示的页数
		map.put("pageInfo", pageInfo);
		return "UserInfo";
	}
}
