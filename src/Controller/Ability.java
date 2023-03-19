package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Graphics.fourthWindow;
import exceptions.AbilityUseException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import model.abilities.AreaOfEffect;
import model.world.Champion;
import model.world.Direction;

public class Ability implements ActionListener{
public static void cast(model.abilities.Ability ability){
	Champion C=fourthWindow.getGame().getCurrentChampion();	

	if(ability.getCastArea()==AreaOfEffect.SURROUND||ability.getCastArea()==AreaOfEffect.SELFTARGET||ability.getCastArea()==AreaOfEffect.TEAMTARGET) {
		try {
			fourthWindow.getGame().castAbility(ability);
		} catch (AbilityUseException e){
			JOptionPane.showMessageDialog(null,"Cant Use Ability ","Cast",JOptionPane.PLAIN_MESSAGE);
		} catch (NotEnoughResourcesException e) {
			JOptionPane.showMessageDialog(null,"NotEnoughResources","Cast",JOptionPane.PLAIN_MESSAGE);
			
		} catch (CloneNotSupportedException e) {
			JOptionPane.showMessageDialog(null,"Cant Use Ability in Duration","Cast",JOptionPane.PLAIN_MESSAGE);
			
		}
	}
}





public static void cast(model.abilities.Ability ability, int i, int j) {
	try {
		fourthWindow.getGame().castAbility(ability,i,j);
	} catch (AbilityUseException e) {
		JOptionPane.showMessageDialog(null,"Cant Use Ability ","Cast",JOptionPane.PLAIN_MESSAGE);
	} catch (NotEnoughResourcesException e) {
		
		JOptionPane.showMessageDialog(null,"NotEnoughResources","Cast",JOptionPane.PLAIN_MESSAGE);
	} catch (InvalidTargetException e) {
		
		JOptionPane.showMessageDialog(null,"InvalidTargetException","Cast",JOptionPane.PLAIN_MESSAGE);
	} catch (CloneNotSupportedException e) {
		
		JOptionPane.showMessageDialog(null,"Cant Use Ability in Duration","Cast",JOptionPane.PLAIN_MESSAGE);
	}
	
}







public static void cast(model.abilities.Ability ability, Direction D) {
	
	try {
		fourthWindow.getGame().castAbility(ability,D);
	} catch (AbilityUseException e) {	
	JOptionPane.showMessageDialog(null,"Cant Use Ability ","Cast",JOptionPane.PLAIN_MESSAGE);
	} catch (NotEnoughResourcesException e) {
	JOptionPane.showMessageDialog(null,"NotEnoughResources","Cast",JOptionPane.PLAIN_MESSAGE);
	} catch (CloneNotSupportedException e) {
		JOptionPane.showMessageDialog(null,"Cant Use Ability in Duration ","Cast",JOptionPane.PLAIN_MESSAGE);
	}
}





@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}

public static void leader1() {
	try {
		fourthWindow.getGame().useLeaderAbility();
	} catch (LeaderNotCurrentException e){
		JOptionPane.showMessageDialog(null,"LeaderNotCurrent","Cast",JOptionPane.PLAIN_MESSAGE);
		
	} catch (LeaderAbilityAlreadyUsedException e){
		JOptionPane.showMessageDialog(null,"AbilityAlreayUsed","Cast",JOptionPane.PLAIN_MESSAGE);
	}
	
}

}


