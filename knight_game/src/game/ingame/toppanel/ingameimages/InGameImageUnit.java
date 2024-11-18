package game.ingame.toppanel.ingameimages;

import javax.swing.JLabel;

import game.ImageUnit;

public abstract class InGameImageUnit extends JLabel {

	protected InGameImageUnit(ImageUnit i) {
		super(i.getImage());
		setSize(300, 300);
	}

}