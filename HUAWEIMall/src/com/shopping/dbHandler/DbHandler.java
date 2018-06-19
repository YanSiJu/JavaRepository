package com.shopping.dbHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DbHandler {
	public List<String> getUserName(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<String> list = new ArrayList<String>();
		String sql = "select * from user";
		try {
			 conn = JDBCTools.getConnection();
			 ps = conn.prepareStatement(sql);
			 rs = ps.executeQuery();
			 
			 while(rs.next()){
				 String userName = rs.getString(3);
				 list.add(userName);
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCTools.closeSource(rs, ps, conn);
		}
		return list;
	}
}
