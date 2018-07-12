package com.alibaba.service;

import org.springframework.stereotype.Service;

/**
 * @author Bill
 *
 */
@Service
public interface PostService {

	
	/**     
	* 方法名：post</br>
	* 详述：TODO（简单方法可一句话概述）</br>
	* 开发人员：liuhf </br>
	* 创建时间：2018年7月12日  </br>
	* @param title
	* @param content
	* @param userId
	* @throws 
	*/
	void post(String title, String content, int userId);

}
