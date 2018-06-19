package com.ascent.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.ascent.bean.Usr;
import com.ascent.dao.LoginDAO;
import com.ascent.dao.UserManagerDAO;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	private ServletContext sc = null;

	public void init() throws ServletException {
		super.init();
		sc = this.getServletContext();
	}

	// Process the HTTP Post request
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取登录状态（登录或退出系统）；
		String loginstate = request.getParameter("a");
		if (loginstate.equals("out")) {// 为退出系统动作
			this.loginOut(request, response);
		} else if (loginstate.equals("login")) {// 为系统登录动作
			this.userLogin(request, response);
		}else if (loginstate.equals("regis")){// 为添加用户
			this.addUser(request, response);
		}
	}

	/**
	 * 添加用户
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		UserManagerDAO um = new UserManagerDAO();
		// 从session中取验证码
		String code_temp = (String) session.getAttribute("CODE");
		// 获取页面form里的属性值
		String codes = request.getParameter("code");
		String usernames = request.getParameter("username");
		String passwords = request.getParameter("password");
		String companynames = request.getParameter("companyname");
		String companyaddresss = request.getParameter("companyaddress");
		String countrys = request.getParameter("country");
		String citys = request.getParameter("city");
		String jobs = request.getParameter("job");
		String tels = request.getParameter("tel");
		String zips = request.getParameter("zip");
		String emails = request.getParameter("email");

		// 将session中验证码强行清空，更安全
		session.setAttribute("CODE", null);
		if (!code_temp.equalsIgnoreCase(codes.trim())) {
			this.doError(request, response, "您输入的验证码不匹配，请重新注册");
		} else {
			Usr pu = um.findUserByusername(usernames);
			if (pu != null) {
				this.doError(request, response, "您使用的用户名已经被占用了，请重新注册");
			} else {
				Usr productuser = new Usr();
				productuser.setCity(citys);
				productuser.setUsername(usernames);
				productuser.setTel(tels);
				productuser.setPassword(passwords);
				productuser.setZip(zips);
				productuser.setJob(jobs);
				productuser.setEmail(emails);
				productuser.setCountry(countrys);
				productuser.setCompanyname(companynames);
				productuser.setCompanyaddress(companyaddresss);
				productuser.setSuperuser("1");
				um.addProductUser(productuser);
				this.doBrowse(request, response, "/product/regist_succ.jsp");
			}
		}
	}
	
	
	private void doBrowse(HttpServletRequest request,
			HttpServletResponse response, String url) throws ServletException,IOException {
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	private void doBrowseErr(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = sc.getRequestDispatcher("/product/products.jsp");
		rd.forward(request, response);
	}

	private void doError(HttpServletRequest request,HttpServletResponse response, String error)throws ServletException, IOException {
		request.setAttribute("error", error);
		this.doBrowseErr(request, response);
	}

	// Clean up resources
	public void destroy() {
	}

	public void userLogin(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		LoginDAO Ld = new LoginDAO();
		Usr puser = Ld.logIn(name, password);
		if (puser == null) {
			this.doError(request, response, "用户不存在！请注册新账户！");
		} else {
			
			// 用户登录成功 这里开始判断权限 将用户保存到session
			String delsoft = puser.getDelsoft();
			if (delsoft != null && "0".equals(delsoft.trim())) {
				String superuser = puser.getSuperuser();
				if (superuser != null) {
					HttpSession mysession = request.getSession(false);
					mysession.setAttribute("productuser", puser);
					mysession.setAttribute("isLogin", "true"); //用户对session过滤判断
					if (superuser.equals("1")) {// 普通注册用户
						this.doBrowse(request, response,"/product/products.jsp");
					} else if (superuser.equals("2") || superuser.equals("3")) {// 3为超级管理员，2为普通管理员
						UserManagerDAO dao = new UserManagerDAO();
						List<Usr> usrs = dao.getAllProductUser();
						request.setAttribute("allproductlist", usrs);
						this.doBrowse(request, response,"/admin/products_showusers.jsp");
					} else {
						this.doError(request, response, "用户角色错误，请与系统管理员联系！");
					}
				} else {
					this.doError(request, response, "用户角色为空，请与系统管理员联系！");
				}
			} else {
				this.doError(request, response, "该用户被冻结，请与系统管理员联系！");
			}
		}
	}

	public void loginOut(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		// 清空所有session；
		session.invalidate();
		// 返回首页
		this.doBrowse(request, response, "/index.jsp");
	}
}