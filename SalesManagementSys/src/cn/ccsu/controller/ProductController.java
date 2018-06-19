package cn.ccsu.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import cn.ccsu.entity.Product;
import cn.ccsu.service.IProductService;

/**
 * @author Bill
 *
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IProductService service;

	public ProductController() {

	}

	@RequestMapping(value = "/queryAllProducts")
	public String queryAllProducts(Map<String, Object> map) {

		putProducts(map);
		return "productInfo";
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProduct(Map<String, Object> map, Product prdt) {

		service.addProduct(prdt);
		map.put("message", "信息添加成功");
		System.out.println("添加产品信息");
		return "jump";
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public String addProduct() {
		return "appendProduct";

	}

	@RequestMapping(value = "/modifyProduct", method = RequestMethod.GET)
	public String modifyProduct(Map<String, Object> map, @RequestParam(value = "id", required = false) Integer id) {

		// 根据ID查询出销售员，并存到map中
		List<Product> list = service.queryProduct(null, id);
		if (list != null && list.size() > 0) {
			map.put("product", list.get(0));
		}
		return "modifyProductInfo";

	}

	@RequestMapping(value = "/modifyProduct", method = RequestMethod.POST)
	public String modifyProduct(Map<String, Object> map, Product prdt) {
		service.modifyProduct(prdt);
		map.put("message", "信息修改成功");
		return "jump";
	}

	public void putProducts(Map<String, Object> map) {

		List<Product> products = service.queryAllProducts();
		map.put("products", products);
	}

	@RequestMapping("/queryProduct")
	public String queryProduct(Map<String, Object> map,
			@RequestParam(value = "productName", required = false) String productName,
			@RequestParam(value = "id", required = false) Integer id) {
		if (productName.length() == 0) {
			productName = null;
		}
		List<Product> products = service.queryProduct(productName, id);
		map.put("products", products);
		return "productInfo";
	}

	@RequestMapping("/deleteProduct")
	public String deleteProduct(Map<String, Object> map, @RequestParam(value = "id", required = false) Integer id) {

		service.deleteProduct(id);
		putProducts(map);
		return "productInfo";

	}

}
