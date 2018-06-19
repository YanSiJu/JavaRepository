package cn.csu.factory;

import cn.csu.product.AbstractBMW;
import cn.csu.product.AbstractBenz;

public abstract class AbstractCarFactory {

	
	public abstract AbstractBenz BenzFactory();
	
	public abstract AbstractBMW BMWFactory();
	
}
