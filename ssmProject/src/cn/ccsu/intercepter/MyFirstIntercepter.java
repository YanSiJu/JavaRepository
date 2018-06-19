package cn.ccsu.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyFirstIntercepter implements HandlerInterceptor {

	public MyFirstIntercepter() {
		System.out.println("MyFirstIntercepter controller:" + this.getClass().getName());
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object method, Exception arg3)
			throws Exception {
		System.out.println("MyFirstIntercepter afterCompletion  method:"+method);

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object method, ModelAndView arg3)
			throws Exception {
		System.out.println("MyFirstIntercepter postHandle method:"+method);

	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object method) throws Exception {
		System.out.println("MyFirstIntercepter preHandle  method:"+method);
		return true;
	}

}
