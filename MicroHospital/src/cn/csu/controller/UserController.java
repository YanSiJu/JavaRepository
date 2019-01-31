package cn.csu.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.csu.entity.User;
import cn.csu.service.impl.UserServiceImpl;

@Controller
@RequestMapping("User")
public class UserController {

	@Autowired
	private UserServiceImpl service;

	@RequestMapping("register")
	public String register(@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "userName", required = false) String userName,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "tel", required = false) String tel,
			@RequestParam(value = "name", required = false) String name, HttpServletRequest request) {
		int id = 0;
		User user = new User(id, name, userName, password, tel);
		service.register(user);
		request.setAttribute("userName", userName);
		return "user/registerSuccess";
	}

	@RequestMapping("regist")
	public String register() {
		return "user/register";
	}

	@RequestMapping("loginSkip")
	public String login() {
		return "user/login";
	}

	@RequestMapping("sendCode")
	@ResponseBody
	public Map<String, String> sendValidateCode(@RequestBody String mobile) {
		Map<String, String> result = new HashMap<String, String>();
		// 此功能待完善
		result.put("code", "code");
		System.out.println("验证码：" + result);
		return result;
	}

	@RequestMapping("logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	@RequestMapping("validateUserName")
	@ResponseBody
	public Map<String, String> ifUserNameDuplicate(@RequestBody String name) {
		Map<String, String> result = new HashMap<String, String>();
		try {
			JSONObject jsonobj = new JSONObject(name);
			if (service.ifUserNameDuplicate(jsonobj.get("name").toString())) {
				result.put("msg", "该用户名已被注册");
			} else {
				result.put("msg", "OK");
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping("login")
	public String login(@RequestParam(value = "userName", required = false) String name,
			@RequestParam(value = "password", required = false) String pwd, HttpServletRequest request) {

		User user = service.login(name, pwd);
		if (user != null) {
			System.out.println("----->登录成功!!" + "\n\n\n");
			return "index";
		}
		request.setAttribute("errorMsg", "帐号或密码错误，请重新输入");
		request.setAttribute("userName", name);
		request.setAttribute("pwd", pwd);
		// return "user/login";
		return "forward:/index.jsp";
	}

}
