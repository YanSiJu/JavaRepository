package cn.csu.swing;

import javax.swing.*;
import java.awt.*;

public class saveImg extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JTextField jPathField;

	JTextField jNameField;

	JLabel pathLabel, nameLabel;
	JPanel jp1, jp2, jp3;
	JButton button, jb2;

	public saveImg() {

		// 设置文本域
		jPathField = new JTextField(15);
		jNameField = new JTextField(15);

		// 设置文本域大小
		jNameField.setPreferredSize(new Dimension(15, 30));
		jPathField.setPreferredSize(new Dimension(15, 30));

		// 设置默认路径
		jPathField.setText("");
		// 设置默认文件名
		jNameField.setText("");
		pathLabel = new JLabel("保存路径");
		nameLabel = new JLabel("文件名");
		nameLabel.setLocation(70, 50);

		// 保存按钮
		button = new JButton("保存 ");

		// 设置布局
		this.setLayout(new GridLayout(3, 1));
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();

		jp1.add(pathLabel);
		jp1.add(jPathField);// 第一块面板添加用户名和文本框

		jp2.add(nameLabel);
		jp2.add(jNameField);// 第二块面板添加密码和密码输入框

		jp3.add(button);

		this.add(jp1);
		this.add(jp2);
		this.add(jp3);

		this.setSize(500, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("保存文件 ");

	}

	public static void main(String[] args) {
		new saveImg();
	}
}
