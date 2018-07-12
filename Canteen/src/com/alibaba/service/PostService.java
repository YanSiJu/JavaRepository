package com.alibaba.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.entity.Post;

/**
 * @author Bill
 * @title: PostService.java
 * @Package: com.alibaba.service
 * @Description: TODO
 * @date:2018��7��12�� ����3:32:20
 * @version:V1.0
 */
@Service
public interface PostService {

	
	/**     
	* ��������post</br>
	* �����������û�����</br>
	* ������Ա��Bill </br>
	* ����ʱ�䣺2018��7��12��  </br>
	* @param title
	* @param content
	* @param userId
	* @throws 
	*/
	void post(String title, String content, int userId);

	/**     
	* ��������queryAndOrderPosts</br>
	* �������������ݿ���ȡ�������Ӱ���ʱ���Ⱥ�˳������</br>
	* ������Ա��Bill </br>
	* ����ʱ�䣺2018��7��12��  </br>
	* @return
	* @throws 
	*/
	List<Post> queryAndOrderPosts();

}
