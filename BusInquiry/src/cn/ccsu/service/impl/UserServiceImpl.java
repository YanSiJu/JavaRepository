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
 * @date:2019��1��31�� ����12:39:57
 * @version:V1.0
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * ��������login</br> ������TODO���򵥷�����һ�仰������</br> ������Ա��Bill </br> ����ʱ�䣺2019��1��31��
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
	 * ��������register</br> ������TODO���򵥷�����һ�仰������</br> ������Ա��Bill </br> ����ʱ�䣺2019��1��31��
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
