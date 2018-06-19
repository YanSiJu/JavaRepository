package cn.ccsu.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.ccsu.entity.Salesman;

/**
 * @author Bill
 *
 */
@Repository("salesmanMapper")
public interface SalesmanMapper {

	// 增加销售员
	void addSalesman(Salesman salman);

	// 查询销售员信息
	List<Salesman> selectSalesman(Map<String, Object> params);

	// 查询所有销售员信息
	List<Salesman> selectAllSalesman();

	// 更新销售员信息
	void updateSalesman(Salesman salman);

	// 删除销售员信息
	void deleteSalesman(Integer id);

}
