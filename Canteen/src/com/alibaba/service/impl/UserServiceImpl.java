package com.alibaba.service.impl;

import java.util.List;
import org.mindrot.jbcrypt.Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.entity.User;
import com.alibaba.mapper.UserMapper;
import com.alibaba.service.UserService;

/**
 * @author Bill
 * @title: UserServiceImpl.java
 * @Package: com.alibaba.service.impl
 * @Description: TODO
 * @date:2018年7月12日 下午3:33:38
 * @version:V1.0
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	
	/**     
	* 方法名：login</br>
	* 详述：TODO（简单方法可一句话概述）</br>
	* 开发人员：Bill </br>
	* 创建时间：2018年7月12日  </br>
	* @see com.alibaba.service.UserService#login(java.lang.String, java.lang.String)
	* @param name
	* @param password
	* @return
	* @throws 
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
	* 方法名：register</br>
	* 详述：TODO（简单方法可一句话概述）</br>
	* 开发人员：Bill </br>
	* 创建时间：2018年7月12日  </br>
	* @see com.alibaba.service.UserService#register(java.lang.String, java.lang.String, java.lang.String)
	* @param name
	* @param pwd
	* @param mobile
	* @throws 
	*/
	@Override
	public void register(String name, String pwd, String mobile) {
		User u = new User(0, name, Crypt.hashpw(pwd, Crypt.gensalt()), 0, 0d, mobile, null, null);
		System.out.println("\n\n\nuser--->" + u);
		userMapper.insertUser(u);
	}

}
