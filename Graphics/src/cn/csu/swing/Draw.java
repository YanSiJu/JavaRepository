package cn.csu.swing;

import java.awt.Color;
import java.awt.Graphics;

public class Draw {

	public Draw() {

	}

	public static void draw(Graphics g) {
		g.setColor(Color.RED); // ���û�����ɫ
		g.fillRect(80, 60, 40, 60); // ���һ������
	}

}
