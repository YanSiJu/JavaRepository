package com.clothing.db;

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

import org.apache.commons.beanutils.BeanUtils;

//DAO工具类
public class DAO {
	// 更新数据库的方法(插入insert，删除delete，修改update)
	public static void update(String sql, Object... objects) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// 获取连接
			conn = JDBCTools.getConnection();
			// 获取PreparedStatement对象
			ps = conn.prepareStatement(sql);
			// 遍历可变参数数组
			for (int i = 0; i < objects.length; i++) {
				ps.setObject(i + 1, objects[i]);
			}
			// 执行更新
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			JDBCTools.closeSource(ps, conn);
		}

	}

	/*
	 * 通用的查询方法 clazz:数据库表一条记录对应的一个类的Class对象 sql:执行查询的sql语句
	 * objects:替换sql中的占位符的可变参数列表
	 */
	public static <T> T get(Class<T> clazz, String sql, Object... objects) {
		T entity = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = JDBCTools.getConnection();

			ps = conn.prepareStatement(sql);

			for (int i = 0; i < objects.length; i++) {
				ps.setObject(i + 1, objects[i]);
			}

			rs = ps.executeQuery();

			Map<String, Object> map = new HashMap<String, Object>();

			ResultSetMetaData metaData = rs.getMetaData();

			if (rs.next()) {
				for (int i = 0; i < metaData.getColumnCount(); i++) {
					String columnName = metaData.getColumnLabel(i + 1);
					Object columnValue = rs.getObject(i + 1);
					map.put(columnName, columnValue);
				}
			}

			if (map.size() > 0) {
				entity = clazz.newInstance();
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					String key = entry.getKey();
					Object value = entry.getValue();

					ReflectionUtils.setFieldValue(entity, key, value);

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.closeSource(rs, ps, conn);
		}

		return entity;
	}
	
	
	/*
	 * 通用的查询方法 clazz:数据库表一条记录对应的一个类的Class对象 sql:执行查询的sql语句
	 * objects:替换sql中的占位符的可变参数列表
	 */
	public static <T> T getRecord(Class<T> clazz, String sql, Object... objects) {
		T entity = null;
		List<T> list = getForList(clazz, sql, objects);
		if(list.size() > 0){
		entity = list.get(0);
		}

		return entity;
	}
	
	// 查询所有记录
	public static <T> List<T> getForList(Class<T> clazz, String sql, Object... objects) {
		//数据库中每条记录对应的对象
		
		//存放所有记录的List
		List<T> list = new ArrayList<T>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			//获取连接
			conn = JDBCTools.getC3p0Connection();
			//获取PreparedStatement对象
			ps = conn.prepareStatement(sql);
			//为占位符赋值
			for (int i = 0; i < objects.length; i++) {
				ps.setObject(i + 1, objects[i]);
			}
			//执行查询，获取结果集
			rs = ps.executeQuery();
			//获取存放所有记录的map类型的List集合
			List<Map<String, Object>> lists = getMapList(rs);
			System.out.println(lists);
			//获取最终的存放每条记录对应的对象的List
			list = getResultList(clazz,lists);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			JDBCTools.closeSource(rs, ps, conn);
		}

		return list;
	}

	private static <T> List<T>  getResultList(Class<T> clazz, List<Map<String, Object>> lists)
			throws InstantiationException, IllegalAccessException, InvocationTargetException {
		List<T> list = new ArrayList<T>();
		T entity;
		//如果有记录
		if (lists != null && lists.size() > 0) {
			//遍历存放map的集合
			for (Map<String, Object> m : lists) {
				//利用反射创建存放记录的对象的实例
				entity = clazz.newInstance();
				//遍历List集合中的每一个map
				for (Map.Entry<String, Object> entry : m.entrySet()) {
					String key = entry.getKey();
					Object value = entry.getValue();
					//为每个记录所对应的对象的属性赋值
					BeanUtils.setProperty(entity, key, value);
				}
				//System.out.println(entity);
				//将各个对象添加到存放所有记录的集合中
				list.add(entity);

			}
		}
		
		return list;
	}

	private static List<Map<String, Object>> getMapList(ResultSet rs) throws SQLException {
		//获取ResultSetMetaData对象
		ResultSetMetaData metaData = rs.getMetaData();
		//每个记录对应的对象的所有属性键值对对应一个Map，用一个List集合来存放这些信息
		List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> map = null;
		//遍历结果集
		while (rs.next()) {
			map = new HashMap<>();
			//获取属性对应的键值对放入map
			for (int i = 0; i < metaData.getColumnCount(); i++) {
				String columnName = metaData.getColumnLabel(i + 1);
				Object columnValue = rs.getObject(i + 1);
				map.put(columnName, columnValue);
			}
			//将map添加到List
			
			lists.add(map);

		}
		return lists;
	}
	//结果集应为一行一列(统计或查询某个字段的值)
	@SuppressWarnings("unchecked")
	public static <E> E getForValue(String sql, Object... objects) {
		E e = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = JDBCTools.getConnection();
			//指定事务的隔离级别为:读已提交的数据
			conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			ps = conn.prepareStatement(sql);

			for (int i = 0; i < objects.length; i++) {
				ps.setObject(i + 1, objects[i]);
			}

			rs = ps.executeQuery();
			
			if(rs.next()){
				e = (E) rs.getObject(1);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JDBCTools.closeSource(rs, ps, conn);
		}

		return e;

	}
	
	
	//开始事务
	public static void begin(Connection conn){
		if(conn != null){
			try {
				conn.setAutoCommit(false);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//提交事务
	public static void commit(Connection conn){
		if(conn != null){
			try {
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//回滚事务
	public static void rollback(Connection conn){
		if(conn != null){
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
