package cn.ccsu.test;

import static org.junit.Assert.*;
import java.sql.Connection;
import java.util.List;

import org.junit.Test;
import cn.ccsu.dao.DaoUtils;
import cn.ccsu.entity.Customer;

public class DaoUtilsTest {

	@Test
	public void testGetConnection() {
		fail("Not yet implemented");
		DaoUtils dao = new DaoUtils();
		System.out.println(dao.getConnection());
	}

	@Test
	public void testGetRecord() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRecords() {
		// fail("Not yet implemented");
		DaoUtils dao = new DaoUtils();
		Connection conn = dao.getConnection();
		String sql = "select * from customer";
		List<Customer> list = dao.getRecords(Customer.class, sql, conn);
		for(Customer customer:list) {
			System.out.println(customer);	
		}
	}

	public void testupdate() {
		fail("Not yet implemented");
		DaoUtils dao = new DaoUtils();
		Connection conn = dao.getConnection();
		String sql = "INSERT INTO customer(id,name,email) VALUES (?,?,?)";
		System.out.println(dao.update(sql, conn, 18, "¿â¿Ë", "USIphone@163.com"));
	}

}
