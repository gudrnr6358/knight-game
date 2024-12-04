package game.monster.boss;

import javax.swing.ImageIcon;

import game.monster.Monster;

public class Boss extends Monster {

	public Boss() {
		super("마왕", 1500, 75);
	}

	@Override
	public ImageIcon getUnitImage() {
		return new ImageIcon("images/monster/boss.png");
	}

	@Override
	public String getSkillName() {
		return "아주 짱짱쎈 공격";
	}

	// 보스는 특별히 2배 데미지
	@Override
	public Integer skill() {
		return (int) (power * 2 + (Math.random() * 3 + 1));
	}

	@Override
	public Integer getEXP() {
		return 300;
	}

}
