package com.alibaba.stream.thread.test;

import java.io.IOException;

import org.junit.Test;
import com.alibaba.stream.thread.Receiver;
import com.alibaba.stream.thread.Sender;

public class PipedStreamTest {

	public PipedStreamTest() {

	}

	@Test
	public void streamwithThreadTest() {

		String content = "Java是一种可以撰写跨平台应用软件的面向对象的程序设计语言，\n" + "是由Sun Microsystems公司于1995年5月推出的Java程序设计语言和\n"
				+ "Java平台（即JavaSE, JavaEE, JavaME）的总称。Java 技术具有卓" + "越的通用性、高效性、平台移植性和安全性，广泛应用于个人PC、数据中心、游戏控制台、"
				+ "\n科学超级计算机、移动电话和互联网，同时拥有全球最大的开发者专业社群。在全球云计算" + "和移动互联网的产业环境下，Java更具备了显著优势和广阔前景。";

		Receiver rcv = new Receiver();
		Sender s = new Sender(content, rcv);
		try {
			// 将管道连接
			s.getOut().connect(rcv.getIn());
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread receiver = new Thread(rcv);
		Thread sender = new Thread(s);

		sender.start();
		// 不加这个sleep会出问题 ------>WHY???
		try {
			Thread.sleep(50);// 这个时间的大小也有影响
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		receiver.start();

	}

}
