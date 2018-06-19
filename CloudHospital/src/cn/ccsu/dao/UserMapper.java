package cn.ccsu.dao;

import java.util.Map;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import cn.ccsu.bean.User;

@Repository("userMapper")
public interface UserMapper {

	@MapKey("id")
	Map<Integer, User> selectUserByNameAndPassword(@Param("name") String name, @Param("password") String password);

	
	boolean addUser(User user);
}
