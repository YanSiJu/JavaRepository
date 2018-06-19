import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ButtonListener_white implements ActionListener{
	JFrame mjf;
	public ButtonListener_white(JFrame mjf){
		this.mjf = mjf;
	}
	public void actionPerformed(ActionEvent arg0) {
		mjf.setTitle("背景是白色");
		mjf.getContentPane().setBackground(Color.white);
	}

}
