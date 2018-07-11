package com.yf.db;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DBUtil {

	// oracle�������ݿ�ĵ�ַ
	// private static String URL="jdbc:oracle:thin:@localhost:1521:orcl";

	// Sql server�������ݿ�ĵ�ַ databasename Ϊ���������ݿ������
	// private static String URL =
	// "jdbc:sqlserver://localhost:1433;databasename=ajaxdb";
	// �������ݿ���û���
	// private static String USERNAME = "sa";

	// �������ݿ������
	// private static String PASSWORD = "123456";
	// oracle�������ݿ������
	// private static String DRIVER="oracle.jdbc.driver.OracleDriver";

	// sql server�������ݿ������
	// private static String DRIVER =
	// "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	// mysql
	private static String URL = "jdbc:mysql://www.sijuyan.cn:3306/repositorysys?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true";
	private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String USERNAME = "root";
	private static String PASSWORD = "123456";

	public DBUtil() {
		System.out.println("���췽��");
	}

	// ����������,��������ֻ��Ҫ����һ�ξ�����
	static {
		// ��̬��,������������ֻ��ִ��һ��
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// �ṩ��ȡ���ӵķ���
	public static Connection getConnection() {
		Connection cn = null;

		try {
			cn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cn;
	}

	// �ر���Դ�ķ���
	public static void closeAll(Connection cn, Statement st, ResultSet rs) {
		try {
			if (cn != null)
				cn.close();
			if (st != null)
				st.close();
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ͨ����ɾ�ĵķ���
	public static int executeUpdate(String sql, Object... pars) {
		Connection cn = DBUtil.getConnection();
		PreparedStatement st = null;
		int count = 0;
		try {

			st = cn.prepareStatement(sql);

			if (pars != null) {
				// ʹ��ѭ�������ò���
				for (int i = 0; i < pars.length; i++) {
					st.setObject(i + 1, pars[i]);
				}
			}

			count = st.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(cn, st, null);
		}
		return count;
	}

	// ͨ�õĲ�ѯ����
	// Tb_user.class T=Tb_user
	public static <T> List<T> query(String sql, Class<T> cls, Object... obj) {
		List<T> list = new ArrayList<T>();// ����һ������
		Connection cn = DBUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = cn.prepareStatement(sql);
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					pst.setObject(i + 1, obj[i]);
				}
			}
			rs = pst.executeQuery();
			while (rs.next()) {
				T t = cls.newInstance();// �����޲εĹ��췽����������
				// ����set������ʼ������
				Field[] fd = cls.getDeclaredFields();// ��ȡ��������е����� 
				int n = fd.length;// ��ǰ������Ը���
				// ������಻��object ��ô��ȡ��������Ը��� ���ҽ���ǰ��͸����������кϲ�
				if (!cls.getSuperclass().equals(Object.class)) {
					Field[] fdp = cls.getSuperclass().getDeclaredFields();
					fd = Arrays.copyOf(fd, fd.length + fdp.length);
					System.arraycopy(fdp, 0, fd, n, fdp.length);//����ϲ�
				}
				for (int i = 0; i < fd.length; i++) {
					// ͨ�����Ի�ȡ��Ӧ��set����
					String fieldName = fd[i].getName();// ��ȡ���Ե����� user_id
					String methodName = "set"
							+ fieldName.substring(0, 1).toUpperCase()
							+ fieldName.substring(1);// ƴ�ӵõ���Ӧ���Ե�set������
					Method method = null;
					// �����set����
					if (i < n) {
						method = cls.getDeclaredMethod(methodName,
								fd[i].getType()); // ͨ�������������Ե��������� ��ȡ��Ӧset����
					}
					// �����set����
					else {
						method = cls.getSuperclass().getDeclaredMethod(
								methodName, fd[i].getType());
					}
					Object value = null;
					if (fd[i].getType().equals(int.class)) {
						value = rs.getInt(fieldName);
					}
					if (fd[i].getType().equals(double.class)) {
						value = rs.getDouble(fieldName);
					}
					if (fd[i].getType().equals(String.class)) {
						value = rs.getString(fieldName);
					}
					if (fd[i].getType().equals(Date.class)) {
						value = rs.getDate(fieldName);
					}
					method.invoke(t, value);
				}
				list.add(t);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(cn, pst, rs);
		}
		return list;
	}

	public static void main(String[] args) {
		if (DBUtil.getConnection() == null) {
			System.out.println("���ݿ�����ʧ��!");
		} else {
			System.out.println("���ݿ����ӳɹ�!");
		}

	}
}
