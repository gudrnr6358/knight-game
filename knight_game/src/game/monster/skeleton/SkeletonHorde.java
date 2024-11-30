package game.monster.skeleton;

import javax.swing.ImageIcon;

public class SkeletonHorde extends Skeleton {

	public SkeletonHorde() {
		super("스켈레톤 무리", 30, 30);
	}

	@Override
	public ImageIcon getUnitImage() {
		return new ImageIcon("images/monster/skeletons/skeletonhorde.png");
	}

	@Override
	public String getSkillName() {
		return "집단공격";
	}

	@Override
	public Integer getEXP() {
		return 13;
	}
}
