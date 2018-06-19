package cn.ccsu.proxy.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import cn.ccsu.proxy.Handler;
import cn.ccsu.subject.ISubject;
import cn.ccsu.subject.SubjectAImplA;

public class Client {

	public static void main(String[] args) {

		InvocationHandler handler = new Handler(new SubjectAImplA());
		ISubject subject = (ISubject) Proxy.newProxyInstance(ISubject.class
				.getClassLoader(), new Class[] { ISubject.class }, handler);
		System.out.println("subject:"+subject);
		subject.request();
	}

}
