package com.alibaba.mapper;

import org.springframework.stereotype.Repository;

import com.alibaba.entity.Post;

@Repository
public interface PostMpper {

	void insertPost(Post p);
}
