package game.ingame.bottom;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BattleSkillPanel extends BottomBox {
	private final Integer BUTTON_COUNT_TEXT_X = 140;
	private final Integer BUTTON_COUNT_TEXT_Y = 90;

	public static final ImageIcon CRITICAL_ATTACK_BUTTON_IMAGE = new ImageIcon(
			"images/ingame/button/skillpanel/critical_attack.png");
	public static final ImageIcon DOUBLE_ATTACK_BUTTON_IMAGE = new ImageIcon(
			"images/ingame/button/skillpanel/double_attack.png");
	public static final ImageIcon HEAVENLY_STRIKE_BUTTON_IMAGE = new ImageIcon(
			"images/ingame/button/skillpanel/heavenly_strike.png");

	private final Integer BUTTON_WIDTH = 230;
	private final Integer BUTTON_HEIGHT = 136;

	public BattleSkillPanel() {
		add(new CriticalAttack());
		add(new DoubleAttack());
		add(new HeavenlyStrike());
		add(new NextPageInfoLabel());
	}

	private class NextPageInfoLabel extends JLabel {

		private static String str = "패널 클릭시 이전 페이지로 돌아갑니다";

		private NextPageInfoLabel() {
			super(str);
			setForeground(new Color(128, 128, 128));
			setFont(new Font("SansSerif", Font.BOLD, 22));
			setBounds(920, 70, 430, 470);
		}

	}

	private class CriticalAttack extends SkillPanelButton {

		private CriticalAttack() {
			super(CRITICAL_ATTACK_BUTTON_IMAGE);
			setLocation(140, 90);
		}

		// 스킬 횟수 그리기
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setFont(new Font("NanumGothic", Font.BOLD, 20));
			g.setColor(Color.RED);
			g.drawString(
					inGame.character.getCurrentCriticalCount() + "/" + inGame.character.getFIXED_CRTICAL_ATTACK_COUNT(),
					BUTTON_COUNT_TEXT_X, BUTTON_COUNT_TEXT_Y);
		}

	}

	private class DoubleAttack extends SkillPanelButton {

		private DoubleAttack() {
			super(DOUBLE_ATTACK_BUTTON_IMAGE);
			setLocation(540, 90);
		}

		// 스킬 횟수 그리기
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setFont(new Font("NanumGothic", Font.BOLD, 20));
			g.setColor(Color.RED);
			g.drawString(
					inGame.character.getCurrentDoubleAttackCount() + "/"
							+ inGame.character.getFIXED_DOUBLE_ATTACK_COUNT(),
					BUTTON_COUNT_TEXT_X, BUTTON_COUNT_TEXT_Y);
		}

	}

	private class HeavenlyStrike extends SkillPanelButton {

		private HeavenlyStrike() {
			super(HEAVENLY_STRIKE_BUTTON_IMAGE);
			setLocation(940, 90);
		}

		// 스킬 횟수 그리기
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setFont(new Font("NanumGothic", Font.BOLD, 20));
			g.setColor(Color.RED);
			g.drawString(
					inGame.character.getCurrentHeaventlyStrikeCount() + "/"
							+ inGame.character.getFIXED_HEAVENTLY_STRIKE_COUNT(),
					BUTTON_COUNT_TEXT_X, BUTTON_COUNT_TEXT_Y);
		}

	}

}
