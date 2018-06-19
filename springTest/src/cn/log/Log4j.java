package cn.log;


public class Log4j {

	public Log4j(String str) {

	}

	
	public void beforeMethod() {

		System.out.println("beforeMethod");
	}

	public void afterMethod() {

		System.out.println("afterMethod");
	}

}
