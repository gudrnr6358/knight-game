package game.monster.slime;

import javax.swing.ImageIcon;

public class CombatSlime extends Slime {

	public CombatSlime() {
		super("전투병 슬라임", 25, 17);
	}

	@Override
	public ImageIcon getUnitImage() {
		return new ImageIcon("images/monster/slimes/combatslime.png");
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
