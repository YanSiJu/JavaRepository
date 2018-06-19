package cn.csu.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SwingTest extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static JLabel label;
	private JTextField txt;

	public SwingTest() {
		super("Hello Swing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		setVisible(true);

		// ���ô��岼��
		setLayout(new FlowLayout());

		// ��ӱ�ǩ
		label = new JLabel("A Label");
		label.setLocation(30, 50);
		add(label);
		txt = new JTextField(20);
		add(txt);

		label = new JLabel(" Label");
		label.setLocation(40, 60);
		add(label);
		// ����ı������
		txt = new JTextField(20);
		add(txt);

		// ��Ӱ�ť
//		b1 = new JButton("��ť��");
//		b2 = new JButton("��ť��");
//		add(b1);
//		add(b2);

		// ����¼�
//		b1.addActionListener(new ButtonListener());
//		b2.addActionListener(new ButtonListener());

	}

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new SwingTest();
			}
		});

	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			// ����ť��������ʾ��TextField��
			txt.setText(((JButton) event.getSource()).getText());
		}

	}

}
