package com.alibaba.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.alibaba.entity.Menu;
import com.alibaba.entity.MenuComment;

/**
 * @author Bill
 * @title: MenuMapper.java
 * @Package: com.alibaba.mapper
 * @Description: TODO
 * @date:2018��7��15�� ����5:25:30
 * @version:V1.0
 */
@Repository
public interface MenuMapper {

	/**
	 * ��������insertComment</br>
	 * ������TODO���򵥷�����һ�仰������</br>
	 * ������Ա��Bill </br>
	 * ����ʱ�䣺2018��7��15�� </br>
	 * @param cmmt @throws
	 */
	void insertComment(MenuComment cmmt);

	/**
	 * ��������praise</br>
	 * ������TODO���򵥷�����һ�仰������</br>
	 * ������Ա��Bill </br>
	 * ����ʱ�䣺2018��7��15�� </br>
	 * @param menuId @throws
	 */
	void praise(@Param("menuId") int menuId);

	/**     
	* ��������selectMenu</br>
	* ������TODO���򵥷�����һ�仰������</br>
	* ������Ա��Bill </br>
	* ����ʱ�䣺2018��7��16��  </br>
	* @return
	* @throws 
	*/
	List<Menu> selectMenu();
}
