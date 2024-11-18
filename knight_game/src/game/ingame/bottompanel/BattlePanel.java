package game.ingame.bottompanel;

public class BattlePanel extends BottomBox {

	// 크기, 위치 설정 및 버튼 부착
	public BattlePanel() {
		setLayout(null);
		setBounds(3, 3, 1314, 329);
		add(new AttackButton());
		add(new SkillButton());
		add(new CharSkillButton());
	}

	private class AttackButton extends BattlePanelButton {

		private AttackButton() {
			super("공격");
			setLocation(100, 100);
		}
	}

	private class SkillButton extends BattlePanelButton {

		private SkillButton() {
			super("캐릭터 스킬");
			setLocation(500, 100);
		}
	}

	private class CharSkillButton extends BattlePanelButton {

		private CharSkillButton() {
			super("CharSkillButton");
			setLocation(900, 100);
		}
	}

}
