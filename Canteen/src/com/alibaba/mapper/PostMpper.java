package com.alibaba.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.entity.Post;

/**
 * @author Bill
 * @title: PostMpper.java
 * @Package: com.alibaba.mapper
 * @Description: TODO
 * @date:2018年7月12日 下午2:49:43
 * @version:V1.0
 */
@Repository
public interface PostMpper {

	/**     
	* 方法名：insertPost</br>
	* 详述：将用户发的帖子保存到数据库 </br>
	* 开发人员：Bill </br>
	* 创建时间：2018年7月12日  </br>
	* @param p
	* @throws 
	*/
	void insertPost(Post p);

	/**     
	* 方法名：selectPosts</br>
	* 详述：查询出所有的帖子 </br>
	* 开发人员：Bill </br>
	* 创建时间：2018年7月12日  </br>
	* @return
	* @throws 
	*/
	List<Post> selectPosts();
}
