package cn.ccsu.test;

import cn.ccsu.bean.Coffee;
import cn.ccsu.bean.Decorator;
import cn.ccsu.bean.Juice;
import cn.ccsu.bean.LanShan;
import cn.ccsu.bean.Latte;
import cn.ccsu.bean.Milk;

public class Test {

	public static void main(String[] args) {

		Coffee coffee = new Latte();
		Decorator juice = new Juice(coffee);
		System.out.println("加了橙汁拿铁咖啡价格为:" + juice.getPrize());

		coffee = new LanShan();
		Decorator milk = new Milk(coffee);
		System.out.println("加了牛奶蓝山咖啡价格为:" + milk.getPrize());

		juice = new Juice(milk);
		System.out.println("加了橙汁加了牛奶蓝山咖啡价格为:" + juice.getPrize());
	}
}
