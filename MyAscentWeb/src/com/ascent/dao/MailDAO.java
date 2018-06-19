package com.ascent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ascent.util.DataAccess;
import com.ascent.util.DataAccessJDBC;

import com.ascent.bean.Mailtb;

/**
 * ����ʼ����Һ���ӹ��ܵ���
 * @author zy
 */
public class MailDAO {

	/**
	 * ��ѯ���õ��ʼ�����
	 * @return �ʼ�����
	 * @throws SQLException
	 */
	public Mailtb findMail() throws SQLException {
		Connection conn = DataAccess.getConnection();
		Statement st = conn.createStatement();
		String sql = "select * from mailtb";
		ResultSet rs = st.executeQuery(sql);
		Mailtb mt = null;
		if (rs.next()) {
			mt = new Mailtb();
			mt.setFromaddress(rs.getString("fromaddress"));
			mt.setFrompassword(rs.getString("frompassword"));
			mt.setToaddress(rs.getString("toaddress"));
		}
		rs.close();
		st.close();
		conn.close();
		return mt;
	}

	/**
	 * �����ʼ�����
	 * @param mt �ʼ�����
	 * @throws SQLException
	 */
	public void saveMail(Mailtb mt) throws SQLException {
		Connection conn = DataAccess.getConnection();
		String sql = "insert into mailtb(fromaddress,frompassword,toaddress) values (?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, mt.getFromaddress());
		pst.setString(2, mt.getFrompassword());
		pst.setString(3, mt.getToaddress());
		pst.execute("truncate mailtb");
		pst.execute();
		pst.close();
		conn.close();
	}

}
