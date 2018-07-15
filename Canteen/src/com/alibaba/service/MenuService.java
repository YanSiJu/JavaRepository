package com.alibaba.service;

import org.springframework.stereotype.Service;

/**
 * @author Bill
 * @title: MenuService.java
 * @Package: com.alibaba.service
 * @Description: TODO
 * @date:2018年7月15日 下午5:25:09
 * @version:V1.0
 */
@Service
public interface MenuService {

	/**
	 * 方法名：praise</br> 
	 * 详述：</br> 
	 * 开发人员：Bill </br> 
	 * 创建时间：2018年7月15日 </br> 
	 * @param postId 
	 * @param userId 
	 * @return 
	 * @throws
	 */
	boolean praise(int menuId, int userId);

	/**     
	* 方法名：commentMenu</br>
	* 详述：TODO（简单方法可一句话概述）</br>
	* 开发人员：Bill </br>
	* 创建时间：2018年7月15日  </br>
	* @param content
	* @param userId
	* @param postId
	* @throws 
	*/
	void commentMenu(String content, int userId, int menuId);

}
