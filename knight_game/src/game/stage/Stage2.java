package game.stage;

import game.monster.Monster;
import game.monster.dragon.AncientDragon;
import game.monster.dragon.BabyDragon;
import game.monster.dragon.CowardDragon;

public class Stage2 extends Stage {
	private Monster[] monsters;

	public Stage2() {
		monsters = new Monster[] { new BabyDragon(), new CowardDragon(), new AncientDragon() };
	}

}
