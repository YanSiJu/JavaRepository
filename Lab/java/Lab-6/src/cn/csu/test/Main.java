package cn.csu.test;

import cn.csu.service.EnteringInfo;

public class Main {

	
	public static void main(String[] str) {
		
		try {
			EnteringInfo.test();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
