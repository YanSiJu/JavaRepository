package cn.csu.swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawSimplePicture {
	static Graphics graphics;

	public DrawSimplePicture() {

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("my frame"); // 初始化一个窗口
		frame.setSize(1800, 1000);
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton b;
		b = new JButton("直线");
		b.setPreferredSize(new Dimension(100, 30));
		b.setFont(new Font("直线", Font.BOLD, 20));

		frame.setVisible(true);
		JPanel panel = null;
		panel = new JPanel() { // 初始化一个新画布
			private static final long serialVersionUID = 1L; // 不用管，可加可不加

			@Override
			public void paint(Graphics g) { // 重写 pait 方法
				super.paint(g); // 这个要加上，但不加也能正常显示

				b.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Draw.draw(g);
					}
				});

			}
		};
		frame.add(b);
		frame.setContentPane(panel); // 将画布添加到窗口中

	}

}
