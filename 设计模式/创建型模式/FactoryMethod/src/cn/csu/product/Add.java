package cn.csu.product;

public class Add extends Operation {

	@Override
	public double getResult() {
		
		return this.getNumber1() + this.getNumber2();
		
	}

}
