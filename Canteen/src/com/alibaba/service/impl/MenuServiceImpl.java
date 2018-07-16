package com.alibaba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.entity.Menu;
import com.alibaba.mapper.MenuMapper;
import com.alibaba.service.MenuService;
import com.alibaba.util.JedisUtil;

/**
 * @author Bill
 * @title: MenuServiceImpl.java
 * @Package: com.alibaba.service.impl
 * @Description: TODO
 * @date:2018��7��15�� ����5:25:13
 * @version:V1.0
 */
@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper mapper;

	@Override
	public boolean praise(int menuId, int userId) {
		if (!JedisUtil.addToMenuPraiseHSet(userId, menuId)) {
			mapper.praise(menuId);
			return true;
		}
		return false;
	}

	@Override
	public void commentMenu(String content, int userId, int menuId) {

	}

	@Override
	public List<Menu> queryMenu() {
		List<Menu> menu = mapper.selectMenu();
		return menu;
	}

}
