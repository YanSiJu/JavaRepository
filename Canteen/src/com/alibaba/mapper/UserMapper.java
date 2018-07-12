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
	* ��������selectUserByName</br>
	* ������TODO���򵥷�����һ�仰������</br>
	* ������Ա��liuhf </br>
	* ����ʱ�䣺2018��7��12��  </br>
	* @param name
	* @return
	* @throws 
	*/
	List<User> selectUserByName(@Param("name") String name);

	
	/**     
	* ��������insertUser</br>
	* ������TODO���򵥷�����һ�仰������</br>
	* ������Ա��liuhf </br>
	* ����ʱ�䣺2018��7��12��  </br>
	* @param u
	* @throws 
	*/
	void insertUser(User u);

}
