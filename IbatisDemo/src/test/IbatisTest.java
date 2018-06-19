package test;

import org.junit.Test;

import ibatis.model.LoginInfo;
import ibatis.util.ParameterMap;
import java.io.*;
import java.sql.SQLException;

import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.*;

public class IbatisTest {

	@Test
	public void test() throws IOException, SQLException {
		String config = "SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader(config);
		SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);

		ParameterMap parameter = new ParameterMap("ID", 222);
		Object info = sqlMap.queryForObject("getLoginInfo", parameter);
		System.out.println("info---->"+info+"\n");

		
		parameter = new ParameterMap("IP", "127.0.0.1");
		@SuppressWarnings("unchecked")
		List<LoginInfo> list = (List<LoginInfo>) sqlMap.queryForList("getLoginInfo", parameter);
		for (LoginInfo inf : list) {
			System.out.println(inf);
		}
		

	}

	/*
	 * @Test public void testInsert() throws IOException, SQLException {
	 * 
	 * String config = "SqlMapConfig.xml"; Reader reader =
	 * Resources.getResourceAsReader(config); SqlMapClient sqlMap =
	 * SqlMapClientBuilder.buildSqlMapClient(reader);
	 * 
	 * ParameterMap parameterMap = new ParameterMap("userName", "Õı«ø", "password",
	 * "123aBN", "mobile", "1", "email", "981348@186.com", "userId", "131");
	 * 
	 * System.out.println(sqlMap.update("addUser", parameterMap));
	 * 
	 * }
	 */

	public IbatisTest() {

	}

}
