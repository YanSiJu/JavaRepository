package cn.csu.bean;

public class Pigeon extends AbstractBird {

	@Override
	public void display() {

		this.getBehavior().bahave("Pigeon");
	}

}
