package game.monster;

import game.AbstractCombatant;
import game.ImageUnit;

public abstract class Monster extends AbstractCombatant implements ImageUnit {

	protected Monster(String name, int hp, int power) {
		super(name, hp, power);
	}

	public abstract String getSkillName();

	public abstract Integer getEXP();

	@Override
	public Integer attack() {
		useSkill = false;
		int random = (int) ((Math.random() * 10) + 1);

		// 몬스터 스킬 발동 확률 30%
		if (random < 3) {
			useSkill = true;
			attackValue = skill();
			return attackValue;
		}
		attackValue = (int) (power + (Math.random() * 5 + 1));
		return attackValue;
	}

	@Override
	public Integer skill() {
		return (int) (power * 1.5 + (Math.random() * 3 + 1));
	}

}
