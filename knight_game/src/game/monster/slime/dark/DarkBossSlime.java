package game.monster.slime.dark;

import javax.swing.ImageIcon;

import game.monster.slime.Slime;

public class DarkBossSlime extends Slime {

	public DarkBossSlime() {
		super("어둠의 슬라임 대장", 150, 45);
	}

	@Override
	public ImageIcon getUnitImage() {
		return new ImageIcon("images/monster/slimes/dark/bossslime.png");
	}

	@Override
	public String getSkillName() {
		return "슬라임 총공격";
	}

	@Override
	public Integer getEXP() {
		return 40;
	}
}