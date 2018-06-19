package cn.csu.bean;

public class Penguin extends AbstractBird {

	@Override
	public void display() {
		this.getBehavior().bahave("Penguin");	}

}
