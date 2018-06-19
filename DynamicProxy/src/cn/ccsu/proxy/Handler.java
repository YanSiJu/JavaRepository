package cn.ccsu.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Handler implements InvocationHandler {

	private Object obj;

	public Handler() {

	}

	public Handler(Object obj) {
		this.obj = obj;
	}

	public void preRequest() {
		System.out.println("方法调用前");
	}

	public void postRequest() {
		System.out.println("方法调用后");
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("invoke() method");
		preRequest();
		method.invoke(obj, args);
		postRequest();
		return null;
	}

}
