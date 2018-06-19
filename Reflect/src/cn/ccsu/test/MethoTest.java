package cn.ccsu.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.Test;
import cn.ccsu.entity.Animal;

public class MethoTest {

	public MethoTest() {

	}

	@Test
	public void methodTest() {

		Class<?> clazz;
		Method method;
		Animal a;

		try {
			clazz = Animal.class;
			a = (Animal) clazz.newInstance();

			method = clazz.getMethod("setAge", Integer.class);
			System.out.println("setAge return:" + method.invoke(a, new Integer(15)));
			// System.out.println(method);

			method = clazz.getDeclaredMethod("getAge");
			System.out.println("getAge return:" + method.invoke(a));

			a.setColor("wtite");
			a.setName("dog");

			method = clazz.getDeclaredMethod("info");
			method.setAccessible(true);// 私有成员需设置权限
			method.invoke(a);

		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
