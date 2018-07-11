package com.yf.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yf.bean.Tb_color;
import com.yf.dao.Tb_colorDao;

public class ColorServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");// 获取type的类型
		response.setCharacterEncoding("utf-8");
		String message = "";// 操作完成的提示消息
		String path = "ColorServlet?type=query";//
		int i = 0;// 表示 增删改默认的返回值
		
		// 查询的操作
		if ("query".equals(type)) {
			// 将颜色数据查询出来
			Tb_colorDao dao = new Tb_colorDao();// 创建colorDao 调用查询方法
			List<Tb_color> list = dao.queryAll();
			request.setAttribute("list", list);// 将查询的数据放入 request中
			// 服务器转发
			request.getRequestDispatcher("system/color.jsp").forward(request,
					response);
			return;
		}
		
		// 添加的操作
		if ("add".equals(type)) {
			// 获取颜色的名称
			String colorName = request.getParameter("colorName");
			// 设置编码
			colorName = new String(colorName.getBytes("iso-8859-1"), "utf-8");
			System.out.println(colorName);
			Tb_colorDao dao = new Tb_colorDao();
			Tb_color color = new Tb_color();// 创建颜色对象
			color.setColor_name(colorName);// 初始化颜色对象
			i = dao.insert(color);// 调用添加的方法
			if (i > 0) {
				message = "添加成功!";
			} else {
				message = "添加失败";
			}

		}
		
		// 删除的操作
		if ("delete".equals(type)) {
			int id = Integer.parseInt(request.getParameter("colorId"));// 将字符串转换成int类型
			Tb_colorDao dao = new Tb_colorDao();
			i = dao.delete(id);
			if (i > 0) {
				message = "删除成功!";
			} else {
				message = "删除失败";
			}

		}

		// 修改的操作
		if("update".equals(type)){
			String color_name=request.getParameter("colorName");
			color_name = new String(color_name.getBytes("iso-8859-1"), "utf-8");
			int id = Integer.parseInt(request.getParameter("colorId"));// 将字符串转换成int类型
			Tb_colorDao dao=new Tb_colorDao();
			Tb_color color=new Tb_color();
			color.setColor_id(id);
			color.setColor_name(color_name);
			i=dao.update(color);
			if(i>0){
				message="修改成功!";
			}
			else{
				message="修改失败";
			}
		}
		
        //根据id查询的方法
		if("queryId".equals(type)){
			int id = Integer.parseInt(request.getParameter("colorId"));// 将字符串转换成int类型
		   Tb_colorDao dao=new Tb_colorDao();
		   List<Tb_color> list=dao.queryById(id);//根据Id查询的结果
		   Tb_color color=null;
		   if(list.size()>0){
		    color=list.get(0);
		   }
		   request.setAttribute("color", color);
		   System.out.println(color.getColor_name());
		   //查询之后跳转到修改页面
		   request.getRequestDispatcher("system/colorUpdate.jsp").forward(request, response);
		    return;
		}
		
		//根据颜色名字模糊查询
		if("queryByName".equals(type)){
			String name=request.getParameter("name");
			name = new String(name.getBytes("iso-8859-1"), "utf-8");
			Tb_colorDao dao=new Tb_colorDao();
			List<Tb_color> list =dao.queryByName(name);
			request.setAttribute("list", list);// 将查询的数据放入 request中
			// 服务器转发
			request.getRequestDispatcher("system/color.jsp").forward(request,
					response);
			return;	
		}
		request.setAttribute("message", message);
		request.setAttribute("path", path);
		request.getRequestDispatcher("success.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
