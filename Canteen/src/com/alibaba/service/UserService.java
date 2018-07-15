package com.alibaba.service;

import org.springframework.stereotype.Service;
import com.alibaba.entity.User;


/**
* @author Bill
* @title: UserService.java
* @Package: com.alibaba.service
* @Description: TODO
* @date:2018��7��15�� ����5:26:35
* @version:V1.0
*/
@Service
public interface UserService {

	
	/**     
	* ��������login</br>
	* ������TODO���򵥷�����һ�仰������</br>
	* ������Ա��liuhf </br>
	* ����ʱ�䣺2018��7��12��  </br>
	* @param name
	* @param password
	* @return
	* @throws 
	*/
	User login(String name, String password);

	
	/**     
	* ��������register</br>
	* ������TODO���򵥷�����һ�仰������</br>
	* ������Ա��liuhf </br>
	* ����ʱ�䣺2018��7��12��  </br>
	* @param name
	* @param pwd
	* @param mobile
	* @throws 
	*/
	void register(String name, String pwd, String mobile);

}
