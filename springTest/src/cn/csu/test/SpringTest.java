package cn.csu.test;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.csu.controller.UserController;

public class SpringTest {

	public static void main(String[] args) {


		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserController controller = (UserController) ctx.getBean("userController");
		controller.regist();
		ctx.close();

	}
	
	/*@Test
	public void autowiredTest() {
		// fail("Not yet implemented");

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("");
		UserController controller = (UserController) ctx.getBean("userController");
		controller.regist();
		ctx.close();
	}
*/
}
