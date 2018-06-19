package com.alibaba.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.alibaba.entity.Goods;
import com.alibaba.entity.User;
import com.alibaba.mapper.GoodsMapper;
import com.alibaba.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("goods")
public class GoodsController {

	@Autowired
	private GoodsMapper mapper;
	@Autowired
	private UserService service;

	@RequestMapping("querygoods")
	public String listGoods(@RequestParam(value = "pn", required = false, defaultValue = "1") int pn,
			Map<String, Object> map) {
		
		PageHelper.startPage(pn, 2);
		List<Goods> gds = mapper.queryGoods();
		PageInfo<Goods> pageInfo = new PageInfo<>(gds, 3);
		printInfo(pageInfo);
		map.put("goodsInfo", pageInfo);

		
		PageHelper.startPage(pn, 2);
		// startPage后紧跟的这个查询就是分页查询
		List<User> emps = service.getAll();
		// 使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
		PageInfo<User> userInfo = new PageInfo<>(emps, 3);
		printUserInfo(userInfo);
		return "goods";
	}

	private void printInfo(PageInfo<Goods> pageInfo) {
		System.out.println("\n\n\n当前页:" + pageInfo.getPageNum());
		for (Goods g : pageInfo.getList()) {
			System.out.println(g);
		}
		System.out.println("连续显示的页数:" + pageInfo.getNavigatePages());
		for (int page : pageInfo.getNavigatepageNums()) {
			System.out.print(page + "  ");
		}
		System.out.println("尾页:" + pageInfo.getPages()+"\n\n\n");
	}

	private void printUserInfo(PageInfo<User> pageInfo) {
		System.out.println("\n\n\n用户信息:");
		System.out.println("当前页:" + pageInfo.getPageNum());
		for (User g : pageInfo.getList()) {
			System.out.println(g);
		}
		System.out.println("连续显示的页数:" + pageInfo.getNavigatePages());
		for (int page : pageInfo.getNavigatepageNums()) {
			System.out.print(page + "  ");
		}
		System.out.println("尾页:" + pageInfo.getPages());
	}

}
