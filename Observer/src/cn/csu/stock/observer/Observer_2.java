package cn.csu.stock.observer;

public class Observer_2 extends Observer {

	public Observer_2() {
	
	}

	@Override
	public void response(double range, double price) {
		System.out.println("����2�۲쵽��Ʊ����Ϊ:%" + (range * 100) + ",�¼۸�Ϊ:" + price);

	}

}
