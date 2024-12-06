package game.monster.dragon;

import javax.swing.ImageIcon;

public class BabyDragon extends Dragon {

	public BabyDragon() {
		super("아기 용", 40, 17);
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