package com.alibaba.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.alibaba.entity.User;

@Repository
public interface UserMapper {

	List<User> selectAllUsers();

}
