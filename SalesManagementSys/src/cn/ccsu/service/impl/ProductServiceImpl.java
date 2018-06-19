package cn.ccsu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ccsu.entity.Product;
import cn.ccsu.mapper.ProductMapper;
import cn.ccsu.service.IProductService;

/**
 * @author Bill
 *
 */
@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductMapper mapper;

	public ProductServiceImpl() {

	}

	@Override
	public int addProduct(Product product) {

		if (product != null) {
			mapper.addProduct(product);
			return 1;
		} else {
			return -1;
		}

	}

	@Override
	public List<Product> queryProduct(String productName, Integer id) {

		Map<String, Object> map = new HashMap<>(2);
		map.put("productName", productName);
		map.put("id", id);
		return mapper.selectProduct(map);
	}

	@Override
	public int modifyProduct(Product product) {
		if (product != null) {
			mapper.updateProduct(product);
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	public void deleteProduct(Integer id) {

//		System.out.println("product id:" + id);
		mapper.deleteProduct(id);
	}

	@Override
	public List<Product> queryAllProducts() {
		return mapper.selectAllProducts();
	}

}
