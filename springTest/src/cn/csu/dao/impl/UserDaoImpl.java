package cn.csu.dao.impl;

import java.util.Map;
import org.springframework.stereotype.Repository;
import cn.csu.dao.IUserDao;


@Repository
public class UserDaoImpl implements IUserDao {

	public UserDaoImpl() {
		System.out.println(this.getClass().getName() + "'s constructor");
	}

	@Override
	public void addUser() {
		System.out.println("addUser ");

	}

	@Override
	public void deleteUserById(int id) {
		System.out.println("deleteUser ");

	}

	@Override
	public void updtaeUserById(int id) {
		System.out.println("updateUser ");

	}

	@Override
	public void queryUser(String sql, Map<String, Object> map) {
		System.out.println("queryUser ");

	}

}
