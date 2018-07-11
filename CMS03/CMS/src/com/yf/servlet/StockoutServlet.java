package com.yf.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yf.bean.PageBean;
import com.yf.bean.StockoutView;
import com.yf.dao.Tb_stockoutDao;

public class StockoutServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  int page=Integer.parseInt(request.getParameter("page"));//当前页码
          int pageSize=Integer.parseInt(request.getParameter("pageSize"));//页面显示的大小
		   PageBean<StockoutView> pageBean=new PageBean<StockoutView>();
          Tb_stockoutDao dao=new Tb_stockoutDao();
          List<StockoutView> list=dao.queryAllView(page, pageSize);
          pageBean.setCount(dao.queryAllView().size());
          pageBean.setList(list);
          pageBean.setPage(page);
          request.setAttribute("pageBean", pageBean);
          request.getRequestDispatcher("stock/stockout.jsp").forward(request, response);
          
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 this.doGet(request, response);
	}

}
