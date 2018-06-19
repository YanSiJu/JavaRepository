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
	 * 初始化界面的方法
	 */
	public void initUI() {
		frame.setTitle("依米的画图板");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(2000, 900);
		frame.setLocationRelativeTo(null);

		DrawListenerner dl = new DrawListenerner(this, shapeArray);

		// 北边面板（存放铅笔，喷枪等工具按钮）
		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(120, 50));
		panel1.setBackground(Color.gray);
		frame.add(panel1, BorderLayout.NORTH);

		String[] str1 = { "铅笔", "刷子", "喷枪", "吸管", "橡皮" };
		for (int i = 0; i < str1.length; i++) {
			JButton button_1 = new JButton(str1[i]);
			panel1.add(button_1);
			button_1.setPreferredSize(new Dimension(110, 30));
			button_1.addActionListener(dl);
		}

		// 西边面板（存放图形按钮）
		JPanel panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension(130, 800));
		panel2.setBackground(Color.gray);
		frame.add(panel2, BorderLayout.WEST);

		String[] str2 = { "直线", "填充圆", "文字", "图片", "圆角矩形", "填充矩形", "3d矩形", "五角星", "任意多边形" };

		for (int i = 0; i < str2.length; i++) {
			JButton button_2 = new JButton(str2[i]);
			panel2.add(button_2);
			button_2.setPreferredSize(new Dimension(120, 30));
			button_2.addActionListener(dl);
		}

		JPanel panel3 = new JPanel(); // 东边面板（存放颜色按钮）
		panel3.setPreferredSize(new Dimension(130, 800));
		panel3.setBackground(Color.gray);
		frame.add(panel3, BorderLayout.EAST);

		// 定义Color数组，用来存储按钮上要显示的颜色信息
		Color[] colorArray = { Color.BLUE, Color.GREEN, Color.RED, Color.BLACK, Color.lightGray, Color.ORANGE,
				Color.PINK, new Color(123, 100, 132) };
		// 循环遍历colorArray数组，根据数组中的元素来实例化按钮对象
		for (int i = 0; i < colorArray.length; i++) {
			JButton button = new JButton();
			button.setBackground(colorArray[i]);
			button.setPreferredSize(new Dimension(50, 50));
			// 4.将事件源按钮对象通过addActionListener()监听方法和事件处理类dl对象绑定。
			button.addActionListener(dl);
			panel3.add(button);
		}

		frame.add(this, BorderLayout.CENTER);
		frame.setBackground(this.getBackground());

		// 可见必须在gr之前，否则看不到画笔
		frame.setVisible(true);
		// 从窗体上获取画笔对象
		Graphics gr = this.getGraphics();

		this.addMouseListener(dl);
		this.addMouseMotionListener(dl);

		dl.setG(gr);

	}

	// 声明图形对象数组，数组的能存储的元素个数是10000个图形

	/**
	 * 重写组件的paint方法
	 */
	@Override
	public void paint(Graphics gr) {
		super.paint(gr);// 调用父类的paint（）
		/*
		 * 从数组中获取Shape对象 
		 * 判断shape是否不为空 
		 * 如果不为空则调用调用绘制图形的方法
		 */
		for (int i = 0; i < shapeArray.length; i++) {

			Shape shape = shapeArray[i];
			if (shape != null)//
				shape.draw((Graphics2D) gr);

		}
	}
}
