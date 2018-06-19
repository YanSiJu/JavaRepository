package cn.csu.product;

public class Sub extends Operation {

	@Override
	public double getResult() {
		
		return this.getNumber1() - this.getNumber2();

	}

}
