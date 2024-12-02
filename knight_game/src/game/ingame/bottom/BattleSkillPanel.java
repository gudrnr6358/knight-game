package game.ingame.bottom;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class BattleSkillPanel extends BottomBox {

	public BattleSkillPanel() {
		add(new CriticalAttack());
		add(new DoubleAttack());
		add(new HeavenlyStrike());
	}

	private class CriticalAttack extends SkillPanelButton {

		private CriticalAttack() {
			super("크리티컬 어택");
			setLocation(130, 100);
		}

		// 스킬 횟수 그리기
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setFont(new Font("NanumGothic", Font.BOLD, 20));
			g.setColor(Color.RED);
			g.drawString(
					INGAME.character.getCurrentCriticalCount() + "/" + INGAME.character.getFIXED_CRTICAL_ATTACK_COUNT(),
					getWidth() / 2 - 10, getHeight() - 25);
		}

	}

	private class DoubleAttack extends SkillPanelButton {

		private DoubleAttack() {
			super("더블 어택");
			setLocation(535, 100);
		}

		// 스킬 횟수 그리기
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setFont(new Font("NanumGothic", Font.BOLD, 20));
			g.setColor(Color.RED);
			g.drawString(INGAME.character.getCurrentDoubleAttackCount() + "/"
					+ INGAME.character.getFIXED_DOUBLE_ATTACK_COUNT(), getWidth() / 2 - 10, getHeight() - 25);
		}

	}

	private class HeavenlyStrike extends SkillPanelButton {

		private HeavenlyStrike() {
			super("천상의 일격");
			setLocation(935, 100);
		}

		// 스킬 횟수 그리기
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setFont(new Font("NanumGothic", Font.BOLD, 20));
			g.setColor(Color.RED);
			g.drawString(
					INGAME.character.getCurrentHeaventlyStrikeCount() + "/"
							+ INGAME.character.getFIXED_HEAVENTLY_STRIKE_COUNT(),
					getWidth() / 2 - 10, getHeight() - 25);
		}

	}

}
