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

		// 1. ׼���������ݿ�� 4 ���ַ���.
		// 1). ���� Properties ����
		Properties properties = new Properties();

		// 2). ��ȡ jdbc.properties ��Ӧ��������
		InputStream in = JDBCTools.class.getClassLoader().getResourceAsStream("jdbc.properties");

		// 3). ���� 2�� ��Ӧ��������
		properties.load(in);

		// 4). ������� user, password ��4 ���ַ���.
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		String jdbcUrl = properties.getProperty("jdbcUrl");
		String driver = properties.getProperty("driver");

		// 2. �������ݿ���������(��Ӧ�� Driver ʵ��������ע�������ľ�̬�����.)
		Class.forName(driver);

		// 3. ͨ�� DriverManager �� getConnection() ������ȡ���ݿ�����.
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

			System.out.println("\n  ���ݸ��³ɹ�!!\n");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println("\nPreparedStatement  �ر�ʧ��!!\n");
				e.printStackTrace();
			}
		}

	}

			//������ֻ���ص�������
	public <T> T get(Class<T> clazz, Connection conn, String sql, Object... args) {

		T entity = null;
		PreparedStatement ps = null;

		try {

			// ��ȡPreparedStatement����
			ps = conn.prepareStatement(sql);

			// ��������ֵ,��ִ�в�ѯ���,�õ�ResultSet
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			ResultSet rs = ps.executeQuery();

			// ����ResultSet�õ�ResultSetMetaData
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();

			// ӳ�伯�ϣ��洢��������ֵ��ӳ�伯��
			Map<String, Object> values = new HashMap<>();

			// ����ResultSet��ResultSetMetaData�õ���������ֵ��ӳ�伯��
			if (rs.next()) {

				for (int i = 0; i < columnCount; i++) {

					String columnLabel = metaData.getColumnLabel(i + 1);
					Object columnValue = rs.getObject(columnLabel);
					values.put(columnLabel, columnValue);

				}

			}

			if (values.size() > 0) {

				entity = clazz.newInstance();

				// ���÷����ʵ���������Ը�ֵ
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

			// �ر�PreparedStatement����
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
