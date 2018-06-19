package cn.ccsu.log;

public class RealLog extends AbstractLog {

	@Override
	public int method(int m, int n) {

		System.out.println("真实业务方法被调用!!");
		return m / n;
	}

}
