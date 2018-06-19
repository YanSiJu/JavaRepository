package cn.ccsu.log.test;

import cn.ccsu.log.ProxyLog;
import org.junit.Test;

public class ProxyLogTest {

	@Test
	public void test() {

		int m = 0;
		int n = 1;
		 System.out.println(new ProxyLog().method(m, n));
	}
}
