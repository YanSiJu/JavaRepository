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

	private String type = "Ǧ��";// ����ͼ�����ԣ������洢�û�ѡ���ͼ��
	private Color color = Color.black;// ������ɫ���ԣ������洢�û�ѡ�����ɫ
	private Graphics g;// ����Graphics������Ķ���
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
	private ShapeFactory shape;// ����ͼ�ζ���
	// private ShapeFactory[] shapeArray;// �����洢ͼ�ζ��������
	private List<ShapeFactory> list;
	private int number = 0;// ��¼����������¼�Ѿ��洢��ͼ�θ�����
	private String colorStr;
	private JPanel panel;
	@SuppressWarnings("unused")
	private JFrame frame;
	private String path;
	private String name;
	Random r = new Random();
	public BasicStroke s1;// ���ʴ�С
	BasicStroke s = new BasicStroke();

	/**
	 * 1 ���췽��
	 * 
	 * @param g�Ǵ�DrawMain��Ĵ����ϴ��ݹ����Ļ��ʶ���
	 * @param shapeArray�Ǵ�DrawMain�ഫ�ݹ����Ĵ洢ͼ�ε��������
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
		// �����ı���
		JTextField jPathField = new JTextField(15);
		JTextField jNameField = new JTextField(15);

		// �����ı����С
		jNameField.setPreferredSize(new Dimension(15, 40));
		jPathField.setPreferredSize(new Dimension(50, 40));

		jNameField.setFont(new Font("1", 20, 20));
		jPathField.setText("C:\\\\Users\\\\Bill\\\\Desktop\\\\");
		jPathField.setFont(new Font("C:\\Users\\Bill\\Desktop\\", 20, 20));

		// ����Ĭ��·��
		// ����Ĭ���ļ���
		jNameField.setText("1");
		JLabel pathLabel = new JLabel("����·��");
		JLabel nameLabel = new JLabel("�ļ���");
		nameLabel.setLocation(70, 50);

		// ���水ť
		JButton button = new JButton("����ͼƬ");
		button.addActionListener(this);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				path = jPathField.getText();
				name = jNameField.getText();
				save();
			}
		});

		// ���ò���
		frame.setLayout(new GridLayout(3, 1));
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();

		jp1.add(pathLabel);
		jp1.add(jPathField);// ��һ���������û������ı���

		jp2.add(nameLabel);
		jp2.add(jNameField);// �ڶ�����������������������

		jp3.add(button);

		frame.add(jp1);
		frame.add(jp2);
		frame.add(jp3);

		frame.setSize(500, 200);
		frame.setLocation(1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("�����ļ� ");

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
			// Y ��20��Χ���ƶ���Ϊ��ˮƽ�ƶ�
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
				// ����
				while (it.hasNext()) {
					ShapeFactory s = it.next();
					s.setW(s.getW() + 10);
					s.setH(s.getH() + 10);
				}
			} else {
				// ����
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
	 * ��дActionListener�ӿ��е�actionPerformed���󷽷���
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();// ��ȡ�¼�Դ����
		String text = button.getText();// ��ȡ��ť�ϵ�������Ϣ
		if (text == null || text.equals("")) {// �ж��Ƿ���������ɫ��ť
			color = button.getBackground();// ��ȡ��ť�ı�����ɫ
			colorStr = button.getToolTipText();
		} else {
			type = button.getText();// ��ȡ��ť�ϵ�������Ϣ
			if (type.equals("�����ļ�")) {
				saveImgFrame();
			}
		}
	}

	/**
	 * �������¼�Դ�����Ϸ�����갴�����¶���ʱִ�д˷���
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// 2.����д�İ��¶������ͷŶ������¼��������У��ڰ��·����л�ȡ��������ֵ
		x1 = e.getX();
		y1 = e.getY();
		if (type.equals("����")) {
			Point point = MouseInfo.getPointerInfo().getLocation();
			moveX = point.x;
			moveY = point.y;
		}

	}

	/**
	 * �������¼�Դ�����Ϸ�����갴���ͷŶ���ʱִ�д˷���
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// ����д�İ��¶������ͷŶ������¼��������У���ȡ�ͷŵ�����ֵ��
		x2 = e.getX();
		y2 = e.getY();
		// 2.֮����ݰ��º��ͷŵ�����ֵ���Լ�ͼ�κ���ɫ��ʹ��Graphics�����ƶ�Ӧ��ͼ�Ρ�
		if (type.equals("ֱ��")) {

			// ����������ʵ����ͼ�ζ���
			shape = new LineFactory(this);
			// ����ͼ�εĻ�ͼ����
			shape.draw((Graphics2D) g);
			saveShape();
		} else if (type.equals("����")) {
			Point point = MouseInfo.getPointerInfo().getLocation();
			int thisX = point.x;
			int thisY = point.y;
			zoom(thisX, thisY);
		} else if (type.equals("Բ�Ǿ���")) {
			shape = new RoundRectFactory(this, 30, 30);
			shape.draw((Graphics2D) g);
			saveShape();
		} else if (type.equals("���Բ")) {
			shape = new CircleFactory(this);
			shape.draw((Graphics2D) g);
			saveShape();
		}
	}

	/**
	 * ������ڴ����ϰ��°��������϶�ʱִ�д˷���
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();
		Graphics2D g2d = (Graphics2D) g;
		if (type.equals("Ǧ��")) {
			// ����������ʵ����ͼ�ζ���
			shape = new LineFactory(this);
			// ����ͼ�εĻ�ͼ����
			shape.draw(g2d);
			x1 = x2;
			y1 = y2;
			saveShape();
		} else if (type.equals("��Ƥ")) {
			shape = new EraserFactory(this);
			shape.draw(g2d);
			x1 = x2;
			y1 = y2;
			saveShape();
		} else if (type.equals("������")) {
			shape = new FilledRectFactory(this);
			shape.draw(g2d);
			saveShape();
		} /*
			 * else if (type.equals("����")) { shape = new StringFactory(this);
			 * shape.draw(g2d); saveShape(); }
			 */else if (type.equals("3d����")) {
			shape = new ThreeDRectFactory(this);
			shape.draw(g2d);
			saveShape();
		}

	}

	/**
	 * ������ڴ������ƶ����ʱִ�д˷���
	 */
	@Override
	public void mouseMoved(MouseEvent e) {

	}

	/**
	 * �������¼�Դ�����Ϸ��������(���º��ͷŵĶ���������ͬһ��λ����)����ʱִ�д˷���
	 */
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	/**
	 * ��������������¼�Դ������ʱִ�д˷���
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	/**
	 * �����������뿪�¼�Դ������ʱִ�д˷���
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
// // Y ��20��Χ���ƶ���Ϊ��ˮƽ�ƶ�
// if (moveX < thisX) {
// // right
// shapeArray[i].setW(shapeArray[i].getW() + 20);
// } else {
// // left
// shapeArray[i].setW(shapeArray[i].getW() - 20);
// }
// } else {
// if (moveX < thisX) {
// // ����
// shapeArray[i].setW(shapeArray[i].getW() + 20);
// shapeArray[i].setH(shapeArray[i].getH() + 20);
// } else {
// // ����
// shapeArray[i].setW(shapeArray[i].getW() - 20);
// shapeArray[i].setH(shapeArray[i].getH() - 20);
// }
// }
// panel.repaint();
// }