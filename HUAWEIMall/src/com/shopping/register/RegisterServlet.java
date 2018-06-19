package com.shopping.register;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.dbHandler.DbHandler;
import com.shopping.dbHandler.JDBCTools;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DbHandler dh = new DbHandler();
		List<String> list = dh.getUserName();
		System.out.println(list);
		String tel = request.getParameter("tel");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String name = request.getParameter("name");
		String sql = "insert into user(tel,userName,password,address,name) values(?,?,?,?,?)";
		int count = 0;
		//判断表单提交的用户名是否与数据库中的重复
		if(list.size() > 0){
		for(String s : list){
			count++;
			if(s.equals(userName)){
				request.getRequestDispatcher("register.jsp").forward(request, response);
				break;
			}
			if(count == list.size() - 1){
				JDBCTools.update(sql, tel,userName,password,address,name);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		}
	}

}
