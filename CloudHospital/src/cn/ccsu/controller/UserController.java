package cn.ccsu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ccsu.bean.User;
import cn.ccsu.service.UserService;

@RequestMapping("/User")
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	private static String SUCCESS = "success";
	private static String FAIL = "fail";

	public UserController() {

	}

	@RequestMapping("Login")
	public String login(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		Integer id = userService.validateUser(name, password);
		if (id != null) {
			session.setAttribute("id", id);
			return SUCCESS;
		} else {
			return FAIL;
		}
	}

	@RequestMapping("/register")
	public String register(User user) {	

		boolean state = userService.addUser(user);
		if (state == true) {
			return "login";
		} else {
			return "RegisterFailed";
		}

	}
}
