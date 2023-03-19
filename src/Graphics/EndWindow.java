package Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EndWindow extends JFrame implements ActionListener {
private MYFrame frame;
private JButton confirm;
private MainView main;
private JPanel panel ;
private JPanel panel2 ;
private JPanel panel3 ;
private JLabel label;
public EndWindow() {
	frame=new MYFrame();
	frame.setLayout(new BorderLayout());
	frame.setBackground(Color.BLACK);
	confirm = new JButton();
	confirm.setText("Main Menu");
	confirm.setFocusable(false);
	confirm.setBackground(Color.BLACK);
	confirm.setForeground(Color.WHITE);
	confirm.setBorder(BorderFactory.createLineBorder(Color.RED));
	confirm.setBounds(650,100,200,100);
	confirm.addActionListener(this);
	panel = new JPanel();
	panel.setPreferredSize(new Dimension(500,500));
	panel.setBackground(Color.black);
	panel.setLayout(null);
//	panel.setLayout(new BorderLayout());
	panel2 = new JPanel();
	panel2.setPreferredSize(new Dimension(100,100));
	panel2.setBackground(Color.black);
	label = new JLabel();
	//label.setText("GAME OVER !" + "\n" + "Ahmed " + "is the winner");
	label.setForeground(Color.RED);
	label.setVerticalAlignment(JLabel.CENTER);
	label.setFont(new Font(" ", Font.ITALIC,55));
	if (secondWindow.getSecond().getTeam().size()==0) {
	label.setText("GAME OVER !" + "\n" + secondWindow.getFirst().getName() + "is the winner");
	}else {
		label.setText("GAME OVER !" + "\n" + secondWindow.getSecond().getName() + "is the winner");
	}
	panel2.add(label);
	//panel.add(panel2,BorderLayout.SOUTH);
	panel.add(confirm/*,BorderLayout.NORTH*/);
	frame.add(panel2,BorderLayout.CENTER);
	frame.add(panel,BorderLayout.NORTH);
	frame.setVisible(true);
	frame.revalidate();
	frame.repaint();
	
	
}
@Override
public void actionPerformed(ActionEvent e) {
	if (e.getSource() == (JButton) confirm) {
		main = new MainView();
		frame.dispose();
	}
}

}
