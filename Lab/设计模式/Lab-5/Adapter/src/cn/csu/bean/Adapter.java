package cn.csu.bean;

public class Adapter extends AbstractGraph {

	private Angle angle;

	public Adapter(Angle angle) {
		this.angle = angle;
	}

	@Override
	public void draw() {
		angle.drawAngle();
	}

}
