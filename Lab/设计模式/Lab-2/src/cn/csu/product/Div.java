package cn.csu.product;

public class Div extends Operation {

	@Override
	public double getResult() throws Exception {
		
		if (this.getNumber2() == 0) {
			throw new Exception("除数不能为0");
		}
		
		return this.getNumber1() / this.getNumber2();
	}

}
