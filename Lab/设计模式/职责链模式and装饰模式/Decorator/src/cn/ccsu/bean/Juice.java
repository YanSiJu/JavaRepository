package cn.ccsu.bean;

public class Juice extends Decorator {

	public static final double prize = 3;
	
	public Juice(AbstractDrink d) {
		this.d = d;
		this.setPrize(prize);
		raisePrize();
	}

}
