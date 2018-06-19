package com.ascent.util;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

/**
 * <p>Title: SignonFilter</p>
 * <p>Description: ¹ýÂËµÇÂ¼ÇëÇó</p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: ascent</p>
 * @author zy
 * @version 1.0
 */
public class SignonFilter implements Filter {

	public void init(javax.servlet.FilterConfig config) {
	}

	public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hreq = (HttpServletRequest) req;
		HttpServletResponse hres = (HttpServletResponse) res;

		HttpSession session = hreq.getSession(false);
		try {
			if (session != null) {
				String isLogin = (String) session.getAttribute("isLogin");
				if ((isLogin != null) && (isLogin.equals("true"))) {
					chain.doFilter(req, res); // go to resource or next filter
				} else { // user is illegal
					hres.sendRedirect(hreq.getContextPath() +"/index.jsp"); 
				}
			} else { // no session
				hres.sendRedirect(hreq.getContextPath() +"/index.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void destroy() {
	}
}
