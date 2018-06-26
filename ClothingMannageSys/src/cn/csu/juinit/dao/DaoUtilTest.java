package cn.csu.juinit.dao;

import static org.junit.Assert.*;
import java.sql.SQLException;
import org.junit.Test;

import cn.csu.dao.util.DaoUtil;

public class DaoUtilTest {

	@Test
	public void testConnectDatabase() {
//		fail("Not yet implemented");
		try {
			System.out.println(new DaoUtil().connectDatabase());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRecord() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRecoreds() {
		fail("Not yet implemented");
	}

	@Test
	public void testCloseConnection() {
		fail("Not yet implemented");
	}

}
