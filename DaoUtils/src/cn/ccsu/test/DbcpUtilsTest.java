package cn.ccsu.test;

import org.junit.Test;
import cn.ccsu.dao.pool.DbcpUtils;

public class DbcpUtilsTest {

	@Test
	public void testGetConnection() {
		DbcpUtils pool = new DbcpUtils();
		System.out.println("connection:" + pool.getConnection().getClass());
	}

}
