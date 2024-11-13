package game.monster.dragon;

import javax.swing.ImageIcon;

public class BabyDragon extends Dragon {

	public BabyDragon() {
		super("아기 용", 30, 15);
	}

	//
	@Override
	public int skill() {
		return (int) (POWER * 1.5 + (Math.random() * 3 + 1));
	}

	@Override
	public ImageIcon getImage() {
		return null;
	}

	@Override
	public String getSkillName() {
		return "할퀴기를";
	}
	
}