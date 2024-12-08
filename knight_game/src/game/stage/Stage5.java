package game.stage;

import game.monster.Monster;
import game.monster.dragon.dark.DarkAncientDragon;
import game.monster.skeleton.dark.DarkSkeletonHorde;
import game.monster.slime.dark.DarkBossSlime;

public class Stage5 extends Stage {

	public Stage5() {
		monsters = new Monster[] { new DarkBossSlime(), new DarkAncientDragon(), new DarkSkeletonHorde() };
	}

}
