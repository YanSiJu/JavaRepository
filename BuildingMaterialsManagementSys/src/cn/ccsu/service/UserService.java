<<<<<<< HEAD
package cn.ccsu.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import cn.ccsu.dao.UserMapper;
import cn.ccsu.entity.User;

@Service
public class UserService {

	private UserMapper mapper;

	public void authorize(User user) {
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		mapper.addUser(user);
	}

	public User login(String name, String pwd) {
		User user = mapper.queryUserByName(name);
		if (BCrypt.checkpw(pwd, user.getPassword())) {
			return user;
		} else {
			return null;
		}

	}

}
=======
package cn.ccsu.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import cn.ccsu.dao.UserMapper;
import cn.ccsu.entity.User;

@Service
public class UserService {

	private UserMapper mapper;

	public void authorize(User user) {
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		mapper.addUser(user);
	}

	public User login(String name, String pwd) {
		User user = mapper.queryUserByName(name);
		if (BCrypt.checkpw(pwd, user.getPassword())) {
			return user;
		} else {
			return null;
		}

	}

}
>>>>>>> 4c95842e54af405a20c2d0efa74e5f0893824e2a
