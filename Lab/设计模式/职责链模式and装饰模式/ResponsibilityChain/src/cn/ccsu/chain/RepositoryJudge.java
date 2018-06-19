package cn.ccsu.chain;

public class RepositoryJudge extends AbstractChain {

	@Override
	public void judge(Integer orderType, boolean isPaid, int num) {

		if (num > 0) {
			System.out.println("没有优惠券，但可以购买!!");
		} else {
			System.out.println("对不起，库存不足!!");
		}
	}

}
