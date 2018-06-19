package cn.ccsu.bean;

public class Decorator extends AbstractDrink {

	protected AbstractDrink d;

	public void raisePrize() {
		this.setPrize(this.getPrize() + d.getPrize());
	}
}
