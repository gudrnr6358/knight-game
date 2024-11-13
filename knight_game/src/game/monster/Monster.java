package game.monster;

import game.Combatant;
import game.ImageUnit;

public abstract class Monster implements Combatant, ImageUnit {
	public final String NAME;
	public final Integer HP;
	public Integer nowHp;
	public final Integer POWER;
	public Boolean useSkill;
	public Integer attackValue;

	protected Monster(String nAME, int hP, int pOWER) {
		NAME = nAME;
		HP = hP;
		POWER = pOWER;
		nowHp = hP;
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
		attackValue = (int) (POWER + (Math.random() * 5 + 1));
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
