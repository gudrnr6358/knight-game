package game.monster.skeleton.dark;

import javax.swing.ImageIcon;

import game.monster.skeleton.Skeleton;

public class DarkArcherSkeleton extends Skeleton {

	public DarkArcherSkeleton() {
		super("어둠의 궁수 스켈레톤", 150, 90);
	}

	@Override
	public ImageIcon getUnitImage() {
		return new ImageIcon("images/monster/skeletons/dark/archerskeleton.png");
	}

	@Override
	public String getSkillName() {
		return "불화살 쏘기";
	}

	@Override
	public Integer getEXP() {
		return 42;
	}
}
