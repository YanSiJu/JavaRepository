package cn.csu.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

import org.junit.Test;

import cn.csu.enums.WeekDayEnum;

public class EnumTest {

	public EnumTest() {

	}

	@Test
	public void test() {
		WeekDayEnum today = WeekDayEnum.Sun;
		WeekDayEnum sun = WeekDayEnum.Sun;
		System.out.println("today == sun:" + (sun == today));
		System.out.println("today instanceof Object:" + (today instanceof Object));
		System.out.println(today + ":" + today.getIndex());
		today.display();

	}

	@Test
	public void enumReflectTest() throws NoSuchMethodException, SecurityException {
		Constructor<WeekDayEnum> constructor = WeekDayEnum.class.getDeclaredConstructor();
		System.out.println("constructor:" + constructor);

	}

	@Test
	public void enumSerializableTest() {

		WeekDayEnum today = WeekDayEnum.Sun;
		WeekDayEnum sun = (WeekDayEnum) serializableObject(today);
		WeekDayEnum s = (WeekDayEnum) serializableObject(today);
		System.out.println("sun == s:" + (sun == s));
		System.out.println("sun == today:" + (sun == today));

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
