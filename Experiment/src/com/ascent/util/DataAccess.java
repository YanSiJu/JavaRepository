package com.ascent.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import org.apache.commons.beanutils.BeanUtils;

public class DataAccess {

	private static String url;
	private static String user;
	private static String password;

	static {
		InputStream in = null;
		try {
			in = DataAccess.class.getClassLoader().getResourceAsStream("db.properties");
			Properties prop = new Properties();
			prop.load(in);
			Class.forName(prop.getProperty("jdbc.driver"));
			url = prop.getProperty("jdbc.url");
			user = prop.getProperty("jdbc.username");
			password = prop.getProperty("jdbc.password");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public <T> T getRecord(Class<T> clazz, String sql, Connection conn, Object... args) {
		PreparedStatement stmt = null;
		T entity = null;
		try {
			stmt = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				stmt.setObject(i + 1, args[i]);
			}
			ResultSet rslt = stmt.executeQuery();
			ResultSetMetaData metaData = rslt.getMetaData();
			int count = metaData.getColumnCount();
			Map<String, Object> values = new HashMap<>();
			if(rslt.next()) {
				values.clear();
				entity = clazz.newInstance();
				for (int i = 0; i < count; i++) {
					String columnLabel = metaData.getColumnLabel(i + 1);
					Object columnvalue = rslt.getObject(columnLabel);
					values.put(columnLabel, columnvalue);
				}
				for (Entry<String, Object> entry : values.entrySet()) {
					BeanUtils.setProperty(entity, entry.getKey(), entry.getValue());
				}
			}

		} catch (SQLException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}finally {
			release(conn, stmt);
		}
		return entity;
	}

	public <T> List<T> getRecords(Class<T> clazz, String sql, Connection conn, Object... args) {
		PreparedStatement stmt = null;
		List<T> list = new LinkedList<>();
		try {
			stmt = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				stmt.setObject(i + 1, args[i]);
			}
			ResultSet rslt = stmt.executeQuery();
			ResultSetMetaData metaData = rslt.getMetaData();
			int count = metaData.getColumnCount();
			Map<String, Object> values = new HashMap<>();
			T entity;
			while (rslt.next()) {
				values.clear();
				entity = clazz.newInstance();
				for (int i = 0; i < count; i++) {
					String columnLabel = metaData.getColumnLabel(i + 1);
					Object columnvalue = rslt.getObject(columnLabel);
					values.put(columnLabel, columnvalue);
				}
				for (Entry<String, Object> entry : values.entrySet()) {
					BeanUtils.setProperty(entity, entry.getKey(), entry.getValue());
				}
				list.add(entity);
			}
		} catch (SQLException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}finally {
			release(conn, stmt);
		}
		return list;
	}

	public int update(String sql, Connection conn, Object... args) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				stmt.setObject(i + 1, args[i]);
			}
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			release(conn, stmt);
		}
		return 0;

	}

	public void release(Connection conn, Statement stmt) {

		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
