package game.monster.slime;

import javax.swing.ImageIcon;

public class CombatSlime extends Slime {

	public CombatSlime() {
		super("전투병 슬라임", 25, 15);
	}

	// 베기
	@Override
	public int skill() {
		return (int) (power * 1.5 + (Math.random() * 3 + 1));
	}

	@Override
	public ImageIcon getUnitImage() {
		return new ImageIcon("images/monster/slime.png");
	}

	@Override
	public String getSkillName() {
		return "베기";
	}

	@Override
	public Integer getEXP() {
		return 7;
	}
}
