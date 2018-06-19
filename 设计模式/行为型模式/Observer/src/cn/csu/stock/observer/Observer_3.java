package cn.csu.stock.observer;

public class Observer_3 extends Observer {

	public Observer_3() {

	}

	@Override
	public void response(double range, double price) {
		System.out.println("股民3观察到股票降幅为:%" + (range * 100) + ",新价格为:" + price);

	}

}
