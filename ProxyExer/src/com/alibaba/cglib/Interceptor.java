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
		// ǰ��֪ͨ
		preRequest();
		// ����Ŀ�귽��,ʹ���β��е�proxy,�����ǳ�Ա����target
		Object result = methodProxy.invokeSuper(proxy, args);
		// ����֪ͨ
		postRequest();
		return result;
	}

	public void preRequest() {
		System.out.println("\n����֮ǰ");
	}

	public void postRequest() {
		System.out.println("����֮��\n\n");
	}

}
