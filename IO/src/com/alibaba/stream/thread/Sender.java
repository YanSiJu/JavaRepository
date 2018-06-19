package com.alibaba.stream.thread;

import java.io.IOException;
import java.io.PipedOutputStream;

public class Sender implements Runnable {

	private PipedOutputStream out = new PipedOutputStream();
	private String content = "";
	private Receiver rcv;

	public Sender(String content, Receiver rcv) {
		super();
		this.content = content;
		this.rcv = rcv;
	}

	public Sender() {

	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @param rcv
	 *            the rcv to set
	 */
	public void setRcv(Receiver rcv) {
		this.rcv = rcv;
	}

	@Override
	public void run() {
		try {
			out.write(content.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 通知接收者可以接收了
		synchronized (this) {
			rcv.setFinished(true);
		}

	}

	/**
	 * @return the out
	 */
	public PipedOutputStream getOut() {
		return out;
	}

}
