package cn.ccsu.service.impl;

import org.springframework.stereotype.Component;

import cn.ccsu.service.IPerformance;

@Component("IPerformance")
public class PerformanceImpl implements IPerformance {

	public PerformanceImpl() {
		System.out.println("PerformanceImpl this:" + this + "\n");
	}

	@Override
	public void perform(String name) {
		System.out.println("\n" + name + " is  Performing!!\n  ");

	}

}
