package cn.ccsu.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import cn.ccsu.entity.User;

@Repository
public interface UserMapper {

	public void addUser(User user);

	public User queryUserByName(@Param("name")  String name);

}
