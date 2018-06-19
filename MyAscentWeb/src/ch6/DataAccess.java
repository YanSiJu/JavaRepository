package ch6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataAccess {
	final static String url = "jdbc:mysql://localhost:3306/ascentweb";//连接串
	final static String username="root";//访问数据库账户
	final static String pwd = "123456";
	
	public static Connection getConnection(){
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");//驱动程序类，由jar包提供
			
			conn = DriverManager.getConnection(url,username,pwd);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	}

}
