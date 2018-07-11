package com.alibaba.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.entity.User;
import com.alibaba.service.UserService;
import com.yunpian.JavaSmsApi;

@Controller
@RequestMapping("User")
public class UserController {

	@Autowired
	private UserService userService;
	private static String apikey = "2dc30c93cb9f554e82bbf644cb25f9d7";

	/**
	 * @param request
	 * @param name
	 * @param pwd
	 * @param response
	 */
	@RequestMapping("login")
	public void login(HttpServletRequest request,
			@RequestParam(value = "userName", required = false, defaultValue = "") String name,
			@RequestParam(value = "password", required = false, defaultValue = "") String pwd,
			HttpServletResponse response) {
		User user = userService.login(name, pwd);
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			try {
				request.getRequestDispatcher("").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		try {
			response.sendRedirect("");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("sendCode")
	@ResponseBody
	public Map<String, String> getValidateCode(@RequestBody String data) {
		System.out.println("\n\n\nsendCode  data:" + data);
		String code = null;
		try {
			JSONObject jsonObj = new JSONObject(data);
			String tel = (String) jsonObj.get("tel");
			code = JavaSmsApi.sendCode(tel, apikey);
		} catch (IOException | URISyntaxException | JSONException e) {
			e.printStackTrace();
		}
		Map<String, String> map = new HashMap<>();
		map.put("code", code);
		return map;
	}

	@RequestMapping("register")
	@ResponseBody
	public Map<String, String> regist(@RequestBody String data) {
		System.out.println("\n\n\n开始注册....\ndata" + data);
		String name = null;
		String pwd = null;
		String tel = null;
		try {
			JSONObject jsonObj = new JSONObject(data);
			name = (String) jsonObj.get("name");
			tel = (String) jsonObj.get("tel");
			pwd = (String) jsonObj.get("password");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		userService.register(name, pwd, tel);
		System.out.println("\n\n\n注册成功!!");
		Map<String, String> map = new HashMap<>();
		map.put("msg", "1");
		return map;
	}

}
