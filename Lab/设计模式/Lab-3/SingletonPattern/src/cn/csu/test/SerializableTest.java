package cn.csu.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

import cn.csu.beans.Singleton;
import cn.csu.beans.TaskManager;
import cn.csu.beans.Window;

public class SerializableTest {

	@Test
	public void lazyTest() {
		// fail("Not yet implemented");
		TaskManager task = TaskManager.getTaskManager();

		// 通过序列化和反序列化得到2个对象
		TaskManager t_1 = (TaskManager) serializableObject(task);
		TaskManager t_2 = (TaskManager) serializableObject(task);

		// 判断通过序列化和反序列化得到的2个对象是否为同一对象
		System.out.println(t_1 == t_2);
		System.out.println(t_1 == task);

	}

	@Test
	public void hungryTest() {
		// fail("Not yet implemented");
		Window w = Window.getWindow();

		// 通过序列化和反序列化得到2个对象
		Window w_1 = (Window) serializableObject(w);
		Window w_2 = (Window) serializableObject(w);

		// 判断通过序列化和反序列化得到的2个对象是否为同一对象
		System.out.println("w_1 == w_2:" + (w_1 == w_2));

	}

	@Test
	public void innerClassTest() {
		// fail("Not yet implemented");
		Singleton singleton = Singleton.getInstance();

		// 通过序列化和反序列化得到2个对象
		Singleton s_1 = (Singleton) serializableObject(singleton);
		Singleton s_2 = (Singleton) serializableObject(singleton);

		// 判断通过序列化和反序列化得到的2个对象是否为同一对象
		System.out.println("s_1 == singleton:" + (s_1 == singleton));
		System.out.println("s_2 == singleton:" + (s_2 == singleton));
		System.out.println("s_1 == s_2:" + (s_1 == s_2));

	}

	public Object serializableObject(Object obj) {
		ByteArrayOutputStream bos = null;
		ObjectOutputStream oos = null;
		ByteArrayInputStream bis = null;
		ObjectInputStream ois = null;

		try {
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);

			bis = new ByteArrayInputStream(bos.toByteArray());
			ois = new ObjectInputStream(bis);
			return ois.readObject();

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {

			try {
				if (bos != null) {
					bos.close();
				}
				if (oos != null) {
					oos.close();
				}
				if (ois != null) {
					ois.close();
				}
				if (bis != null) {
					bis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return null;

	}
}
