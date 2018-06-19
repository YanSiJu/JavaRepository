package cn.csu.test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.Test;

public class Main {

	public Main() {

	}

	/**
	 * 将Date转为 String 类型 通常用 format(Date date)
	 */
	@Test
	public void testDateToString() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(date);
		System.out.println(str);
		System.out.println(date);
	}
	
	@Test
	public void datetimeToString() {
		LocalDateTime dateTime = LocalDateTime.now();
		String newstring = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		System.out.println(newstring);
	}

	@Test
	public void test() {
		/*
		 * LocalDateTime ldt = LocalDateTime.now(); System.out.print(ldt);
		 */

		String str = "2012-01-18 12:52";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
		System.out.println("dateTime:" + dateTime);
		System.out.print("dateTime.getMonthValue():" + dateTime.getMonthValue());
	}
}
