package Graphics;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MYFrame extends JFrame{

	public MYFrame() {
		this.setBackground(Color.black);
		  ImageIcon image1 =new ImageIcon("H.png");
          this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          this.setExtendedState(JFrame.MAXIMIZED_BOTH);	
		  this.setTitle("Marvel");
		  this.setIconImage(image1.getImage());
		  this.setVisible(true);
		  this.setResizable(true);
		  this.validate();
		  this.repaint();
		 // this.pack();
	}
	public static void main(String[] args) {
		MYFrame Frame=new MYFrame();
	}
	

}