package cn.ccsu.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JColorChooserDemo {

	public JColorChooserDemo() {
		
	}
	
	 public static void main(String[] args) {  
		  
	        JFrame frame = new JFrame("JColorChooserDemo");  
	          
	        MyPanel panel = new MyPanel();  
	        frame.add(panel);  
	          
	        frame.pack();  
	        frame.setLocation(300, 200);  
	        frame.setVisible(true);  
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    }  
	}  
	  
	class MyPanel extends JPanel implements ActionListener {  
	  
	    private static final long serialVersionUID = 1L;  
	    private JButton button,rgb,red,green,blue;  
	    private Color color = new Color(255, 51, 150);  
	  
	    public MyPanel() {  
	  
	        button = new JButton("Get Color");  
	        rgb = new JButton("RGB: ");  
	        red = new JButton("Red: ");  
	        green = new JButton("Green: ");  
	        blue = new JButton("Blue: ");  
	        button.addActionListener(this);  
	  
	        setPreferredSize(new Dimension(550, 250));  
	        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));  
	        setBackground(color);  
	        add(button);  
	        add(rgb);  
	        add(red);  
	        add(green);  
	        add(blue);  
	    }  
	  
	    public void actionPerformed(ActionEvent e) {  
	  
	        color = JColorChooser.showDialog(this, "Choose Color", color);  
	  
	        if (color != null) {  
	            setBackground(color);  
	            button.setText("Get again");  
	            rgb.setText("RGB: " + color.getRGB());  
	            red.setText("Red: " + color.getRed());  
	            green.setText("Green: " + color.getGreen());  
	            blue.setText("Blue: " + color.getBlue());  
	        }  
	    }

		

}
