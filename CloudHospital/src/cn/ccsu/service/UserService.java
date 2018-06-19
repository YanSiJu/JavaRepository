package cn.ccsu.service;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.ccsu.bean.User;
import cn.ccsu.dao.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public Integer validateUser(String name, String password) {

		Map<Integer, User> map = userMapper.selectUserByNameAndPassword(name, password);
		Set<Entry<Integer, User>> set = map.entrySet();
		for (Entry<Integer, User> entry : set) {

			User user = entry.getValue();
			if (user != null && user.getName() == name && user.getPassword() == password) {
				return entry.getKey();
			}
		}

		return null;
	}

	public boolean addUser(User user) {

		return userMapper.addUser(user);
	}

	public UserService() {

	}

}
