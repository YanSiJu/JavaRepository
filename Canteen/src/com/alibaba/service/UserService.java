package com.alibaba.service;

import org.springframework.stereotype.Service;
import com.alibaba.entity.User;

@Service
public interface UserService {

	User login(String name, String password);

	void register(String name, String pwd, String mobile);

}
