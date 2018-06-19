package cn.csu.state;

import cn.csu.entity.Account;

public class HasEnoughBalanceState extends AbstractState {

	public HasEnoughBalanceState() {

	}

	public HasEnoughBalanceState(Account acc) {
		super(acc);

	}

	@Override
	protected void checkState(double money, String act) {
		// ȡ��
		if (act.equalsIgnoreCase("withdraw")) {

			if (money > acc.getBalance()) {
				System.out.println("ȡ����������޷�ȡ��!!");
			} else if (money == acc.getBalance()) {
				acc.setBalance(acc.getBalance() - money);
				acc.setState(new NoMoneyState(acc));
			} else {
				acc.setBalance(acc.getBalance() - money);
			}
		} else if (act.equalsIgnoreCase("deposit")) { // ���
			acc.setBalance(acc.getBalance() + money);
		}
	}

}
