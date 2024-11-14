package game.monster.boss;

import javax.swing.ImageIcon;

import game.monster.Monster;

public class Boss extends Monster {

	public Boss() {
		super("보스몹", 150, 80);
	}

	@Override
	public ImageIcon getImage() {
		return new ImageIcon("images/boss.png");
	}

	@Override
	public int skill() {
		return (int) (POWER * 1.5 + (Math.random() * 3 + 1));
	}

	@Override
	public String getSkillName() {
		return "아주 짱짱쎈 공격";
	}

}
