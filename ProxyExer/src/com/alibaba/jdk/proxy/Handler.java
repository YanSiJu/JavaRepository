package com.alibaba.jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Handler implements InvocationHandler {

	Object target;

	public Handler() {

	}

	public Object bind(Object target) {
		this.target = target;
		// ���ش��������������Ŀ�귽��
		return Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(),
				this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 3.�ڴ˷�����ֻ����ֻ�������Proxy.isProxyClass(proxy.getClass())������������ݻᱨջ�������:StackOverflowError
		System.out.println("----->:" + Proxy.isProxyClass(proxy.getClass()));
		// ǰ��֪ͨ
		preRequest();
		// ����Ŀ�귽��,ʹ�ó�Ա����target,�������β��е�proxy
		Object result = method.invoke(target, args);
		// ����֪ͨ
		postRequest();
		// Ŀ�귽���ķ���ֵ
		return result;
	}

	public void preRequest() {
		System.out.println("����֮ǰ");
	}

	public void postRequest() {
		System.out.println("����֮��\n\n");
	}
}
