package com.ascent.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.ascent.bean.Usr;
import com.ascent.dao.UserManagerDAO;

/**
 * Servlet implementation class FindAllUserServlet
 */
public class FindAllUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllUserServlet() {
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
		UserManagerDAO dao = new UserManagerDAO();
		ArrayList<Usr> users = (ArrayList<Usr>) dao.getAllProductUser();

		//实验2（4）的内容（3）
		/*
		request.setAttribute("users", users);
		RequestDispatcher rd = request.getRequestDispatcher("exp2-4/showAllUser.jsp");
		rd.forward(request, response);
		*/
//	实验2（1）的内容（3)		
		PrintWriter out = response.getWriter();
		out.println("<html><body><table border='1'>");
		out.println("<tr><td>编号</td><td>用户名</td><td>公司名称</td><td>公司地址</td><td>电话</td><td>电子邮件</td></tr>");
		
		for(Usr u : users){
			out.println("<tr><td>"+u.getId()+"</td><td>"+u.getUsername()+"</td><td>"+u.getCompanyname()+"</td><td>"
		+u.getCompanyaddress()+"</td><td>"+u.getTel()+"</td><td>"+u.getEmail()+"</td><tr>");
		}
		out.println("</table></body></html>");
		out.flush();
		out.close();
		
	}

}
