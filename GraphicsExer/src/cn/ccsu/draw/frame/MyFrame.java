package cn.ccsu.draw.frame;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import cn.ccsu.draw.factory.GraphicsFactory;
import cn.ccsu.draw.factory.RecFactory;

public class MyFrame extends JFrame {

	private JButton recBtn;
	private JButton ovalBtn;
	private JButton lineBtn;
	private JButton colorBtn;
	@SuppressWarnings("unused")
	private JPanel panel;
	private static Graphics g;

	{
		// ��ʼ������
		panel = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			public void paint(Graphics g) {
				super.paint(g);
				MyFrame.g = g;
			}
		};
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private void setButton() {
		recBtn = new JButton("����");
		recBtn.setPreferredSize(new Dimension(100, 30));
		recBtn.setFont(new Font("����", Font.BOLD, 20));

		ovalBtn = new JButton("Բ");
		ovalBtn.setPreferredSize(new Dimension(100, 30));
		ovalBtn.setFont(new Font("Բ", Font.BOLD, 20));

		lineBtn = new JButton("ֱ��");
		lineBtn.setPreferredSize(new Dimension(100, 30));
		lineBtn.setFont(new Font("ֱ��", Font.BOLD, 20));

		colorBtn = new JButton("ѡȡ��ɫ");
		colorBtn.setPreferredSize(new Dimension(118, 40));
		colorBtn.setFont(new Font("ѡȡ��ɫ", Font.BOLD, 20));

	}

	public MyFrame() throws HeadlessException {
		this("��ͼ���");

		this.setSize(1800, 1000);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setButton();
		addActionListener(this);
		this.add(recBtn);
		this.add(lineBtn);

		this.add(ovalBtn);
		this.add(colorBtn);
		this.setVisible(true);
	}

	private void addActionListener(JFrame f) {
		recBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GraphicsFactory factory = new RecFactory(f,MyFrame.g);
				factory.draw(null);
			}

		});

	}

	public MyFrame(String title) throws HeadlessException {
		super(title);
	}

}
