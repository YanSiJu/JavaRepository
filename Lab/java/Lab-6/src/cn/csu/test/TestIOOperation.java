package cn.csu.test;

import java.io.IOException;

import cn.csu.service.IOOperation;

public class TestIOOperation {

	public static void main(String[] str) {

		try {
			IOOperation.testIO();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
