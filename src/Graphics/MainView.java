package Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.http.WebSocket.Listener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainView  implements ActionListener{
	JButton Button;
	MYFrame frame;
	JButton exit;
  public MainView(){
	  frame = new MYFrame();
	  frame.setLayout(new BorderLayout());
	  
	  Button =new JButton();
	  exit = new JButton ();
	  
	  ImageIcon image2 =new ImageIcon("downlaod.png");

	  JLabel label=new JLabel();
	  label.setIcon(image2);
	  
	  JPanel panel1 =new JPanel();
	  JPanel panel2=new JPanel();
	  
	  panel1.setPreferredSize(new Dimension(400,400));
	  panel1.setBackground(Color.black);
	  panel1.setLayout(null);

	  panel2.setPreferredSize(new Dimension(400,400));	
	  panel2.setBackground(Color.black);
	  panel2.setLayout(new BorderLayout());


	  Button.setBounds(650,100,200,100);
	  Button.setText("Start Game");
	  Button.setForeground(Color.WHITE);
	  Button.setBackground(Color.BLACK);
	  Button.setBorder(BorderFactory.createLineBorder(Color.RED));
	  Button.setFocusable(false);
	  Button.addActionListener(this);

	  
	  exit.setBounds(650,300,200,100);
	  exit.setText("Exit");
	  exit.setForeground(Color.WHITE);
	  exit.setBackground(Color.BLACK);
	  exit.setBorder(BorderFactory.createLineBorder(Color.RED));
	  exit.setFocusable(false);
	  exit.addActionListener(this);

	  panel1.add(Button);
	  panel1.add(exit);

	  label.setText("Welcome to Marvel : Ultimate War");
	  label.setForeground(Color.RED);
	  label.setVerticalTextPosition(JLabel.BOTTOM);
	  label.setHorizontalTextPosition(JLabel.CENTER);
	  label.setIconTextGap(-20);
	  label.setHorizontalAlignment(JLabel.CENTER);
	  label.setFont(new Font("",Font.BOLD ,50));
	  
	  panel2.add(label,BorderLayout.SOUTH);
	  
	  frame.add(panel1,BorderLayout.NORTH);
	  frame.add(panel2,BorderLayout.SOUTH);
	  frame.revalidate();
	  frame.repaint();
  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
public static void main(String [] args){
	MainView  x = new MainView();
}




@Override
public void actionPerformed(ActionEvent e) {
 
  if(e.getSource()==Button) {
	  try {
		secondWindow secondWindow=new secondWindow();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	  frame.dispose();
	  
  }else if (e.getSource() == exit) {
	  frame.dispose();
  }
	
}
}
