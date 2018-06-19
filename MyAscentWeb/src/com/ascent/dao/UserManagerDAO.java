package com.ascent.dao;

import java.sql.*;
import java.util.*;

import com.ascent.util.DataAccess;
import com.ascent.util.DataAccessJDBC;
import com.ascent.bean.Usr;

/**
 * 对用户进行相关操作的类
 * @author zy
 */
public class UserManagerDAO {

	/**
	 * 根据用户id主键查询用户对象
	 * @param uid 用户主键id
	 * @return 用户对象
	 */
	public Usr getProductUserByid(int uid) {
		Connection con = DataAccess.getConnection();
		String sql = "select * from usr p where p.id=?";
		PreparedStatement pst = null ;
		Usr pu = null;
		ResultSet rs = null ;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, uid);
			rs = pst.executeQuery();
			if (rs.next()) {
				pu = new Usr();
				pu.setId(rs.getInt("id"));
				pu.setUsername(rs.getString("username"));
				pu.setPassword(rs.getString("password"));
				pu.setFullname(rs.getString("fullname"));
				pu.setTitle(rs.getString("title"));
				pu.setCompanyname(rs.getString("companyname"));
				pu.setCompanyaddress(rs.getString("companyaddress"));
				pu.setCity(rs.getString("city"));
				pu.setJob(rs.getString("job"));
				pu.setTel(rs.getString("tel"));
				pu.setEmail(rs.getString("email"));
				pu.setCountry(rs.getString("country"));
				pu.setZip(rs.getString("zip"));
				pu.setSuperuser(rs.getString("superuser"));
				pu.setDelsoft(rs.getString("delsoft"));
				pu.setNote(rs.getString("note"));
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

	/**
	 * 根据用户名查询用户对象
	 * @param username 用户名
	 * @return 用户对象
	 */
	public Usr findUserByusername(String username) {
		Connection con = DataAccess.getConnection();
		String sql = "select * from usr p where p.username=?";
		PreparedStatement pst = null ;
		Usr pu = null;
		ResultSet rs =  null ;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, username);
			rs = pst.executeQuery();
			if (rs.next()) {
				pu = new Usr();
				pu.setId(rs.getInt("id"));
				pu.setUsername(rs.getString("username"));
				pu.setPassword(rs.getString("password"));
				pu.setFullname(rs.getString("fullname"));
				pu.setTitle(rs.getString("title"));
				pu.setCompanyname(rs.getString("companyname"));
				pu.setCompanyaddress(rs.getString("companyaddress"));
				pu.setCity(rs.getString("city"));
				pu.setJob(rs.getString("job"));
				pu.setTel(rs.getString("tel"));
				pu.setEmail(rs.getString("email"));
				pu.setCountry(rs.getString("country"));
				pu.setZip(rs.getString("zip"));
				pu.setSuperuser(rs.getString("superuser"));
				pu.setDelsoft(rs.getString("delsoft"));
				pu.setNote(rs.getString("note"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
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

	/**
	 * 添加用户信息
	 * @param pu 用户对象
	 */
	public void addProductUser(Usr pu) {
		Connection con = DataAccess.getConnection();
		String sql = "insert into usr (username,password,fullname,title,companyname,companyaddress,city,job,tel,email,country,zip,superuser,delsoft,note) values(?,?,?,?,?,?,?,?,?,?,?,?,'1','0',?)";
		PreparedStatement pst = null ;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, pu.getUsername());
			pst.setString(2, pu.getPassword());
			pst.setString(3, pu.getFullname());
			pst.setString(4, pu.getTitle());
			pst.setString(5, pu.getCompanyname());
			pst.setString(6, pu.getCompanyaddress());
			pst.setString(7, pu.getCity());
			pst.setString(8, pu.getJob());
			pst.setString(9, pu.getTel());
			pst.setString(10, pu.getEmail());
			pst.setString(11, pu.getCountry());
			pst.setString(12, pu.getZip());
			pst.setString(13, pu.getNote());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
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
	}

	/**
	 * 更新用户信息
	 * @param pu 用户对象
	 */
	public void updateProductuser(Usr pu) {
		Connection con = DataAccess.getConnection();
		String sql = "update usr set username=?,password=?,fullname=?,title=?,companyname=?,companyaddress=?,city=?,job=?,tel=?,email=?,country=?,zip=?,note=? where id=?";
		PreparedStatement pst = null ;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, pu.getUsername());
			pst.setString(2, pu.getPassword());
			pst.setString(3, pu.getFullname());
			pst.setString(4, pu.getTitle());
			pst.setString(5, pu.getCompanyname());
			pst.setString(6, pu.getCompanyaddress());
			pst.setString(7, pu.getCity());
			pst.setString(8, pu.getJob());
			pst.setString(9, pu.getTel());
			pst.setString(10, pu.getEmail());
			pst.setString(11, pu.getCountry());
			pst.setString(12, pu.getZip());
			pst.setString(13, pu.getNote());
			pst.setInt(14, pu.getId());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
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
	}

	/**
	 * 更新用户权限
	 * @param uid 用户主键id
	 * @param superuser 用户角色
	 */
	public void updateSuperuser(int uid, String superuser) {
		Connection con = DataAccess.getConnection();
		String sql = "update usr set superuser=? where id=?";
		PreparedStatement pst = null ;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, superuser);
			pst.setInt(2, uid);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
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
	}

	/**
	 * 屏蔽用户（软删除用户1为删除）
	 * @param uid 用户主键 id
	 * @param delsoft 软删除标志 1为软删除，0为正常
	 */
	public void delSoftuser(int uid, String delsoft) {
		Connection con = DataAccess.getConnection();
		String sql = "update usr set delsoft=? where id=?";
		PreparedStatement pst = null ;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, delsoft);
			pst.setInt(2, uid);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
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
	}

	/**
	 * 查询所有用户对象
	 * @return 所有用户对象
	 */
	public List<Usr> getAllProductUser() {
		Connection con = DataAccessJDBC.getConnection();
		String sql = "select * from usr p  order by p.id ";
		List<Usr> list = new ArrayList<Usr>();
		Statement stmt = null;
		ResultSet rs = null ;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Usr pu = new Usr();
				pu.setId(rs.getInt("id"));
				pu.setUsername(rs.getString("username"));
				pu.setPassword(rs.getString("password"));
				pu.setFullname(rs.getString("fullname"));
				pu.setTitle(rs.getString("title"));
				pu.setCompanyname(rs.getString("companyname"));
				pu.setCompanyaddress(rs.getString("companyaddress"));
				pu.setCity(rs.getString("city"));
				pu.setJob(rs.getString("job"));
				pu.setTel(rs.getString("tel"));
				pu.setEmail(rs.getString("email"));
				pu.setCountry(rs.getString("country"));
				pu.setZip(rs.getString("zip"));
				pu.setSuperuser(rs.getString("superuser"));
				pu.setDelsoft(rs.getString("delsoft"));
				pu.setNote(rs.getString("note"));
				list.add(pu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs!=null){
					rs.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
}