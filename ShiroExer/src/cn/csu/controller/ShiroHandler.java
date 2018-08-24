package cn.csu.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("shiro")
public class ShiroHandler {

	@RequestMapping("login")
	public String login(@RequestParam(value = "username", required = false, defaultValue = "") String userName,
			@RequestParam(value = "password", required = false, defaultValue = "") String password) {
		Subject currentUser = SecurityUtils.getSubject();
		System.out.println("\n\n\n----->login");
		if (!currentUser.isAuthenticated()) {
			// 把用户名和密码封装为 UsernamePasswordToken 对象
			UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
			// rememberme
			token.setRememberMe(true);
			try {
				System.out.println("\n\n\n-----1." + token.hashCode());
				System.out.println("-----Principal:" + token.getPrincipal());
				System.out.println("-----Username:" + token.getUsername());
				System.out.println("-----Host:" + token.getHost());
				// 执行登录.
				currentUser.login(token);
			} catch (AuthenticationException ae) {
				System.out.println("登录失败\n\n\n " + ae.getMessage());
			}
		}

		return "redirect:/list.jsp";
	}

}
