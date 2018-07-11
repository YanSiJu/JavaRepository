package com.clothing.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
public class DbHandler {
		//更新数据库(增删改)
		public void update(String sql, Object ... args){
			Connection conn = null;
			PreparedStatement ps = null;
			try {
				conn = JDBCTools.getConnection();

				ps = conn.prepareStatement(sql);
				//遍历可变参数数组
				for(int i = 0;i < args.length;i++){
					ps.setObject(i+1, args[i]);
				}
				
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCTools.closeSource(ps, conn);
			}
		}
}
