package game.monster.slime;

import javax.swing.ImageIcon;

public class MiniSlime extends Slime {

	public MiniSlime() {
		super("작은 슬라임", 20, 12);
	}

	// 조약돌 던지기
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
		return "조약돌 던지기를";
	}
}
