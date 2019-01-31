package test;

import com.mythread.www.MyThread;

public class Run {

	public static void main(String[] args) {
		MyThread mythread = new MyThread();
		mythread.start();
//		mythread.run();
		System.out.println("ÔËĞĞ½áÊø£¡");
		mythread.start();
	}

}
