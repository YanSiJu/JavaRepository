package cn.ccsu.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import cn.ccsu.dao.pool.C3p0Utils;

public class C3p0UtilsTest {

	@Test
	public void testGetConnection() {
		C3p0Utils pool = new C3p0Utils();
		Connection conn = pool.getConnection();
		try {
			System.out.println(conn + "\nUrl---->" + conn.getMetaData().getURL());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
