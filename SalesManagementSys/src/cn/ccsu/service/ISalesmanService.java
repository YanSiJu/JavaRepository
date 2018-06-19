package cn.ccsu.service;

import java.util.List;
import cn.ccsu.entity.Salesman;

/**
 * @author Bill
 *
 */
public interface ISalesmanService {

	// 增加销售员
	int addSalesman(Salesman salman);

	// 查询销售员信息
	List<Salesman> querySalesman(String name, Integer id, String sex);

	// 查询所有销售员信息
	List<Salesman> queryAllSalesman();

	// 更新销售员信息
	int modifySalesman(Salesman salman);

	// 删除销售员信息
	void deleteSalesman(Integer id);
}
