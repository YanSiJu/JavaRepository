package cn.ccsu.simpleFactory;

public class Div extends Operation {

	@Override
	public double getResult() throws Exception {
		// TODO Auto-generated method stub
		if (this.getNumber2() == 0) {
			throw new Exception("��������Ϊ0");
		}
		
		return this.getNumber1() / this.getNumber2();
	}

}
