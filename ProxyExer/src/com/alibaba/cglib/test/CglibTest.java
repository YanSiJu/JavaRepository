package com.alibaba.cglib.test;

import org.junit.Test;
import com.alibaba.cglib.CglibInterceptor;
import com.alibaba.service.AbstractLog;
import com.alibaba.service.ICountService;
import com.alibaba.service.Impl.CountServiceImpl;
import com.alibaba.service.Impl.IphoneFactory;
import com.alibaba.service.Impl.RealLog;

public class CglibTest {

	public CglibTest() {

	}

	public static void main(String[] args) {
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");  
		AbstractLog s = (AbstractLog) new CglibInterceptor().getProxy(new RealLog());
		System.out.println("class:" + s.getClass());
		System.out.println("Superclass:" + s.getClass().getSuperclass());
		System.out.println("Interface:" + s.getClass().getInterfaces()[0] + "\n");
		s.method();
		// System.out.println("\n-------------toString-------------");
		// s.toString();
		System.out.println("\n-------------hashCoe-------------");
		s.hashCode();
	}

	@Test
	public void cglibProxyTest() {
		AbstractLog s = (AbstractLog) new CglibInterceptor().getProxy(new RealLog());
		System.out.println("class:" + s.getClass());
		System.out.println("Superclass:" + s.getClass().getSuperclass());
		System.out.println("Interface:" + s.getClass().getInterfaces()[0] + "\n");
		s.method();
		// System.out.println("\n-------------toString-------------");
		// s.toString();
		System.out.println("\n-------------hashCoe-------------");
		s.hashCode();

	}

	@Test
	public void cglibProxyTest_1() {
		ICountService service = (ICountService) new CglibInterceptor().getProxy(new CountServiceImpl());
		service.queryCount();
		service.updateCount();
	}

	@Test
	public void cglibProxyTest_2() {
		IphoneFactory factory = (IphoneFactory) new CglibInterceptor().getProxy(new IphoneFactory());
		factory.product();

	}

}
