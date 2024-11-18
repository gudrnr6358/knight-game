package game;

public abstract class Combatant {
	public abstract int attack();

	public abstract int skill();

	public abstract boolean isAlive();

	public String name;
	public Integer hp;
	public Integer nowHp;
	public Integer power;
	public Boolean useSkill = false;
	public Integer attackValue;

	protected Combatant(String name, Integer hp, Integer power) {
		super();
		this.name = name;
		this.hp = hp;
		this.nowHp = hp;
		this.power = power;
	}

	// Character 생성자를 위한 기본 생성자
	protected Combatant() {

	}

}
