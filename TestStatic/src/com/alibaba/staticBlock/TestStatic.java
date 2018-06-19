package com.alibaba.staticBlock;

import java.sql.Date;


public class TestStatic {

	@SuppressWarnings("unused")
	private Date date;
	@SuppressWarnings("unused")
	private String name;
	@SuppressWarnings("unused")
	private static int id;

	public void show() {

	}

	public static void display() {

	}

	
	static{
//		show();
//		name = "";
		id = 100;
		display();
		
	}
	
	
	{
		show();
		name = "";
		id = 100;
		display();
		
	}
}
