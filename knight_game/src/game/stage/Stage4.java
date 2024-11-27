package game.stage;

import game.monster.slime.CombatSlime;
import game.monster.dragon.CowardDragon;
import game.monster.skeleton.ArcherSkeleton;
import game.monster.Monster;

public class Stage4 {
	private Monster[] monsters;

	public Stage4() {
		monsters = new Monster[] { new CombatSlime(), new CowardDragon(), new ArcherSkeleton() };
	}

	public Monster[] getMonsters() {
		return monsters;
	}

}
