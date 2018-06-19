package cn.csu.innerclass;

public class Outer {

	private int i;

	public Outer() {
		this.i = 12;
	}

	public class Inner {

		public void visit() {
			System.out.println(i);
		}
	}
}
