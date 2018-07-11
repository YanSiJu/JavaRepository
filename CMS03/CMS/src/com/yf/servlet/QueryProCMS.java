package com.yf.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yf.bean.Tb_color;
import com.yf.dao.Tb_colorDao;

public class QueryProCMS extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * 此servlet用于在添加服装之前  查询出所有的颜色 尺码 面料
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        //查颜色
		Tb_colorDao colorDao=new Tb_colorDao();
        List<Tb_color> list=colorDao.queryAll();
        //查尺码
        //查面料
        request.setAttribute("colorList", list);
        request.getRequestDispatcher("system/addClothing.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       this.doGet(request, response);
	}

}
