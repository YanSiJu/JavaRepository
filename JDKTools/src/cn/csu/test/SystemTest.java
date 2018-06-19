package cn.csu.test;

import java.util.Map;
import java.util.Map.Entry;

public class SystemTest {

	public static void main(String[] args) {
		System.out.println("console:" + System.console());
		System.out.println("env:" + System.getenv());
		Map<String, String> env = System.getenv();
		for (Entry<String, String> entry : env.entrySet()) {
			System.out.println("key:" + entry.getKey() + "  value:" + entry.getValue());
		}
	}
	// @Test
	// public void testConsole() {
	// fail("Not yet implemented");
	// System.out.println(System.console());
	// }
	//
	// @Test
	// public void testExit() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testGc() {
	// fail("Not yet implemented");
	// }

}
