package cn.csu.stock.observer;

public class Observer_1 extends Observer {

	public Observer_1() {

	}

	@Override
	public void response(double range, double price) {

		System.out.println("����1 �۲쵽��Ʊ����Ϊ:%" + (range * 100) + ",�¼۸�Ϊ:" + price);
	}

}
