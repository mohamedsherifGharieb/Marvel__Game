package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class Start extends JFrame {
	JFrame one;
	JPanel panel;
	JLabel label ;
public Start() {
	one = new JFrame();
	panel = new JPanel();
	panel.setLayout(new BorderLayout());
	label = new JLabel("Welcome to Marvel : Ultimate War");
	JButton button = new JButton();
	ImageIcon image = new ImageIcon("downlaod.png");
	label.setIcon(image);
	label.setVerticalTextPosition(JLabel.TOP);
	label.setHorizontalTextPosition(JLabel.CENTER);
	label.setVerticalAlignment(JLabel.CENTER);
	label.setHorizontalAlignment(JLabel.CENTER);
	one.setBackground(Color.black);
	one.setSize(200, 200);
	panel.add(label,BorderLayout.CENTER);
	panel.add(button,BorderLayout.SOUTH);
	one.add(panel);
	panel.setBackground(Color.black);
	label.setForeground(Color.red);
	label.setFont(new Font(" ",0,20));
	label.setSize(100,100);
	one.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	one.setVisible(true);
	one.revalidate();
	one.repaint();
	one.pack();
	
}
public static void main(String[] args) {
	new Start();
}
}
