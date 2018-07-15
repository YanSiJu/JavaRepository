package com.alibaba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.mapper.MenuMapper;
import com.alibaba.service.MenuService;
import com.alibaba.util.JedisUtil;

/**
 * @author Bill
 * @title: MenuServiceImpl.java
 * @Package: com.alibaba.service.impl
 * @Description: TODO
 * @date:2018年7月15日 下午5:25:13
 * @version:V1.0
 */
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

}
