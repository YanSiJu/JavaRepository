package cn.ccsu.service.impl;

import java.util.List;
import org.mindrot.jbcrypt.Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ccsu.entity.User;
import cn.ccsu.mapper.UserMapper;
import cn.ccsu.service.UserService;

/**
 * @author Bill
 * @title: UserServiceImpl.java
 * @Package: cn.ccsu.service.impl
 * @Description: TODO
 * @date:2019年1月31日 下午12:39:57
 * @version:V1.0
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 方法名：login</br> 详述：TODO（简单方法可一句话概述）</br> 开发人员：Bill </br> 创建时间：2019年1月31日
	 * </br> @see cn.ccsu.service.UserService#login(java.lang.String,
	 * java.lang.String) @param name @param password @return @throws
	 */
	@Override
	public User login(String name, String password) {
		List<User> list = userMapper.selectUserByName(name);
		if (list != null && list.size() > 0) {
			User user = list.get(0);
			if (Crypt.checkpw(password, user.getPassword())) {
				return user;
			}
		}
		return null;
	}

	/**
	 * 方法名：register</br> 详述：TODO（简单方法可一句话概述）</br> 开发人员：Bill </br> 创建时间：2019年1月31日
	 * </br> @see cn.ccsu.service.UserService#register(java.lang.String,
	 * java.lang.String, java.lang.String) @param name @param pwd @param
	 * mobile @throws
	 */
	@Override
	public void register(String name, String pwd, String mobile) {
		User u = new User();
		System.out.println("\n\n\nuser--->" + u);
		userMapper.insertUser(u);
	}

}
