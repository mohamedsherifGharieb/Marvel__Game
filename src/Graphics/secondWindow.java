package Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import engine.Game;
import engine.Player;
import model.world.Champion;

public class secondWindow extends JFrame implements ActionListener, MouseListener{
MYFrame frame;
JTextField f1;
JTextField f2;
JTextField f3;
JButton Button;
JPanel Panel2;
JPanel Panel3;
int x=0;
private static Player First;
private static Player Second;
int count=0;
ImageIcon image1;
ImageIcon image2;
ImageIcon image3;
ImageIcon image4;
ImageIcon image5;
ImageIcon image6;
ImageIcon image7;
ImageIcon image8;
ImageIcon image9;
ImageIcon image10;
ImageIcon image11;
ImageIcon image12;
ImageIcon image13;
ImageIcon image14;
ImageIcon image15;
ArrayList<ImageIcon> images;
ArrayList<JButton> buttons;
public static Player getFirst() {
	return First;
}
public static Player getSecond() {
	return Second;
}

JLabel label=new JLabel();
JLabel label3=new JLabel();
JLabel label2=new JLabel();
	public secondWindow() throws IOException{
		try {
			Game.loadAbilities("Abilities.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Game.loadChampions("Champions.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Panel3=new JPanel();
		Panel2=new JPanel();
		Button=new JButton();
		JPanel Panel1=new JPanel();
		frame=new MYFrame();
		frame.setLayout(new BorderLayout());
		f1=new JTextField();
		f1.setBackground(Color.black);
		f1.setBorder(BorderFactory.createLineBorder(Color.RED));
		f1.setForeground(Color.white);
		f2=new JTextField();
		f2.setBackground(Color.black);
		f2.setBorder(BorderFactory.createLineBorder(Color.RED));
		f2.setForeground(Color.white);
		f1.setPreferredSize(new Dimension(90,50));
		f2.setPreferredSize(new Dimension(90,50));
		f1.setText("Player1");
		f2.setText("Player2");
		Button.setPreferredSize(new Dimension(80,40));
		Button.setText("Submit");
		Button.addActionListener(this);
		Button.setForeground(Color.WHITE);
		Button.setBackground(Color.BLACK);
		Button.setBorder(BorderFactory.createLineBorder(Color.RED));
		Button.setFocusable(false);
		Panel1.setPreferredSize(new Dimension(80,80));
		Panel1.setLayout(new FlowLayout());
		Panel1.add(Button);
		Panel1.add(f1);
		Panel1.add(f2);

		Panel1.setBackground(Color.BLACK);
		f3=new JTextField();
		f3.setVisible(false);
		f3.setBorder(BorderFactory.createLineBorder(Color.RED));
		f3.setPreferredSize(new Dimension(110,50));
		f3.setEditable(false);
		f3.setForeground(Color.white);
		f3.setBackground(Color.black);
		
		Panel1.add(f3);
		 images=new ArrayList<ImageIcon>();
		 image1 =new ImageIcon("CaptainAmerica.png");images.add(image1);
		 image2 =new ImageIcon("Deadpool.png");images.add(image2);
		 image3 =new ImageIcon("DR.png");images.add(image3);
		 image4 =new ImageIcon("electro.png");images.add(image4);
		 image5 =new ImageIcon("GhostRider.png");images.add(image5);
		 image6 =new ImageIcon("Hela.png");images.add(image6);
		 image7 =new ImageIcon("Hulk.png");images.add(image7);
		 image8 =new ImageIcon("iceman.png");images.add(image8);
		 image9 =new ImageIcon("IM.png");images.add(image9);
		 image10 =new ImageIcon("loki.png");images.add(image10);
		 image11 =new ImageIcon("quicksilver.png");images.add(image11);
		 image12 =new ImageIcon("spider.png");images.add(image12);
		 image13 =new ImageIcon("thor.png");images.add(image13);
		 image14 =new ImageIcon("venom.png");images.add(image14);
		 image15 =new ImageIcon("yellowJacket.png");images.add(image15);
		
		
		
	    buttons=new ArrayList<JButton>();
	    int z=0;
		for(Champion c :Game.getAvailableChampions()){
			JButton b = new JButton();
			
			b.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e){
					
				    label.setIcon(getImage(c));
					label2.setText("hp:"+c.getMaxHP()+"           "+"Mana:"+c.getMana()+"        "+"speed:"+c.getSpeed()+"        "+"Action:"+c.getMaxActionPointsPerTurn()+"       "+"attack Damage &&Range:"+c.getAttackDamage()+"/"+c.getAttackRange()+"");
					label3.setText("Ability1:  "+(c.getAbilities().get(0).getName())+"  "+"/Ability2:   "+c.getAbilities().get(1).getName()+"   "+"/Ability3:  "+c.getAbilities().get(2).getName()+" ");
				}
				
				public void mouseExited(MouseEvent e){
					label.setIcon(null);
					label2.setText("");
					label3.setText("");
				}
			});
			buttons.add(b);
			JButton temp=buttons.get(z);
			temp.addActionListener(this);
			temp.setText(c.getName());
			temp.setBackground(Color.BLACK);
			temp.setForeground(Color.WHITE);
			temp.setBorder(BorderFactory.createLineBorder(Color.RED));
			temp.setFocusable(false);
			temp.setPreferredSize(new Dimension(30,30));
			z++;
		}
		
 
		Panel2.setBackground(Color.black);
		Panel2.setPreferredSize(new Dimension(200,200));
		Panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		Panel2.setLayout(new GridLayout(0,3));
		for(int i =0;i<buttons.size();i++){
			Panel2.add(buttons.get(i));
		}
		Panel2.setVisible(false);

		
		
		
        Panel3.setBorder(BorderFactory.createLineBorder(Color.RED));
        Panel3.setBackground(Color.black);
		Panel3.setPreferredSize(new Dimension(500,500));
		Panel3.setLayout(new BorderLayout());
		label2.setBorder(BorderFactory.createLineBorder(Color.RED));
		label.setPreferredSize(new Dimension(300,300));
		label2.setPreferredSize(new Dimension(200,200));
		label3.setPreferredSize(new Dimension(100,100));
		Panel3.add(label,BorderLayout.NORTH);
		Panel3.add(label2,BorderLayout.CENTER);
		Panel3.add(label3,BorderLayout.SOUTH);	
		label2.setForeground(Color.RED);
		label2.setHorizontalTextPosition(JLabel.CENTER);
		label2.setHorizontalAlignment(JLabel.CENTER);
		label2.setLayout(new FlowLayout());
		
		label3.setForeground(Color.WHITE);
		label3.setHorizontalAlignment(JLabel.CENTER);
		label3.setHorizontalTextPosition(JLabel.CENTER);
		
		Panel3.setVisible(false);
		
		
		
		
		
		
		
		
		
		
		
		
		frame.add(Panel1,BorderLayout.NORTH);
		frame.add(Panel2,BorderLayout.SOUTH);
		frame.add(Panel3,BorderLayout.CENTER);
		
	}
public ImageIcon getImage(Champion C){
	   for(int i=0;i<Game.getAvailableChampions().size();i++){
		   Champion C1=Game.getAvailableChampions().get(i);
		   if(C.getName()==C1.getName()){
			   x=i;
			   break;
		   }
		   
	   }
	return(images.get(x));
	}
public void actionPerformed(ActionEvent e){
	if(count<2){
		f3.setVisible(true);
		f3.setForeground(Color.green);
		f3.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		f3.setText("First Player Team");
		//f3.setBorder(BorderFactory.createLineBorder(Color.RED));
	}
	if(count>=2) {
		f3.setVisible(true);
		f3.setForeground(Color.BLUE);
		f3.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		f3.setText("Second Player Team");
	//	f3.setBorder(BorderFactory.createLineBorder(Color.RED));
	}
		
		JButton b= (JButton) e.getSource();
		if(buttons.contains(b)){
			for(int i=0;i<buttons.size();i++){
				
				if(b.getText()==buttons.get(i).getText()){
					Champion c = null;
					c = Game.getAvailableChampions().get(i);
					label.setIcon(images.get(i));
					
					buttons.get(i).setEnabled(false);
					label2.setText("hp:"+c.getMaxHP()+"           "+"Mana:"+c.getMana()+"        "+"speed:"+c.getSpeed()+"        "+"Action:"+c.getMaxActionPointsPerTurn()+"       "+"attack Damage &&Range:"+c.getAttackDamage()+"/"+c.getAttackRange()+"");
					label3.setText("Ability1:  "+(c.getAbilities().get(0).getName())+"  "+"/Ability2:   "+c.getAbilities().get(1).getName()+"   "+"/Ability3:  "+c.getAbilities().get(2).getName()+" ");
					if(count<=2){
						First.getTeam().add(Game.getAvailableChampions().get(i));
						break;
					}
					else if(count>2) {
						Second.getTeam().add(Game.getAvailableChampions().get(i));
						break;
					}
				}
			}
		  count++;
		}
		else if(b==Button){
			Panel3.setVisible(true);
			Panel2.setVisible(true);
			f1.setEditable(false);
			f2.setEditable(false);
			Button.setEnabled(false);
			First=new Player(f1.getText());
			Second =new Player(f2.getText());
			
		}
		

	if(count==6){
		frame.dispose();
		thirdWindow GameStart =new thirdWindow();
		//this.dispose();
	}
}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}}
