import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ButtonListener_blue implements ActionListener{
	JFrame mjf;
	public ButtonListener_blue(JFrame mjf){
		this.mjf = mjf;
	}
	public void actionPerformed(ActionEvent arg0) {		
		mjf.setTitle("背景是蓝色");
		mjf.getContentPane().setBackground(Color.blue);
	}

}
