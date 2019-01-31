package cn.csu.service;

import org.springframework.stereotype.Service;

import cn.csu.entity.User;

@Service
public interface UserService {

	public User login(String userName, String pwd);

	public void register(User user);
}
