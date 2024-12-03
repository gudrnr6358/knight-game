package game.monster.skeleton;

import javax.swing.ImageIcon;

public class ArcherSkeleton extends Skeleton {

	public ArcherSkeleton() {
		super("궁수 스켈레톤", 40, 70);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ImageIcon getUnitImage() {
		return new ImageIcon("images/monster/skeletons/archerskeleton.png");
	}

	@Override
	public String getSkillName() {
		return "불화살 쏘기";
	}

	@Override
	public Integer getEXP() {
		return 15;
	}
}
