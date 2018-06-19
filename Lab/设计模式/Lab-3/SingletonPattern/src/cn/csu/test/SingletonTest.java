package cn.csu.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import cn.csu.beans.Window;
import cn.csu.beans.Singleton;
import cn.csu.beans.TaskManager;

public class SingletonTest {

	@Test
	public void reflectTest() {

		
		try {
			// 获得构造器
			Constructor<TaskManager> constructor = TaskManager.class.getDeclaredConstructor();
			System.out.println(constructor);
			// 设置为可访问
			constructor.setAccessible(true);

			// 构造两个不同的对象
			TaskManager t = constructor.newInstance();
			TaskManager taskManager = constructor.newInstance();
			// 验证是否是不同对象
			System.out.println("taskManager == t:" + (taskManager == t));

		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void staticInnerClassTest() {

		try {
			// 获得构造器
			Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
			System.out.println(constructor);
			// 设置为可访问
			constructor.setAccessible(true);

			// 构造两个不同的对象
			Singleton i = constructor.newInstance();
			Singleton in = constructor.newInstance();
			// 验证是否是不同对象
			System.out.println("i == in:" + (i == in));

		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() {

		TaskManager task = TaskManager.getTaskManager();
		Window w = Window.getWindow();

		System.out.println("window:" + (w == Window.getWindow()));
		System.out.println("TaskManager" + (task == TaskManager.getTaskManager()));

		/*
		 * System.out.println("task:"+task); System.out.println("window:"+w);
		 */

	}
}
