package com.qzdatasoft.JDBC;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.beanutils.BeanUtils;

public class JDBCTools {

	public Connection connectDatabase() throws SQLException, IOException, ClassNotFoundException {

		// 1. 准备连接数据库的 4 个字符串.
		// 1). 创建 Properties 对象
		Properties properties = new Properties();

		// 2). 获取 jdbc.properties 对应的输入流
		InputStream in = JDBCTools.class.getClassLoader().getResourceAsStream("jdbc.properties");

		// 3). 加载 2） 对应的输入流
		properties.load(in);

		// 4). 具体决定 user, password 等4 个字符串.
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		String jdbcUrl = properties.getProperty("jdbcUrl");
		String driver = properties.getProperty("driver");

		// 2. 加载数据库驱动程序(对应的 Driver 实现类中有注册驱动的静态代码块.)
		Class.forName(driver);

		// 3. 通过 DriverManager 的 getConnection() 方法获取数据库连接.
		return DriverManager.getConnection(jdbcUrl, user, password);

	}

	public void update(Connection conn, String sql, Object... args) {

		PreparedStatement ps = null;
		try {

			ps = conn.prepareStatement(sql);

			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}

			ps.executeUpdate();

			System.out.println("\n  数据更新成功!!\n");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println("\nPreparedStatement  关闭失败!!\n");
				e.printStackTrace();
			}
		}

	}

			//适用于只返回单行数据
	public <T> T get(Class<T> clazz, Connection conn, String sql, Object... args) {

		T entity = null;
		PreparedStatement ps = null;

		try {

			// 获取PreparedStatement对象
			ps = conn.prepareStatement(sql);

			// 给参数赋值,并执行查询语句,得到ResultSet
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			ResultSet rs = ps.executeQuery();

			// 根据ResultSet得到ResultSetMetaData
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();

			// 映射集合，存储列名和列值的映射集合
			Map<String, Object> values = new HashMap<>();

			// 根据ResultSet和ResultSetMetaData得到列名和列值的映射集合
			if (rs.next()) {

				for (int i = 0; i < columnCount; i++) {

					String columnLabel = metaData.getColumnLabel(i + 1);
					Object columnValue = rs.getObject(columnLabel);
					values.put(columnLabel, columnValue);

				}

			}

			if (values.size() > 0) {

				entity = clazz.newInstance();

				// 利用反射给实体对象的属性赋值
				for (Map.Entry<String, Object> entry : values.entrySet()) {

					String name = entry.getKey();
					Object value = entry.getValue();
					//ReflectionUtils.setFieldValue(entity, name, value);
					BeanUtils.setProperty(entity, name, value);
				}

			}
			// InstantiationException

		} catch (SQLException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			// 关闭PreparedStatement对象
			try {

				if (ps != null) {

					ps.close();
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return entity;
	}
}
