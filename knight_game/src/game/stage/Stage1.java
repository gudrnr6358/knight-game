package game.stage;

import game.monster.Monster;
import game.monster.slime.BossSlime;
import game.monster.slime.CombatSlime;
import game.monster.slime.MiniSlime;

public class Stage1 extends Stage {

	public Stage1() {
		monsters = new Monster[] { new MiniSlime(), new CombatSlime(), new BossSlime() };
	}

}