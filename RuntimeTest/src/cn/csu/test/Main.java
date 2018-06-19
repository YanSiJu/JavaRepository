package cn.csu.test;

import java.io.IOException;

import org.junit.Test;

public class Main {

	public Main() {

	}

	@Test
	public void testRuntime() {
		try {
			System.out.println(Runtime.getRuntime().exec("cmd"));
			System.out.println(Runtime.getRuntime());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
