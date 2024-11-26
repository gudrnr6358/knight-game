package game.monster.dragon;

import javax.swing.ImageIcon;

public class AncientDragon extends Dragon {
	public AncientDragon() {
		super("고대 용", 60, 30);
	}

	//
	@Override
	public int skill() {
		return (int) (power * 1.5 + (Math.random() * 3 + 1));
	}

	@Override
	public ImageIcon getUnitImage() {
		return new ImageIcon("images/monster/ancientdragon.png");
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