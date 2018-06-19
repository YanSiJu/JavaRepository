package cn.ccsu.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import org.junit.Test;
import cn.ccsu.entity.Animal;

public class FieldsTest {

	public FieldsTest() {

	}

	@Test
	public void setFieldTest() {

		try {
			Class<Animal> clazz = Animal.class;
			Constructor<?> con = clazz.getDeclaredConstructor();
			con.setAccessible(true);

			Animal a = (Animal) con.newInstance();
			System.out.println("a:" + a);

			Field age = clazz.getDeclaredField("age");
			age.setAccessible(true);
			age.setInt(a, 25);

			Field name = clazz.getDeclaredField("name");
			name.setAccessible(true);
			name.set(a, "dog");


			Field color = clazz.getDeclaredField("color");
			color.setAccessible(true);
			color.set(a, "white");

			System.out.println("animal:" + a);
			System.out.println("color:" + color.get(a));
			System.out.println("age:" + age.get(a));
			System.out.println("name:" + name.get(a));
			System.out.println("name:" + name.getModifiers());

			Field description = clazz.getDeclaredField("description");
			description.set(null, "Animal");
			System.out.println("\n\ndescription:" + description.get(null));
			System.out.println("\n\ndescription.getType():" + description.getType());
			System.out.println("\n\ndescription.getModifiers():" + description.getModifiers());

		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException | NoSuchFieldException e) {
			e.printStackTrace();
		}

	}

}
