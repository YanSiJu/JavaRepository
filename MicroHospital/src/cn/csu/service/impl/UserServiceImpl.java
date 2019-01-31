package cn.csu.service.impl;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.csu.entity.User;
import cn.csu.mapper.UserMapper;
import cn.csu.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;

	public User login(String userName, String pwd) {

		User user = mapper.selectUserByName(userName);
		System.out.println("----->login:" + user);
		// 比对用户输入的明文与数据库中的密文
		if (user != null && BCrypt.checkpw(pwd, user.getPassword())) {
			return user;
		}
		return null;
	}

	public boolean ifUserNameDuplicate(String userName) {
		if (mapper.selectUserByName(userName) != null) {
			return true;// 用户名已被注册
		}
		return false;// 用户名未被注册
	}

	public void register(User user) {
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		mapper.insertUser(user);

	}
}
