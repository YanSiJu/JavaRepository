package cn.csu.test;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Test;

public class StringTest {

	@Test
	public void stringPool_2Test() {
		String s = new String("1");
		String s2 = "1";
		s.intern();
		System.out.println(s == s2);

		String s3 = new String("1") + new String("1");
		String s4 = "11";
		s3.intern();
		System.out.println(s3 == s4);

	}

	@Test
	public void stringPool_1Test() {
		String s = new String("1");
		s.intern();
		String s2 = "1";
		System.out.println(s == s2);

		String s3 = new String("1") + new String("1");
		s3.intern();
		String s4 = "11";
		System.out.println(s3 == s4);

	}

	@Test
	public void stringPoolTest() {
		String s1 = new String("stackoverflow");
		String s2 = "stackoverflow";
		System.out.println("s2 == s1:" + (s2 == s1)); // false

		String s3 = "ubuntu deepin Linux";
		String s4 = new String("ubuntu deepin Linux");

		System.out.println("s3 == s4:" + (s3 == s4)); // false

	}

	public static void main(String[] args) {
		String str1 = new String("abc");
		String str2 = new String(str1);

		Field valueField;
		try {

			valueField = str1.getClass().getDeclaredField("value");
			valueField.setAccessible(true);
			char[] value = (char[]) valueField.get(str1);

			valueField = str2.getClass().getDeclaredField("value");
			valueField.setAccessible(true);
			char[] val = (char[]) valueField.get(str2);

			System.out.println("str1 == str2:" + (str1 == str2)); // false
			System.out.println("value == val:" + (value == val)); // true

		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void reflectTest() {
		String str = "Deepin Ubuntu";
		try {
			Field valueField = str.getClass().getDeclaredField("value");
			valueField.setAccessible(true);
			char[] value = (char[]) valueField.get(str);
			System.out.println(value);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unused")
	@Test
	public void asciiTest() {
		fail("Not yet implemented");
		scan: {
			for (char i = 0; i <= 32; i++) {
				char c = i;
				System.out.println(c);
			}

		}
	}

	@Test
	public void testString() {
		fail("Not yet implemented");
		char[] c = { 'U', 'b', 'u', 'n', 't', 'u' };
		String s = new String(c, 1, 0);
		System.out.println(s.hashCode());
	}

	@Test
	public void testEquals() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testValueOfObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testValueOfChar() {
		fail("Not yet implemented");
	}

	@Test
	public void testValueOfInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testValueOfFloat() {
		fail("Not yet implemented");
	}

	@Test
	public void testIntern() {
		fail("Not yet implemented");
		System.out.println(Integer.TYPE);
		String s = new String("Ubuntu deepin NLP");
		String str = s.intern();
		System.out.println(str == s); // true

		String n = "Ubuntu  NLP";
		String a = new String("Ubuntu  NLP");
		String b = a.intern();
		System.out.println(a == n);
		System.out.println(a == b); //
		System.out.println(n == b); //

	}

}
