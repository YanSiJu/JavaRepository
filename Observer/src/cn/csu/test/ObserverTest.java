package cn.csu.test;

import org.junit.Test;
import cn.csu.observer.Observer;
import cn.csu.observer.Observer_1;
import cn.csu.observer.Observer_2;
import cn.csu.observer.Observer_3;
import cn.csu.stock.subject.Stock;
import cn.csu.stock.subject.TencentStock;
import cn.csu.subject.Girl;
import cn.csu.subject.Subject;

public class ObserverTest {

	public ObserverTest() {

	}

	@Test
	public void test_1() {
		Subject subject = new Girl();

		Observer obs_1 = new Observer_1();
		Observer obs_2 = new Observer_2();
		Observer obs_3 = new Observer_3();

		subject.attach(obs_1);
		subject.attach(obs_2);
		subject.attach(obs_3);

		subject.dance();
		System.out.println();
		subject.sing();

	}

	@Test
	public void test_2() {
		Stock subject = new TencentStock();

		cn.csu.stock.observer.Observer obs_1 = new cn.csu.stock.observer.Observer_1();
		cn.csu.stock.observer.Observer obs_2 = new cn.csu.stock.observer.Observer_2();
		cn.csu.stock.observer.Observer obs_3 = new cn.csu.stock.observer.Observer_3();

		subject.attach(obs_1);
		subject.attach(obs_2);
		subject.attach(obs_3);

		subject.decline(0.05, 200);

	}
}
