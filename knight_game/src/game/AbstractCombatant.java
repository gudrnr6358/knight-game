package game;

public abstract class AbstractCombatant implements Combatant {

	public String name;
	public Integer hp;
	public Integer nowHp;
	public Integer power;
	public Boolean useSkill = false;
	public Integer attackValue;

	protected AbstractCombatant(String name, Integer hp, Integer power) {
		super();
		this.name = name;
		this.hp = hp;
		this.nowHp = hp;
		this.power = power;
	}

	// Character 생성자를 위한 기본 생성자
	protected AbstractCombatant() {

	}

}
