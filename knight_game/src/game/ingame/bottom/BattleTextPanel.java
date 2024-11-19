package game.ingame.bottom;

import game.Combatant;

// 전투 상황 텍스트를 출력하는 패널
// 오직 Text 출력을 위한 패널
public class BattleTextPanel extends BottomBox {

	private BattleTextPanel(Combatant a, Combatant b) {
		super();
		attackText(a, b);
	}

//	// 내부에서 setTextLabel 호출
//	// 조금 더 명확한 메서드를 만들어주고 싶었음
//	public void setBattleText(String text) {
//		super.textLabel.setTextLabel(text);
//	}

	public void attackText(Combatant a, Combatant b) {
		String word = "공격!";
		if (a.useSkill) {
			word = "스킬!";
		}
		super.textLabel.setTextLabel(a.name + "의 " + word + " " + b.name + " -" + a.attackValue);
	}

}
