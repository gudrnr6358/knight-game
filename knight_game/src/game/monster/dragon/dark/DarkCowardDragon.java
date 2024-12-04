package game.monster.dragon.dark;

import javax.swing.ImageIcon;

import game.monster.dragon.Dragon;

public class DarkCowardDragon extends Dragon {

	public DarkCowardDragon() {
		super("어둠의 겁쟁이 용", 50, 38);
	}

	@Override
	public ImageIcon getUnitImage() {
		return new ImageIcon("images/monster/dragons/dark/cowarddragon.png");
	}

	@Override
	public String getSkillName() {
		return "옆에 있던 용에게 도움요청하기";
	}

	@Override
	public Integer getEXP() {
		return 15;
	}
}