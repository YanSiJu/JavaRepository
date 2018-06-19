package cn.ccsu.Test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ccsu.beans.Person;

public class Main {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Person p = (Person) ctx.getBean("p");

		System.out.println(p);

		ctx.close();

	}
}
