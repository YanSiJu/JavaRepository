package com.alibaba.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.entity.User;
import com.alibaba.service.MenuService;

/**
 * @author Bill
 * @title: MenuController.java
 * @Package: com.alibaba.controller
 * @Description: TODO
 * @date:2018年7月15日 下午6:46:44
 * @version:V1.0
 */
@Controller
@RequestMapping("menu")
public class MenuController {

	@Autowired
	private MenuService service;

	@RequestMapping("commentPosts")
	@ResponseBody
	public Map<String, String> praise(@RequestBody String data, HttpServletRequest request) {
		Map<String, String> map = new HashMap<>(1);
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(data);
			int menuId = (int) jsonObject.get("menuId");
			User user = (User) request.getSession().getAttribute("user");
			if (user != null) {
				if (service.praise(menuId, user.getUserId())) {
					map.put("msg", "1");
				} else {
					map.put("msg", "0");
				}
			} else {
				map.put("msg", "0");
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping("commentPosts")
	@ResponseBody
	public Map<String, String> commentPosts(@RequestBody String data, HttpServletRequest request) {

		Map<String, String> map = new HashMap<>(1);
		return map;
	}

}
