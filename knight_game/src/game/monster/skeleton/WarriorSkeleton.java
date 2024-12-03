package game.monster.skeleton;

import javax.swing.ImageIcon;

public class WarriorSkeleton extends Skeleton {

	public WarriorSkeleton() {
		super("전사 스켈레톤", 70, 35);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ImageIcon getUnitImage() {
		return new ImageIcon("images/monster/skeletons/warriorskeleton.png");
	}

	@Override
	public String getSkillName() {
		return "쌍검 휘두르기";
	}

	@Override
	public Integer getEXP() {
		return 22;
	}
}
