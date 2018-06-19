<<<<<<< HEAD
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

	@RequestMapping("/authorize")
	public String authorize(ModelMap modelMap, User user) {
		service.authorize(user);
		modelMap.put("user", user);
		return "authorizeSuccess";
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request, @RequestParam(value = "userName", required = false) String name,
			@RequestParam(value = "password", required = false) String pwd) {

		User user = service.login(name, pwd);
		if (user != null) {
			request.getSession().setAttribute("user", user);
			return "index";
		} else {
			request.setAttribute("errorMessage", "ÕÊºÅ»òÃÜÂëÊäÈë´íÎó£¬ÇëÖØĞÂÊäÈë");
			return "login";
		}

	}

}
=======
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

	@RequestMapping("/authorize")
	public String authorize(ModelMap modelMap, User user) {
		service.authorize(user);
		modelMap.put("user", user);
		return "authorizeSuccess";
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request, @RequestParam(value = "userName", required = false) String name,
			@RequestParam(value = "password", required = false) String pwd) {

		User user = service.login(name, pwd);
		if (user != null) {
			request.getSession().setAttribute("user", user);
			return "index";
		} else {
			request.setAttribute("errorMessage", "ÕÊºÅ»òÃÜÂëÊäÈë´íÎó£¬ÇëÖØĞÂÊäÈë");
			return "login";
		}

	}

}
>>>>>>> 4c95842e54af405a20c2d0efa74e5f0893824e2a
