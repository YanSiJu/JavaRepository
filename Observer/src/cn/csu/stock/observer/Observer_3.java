package cn.csu.stock.observer;

public class Observer_3 extends Observer {

	public Observer_3() {

	}

	@Override
	public void response(double range, double price) {
		System.out.println("����3�۲쵽��Ʊ����Ϊ:%" + (range * 100) + ",�¼۸�Ϊ:" + price);

	}

}
