package com.ascent.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataAccessJDBC {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/ascentweb";
	private static String user = "root";
	private static String pwd = "123456";

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return con;
	}

}
