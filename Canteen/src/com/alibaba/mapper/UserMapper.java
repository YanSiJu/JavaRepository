package com.alibaba.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.alibaba.entity.User;

@Repository
public interface UserMapper {

	List<User> selectUserByName(@Param("name") String name);

	void insertUser(User u);

}
