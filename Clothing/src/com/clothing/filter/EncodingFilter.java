package com.clothing.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter extends HttpFilter{
	

	private String encoding;
	
	@Override
	public void init() {
		encoding = getFilterConfig().getServletContext().getInitParameter("encoding");
	}
	
	
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
	}


	@Override
	public void destroy() {
		
	}

}
