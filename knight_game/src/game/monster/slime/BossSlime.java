package game.monster.slime;

import javax.swing.ImageIcon;

public class BossSlime extends Slime {

	public BossSlime() {
		super("슬라임 대장", 35, 25);
	}

	@Override
	public ImageIcon getUnitImage() {
		return new ImageIcon("images/monster/slimes/bossslime.png");
	}

	@Override
	public String getSkillName() {
		return "슬라임 총공격";
	}

	@Override
	public Integer getEXP() {
		return 9;
	}
}