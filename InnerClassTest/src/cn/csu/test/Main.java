package cn.csu.test;

import org.junit.Test;
import cn.csu.innerclass.Outer;
import cn.csu.innerclass.Outer.Inner;

public class Main {

	public Main() {

	}

	@Test
	public void test() {

		Outer out = new Outer();
		Inner in = out.new Inner();
		in.visit();

	}

}
