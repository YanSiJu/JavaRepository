package com.ascent.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ascent.bean.Usr;
import com.ascent.dao.LoginDAO;

/**
 * Servlet implementation class NewLoginServlet
 */
public class NewLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		HttpSession session = request.getSession();
		LoginDAO dao = new LoginDAO();
		Usr user = dao.logIn(username, password);
		if(user != null){
//		session.setAttribute("user", user);
			if("1".equals(user.getSuperuser()))
				out.println("您是普通用户");
			else
				out.println("您是管理员");
		}
		else
			out.println("用户名或密码错，登录失败");
		out.println("</body></html>");
		out.flush();
		out.close();
			
		}
}

