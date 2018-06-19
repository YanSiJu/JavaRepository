package cn.ccsu.Test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.ccsu.annotation.Controller.UserController;
/*import cn.ccsu.annotation.Repository.UserRepository;
import cn.ccsu.annotation.services.UserServiceImpl;*/

public class TestAnnotation {

	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean-annotation.xml");
		
//		UserServiceImpl s = (UserServiceImpl) ctx.getBean("userServiceImpl");
		UserController c = (UserController)ctx.getBean("userController");
		c.controll();
//		UserRepository r = (UserRepository)ctx.getBean("userRepository");
		
		
//		System.out.println("s:"+s+"\n c:"+c+"\n r:"+r);
		
		
		ctx.close();
		
	}
}
