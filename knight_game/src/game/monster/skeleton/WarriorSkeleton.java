package game.monster.skeleton;

import javax.swing.ImageIcon;

public class WarriorSkeleton extends Skeleton{

	public WarriorSkeleton() {
		super("전사 스켈레톤", 70, 40);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int skill() {
		return (int) (POWER * 1.5 + (Math.random() * 3 + 1));
	}

	@Override
	public ImageIcon getImage() {
		return new ImageIcon("images/skeleton.png");
	}

	@Override
	public String getSkillName() {
		return "쌍검 휘두르기를";
	}
}
