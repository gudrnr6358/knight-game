package game;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class Character extends AbstractCombatant implements ImageUnit, Serializable {
	public static boolean hadCharacter = false;
	// 각 레벨별 요구 경험치
	private Integer[] EXP = { 20, 50, 80, 120, 150, 175, 200, 250, 300 };
	// 레벨업시에 추가되는 능력치
	private Integer[] LEVEL_UP_PLUS_HP = { 5, 5, 5, 10, 10, 15, 25, 25, 50 };
	private Integer[] LEVEL_UP_PLUS_POWER = { 5, 5, 5, 10, 10, 15, 25, 25, 50 };
	private Integer exp;
	private Integer level;

	// 고정 스킬 사용 횟수
	private final Integer FIXED_CRTICAL_ATTACK_COUNT = 2;
	private final Integer FIXED_DOUBLE_ATTACK_COUNT = 1;
	private final Integer FIXED_HEAVENTLY_STRIKE_COUNT = 1;
	// 가변 스킬 사용 횟수
	private Integer currentCriticalAttackCount = FIXED_CRTICAL_ATTACK_COUNT;
	private Integer currentDoubleAttackCount = FIXED_DOUBLE_ATTACK_COUNT;
	private Integer currentHeaventlyStrikeCount = FIXED_HEAVENTLY_STRIKE_COUNT;

	// 이름만 받아서 객체 생성, 이름 설정 Writer Reader 이용해도 괜찮을 듯
	public Character() {
		super("???", 100, 10);
		this.level = 1;
		this.exp = 0;
	}

	@Override
	public Integer attack() {
		useSkill = false;
		attackValue = power + (int) (Math.random() * 3 + 1);
		return attackValue;
	}

	@Override
	public Integer skill() {
		useSkill = true;
		attackValue = (int) ((power * 1.2) + (Math.random() * 3 + 1));
		return attackValue;
	}

	public Integer doubleAttack() {
		useSkill = true;
		attackValue = (int) ((power * 1.5) + (Math.random() * 3 + 1));
		return attackValue;
	}

	public Integer heavenlyStrike() {
		useSkill = true;
		attackValue = (int) ((power * 1.7) + (Math.random() * 3 + 1));
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
		// 최대 레벨이 아니면서 경험치가 충족될 때 반복 실행
		while (level <= EXP.length && exp >= EXP[level - 1]) {
			exp -= EXP[level - 1];
			System.out.println("레벨업 전 레벨 : " + level);
			levelup();
		}
		// 최대 레벨일 경우 exp = 0 세팅
		if (level > EXP.length) {
			exp = 0;
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
		if (level > EXP.length) {
			return 0;
		}
		return EXP[level - 1];
	}

	public Integer getExp() {
		if (level > EXP.length) {
			return 0;
		}
		return exp;
	}

	public Integer getLevel() {
		return level;
	}

	public Boolean canUseCriticalAttack() {
		if (currentCriticalAttackCount > 0) {
			currentCriticalAttackCount--;
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	public Boolean canUseDoubleAttack() {
		if (currentDoubleAttackCount > 0) {
			currentDoubleAttackCount--;
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	public Boolean canUseHeavenlyStrike() {
		if (currentHeaventlyStrikeCount > 0) {
			currentHeaventlyStrikeCount--;
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	// 스킬 횟수 세팅
	public void setSkillCount() {
		currentHeaventlyStrikeCount = FIXED_HEAVENTLY_STRIKE_COUNT;
		currentDoubleAttackCount = FIXED_DOUBLE_ATTACK_COUNT;
		currentCriticalAttackCount = FIXED_CRTICAL_ATTACK_COUNT;
	}

	public Integer getFIXED_CRTICAL_ATTACK_COUNT() {
		return FIXED_CRTICAL_ATTACK_COUNT;
	}

	public Integer getFIXED_DOUBLE_ATTACK_COUNT() {
		return FIXED_DOUBLE_ATTACK_COUNT;
	}

	public Integer getFIXED_HEAVENTLY_STRIKE_COUNT() {
		return FIXED_HEAVENTLY_STRIKE_COUNT;
	}

	public Integer getCurrentCriticalCount() {
		return currentCriticalAttackCount;
	}

	public Integer getCurrentDoubleAttackCount() {
		return currentDoubleAttackCount;
	}

	public Integer getCurrentHeaventlyStrikeCount() {
		return currentHeaventlyStrikeCount;
	}

	public void dead() {
		nowHp = 30;
		exp = 0;
	}

	public Integer getEXPArrayLength() {
		return EXP.length;
	}

}
