package Controller;

import javax.swing.JOptionPane;

import Graphics.fourthWindow;
import Graphics.secondWindow;
import engine.Player;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughResourcesException;
import model.world.Direction;

public class AttackPerformed {

	public static void attack(Direction D) {
		
		try {
			fourthWindow.getGame().attack(D);
		} catch (ChampionDisarmedException e) {
			JOptionPane.showMessageDialog(null,"Champion Cannot Attack","Attack",JOptionPane.PLAIN_MESSAGE);
		} catch (NotEnoughResourcesException e) {
			JOptionPane.showMessageDialog(null,"NotEnoughResourcesException","Attack",JOptionPane.PLAIN_MESSAGE);
		} catch (InvalidTargetException e) {
			JOptionPane.showMessageDialog(null,"InvalidTargetException","Attack",JOptionPane.PLAIN_MESSAGE);
		}
		
	}

}
