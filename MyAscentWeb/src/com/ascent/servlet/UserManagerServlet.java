package com.ascent.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.ascent.bean.Usr;
import com.ascent.dao.UserManagerDAO;

@SuppressWarnings("serial")
public class UserManagerServlet extends HttpServlet {
	
	private ServletContext sc = null;

	public void init() throws ServletException {
		super.init();
		sc = this.getServletContext();
	}

	// Process the HTTP Post request
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// 获取登录状态（登录或退出系统）；
		String loginstate = request.getParameter("a");
		if (loginstate.equals("all")){// 为查询所用用户
			this.findAllUser(request, response);
		}else if (loginstate.equals("finduser")){// 查找用户
			this.findProductUserbyid(request, response);
		}else if (loginstate.equals("update")){// 更新用户信息
			this.updateProductUser(request, response);
		}else if (loginstate.equals("updatesuper")){// 更新角色信息
			this.updateUserSuper(request, response);
		}else if (loginstate.equals("delsuser")){// 删除用户信息(软删除)
			this.delSoftUser(request, response);
		}
	}

	private void doBrowse(HttpServletRequest request,HttpServletResponse response, String url) throws ServletException,IOException {
		RequestDispatcher rd = sc.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	private void doBrowseErr(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = sc.getRequestDispatcher("/admin/register.jsp");
		rd.forward(request, response);
	}

	private void doError(HttpServletRequest request,HttpServletResponse response, String error)throws ServletException, IOException {
		request.setAttribute("error", error);
		this.doBrowseErr(request, response);
	}

	// Clean up resources
	public void destroy() {
	}

	/**
	 * 查询所有用户
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findAllUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		UserManagerDAO um = new UserManagerDAO();
		List<Usr> usrs = um.getAllProductUser();
		request.setAttribute("allproductlist", usrs);
		this.doBrowse(request, response, "/chapt13/products_showusers.jsp");
		
//		this.doBrowse(request, response, "/admin/products_showusers.jsp");
	}

	/**
	 * 更改用户的权限，只有超级具有该权限
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateUserSuper(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		HttpSession mysession = request.getSession(false);
		Usr pu = (Usr) mysession.getAttribute("productuser");
		if(pu!=null && pu.getSuperuser()!=null && pu.getSuperuser().trim().equals("3")){
			String userid = request.getParameter("uid");
			String supers = request.getParameter("superuser");
			int uid = Integer.valueOf(userid);
			UserManagerDAO um = new UserManagerDAO();
			um.updateSuperuser(uid, supers);
			
			List<Usr> allProductList = um.getAllProductUser();
			request.setAttribute("allproductlist", allProductList);
			this.doBrowse(request, response, "/admin/products_showusers.jsp");
		}else{
			this.doError(request, response, "权限不够，只有超级管理员才可以进行此操作！");
		}
	}

	/**
	 * 软删除用户
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void delSoftUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("uid");
		String valuea = request.getParameter("value");
		int a = Integer.valueOf(valuea);
		int uid = Integer.valueOf(userid);
		UserManagerDAO um = new UserManagerDAO();
		um.delSoftuser(uid, a + "");
		List<Usr> allProductList = um.getAllProductUser();
		request.setAttribute("allproductlist", allProductList);
		this.doBrowse(request, response, "/admin/products_showusers.jsp");
	}

	/**
	 * 查看用户信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findProductUserbyid(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("uid");
		int uid = Integer.valueOf(userid);
		UserManagerDAO um = new UserManagerDAO();
		Usr allProductuser = um.getProductUserByid(uid);
		request.setAttribute("UID_Productuser", allProductuser);
		this.doBrowse(request, response, "/admin/updateproductuser.jsp");
	}

	/**
	 * 更新用户信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateProductUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String uids = request.getParameter("uid");
		String citys = request.getParameter("city");
		String usernames = request.getParameter("username");
		String fullnames = request.getParameter("fullname");
		String titles = request.getParameter("title");
		String tels = request.getParameter("tel");
		String passwords = request.getParameter("password");
		String zips = request.getParameter("zip");
		String jobs = request.getParameter("job");
		String emails = request.getParameter("email");
		String countrys = request.getParameter("country");
		String companynames = request.getParameter("companyname");
		String companyaddresss = request.getParameter("companyaddress");
		String notes = request.getParameter("note");
		
		Usr productuser = new Usr();
		productuser.setId(Integer.valueOf(uids));
		productuser.setCity(citys);
		productuser.setUsername(usernames);
		productuser.setFullname(fullnames);
		productuser.setTitle(titles);
		productuser.setTel(tels);
		productuser.setPassword(passwords);
		productuser.setZip(zips);
		productuser.setJob(jobs);
		productuser.setEmail(emails);
		productuser.setCountry(countrys);
		productuser.setCompanyname(companynames);
		productuser.setCompanyaddress(companyaddresss);
		productuser.setNote(notes);
		
		UserManagerDAO um = new UserManagerDAO();
		um.updateProductuser(productuser);
		List<Usr> allProductList = um.getAllProductUser();
		request.setAttribute("allproductlist", allProductList);
		this.doBrowse(request, response, "/admin/products_showusers.jsp");
	}

	
}