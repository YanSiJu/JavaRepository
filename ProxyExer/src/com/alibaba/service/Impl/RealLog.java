package com.alibaba.service.Impl;

import com.alibaba.service.AbstractLog;

public class RealLog extends AbstractLog {

	public RealLog() {

	}

	// public void info() {
	// System.out.println("------>调用真实业务方法");
	// }

	@Override
	public int method() {
		System.out.println("------>调用真实业务方法");
		return 0;
	}

}
