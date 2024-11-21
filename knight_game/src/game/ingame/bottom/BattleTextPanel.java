package game.ingame.bottom;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import game.Combatant;

// 전투 상황 텍스트를 출력하는 패널
// 오직 Text 출력을 위한 패널
public class BattleTextPanel extends BottomBox {

	public BattleTextPanel(Combatant attackUnit, Combatant attackedUnit) {
		super();
		attackText(attackUnit, attackedUnit);
	}

	public void attackText(Combatant attackUnit, Combatant attackedUnit) {
		String word = "공격!";
		if (attackUnit.useSkill) {
			word = "스킬!";
		}
		TextLabel.textLabel
				.setTextLabel(attackUnit.name + "의 " + word + " " + attackedUnit.name + " -" + attackUnit.attackValue);
	}

	private class BattleTextPanelListener extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mousePressed(e);
		}

	}

}
