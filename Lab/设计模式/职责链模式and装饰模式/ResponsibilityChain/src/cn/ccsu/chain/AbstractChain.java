package cn.ccsu.chain;

public abstract class AbstractChain {

	protected AbstractChain successor;

	public void setNextSuccessor(AbstractChain successor) {
		this.successor = successor;
	}

	public abstract void judge(Integer orderType, boolean isPaid, int num);
}
