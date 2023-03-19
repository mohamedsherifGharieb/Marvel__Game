package Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import engine.Game;
import model.world.Champion;

public class thirdWindow extends JFrame implements ActionListener{
MYFrame frame;
JPanel panel1;
JPanel panel2;
JPanel panel3;
JLabel label1;
JLabel label2;
JLabel label3;
JLabel label4;
JTextField f1;
ArrayList<JButton> buttons1;
ArrayList<JButton> buttons2;
boolean flag1=false;
boolean flag2=false;
public thirdWindow(){
	 buttons1=new ArrayList<JButton>();
	 buttons2=new ArrayList<JButton>();
	 f1=new JTextField();
	 f1.setFocusable(false);
	 f1.setEditable(false);
	 f1.setBackground(Color.BLACK);
	 f1.setText("Choose Leaders for Both Players");
	 f1.setForeground(Color.WHITE);
	 f1.setHorizontalAlignment((int)JTextField.CENTER_ALIGNMENT);
	 frame=new MYFrame();
	 frame.setLayout(new BorderLayout());
	 panel1=new JPanel();
	 panel1.setLayout(new BorderLayout());
	 panel1.setPreferredSize(new Dimension(300,300));
	 panel1.setBackground(Color.black);
	 panel1.setLayout(new BorderLayout());
	 panel2=new JPanel();
	 panel2.setPreferredSize(new Dimension(300,300));
	 panel2.setBackground(Color.BLACK);
	 panel2.setLayout(new BorderLayout());
	 panel2.setLayout(new BorderLayout());
	 panel3=new JPanel();
	 panel3.setPreferredSize(new Dimension(100,100));
	 panel3.setLayout(new BorderLayout());
	 panel3.setBorder(BorderFactory.createLineBorder(Color.RED));
	 panel3.setBackground(Color.BLACK);
	 panel3.add(f1,BorderLayout.CENTER);
	 label1=new JLabel();
	 label1.setLayout(new GridLayout(0,3));
	 label1.setPreferredSize(new Dimension(200,200));
	 label2=new JLabel();
	 label2.setText(secondWindow.getFirst().getName());
	 label2.setPreferredSize(new Dimension(100,100));
	 label2.setForeground(Color.GREEN);
	 label2.setHorizontalTextPosition(JLabel.CENTER);
	 label2.setHorizontalAlignment(JLabel.CENTER);
	 label3=new JLabel();
	 label3.setPreferredSize(new Dimension(200,200));
	 label3.setLayout(new GridLayout(0,3));
	 label4=new JLabel();
	 label4.setPreferredSize(new Dimension(100,100));
	 label4.setText(secondWindow.getSecond().getName());
	 label4.setForeground(Color.BLUE);
	 label4.setHorizontalAlignment(JLabel.CENTER);
	 label4.setHorizontalTextPosition(JLabel.CENTER);
	 frame.add(panel1,BorderLayout.NORTH);
	 frame.add(panel2,BorderLayout.SOUTH);
	 frame.add(panel3,BorderLayout.CENTER);
     for(Champion c :secondWindow.getFirst().getTeam()){
              JButton Temp=new JButton();
              Temp.setBackground(Color.black);
              Temp.setForeground(Color.GREEN);
        	  Temp.setBorder(BorderFactory.createLineBorder(Color.GREEN));
              Temp.setPreferredSize(new Dimension(50,50));
              Temp.setFocusable(false);
              Temp.setText(c.getName());
              Temp.addActionListener(this);
              buttons1.add(Temp);
              label1.add(Temp);
     }
     for(Champion c :secondWindow.getSecond().getTeam()){
         JButton Temp=new JButton();
         Temp.setBackground(Color.black);
         Temp.setForeground(Color.blue);
         Temp.setBorder(BorderFactory.createLineBorder(Color.BLUE));
         Temp.setPreferredSize(new Dimension(50,50));
         Temp.setText(c.getName());
         Temp.setFocusable(false);
         Temp.addActionListener(this);
         buttons2.add(Temp);
         label3.add(Temp);
     }
	
     panel1.add(label2,BorderLayout.NORTH);
     panel1.add(label1,BorderLayout.SOUTH);
     panel2.add(label3,BorderLayout.NORTH);
     panel2.add(label4,BorderLayout.SOUTH);
     frame.setVisible(true);
}
@Override
public void actionPerformed(ActionEvent e){
	JButton b=(JButton) e.getSource();
	if(buttons1.contains(b)){
		for(int i=0;i<buttons1.size();i++){
			if(b.getText()==buttons1.get(i).getText()){
				secondWindow.getFirst().setLeader(secondWindow.getFirst().getTeam().get(i));
				b.setEnabled(false);
				flag1=true;
			}
			buttons1.get(i).setEnabled(false);
		}
		
	}
	else if(buttons2.contains(b)){
		for(int i=0;i<buttons2.size();i++){
			if(b.getText()==buttons2.get(i).getText()){
				secondWindow.getSecond().setLeader(secondWindow.getSecond().getTeam().get(i));
				b.setEnabled(false);
				flag2=true;
			}
			buttons2.get(i).setEnabled(false);
		}
		
	}
	if(flag1&&flag2==true){
		fourthWindow fourth=new fourthWindow();
		frame.dispose();
	}
}
}
