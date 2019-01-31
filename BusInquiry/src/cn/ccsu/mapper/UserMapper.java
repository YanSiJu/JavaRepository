package cn.ccsu.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import cn.ccsu.entity.User;


/**
* @author Bill
* @title: UserMapper.java
* @Package: cn.ccsu.mapper
* @Description: TODO
* @date:2019年1月31日 下午12:43:50
* @version:V1.0
*/
@Repository
public interface UserMapper {

	
	
	/**     
	* 方法名：selectUserByName</br>
	* 详述：TODO（简单方法可一句话概述）</br>
	* 开发人员：Bill </br>
	* 创建时间：2019年1月31日  </br>
	* @param name
	* @return
	* @throws 
	*/
	List<User> selectUserByName(@Param("name") String name);

	
	
	/**     
	* 方法名：insertUser</br>
	* 详述：TODO（简单方法可一句话概述）</br>
	* 开发人员：Bill </br>
	* 创建时间：2019年1月31日  </br>
	* @param u
	* @throws 
	*/
	void insertUser(User u);

}
