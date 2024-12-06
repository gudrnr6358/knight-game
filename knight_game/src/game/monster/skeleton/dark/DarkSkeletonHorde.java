package game.monster.skeleton.dark;

import javax.swing.ImageIcon;

import game.monster.skeleton.Skeleton;

public class DarkSkeletonHorde extends Skeleton {

	public DarkSkeletonHorde() {
		super("어둠의 스켈레톤 무리", 200, 90);
	}

	@Override
	public ImageIcon getUnitImage() {
		return new ImageIcon("images/monster/skeletons/dark/skeletonhorde.png");
	}

	@Override
	public String getSkillName() {
		return "집단공격";
	}

	@Override
	public Integer getEXP() {
		return 62;
	}
}
