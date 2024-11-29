package game.monster.dragon;

import javax.swing.ImageIcon;

public class BabyDragon extends Dragon {

	public BabyDragon() {
		super("아기 용", 30, 17);
	}

	//
	@Override
	public int skill() {
		return (int) (power * 1.5 + (Math.random() * 3 + 1));
	}

	@Override
	public ImageIcon getUnitImage() {
		return  new ImageIcon("images/monster/dragons/babydragon.png");
	}

	@Override
	public String getSkillName() {
		return "할퀴기";
	}

	@Override
	public Integer getEXP() {
		return 12;
	}
}