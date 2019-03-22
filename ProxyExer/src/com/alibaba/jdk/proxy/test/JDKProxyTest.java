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
		// Ŀ�����
		ICountService service = new CountServiceImpl();
		Handler handler = new Handler();
		// ����һ���������
		ICountService proxy = (ICountService) handler.bind(service);
		// 1.�˴���ӡproxyʱ�����invoke()�����������
		System.out.println("handler:" + handler);
		System.out.println("class:" + proxy.getClass().getName());
		System.out.println("Superclass:" + proxy.getClass().getSuperclass());
		System.out.println("Interface:" + proxy.getClass().getInterfaces()[0] + "\n");

		proxy.updateCount();
		// 2.Ŀ�������κη������ᱻ����,�Ƿ����ָ��ֻ����ĳЩ����(��Ȼ������Spring AOP �������)
		proxy.queryCount();
		proxy.getClass();

	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
	IllegalArgumentException, InvocationTargetException {
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		// Ŀ�����
		ICountService service = new CountServiceImpl();
		Handler handler = new Handler();
		// ����һ���������
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

	

	@Test
	public void Test() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		// Ŀ�����
		ICountService service = new CountServiceImpl();
		Handler handler = new Handler();
		// ����һ���������
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
