package com.ascent.dao;

import java.sql.Connection;
import java.util.List;
import com.ascent.entity.User;

public class UserManagerDAO extends DataAccess {

	public List<User> queryAllUser() {
		Class<User> clazz = User.class;
		String sql = "select * from user";
		Connection conn = this.getConnection();
		return this.getRecords(clazz, sql, conn);
	}
}
