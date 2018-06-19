package cn.csu.factory;

import cn.csu.product.Operation;
import cn.csu.product.Sub;

public class SubFactory implements IFactory {

	@Override
	public Operation getproduct() {
//		System.out.println("Sub");
		return new Sub();
	}

}
