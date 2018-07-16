package com.alibaba.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.entity.Menu;

/**
 * @author Bill
 * @title: MenuService.java
 * @Package: com.alibaba.service
 * @Description: TODO
 * @date:2018��7��15�� ����5:25:09
 * @version:V1.0
 */
@Service
public interface MenuService {

	/**
	 * ��������praise</br> 
	 * ������</br> 
	 * ������Ա��Bill </br> 
	 * ����ʱ�䣺2018��7��15�� </br> 
	 * @param  postId 
	 * @param userId 
	 * @return 
	 * @throws
	 */
	boolean praise(int menuId, int userId);

	/**
	 * ��������commentMenu</br> 
	 * ������TODO���򵥷�����һ�仰������</br> 
	 * ������Ա��Bill </br> 
	 * ����ʱ�䣺2018��7��15�� </br> 
	 * @param content 
	 * @param userId 
	 * @param postId 
	 * @throws
	 */
	void commentMenu(String content, int userId, int menuId);

	/**     
	* ��������queryMenu</br>
	* ������TODO���򵥷�����һ�仰������</br>
	* ������Ա��Bill </br>
	* ����ʱ�䣺2018��7��16��  </br>
	* @return
	* @throws 
	*/
	List<Menu> queryMenu();

}
