package game.ingame.bottom;

import game.Combatant;

// 전투 상황 텍스트를 출력하는 패널
// 오직 Text 출력을 위한 패널
public class BattleTextPanel extends BottomBox {

	public BattleTextPanel(Combatant a, Combatant b) {
		super();
		attackText(a, b);
	}

	public void attackText(Combatant a, Combatant b) {
		String word = "공격!";
		if (a.useSkill) {
			word = "스킬!";
		}
		TextLabel.textLabel.setTextLabel(a.name + "의 " + word + " " + b.name + " -" + a.attackValue);
	}

}
