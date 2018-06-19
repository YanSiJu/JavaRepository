package cn.ccsu.chain;

public class PayJudge extends AbstractChain {

	@Override
	public void judge(Integer orderType, boolean isPaid, int num) {

		if (isPaid) {
			if (orderType == 1) {
				System.out.println("享受100元优惠券");
			} else {
				System.out.println("享受50元优惠券");
			}
			return;
		} else {
			this.setNextSuccessor(new RepositoryJudge());
		}
		this.successor.judge(orderType, isPaid, num);
	}

}
