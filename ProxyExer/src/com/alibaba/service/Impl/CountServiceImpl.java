package com.alibaba.service.Impl;

import com.alibaba.service.ICountService;

public class CountServiceImpl implements ICountService {

	public CountServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public final void queryCount() {
		System.out.println("�鿴�˻�����...");

	}

	@Override
	public final void updateCount() {
		System.out.println("�޸��˻�����...");

	}

	@Override
	public final void deposit() {
		System.out.println("����...");
	}

}
