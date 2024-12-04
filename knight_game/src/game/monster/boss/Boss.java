package game.monster.boss;

import javax.swing.ImageIcon;

import game.monster.Monster;

public class Boss extends Monster {

	public Boss() {
		super("마왕", 500, 100);
	}

	@Override
	public ImageIcon getUnitImage() {
		return new ImageIcon("images/monster/boss.png");
	}

	@Override
	public String getSkillName() {
		return "아주 짱짱쎈 공격";
	}

	@Override
	public Integer getEXP() {
		return 300;
	}

}
