package cn.csu.state;

import cn.csu.entity.Account;

public class NoEnoughBalanceState extends AbstractState {

	public NoEnoughBalanceState() {

	}

	public NoEnoughBalanceState(Account acc) {
		super(acc);

	}

	@Override
	protected void checkState(double money, String act) {

		// ȡ��
		if (act.equalsIgnoreCase("withdraw")) {
			System.out.println("���Ϊ0���޷�ȡ��!!");
		} else if (act.equalsIgnoreCase("deposit")) { // ���
			acc.setBalance(acc.getBalance() + money);
			acc.setState(new HasEnoughBalanceState(acc));

		}
	}

}
