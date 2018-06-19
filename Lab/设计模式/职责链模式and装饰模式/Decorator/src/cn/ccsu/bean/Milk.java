package cn.ccsu.bean;

public class Milk extends Decorator {
	
	public static final double prize = 2;
	
	public Milk(AbstractDrink d) {
		this.d = d;
		this.setPrize(prize);
		raisePrize();
	}
	
}
