package game.ingame.top.ingameimages;

import javax.swing.JLabel;

import game.ImageUnit;

public abstract class InGameImageUnit extends JLabel {

	protected InGameImageUnit(ImageUnit i) {
		super(i.getUnitImage());
		setSize(300, 300);
	}

}