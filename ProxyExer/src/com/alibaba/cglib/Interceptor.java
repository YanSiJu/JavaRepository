package com.alibaba.cglib;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.proxy.NoOp;

public class Interceptor implements MethodInterceptor {

	public Interceptor() {

	}

	private Object target;

	public Object getProxyInstance(Object obj) {
		this.target = obj;
		Enhancer eh = new Enhancer();
		eh.setSuperclass(target.getClass());
		eh.setCallbacks(new Callback[] { this, NoOp.INSTANCE });
		eh.setCallbackFilter(new CallbackFilterImpl());
		return eh.create();
	}

	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		// 前置通知
		preRequest();
		// 调用目标方法,使用形参中的proxy,而不是成员变量target
		Object result = methodProxy.invokeSuper(proxy, args);
		// 后置通知
		postRequest();
		return result;
	}

	public void preRequest() {
		System.out.println("\n调用之前");
	}

	public void postRequest() {
		System.out.println("调用之后\n\n");
	}

}
