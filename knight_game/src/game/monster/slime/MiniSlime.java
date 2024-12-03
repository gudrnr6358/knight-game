package game.monster.slime;

import javax.swing.ImageIcon;

public class MiniSlime extends Slime {

	public MiniSlime() {
		super("미니 슬라임", 15, 12);
	}

	@Override
	public ImageIcon getUnitImage() {
		return new ImageIcon("images/monster/slimes/minislime.png");
	}

	@Override
	public String getSkillName() {
		return "조약돌 던지기";
	}

	@Override
	public Integer getEXP() {
		return 4;
	}
}
