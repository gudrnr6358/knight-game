package game.monster.slime.dark;

import javax.swing.ImageIcon;

import game.monster.slime.Slime;

public class DarkCombatSlime extends Slime {

	public DarkCombatSlime() {
		super("어둠의 전투병 슬라임", 100, 45);
	}

	@Override
	public ImageIcon getUnitImage() {
		return new ImageIcon("images/monster/slimes/dark/combatslime.png");
	}

	@Override
	public String getSkillName() {
		return "베기";
	}

	@Override
	public Integer getEXP() {
		return 30;
	}
}
