package cn.csu.state;

import java.util.Scanner;

import cn.csu.entity.Account;

public abstract class AbstractState {

	protected Account acc;
	private static Scanner in = new Scanner(System.in);

	public AbstractState() {

	}

	public AbstractState(Account acc) {
		this.acc = acc;
	}

	public static void close() {
		in.close();
	}

	// ���
	public void deposit() {
		System.out.println("����������:");
		double money = in.nextDouble();
		checkState(money, "deposit");
		System.out.println("����ǰ�����Ϊ:" + acc.getBalance() + "\n");

	}

	protected abstract void checkState(double money, String act);

	// ȡ��
	public void withdraw() {
		System.out.println("������ȡ����:");
		double money = in.nextDouble();
		checkState(money, "withdraw");
		System.out.println("����ǰ�����Ϊ:" + acc.getBalance() + "\n");

	}
}
