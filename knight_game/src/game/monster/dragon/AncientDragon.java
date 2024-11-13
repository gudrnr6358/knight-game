package game.monster.dragon;

import javax.swing.ImageIcon;

public class AncientDragon extends Dragon {
	public AncientDragon() {
		super("고대 용", 60, 30);
	}

	//
	@Override
	public int skill() {
		System.out.println(NAME + "이 드래곤 브레스를 사용했습니다!");
		return (int) (POWER * 1.5 + (Math.random() * 3 + 1));
	}
	
	@Override
	public ImageIcon getImage() {
		return null;
	}

	@Override
	public String getSkillName() {
		return "드래곤 브레스를";
	}
	
}