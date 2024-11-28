package game.ingame.bottom;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import game.InGame;

public class BattlePanel extends BottomBox {
	public static InGame inGame;

	// 크기, 위치 설정 및 버튼 부착
	public BattlePanel() {
		add(new AttackButton());
		add(new SkillButton());
		add(new CharSkillButton());
	}

	private class AttackButton extends BattlePanelButton {

		private AttackButton() {
			super("공격");
			setLocation(105, 100);
		}
	}

	private class SkillButton extends BattlePanelButton {

		private SkillButton() {
			super("캐릭터 스킬");
			setLocation(505, 100);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setFont(new Font("NanumGothic", Font.BOLD, 20));
			g.setColor(Color.RED);
			g.drawString(inGame.character.getCurrentSkillCount() + "/" + inGame.character.getFixedSkillCount(),
					getWidth() / 2 - 10, getHeight() - 25);
		}

	}

	private class CharSkillButton extends BattlePanelButton {

		private CharSkillButton() {
			super("두번 베기");
			setLocation(905, 100);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setFont(new Font("NanumGothic", Font.BOLD, 20));
			g.setColor(Color.RED);
			g.drawString(inGame.character.getCurrentCharSkillCount() + "/" + inGame.character.getFixedCharSkillCount(),
					getWidth() / 2 - 10, getHeight() - 25);
		}

	}

}
