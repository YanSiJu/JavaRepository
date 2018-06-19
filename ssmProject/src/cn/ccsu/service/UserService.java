package cn.ccsu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ccsu.bean.User;
import cn.ccsu.dao.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public UserService() {

		System.out.println("UserService controller:" + this);
	}

	public User validateUser() {
		System.out.println("UserService  validateUser");
		// User getUserById(Integer id)
		return userMapper.getUserById(981);
	}

}
