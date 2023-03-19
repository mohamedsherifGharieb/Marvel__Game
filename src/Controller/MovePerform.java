package Controller;

import javax.swing.JOptionPane;

import Graphics.fourthWindow;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import model.world.Direction;

public class MovePerform {

public static void move(Direction D){
		try {
			fourthWindow.getGame().move(D);
		} catch (UnallowedMovementException e) {
			JOptionPane.showMessageDialog(null,"UnAllowedMovement","Move",JOptionPane.PLAIN_MESSAGE);
		} catch (NotEnoughResourcesException e) {
			JOptionPane.showMessageDialog(null,"NotEnoughResourcesException","Move",JOptionPane.PLAIN_MESSAGE);
		}
	}
}
