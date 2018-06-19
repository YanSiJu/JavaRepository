package cn.ccsu.test;

import cn.ccsu.basic.MyCalendar;

public class TestMyCalendar {

	public static void main(String[] args) {

		MyCalendar calendar = new MyCalendar();
		System.out.println("" + calendar.getYear() + "Äê" + (calendar.getMonth()+1)
		+ "ÔÂ"+calendar.getDay()+"ÈÕ");
	}
}
