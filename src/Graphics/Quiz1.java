package Graphics;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import engine.Game;
import model.abilities.Ability;
import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;

public class Quiz1 extends JFrame implements ActionListener {
	JButton y ;
	JButton z;
	JButton r;
	JButton n ;
	ArrayList <Ability> a ;
	Ability b ;
	Game g;
public Quiz1() {
		try {
			g.loadAbilities("Abilities.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 this.setSize(new Dimension (400,500));

	JPanel panel =  new JPanel();
	panel.setLayout(new GridLayout(0,2));
	a = g.getAvailableAbilities();
 	int i = (int) (Math.random() * a.size());
 	b = a.get(i);

	 y = new JButton();
	 y.setText(b.getName());
	 z = new JButton();
	 if(a.get(i)instanceof DamagingAbility) {
		 z.setText("Damaging");
	 }else 	 if(a.get(i)instanceof HealingAbility) {
		 z.setText("Healing");
	 }else 	 if(a.get(i)instanceof CrowdControlAbility) {
		 z.setText("cc");
	 }	 
	 r = new JButton();
	 r.setText("" + i);
	 n = new JButton();
	 n.setText("next");
	n.addActionListener(this);
	this.setTitle("Quiz");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	panel.add(y);
	panel.add(z);
	panel.add(r);
	panel.add(n);

	this.add(panel);
	this.setVisible(true);
	this.validate();
	this.repaint();
}
public static void main(String[] args) {
	Quiz1 x = new Quiz1();

}
@Override
public void actionPerformed(ActionEvent e) {
if (e.getSource() == n) {
	int i = (int) (Math.random() * a.size()) ;
	 y.setText(a.get(i).getName());
	 if(a.get(i)instanceof DamagingAbility) {
		 z.setText("Damaging");
	 }else 	 if(a.get(i)instanceof HealingAbility) {
		 z.setText("Healing");
	 }else 	 if(a.get(i)instanceof CrowdControlAbility) {
		 z.setText("cc");
	 }	 r.setText("" + i);

	 


}
}
}
