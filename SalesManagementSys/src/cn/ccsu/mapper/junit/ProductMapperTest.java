package cn.ccsu.mapper.junit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.ccsu.entity.Product;
import cn.ccsu.mapper.ProductMapper;

/**
 * @author Bill
 *
 */
public class ProductMapperTest {

	public ProductMapperTest() {

	}

	private static ClassPathXmlApplicationContext ctxt;
	private static ProductMapper mapper;

	static {
		ctxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		mapper = (ProductMapper) ctxt.getBean("productMapper");
	}

	@Test
	public void addProductTest() {
		System.out.println(mapper);
		Product prdt = new Product("《我们仨》", 4, 35);
		mapper.addProduct(prdt);
		close();
	}

	@Test
	public void updateProductTest() {
		Product prdt = new Product("Thinking in java", 4, 89);
		mapper.updateProduct(prdt);
		close();
	}


	@Test
	public void selectProductTest() {
		Integer id = null;
		String productName = "a";
		Map<String, Object> map = new HashMap<>(2);

		map.put("id", id);
		map.put("productName", productName);
		List<Product> list = mapper.selectProduct(map);

		for (Product prdt : list) {
			System.out.println(prdt);
		}

		close();
	}

	public void close() {
		ctxt.close();
	}

}
