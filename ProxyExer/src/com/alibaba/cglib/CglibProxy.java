package com.alibaba.cglib;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {

	public CglibProxy() {
	}

	private Object target;

	@Override
	public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

		// ǰ��֪ͨ
		preRequest();
		// ����Ŀ�귽��,ʹ���β��е�object,�����ǳ�Ա����target
		methodProxy.invokeSuper(object, args);
		// ����֪ͨ
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
		System.out.println("����֮ǰ");
	}

	public void postRequest() {
		System.out.println("����֮��\n\n");
	}

}
