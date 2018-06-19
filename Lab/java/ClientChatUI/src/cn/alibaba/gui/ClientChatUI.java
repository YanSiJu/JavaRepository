package cn.alibaba.gui;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class ClientChatUI extends JFrame{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	 private JTextArea jta_recive;
	 private JComboBox jcb_users;
	 JTextField jtf_send;
	 
	 public static void main(String[] args)
	 {
	  new ClientChatUI("Hello");
	 }
	 
	 ClientChatUI(String userName)
	 {
	  this.userName = userName;
	  initUI();
	  showFrame();
	 }
	 public void showFrame()
	 {
	  this.setTitle("netjava：欢迎" + this.userName);
	  this.setSize(300, 500);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setVisible(true);
	 }
	 private void initUI()
	 {
	  this.setLayout(new FlowLayout());
	  
	  JPanel jp=new JPanel();
	  
	  JLabel la_nameJLabel = new JLabel("消息：");
	  JLabel la_users = new JLabel("内容：");
	  jtf_send = new JTextField(20);
	  JButton bu_send = new JButton("发送");
	  
	  jcb_users = new JComboBox();
	  jcb_users.addItem("张三");
	  jcb_users.addItem("李四");
	  
	  jta_recive = new JTextArea(15, 25);
	  jta_recive.setLineWrap(true);    //消息显示到最右边时自动换行
	  JScrollPane jsPane = new JScrollPane(jta_recive);    //将消息框添加进滚动条界面
	  jp.setLayout(new GridLayout(1,1));    //滚动条界面里用只有一个组件，所以设置成行1，列1
	  jp.add(jsPane);    //将滚动条界面添加进JPanel
	  jta_recive.setEditable(false);  //消息框不可编辑
	  
	  add(la_nameJLabel);
	  add(jp);
	  add(la_users);
	  add(jtf_send);
	  add(jcb_users);
	  add(bu_send);
	  
	  bu_send.addActionListener(new showAct());
	 }
	 class showAct implements ActionListener{
		 public void actionPerformed(ActionEvent e)
		 {
		   String reciver = (String)jcb_users.getSelectedItem();
		   reciver = reciver.trim();
		   String content = jtf_send.getText();
		   String message = userName+"对"+reciver+"说："+content+"\r\n";
		   jta_recive.append(message);
		   jtf_send.setText("");
		 }
	}
}