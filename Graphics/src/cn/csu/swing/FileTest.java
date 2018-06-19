package cn.csu.swing;

import java.io.File;
import org.junit.Test;

public abstract class FileTest {

	@Test
	public void fileTest() {
		System.out.println(new File("D:\\Eclipse_Workspace\\NIO\\src\\Java8 API.chm").getPath());
	}

	public static void main(String[] args) {
		System.out.println(new File("D:\\Eclipse_Workspace\\NIO\\src\\Java8 API.chm").getPath());
	}
}
