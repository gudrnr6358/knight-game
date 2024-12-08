package game.stage;

import game.monster.Monster;
import game.monster.dragon.dark.DarkCowardDragon;
import game.monster.skeleton.dark.DarkArcherSkeleton;
import game.monster.slime.dark.DarkCombatSlime;

public class Stage4 extends Stage {

	public Stage4() {
		monsters = new Monster[] { new DarkCombatSlime(), new DarkCowardDragon(), new DarkArcherSkeleton() };
	}

}
