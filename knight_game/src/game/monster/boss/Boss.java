package game.monster.boss;

import javax.swing.ImageIcon;

import game.monster.Monster;

public class Boss extends Monster {

	public Boss() {
		super("마왕", 150, 80);
	}

	@Override
	public ImageIcon getUnitImage() {
		return new ImageIcon("images/monster/boss.png");
	}

	@Override
	public int skill() {
		return (int) (power * 1.5 + (Math.random() * 3 + 1));
	}

	@Override
	public String getSkillName() {
		return "아주 짱짱쎈 공격";
	}

	@Override
	public Integer getEXP() {
		return 150;
	}

}
