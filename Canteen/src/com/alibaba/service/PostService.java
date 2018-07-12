package com.alibaba.service;

import org.springframework.stereotype.Service;

@Service
public interface PostService {

	void post(String title, String content, int userId);

}
