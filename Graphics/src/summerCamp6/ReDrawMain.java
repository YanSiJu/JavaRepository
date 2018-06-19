package summerCamp6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ReDrawMain extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JFrame frame = new JFrame();

	public static void main(String[] args) {
		new ReDrawMain().initUI();
	}

	private Shape[] shapeArray = new Shape[10000];

	/**
	 * ��ʼ������ķ���
	 */
	public void initUI() {
		frame.setTitle("���׵Ļ�ͼ��");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(2000, 900);
		frame.setLocationRelativeTo(null);

		DrawListenerner dl = new DrawListenerner(this, shapeArray);

		// ������壨���Ǧ�ʣ���ǹ�ȹ��߰�ť��
		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(120, 50));
		panel1.setBackground(Color.gray);
		frame.add(panel1, BorderLayout.NORTH);

		String[] str1 = { "Ǧ��", "ˢ��", "��ǹ", "����", "��Ƥ" };
		for (int i = 0; i < str1.length; i++) {
			JButton button_1 = new JButton(str1[i]);
			panel1.add(button_1);
			button_1.setPreferredSize(new Dimension(110, 30));
			button_1.addActionListener(dl);
		}

		// ������壨���ͼ�ΰ�ť��
		JPanel panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension(130, 800));
		panel2.setBackground(Color.gray);
		frame.add(panel2, BorderLayout.WEST);

		String[] str2 = { "ֱ��", "���Բ", "����", "ͼƬ", "Բ�Ǿ���", "������", "3d����", "�����", "��������" };

		for (int i = 0; i < str2.length; i++) {
			JButton button_2 = new JButton(str2[i]);
			panel2.add(button_2);
			button_2.setPreferredSize(new Dimension(120, 30));
			button_2.addActionListener(dl);
		}

		JPanel panel3 = new JPanel(); // ������壨�����ɫ��ť��
		panel3.setPreferredSize(new Dimension(130, 800));
		panel3.setBackground(Color.gray);
		frame.add(panel3, BorderLayout.EAST);

		// ����Color���飬�����洢��ť��Ҫ��ʾ����ɫ��Ϣ
		Color[] colorArray = { Color.BLUE, Color.GREEN, Color.RED, Color.BLACK, Color.lightGray, Color.ORANGE,
				Color.PINK, new Color(123, 100, 132) };
		// ѭ������colorArray���飬���������е�Ԫ����ʵ������ť����
		for (int i = 0; i < colorArray.length; i++) {
			JButton button = new JButton();
			button.setBackground(colorArray[i]);
			button.setPreferredSize(new Dimension(50, 50));
			// 4.���¼�Դ��ť����ͨ��addActionListener()�����������¼�������dl����󶨡�
			button.addActionListener(dl);
			panel3.add(button);
		}

		frame.add(this, BorderLayout.CENTER);
		frame.setBackground(this.getBackground());

		// �ɼ�������gr֮ǰ�����򿴲�������
		frame.setVisible(true);
		// �Ӵ����ϻ�ȡ���ʶ���
		Graphics gr = this.getGraphics();

		this.addMouseListener(dl);
		this.addMouseMotionListener(dl);

		dl.setG(gr);

	}

	// ����ͼ�ζ������飬������ܴ洢��Ԫ�ظ�����10000��ͼ��

	/**
	 * ��д�����paint����
	 */
	@Override
	public void paint(Graphics gr) {
		super.paint(gr);// ���ø����paint����
		/*
		 * �������л�ȡShape���� 
		 * �ж�shape�Ƿ�Ϊ�� 
		 * �����Ϊ������õ��û���ͼ�εķ���
		 */
		for (int i = 0; i < shapeArray.length; i++) {

			Shape shape = shapeArray[i];
			if (shape != null)//
				shape.draw((Graphics2D) gr);

		}
	}
}
