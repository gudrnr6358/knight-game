/*
package game;

public class 태연캐릭터참고용 {

	// 이 안에 레벨 최대치를 막는 if 문을 넣거나,
	// 레벨 최대치의 경우 이 메서드를 호출 못하게 하는 코드를 작성해야함 (checkExp 메서드에 구현)
	public static void levelup() {
		System.out.println("레벨업!!");
		hp += LEVEL_UP_PLUS_HP[level_count];
		power += LEVEL_UP_PLUS_POWER[level_count];
		nowHp = hp; // 체력 최대로 채우기
		level++;
		level_count++;
		showExp();
	}

	// 휴식한다. 선택지를 골랐을 때 실행하면 됨
	public static void recoveryHp() {
		nowHp = hp;
	}

	// 10~15 사이의 경험치 얻기
	public static void exp10_15() {
		exp += (int) ((Math.random() * 6) + 10);
		checkExp();
	}

	// 20~25 사이의 경험치 얻기
	public static void exp20_25() {
		exp += (int) ((Math.random() * 6) + 20);
		checkExp();
	}

	// 30~35 사이의 경험치 얻기
	public static void exp30_35() {
		exp += (int) ((Math.random() * 6) + 30);
		checkExp();
	}

	public static void showExp() {
		System.out.println("현재 레벨: " + level + " (" + exp + "/" + EXP[level_count] + ")");
	}

	// EXP 값이 충족되면 레벨업을 진행
	// 경험치 얻는 메서드마다 실행
	private static void checkExp() {
		if (level == EXP.length) {
			System.out.println("최대 레벨입니다.");
			return;
		}
		if (exp >= EXP[level_count]) {
			exp -= EXP[level_count];
			levelup();
		}
	}

}
*/