package cn.csu.dao;

import java.util.Map;

public interface IUserDao {

	void addUser();

	void deleteUserById(int id);
	
	void updtaeUserById(int id);
	
	void queryUser(String sql,Map<String,Object> map);
	
}
