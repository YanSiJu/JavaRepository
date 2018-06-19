package cn.csu.swing;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainFrame extends JFrame implements MouseMotionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon ii = new ImageIcon("female.png");
	int x, y;

	public MainFrame(){
	  setTitle("Mouse Move");
	  addMouseMotionListener(this);
	  setSize(400,400);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  setLocationRelativeTo(null);
	  setVisible(true);
	 }

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawRect(x, y, 20, 20);
//		g.drawImage(ii.getImage(), x, y, null);
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		repaint();
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}
