package game.monster.skeleton.dark;

import javax.swing.ImageIcon;

import game.monster.skeleton.Skeleton;

public class DarkArcherSkeleton extends Skeleton {

	public DarkArcherSkeleton() {
		super("어둠의 궁수 스켈레톤", 60, 70);
		// TODO Auto-generated constructor stub
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
		return 25;
	}
}
