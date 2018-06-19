package cn.ccsu.mybatis.dao;

import org.apache.ibatis.annotations.Param;

import cn.ccsu.bean.User;

public interface UserMapper {

	boolean updateUserById(User user);

	boolean addUser(User user);

	boolean deleteUser(User user);

	User selectUser(@Param("userName") String userName, @Param("mobile") String mobile);

	User getUserById(Integer id);
}
