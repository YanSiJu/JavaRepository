package cn.csu.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.ObjectStreamException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import cn.csu.Listenerner.DrawListenerner;
import cn.csu.factory.ShapeFactory;

public class ReDrawMain extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ReDrawMain() {
	}

	private static volatile ReDrawMain panel = new ReDrawMain();

	public static ReDrawMain getPanel() {
		return panel;
	}

	private Object readResolve() throws ObjectStreamException {
		return panel;
	}

	JFrame frame = new JFrame();

	private List<ShapeFactory> list = new LinkedList<>();

	/**
	 * 初始化界面的方法
	 */
	public void initUI() {
		frame.setTitle("依米的画图板");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(4500, 2000);
		frame.setLocationRelativeTo(null);

		DrawListenerner listenerner = new DrawListenerner(this, frame, list);

		// 北边面板（存放铅笔，喷枪等工具按钮）
		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(120, 50));
		panel1.setBackground(Color.gray);
		frame.add(panel1, BorderLayout.NORTH);

		String[] str1 = { "缩放", "橡皮", "保存文件" };
		for (int i = 0; i < str1.length; i++) {
			JButton button_1 = new JButton(str1[i]);
			panel1.add(button_1);
			button_1.setPreferredSize(new Dimension(110, 30));
			button_1.addActionListener(listenerner);
		}

		// 西边面板（存放图形按钮）
		JPanel panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension(130, 800));
		panel2.setBackground(Color.gray);
		frame.add(panel2, BorderLayout.WEST);

		String[] str2 = { "直线", "填充圆", "圆角矩形", "填充矩形", "3d矩形" };

		for (int i = 0; i < str2.length; i++) {
			JButton button_2 = new JButton(str2[i]);
			panel2.add(button_2);
			button_2.setPreferredSize(new Dimension(120, 30));
			button_2.addActionListener(listenerner);
		}

		JPanel panel3 = new JPanel(); // 东边面板（存放颜色按钮）
		panel3.setPreferredSize(new Dimension(130, 800));
		panel3.setBackground(Color.gray);
		frame.add(panel3, BorderLayout.EAST);

		// 定义Color数组，用来存储按钮上要显示的颜色信息
		Color[] colorArray = { Color.BLUE, Color.GREEN, Color.RED, Color.BLACK, Color.lightGray, Color.ORANGE,
				Color.PINK, Color.yellow };
		Map<Color, String> map = new HashMap<>(colorArray.length);
		map.put(Color.BLUE, "Blue");
		map.put(Color.green, "Green");
		map.put(Color.red, "Red");
		map.put(Color.LIGHT_GRAY, "LightGray");
		map.put(Color.black, "Black");
		map.put(Color.orange, "Orange");
		map.put(Color.PINK, "Pink");
		map.put(Color.yellow, "Yellow");
		// 循环遍历colorArray数组，根据数组中的元素来实例化按钮对象
		for (int i = 0; i < colorArray.length; i++) {
			JButton button = new JButton();
			button.setBackground(colorArray[i]);
			button.setPreferredSize(new Dimension(50, 50));
			button.setToolTipText(map.get(colorArray[i]));
			// 4.将事件源按钮对象通过addActionListener()监听方法和事件处理类dl对象绑定。
			button.addActionListener(listenerner);
			panel3.add(button);
		}

		frame.add(this, BorderLayout.CENTER);
		frame.setBackground(this.getBackground());

		// 可见必须在gr之前，否则看不到画笔
		frame.setVisible(true);
		// 从窗体上获取画笔对象
		Graphics gr = this.getGraphics();

		this.addMouseListener(listenerner);
		this.addMouseMotionListener(listenerner);

		listenerner.setG(gr);

	}

	// 声明图形对象数组，数组的能存储的元素个数是10000个图形

	/**
	 * 重写组件的paint方法
	 */
	@Override
	public void paint(Graphics gr) {
		super.paint(gr);// 调用父类的paint（）
		/*
		 * 从数组中获取Shape对象 判断shape是否不为空 如果不为空则调用绘制图形的方法
		 */
		Iterator<ShapeFactory> it = list.iterator();
		while (it.hasNext()) {
			ShapeFactory s = it.next();
			if (s != null) {
				s.draw((Graphics2D) gr);
			}
		}
	}
}
