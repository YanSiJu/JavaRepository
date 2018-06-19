package cn.csu.stock.subject;

import cn.csu.stock.observer.Observer;

public class TencentStock extends Stock {

	public TencentStock() {

	}

	@Override
	public void decline(double range, double price) {

		if (range >= 0.05) {
			for (Observer o : obs) {
				o.response(range, price);
			}
		}
	}

}
