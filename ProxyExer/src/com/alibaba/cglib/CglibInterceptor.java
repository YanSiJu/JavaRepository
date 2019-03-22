package com.alibaba.cglib;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibInterceptor implements MethodInterceptor {

	public CglibInterceptor() {
	}

	private Object target;

	@Override
	public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

		// 前置通知
		preRequest();
		// 调用目标方法,使用形参中的object,而不是成员变量target
		methodProxy.invokeSuper(object, args);
		// 后置通知
		postRequest();

		return null;
	}

	public Object getProxy(Object obj) {
		this.target = obj;

		Enhancer eh = new Enhancer();
		eh.setCallback(this);
		eh.setSuperclass(target.getClass());
		return eh.create();
	}

	public void preRequest() {
		System.out.println("调用之前");
	}

	public void postRequest() {
		System.out.println("调用之后\n\n");
	}

}
