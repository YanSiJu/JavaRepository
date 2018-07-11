package com.alibaba.mapper;

import org.springframework.stereotype.Repository;

import com.alibaba.entity.User;

@Repository
public interface UserMapper {

	User selectUserByName(String userName);

	void insertUser(User user);

}
