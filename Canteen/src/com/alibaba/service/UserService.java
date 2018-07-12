package com.alibaba.service;

import org.springframework.stereotype.Service;
import com.alibaba.entity.User;

/**
 * @author Bill
 *
 */
@Service
public interface UserService {

	
	/**     
	* 方法名：login</br>
	* 详述：TODO（简单方法可一句话概述）</br>
	* 开发人员：liuhf </br>
	* 创建时间：2018年7月12日  </br>
	* @param name
	* @param password
	* @return
	* @throws 
	*/
	User login(String name, String password);

	
	/**     
	* 方法名：register</br>
	* 详述：TODO（简单方法可一句话概述）</br>
	* 开发人员：liuhf </br>
	* 创建时间：2018年7月12日  </br>
	* @param name
	* @param pwd
	* @param mobile
	* @throws 
	*/
	void register(String name, String pwd, String mobile);

}
