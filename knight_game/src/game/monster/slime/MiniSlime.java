package game.monster.slime;

import javax.swing.ImageIcon;

public class MiniSlime extends Slime {

	public MiniSlime() {
		super("작은 슬라임", 20, 12);
	}

	// 조약돌 던지기
	@Override
	public int skill() {
		System.out.println(NAME + "이 조약돌을 던졌습니다!");
		return (int) (POWER * 1.5 + (Math.random() * 3 + 1));
	}

	@Override
	public ImageIcon getImage() {
		return null;
	}
}
