package game.monster.dragon.dark;

import javax.swing.ImageIcon;

import game.monster.dragon.Dragon;

public class DarkAncientDragon extends Dragon {
	public DarkAncientDragon() {
		super("어둠의 고대 용", 185, 75);
	}

	@Override
	public ImageIcon getUnitImage() {
		return new ImageIcon("images/monster/dragons/dark/ancientdragon.png");
	}

	@Override
	public String getSkillName() {
		return "드래곤 브레스";
	}

	@Override
	public Integer getEXP() {
		return 51;
	}
}