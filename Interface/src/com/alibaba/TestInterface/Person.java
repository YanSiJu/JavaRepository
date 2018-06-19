package com.alibaba.TestInterface;

public interface Person extends ISwim, IStudy {
	
	
	public default void walk() {
		
		System.out.println("\n  $$  Person  walk!!\n");
	}

}
