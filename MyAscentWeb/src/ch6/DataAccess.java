package ch6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataAccess {
	final static String url = "jdbc:mysql://localhost:3306/ascentweb";//���Ӵ�
	final static String username="root";//�������ݿ��˻�
	final static String pwd = "123456";
	
	public static Connection getConnection(){
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");//���������࣬��jar���ṩ
			
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
