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
		String type = request.getParameter("type");// ��ȡtype������
		response.setCharacterEncoding("utf-8");
		String message = "";// ������ɵ���ʾ��Ϣ
		String path = "ColorServlet?type=query";//
		int i = 0;// ��ʾ ��ɾ��Ĭ�ϵķ���ֵ
		
		// ��ѯ�Ĳ���
		if ("query".equals(type)) {
			// ����ɫ���ݲ�ѯ����
			Tb_colorDao dao = new Tb_colorDao();// ����colorDao ���ò�ѯ����
			List<Tb_color> list = dao.queryAll();
			request.setAttribute("list", list);// ����ѯ�����ݷ��� request��
			// ������ת��
			request.getRequestDispatcher("system/color.jsp").forward(request,
					response);
			return;
		}
		
		// ��ӵĲ���
		if ("add".equals(type)) {
			// ��ȡ��ɫ������
			String colorName = request.getParameter("colorName");
			// ���ñ���
			colorName = new String(colorName.getBytes("iso-8859-1"), "utf-8");
			System.out.println(colorName);
			Tb_colorDao dao = new Tb_colorDao();
			Tb_color color = new Tb_color();// ������ɫ����
			color.setColor_name(colorName);// ��ʼ����ɫ����
			i = dao.insert(color);// ������ӵķ���
			if (i > 0) {
				message = "��ӳɹ�!";
			} else {
				message = "���ʧ��";
			}

		}
		
		// ɾ���Ĳ���
		if ("delete".equals(type)) {
			int id = Integer.parseInt(request.getParameter("colorId"));// ���ַ���ת����int����
			Tb_colorDao dao = new Tb_colorDao();
			i = dao.delete(id);
			if (i > 0) {
				message = "ɾ���ɹ�!";
			} else {
				message = "ɾ��ʧ��";
			}

		}

		// �޸ĵĲ���
		if("update".equals(type)){
			String color_name=request.getParameter("colorName");
			color_name = new String(color_name.getBytes("iso-8859-1"), "utf-8");
			int id = Integer.parseInt(request.getParameter("colorId"));// ���ַ���ת����int����
			Tb_colorDao dao=new Tb_colorDao();
			Tb_color color=new Tb_color();
			color.setColor_id(id);
			color.setColor_name(color_name);
			i=dao.update(color);
			if(i>0){
				message="�޸ĳɹ�!";
			}
			else{
				message="�޸�ʧ��";
			}
		}
		
        //����id��ѯ�ķ���
		if("queryId".equals(type)){
			int id = Integer.parseInt(request.getParameter("colorId"));// ���ַ���ת����int����
		   Tb_colorDao dao=new Tb_colorDao();
		   List<Tb_color> list=dao.queryById(id);//����Id��ѯ�Ľ��
		   Tb_color color=null;
		   if(list.size()>0){
		    color=list.get(0);
		   }
		   request.setAttribute("color", color);
		   System.out.println(color.getColor_name());
		   //��ѯ֮����ת���޸�ҳ��
		   request.getRequestDispatcher("system/colorUpdate.jsp").forward(request, response);
		    return;
		}
		
		//������ɫ����ģ����ѯ
		if("queryByName".equals(type)){
			String name=request.getParameter("name");
			name = new String(name.getBytes("iso-8859-1"), "utf-8");
			Tb_colorDao dao=new Tb_colorDao();
			List<Tb_color> list =dao.queryByName(name);
			request.setAttribute("list", list);// ����ѯ�����ݷ��� request��
			// ������ת��
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
