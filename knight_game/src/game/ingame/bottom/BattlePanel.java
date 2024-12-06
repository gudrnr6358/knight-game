package game.ingame.bottom;

import javax.swing.ImageIcon;

public class BattlePanel extends BottomBox {

	public static final ImageIcon ATTACK_BUTTON_IMAGE = new ImageIcon("images/ingame/button/battlepanel/attack.jpg");
	public static final ImageIcon SKILL_BUTTON_IMAGE = new ImageIcon("images/ingame/button/battlepanel/skill.jpg");

	// 크기, 위치 설정 및 버튼 부착
	public BattlePanel() {
		add(new AttackButton());
		add(new SkillButton());
	}

	private class AttackButton extends BattlePanelButton {

		private AttackButton() {
			super(ATTACK_BUTTON_IMAGE);
			setLocation(285, 90);
		}
	}

	private class SkillButton extends BattlePanelButton {

		private SkillButton() {
			super(SKILL_BUTTON_IMAGE);
			setLocation(785, 90);
		}

	}

}
