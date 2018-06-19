package cn.ccsu.dao.pool;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
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
import javax.sql.DataSource;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class DbcpUtils {

	private static DataSource dataSource;

	// 数据库连接池应只被初始化一次.
	static {
		try {
			InputStream in = DbcpUtils.class.getClassLoader().getResourceAsStream("dbcp.properties");
			Properties prop = new Properties();
			prop.load(in);
			dataSource = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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
			if (rslt.next()) {
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
