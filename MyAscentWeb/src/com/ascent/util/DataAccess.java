package com.ascent.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.sql.PooledConnection;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;


public class DataAccess {
	
	private static String driver;
	private static String url;
	private static String user;
	private static String pwd;
	
	static {
		DatabaseConfigParser databaseConfig = new DatabaseConfigParser();
		try {
			databaseConfig.parse("database.conf.xml");
			Properties dbProps = databaseConfig.getProps();
			driver = dbProps.getProperty("driver");
			url = dbProps.getProperty("url");
			user = dbProps.getProperty("user");
			pwd = dbProps.getProperty("password");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DataAccess() throws Exception {

	}

	public static Connection getConnection() {
		Connection con = null;
		try {
			//�����ܹ�����PooledConnection������Դ
			MysqlConnectionPoolDataSource  pooledDS = new MysqlConnectionPoolDataSource();
			pooledDS.setUrl(url);
			pooledDS.setUser(user);
			pooledDS.setPassword(pwd);
			
			/*
			 * ����PooledConnection��  PooledConnection�����ʾ����Դ����������
			 * ��������Ӧ�ó���ʹ�������Ի��ն����ùرգ��Ӷ���������Ҫ�������ӵĴ�����
			 */
			PooledConnection pooledConn = pooledDS.getPooledConnection();
			con = pooledConn.getConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return con;
	}
	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
	
	
	/*public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return con;
	}*/

	/*public static Connection getConnection() {
		Connection con = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql");
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}*/
}
