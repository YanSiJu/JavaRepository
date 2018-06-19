package cn.ccsu.chain;

public class OrderTypeJudge extends AbstractChain {

	@Override
	public void judge(Integer orderType, boolean isPaid, int num) {

		if (orderType == 3) {
			this.setNextSuccessor(new RepositoryJudge());

		} else {
			this.setNextSuccessor(new PayJudge());
		}
		this.successor.judge(orderType, isPaid, num);
	}

}
