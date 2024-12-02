package game.ingame.bottom;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class BattlePanel extends BottomBox {

	// 크기, 위치 설정 및 버튼 부착
	public BattlePanel() {
		add(new AttackButton());
		add(new SkillButton());
	}

	private class AttackButton extends BattlePanelButton {

		private AttackButton() {
			super("공격");
			setLocation(105, 100);
		}
	}

	private class SkillButton extends BattlePanelButton {

		private SkillButton() {
			super("스킬");
			setLocation(505, 100);
		}

	}

}
