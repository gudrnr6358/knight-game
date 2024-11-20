package game.monster.slime;

import javax.swing.ImageIcon;

public class BossSlime extends Slime {

	public BossSlime() {
		super("슬라임 대장", 35, 20);
	}

	// 슬라임 총공격
	@Override
	public int skill() {
		return (int) (power * 1.5 + (Math.random() * 3 + 1));
	}

	@Override
	public ImageIcon getUnitImage() {
		return new ImageIcon("images/bossslime.png");
	}

	@Override
	public String getSkillName() {
		return "슬라임 총공격";
	}
}