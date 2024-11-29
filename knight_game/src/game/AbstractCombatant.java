package game;

public abstract class AbstractCombatant implements Combatant {

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

}
