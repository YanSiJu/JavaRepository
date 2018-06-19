package com.alibaba.stream.thread;

import java.io.IOException;
import java.io.PipedInputStream;

public class Receiver implements Runnable {

	// 标志域,用于检查发送者是否已发送完数据
	private volatile boolean finished = false;

	private PipedInputStream in = new PipedInputStream();

	// 存储接收到的数据
	private StringBuilder content = new StringBuilder();

	@Override
	public void run() {
		// 不断睡眠，直至发送者已经写完数据
		while (!finished) {
			try {
				Thread.sleep(1000);
				System.out.println("sleeping....");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		try {
			byte[] buff = new byte[1024];
			int len;
			while ((len = in.read(buff)) != -1) {
				content.append(new String(buff, 0, len));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		showContent();
	}

	// 显示接收到的数据
	private void showContent() {

		// 可以考虑输出到文件
		System.out.println("接收到的内容:\n" + content);
	}

	/**
	 * @return the finished
	 */
	public boolean isFinished() {
		return finished;
	}

	/**
	 * @param finished
	 *            the finished to set
	 */
	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	/**
	 * @return the in
	 */
	public PipedInputStream getIn() {
		return in;
	}

}
