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
import com.clothing.db.JDBCTools;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求参数
		String userName = request.getParameter("user_name");
		String userPass = request.getParameter("user_pass");
		String realName = request.getParameter("real_name");
		String userSex = request.getParameter("user_sex");
		String userMobil = request.getParameter("user_mobil");
		//查询数据库所有用户记录
		List<User> list = DAO.getForList(User.class, "select * from tb_user");
		User user = null;
		//判断数据库中是否有相同用户名的用户
		if(list != null && list.size() > 0){
		for(int i = 0;i < list.size();i++){
			user = list.get(i);
			if(user.getUserName().equals(userName)){
				request.getRequestDispatcher("jsp/registerFail.jsp").forward(request, response);
			}
			if(i == list.size()-1 && !user.getUserName().equals(userName)){
				JDBCTools.update("insert into tb_user(userName,userPass,realName,userSex,userMobil) values(?,?,?,?,?)", userName,userPass,realName,userSex,userMobil);
				request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
			}
		}
		}
		
		
		
		
		
	}

}
