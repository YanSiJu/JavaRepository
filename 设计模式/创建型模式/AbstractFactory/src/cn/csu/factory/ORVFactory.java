package cn.csu.factory;

import cn.csu.product.AbstractBMW;
import cn.csu.product.AbstractBenz;
import cn.csu.product.BMWORV;
import cn.csu.product.BenzORV;

public class ORVFactory extends AbstractCarFactory {

	@Override
	public AbstractBMW BMWFactory() {
		
		return new BMWORV();
	}

	@Override
	public AbstractBenz BenzFactory() {
		return new BenzORV();
	}

}
