package cn.ccsu.draw.factory;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RecFactory extends GraphicsFactory {

	public RecFactory() {
		super();
	}

	public RecFactory(JFrame frame, Graphics g) {
		super(frame,g);
	}

	@Override
	public void draw(Color c) {

		JPanel panel = new JPanel() { // ��ʼ��һ���»���
			private static final long serialVersionUID = 1L; // ���ùܣ��ɼӿɲ���

			@Override
			public void paint(Graphics g) { // ��д pait ����
				super.paint(g); // ���Ҫ���ϣ�������Ҳ��������ʾ
				g.setColor(Color.PINK); // ���û�����ɫ
				g.fillRect(80, 60, 40, 60); // ���һ������

			}
		};
		frame.setContentPane(panel);
		System.out.println("frame:" + frame);
	}

}
