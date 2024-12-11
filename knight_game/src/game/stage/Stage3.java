package game.stage;

import game.monster.Monster;
import game.monster.skeleton.ArcherSkeleton;
import game.monster.skeleton.SkeletonHorde;
import game.monster.skeleton.WarriorSkeleton;

public class Stage3 extends Stage {

	public Stage3() {
		monsters = new Monster[] { new WarriorSkeleton(), new ArcherSkeleton(), new SkeletonHorde() };
	}

}
