package com.alibaba.service.impl;

import java.util.List;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.entity.User;
import com.alibaba.mapper.UserMapper;
import com.alibaba.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User login(String name, String password) {
		List<User> list = userMapper.selectUserByName(name);
		if (list != null && list.size() > 0) {
			User user = list.get(0);
			if (BCrypt.checkpw(password, user.getPassword())) {
				return user;
			}
		}
		return null;
	}

	public void register(String name, String pwd, String mobile) {
		User u = new User(0, name, BCrypt.hashpw(pwd, BCrypt.gensalt()), 0, 0d, mobile, null);
		System.out.println("\n\n\nuser--->" + u);
		userMapper.insertUser(u);
	}

}
