package com.alibaba.service.impl;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.entity.Post;
import com.alibaba.mapper.PostMpper;
import com.alibaba.service.PostService;

/**
 * @author Bill
 * @title: PostServiceImpl.java
 * @Package: com.alibaba.service.impl
 * @Description: TODO
 * @date:2018��7��12�� ����3:33:27
 * @version:V1.0
 */
@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostMpper mapper;

	/**     
	* ��������post</br>
	* ������TODO���򵥷�����һ�仰������</br>
	* ������Ա��Bill </br>
	* ����ʱ�䣺2018��7��12��  </br>
	* @see com.alibaba.service.PostService#post(java.lang.String, java.lang.String, int)
	* @param title
	* @param content
	* @param userId
	* @throws 
	*/
	@Override
	public void post(String title, String content, int userId) {
		LocalDateTime time = LocalDateTime.now();
		Post p = new Post(0, title, content, time, userId, 0);
		mapper.insertPost(p);
	}

	/**     
	* ��������queryAndOrderPosts</br>
	* ������TODO���򵥷�����һ�仰������</br>
	* ������Ա��Bill </br>
	* ����ʱ�䣺2018��7��12��  </br>
	* @see com.alibaba.service.PostService#queryAndOrderPosts()
	* @return
	* @throws 
	*/
	@Override
	public List<Post> queryAndOrderPosts() {
		List<Post> posts = mapper.selectPosts();
		Comparator<Post> c = new Comparator<Post>() {

			@Override
			public int compare(Post o1, Post o2) {
				long time = java.sql.Timestamp.valueOf(o1.getTime()).getTime();
				long t = java.sql.Timestamp.valueOf(o2.getTime()).getTime();
				if (time > t) {
					return 1;
				} else if (time < t) {
					return -1;
				}
				return 0;
			}
		};
		Collections.sort(posts, c);
		return posts;
	}

}
