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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.Ability;
import Controller.AttackPerformed;
import Controller.MovePerform;
import engine.Game;
import engine.Player;
import engine.PriorityQueue;
import model.abilities.AreaOfEffect;
import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.effects.Effect;
import model.world.AntiHero;
import model.world.Champion;
import model.world.Cover;
import model.world.Direction;
import model.world.Hero;
import model.world.Villain;

public class fourthWindow extends JFrame implements ActionListener{
private MYFrame frame;
private JButton[][] Buttons; 
private JButton Attack;
private JButton Move;
private JLabel Controller;
private Object[][] board;
private JPanel B1;
private JPanel B2;
private JPanel TurnOrder;
private static Game game;
private JButton UP;
private JButton DOWN;
private JButton LEFT;
private JButton RIGHT;
private JButton useLeaderAbility;
private JButton EndTurn;
private JLabel ChampionInfo;
private JButton Ability1;
private JButton Ability2;
private JButton Ability3;
private JButton FirstTeam;
private JButton SecondTeam;
private JButton Cast;
private boolean isMoveClick =false;
private boolean isAttackClick =false;
private boolean isCastClick = false;
private Boolean S1=false;
private Boolean S2=false;
private Boolean S3=false;
private Boolean D1=false;
private Boolean D2=false;
private Boolean D3=false;
private JTextField PlayerName;
private JButton Disarm;
private boolean Disarm1=false;
public fourthWindow(){
	 game=new Game(secondWindow.getFirst(),secondWindow.getSecond());
     frame=new MYFrame();
	 Disarm =new JButton();
	 Disarm.setText("Punch");
	 Disarm.setFocusable(false);
	 Disarm.setPreferredSize(new Dimension(20,50));
	 Disarm.addActionListener(this);
	 Disarm.setVisible(true);
     Buttons= new JButton[5][5];
     JPanel  Show=new JPanel();
  //   Show.setBorder(BorderFactory.createLineBorder(Color.black));
     Show.setPreferredSize(new Dimension(200,600));
   //  Show.setBackground(Color.red);
	 Controller =new JLabel();
	 Controller.setPreferredSize(new Dimension(50,50));
	 Controller.setBorder(BorderFactory.createLineBorder(Color.black));
	 UP=new JButton();
	 UP.setText("UP");
	 UP.setBorder(BorderFactory.createLineBorder(Color.RED));
	 UP.setBackground(Color.black);
	 UP.setForeground(Color.white);
	 UP.setPreferredSize(new Dimension(50,30));
	 UP.addActionListener(this);
	 UP.setFocusable(false);
	 DOWN=new JButton();
	 DOWN.setText("DOWN");
	 DOWN.setBorder(BorderFactory.createLineBorder(Color.RED));
	 DOWN.setBackground(Color.black);
	 DOWN.setForeground(Color.white);
	 DOWN.setPreferredSize(new Dimension(50,30));
	 DOWN.addActionListener(this);
	 DOWN.setFocusable(false);
	 LEFT=new JButton();
	 LEFT.setText("LEFT");
	 LEFT.setBorder(BorderFactory.createLineBorder(Color.RED));
	 LEFT.setBackground(Color.black);
	 LEFT.setForeground(Color.white);
	 LEFT.setPreferredSize(new Dimension(70,50));
	 LEFT.addActionListener(this);
	 LEFT.setFocusable(false);
	 RIGHT=new JButton();
	 RIGHT.setText("RIGHT");
	 RIGHT.setBorder(BorderFactory.createLineBorder(Color.RED));
	 RIGHT.setBackground(Color.black);
	 RIGHT.setForeground(Color.white);
	 RIGHT.setPreferredSize(new Dimension(70,50));
	 RIGHT.addActionListener(this);
	 RIGHT.setFocusable(false);
	 Cast=new JButton();
	 Cast.setBorder(BorderFactory.createLineBorder(Color.RED));
	 Cast.setBackground(Color.black);
	 Cast.setForeground(Color.white);
	 Cast.setPreferredSize(new Dimension(5,5));
	 Cast.addActionListener(this);
	 Cast.setFocusable(false);
	 Cast.setText("Cast Ability");
	 
	 Controller.setLayout(new BorderLayout());
	 Controller.setBorder(BorderFactory.createLineBorder(Color.RED));
	 Controller.add(UP,BorderLayout.NORTH);
	 Controller.add(DOWN,BorderLayout.SOUTH);
	 Controller.add(LEFT,BorderLayout.WEST);
	 Controller.add(RIGHT,BorderLayout.EAST);
	 Controller.add(Cast,BorderLayout.CENTER);
	 
	 
	 JPanel Panel3=new JPanel();
	 Attack=new JButton();
	 Attack.setBorder(BorderFactory.createLineBorder(Color.RED));
	 Attack.setBackground(Color.black);
	 Attack.setForeground(Color.white);
	 Move=new JButton();
	 Move.setBorder(BorderFactory.createLineBorder(Color.RED));
	 Move.setBackground(Color.black);
	 Move.setForeground(Color.white);
	 JPanel ShowTeams=new JPanel();
	 ShowTeams.setBorder(BorderFactory.createLineBorder(Color.black));
	 ShowTeams.setFocusable(false);
	 ShowTeams.setLayout(new GridLayout(0,1));
	 FirstTeam=new JButton();
	 FirstTeam.setBorder(BorderFactory.createLineBorder(Color.RED));
	 FirstTeam.setBackground(Color.black);
	 FirstTeam.setForeground(Color.white);
	 FirstTeam.setText("show"+secondWindow.getFirst().getName());
	 FirstTeam.addActionListener(this);
	 FirstTeam.setFocusable(false);
	 SecondTeam=new JButton();
	 SecondTeam.setBorder(BorderFactory.createLineBorder(Color.RED));
	 SecondTeam.setBackground(Color.black);
	 SecondTeam.setForeground(Color.white);
	 SecondTeam.setText("show"+secondWindow.getSecond().getName());
	 SecondTeam.addActionListener(this);
	 SecondTeam.setFocusable(false); 
	 
	 ShowTeams.add(FirstTeam);
	 ShowTeams.add(SecondTeam);
	 
	 
	 Attack.setText("Attack");
	 Move.setText("Move");	 
	 Attack.setFocusable(false);
	 Attack.addActionListener(this);
	 Move.setFocusable(false);
	 Move.addActionListener(this);
	 Move.setBorder(BorderFactory.createLineBorder(Color.black));
	 Attack.setBorder(BorderFactory.createLineBorder(Color.black));
	 Move.setPreferredSize(new Dimension(60,60));
	 Panel3.setPreferredSize(new Dimension(50,100));
	 Panel3.setLayout(new GridLayout(0,4));
	 Panel3.setBorder(BorderFactory.createLineBorder(Color.RED));
	 Panel3.setBackground(Color.black);
	 Panel3.setForeground(Color.white); 
	 Panel3.add(Attack);
	 Panel3.add(Move);
	 Panel3.add(ShowTeams);
	 Panel3.add(Controller);
	 Show.setLayout(new BorderLayout());
	 Show.setBorder(BorderFactory.createLineBorder(Color.RED));
	 Show.setBackground(Color.black);
	 Show.setForeground(Color.white); 
	 JPanel SmallInfo= new JPanel();
	 SmallInfo.setLayout(new BorderLayout());
	 SmallInfo.setBackground(Color.black);
	 PlayerName = new JTextField();
	 PlayerName.setBorder(BorderFactory.createLineBorder(Color.RED));
	 PlayerName.setBackground(Color.black);
	 PlayerName.setForeground(Color.white);
	 PlayerName.setPreferredSize(new Dimension(50,50));
	 PlayerName.setEditable(false);
	 PlayerName.setFocusable(false);
	 PlayerName.setText("Now Turn :"+game.getCurrentChampion().getName());
	// PlayerName.setBorder(BorderFactory.createLineBorder(Color.black));
	 EndTurn=new JButton();
	 useLeaderAbility = new JButton();
	 EndTurn.setPreferredSize(new Dimension(40,30));
	 EndTurn.setFocusable(false);
	 EndTurn.addActionListener(this);
	 EndTurn.setText("EndTurn");
	 EndTurn.setBorder(BorderFactory.createLineBorder(Color.RED));
	 EndTurn.setBackground(Color.black);
	 EndTurn.setForeground(Color.white);
	 useLeaderAbility = new JButton();
	 useLeaderAbility.setBorder(BorderFactory.createLineBorder(Color.RED));
	 useLeaderAbility.setBackground(Color.black);
	 useLeaderAbility.setForeground(Color.white);
     useLeaderAbility.setPreferredSize(new Dimension(40,30));
     useLeaderAbility.setFocusable(false);
     useLeaderAbility.setText("useLeaderAbility");
   //  useLeaderAbility.setBackground(Color.CYAN);
   //  useLeaderAbility.setBorder(BorderFactory.createLineBorder(Color.black));
    // useLeaderAbility.setForeground(Color.black);
     useLeaderAbility.addActionListener(this);
     JPanel Button= new JPanel();
     Button.setPreferredSize(new Dimension(100,100));
     Button.setLayout(new GridLayout(0,1));
     Button.setBackground(Color.black);
     Button.add(useLeaderAbility);
     Button.add(EndTurn);
     
 	 ChampionInfo=new JLabel();
 	ChampionInfo.setBorder(BorderFactory.createLineBorder(Color.RED));
 	ChampionInfo.setBackground(Color.black);
 	ChampionInfo.setForeground(Color.white); 	 
 	ChampionInfo.setPreferredSize(new Dimension(200,350));
 	// ChampionInfo.setForeground(Color.white);
 	 ChampionInfo.setFocusable(false);
 	 updateCurrentInfo();
 	 
 	 JPanel Abilities = new JPanel();
 	 
 	 
 	 Ability1=new JButton();
 	Ability1.setBorder(BorderFactory.createLineBorder(Color.RED));
 	Ability1.setBackground(Color.black);
 	Ability1.setForeground(Color.white); 
 	 Ability1.setFocusable(false);
 	 Ability1.setText(game.getCurrentChampion().getAbilities().get(0).getName());
 	 Ability1.addActionListener(this);
	 Ability2=new JButton();
	 Ability2.setBorder(BorderFactory.createLineBorder(Color.RED));
	 Ability2.setBackground(Color.black);
	 Ability2.setForeground(Color.white); 
	 Ability2.setFocusable(false);
	 Ability2.setText(game.getCurrentChampion().getAbilities().get(1).getName());	 
	 Ability2.addActionListener(this);
	 Ability3=new JButton();
	 Ability3.setBorder(BorderFactory.createLineBorder(Color.RED));
	 Ability3.setBackground(Color.black);
	 Ability3.setForeground(Color.white); 
	 Ability3.setFocusable(false);
	 Ability3.setText(game.getCurrentChampion().getAbilities().get(2).getName());
	 Ability3.addActionListener(this);
 	 Abilities.setPreferredSize(new Dimension(100,140));
 	 Abilities.setBackground(Color.BLACK);
 	 Abilities.setLayout(new GridLayout(0,1));
 	 Abilities.add(Ability1);
	 Abilities.add(Ability2);
	 Abilities.add(Ability3);
 	 
 	 JPanel info = new JPanel();
 	info.setBorder(BorderFactory.createLineBorder(Color.RED));
 	info.setBackground(Color.black);
 	info.setForeground(Color.white); 
 	 info.setBackground(Color.black);
 	 info.setLayout(new BorderLayout()); 	 
 	 info.add(ChampionInfo,BorderLayout.NORTH);
 	 info.add(Abilities,BorderLayout.SOUTH);
 	 info.add(Disarm,BorderLayout.CENTER);
    
     JPanel Top=new JPanel();
     Top.setPreferredSize(new Dimension(200,600));
     Top.setBackground(Color.BLACK);
	 Top.add(info);
     
    
        
     SmallInfo.add(Top,BorderLayout.CENTER);
     SmallInfo.add(Button,BorderLayout.SOUTH);
    
     
	 Show.add(PlayerName,BorderLayout.NORTH);
	 Show.add(SmallInfo,BorderLayout.CENTER);
	 
	 B1=setBoard1();
	 B1.setBorder(BorderFactory.createLineBorder(Color.RED));
	 B1.setBackground(Color.black);
	 B1.setForeground(Color.white); 
     frame.add(B1,BorderLayout.CENTER);
     frame.add(Show,BorderLayout.EAST);
     frame.add(Panel3,BorderLayout.SOUTH);
}
public Player getWinner() {
	Player Winner=fourthWindow.getGame().checkGameOver();
	return Winner;
}
public void updateCurrentInfo(){
	String S="";
	Champion C=game.getCurrentChampion();
	S="<html>"+"Name:"+C.getName()+" \n"+"<br />"+"AttackDamage:"+C.getAttackDamage()+"\n"+"<br />"+"Attack Range:"+C.getAttackRange()+"\n"+"<br />"+"HP:"+C.getCurrentHP()
	+"\n"+"<br />"+"Mana:"+C.getMana()+"\n"+"<br />"+"Speed:"+C.getSpeed()+"\n"+"<br />"+"Actions:"+C.getCurrentActionPoints();
	
	for(Effect e : C.getAppliedEffects()){
		S+="\n"+ "<br />"+"effect:"+e.getName()+"<br />"+"Duration:"
	+e.getDuration()+"</html>";
	}
	turnOrder();
	ChampionInfo.setText(S);
	ChampionInfo.setVerticalTextPosition(JLabel.TOP);
	ChampionInfo.setVerticalAlignment(JLabel.TOP);
}
public void updateInfoAbility(int index){
	String S1="";
    ArrayList<model.abilities.Ability> a=game.getCurrentChampion().getAbilities();
    for(int i=0 ;i<a.size();i++){
    	if(i==index){
    		model.abilities.Ability a1=a.get(index);
    		if(a1 instanceof DamagingAbility){
    			DamagingAbility D= (DamagingAbility)a1;
    			S1="<html>"+"AbilityName:"+a1.getName()+"\n"+"Type:"+"DamagingAbility"
    		+"   "+"AreaOfEffect:"+a1.getCastArea()+"\n"+"Range:"+a1.getCastRange()
    		+"  "+"Mana:"+a1.getManaCost()+"\n"+"ActionCost:"+a1.getRequiredActionPoints()
    		+"  "+"BaseCurrentCool:"+a1.getBaseCooldown()+"\n"+
    		"CurrentCool:"+a1.getCurrentCooldown()+"     "+"Damage:"+D.getDamageAmount();
    		
    		}
    		if(a1 instanceof CrowdControlAbility) {
    			CrowdControlAbility D= (CrowdControlAbility)a1;
    			S1="<html>"+"AbilityName:"+a1.getName()+"\n"+"Type:"+"CC"
    		+"     "+"AreaOfEffect:"+a1.getCastArea()+"\n"+"Range:"+a1.getCastRange()
    		+"  "+"Mana:"+a1.getManaCost()+"\n"+"ActionCost:"+a1.getRequiredActionPoints()
    		+"  "+"BaseCurrentCool:"+a1.getBaseCooldown()+"\n"+
    		"CurrentCool:"+a1.getCurrentCooldown()+"   "+"Effect:"+D.getEffect().getType() 
    		+"\n"+"EffectDuration:"+D.getEffect().getDuration();
    			
    		}
    		if(a1 instanceof HealingAbility) {
    			HealingAbility D= (HealingAbility)a1;
    			S1="<html>"+"AbilityName:"+a1.getName()+"\n"+"Type:"+"HealingAbility"
    		+"     "+"AreaOfEffect:"+a1.getCastArea()+"\n"+"Range:"+a1.getCastRange()
    		+"  "+"Mana:"+a1.getManaCost()+"\n"+"ActionCost:"+a1.getRequiredActionPoints()
    		+"  "+"BaseCurrentCool:"+a1.getBaseCooldown()+"\n"+
    		"CurrentCool:"+a1.getCurrentCooldown()+"       "+"Heal:"+D.getHealAmount();
    		}
    	}
    }
   JOptionPane.showMessageDialog(null,S1,"Ability",JOptionPane.PLAIN_MESSAGE);
	
}
public void turnOrder(){
	TurnOrder =new JPanel();
	frame.remove(TurnOrder);
    TurnOrder.setLayout(new GridLayout(0,1));
    TurnOrder.setPreferredSize(new Dimension(50,600));
    TurnOrder.setBackground(Color.black);
    TurnOrder.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	PriorityQueue PQ =game.getTurnOrder();
	PriorityQueue Temp=new PriorityQueue(game.getTurnOrder().size());
	while(!PQ.isEmpty()){
		Champion C=(Champion) PQ.remove();
		JButton J =new JButton();
		if(secondWindow.getFirst().getTeam().contains(C)){
			J.setBackground(Color.BLACK);
			J.setBorder(BorderFactory.createLineBorder(Color.GREEN));
			J.setText(C.getName());
			J.setToolTipText(C.getName());
			J.setForeground(Color.GREEN);
			J.setFocusable(false);
		}
		if(secondWindow.getSecond().getTeam().contains(C)){
			J.setBackground(Color.black);
			J.setBorder(BorderFactory.createLineBorder(Color.BLUE));
			J.setText(C.getName());
			J.setToolTipText(C.getName());
			J.setFocusable(false);
			J.setForeground(Color.BLUE);
		}
		//frame.add(TurnOrder);
		Temp.insert(C);
		TurnOrder.add(J);
	 //   frame.add(TurnOrder,BorderLayout.WEST);
	}
	while(!Temp.isEmpty()){
		PQ.insert(Temp.remove());
	}
    frame.add(TurnOrder,BorderLayout.WEST);
	frame.revalidate();
	frame.repaint();
}
public void ShowTeam(Player P){
	String S1="";
	for(Champion C : P.getTeam()){
		String S="";
		if(C instanceof Hero){
		  S="Type:"+"Hero"+"\n";
		}
		if(C instanceof Villain){
			  S="Type:"+"Villain"+"\n";
			}
		if(C instanceof AntiHero){
			  S="Type:"+"AntiHero"+"\n";
			}
		
		S+="<html>"+"Name:"+C.getName()+" \n"+"AttackDamage:"+C.getAttackDamage()+
				"\n"+"Attack Range:"+C.getAttackRange()+"\n"+"HP:"+C.getCurrentHP()
		+"\n"+"Mana:"+C.getMana()+"\n"+"Speed:"+C.getSpeed()+"\n"+"MaxActions:"+
				C.getMaxActionPointsPerTurn();
		String f="";
		for(int j=0;j<C.getAppliedEffects().size();j++){
			f+="\n"+"effect:"+C.getAppliedEffects().get(j).getName()+"  "+"Duration:"
		+ C.getAppliedEffects().get(j).getDuration()+"\n";
		}
	  S1+=f;
	  if(C==P.getLeader()){S=S+"\n"+"TeamLeader";}
	  S1+=S+"\n"+"------------------"+"\n";
	}
	
	JOptionPane.showMessageDialog(null,S1,"Team",JOptionPane.PLAIN_MESSAGE);
}
public JLabel getChampionInfo() {
	return ChampionInfo;
}
public boolean Disarmed(Champion C){
	for(Effect e: C.getAppliedEffects()) {
		if(e.getName()=="Disarm"){
			return true;
			}}
	return false;
}
public boolean Rooted(Champion C) {
	for(Effect e: C.getAppliedEffects()) {
		if(e.getName()=="Root") {
			return true;}}
	return false;
	
}



public JPanel setBoard1(){
    board=game.getBoard();
	JPanel Board=new JPanel();
    Board.setPreferredSize(new Dimension(600,600));
    Board.setLayout(new GridLayout(0,5));
	for(int i=0; i <game.getBoardwidth();i++){
   	 for(int j=0;j<game.getBoardheight();j++){
   		 if(board[i][j]==null){
   			Buttons[i][j]=new JButton();
   			Buttons[i][j].addActionListener(this);
   			Buttons[i][j].setPreferredSize(new Dimension(30,30));
   			Buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.RED));
   			Buttons[i][j].setBackground(Color.BLACK);
   			Buttons[i][j].setFocusable(false);
   			Buttons[i][j].addActionListener(this);
   			 Board.add(Buttons[i][j]);}
   		 if(board[i][j]!=null){
   			 Object o=board[i][j];
   			 if(o instanceof Cover){
   				 Cover r=(Cover)o;
   				Buttons[i][j]=new JButton();
       			Buttons[i][j].addActionListener(this);
       			Buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.RED));
       			Buttons[i][j].setBackground(Color.LIGHT_GRAY);
       			Buttons[i][j].setText("Cover"+"\n"+"HP:"+r.getCurrentHP());
       			Buttons[i][j].setForeground(Color.RED);
       			Buttons[i][j].setHorizontalAlignment(JLabel.CENTER);
       			Buttons[i][j].setHorizontalTextPosition(JLabel.CENTER);
       			Buttons[i][j].setVerticalTextPosition(JLabel.BOTTOM);
       			Buttons[i][j].setFocusable(false);
       			Buttons[i][j].addActionListener(this);
       			 Board.add(Buttons[i][j]);}
   			 if(o instanceof Champion){
   				 Champion c=(Champion)o;
   				Buttons[i][j]=new JButton();
   				for (int x = 0 ; x<secondWindow.getFirst().getTeam().size();x++) {
   					if (c.getName().equals(secondWindow.getFirst().getTeam().get(x).getName())) {
   					  Buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.GREEN));
   					Buttons[i][j].setForeground(Color.GREEN);
   					}
   				}
   				for (int x = 0 ; x<secondWindow.getSecond().getTeam().size();x++) {
   					if (c.getName().equals(secondWindow.getSecond().getTeam().get(x).getName())) {
   					  Buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.BLUE));
   					  Buttons[i][j].setForeground(Color.BLUE);

   					}
   				}
       			Buttons[i][j].addActionListener(this);
       			Buttons[i][j].setPreferredSize(new Dimension(30,30));
       			//Buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
       			Buttons[i][j].setBackground(Color.BLACK);
       			Buttons[i][j].setText(c.getName()+"\n"+"HP:"+c.getCurrentHP());
       			Buttons[i][j].setHorizontalAlignment(JLabel.CENTER);
       			Buttons[i][j].setHorizontalTextPosition(JLabel.CENTER);
       			Buttons[i][j].setVerticalTextPosition(JLabel.BOTTOM);
       			Buttons[i][j].setFocusable(false);
       			Buttons[i][j].addActionListener(this);
   				 Board.add(Buttons[i][j]);}}}}
	return Board;	
}

public boolean getS() {
	if(S1==true) {
		return S1;
	}
	if(S2==true){
		return S2;
	}
	return S3;
}
public boolean getD() {
	if(D1==true) {
		return D1;
	}
	if(D2==true){
		return D2;
	}
	return D3;
}
public static Game getGame() {
	return game;	
}
public void actionPerformed(ActionEvent e) {
	JButton b= (JButton) e.getSource();
	ArrayList<model.abilities.Ability> a=game.getCurrentChampion().getAbilities();
	if(Disarmed(game.getCurrentChampion())==true){
		//Disarm.setVisible(true);
	}
	else{
		//Disarm.setVisible(false);
	}
	if(b==Disarm){
	if(isCastClick){	
		JOptionPane.showMessageDialog(null,"ChooseTarget","SingleTaregetAbility",JOptionPane.PLAIN_MESSAGE);
        Disarm.setEnabled(false);
        Disarm1=true; 
        }
	}
	if(b==Ability1){
		if(isCastClick){
			if(game.getCurrentChampion().getAbilities().get(0).getCastArea()==AreaOfEffect.SINGLETARGET){
				Ability1.setEnabled(false);
				JOptionPane.showMessageDialog(null,"ChooseTarget","SingleTaregetAbility",JOptionPane.PLAIN_MESSAGE);
			    S1=true;
			}
			
			if(game.getCurrentChampion().getAbilities().get(0).getCastArea()==AreaOfEffect.DIRECTIONAL) {
				D1=true;
				Ability1.setEnabled(false);
				JOptionPane.showMessageDialog(null,"ChooseDirectionToCastOn","DirectionalTaregetAbility",JOptionPane.PLAIN_MESSAGE);
			}
			else if(a.get(0).getCastArea()==AreaOfEffect.SELFTARGET||a.get(0).getCastArea()==AreaOfEffect.TEAMTARGET||a.get(0).getCastArea()==AreaOfEffect.SURROUND){
				Cast.setEnabled(true);
				Ability.cast(game.getCurrentChampion().getAbilities().get(0));
				updateCurrentInfo();
				isCastClick=false;
				frame.remove(B1);
				B1=setBoard1();
				frame.add(B1);
				frame.revalidate();
				frame.repaint();
			}
		}
		else{
			updateInfoAbility(0);
		}
	}
	if(b==Ability2){
		if(isCastClick){
			if(game.getCurrentChampion().getAbilities().get(1).getCastArea()==AreaOfEffect.SINGLETARGET){
				Ability2.setEnabled(false);
				JOptionPane.showMessageDialog(null,"ChooseTarget","SingleTaregetAbility",JOptionPane.PLAIN_MESSAGE);
			S2=true;
			}
			
			if(game.getCurrentChampion().getAbilities().get(1).getCastArea()==AreaOfEffect.DIRECTIONAL) {
				D2=true;
				Ability2.setEnabled(false);
				JOptionPane.showMessageDialog(null,"ChooseDirectionToCastOn","DirectionalTaregetAbility",JOptionPane.PLAIN_MESSAGE);
			}
			else if(a.get(1).getCastArea()==AreaOfEffect.SELFTARGET||a.get(1).getCastArea()==AreaOfEffect.TEAMTARGET||a.get(1).getCastArea()==AreaOfEffect.SURROUND){	
				Cast.setEnabled(true);
				Ability.cast(game.getCurrentChampion().getAbilities().get(1));
				updateCurrentInfo();
				isCastClick=false;
				frame.remove(B1);
				B1=setBoard1();
				frame.add(B1);
				frame.revalidate();
				frame.repaint();}
			
		}
		else{
			updateInfoAbility(1);
		}
	}
	if(b==Ability3){
		if(isCastClick){
			if(game.getCurrentChampion().getAbilities().get(2).getCastArea()==AreaOfEffect.SINGLETARGET){
				S3=true;
				Ability3.setEnabled(false);
				JOptionPane.showMessageDialog(null,"ChooseTarget","SingleTaregetAbility",JOptionPane.PLAIN_MESSAGE);
			}
			
			if(game.getCurrentChampion().getAbilities().get(2).getCastArea()==AreaOfEffect.DIRECTIONAL) {
				D3=true;
				Ability3.setEnabled(false);
				JOptionPane.showMessageDialog(null,"ChooseDirectionToCastOn","DirectionalTaregetAbility",JOptionPane.PLAIN_MESSAGE);
			}
			else if(a.get(2).getCastArea()==AreaOfEffect.SELFTARGET||a.get(2).getCastArea()==AreaOfEffect.TEAMTARGET||a.get(2).getCastArea()==AreaOfEffect.SURROUND){	Cast.setEnabled(true);
				Ability.cast(game.getCurrentChampion().getAbilities().get(2));
				updateCurrentInfo();
				isCastClick=false;
				frame.remove(B1);
				B1=setBoard1();
				frame.add(B1);
				frame.revalidate();
				frame.repaint();  }
			
		}
		else{
			updateInfoAbility(2);
		}
	}
	if(b==FirstTeam){
		ShowTeam(secondWindow.getFirst());
	}
	if(b==SecondTeam){
		ShowTeam(secondWindow.getSecond());
	}
	if(b==Move&&isCastClick==false&&isAttackClick==false){
		isMoveClick=true;
		Move.setEnabled(false);
		//JOptionPane.showMessageDialog(null,"Chose Direction","Move",JOptionPane.PLAIN_MESSAGE);
	}
	if(b==Attack &&isCastClick==false && isMoveClick==false){
		isAttackClick=true;
		Attack.setEnabled(false);
		//JOptionPane.showMessageDialog(null,"Chose Direction","Attack",JOptionPane.PLAIN_MESSAGE);
	}
	if(b==Cast&&isMoveClick==false&&isAttackClick==false){
		isCastClick=true;
		Cast.setEnabled(false);
		JOptionPane.showMessageDialog(null,"Choose Ability","Cast",JOptionPane.PLAIN_MESSAGE);
	}
	if(b==DOWN){
		if(isMoveClick&&isAttackClick==false&&isCastClick==false){
			Move.setEnabled(true);
			MovePerform.move(Direction.UP);
			isMoveClick=false;
			updateCurrentInfo();
			frame.remove(B1);
			B1=setBoard1();
			frame.add(B1);
			frame.revalidate();
			frame.repaint();
		}
		if(isMoveClick==false&&isAttackClick&&isCastClick==false){
			Attack.setEnabled(true);
			AttackPerformed.attack(Direction.UP);
			 updateCurrentInfo();
			isAttackClick=false;
			frame.remove(B1);
			B1=setBoard1();
			frame.add(B1);
			frame.revalidate();
			frame.repaint();
		}
		
	}
	if(b==UP) {
		if(isMoveClick&&isAttackClick==false&&isCastClick==false){
			Move.setEnabled(true);
			MovePerform.move(Direction.DOWN);
			 updateCurrentInfo();
			frame.remove(B1);
			B1=setBoard1();
			frame.add(B1);
			isMoveClick=false;
			frame.revalidate();
			frame.repaint();
		}
		if(isMoveClick==false&&isAttackClick&&isCastClick==false){
			Attack.setEnabled(true);
			AttackPerformed.attack(Direction.DOWN);
			isAttackClick=false;
			 updateCurrentInfo();
			frame.remove(B1);
			B1=setBoard1();
			frame.add(B1);
			frame.revalidate();
			frame.repaint();
		}
		
	}
	if(b==LEFT){
		if(isMoveClick&&isAttackClick==false&&isCastClick==false){
			Move.setEnabled(true);
			MovePerform.move(Direction.LEFT);
			 updateCurrentInfo();
			frame.remove(B1);
			B1=setBoard1();
			frame.add(B1);
			isMoveClick=false;
			frame.revalidate();
			frame.repaint();
		}
		if(isMoveClick==false&&isAttackClick&&isCastClick==false){
			Attack.setEnabled(true);
			AttackPerformed.attack(Direction.LEFT);
			 updateCurrentInfo();
			isAttackClick=false;
			frame.remove(B1);
			B1=setBoard1();
			frame.add(B1);
			frame.revalidate();
			frame.repaint();
		}
          
	}
	if(b==RIGHT){
		if(isMoveClick&&isAttackClick==false&&isCastClick==false){
			Move.setEnabled(true);
			MovePerform.move(Direction.RIGHT);
			updateCurrentInfo();
			frame.remove(B1);
			B1=setBoard1();
			frame.add(B1);
			isMoveClick=false;
			frame.revalidate();
			frame.repaint();
		}
		if(isMoveClick==false&&isAttackClick&&isCastClick==false){
			Attack.setEnabled(true);
			AttackPerformed.attack(Direction.RIGHT);
			updateCurrentInfo();
			isAttackClick=false;
			frame.remove(B1);
			B1=setBoard1();
			frame.add(B1);
			frame.revalidate();
			frame.repaint();
		}
          
	}
	if(isCastClick==true&&Disarm1==true) {
		for(int i=0; i <game.getBoardwidth();i++){
		   	 for(int j=0;j<game.getBoardheight();j++){
		   		JButton J =(JButton)Buttons[i][j];
		   		 if(b==J){
		   		    Ability.cast(game.getCurrentChampion().getAbilities().get(3),i,j);
		   			Disarm1=false;
		   			isCastClick=false;
		   			Cast.setEnabled(true);
		   			Disarm.setEnabled(true);
					frame.remove(B1);
					B1=setBoard1();
					frame.add(B1);
					frame.revalidate();
					frame.repaint();}
		   		 }
		   	 }
	}
	if(isCastClick==true&&getS()==true){
		if(S3==true){
			for(int i=0; i <game.getBoardwidth();i++){
			   	 for(int j=0;j<game.getBoardheight();j++){
			   		JButton J =(JButton)Buttons[i][j];
			   		 if(b==J){
			   		    Ability.cast(game.getCurrentChampion().getAbilities().get(2),i,j);
			   			S3=false;
			   			isCastClick=false;
			   			Ability3.setEnabled(true);
			   			Cast.setEnabled(true);
						frame.remove(B1);
						B1=setBoard1();
						frame.add(B1);
						frame.revalidate();
						frame.repaint();    }
			   		 }
			   	 }
		}
	if(S2==true){
		for(int i=0; i <game.getBoardwidth();i++){
		   	 for(int j=0;j<game.getBoardheight();j++){
		   		 JButton J =(JButton)Buttons[i][j];
		   		 if(b==J){
		   			Ability.cast(game.getCurrentChampion().getAbilities().get(1),i,j);
		   			S2=false;
		   			Ability2.setEnabled(true);
		   			Cast.setEnabled(true);
		   			isCastClick=false;
					frame.remove(B1);
					B1=setBoard1();
					frame.add(B1);
					frame.revalidate();
					frame.repaint();
		   			
		   		 
		   		 }}}
	}
	if(S1==true){ 
		for(int i=0; i <game.getBoardwidth();i++){
		   	 for(int j=0;j<game.getBoardheight();j++){
		   		JButton J =(JButton)Buttons[i][j];
		   		 if(b==J){
		   			Ability.cast(game.getCurrentChampion().getAbilities().get(0),i,j);
		   			S1=false;
		   			Ability1.setEnabled(true);
		   			Cast.setEnabled(true);
		   			isCastClick=false;
					frame.remove(B1);
					B1=setBoard1();
					frame.add(B1);
					frame.revalidate();
					frame.repaint();
		   		 }}}}
	updateCurrentInfo();
	}
	if(isCastClick==true&&getD()==true){
		if(D1==true){	
			if(b==UP){
				Ability.cast(game.getCurrentChampion().getAbilities().get(0),Direction.DOWN);
	   			D1=false;
	   			Ability1.setEnabled(true);
	   			Cast.setEnabled(true);
	   			isCastClick=false;
				frame.remove(B1);
				B1=setBoard1();
				frame.add(B1);
				frame.revalidate();
				frame.repaint();}
			if(b==DOWN){
				Ability.cast(game.getCurrentChampion().getAbilities().get(0),Direction.UP);
	   			D1=false;
	   			Ability1.setEnabled(true);
	   			Cast.setEnabled(true);
	   			isCastClick=false;
				frame.remove(B1);
				B1=setBoard1();
				frame.add(B1);
				frame.revalidate();
				frame.repaint();}
			if(b==LEFT){
				Ability.cast(game.getCurrentChampion().getAbilities().get(0),Direction.LEFT);
	   			D1=false;
	   			Ability1.setEnabled(true);
	   			Cast.setEnabled(true);
	   			isCastClick=false;
				frame.remove(B1);
				B1=setBoard1();
				frame.add(B1);
				frame.revalidate();
				frame.repaint();}
			if(b==RIGHT){
				Ability.cast(game.getCurrentChampion().getAbilities().get(0),Direction.RIGHT);
	   			D1=false;
	   			Ability1.setEnabled(true);
	   			Cast.setEnabled(true);
	   			isCastClick=false;
				frame.remove(B1);
				B1=setBoard1();
				frame.add(B1);
				frame.revalidate();
				frame.repaint();}}
		if(D2==true){
			if(b==UP){
				Ability.cast(game.getCurrentChampion().getAbilities().get(1),Direction.DOWN);
	   			D2=false;
	   			Ability2.setEnabled(true);
	   			Cast.setEnabled(true);
	   			isCastClick=false;
				frame.remove(B1);
				B1=setBoard1();
				frame.add(B1);
				frame.revalidate();
				frame.repaint();}
			if(b==DOWN){
				Ability.cast(game.getCurrentChampion().getAbilities().get(1),Direction.UP);
	   			D2=false;
	   			Ability2.setEnabled(true);
	   			Cast.setEnabled(true);
	   			isCastClick=false;
				frame.remove(B1);
				B1=setBoard1();
				frame.add(B1);
				frame.revalidate();
				frame.repaint();}
		   if(b==LEFT){
				Ability.cast(game.getCurrentChampion().getAbilities().get(1),Direction.LEFT);
	   			D2=false;
	   			Ability2.setEnabled(true);
	   			Cast.setEnabled(true);
	   			isCastClick=false;
				frame.remove(B1);
				B1=setBoard1();
				frame.add(B1);
				frame.revalidate();
				frame.repaint();}
			if(b==RIGHT){
				Ability.cast(game.getCurrentChampion().getAbilities().get(1),Direction.RIGHT);
	   			D2=false;
	   			Ability2.setEnabled(true);
	   			Cast.setEnabled(true);
	   			isCastClick=false;
				frame.remove(B1);
				B1=setBoard1();
				frame.add(B1);
				frame.revalidate();
				frame.repaint();}}
		if(D3==true){
			if(b==UP){
				Ability.cast(game.getCurrentChampion().getAbilities().get(2),Direction.DOWN);
	   			D3=false;
	   			Ability3.setEnabled(true);
	   			Cast.setEnabled(true);
	   			isCastClick=false;
				frame.remove(B1);
				B1=setBoard1();
				frame.add(B1);
				frame.revalidate();
				frame.repaint();}
			if(b==DOWN){
				Ability.cast(game.getCurrentChampion().getAbilities().get(2),Direction.UP);
	   			D3=false;
	   			Ability3.setEnabled(true);
	   			Cast.setEnabled(true);
	   			isCastClick=false;
				frame.remove(B1);
				B1=setBoard1();
				frame.add(B1);
				frame.revalidate();
				frame.repaint();}
			if(b==LEFT){
				Ability.cast(game.getCurrentChampion().getAbilities().get(2),Direction.LEFT);
	   			D3=false;
	   			Ability3.setEnabled(true);
	   			Cast.setEnabled(true);
	   			isCastClick=false;
				frame.remove(B1);
				B1=setBoard1();
				frame.add(B1);
				frame.revalidate();
				frame.repaint();}
			if(b==RIGHT){
				Ability.cast(game.getCurrentChampion().getAbilities().get(2),Direction.RIGHT);
	   			D3=false;
	   			Ability3.setEnabled(true);
	   			Cast.setEnabled(true);
	   			isCastClick=false;
				frame.remove(B1);
				B1=setBoard1();
				frame.add(B1);
				frame.revalidate();
				frame.repaint();}}
		updateCurrentInfo();
		}
	if(b==EndTurn){
		game.endTurn();
		updateCurrentInfo();
		turnOrder();
		Ability1.setText(game.getCurrentChampion().getAbilities().get(0).getName());
		Ability2.setText(game.getCurrentChampion().getAbilities().get(1).getName());
		Ability3.setText(game.getCurrentChampion().getAbilities().get(2).getName());
		PlayerName.setText("Now Turn :"+game.getCurrentChampion().getName());
	}
	if(secondWindow.getFirst().getTeam().size()==0){
		EndWindow E=new EndWindow();
		frame.dispose();
	}
   if(secondWindow.getSecond().getTeam().size()==0){
	   EndWindow E=new EndWindow();
	   frame.dispose();
	}
   if(b==useLeaderAbility){
	   Ability.leader1();
	   frame.remove(B1);
	   B1=setBoard1();
	   frame.add(B1);
	   updateCurrentInfo();
	   frame.revalidate();
	   frame.repaint();
   }
}
}
