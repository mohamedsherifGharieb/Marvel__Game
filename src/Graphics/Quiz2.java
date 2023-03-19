package Graphics;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import engine.Game;
import engine.Player;
import model.world.Champion;

public class Quiz2 	extends JFrame implements ActionListener {
	Game g ;
	JPanel all;
	JButton f;
	JButton s;
	JButton t;
	Champion ff;
	Champion ss;
	Champion tt;
	ArrayList <Champion> c;
public Quiz2 () {
	g = new Game(new Player("Ff"), new Player ("feger"));
	try {
		g.loadChampions("Champions.csv");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	c= g.getAvailableChampions();
	this.setSize(new Dimension (500,500));
	int i = (int) (Math.random() * c.size()) ;
	ff = c.get(i);
	all = new JPanel ();
	f = new JButton ();
	f.addActionListener(this);
	f.setText(ff.getName() + " " + ff.getCurrentHP());
	int m = (int) (Math.random() * c.size()) ;
	s = new JButton ();
	s.addActionListener(this);
	ss = c.get(m);
	s.setText(ss.getName() + " " + ss.getCurrentHP());
	int n = (int) (Math.random() * c.size()) ;
	t = new JButton ();
	t.addActionListener(this);
	tt = c.get(n);
	t.setText(tt.getName() + " " + tt.getCurrentHP());
	all.setLayout(new GridLayout(0,1));
	all.add(f);
	all.add(s);
	all.add(t);
	this.add(all);
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.validate();
	this.revalidate();
	this.repaint();

	
}
public static void main(String[] args) {
	new Quiz2();
}
@Override
public void actionPerformed(ActionEvent e) {	
	if (e.getSource()== f) {
		ff.setCurrentHP(ff.getCurrentHP() - 500);
		f.setText(ff.getName() + " " + ff.getCurrentHP());
	}
	if (e.getSource()== s) {

		ss.setCurrentHP(ss.getCurrentHP() - 500);
		s.setText(ss.getName() + " " + ss.getCurrentHP());
	}
	if (e.getSource()== t) {
		tt.setCurrentHP(tt.getCurrentHP() - 500);
		t.setText(tt.getName() + " " + tt.getCurrentHP());
	}
}
}
