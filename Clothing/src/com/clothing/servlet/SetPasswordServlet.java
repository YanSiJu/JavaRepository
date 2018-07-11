package com.clothing.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clothing.bean.User;
import com.clothing.db.DbUtils;


@WebServlet("/SetPasswordServlet")
public class SetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String password3 = request.getParameter("password3");
		String message1 = null;
		String message2 = null;
		String message3 = null;
		String userName = (String) request.getSession().getAttribute("userName");
		List<User> userList = DbUtils.select(User.class, "select userPass from tb_user where userName = ?", userName);
		if("".equals(password1.trim())){
			message1 = "请输入旧密码";
		}
		if("".equals(password2.trim())){
			message2 = "请输入新密码";
		}
		if("".equals(password3.trim())){
			message3 = "请确认密码";
		}
		if(userList == null){
			request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
		}
		if(userList != null &&!"".equals(password1.trim()) && !userList.get(0).getUserPass().equals(password1)){
			message1 = "密码错误";
		}
		if(userList.get(0).getUserPass().equals(password1) && password1.equals(password2)){
			message2 = "新旧密码不能相同";
		}
		if(!password2.equals(password3)){
			message3 = "两次输入的密码不一致";
		}
		
		request.getSession().setAttribute("password1", password1);
		request.getSession().setAttribute("password2", password2);
		request.getSession().setAttribute("password3", password3);
		
		if(message1 == null && message2 == null && message3 == null){
			DbUtils.update("update tb_user set userPass = ? where userName = ?", password2,userName);
			request.getRequestDispatcher("jsp/setSuccess.jsp").forward(request, response);
		}else{
			request.getSession().setAttribute("message1", message1);
			request.getSession().setAttribute("message2", message2);
			request.getSession().setAttribute("message3", message3);
			request.getRequestDispatcher("jsp/setPassword.jsp").forward(request, response);
		}
		
	}

}
