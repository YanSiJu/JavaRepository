package cn.csu.swing;

import javax.swing.JButton;
import org.junit.Test;

import cn.csu.entity.A;
import cn.csu.entity.B;

public class Main {

	@Test
	public void colorTest() {
		JButton b = new JButton();
		b.setToolTipText("--->button");
		System.out.println(b.getToolTipText());
	}

	@Test
	public void instanceTest() {
		Object a = new String("");
		System.out.println(a instanceof String);

		System.out.println("--------------------------------\n");

		A instance = new B();
		System.out.println(instance instanceof B);
	}
}
