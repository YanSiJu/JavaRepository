package cn.ccsu.log;

import java.util.Date;

public class ProxyLog extends AbstractLog {

	private RealLog log = new RealLog();

	public void PreAdvice() {

		System.out.println("方法method调用的时间为：" + new Date());
	}

	public void PostAdvice() {

		System.out.println("方法method调用成功!!");
	}

	@Override
	public int method(int m, int n) {

		PreAdvice();
		int result = 0;
		try {
			result = log.method(m, n);
		} catch (Exception e) {
			System.out.println("方法method()调用失败");
			System.exit(-1);
		}
		PostAdvice();
		return result;
	}

}
