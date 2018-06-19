package cn.ccsu.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.ccsu.service.BookShopService;

public class SpringTXTest {

	public SpringTXTest() {

	}

	@Test
	public void test() throws Exception {

		ClassPathXmlApplicationContext ctxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		BookShopService service = (BookShopService) ctxt.getBean("bookShopServiceImpl");
		String userName = "Linus";
		service.purchase(userName, 12);
		/*
		 * ICashier cashier = (ICashier) ctxt.getBean("iCashierImpl");
		 * 
		 * String userName = "Linus"; cashier.checkout(userName, Arrays.asList(12, 13));
		 */
		ctxt.close();

	}
}
