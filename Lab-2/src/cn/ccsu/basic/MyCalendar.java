package cn.ccsu.basic;

import java.util.GregorianCalendar;

public class MyCalendar {

	private GregorianCalendar calendar;
	private int year;
	private int month;
	private int day;

	{

		calendar = new GregorianCalendar();
	}

	public MyCalendar(){
		
		this.year = calendar.get(GregorianCalendar.YEAR);
		this.day = calendar.get(GregorianCalendar.DATE);
		this.month = calendar.get(GregorianCalendar.MONTH);
		
	}
	
	
	public GregorianCalendar getCalendar() {
		return calendar;
	}


	public void setCalendar(GregorianCalendar calendar) {
		this.calendar = calendar;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public int getMonth() {
		return month;
	}


	public void setMonth(int month) {
		this.month = month;
	}


	public int getDay() {
		return day;
	}


	public void setDay(int day) {
		this.day = day;
	}

}
