package cn.ccsu.Test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.ccsu.beans.Student;

public class Main {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Student s = (Student) ctx.getBean("Student-1");
		Student student = (Student) ctx.getBean("Student-1");
		
		System.out.println(s == student);

		ctx.close();

	}

}
