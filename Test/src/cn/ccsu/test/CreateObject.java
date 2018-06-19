package cn.ccsu.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.Test;
import cn.ccsu.beans.Person;

public class CreateObject {

	public static void main(String... args) throws InstantiationException, IllegalAccessException,
			NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {

		Person p = Person.class.newInstance();
		System.out.println((p instanceof Person) + "\n");

		// p.getClass();
		Constructor<Person> c = Person.class.getConstructor();
		System.out.println(c.toString());
		Person m = c.newInstance();
		System.out.println(m instanceof Person);

	}

	@Test
	public void testClone() {

		Person p = new Person("Martin", 26);
		Person m = (Person) p.clone();
//		p.Person();

		System.out.println("TestClone:" + (p == m));

	}

	@Test
	public void testSerializable() throws FileNotFoundException, IOException, ClassNotFoundException {

		Person p = new Person("Martin", 26);
		System.out.println("\nTestSerializable");

		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.obj"));
		out.writeObject(p);
		out.close();

		ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.obj"));
		Person m = (Person) in.readObject();
		in.close();

		System.out.println(p == m);
		System.out.println("\nTestSerializable");

	}
}
