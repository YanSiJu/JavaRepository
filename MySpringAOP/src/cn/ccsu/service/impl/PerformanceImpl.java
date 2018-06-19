package cn.ccsu.service.impl;

import org.springframework.stereotype.Service;
import cn.ccsu.service.IPerformance;

@Service
public class PerformanceImpl implements IPerformance {

	public PerformanceImpl() {

	}

	@Override
	public void perform(String name) {
		System.out.println("\n" + name + " is  Performing!!\n  ");

	}

}
