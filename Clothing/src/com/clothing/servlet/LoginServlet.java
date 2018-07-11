package com.clothing.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clothing.bean.User;
import com.clothing.db.DAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("user_name");
		String password = request.getParameter("user_pass");
		String userNameMessage = "";
		String passwordMessage = "";
		boolean flag = true;
		if ("".equals(userName)) {
			userNameMessage = "用户名不能为空！";
			flag = false;
		}
		if ("".equals(password)) {
			passwordMessage = "密码不能为空！";
			flag = false;
		}

		List<User> list = DAO.getForList(User.class, "select * from tb_user");
		User user = null;
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				 user = list.get(i);
				if (userName.equals(user.getUserName()) && password.equals(user.getUserPass())) {
					request.getSession().setAttribute("user", user);
					break;
				}
			
					if (userName.equals(user.getUserName()) && !"".equals(password) && !password.equals(user.getUserPass())) {
						passwordMessage = "密码错误！";
						flag = false;
						break;
					}
				
				
					if ( i == list.size() - 1 && !"".equals(userName) && !userName.equals(user.getUserName())) {
						userNameMessage = "用户名不存在！";
						flag = false;
					}
				
			}
		}
		request.getSession().setAttribute("userNameMessage", userNameMessage);
		request.getSession().setAttribute("passwordMessage", passwordMessage);
		request.getSession().setAttribute("userName", userName);
		if (flag) {
			request.getRequestDispatcher("jsp/homePage.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
		}
	}

}
