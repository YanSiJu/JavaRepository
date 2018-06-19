package com.ascent.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class CharacterFilter
 */

public class CharacterFilter implements Filter {

	/**
	 * Default constructor.
	 */
	private String enCoding;

	public CharacterFilter() {

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		this.enCoding = null;

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// pass the request along the filter chain
		if (this.enCoding != null) {

			request.setCharacterEncoding(enCoding);
			response.setContentType("text/html;charset=" + enCoding);
		}
		chain.doFilter(request, response);

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub

		this.enCoding = fConfig.getInitParameter("enCoding");
	}
}
