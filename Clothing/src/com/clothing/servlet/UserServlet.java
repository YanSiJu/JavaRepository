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

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String operate = request.getParameter("operate");
		
		if ("delete".equals(operate)) {
			String deleteError = null;
			Integer userId = null;
			String id = request.getParameter("userId");
			if ("".equals(id)) {
				deleteError = "用户ID不能为空";
			} else {
				for (int i = 0; i < id.length(); i++) {
					if (!(id.charAt(i) >= '0' && id.charAt(i) <= '9')) {
						deleteError = "用户ID不合法";
						break;
					}
					if (i == id.length() - 1) {
						userId = Integer.parseInt(id);
					}
				}
			}

			List<User> userList = DbUtils.select(User.class, "select * from tb_user");
			if (userId != null && userList != null && userList.size() > 0) {
				for (int i = 0; i < userList.size(); i++) {
					if (userId == userList.get(i).getUserId()) {
						DbUtils.update("delete from tb_user where userId = ?", userId);

						break;
					}
					if (!"".equals(id) && i == userList.size() - 1 && userId != userList.get(i).getUserId()) {
						deleteError = "不存在该用户";
					}
				}
			}
			if (deleteError == null) {
				deleteError = "删除成功";
			}
			request.getSession().setAttribute("deleteError", deleteError);
		}
		
		
		if ("update".equals(operate)) {
			
			String updateMessage = null;
			User user = (User)request.getSession().getAttribute("user");
			if(user == null){
				request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
			}else{
			String userName = request.getParameter("userName");
			String realName = request.getParameter("realName");
			String userSex = request.getParameter("userSex");
			String userMobil = request.getParameter("userMobil");
			
			DbUtils.update("update tb_user set userName = ? where userId = ?",userName,user.getUserId());
			DbUtils.update("update tb_user set realName = ? where userId = ?",realName,user.getUserId());
			DbUtils.update("update tb_user set userSex = ? where userId = ?",userSex,user.getUserId());
			DbUtils.update("update tb_user set userMobil = ? where userId = ?",userMobil,user.getUserId());
			updateMessage = "修改成功";
			request.getSession().setAttribute("updateMessage", updateMessage);
			}
			
		}
		
		if ("select".equals(operate)) {
			String selectError = null;
			Integer userId = null;
			String id = request.getParameter("userId");
			List<User> userList = null;
			if ("".equals(id)) {
				userList = DbUtils.select(User.class, "select * from tb_user");
			} else {
				for (int i = 0; i < id.length(); i++) {
					if (!(id.charAt(i) >= '0' && id.charAt(i) <= '9')) {
						selectError = "用户ID不合法";
						break;
					}
					if (i == id.length() - 1 && (id.charAt(i) >= '0' && id.charAt(i) <= '9')) {
						userId = Integer.parseInt(id);
					}
				}
			}

			if (userId != null) {

				userList = DbUtils.select(User.class, "select * from tb_user where userId = ?", userId);
				if(userList == null){
					selectError = "找不到该用户";
				}
			}

			request.getSession().setAttribute("userList", userList);
			request.getSession().setAttribute("selectError", selectError);
		}
		
		
		
		request.getRequestDispatcher("jsp/user.jsp").forward(request, response);
	}

}
