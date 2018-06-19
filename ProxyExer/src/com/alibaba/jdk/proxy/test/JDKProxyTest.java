package com.alibaba.jdk.proxy.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.Test;
import com.alibaba.jdk.proxy.Handler;
import com.alibaba.service.ICountService;
import com.alibaba.service.Impl.CountServiceImpl;

public class JDKProxyTest {

	public JDKProxyTest() {

	}

	@Test
	public void dynamicProxyTest() {
		// 目标对象
		ICountService service = new CountServiceImpl();
		Handler handler = new Handler();
		// 返回一个代理对象
		ICountService proxy = (ICountService) handler.bind(service);
		// 1.此处打印proxy时会调用invoke()方法，很奇怪
		System.out.println("handler:" + handler);
		System.out.println("class:" + proxy.getClass().getName());
		System.out.println("Superclass:" + proxy.getClass().getSuperclass());
		System.out.println("Interface:" + proxy.getClass().getInterfaces()[0] + "\n");

		proxy.updateCount();
		// 2.目标对象的任何方法都会被拦截,是否可以指定只拦截某些方法(当然，不用Spring AOP 的情况下)
		proxy.queryCount();
		proxy.getClass();

	}

	@Test
	public void Test() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		// 目标对象
		ICountService service = new CountServiceImpl();
		Handler handler = new Handler();
		// 返回一个代理对象
		ICountService proxy = (ICountService) handler.bind(service);

		Class<? extends ICountService> clazz = proxy.getClass();
		Class<?>[] interfaces = clazz.getInterfaces();
		Method[] methods = clazz.getMethods();
		Field[] fields = clazz.getFields();

		System.out.println("---------------Interfaces-------------\n");
		for (Class<?> i : interfaces) {
			System.out.println(i);
		}

		System.out.println("\n\n---------------Methods-------------\n");
		for (Method m : methods) {
			System.out.println(m);
		}

		System.out.println("\n---------------Fields-------------\n");
		for (Field f : fields) {
			System.out.println(f);
		}

		Method m = clazz.getMethod("getInvocationHandler", Object.class);
		System.out.println(m.invoke(null, proxy));
	}
}
