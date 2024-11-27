package game.stage;

import game.monster.dragon.BabyDragon;
import game.monster.dragon.CowardDragon;
import game.monster.dragon.AncientDragon;
import game.monster.Monster;

public class Stage2 {
	private Monster[] monsters;

	public Stage2() {
		monsters = new Monster[] { new BabyDragon(), new CowardDragon(), new AncientDragon() };
	}

	public Monster[] getMonsters() {
		return monsters;
	}
}
