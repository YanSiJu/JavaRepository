package cn.ccsu.mapper;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import cn.ccsu.entity.Product;

/**
 * @author Bill
 *
 */
@Repository("productMapper")
public interface ProductMapper {
	// 增加产品
	void addProduct(Product product);

	// 查询产品信息
	List<Product> selectProduct(Map<String, Object> params);

	// 查询所有产品信息
	List<Product> selectAllProducts();

	// 更新产品信息
	void updateProduct(Product product);

	// 删除销售员信息
	void deleteProduct(Integer id);
}
