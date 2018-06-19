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

	// 存款
	public void deposit() {
		System.out.println("请输入存款金额:");
		double money = in.nextDouble();
		checkState(money, "deposit");
		System.out.println("您当前的余额为:" + acc.getBalance() + "\n");

	}

	protected abstract void checkState(double money, String act);

	// 取款
	public void withdraw() {
		System.out.println("请输入取款金额:");
		double money = in.nextDouble();
		checkState(money, "withdraw");
		System.out.println("您当前的余额为:" + acc.getBalance() + "\n");

	}
}
