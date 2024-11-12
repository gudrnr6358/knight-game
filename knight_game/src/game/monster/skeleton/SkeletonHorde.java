package game.monster.skeleton;

import javax.swing.ImageIcon;

public class SkeletonHorde extends Skeleton {

	public SkeletonHorde() {
		super("스켈레톤 무리", 30, 30);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int skill() {
		System.out.println(NAME + "가 집단공격을 시전했습니다!");
		return (int) (POWER * 1.5 + (Math.random() * 3 + 1));
	}

	@Override
	public ImageIcon getImage() {
		// TODO Auto-generated method stub
		return null;
	}

}
