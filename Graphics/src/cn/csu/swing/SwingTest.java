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

		// 设置窗体布局
		setLayout(new FlowLayout());

		// 添加标签
		label = new JLabel("A Label");
		label.setLocation(30, 50);
		add(label);
		txt = new JTextField(20);
		add(txt);

		label = new JLabel(" Label");
		label.setLocation(40, 60);
		add(label);
		// 添加文本输入框
		txt = new JTextField(20);
		add(txt);

		// 添加按钮
//		b1 = new JButton("按钮１");
//		b2 = new JButton("按钮２");
//		add(b1);
//		add(b2);

		// 添加事件
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
			// 将按钮的名称显示在TextField中
			txt.setText(((JButton) event.getSource()).getText());
		}

	}

}
