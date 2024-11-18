package game.monster;

import game.Combatant;
import game.ImageUnit;

public abstract class Monster extends Combatant implements ImageUnit {

	protected Monster(String name, int hp, int power) {
		super(name,hp,power);
	}

	@Override
	public int attack() {
		useSkill = false;
		int random = (int) ((Math.random() * 10) + 1);

		// 몬스터 스킬 발동 확률 30%
		if (random < 4) {
			useSkill = true;
			attackValue = skill();
			return attackValue;
		}
		attackValue = (int) (power + (Math.random() * 5 + 1));
		return attackValue;
	}

	@Override
	public boolean isAlive() {
		if (nowHp > 0) {
			return true;
		} else {
			return false;
		}
	}

	public abstract String getSkillName();

}
