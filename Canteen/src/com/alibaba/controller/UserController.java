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
* @title: UserController.java
* @Package: com.alibaba.controller
* @Description: TODO
* @date:2018年7月15日 下午6:41:10
* @version:V1.0
*/
@Controller
@RequestMapping("User")
public class UserController {

	@Autowired
	private UserService userService;
	private static String apikey = "2dc30c93cb9f554e82bbf644cb25f9d7";

	
	/**     
	* 方法名：login</br>
	* 详述：TODO（简单方法可一句话概述）</br>
	* 开发人员：Bill </br>
	* 创建时间：2018年7月12日  </br>
	* @param request
	* @param data
	* @return
	* @throws 
	*/
	@RequestMapping("login")
	@ResponseBody
	public Map<String, String> login(HttpServletRequest request, @RequestBody String data) {
		System.out.println("\n\n\n登录  data----->" + data);
		User user = null;
		HttpSession session = request.getSession();
		Map<String, String> map = new HashMap<>(1);
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
	* 方法名：getValidateCode</br>
	* 详述：TODO（简单方法可一句话概述）</br>
	* 开发人员：Bill </br>
	* 创建时间：2018年7月12日  </br>
	* @param data
	* @return
	* @throws 
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
		Map<String, String> map = new HashMap<>(1);
		map.put("code", code);
		return map;
	}

	/**     
	* 方法名：regist</br>
	* 详述：TODO（简单方法可一句话概述）</br>
	* 开发人员：Bill </br>
	* 创建时间：2018年7月12日  </br>
	* @param data
	* @return
	* @throws 
	*/
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
		Map<String, String> map = new HashMap<>(1);
		map.put("msg", "1");
		return map;
	}

}
