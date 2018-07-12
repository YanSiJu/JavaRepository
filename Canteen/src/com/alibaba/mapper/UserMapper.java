package com.alibaba.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.alibaba.entity.User;

/**
 * @author Bill
 *
 */
@Repository
public interface UserMapper {

	
	/**     
	* 方法名：selectUserByName</br>
	* 详述：TODO（简单方法可一句话概述）</br>
	* 开发人员：liuhf </br>
	* 创建时间：2018年7月12日  </br>
	* @param name
	* @return
	* @throws 
	*/
	List<User> selectUserByName(@Param("name") String name);

	
	/**     
	* 方法名：insertUser</br>
	* 详述：TODO（简单方法可一句话概述）</br>
	* 开发人员：liuhf </br>
	* 创建时间：2018年7月12日  </br>
	* @param u
	* @throws 
	*/
	void insertUser(User u);

}
