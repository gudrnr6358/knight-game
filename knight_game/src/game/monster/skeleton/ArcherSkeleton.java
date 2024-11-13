package game.monster.skeleton;

import javax.swing.ImageIcon;

public class ArcherSkeleton extends Skeleton{

	public ArcherSkeleton() {
		super("궁수 스켈레톤", 40, 50);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int skill() {
		System.out.println(NAME + "이 불화살을 쐈습니다!");
		return (int) (POWER * 1.5 + (Math.random() * 3 + 1));
	}

	@Override
	public ImageIcon getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSkillName() {
		return "불화살 쏘기를";
	}
	
}
