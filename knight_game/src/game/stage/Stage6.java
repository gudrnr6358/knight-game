package game.stage;

import game.monster.Monster;
import game.monster.boss.Boss;

public class Stage6 extends Stage {

	public Stage6() {
		monsters = new Monster[] { new Boss() };
	}

}