package cn.ccsu.Test;

import cn.ccsu.thread.MyThread2;

public class TestMyThread2 {
	
	
	public static void main(String[] args){
		
		MyThread2 t = new MyThread2();
		@SuppressWarnings("unused")
		MyThread2 tt = new MyThread2();
		
		/*t.setName("A");
		t.start();*/
		
		t.setName("target====");
		Thread thread = new Thread(t);
		Thread t0 = new Thread(t);
		Thread t1 = new Thread(t);
		
		t0.setName("B");
		t1.setName("C");
		thread.setName("A");
		
		t0.start();
		t1.start();
		thread.start();
	}

}
