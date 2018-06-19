import java.awt.FlowLayout;
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JFrame;

public class myJFrame {		
	public static void main(String[] args) {
		JFrame jf = new JFrame("myJFrame");
		jf.setSize(400,300);
		jf.setLocation(200,300);
		
		jf.setLayout(new FlowLayout());		
		JButton jb_red = new JButton("红色");
		jb_red.addActionListener(new ButtonListener_red(jf));
		jf.add(jb_red);
		
		JButton jb_white = new JButton("白色");
		jb_white.addActionListener(new ButtonListener_white(jf));
		jf.add(jb_white);
		
		JButton jb_blue = new JButton("蓝色");
		jb_blue.addActionListener(new ButtonListener_blue(jf));
		jf.add(jb_blue);
		
		jf.setVisible(true);
	}

}
