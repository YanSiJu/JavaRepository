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

		// �����ı���
		jPathField = new JTextField(15);
		jNameField = new JTextField(15);

		// �����ı����С
		jNameField.setPreferredSize(new Dimension(15, 30));
		jPathField.setPreferredSize(new Dimension(15, 30));

		// ����Ĭ��·��
		jPathField.setText("");
		// ����Ĭ���ļ���
		jNameField.setText("");
		pathLabel = new JLabel("����·��");
		nameLabel = new JLabel("�ļ���");
		nameLabel.setLocation(70, 50);

		// ���水ť
		button = new JButton("���� ");

		// ���ò���
		this.setLayout(new GridLayout(3, 1));
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();

		jp1.add(pathLabel);
		jp1.add(jPathField);// ��һ���������û������ı���

		jp2.add(nameLabel);
		jp2.add(jNameField);// �ڶ�����������������������

		jp3.add(button);

		this.add(jp1);
		this.add(jp2);
		this.add(jp3);

		this.setSize(500, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("�����ļ� ");

	}

	public static void main(String[] args) {
		new saveImg();
	}
}
