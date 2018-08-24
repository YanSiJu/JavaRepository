package cn.csu;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class StringExer {

	public static void main(String[] args) {
		String greeting = "Hello";
		int cpCount = greeting.codePointCount(0, greeting.length());
		System.out.println(cpCount);

		int index = greeting.offsetByCodePoints(0, 4);
		int cp = greeting.codePointAt(index);
		System.out.println("cp:" + cp);

		int[] codePoints = greeting.codePoints().toArray();
		System.out.println(Arrays.toString(codePoints));
	}

	@Test
	void equalsTest() {
		String greeting = "Hello";
		System.out.println(greeting == "Hello");// true
		System.out.println(greeting.substring(0) == "Hello");// true
		System.out.println(greeting.substring(0, 3) == "Hel");// false
	}

	@Test
	void joinTest() {
		
		String greeing = "Hel" + "lo";
		
		String a = "Hel";
		String b = "lo";
		String g = a + "lo";
		String e = a + b;
		
		
		System.out.println(e);
		System.out.println(g);
		System.out.println(greeing);
		
		
	}
}
