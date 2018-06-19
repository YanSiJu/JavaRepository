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
		JFrame frame = new JFrame("my frame"); // ��ʼ��һ������
		frame.setSize(1800, 1000);
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton b;
		b = new JButton("ֱ��");
		b.setPreferredSize(new Dimension(100, 30));
		b.setFont(new Font("ֱ��", Font.BOLD, 20));

		frame.setVisible(true);
		JPanel panel = null;
		panel = new JPanel() { // ��ʼ��һ���»���
			private static final long serialVersionUID = 1L; // ���ùܣ��ɼӿɲ���

			@Override
			public void paint(Graphics g) { // ��д pait ����
				super.paint(g); // ���Ҫ���ϣ�������Ҳ��������ʾ

				b.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Draw.draw(g);
					}
				});

			}
		};
		frame.add(b);
		frame.setContentPane(panel); // ��������ӵ�������

	}

}
