package cn.ccsu.aop.bean;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {

	//
	@Pointcut("execution(** cn.ccsu.service.impl.PerformanceImpl.perform(String))" + "&& args(name)")
	public void perform(String name) {
	}

	public Audience() {
		System.out.println("constructor" + this.getClass().getName() + "\n");
	}

	@Before("perform(name)")
	public void silenceCellphone(String name) {
		System.out.println("silencing Cell phones.  name:" + name);
	}

	@Before("perform(name)")
	public void takeSeats(String name) {
		System.out.println("Taking Seats. name:" + name);
	}

	@After("perform(name)")
	public void applause(String name) {
		System.out.println("\nclap clap clap!!  name:"+name);
	}

	@AfterThrowing("perform(name)")
	public void refund(String name) {
		System.out.println("Demanding a refund!!  name:"+name);
	}

}
