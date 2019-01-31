package cn.csu.mapper;

import org.springframework.stereotype.Repository;

import cn.csu.entity.User;

@Repository
public interface UserMapper {

	User selectUserByName(String userName);
 
	void insertUser(User user);

}
