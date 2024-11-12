package game.monster;

import game.Combatant;
import game.ImageUnit;

public abstract class Monster implements Combatant, ImageUnit {
	public final String NAME;
	public final Integer HP;
	public Integer nowHp;
	public final Integer POWER;
	public Boolean useSkill;

	protected Monster(String nAME, int hP, int pOWER) {
		NAME = nAME;
		HP = hP;
		POWER = pOWER;
		nowHp = hP;
	}

	@Override
	public int attack() {
		int num = (int) ((Math.random() * 10) + 1);
		
		// 몬스터 스킬 발동 확률 30%
		if (num < 4) {
			return skill();
		}
		
		System.out.println(NAME + "의 공격!");
		return (int) (POWER + (Math.random() * 5 + 1));
	}

	@Override
	public boolean isAlive() {
		if (nowHp > 0) {
			return true;
		} else {
			return false;
		}
	}

}
