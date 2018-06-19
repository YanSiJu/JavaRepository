package cn.csu.test;

import cn.csu.bean.AbstractGraph;
import cn.csu.bean.Adapter;
import cn.csu.bean.Angle;
import cn.csu.bean.Line;
import cn.csu.bean.Rectangle;
import cn.csu.bean.Square;

public class AdapterTest {

	public static void main(String[] args) {

		AbstractGraph g = new Adapter(new Angle());
		g.draw();

		g = new Line();
		g.draw();
	
		g = new Square();
		g.draw();
		
		
		g = new Rectangle();
		g.draw();
		
	}
}
