package game;

import java.io.Serializable;

public abstract class AbstractCombatant implements Combatant, Serializable {

	protected String name;
	protected Integer hp;
	protected Integer nowHp;
	protected Integer power;
	protected Boolean useSkill = false;
	protected Integer attackValue;

	protected AbstractCombatant(String name, Integer hp, Integer power) {
		super();
		this.name = name;
		this.hp = hp;
		this.nowHp = hp;
		this.power = power;
	}

	protected AbstractCombatant() {

	}

	public String getName() {
		return name;
	}

	public Integer getHp() {
		return hp;
	}

	public Integer getNowHp() {
		return nowHp;
	}

	public Integer getPower() {
		return power;
	}

	public Boolean getUseSkill() {
		return useSkill;
	}

	public Integer getAttackValue() {
		return attackValue;
	}

	@Override
	public Boolean isAlive() {
		if (nowHp > 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

}
