package cn.ccsu.service;

import org.springframework.stereotype.Service;
import cn.ccsu.entity.User;

/**
 * @author Bill
 * @title: UserService.java
 * @Package: cn.ccsu.service
 * @Description: TODO
 * @date:2019��1��31�� ����12:38:54
 * @version:V1.0
 */
@Service
public interface UserService {

	/**
	 * ��������login</br> ������TODO���򵥷�����һ�仰������</br> ������Ա��Bill </br> ����ʱ�䣺2019��1��31��
	 * </br> @param name @param password @return @throws
	 */
	User login(String name, String password);

	/**
	 * ��������register</br> ������TODO���򵥷�����һ�仰������</br> ������Ա��Bill </br> ����ʱ�䣺2019��1��31��
	 * </br> @param name @param pwd @param mobile @throws
	 */
	void register(String name, String pwd, String mobile);

}
