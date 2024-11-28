package game.monster.dragon;

import javax.swing.ImageIcon;

public class AncientDragon extends Dragon {
	public AncientDragon() {
		super("고대 용", 60, 35);
	}

	@Override
	public ImageIcon getUnitImage() {
		return new ImageIcon("images/monster/dragons/ancientdragon.png");
	}

	@Override
	public String getSkillName() {
		return "드래곤 브레스";
	}

	@Override
	public Integer getEXP() {
		return 20;
	}
}