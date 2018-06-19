package cn.csu.factory;

import cn.csu.product.AbstractBMW;
import cn.csu.product.AbstractBenz;
import cn.csu.product.BMWSportsCar;
import cn.csu.product.BenzSportsCar;

public class SportsCarFactory extends AbstractCarFactory {

	@Override
	public AbstractBMW BMWFactory() {
		
		return new BMWSportsCar();
	}

	@Override
	public AbstractBenz BenzFactory() {
		return new BenzSportsCar();
	}

}
