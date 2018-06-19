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
		System.out.println("\n��ѯ��Ŀ��   " + id + ":" + stockMapper.queryStock(id));
		System.out.println("������Ŀ��:" + stockMapper.updateStock(id));

		/*
		 * String userName = "Linus"; Integer price = 210;
		 * 
		 * 
		 * Integer price = bookMapper.queryPrice(id); System.out.println("\n��ѯ��ĵ���:" +
		 * price);
		 * 
		 * 
		 * System.out.println("\n��ѯ�û����:" + userMapper.queryBalance(userName));
		 * System.out.println("\n�����û����:" + userMapper.updateBalance(userName, price));
		 */

		ctxt.close();
	}

}
