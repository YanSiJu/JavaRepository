package com.yf.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yf.bean.PageBean;
import com.yf.bean.StockoutdetView;
import com.yf.dao.Tb_stockoutdetDao;

public class StockoutDet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int stockout_id=Integer.parseInt(request.getParameter("sid"));
		int page = Integer.parseInt(request.getParameter("page"));// 当前页码
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));// 页面显示的大小
		PageBean<StockoutdetView> pageBean = new PageBean<StockoutdetView>();
		Tb_stockoutdetDao dao = new Tb_stockoutdetDao();
		List<StockoutdetView> list = dao.queryAllView(page, pageSize, stockout_id);
		pageBean.setCount(dao.queryAllView(stockout_id).size());
		pageBean.setList(list);
		pageBean.setPage(page);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("stock/stockoutdet.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
