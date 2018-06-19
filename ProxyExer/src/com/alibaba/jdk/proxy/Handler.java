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
		// 返回代理对象，由它调用目标方法
		return Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(),
				this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 3.在此方法中只可以只可以输出Proxy.isProxyClass(proxy.getClass())，输出其他内容会报栈溢出错误:StackOverflowError
		System.out.println("----->:" + Proxy.isProxyClass(proxy.getClass()));
		// 前置通知
		preRequest();
		// 调用目标方法,使用成员变量target,而不是形参中的proxy
		Object result = method.invoke(target, args);
		// 后置通知
		postRequest();
		// 目标方法的返回值
		return result;
	}

	public void preRequest() {
		System.out.println("调用之前");
	}

	public void postRequest() {
		System.out.println("调用之后\n\n");
	}
}
