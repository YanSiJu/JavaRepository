package com.alibaba.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.alibaba.entity.MenuComment;

/**
* @author Bill
* @title: MenuMapper.java
* @Package: com.alibaba.mapper
* @Description: TODO
* @date:2018年7月15日 下午5:25:30
* @version:V1.0
*/
@Repository
public interface MenuMapper {
	
	/**     
	* 方法名：insertComment</br>
	* 详述：TODO（简单方法可一句话概述）</br>
	* 开发人员：Bill </br>
	* 创建时间：2018年7月15日  </br>
	* @param cmmt
	* @throws 
	*/
	void insertComment(MenuComment cmmt);

	
	/**     
	* 方法名：praise</br>
	* 详述：TODO（简单方法可一句话概述）</br>
	* 开发人员：Bill </br>
	* 创建时间：2018年7月15日  </br>
	* @param menuId
	* @throws 
	*/
	void praise(@Param("menuId") int menuId);
}
