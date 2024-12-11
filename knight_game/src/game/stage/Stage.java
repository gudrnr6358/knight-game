package game.stage;

import game.monster.Monster;

public abstract class Stage {
	protected Monster[] monsters;

	public Monster[] getMonsters() {
		return monsters;
	}
}
