package cn.csu;

import java.nio.file.Paths;

public class InputOutput {

	public static void main(String[] args) {
		String dir = System.getProperty("user.dir");
		System.out.println(dir);
		System.out.println(Paths.get("InputOutput.java"));
	}
}
