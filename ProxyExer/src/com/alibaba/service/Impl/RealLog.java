package com.alibaba.service.Impl;

import com.alibaba.service.AbstractLog;

public class RealLog extends AbstractLog {

	public RealLog() {

	}

	// public void info() {
	// System.out.println("------>������ʵҵ�񷽷�");
	// }

	@Override
	public int method() {
		System.out.println("------>������ʵҵ�񷽷�");
		return 0;
	}

}
