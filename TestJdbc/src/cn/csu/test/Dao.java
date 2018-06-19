package cn.csu.test;

import java.io.IOException;
import java.io.InputStream;
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
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class Dao {
	
	private static DataSource dataSource = null;

	// ���ݿ����ӳ�Ӧֻ����ʼ��һ��.
	static {

		InputStream inStream = null;
		
		try {

			Properties properties = new Properties();
			inStream = Dao.class.getClassLoader().getResourceAsStream("dbcp.properties");
			properties.load(inStream);

			dataSource = BasicDataSourceFactory.createDataSource(properties);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (inStream != null)
					inStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public Connection getConnection() throws SQLException {
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

	// �÷��������ڷ��ص��м�¼
	public <T> T getRecord(Class<T> clazz, Connection conn, String sql, Object... args) {

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
					// ReflectionUtils.setFieldValue(entity, name, value);
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

	// �÷��������ڷ��ض��м�¼
	public <T> List<T> getRecoreds(Class<T> clazz, Connection conn, String sql, Object... args) {
		T entity = null;
		List<T> list = new ArrayList<>();

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

			while (rs.next()) {

				values.clear();
				// ����ResultSet��ResultSetMetaData�õ���������ֵ��ӳ�伯��
				for (int i = 0; i < columnCount; i++) {

					String columnLabel = metaData.getColumnLabel(i + 1);
					Object columnValue = rs.getObject(columnLabel);
					values.put(columnLabel, columnValue);

				}

				if (values.size() > 0) {

					entity = clazz.newInstance();

					// ���÷����ʵ���������Ը�ֵ
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

		} catch (SQLException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
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
