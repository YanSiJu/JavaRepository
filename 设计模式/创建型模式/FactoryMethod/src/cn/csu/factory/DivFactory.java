package cn.csu.factory;

import cn.csu.product.Div;
import cn.csu.product.Operation;

public class DivFactory implements IFactory {

	@Override
	public Operation getproduct() {

		return new Div();
	}

}
