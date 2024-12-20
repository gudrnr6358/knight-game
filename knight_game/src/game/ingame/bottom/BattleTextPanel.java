package game.ingame.bottom;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import game.AbstractCombatant;
import game.ingame.top.ingameimages.InGameImageUnit;
import game.monster.Monster;

// 전투 상황 텍스트를 출력하는 패널
// 오직 Text 출력을 위한 패널
public class BattleTextPanel extends BottomBox {

	public BattleTextPanel(AbstractCombatant attackUnit, AbstractCombatant attackedUnit) {
		super();
		attackText(attackUnit, attackedUnit);
		JLabel nextpage = new JLabel("진행하려면 클릭하세요");
		nextpage.setForeground(new Color(128, 128, 128));
		nextpage.setFont(new Font("NanumGothic", Font.BOLD, 22));
		nextpage.setBounds(1075, 70, 250, 470);
		add(nextpage);
	}

	public void attackText(AbstractCombatant attackUnit, AbstractCombatant attackedUnit) {
		String word = "공격!";
		if (attackUnit.getUseSkill()) {
			word = "스킬!";
			if (attackUnit instanceof Monster) {
				word = ((Monster) attackUnit).getSkillName() + "!";
			}
		}
		TextLabel.textLabel.setTextLabel(
				attackUnit.getName() + "의 " + word + " " + attackedUnit.getName() + " -" + attackUnit.getAttackValue());
	}

}
