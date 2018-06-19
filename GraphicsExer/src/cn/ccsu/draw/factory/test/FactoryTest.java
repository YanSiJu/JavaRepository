package cn.ccsu.draw.factory.test;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import cn.ccsu.draw.factory.GraphicsFactory;
import cn.ccsu.draw.factory.RecFactory;

public class FactoryTest {

	public FactoryTest() {

	}

	public static void main(String[] a) {
		JFrame frame = new JFrame("my frame"); // ��ʼ��һ������
		JButton b = new JButton("button");
		b.setPreferredSize(new Dimension(100, 30));
		b.setFont(new Font("����", Font.BOLD, 20));
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GraphicsFactory factory = new RecFactory();
				factory.draw(null);
			}

		});
		frame.setSize(1800, 1000);
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(b);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���û�ͼ������Ĳ������˳���ͼ����
		frame.setVisible(true); // ��ʾ����, ��Ȼɶ������ʾ
//		GraphicsFactory factory = new RecFactory(frame);
//		factory.draw(null);
	}

}
