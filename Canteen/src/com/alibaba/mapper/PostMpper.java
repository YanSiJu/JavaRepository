package com.alibaba.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.entity.Post;

/**
 * @author Bill
 * @title: PostMpper.java
 * @Package: com.alibaba.mapper
 * @Description: TODO
 * @date:2018��7��12�� ����2:49:43
 * @version:V1.0
 */
@Repository
public interface PostMpper {

	/**     
	* ��������insertPost</br>
	* ���������û��������ӱ��浽���ݿ� </br>
	* ������Ա��Bill </br>
	* ����ʱ�䣺2018��7��12��  </br>
	* @param p
	* @throws 
	*/
	void insertPost(Post p);

	/**     
	* ��������selectPosts</br>
	* ��������ѯ�����е����� </br>
	* ������Ա��Bill </br>
	* ����ʱ�䣺2018��7��12��  </br>
	* @return
	* @throws 
	*/
	List<Post> selectPosts();
}
