package cn.ccsu.chain.test;

import java.util.Scanner;
import org.junit.Test;
import cn.ccsu.chain.AbstractChain;
import cn.ccsu.chain.OrderTypeJudge;

public class ChainTest {

	@Test
	public void test() {

		Scanner in = new Scanner(System.in);

		System.out.println("请输入订单类型:");
		Integer orderType = in.nextInt();

		System.out.println("是否已付款(true or false):");
		boolean isPaid = in.nextBoolean();

		System.out.println("请输入库存数:");
		int num = in.nextInt();

		System.out.print("订单类型:" + orderType);
		System.out.print("付款状态:" + isPaid);
		System.out.println("库存数:" + num + "\n");

		AbstractChain chain = new OrderTypeJudge();
		chain.judge(orderType, isPaid, num);
		
		in.close();
	}
}
