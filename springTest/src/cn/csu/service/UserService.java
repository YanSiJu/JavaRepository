package cn.csu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csu.dao.IUserDao;
import cn.csu.dao.impl.UserDaoImpl;
import cn.csu.entity.Employee;

@Service
public class UserService {

	@Autowired
	public IUserDao userDao;

	public UserService() {
		System.out.println(this.getClass().getName() + "'s constructor");

	}

	/**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}

	public void register(Employee e) {

		userDao.addUser();
	}
}
