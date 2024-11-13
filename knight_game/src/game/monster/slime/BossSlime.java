package game.monster.slime;

import javax.swing.ImageIcon;

public class BossSlime extends Slime {

	public BossSlime() {
		super("슬라임 대장", 35, 20);
	}

	// 슬라임 총공격
	@Override
	public int skill() {
		return (int) (POWER * 1.5 + (Math.random() * 3 + 1));
	}

	@Override
	public ImageIcon getImage() {
		return null;
	}

	@Override
	public String getSkillName() {
		return "슬라임 총공격";
	}
}