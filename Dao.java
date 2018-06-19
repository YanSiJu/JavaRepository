package com.qzdatasoft.StudentManagement.Dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Component;
import com.mchange.v2.c3p0.ComboPooledDataSource;


@Component
public class Dao {

	private static DataSource dataSource = null;

	// 数据库连接池应只被初始化一次.
	static {
		dataSource = new ComboPooledDataSource("helloc3p0");
	}

	public Connection connectDatabase() throws SQLException {
		return dataSource.getConnection();
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

	// 该方法适用于返回单行记录
	public <T> T getRecord(Class<T> clazz, Connection conn, String sql, Object... args) {

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
					// ReflectionUtils.setFieldValue(entity, name, value);
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

	// 该方法适用于返回多行记录
	public <T> List<T> getRecoreds(Class<T> clazz, Connection conn, String sql, Object... args) {
		T entity = null;
		List<T> list = new ArrayList<>();

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

			while (rs.next()) {

				values.clear();
				// 根据ResultSet和ResultSetMetaData得到列名和列值的映射集合
				for (int i = 0; i < columnCount; i++) {

					String columnLabel = metaData.getColumnLabel(i + 1);
					Object columnValue = rs.getObject(columnLabel);
					values.put(columnLabel, columnValue);

				}

				if (values.size() > 0) {

					entity = clazz.newInstance();

					// 利用反射给实体对象的属性赋值
					for (Map.Entry<String, Object> entry : values.entrySet()) {

						String name = entry.getKey();
						Object value = entry.getValue();
						// ReflectionUtils.setFieldValue(entity, name, value);
						BeanUtils.setProperty(entity, name, value);
					}

				}

				list.add(entity);
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

		return list;
	}

	public void closeConnection(Connection conn) {

		try {

			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
