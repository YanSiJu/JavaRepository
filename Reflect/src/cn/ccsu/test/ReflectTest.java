package cn.ccsu.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.Test;
import cn.ccsu.entity.Animal;
import cn.ccsu.entity.Toy;

/**
 * @author Bill
 *
 */
public class ReflectTest {

	public ReflectTest() {

	}

	@Test
	public void newInstanceTest() {
		Class<Animal> clazz = Animal.class;
		try {
			Animal a = clazz.newInstance();
			System.out.println(a);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void fieldsTest() {
		Class<Animal> clazz = Animal.class;
		Field[] fields = clazz.getDeclaredFields();
		System.out.println(fields.length);
		printArray(fields);
	}

	private void printArray(Field... args) {
		for (Field arg : args) {
			System.out.println(arg);
		}
	}
	
	
	
	@Test
	public void methodsTest() {
		Class<Animal> clazz = Animal.class;
		Method[] methods = clazz.getDeclaredMethods();
		System.out.println("methods:"+methods);
		for(Method m:methods) {
			System.out.println(m);
		}
	}
	
	
	@Test
	public void constructorsTest() {
		Constructor<?>[] con =Animal.class.getDeclaredConstructors();
		System.out.println("Constructor:"+con);
		for(Constructor<?> c:con) {
			System.out.println(c);
		}
	}

	/**
	 * 
	 */
	@Test
	public void classTest() {

		try {
			Class.forName("cn.ccsu.entity.Toy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Class<Toy> c = Toy.class;
		System.out.println(c);
		System.out.println(c.getClass());
	}

}
