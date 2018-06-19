package cn.csu.entity;

import cn.csu.state.AbstractState;
import cn.csu.state.NoEnoughBalanceState;

public class Account {

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	private double balance;
	private AbstractState state;

	public Account() {
		this.state = new NoEnoughBalanceState(this);
		this.balance = 0;
	}

	// ���
	public void deposit() {
		state.deposit();
	}

	/**
	 * @return the state
	 */
	public AbstractState getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(AbstractState state) {
		this.state = state;
	}

	// ȡ��
	public void withdraw() {
		state.withdraw();
	}

	/**
	 * @param balance
	 *            the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
