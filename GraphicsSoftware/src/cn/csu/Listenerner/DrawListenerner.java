package cn.csu.Listenerner;

import java.awt.AWTException;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import cn.csu.factory.CircleFactory;
import cn.csu.factory.EraserFactory;
import cn.csu.factory.FilledRectFactory;
import cn.csu.factory.LineFactory;
import cn.csu.factory.RoundRectFactory;
import cn.csu.factory.ShapeFactory;
import cn.csu.factory.ThreeDRectFactory;

public class DrawListenerner implements ActionListener, MouseListener, MouseMotionListener {

	private String type = "铅笔";// 声明图形属性，用来存储用户选择的图形
	private Color color = Color.black;// 声明颜色属性，用来存储用户选择的颜色
	private Graphics g;// 声明Graphics画笔类的对象
	private int count = 0;
	private int moveX;
	private int moveY;
	private int t2;
	private int t1;
	private int t3;
	private int t4;
	private int x1;
	private int x2;
	private int y1;
	private int y2;
	private ShapeFactory shape;// 声明图形对象
	// private ShapeFactory[] shapeArray;// 声明存储图形对象的数组
	private List<ShapeFactory> list;
	private int number = 0;// 记录器，用来记录已经存储的图形个数。
	private String colorStr;
	private JPanel panel;
	@SuppressWarnings("unused")
	private JFrame frame;
	private String path;
	private String name;
	Random r = new Random();
	public BasicStroke s1;// 画笔大小
	BasicStroke s = new BasicStroke();

	/**
	 * 1 构造方法
	 * 
	 * @param g是从DrawMain类的窗体上传递过来的画笔对象
	 * @param shapeArray是从DrawMain类传递过来的存储图形的数组对象
	 */
	public DrawListenerner(JPanel panel, JFrame frame, List<ShapeFactory> list) {
		this.panel = panel;
		this.frame = frame;
		this.list = list;
	}

	public void setG(Graphics g) {
		this.g = g;
	}

	public void saveShape() {

		list.add(shape);
	}

	public void saveImgFrame() {

		JFrame frame = new JFrame();
		// 设置文本域
		JTextField jPathField = new JTextField(15);
		JTextField jNameField = new JTextField(15);

		// 设置文本域大小
		jNameField.setPreferredSize(new Dimension(15, 40));
		jPathField.setPreferredSize(new Dimension(50, 40));

		jNameField.setFont(new Font("1", 20, 20));
		jPathField.setText("C:\\\\Users\\\\Bill\\\\Desktop\\\\");
		jPathField.setFont(new Font("C:\\Users\\Bill\\Desktop\\", 20, 20));

		// 设置默认路径
		// 设置默认文件名
		jNameField.setText("1");
		JLabel pathLabel = new JLabel("保存路径");
		JLabel nameLabel = new JLabel("文件名");
		nameLabel.setLocation(70, 50);

		// 保存按钮
		JButton button = new JButton("保存图片");
		button.addActionListener(this);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				path = jPathField.getText();
				name = jNameField.getText();
				save();
			}
		});

		// 设置布局
		frame.setLayout(new GridLayout(3, 1));
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();

		jp1.add(pathLabel);
		jp1.add(jPathField);// 第一块面板添加用户名和文本框

		jp2.add(nameLabel);
		jp2.add(jNameField);// 第二块面板添加密码和密码输入框

		jp3.add(button);

		frame.add(jp1);
		frame.add(jp2);
		frame.add(jp3);

		frame.setSize(500, 200);
		frame.setLocation(1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("保存文件 ");

	}

	public void save() {
		BufferedImage myImage = null;
		try {
			myImage = new Robot().createScreenCapture(panel.getBounds());

			ImageIO.write(myImage, "jpg", new File(path + "" + name + ".jpg"));
		} catch (AWTException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void zoom(int thisX, int thisY) {
		Iterator<ShapeFactory> it = list.iterator();
		if ((moveY - thisY < 20 && moveY - thisY > 0) || (moveY - thisY < 0 && moveY - thisY > -20)) {
			// Y 在20范围内移动认为是水平移动
			if (moveX < thisX) {
				// right
				while (it.hasNext()) {
					ShapeFactory s = it.next();
					s.setW(s.getW() + 10);
				}
			} else {
				// left
				while (it.hasNext()) {
					ShapeFactory s = it.next();
					s.setW(s.getW() - 10);
				}
			}
		} else {
			if (moveX < thisX) {
				// 右下
				while (it.hasNext()) {
					ShapeFactory s = it.next();
					s.setW(s.getW() + 10);
					s.setH(s.getH() + 10);
				}
			} else {
				// 左上
				while (it.hasNext()) {
					ShapeFactory s = it.next();
					s.setW(s.getW() - 10);
					s.setH(s.getH() - 10);
				}
			}
		}
		panel.repaint();
	}

	/**
	 * 重写ActionListener接口中的actionPerformed抽象方法。
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();// 获取事件源对象
		String text = button.getText();// 获取按钮上的文字信息
		if (text == null || text.equals("")) {// 判断是否点击的是颜色按钮
			color = button.getBackground();// 获取按钮的背景颜色
			colorStr = button.getToolTipText();
		} else {
			type = button.getText();// 获取按钮上的文字信息
			if (type.equals("保存文件")) {
				saveImgFrame();
			}
		}
	}

	/**
	 * 当你在事件源对象上发生鼠标按键按下动作时执行此方法
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// 2.在重写的按下动作和释放动作的事件处理方法中，在按下方法中获取按下坐标值
		x1 = e.getX();
		y1 = e.getY();
		if (type.equals("缩放")) {
			Point point = MouseInfo.getPointerInfo().getLocation();
			moveX = point.x;
			moveY = point.y;
		}

	}

	/**
	 * 当你在事件源对象上发生鼠标按键释放动作时执行此方法
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// 在重写的按下动作和释放动作的事件处理方法中，获取释放的坐标值；
		x2 = e.getX();
		y2 = e.getY();
		// 2.之后根据按下和释放的坐标值，以及图形和颜色，使用Graphics来绘制对应的图形。
		if (type.equals("直线")) {

			// 根据数据来实例化图形对象
			shape = new LineFactory(this);
			// 调用图形的绘图方法
			shape.draw((Graphics2D) g);
			saveShape();
		} else if (type.equals("缩放")) {
			Point point = MouseInfo.getPointerInfo().getLocation();
			int thisX = point.x;
			int thisY = point.y;
			zoom(thisX, thisY);
		} else if (type.equals("圆角矩形")) {
			shape = new RoundRectFactory(this, 30, 30);
			shape.draw((Graphics2D) g);
			saveShape();
		} else if (type.equals("填充圆")) {
			shape = new CircleFactory(this);
			shape.draw((Graphics2D) g);
			saveShape();
		}
	}

	/**
	 * 当鼠标在窗体上按下按键并且拖动时执行此方法
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();
		Graphics2D g2d = (Graphics2D) g;
		if (type.equals("铅笔")) {
			// 根据数据来实例化图形对象
			shape = new LineFactory(this);
			// 调用图形的绘图方法
			shape.draw(g2d);
			x1 = x2;
			y1 = y2;
			saveShape();
		} else if (type.equals("橡皮")) {
			shape = new EraserFactory(this);
			shape.draw(g2d);
			x1 = x2;
			y1 = y2;
			saveShape();
		} else if (type.equals("填充矩形")) {
			shape = new FilledRectFactory(this);
			shape.draw(g2d);
			saveShape();
		} /*
			 * else if (type.equals("文字")) { shape = new StringFactory(this);
			 * shape.draw(g2d); saveShape(); }
			 */else if (type.equals("3d矩形")) {
			shape = new ThreeDRectFactory(this);
			shape.draw(g2d);
			saveShape();
		}

	}

	/**
	 * 当鼠标在窗体上移动鼠标时执行此方法
	 */
	@Override
	public void mouseMoved(MouseEvent e) {

	}

	/**
	 * 当你在事件源对象上发生鼠标点击(按下和释放的动作必须在同一个位置上)动作时执行此方法
	 */
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	/**
	 * 当你的鼠标光标进入事件源对象上时执行此方法
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	/**
	 * 当你的鼠标光标离开事件源对象上时执行此方法
	 */
	@Override
	public void mouseExited(MouseEvent e) {
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @return the t1
	 */
	public int getT1() {
		return t1;
	}

	/**
	 * @return the t2
	 */
	public int getT2() {
		return t2;
	}

	/**
	 * @return the t3
	 */
	public int getT3() {
		return t3;
	}

	/**
	 * @return the t4
	 */
	public int getT4() {
		return t4;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @return the x1
	 */
	public int getX1() {
		return x1;
	}

	/**
	 * @return the y1
	 */
	public int getY1() {
		return y1;
	}

	/**
	 * @return the x2
	 */
	public int getX2() {
		return x2;
	}

	/**
	 * @return the y2
	 */
	public int getY2() {
		return y2;
	}

	/**
	 * @return the shape
	 */
	public ShapeFactory getShape() {
		return shape;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @return the r
	 */
	public Random getR() {
		return r;
	}

	/**
	 * @return the s1
	 */
	public BasicStroke getS1() {
		return s1;
	}

	/**
	 * @return the s
	 */
	public BasicStroke getS() {
		return s;
	}

	/**
	 * @return the g
	 */
	public Graphics getG() {
		return g;
	}

	/**
	 * @return the colorStr
	 */
	public String getColorStr() {
		return colorStr;
	}

}

// public int rangeJudge() {
//
// for (int i = 0; i < number; i++) {
// if (shapeArray[i] instanceof CircleFactory) {
// if (moveX < shapeArray[i].getX() + shapeArray[i].getW() && moveX >
// shapeArray[i].getX()) {
// if (moveY < shapeArray[i].getY() + shapeArray[i].getH() && moveY >
// shapeArray[i].getY()) {
// return i;
// }
// }
// } else if (shapeArray[i] instanceof RoundRectFactory) {
// if (moveX < shapeArray[i].getX() + shapeArray[i].getW() && moveX >
// shapeArray[i].getX() + 1) {
// if (moveY < shapeArray[i].getY() + shapeArray[i].getH() && moveY >
// shapeArray[i].getY()) {
// return i;
// }
// }
// } else if (shapeArray[i] instanceof ThreeDRectFactory) {
// if (moveX < shapeArray[i].getX() + shapeArray[i].getW() + 1 && moveX >
// shapeArray[i].getX()) {
// if (moveY < shapeArray[i].getY() + shapeArray[i].getH() + 1 && moveY >
// shapeArray[i].getY()) {
// return i;
// }
// }
// } else if (shapeArray[i] instanceof EraserFactory || shapeArray[i] instanceof
// LineFactory) {
//
// if ((shapeArray[i].getW() - shapeArray[i].getX())
// / (shapeArray[i].getH() - shapeArray[i].getY()) == (moveX -
// shapeArray[i].getX())
// / (moveY - shapeArray[i].getY())) {
// return i;
// }
// } else if (shapeArray[i] instanceof FilledRectFactory) {
// if (moveX < shapeArray[i].getX() + shapeArray[i].getW() - 1 && moveX >
// shapeArray[i].getX()) {
// if (moveY < shapeArray[i].getY() + shapeArray[i].getH() - 1 && moveY >
// shapeArray[i].getY()) {
// return i;
// }
// }
// }
// }
// return -1;
//
// }

// public void z(int thisX, int thisY, int i) {
// if (i < 0 || i >= shapeArray.length) {
// return;
// }
// if ((moveY - thisY < 20 && moveY - thisY > 0) || (moveY - thisY < 0 && moveY
// - thisY > -20)) {
// // Y 在20范围内移动认为是水平移动
// if (moveX < thisX) {
// // right
// shapeArray[i].setW(shapeArray[i].getW() + 20);
// } else {
// // left
// shapeArray[i].setW(shapeArray[i].getW() - 20);
// }
// } else {
// if (moveX < thisX) {
// // 右下
// shapeArray[i].setW(shapeArray[i].getW() + 20);
// shapeArray[i].setH(shapeArray[i].getH() + 20);
// } else {
// // 左上
// shapeArray[i].setW(shapeArray[i].getW() - 20);
// shapeArray[i].setH(shapeArray[i].getH() - 20);
// }
// }
// panel.repaint();
// }