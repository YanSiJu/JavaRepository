package cn.ccsu.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.ccsu.dao.StockMapper;

public class DaoTest {

	/*
	 * @SuppressWarnings("unused")
	 * 
	 * @Autowired private UserMapper userMapper;
	 * 
	 * @SuppressWarnings("unused")
	 * 
	 * @Autowired private StockMapper stockMapper;
	 */

	public DaoTest() {

	}

	@Test
	public void test() {
		ClassPathXmlApplicationContext ctxt = new ClassPathXmlApplicationContext("applicationContext.xml");

		/*
		 * UserMapper userMapper = (UserMapper) ctxt.getBean("userMapper"); BookMapper
		 * bookMapper = (BookMapper) ctxt.getBean("bookMapper");
		 */
		StockMapper stockMapper = (StockMapper) ctxt.getBean("stockMapper");

		int id = 12;
		System.out.println("\n查询书的库存   " + id + ":" + stockMapper.queryStock(id));
		System.out.println("更新书的库存:" + stockMapper.updateStock(id));

		/*
		 * String userName = "Linus"; Integer price = 210;
		 * 
		 * 
		 * Integer price = bookMapper.queryPrice(id); System.out.println("\n查询书的单价:" +
		 * price);
		 * 
		 * 
		 * System.out.println("\n查询用户余额:" + userMapper.queryBalance(userName));
		 * System.out.println("\n更新用户余额:" + userMapper.updateBalance(userName, price));
		 */

		ctxt.close();
	}

}
