package com.alibaba.mapper;

import org.springframework.stereotype.Repository;

import com.alibaba.entity.Post;

/**
* @author Bill
* @itle: PostMpper.java
* @Package: com.alibaba.mapper
* @Description: TODO
* @date:2018年7月12日 下午2:49:43
* @version:V1.0
*/
@Repository
public interface PostMpper {

	/**     
	* 方法名：insertPost</br>
	* 详述：TODO（简单方法可一句话概述）</br>
	* 开发人员：liuhf </br>
	* 创建时间：2018年7月12日  </br>
	* @param p
	* @throws 
	*/
	void insertPost(Post p);
}
