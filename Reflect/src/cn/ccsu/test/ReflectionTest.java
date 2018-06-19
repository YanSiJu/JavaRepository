package cn.ccsu.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

public class ReflectionTest {

	public ReflectionTest() {
	
	}
	
	@Test
	public void test() {
		Class<String> clazz = String.class;
		
		Method[] methods = clazz.getDeclaredMethods();
		for(Method m:methods) {
			System.out.println(m);
		}
		
		System.out.println("\n\n");
		Field[] args = clazz.getDeclaredFields(); 
		for (Field arg : args) {
			System.out.println(arg);
		}
	}
	
	

}
