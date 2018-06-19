package cn.csu.swing;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class MoveItem extends JFrame implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x, y;
	private int r;

	// Ĭ�Ϲ��캯��
	public MoveItem() {
		x = 300;
		y = 200;
		r = 50;
		this.setSize(600, 400);
		this.addKeyListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode(); // ��ȡ������
		switch (key) {
		case KeyEvent.VK_UP: // ����
			y -= 10;
			break;
		case KeyEvent.VK_DOWN: // ����
			y += 10;
			break;
		case KeyEvent.VK_LEFT: // ����
			x -= 10;
			break;
		case KeyEvent.VK_RIGHT: // ����
			x += 10;
			break;
		}

		// ����ͼ��
		Graphics g = this.getGraphics();
		g.clearRect(0, 0, 600, 400);
		g.fillOval(x - r, y - r, 2 * r, r * 2);

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
