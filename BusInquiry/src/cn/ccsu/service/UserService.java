package cn.ccsu.service;

import org.springframework.stereotype.Service;
import cn.ccsu.entity.User;

/**
 * @author Bill
 * @title: UserService.java
 * @Package: cn.ccsu.service
 * @Description: TODO
 * @date:2019年1月31日 下午12:38:54
 * @version:V1.0
 */
@Service
public interface UserService {

	/**
	 * 方法名：login</br> 详述：TODO（简单方法可一句话概述）</br> 开发人员：Bill </br> 创建时间：2019年1月31日
	 * </br> @param name @param password @return @throws
	 */
	User login(String name, String password);

	/**
	 * 方法名：register</br> 详述：TODO（简单方法可一句话概述）</br> 开发人员：Bill </br> 创建时间：2019年1月31日
	 * </br> @param name @param pwd @param mobile @throws
	 */
	void register(String name, String pwd, String mobile);

}
