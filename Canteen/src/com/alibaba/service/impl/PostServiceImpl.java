package com.alibaba.service.impl;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.entity.Post;
import com.alibaba.mapper.PostMpper;
import com.alibaba.service.PostService;

/**
 * @author Bill
 *
 */
@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostMpper mapper;

	@Override
	public void post(String title, String content, int userId) {
		LocalDateTime time = LocalDateTime.now();
		Post p = new Post(0, title, content, time, userId, 0);
		mapper.insertPost(p);
	}

}
