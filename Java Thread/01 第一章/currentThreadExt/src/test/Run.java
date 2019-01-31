package test;

import mythread.CountOperate;

public class Run {

	public static void main(String[] args) {
		CountOperate c = new CountOperate();
		CountOperate b = new CountOperate();

		Thread t1 = new Thread(c);
		t1.setName("A");

		Thread t2 = new Thread(c);
		t2.setName("B");

		Thread t3 = new Thread(c);
		t3.setName("C");

		t1.start();
		t2.start();
		t3.start();

		

		Thread t4 = new Thread(b);
		t4.setName("D");
		t4.start();

	}

}
