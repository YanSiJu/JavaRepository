package com.alibaba.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.entity.User;
import com.alibaba.mapper.UserMapper;
import com.alibaba.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;

	@Override
	public List<User> getAll() {
		return mapper.selectAllUsers();
	}

}
