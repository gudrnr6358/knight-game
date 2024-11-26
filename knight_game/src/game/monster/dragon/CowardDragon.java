package game.monster.dragon;

import javax.swing.ImageIcon;

public class CowardDragon extends Dragon {

	public CowardDragon() {
		super("겁쟁이 용", 20, 35);
	}

	//
	@Override
	public int skill() {
		return (int) (power * 1.5 + (Math.random() * 3 + 1));
	}

	@Override
	public ImageIcon getUnitImage() {
		return  new ImageIcon("images/monster/dragons/cowarddragon.png");
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