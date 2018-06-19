package cn.csu.service.impl;

import cn.csu.service.IBehavior;

public class Swim implements IBehavior {

	@Override
	public void bahave(String birdType) {
		if ("Pigeon".equalsIgnoreCase(birdType)) {
			System.out.println("\n" + birdType + " cannot swim.");
		} else if ("Penguin".equalsIgnoreCase(birdType)) {
			System.out.println("\n" + birdType + " is swimming");
		}

	}

}
