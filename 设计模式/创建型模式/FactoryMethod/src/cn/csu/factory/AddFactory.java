package cn.csu.factory;

import cn.csu.product.Add;
import cn.csu.product.Operation;

public class AddFactory implements IFactory {

	@Override
	public Operation getproduct() {
//		System.out.println("add");
		return new Add();
	}

}
