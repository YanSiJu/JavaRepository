package cn.csu.test;

import cn.csu.bean.AbstractBird;
import cn.csu.bean.Penguin;
import cn.csu.bean.Pigeon;
import cn.csu.service.impl.Fly;
import cn.csu.service.impl.Swim;

public class Main {

	public static void main(String[] args) {
		
		AbstractBird b = new Pigeon();
		
		b.setBehavior(new Fly());
		b.display();
	
		b.setBehavior(new Swim());
		b.display();
		
		
		b = new Penguin();
		
		b.setBehavior(new Fly());
		b.display();
	
		b.setBehavior(new Swim());
		b.display();
	
	}
}
