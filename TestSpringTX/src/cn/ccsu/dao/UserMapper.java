package cn.ccsu.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

	boolean updateBalance(@Param("userName") String userName, @Param("price") Integer price);

	Integer queryBalance(String userName);
}
