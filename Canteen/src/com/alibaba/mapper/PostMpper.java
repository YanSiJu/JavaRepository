package com.alibaba.mapper;

import org.springframework.stereotype.Repository;

import com.alibaba.entity.Post;

/**
* @author Bill
* @itle: PostMpper.java
* @Package: com.alibaba.mapper
* @Description: TODO
* @date:2018��7��12�� ����2:49:43
* @version:V1.0
*/
@Repository
public interface PostMpper {

	/**     
	* ��������insertPost</br>
	* ������TODO���򵥷�����һ�仰������</br>
	* ������Ա��liuhf </br>
	* ����ʱ�䣺2018��7��12��  </br>
	* @param p
	* @throws 
	*/
	void insertPost(Post p);
}
