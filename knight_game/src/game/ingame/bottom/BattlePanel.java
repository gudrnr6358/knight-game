package game.ingame.bottom;

import javax.swing.ImageIcon;

public class BattlePanel extends BottomBox {

	public static final ImageIcon attackImage = new ImageIcon("images/ingame_attack_image.jpg");
	public static final ImageIcon skillImage = new ImageIcon("images/ingame_skill_image.jpg");

	// 크기, 위치 설정 및 버튼 부착
	public BattlePanel() {
		add(new AttackButton());
		add(new SkillButton());
	}

	private class AttackButton extends BattlePanelButton {

		private AttackButton() {
			super(attackImage);
			setLocation(285, 90);
		}
	}

	private class SkillButton extends BattlePanelButton {

		private SkillButton() {
			super(skillImage);
			setLocation(785, 90);
		}

	}

}
