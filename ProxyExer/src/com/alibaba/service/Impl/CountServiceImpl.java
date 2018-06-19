package com.alibaba.service.Impl;

import com.alibaba.service.ICountService;

public class CountServiceImpl implements ICountService {

	public CountServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public final void queryCount() {
		System.out.println("查看账户方法...");

	}

	@Override
	public final void updateCount() {
		System.out.println("修改账户方法...");

	}

	@Override
	public final void deposit() {
		System.out.println("存款方法...");
	}

}
