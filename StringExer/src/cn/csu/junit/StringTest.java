package cn.csu.junit;

import java.io.File;
import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Test;

public class StringTest {

	public static void main(String[] args) {
		try {
			new Random(0);
			Object object = null;
			System.out.println(String.valueOf(object));
			System.out.println(char[].class);
			System.out.println(int[].class);
			System.out.println(Integer[].class);
			System.out.println(File[].class);
			System.out.println(Integer.TYPE);
			System.out.println(Boolean.TYPE);
			System.out.println(String.valueOf(null));
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	@Test
	public void finalTest() {
		final int[] a = { 21, 43, 12 };
		int[] b = a;
		System.out.println(b == a);

		a[0] = 90;
		System.out.println(Arrays.toString(a));
		System.out.println(b == a);
	}

}
