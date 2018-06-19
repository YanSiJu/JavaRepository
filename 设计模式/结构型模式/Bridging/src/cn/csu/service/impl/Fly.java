package cn.csu.service.impl;

import cn.csu.service.IBehavior;

public class Fly implements IBehavior {

	@Override
	public void bahave(String birdType) {
		if ("Pigeon".equalsIgnoreCase(birdType)) {
			System.out.println("\n" + birdType + " is flying  quikly");
		} else if ("Penguin".equalsIgnoreCase(birdType)) {
			System.out.println("\n" + birdType + " is flying  slowly  and laigh");
		}

	}

}
