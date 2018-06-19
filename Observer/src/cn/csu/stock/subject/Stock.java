package cn.csu.stock.subject;

import java.util.LinkedList;
import java.util.List;
import cn.csu.stock.observer.Observer;

public abstract class Stock {

	protected List<Observer> obs;

	public Stock() {
		obs = new LinkedList<>();
	}

	public void attach(Observer o) {
		obs.add(o);
	}

	public void detach(Observer o) {
		obs.remove(o);
	}

	public abstract void decline(double range, double price);
}
