package cn.csu.test;

import cn.csu.enums.WeekDayEnum;

public class MyThread implements Runnable {

	public MyThread() {
		
	}

	@Override
	public void run() {
		System.out.println("WeekDayEnum.Sun:"+WeekDayEnum.Sun);
	}

}
