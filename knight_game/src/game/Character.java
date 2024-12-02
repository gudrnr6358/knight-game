package game;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class Character extends AbstractCombatant implements ImageUnit, Serializable {
	public static boolean hadCharacter = false;
	private Integer[] EXP = { 20, 30, 35, 40, 45, 70, 80, 90, 110 };
	private Integer[] LEVEL_UP_PLUS_HP = { 5, 10, 15, 15, 15, 20, 20, 25, 30 };
	private Integer[] LEVEL_UP_PLUS_POWER = { 5, 10, 15, 15, 15, 20, 20, 25, 30 };
	private Integer exp;
	private Integer level;

	// 고정 스킬 사용 횟수
	private final Integer fixedSkillCount = 3;
	private final Integer fixedCharSkillCount = 1;
	// 가변 스킬 사용 횟수
	private Integer currentSkillCount = fixedSkillCount;
	private Integer currentCharSkillCount = fixedCharSkillCount;

	// 이름만 받아서 객체 생성, 이름 설정 Writer Reader 이용해도 괜찮을 듯
	public Character() {
		super("???", 100, 10);
		this.level = 1;
		this.exp = 0;
	}

	@Override
	public int attack() {
		useSkill = false;
		attackValue = power + (int) (Math.random() * 5 + 1);
		return attackValue;
	}

	@Override
	public int skill() {
		useSkill = true;
		attackValue = (int) ((power * 1.2) + (Math.random() * 3 + 1));
		return attackValue;
	}

	public int charSkill() {
		useSkill = true;
		attackValue = (int) ((power * 2.0) + (Math.random() * 3 + 1));
		return attackValue;
	}

	@Override
	public ImageIcon getUnitImage() {
		return new ImageIcon("images/knight.png");
	}

	public void plusEXP(Integer exp) {
		this.exp += exp;
		checkExp();
	}

	// EXP 값이 충족되면 레벨업을 진행
	// 경험치 얻는 메서드마다 실행
	private void checkExp() {
		if (level == EXP.length) {
			return;
		}
		if (exp >= EXP[level - 1]) {
			exp -= EXP[level - 1];
			levelup();
			if (exp >= EXP[level - 1]) {
				checkExp();
			}
			return;
		}
	}

	private void levelup() {
		hp += LEVEL_UP_PLUS_HP[level - 1];
		power += LEVEL_UP_PLUS_POWER[level - 1];
		nowHp = hp;
		level++;
	}

	public Integer getLevelExp() {
		return EXP[level - 1];
	}

	public Integer getExp() {
		return exp;
	}

	public Integer getLevel() {
		return level;
	}

	public Boolean canUseSkill() {
		if (currentSkillCount > 0) {
			currentSkillCount--;
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	public Boolean canUsecharSkill() {
		if (currentCharSkillCount > 0) {
			currentCharSkillCount--;
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	public void setSkillCount() {
		currentCharSkillCount = fixedCharSkillCount;
		currentSkillCount = fixedSkillCount;
	}

	public Integer getFixedCharSkillCount() {
		return fixedCharSkillCount;
	}

	public Integer getFixedSkillCount() {
		return fixedSkillCount;
	}

	public Integer getCurrentCharSkillCount() {
		return currentCharSkillCount;
	}

	public Integer getCurrentSkillCount() {
		return currentSkillCount;
	}

	public void dead() {
		nowHp = 30;
		exp = 0;
	}

}
