package cn.csu.factory;

import cn.csu.product.Multi;
import cn.csu.product.Operation;

public class MultiFactory implements IFactory {

	@Override
	public Operation getproduct() {

		return new Multi();
	}

}
