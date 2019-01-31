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
* @date:2019��1��31�� ����12:43:50
* @version:V1.0
*/
@Repository
public interface UserMapper {

	
	
	/**     
	* ��������selectUserByName</br>
	* ������TODO���򵥷�����һ�仰������</br>
	* ������Ա��Bill </br>
	* ����ʱ�䣺2019��1��31��  </br>
	* @param name
	* @return
	* @throws 
	*/
	List<User> selectUserByName(@Param("name") String name);

	
	
	/**     
	* ��������insertUser</br>
	* ������TODO���򵥷�����һ�仰������</br>
	* ������Ա��Bill </br>
	* ����ʱ�䣺2019��1��31��  </br>
	* @param u
	* @throws 
	*/
	void insertUser(User u);

}
