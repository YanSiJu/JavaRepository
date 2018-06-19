import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ButtonListener_red implements ActionListener{
	JFrame mjf;
	public ButtonListener_red(JFrame mjf){
		this.mjf = mjf;
	}
	public void actionPerformed(ActionEvent arg0) {		
		mjf.setTitle("背景是红色");
		//mjf.setBackground(Color.red);
		mjf.getContentPane().setBackground(Color.red);
	}

}
