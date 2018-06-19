package com.ascent.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ascent.util.DataAccess;
import com.ascent.util.DataAccessJDBC;
import com.ascent.bean.Usr;



/**
 * 完成登录操作的类
 * @author zy
 */
public class LoginDAO {

	/**
	 * 验证用户登录
	 * @param user 用户名
	 * @param password 密码
	 * @return 当前用户对象
	 */
	public Usr logIn(String user, String password) {
		Connection con = DataAccessJDBC.getConnection();
		String sql = "select * from usr where username=? and password =?";//

//		String sql1 = "select * from usr where username= " + user + " and pasword = " + password;
//		若user 值 = mary 则成为 " select * from usr where username=mary
//		Statement stm = con.createStatement();
//		ResultSet rs1 = stm.executeQuery(sql1)
		
		PreparedStatement pst = null;
		ResultSet rs = null ;
		Usr pu = null ;
		
//		List<Usr> users = new ArrayList<Usr>();
		
		try {
			pst = con.prepareStatement(sql);//创建预编译语句对象
			pst.setString(1, user);						//参数赋值，1为第一个占位符
			pst.setString(2, password);
			rs = pst.executeQuery();// 执行语句
//			while(rs.next()) {
				if (rs.next()) {				//处理结果
				pu = new Usr();
				pu.setId(rs.getInt("id"));
				pu.setSuperuser(rs.getString("superuser"));
				pu.setUsername(rs.getString("username"));
				pu.setEmail(rs.getString("email"));
				pu.setTel(rs.getString("tel"));
				pu.setCompanyname(rs.getString("companyname"));
				pu.setCompanyaddress(rs.getString("companyaddress"));
				pu.setDelsoft(rs.getString("delsoft"));
				
//				users.add(pu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs!=null){
					rs.close();
				}
				if(pst!=null){
					pst.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return pu;
	}
}
