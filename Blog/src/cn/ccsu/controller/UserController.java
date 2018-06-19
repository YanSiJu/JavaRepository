package cn.ccsu.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import cn.ccsu.entity.User;
import cn.ccsu.service.UserService;

@RequestMapping("/User")
@Controller
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping("/register")
	public String register(HttpServletRequest request, ModelMap modelMap, User user) {
		service.register(user);
		modelMap.put("userName", user.getUserName());
		return "registerSuccess";
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request, @RequestParam(value = "user", required = false) String name,
			@RequestParam(value = "password", required = false) String pwd) {

		User user = service.login(name, pwd);
		if (user != null) {
			request.getSession().setAttribute("user", user);
			return "index";
		} else {
			request.setAttribute("errorMessage", "用户名或密码输入错误，请重新输入");
			return "login";
		}

	}

}
