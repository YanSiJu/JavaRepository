package com.clothing.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
//自定义JDBC工具类
public class JDBCTools {
	
	private static DataSource ds = null;
	
	static{
		ds = new ComboPooledDataSource("helloc3p0");
		
	}
	
	//从c3p0数据库连接池获取数据库连接
		public static Connection getC3p0Connection() throws Exception{
			System.out.println(ds.getConnection());
			return ds.getConnection();
		}
		
		
	//获取数据库连接
	public static Connection getConnection() throws Exception{
		Connection conn = null;
		String driverClass = null;
		String url = null;
		String user = null;
		String password = null;
		
		Properties prop = new Properties();
		//获取输入流用来读取属性文件
		InputStream is = JDBCTools.class.getClassLoader().getResourceAsStream("jdbc.properties");
		//载入输入流
		prop.load(is);
		//获取属性文件中的各个属性值
		driverClass = prop.getProperty("driverClass");
		url = prop.getProperty("url");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
		//加载驱动
		Class.forName(driverClass);
		//获取连接
		conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
	
	
	//关闭Statement和Connection
	public static void closeSource(Statement stat, Connection conn){
		if(stat != null){
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//关闭ResultSet,Statement和Connection
		public static void closeSource(ResultSet rs, Statement stat, Connection conn){
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(stat != null){	
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			//若使用连接池获取连接，则相当于把连接归还到数据库连接池中
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	
	public static void execute(String sql){
		Connection conn = null;
		Statement stat = null;
		try{
			//获取数据库连接
			conn = getConnection();
			
			//获取Statement对象
			stat = conn.createStatement();	
			
			//调用executeUpdate()方法执行sql语句
			stat.executeUpdate(sql);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//关闭资源
			closeSource(stat,conn);
		}
	}
	//更新数据库(增删改)
	public static void update(String sql, Object ... args){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCTools.getConnection();

			ps = conn.prepareStatement(sql);
			//遍历可变参数数组
			for(int i = 0;i < args.length;i++){
				ps.setObject(i+1, args[i]);
			}
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.closeSource(ps, conn);
		}
	}
	
}
