package com.yf.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yf.bean.StockindetView;
import com.yf.dao.Tb_stockindetDao;

public class StockindetServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          int sid=Integer.parseInt(request.getParameter("sid"));
          Tb_stockindetDao dao=new Tb_stockindetDao();
          List<StockindetView> list=dao.queryStockinView(sid);
          request.setAttribute("list", list);
          request.getRequestDispatcher("stock/stockindet.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        this.doGet(request, response);
	}

}
