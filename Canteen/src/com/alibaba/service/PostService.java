package com.alibaba.service;

import org.springframework.stereotype.Service;

/**
 * @author Bill
 *
 */
@Service
public interface PostService {

	
	/**     
	* ��������post</br>
	* ������TODO���򵥷�����һ�仰������</br>
	* ������Ա��liuhf </br>
	* ����ʱ�䣺2018��7��12��  </br>
	* @param title
	* @param content
	* @param userId
	* @throws 
	*/
	void post(String title, String content, int userId);

}
