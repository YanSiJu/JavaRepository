package cn.csu.state;

import cn.csu.entity.Account;

public class NoMoneyState extends AbstractState {

	public NoMoneyState() {

	}

	public NoMoneyState(Account acc) {
		super(acc);

	}

	@Override
	protected void checkState(double money, String act) {

		// 取款
		if (act.equalsIgnoreCase("withdraw")) {
			System.out.println("余额为0，无法取款!!");
		} else if (act.equalsIgnoreCase("deposit")) { // 存款
			acc.setBalance(acc.getBalance() + money);
			acc.setState(new HasEnoughBalanceState(acc));

		}
	}

}
