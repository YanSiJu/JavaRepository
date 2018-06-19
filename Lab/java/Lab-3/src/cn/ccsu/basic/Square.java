package cn.ccsu.basic;

public class Square extends Rectangle {

	public Square(double side) {

		super.setLength(side);
		super.setWidth(side);
	}

	public void reSize(double side) {
		super.setLength(side);
		super.setWidth(side);
	}

	public void printWay() {

		System.out.println("边长：" + this.getLength());
		System.out.println("周长：" + this.calculatePerimeter() + "	面积："
				+ this.calculateArea());
		
	}

	/*@Override
	public double calculatePerimeter() {

		return super.calculatePerimeter();
	}

	@Override
	public double calculateArea() {

		return super.calculateArea();
	}*/

}
