package cn.ccsu.functioninterface;


public class Main {

	public static void main(String[] args) {

		
		IHandler h = (x)->(x*x*x);
		System.out.println(h.getValue(100));
		
		System.out.println(new Double[0].getClass().getSuperclass());

		
	}
}
