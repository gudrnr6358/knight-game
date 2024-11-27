package game.stage;

import game.monster.slime.MiniSlime;
import game.monster.slime.CombatSlime;
import game.monster.slime.BossSlime;
import game.monster.Monster;

public class Stage1 {
	private Monster[] monsters;

	public Stage1() {
		monsters = new Monster[] { new MiniSlime(), new CombatSlime(), new BossSlime() };
	}

	public Monster[] getMonsters() {
		return monsters;
	}
}