package com.alibaba.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.entity.User;
import com.alibaba.service.UserService;
import com.yunpian.JavaSmsApi;

/**
 * @author Bill
 *
 */
@Controller
@RequestMapping("User")
public class UserController {

	@Autowired
	private UserService userService;
	private static String apikey = "2dc30c93cb9f554e82bbf644cb25f9d7";

	/**
	 * @param request
	 * @param data
	 * @return
	 */
	@RequestMapping("login")
	@ResponseBody
	public Map<String, String> login(HttpServletRequest request, @RequestBody String data) {
		System.out.println("\n\n\n��¼  data----->" + data);
		User user = null;
		HttpSession session = request.getSession();
		Map<String, String> map = new HashMap<>();
		try {
			JSONObject jsonObj = new JSONObject(data);
			String name = jsonObj.getString("name");
			String pwd = jsonObj.getString("password");
			user = userService.login(name, pwd);
			if (user != null) {
				session.setAttribute("user", user);
				map.put("msg", "1");
			} else {
				map.put("msg", "0");
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * @param data
	 * @return
	 */
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

	/**
	 * @param data
	 * @return
	 */
	@RequestMapping("register")
	@ResponseBody
	public Map<String, String> regist(@RequestBody String data) {
		System.out.println("\n\n\n��ʼע��....\ndata" + data);
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
		System.out.println("\n\n\nע��ɹ�!!");
		Map<String, String> map = new HashMap<>();
		map.put("msg", "1");
		return map;
	}

}
