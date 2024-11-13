package game;

import javax.swing.ImageIcon;

public class Character implements Combatant, ImageUnit {
	public static boolean hadCharacter = false;
	public String name;
	public Integer level;
	public Integer exp;
	public Integer hp;
	public Integer nowHp;
	public Integer power;
	public Boolean useSkill;
	public Integer attackValue;
	private Integer[] EXP = { 20, 30, 35, 40, 45, 70, 80, 90, 110 };
	private Integer[] LEVEL_UP_PLUS_HP = { 10, 10, 15, 15, 15, 20, 20, 25, 30 };
	private Integer[] LEVEL_UP_PLUS_POWER = { 10, 10, 15, 15, 15, 20, 20, 25, 30 };

	// 이름만 받아서 객체 생성, 이름 설정 Writer Reader 이용해도 괜찮을 듯
	public Character() {
		this.level = 1;
		this.exp = 0;
		this.hp = 100;
		this.nowHp = 100;
		this.power = 10;
	}

	@Override
	public int attack() {
		useSkill= false;
		attackValue = 10;
		return attackValue;
	}

	@Override
	public int skill() {
		// 20은 그냥 막 넣어놓은 값임, power 관련 연산 진행하고
		// 그걸 attackValue 에 넣어서 return 하면 될 듯
		useSkill= true;
		attackValue = 20;
		return attackValue;
	}

	public int charSkill() {
		useSkill= true;
		attackValue = 20;
		return attackValue;
	}

	@Override
	public ImageIcon getImage() {
		return new ImageIcon("images/knight.png");
	}

	@Override
	public boolean isAlive() {
		if (nowHp > 0) {
			return true;
		}
		return false;
	}

}
