package com.clothing.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clothing.bean.Product;
import com.clothing.bean.Size;
import com.clothing.db.DbUtils;


@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operate = request.getParameter("operate");
		
		if("insert".equals(operate)){
			String proName = request.getParameter("proName");
			String sizeId = request.getParameter("sizeId");
			String colorId = request.getParameter("colorId");
			String outmaId = request.getParameter("outmaId");
			String proFacPrice = request.getParameter("proFacPrice");
			String proRetPrice = request.getParameter("proRetPrice");
			System.out.println(proName);
			DbUtils.update("insert into tb_product(proName,sizeId,colorId,outmaId,proFacPrice,proRetPrice) values(?,?,?,?,?,?)", proName,sizeId,colorId,outmaId,proFacPrice,proRetPrice);
			request.getSession().setAttribute("insertSuccess", "新增服装信息成功!");
		}
		
		
		if ("delete".equals(operate)) {
			String deleteError = null;
			Integer proId = null;
			String id = request.getParameter("proId");
			if ("".equals(id)) {
				deleteError = "服装ID不能为空";
			} else {
				for (int i = 0; i < id.length(); i++) {
					if (!(id.charAt(i) >= '0' && id.charAt(i) <= '9')) {
						deleteError = "服装ID不合法";
						break;
					}
					if (i == id.length() - 1) {
						proId = Integer.parseInt(id);
					}
				}
			}

			List<Product> proList = DbUtils.select(Product.class, "select * from tb_product");
			if (proId != null && proList != null && proList.size() > 0) {
				for (int i = 0; i < proList.size(); i++) {
					if (proId == proList.get(i).getProId()) {
						DbUtils.update("delete from tb_user where userId = ?", proId);

						break;
					}
					if (!"".equals(id) && i == proList.size() - 1 && proId != proList.get(i).getProId()) {
						deleteError = "不存在该服装";
					}
				}
			}
			if (deleteError == null) {
				deleteError = "删除成功";
			}
			request.getSession().setAttribute("deleteError", deleteError);
		}

		if ("select".equals(operate)) {
			String selectError = null;
			Integer proId = null;
			String id = request.getParameter("proId");
			List<Product> proList = null;
			List<Size> sizeList = null;
			if ("".equals(id)) {
				proList = DbUtils.select(Product.class, "select * from tb_product");
			} else {
				for (int i = 0; i < id.length(); i++) {
					if (!(id.charAt(i) >= '0' && id.charAt(i) <= '9')) {
						selectError = "服装ID不合法";
						break;
					}
					if (i == id.length() - 1 && (id.charAt(i) >= '0' && id.charAt(i) <= '9')) {
						proId = Integer.parseInt(id);
					}
				}
			}

			if (proId != null) {

				proList = DbUtils.select(Product.class, "select * from tb_product where proId = ?", proId);
				if(proList == null){
					selectError = "找不到该服装";
				}else{
					sizeList = DbUtils.select(Size.class, "select sizeName from tb_size where sizeId = ?", proList.get(0));
				}
			}
			request.getSession().setAttribute("sizeList", sizeList);
			request.getSession().setAttribute("proList", proList);
			request.getSession().setAttribute("selectError", selectError);
		}
		request.getRequestDispatcher("jsp/product.jsp").forward(request, response);
	}

}
